package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.ApplicationDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationDaoImpl implements ApplicationDao {

    private static final String INSERT_SQL = "INSERT INTO application (memberName, dateSubmitted, status) VALUES (?, ?, ?)";
    private static final String UPDATE_STATUS_SQL = "UPDATE application SET status = ? WHERE applicationNo = ?";

    private static final String DELETE_APPLICATION_SQL = "DELETE FROM application WHERE applicationNo = ?";

    @Override
    public void saveApplication(Application application) throws Exception {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, application.getPagibigMid());
            stmt.setDate(2, Date.valueOf(application.getDateSubmitted()));
            stmt.setString(3, application.getStatus().name());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Creating application failed, no rows affected.");
            }
            try (java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    application.setApplicationNo(generatedId);
                } else {
                    throw new Exception("Creating application failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving Application record: " + e.getMessage(), e);
        }
    }


    @Override
    public void updateApplicationStatus(int applicationNo, Application.Status status) throws Exception {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_STATUS_SQL)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, applicationNo);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("No application found with applicationNo: " + applicationNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error updating application status: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteApplicationAndRelatedRecords(int applicationNo) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // Delete related loan applications
                try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM loan_application WHERE applicationNo = ?")) {
                    stmt.setInt(1, applicationNo);
                    stmt.executeUpdate();
                }
                // Delete related collateral
                try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM collateral WHERE applicationNo = ?")) {
                    stmt.setInt(1, applicationNo);
                    stmt.executeUpdate();
                }
                // Delete related spouse
                try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM spouse WHERE applicationNo = ?")) {
                    stmt.setInt(1, applicationNo);
                    stmt.executeUpdate();
                }
                // Delete related bank
                try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM bank WHERE applicationNo = ?")) {
                    stmt.setInt(1, applicationNo);
                    stmt.executeUpdate();
                }
                // Delete related real estate
                try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM real_estate WHERE applicationNo = ?")) {
                    stmt.setInt(1, applicationNo);
                    stmt.executeUpdate();
                }
                // Delete related outstanding credits
                try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM outstanding_credits WHERE applicationNo = ?")) {
                    stmt.setInt(1, applicationNo);
                    stmt.executeUpdate();
                }

                // Delete the application record
                try (PreparedStatement stmt = conn.prepareStatement(DELETE_APPLICATION_SQL)) {
                    stmt.setInt(1, applicationNo);
                    stmt.executeUpdate();
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
            throw new Exception("Error deleting application and related records: " + e.getMessage(), e);
        }
    }

    public int saveApplication(Connection conn, Application application) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, application.getPagibigMid());
            stmt.setDate(2, java.sql.Date.valueOf(application.getDateSubmitted()));
            stmt.setString(3, application.getStatus().name());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Creating application failed, no rows affected.");
            }
            try (java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    application.setApplicationNo(generatedId);
                    return generatedId;
                } else {
                    throw new Exception("Creating application failed, no ID obtained.");
                }
            }
        }
    }
}
