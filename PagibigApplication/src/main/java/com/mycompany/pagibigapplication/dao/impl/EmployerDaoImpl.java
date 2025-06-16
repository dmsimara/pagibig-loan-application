package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.EmployerDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Employer;

import java.sql.*;

public class EmployerDaoImpl implements EmployerDao {

    private static final String INSERT_SQL = "INSERT INTO employer (employerPhoneDirect, employerPhoneTrunk, employerEmail, employerName, employerAddress, industry, preferredContactTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE employer SET employerPhoneDirect = ?, employerPhoneTrunk = ?, employerEmail = ?, employerName = ?, employerAddress = ?, industry = ?, preferredContactTime = ? WHERE employerId = ?";
    private static final String SELECT_BY_EMPLOYER_ID_SQL = "SELECT employerId, employerPhoneDirect, employerPhoneTrunk, employerEmail, employerName, employerAddress, industry, preferredContactTime FROM employer WHERE employerId = ?";
    private static final String SELECT_BY_EMPLOYER_NAME_SQL = "SELECT employerId FROM employer WHERE LOWER(employerName) = LOWER(?)";

    @Override
    public void saveEmployer(Employer employer) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                Integer existingEmployerId = findEmployerIdByName(conn, employer.getEmployerName());
                if (existingEmployerId != null) {
                    employer.setEmployerId(existingEmployerId);
                    updateEmployer(conn, employer);
                } else {
                    insertEmployer(conn, employer);
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
            throw new Exception("Error saving Employer record: " + e.getMessage(), e);
        }
    }

    public void saveEmployer(Connection conn, Employer employer) throws Exception {
        try {
            Integer existingEmployerId = findEmployerIdByName(conn, employer.getEmployerName());
            if (existingEmployerId != null) {
                employer.setEmployerId(existingEmployerId);
                updateEmployer(conn, employer);
            } else {
                insertEmployer(conn, employer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving Employer record: " + e.getMessage(), e);
        }
    }

    @Override
    public Employer getEmployerByEmployerId(String employerIdStr) throws Exception {
        Employer employer = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_EMPLOYER_ID_SQL)) {
            int employerId = Integer.parseInt(employerIdStr);
            stmt.setInt(1, employerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employer = mapResultSetToEmployer(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving Employer by employerId: " + e.getMessage(), e);
        }
        return employer;
    }

    private Integer findEmployerIdByName(Connection conn, String employerName) throws SQLException {
        if (employerName == null || employerName.trim().isEmpty()) {
            return null;
        }
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_BY_EMPLOYER_NAME_SQL)) {
            stmt.setString(1, employerName.trim());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("employerId");
                }
            }
        }
        return null;
    }

    private void insertEmployer(Connection conn, Employer employer) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, employer.getEmployerPhoneDirect());
            stmt.setString(2, employer.getEmployerPhoneTrunk());
            stmt.setString(3, employer.getEmployerEmail());
            stmt.setString(4, employer.getEmployerName());
            stmt.setString(5, employer.getEmployerAddress());
            stmt.setString(6, employer.getIndustry());
            stmt.setString(7, employer.getPreferredContactTime());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting employer failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employer.setEmployerId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Inserting employer failed, no ID obtained.");
                }
            }
        }
    }

    private void updateEmployer(Connection conn, Employer employer) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            stmt.setString(1, employer.getEmployerPhoneDirect());
            stmt.setString(2, employer.getEmployerPhoneTrunk());
            stmt.setString(3, employer.getEmployerEmail());
            stmt.setString(4, employer.getEmployerName());
            stmt.setString(5, employer.getEmployerAddress());
            stmt.setString(6, employer.getIndustry());
            stmt.setString(7, employer.getPreferredContactTime());
            stmt.setInt(8, employer.getEmployerId());
            stmt.executeUpdate();
        }
    }

    private Employer mapResultSetToEmployer(ResultSet rs) throws SQLException {
        Employer employer = new Employer();
        employer.setEmployerId(rs.getInt("employerId"));
        employer.setEmployerPhoneDirect(rs.getString("employerPhoneDirect"));
        employer.setEmployerPhoneTrunk(rs.getString("employerPhoneTrunk"));
        employer.setEmployerEmail(rs.getString("employerEmail"));
        employer.setEmployerName(rs.getString("employerName"));
        employer.setEmployerAddress(rs.getString("employerAddress"));
        employer.setIndustry(rs.getString("industry"));
        employer.setPreferredContactTime(rs.getString("preferredContactTime"));
        return employer;
    }
}
