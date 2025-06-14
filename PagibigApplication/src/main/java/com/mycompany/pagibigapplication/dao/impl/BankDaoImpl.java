package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.BankDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Bank;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl implements BankDao {

    private static final String INSERT_SQL = "INSERT INTO bank (bankId, bankName, accountNumber, housingAccountNo, bankBranch, accountType, dateOpened, averageBalance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE bank SET bankName = ?, accountNumber = ?, housingAccountNo = ?, bankBranch = ?, accountType = ?, dateOpened = ?, averageBalance = ? WHERE bankId = ?";
    private static final String SELECT_BY_HOUSING_ACCOUNT_NO_SQL = "SELECT bankId, bankName, accountNumber, housingAccountNo, bankBranch, accountType, dateOpened, averageBalance FROM bank WHERE housingAccountNo = ?";
    private static final String SELECT_MAX_BANK_ID_SQL = "SELECT bankId FROM bank ORDER BY bankId DESC LIMIT 1";
    private static final String SELECT_BY_BANK_ID_SQL = "SELECT bankId FROM bank WHERE bankId = ?";

    @Override
    public void saveBanks(List<Bank> banks) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                for (Bank bank : banks) {
                    if (bank.getStrBankId() == null || bank.getStrBankId().isEmpty()) {
                        String nextBankId = getNextBankId(conn);
                        bank.setStrBankId(nextBankId);
                    }
                    if (existsByBankId(conn, bank.getStrBankId())) {
                        updateBank(conn, bank);
                    } else {
                        insertBank(conn, bank);
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
            throw new Exception("Error saving Bank records: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Bank> getBanksByBankId(String housingAccountNo) throws Exception {
        List<Bank> banks = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_HOUSING_ACCOUNT_NO_SQL)) {
            stmt.setString(1, housingAccountNo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Bank bank = mapResultSetToBank(rs);
                    banks.add(bank);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving Banks by housingAccountNo: " + e.getMessage(), e);
        }
        return banks;
    }

    private String getNextBankId(Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_MAX_BANK_ID_SQL);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String lastBankId = rs.getString("bankId");
                int lastNumber = Integer.parseInt(lastBankId.substring(1));
                int nextNumber = lastNumber + 1;
                return String.format("B%03d", nextNumber);
            } else {
                return "B001";
            }
        }
    }

    private boolean existsByBankId(Connection conn, String bankId) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_BY_BANK_ID_SQL)) {
            stmt.setString(1, bankId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private void insertBank(Connection conn, Bank bank) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, bank.getStrBankId());
            stmt.setString(2, bank.getStrBankName());
            if (bank.getIntAccountNumber() != null) {
                stmt.setString(3, bank.getIntAccountNumber());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            if (bank.getIntHousingAccountNo() != null) {
                stmt.setString(4, bank.getIntHousingAccountNo());
            } else {
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }
            stmt.setString(5, bank.getStrBankBranch());
            stmt.setString(6, bank.getEnumAccountType() != null ? bank.getEnumAccountType().name() : null);
            stmt.setDate(7, bank.getDtDateOpened() != null ? Date.valueOf(bank.getDtDateOpened()) : null);
            stmt.setBigDecimal(8, bank.getBdAverageBalance());
            stmt.executeUpdate();
        }
    }

    private void updateBank(Connection conn, Bank bank) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            stmt.setString(1, bank.getStrBankName());
            if (bank.getIntAccountNumber() != null) {
                stmt.setString(2, String.valueOf(bank.getIntAccountNumber()));
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            if (bank.getIntHousingAccountNo() != null) {
                stmt.setString(3, String.valueOf(bank.getIntHousingAccountNo()));
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.setString(4, bank.getStrBankBranch());
            stmt.setString(5, bank.getEnumAccountType() != null ? bank.getEnumAccountType().name() : null);
            stmt.setDate(6, bank.getDtDateOpened() != null ? Date.valueOf(bank.getDtDateOpened()) : null);
            stmt.setBigDecimal(7, bank.getBdAverageBalance());
            stmt.setString(8, bank.getStrBankId());
            stmt.executeUpdate();
        }
    }

    private Bank mapResultSetToBank(ResultSet rs) throws SQLException {
        Bank bank = new Bank();
        bank.setStrBankId(rs.getString("bankId"));
        bank.setStrBankName(rs.getString("bankName"));
        String accountNumberStr = rs.getString("accountNumber");
        bank.setIntAccountNumber(accountNumberStr);
        String housingAccountNoStr = rs.getString("housingAccountNo");
        bank.setIntHousingAccountNo(housingAccountNoStr);
        bank.setStrBankBranch(rs.getString("bankBranch"));
        String accountTypeStr = rs.getString("accountType");
        if (accountTypeStr != null) {
            try {
                bank.setEnumAccountType(Bank.AccountType.valueOf(accountTypeStr));
            } catch (IllegalArgumentException e) {
                bank.setEnumAccountType(null);
            }
        } else {
            bank.setEnumAccountType(null);
        }
        Date dateOpened = rs.getDate("dateOpened");
        if (dateOpened != null) {
            bank.setDtDateOpened(dateOpened.toLocalDate());
        } else {
            bank.setDtDateOpened(null);
        }
        bank.setBdAverageBalance(rs.getBigDecimal("averageBalance"));
        return bank;
    }
}
