
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Employer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployerService {
    private Connection connection;
    
    public EmployerService(Connection connection) {
        this.connection = connection;
    }
    
    public List<Employer> getEmployers() {
        List<Employer> employers = new ArrayList<>();
        String strQuery = "SELECT * FROM employer";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Employer employer = new Employer();
                employer.setEmployerId(rs.getInt("employerId"));
                employer.setEmployerPhoneDirect(rs.getString("employerPhoneDirect"));
                employer.setEmployerPhoneTrunk(rs.getString("employerPhoneTrunk"));
                employer.setEmployerEmail(rs.getString("employerEmail"));
                employer.setEmployerName(rs.getString("employerName"));
                employer.setEmployerAddress(rs.getString("employerAddress"));
                employer.setIndustry(rs.getString("industry"));
                employer.setPreferredContactTime(rs.getString("preferredContactTime"));
                
                employers.add(employer);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching employers: ");
            e.printStackTrace();
        }
        
        return employers;
    }
}
