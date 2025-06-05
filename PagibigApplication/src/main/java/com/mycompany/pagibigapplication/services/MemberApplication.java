package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Application;
import com.mycompany.pagibigapplication.models.Application.Status;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberApplication {

    private Connection connection;

    public MemberApplication(Connection connection) {
        this.connection = connection;
    }

    // Fetch applications for a specific member
    public List<Application> getApplicationsForMember(String memberName) {
        List<Application> applications = new ArrayList<>();

        String query = "SELECT a.applicationNo, m.name AS memberName, a.dateSubmitted, a.status, m.pagibigMid " +
                       "FROM application a " +
                       "JOIN member m ON a.memberName = m.pagibigMid " +
                       "WHERE a.memberName = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, memberName);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int appNo = rs.getInt("applicationNo");
                    String memName = rs.getString("memberName");
                    LocalDate dateSubmitted = rs.getDate("dateSubmitted").toLocalDate();
                    Status status = Status.valueOf(rs.getString("status")); 
                    String pagibigMid = rs.getString("pagibigMid");

                    Application app = new Application(appNo, memName, dateSubmitted, status, pagibigMid);
                    applications.add(app);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }

    // Fetch all applications for admin
    public List<Application> getAllApplications() {
        List<Application> applications = new ArrayList<>();

        String query = "SELECT a.applicationNo, m.name AS memberName, a.dateSubmitted, a.status, m.pagibigMid " +
                       "FROM application a " +
                       "JOIN member m ON a.memberName = m.pagibigMid";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int appNo = rs.getInt("applicationNo");
                    String memName = rs.getString("memberName");
                    LocalDate dateSubmitted = rs.getDate("dateSubmitted").toLocalDate();
                    Status status = Status.valueOf(rs.getString("status")); 
                    String pagibigMid = rs.getString("pagibigMid");

                    Application app = new Application(appNo, memName, dateSubmitted, status, pagibigMid);
                    applications.add(app);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }
}
