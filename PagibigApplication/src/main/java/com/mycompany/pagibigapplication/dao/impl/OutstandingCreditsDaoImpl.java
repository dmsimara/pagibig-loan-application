package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.OutstandingCreditsDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.OutstandingCredits;
import com.mycompany.pagibigapplication.models.OutstandingCredits.CreditSecurity;
import com.mycompany.pagibigapplication.models.OutstandingCredits.CreditType;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OutstandingCreditsDaoImpl implements OutstandingCreditsDao {

    private static final String INSERT_SQL = "INSERT INTO outstanding_credits (creditorId, creditorName, creditorAddress, housingAccountNo, creditSecurity, creditType, maturityDate, outstandingBalance, monthlyAmortization) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE outstanding_credits SET creditorName = ?, creditorAddress = ?, housingAccountNo = ?, creditSecurity = ?, creditType = ?, maturityDate = ?, outstandingBalance = ?, monthlyAmortization = ? WHERE creditorId = ?";
    private static final String SELECT_BY_HOUSING_ACCOUNT_NO_SQL = "SELECT creditorId, creditorName, creditorAddress, housingAccountNo, creditSecurity, creditType, maturityDate, outstandingBalance, monthlyAmortization FROM outstanding_credits WHERE housingAccountNo = ?";
    private static final String SELECT_MAX_CREDITOR_ID_SQL = "SELECT creditorId FROM outstanding_credits ORDER BY creditorId DESC LIMIT 1";
    private static final String SELECT_BY_CREDITOR_ID_SQL = "SELECT creditorId FROM outstanding_credits WHERE creditorId = ?";

    @Override
    public void saveOutstandingCredits(List<OutstandingCredits> credits) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                for (OutstandingCredits credit : credits) {
                    if (credit.getStrCreditorId() == null || credit.getStrCreditorId().isEmpty()) {
                        String nextCreditorId = getNextCreditorId(conn);
                        credit.setStrCreditorId(nextCreditorId);
                    }
                    if (existsByCreditorId(conn, credit.getStrCreditorId())) {
                        updateOutstandingCredit(conn, credit);
                    } else {
                        insertOutstandingCredit(conn, credit);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving OutstandingCredits records: " + e.getMessage(), e);
        }
    }

    @Override
    public List<OutstandingCredits> getOutstandingCreditsByCreditorId(String housingAccountNo) throws Exception {
        List<OutstandingCredits> credits = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_HOUSING_ACCOUNT_NO_SQL)) {
            stmt.setString(1, housingAccountNo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OutstandingCredits credit = mapResultSetToOutstandingCredit(rs);
                    credits.add(credit);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving OutstandingCredits by housingAccountNo: " + e.getMessage(), e);
        }
        return credits;
    }

    private String getNextCreditorId(Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_MAX_CREDITOR_ID_SQL);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String lastCreditorId = rs.getString("creditorId");
                int lastNumber = Integer.parseInt(lastCreditorId.substring(1));
                int nextNumber = lastNumber + 1;
                return String.format("C%03d", nextNumber);
            } else {
                return "C001";
            }
        }
    }

    private boolean existsByCreditorId(Connection conn, String creditorId) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_BY_CREDITOR_ID_SQL)) {
            stmt.setString(1, creditorId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private void insertOutstandingCredit(Connection conn, OutstandingCredits credit) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, credit.getStrCreditorId());
            stmt.setString(2, credit.getStrCreditorName());
            stmt.setString(3, credit.getStrCreditorAddress());
            stmt.setString(4, credit.getStrHousingAccountNo());
            stmt.setString(5, credit.getEnumSecurity() != null ? credit.getEnumSecurity().name().replace("_", " ") : null);
            stmt.setString(6, credit.getEnumType() != null ? credit.getEnumType().name().replace("_", " ") : null);
            stmt.setDate(7, credit.getDtMaturityDate() != null ? Date.valueOf(credit.getDtMaturityDate()) : null);
            stmt.setBigDecimal(8, credit.getBdOutstandingBalance());
            stmt.setBigDecimal(9, credit.getBdMonthlyAmortization());
            stmt.executeUpdate();
        }
    }

    private void updateOutstandingCredit(Connection conn, OutstandingCredits credit) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            stmt.setString(1, credit.getStrCreditorName());
            stmt.setString(2, credit.getStrCreditorAddress());
            stmt.setString(3, credit.getStrHousingAccountNo());
            stmt.setString(4, credit.getEnumSecurity() != null ? credit.getEnumSecurity().name().replace("_", " ") : null);
            stmt.setString(5, credit.getEnumType() != null ? credit.getEnumType().name().replace("_", " ") : null);
            stmt.setDate(6, credit.getDtMaturityDate() != null ? Date.valueOf(credit.getDtMaturityDate()) : null);
            stmt.setBigDecimal(7, credit.getBdOutstandingBalance());
            stmt.setBigDecimal(8, credit.getBdMonthlyAmortization());
            stmt.setString(9, credit.getStrCreditorId());
            stmt.executeUpdate();
        }
    }

    private OutstandingCredits mapResultSetToOutstandingCredit(ResultSet rs) throws SQLException {
        OutstandingCredits credit = new OutstandingCredits();
        credit.setStrCreditorId(rs.getString("creditorId"));
        credit.setStrCreditorName(rs.getString("creditorName"));
        credit.setStrCreditorAddress(rs.getString("creditorAddress"));
        credit.setStrHousingAccountNo(rs.getString("housingAccountNo"));
        String creditSecurityStr = rs.getString("creditSecurity");
        if (creditSecurityStr != null) {
            try {
                credit.setEnumSecurity(OutstandingCredits.CreditSecurity.fromString(creditSecurityStr));
            } catch (IllegalArgumentException e) {
                credit.setEnumSecurity(null);
            }
        } else {
            credit.setEnumSecurity(null);
        }
        String creditTypeStr = rs.getString("creditType");
        if (creditTypeStr != null) {
            try {
                credit.setEnumType(OutstandingCredits.CreditType.fromString(creditTypeStr));
            } catch (IllegalArgumentException e) {
                credit.setEnumType(null);
            }
        } else {
            credit.setEnumType(null);
        }
        Date maturityDate = rs.getDate("maturityDate");
        if (maturityDate != null) {
            credit.setDtMaturityDate(maturityDate.toLocalDate());
        } else {
            credit.setDtMaturityDate(null);
        }
        credit.setBdOutstandingBalance(rs.getBigDecimal("outstandingBalance"));
        credit.setBdMonthlyAmortization(rs.getBigDecimal("monthlyAmortization"));
        return credit;
    }
}
