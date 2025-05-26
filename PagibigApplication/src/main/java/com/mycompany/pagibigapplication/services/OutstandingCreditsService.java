
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.OutstandingCredits;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OutstandingCreditsService {
    private Connection connection;
    
    public OutstandingCreditsService(Connection connection) {
        this.connection = connection;
    }
    
    public List<OutstandingCredits> getOutstandingCredits() {
        List<OutstandingCredits> credits = new ArrayList<>();
        String strQuery = "SELECT * FROM outstanding_credits";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
        
            while (rs.next()) {
                OutstandingCredits credit = new OutstandingCredits();
                credit.setStrCreditorId(rs.getString("creditorId"));
                credit.setStrCreditorName(rs.getString("creditorName"));
                credit.setStrCreditorAddress(rs.getString("creditorAddress"));
                credit.setStrHousingAccountNo(rs.getString("housingAccountNo"));
                credit.setEnumSecurity(OutstandingCredits.CreditSecurity.fromString(rs.getString("creditSecurity")));
                credit.setEnumType(OutstandingCredits.CreditType.fromString(rs.getString("creditType")));
                credit.setDtMaturityDate(rs.getDate("maturityDate").toLocalDate());
                credit.setBdOutstandingBalance(rs.getBigDecimal("outstandingBalance"));
                credit.setBdMonthlyAmortization(rs.getBigDecimal("monthlyAmortization"));
                
                credits.add(credit);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching credits: ");
            e.printStackTrace();
        }
        
        return credits;
    }
}
