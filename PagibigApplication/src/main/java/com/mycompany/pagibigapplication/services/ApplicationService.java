package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Application;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationService {
    private Connection connection;
    
    public ApplicationService(Connection connection) {
        this.connection = connection;
    }
    
    public List<Application> getApplications() {
        List<Application> applications = new ArrayList<>();
        String strQuery = "SELECT a.applicationNo, m.pagibigMid, m.name AS memberName, a.dateSubmitted, a.status " +
                          "FROM application a " +
                          "JOIN member m ON a.memberName = m.pagibigMid";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Application app = new Application();
                app.setApplicationNo(rs.getInt("applicationNo"));
                app.setPagibigMid(rs.getString("pagibigMid"));
                app.setMemberName(rs.getString("memberName"));
                app.setDateSubmitted(rs.getDate("dateSubmitted").toLocalDate());
                app.setStatus(Application.Status.valueOf(rs.getString("status")));
                
                applications.add(app);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching members: ");
            e.printStackTrace();
        }
        
        return applications;
    }
    
}
