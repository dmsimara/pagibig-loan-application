package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.LoanApplicationDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.LoanApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanApplicationDaoImpl implements LoanApplicationDao {

    private static final String INSERT_SQL = "INSERT INTO loan_application (housingAccountNo, purposeOfLoan, hasExistingApplication, housingApplicationNo, loanAmount, loanTerm, repricingPeriod, modeOfPayment, pagibigMid, applicationNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE loan_application SET purposeOfLoan = ?, hasExistingApplication = ?, housingApplicationNo = ?, loanAmount = ?, loanTerm = ?, repricingPeriod = ?, modeOfPayment = ?, pagibigMid = ?, applicationNo = ? WHERE housingAccountNo = ?";
    private static final String SELECT_BY_HOUSING_ACCOUNT_NO_SQL = "SELECT housingAccountNo, purposeOfLoan, hasExistingApplication, housingApplicationNo, loanAmount, loanTerm, repricingPeriod, modeOfPayment, pagibigMid FROM loan_application WHERE housingAccountNo = ?";
    private static final String SELECT_BY_PAGIBIG_MID_SQL = "SELECT housingAccountNo, purposeOfLoan, hasExistingApplication, housingApplicationNo, loanAmount, loanTerm, repricingPeriod, modeOfPayment, pagibigMid FROM loan_application WHERE pagibigMid = ?";
    private static final String SELECT_BY_APPLICATION_NO_SQL = "SELECT housingAccountNo, purposeOfLoan, hasExistingApplication, housingApplicationNo, loanAmount, loanTerm, repricingPeriod, modeOfPayment, pagibigMid FROM loan_application WHERE applicationNo = ?";

    @Override
    public List<LoanApplication> getLoanApplicationsByApplicationNo(int applicationNo) throws Exception {
        List<LoanApplication> loanApplications = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_APPLICATION_NO_SQL)) {
            stmt.setInt(1, applicationNo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LoanApplication loanApplication = new LoanApplication();
                    loanApplication.setHousingAccountNo(rs.getString("housingAccountNo"));
                    loanApplication.setPurposeOfLoan(rs.getString("purposeOfLoan"));
                    loanApplication.setHasExistingApplication(rs.getBoolean("hasExistingApplication"));
                    loanApplication.setHousingApplicationNo(rs.getString("housingApplicationNo"));
                    loanApplication.setLoanAmount(rs.getInt("loanAmount"));
                    loanApplication.setLoanTerm(rs.getString("loanTerm"));
                    loanApplication.setRepricingPeriod(rs.getString("repricingPeriod"));
                    loanApplication.setModeOfPayment(rs.getString("modeOfPayment"));
                    loanApplication.setPagibigMid(rs.getString("pagibigMid"));
                    loanApplications.add(loanApplication);
                }
            }
        }
        return loanApplications;
    }

    public void saveLoanApplication(List<LoanApplication> loanApplications) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                for (LoanApplication loanApplication : loanApplications) {
                    if (existsByHousingAccountNo(conn, loanApplication.getHousingAccountNo())) {
                        updateLoanApplication(conn, loanApplication);
                    } else {
                        insertLoanApplication(conn, loanApplication);
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
            throw new Exception("Error saving LoanApplication records: " + e.getMessage(), e);
        }
    }

    public void saveLoanApplication(Connection conn, List<LoanApplication> loanApplications) throws Exception {
        try {
            for (LoanApplication loanApplication : loanApplications) {
                if (existsByHousingAccountNo(conn, loanApplication.getHousingAccountNo())) {
                    updateLoanApplication(conn, loanApplication);
                } else {
                    insertLoanApplication(conn, loanApplication);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving LoanApplication records: " + e.getMessage(), e);
        }
    }

    public void saveLoanApplication(Connection conn, LoanApplication loanApplication) throws Exception {
        try {
            if (existsByHousingAccountNo(conn, loanApplication.getHousingAccountNo())) {
                updateLoanApplication(conn, loanApplication);
            } else {
                insertLoanApplication(conn, loanApplication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving LoanApplication record: " + e.getMessage(), e);
        }
    }

    @Override
    public List<LoanApplication> getLoanApplicationsByHousingAccountNo(String housingAccountNo) throws Exception {
        List<LoanApplication> loanApplications = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_HOUSING_ACCOUNT_NO_SQL)) {
            stmt.setString(1, housingAccountNo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LoanApplication loanApplication = mapResultSetToLoanApplication(rs);
                    loanApplications.add(loanApplication);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving LoanApplications by housingAccountNo: " + e.getMessage(), e);
        }
        return loanApplications;
    }

    @Override
    public List<LoanApplication> getLoanApplicationsByPagibigMid(String pagibigMid) throws Exception {
        List<LoanApplication> loanApplications = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_PAGIBIG_MID_SQL)) {
            stmt.setString(1, pagibigMid);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LoanApplication loanApplication = mapResultSetToLoanApplication(rs);
                    loanApplications.add(loanApplication);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving LoanApplications by pagibigMid: " + e.getMessage(), e);
        }
        return loanApplications;
    }

    private boolean existsByHousingAccountNo(Connection conn, String housingAccountNo) throws SQLException {
        String sql = "SELECT 1 FROM loan_application WHERE housingAccountNo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, housingAccountNo);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private void insertLoanApplication(Connection conn, LoanApplication loanApplication) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, loanApplication.getHousingAccountNo());
            stmt.setString(2, loanApplication.getPurposeOfLoan());
            stmt.setBoolean(3, loanApplication.hasExistingApplication());
            stmt.setString(4, loanApplication.getHousingApplicationNo());
            stmt.setInt(5, loanApplication.getLoanAmount());
            stmt.setString(6, loanApplication.getLoanTerm());
            stmt.setString(7, loanApplication.getRepricingPeriod());
            stmt.setString(8, loanApplication.getModeOfPayment());
            stmt.setString(9, loanApplication.getPagibigMid());
            stmt.setInt(10, loanApplication.getIntApplicationNo());
            stmt.executeUpdate();
        }
    }

    private void updateLoanApplication(Connection conn, LoanApplication loanApplication) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            stmt.setString(1, loanApplication.getPurposeOfLoan());
            stmt.setBoolean(2, loanApplication.hasExistingApplication());
            stmt.setString(3, loanApplication.getHousingApplicationNo());
            stmt.setInt(4, loanApplication.getLoanAmount());
            stmt.setString(5, loanApplication.getLoanTerm());
            stmt.setString(6, loanApplication.getRepricingPeriod());
            stmt.setString(7, loanApplication.getModeOfPayment());
            stmt.setString(8, loanApplication.getPagibigMid());
            stmt.setInt(9, loanApplication.getIntApplicationNo());
            stmt.setString(10, loanApplication.getHousingAccountNo());
            stmt.executeUpdate();
        }
    }

    private LoanApplication mapResultSetToLoanApplication(ResultSet rs) throws SQLException {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setHousingAccountNo(rs.getString("housingAccountNo"));
        loanApplication.setPurposeOfLoan(rs.getString("purposeOfLoan"));
        loanApplication.setHasExistingApplication(rs.getBoolean("hasExistingApplication"));
        loanApplication.setHousingApplicationNo(rs.getString("housingApplicationNo"));
        loanApplication.setLoanAmount(rs.getInt("loanAmount"));
        loanApplication.setLoanTerm(rs.getString("loanTerm"));
        loanApplication.setRepricingPeriod(rs.getString("repricingPeriod"));
        loanApplication.setModeOfPayment(rs.getString("modeOfPayment"));
        loanApplication.setPagibigMid(rs.getString("pagibigMid"));
        return loanApplication;
    }
}
