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

    @Override
    public void saveApplication(Application application) throws Exception {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, application.getPagibigMid());
            stmt.setDate(2, Date.valueOf(application.getDateSubmitted()));
            stmt.setString(3, application.getStatus().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving Application record: " + e.getMessage(), e);
        }
    }
}
