
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.LoanApplication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanApplicationService {
    private Connection connection;
    
    public LoanApplicationService(Connection connection) {
        this.connection = connection;
    }
    
    public List<LoanApplication> getAllLoanApplications() {
        List<LoanApplication> applications = new ArrayList<>();
        String strQuery = "SELECT * FROM loan_application";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                LoanApplication application = new LoanApplication();
                application.setHousingAccountNo(rs.getString("housingAccountNo"));
                application.setPurposeOfLoan(rs.getString("purposeOfLoan"));
                application.setHasExistingApplication(rs.getBoolean("hasExistingApplication"));
                application.setHousingApplicationNo(rs.getString("housingApplicationNo"));
                application.setLoanAmount(rs.getInt("loanAmount"));
                application.setLoanTerm(rs.getString("loanTerm"));
                application.setRepricingPeriod(rs.getString("repricingPeriod"));
                application.setModeOfPayment(rs.getString("modeOfPayment"));
                application.setPagibigMid(rs.getString("pagibigMid"));
                
                applications.add(application);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching loan applications: ");
            e.printStackTrace();
        }
        
        return applications;
    }
    
}
