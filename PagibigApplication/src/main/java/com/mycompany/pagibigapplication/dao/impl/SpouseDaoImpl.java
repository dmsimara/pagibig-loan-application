package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.SpouseDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Spouse;

import java.sql.*;

public class SpouseDaoImpl implements SpouseDao {

    private static final String INSERT_SQL = "INSERT INTO spouse (spousePagibigMid, spouseName, spouseCitizenship, spouseDOB, spouseTin, spouseOccupation, spouseBusinessPhone, employerId, spousePosition, spouseYearsEmployment, pagibigMid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE spouse SET spouseName = ?, spouseCitizenship = ?, spouseDOB = ?, spouseTin = ?, spouseOccupation = ?, spouseBusinessPhone = ?, employerId = ?, spousePosition = ?, spouseYearsEmployment = ?, pagibigMid = ? WHERE spousePagibigMid = ?";

    private static final String SELECT_EMPLOYER_BY_NAME = "SELECT employerId FROM Employer WHERE LOWER(employerName) = LOWER(?)";
    private static final String INSERT_EMPLOYER = "INSERT INTO Employer (employerName) VALUES (?)";

    @Override
    public void saveSpouse(Spouse spouse, String memberPagibigMid) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // Find or insert employer
                Integer employerId = findOrInsertEmployer(conn, spouse.getEmployerName());

                try (PreparedStatement updateStmt = conn.prepareStatement(UPDATE_SQL)) {
                    updateStmt.setString(1, spouse.getStrSpouseName());
                    updateStmt.setString(2, spouse.getEnumSpouseCitizenship() != null ? spouse.getEnumSpouseCitizenship().name() : null);
                    updateStmt.setDate(3, spouse.getDtSpouseDOB() != null ? Date.valueOf(spouse.getDtSpouseDOB()) : null);
                    updateStmt.setString(4, spouse.getStrSpouseTin());
                    updateStmt.setString(5, spouse.getStrSpouseOccupation());
                    updateStmt.setString(6, spouse.getStrSpouseBusinessPhone());
                    if (employerId != null) {
                        updateStmt.setInt(7, employerId);
                    } else {
                        updateStmt.setNull(7, Types.INTEGER);
                    }
                    updateStmt.setString(8, spouse.getStrSpousePosition());
                    updateStmt.setInt(9, spouse.getIntSpouseYearsEmployment());
                    updateStmt.setString(10, memberPagibigMid); // pagibigMid from member
                    updateStmt.setString(11, spouse.getStrSpousePagibigMid());

                    int affectedRows = updateStmt.executeUpdate();
                    if (affectedRows == 0) {
                        try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_SQL)) {
                            insertStmt.setString(1, spouse.getStrSpousePagibigMid());
                            insertStmt.setString(2, spouse.getStrSpouseName());
                            insertStmt.setString(3, spouse.getEnumSpouseCitizenship() != null ? spouse.getEnumSpouseCitizenship().name() : null);
                            insertStmt.setDate(4, spouse.getDtSpouseDOB() != null ? Date.valueOf(spouse.getDtSpouseDOB()) : null);
                            insertStmt.setString(5, spouse.getStrSpouseTin());
                            insertStmt.setString(6, spouse.getStrSpouseOccupation());
                            insertStmt.setString(7, spouse.getStrSpouseBusinessPhone());
                            if (employerId != null) {
                                insertStmt.setInt(8, employerId);
                            } else {
                                insertStmt.setNull(8, Types.INTEGER);
                            }
                            insertStmt.setString(9, spouse.getStrSpousePosition());
                            insertStmt.setInt(10, spouse.getIntSpouseYearsEmployment());
                            insertStmt.setString(11, memberPagibigMid); // pagibigMid from member
                            insertStmt.executeUpdate();
                        }
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
            throw new Exception("Error saving Spouse record: " + e.getMessage(), e);
        }
    }

    private Integer findOrInsertEmployer(Connection conn, String employerName) throws SQLException {
        if (employerName == null || employerName.trim().isEmpty()) {
            return null;
        }
        try (PreparedStatement selectStmt = conn.prepareStatement(SELECT_EMPLOYER_BY_NAME)) {
            selectStmt.setString(1, employerName.trim());
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("employerId");
                }
            }
        }
        try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_EMPLOYER, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, employerName.trim());
            int affectedRows = insertStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting employer failed, no rows affected.");
            }
            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting employer failed, no ID obtained.");
                }
            }
        }
    }

    @Override
    public Spouse getSpouseBySpousePagibigMid(String spousePagibigMid) throws Exception {
        Spouse spouse = null;
        String sql = "SELECT spousePagibigMid, spouseName, spouseCitizenship, spouseDOB, spouseTin, spouseOccupation, spouseBusinessPhone, employerId, spousePosition, spouseYearsEmployment, pagibigMid FROM spouse WHERE spousePagibigMid = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, spousePagibigMid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    spouse = new Spouse();
                    spouse.setStrSpousePagibigMid(rs.getString("spousePagibigMid"));
                    spouse.setStrSpouseName(rs.getString("spouseName"));
                    String citizenshipStr = rs.getString("spouseCitizenship");
                    if (citizenshipStr != null) {
                        spouse.setEnumSpouseCitizenship(Spouse.Citizenship.valueOf(citizenshipStr));
                    }
                    Date dob = rs.getDate("spouseDOB");
                    if (dob != null) {
                        spouse.setDtSpouseDOB(dob.toLocalDate());
                    }
                    spouse.setStrSpouseTin(rs.getString("spouseTin"));
                    spouse.setStrSpouseOccupation(rs.getString("spouseOccupation"));
                    spouse.setStrSpouseBusinessPhone(rs.getString("spouseBusinessPhone"));
                    spouse.setIntEmployerId(rs.getInt("employerId"));
                    spouse.setStrSpousePosition(rs.getString("spousePosition"));
                    spouse.setIntSpouseYearsEmployment(rs.getInt("spouseYearsEmployment"));
                    spouse.setPagibigMid(rs.getString("pagibigMid"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving Spouse by spousePagibigMid: " + e.getMessage(), e);
        }
        return spouse;
    }
}
