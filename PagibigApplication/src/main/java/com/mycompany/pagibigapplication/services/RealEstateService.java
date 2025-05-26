
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.RealEstate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RealEstateService {
    private Connection connection;
    
    public RealEstateService(Connection connection) {
        this.connection = connection;
    }
    
    public List<RealEstate> getRealEstates() {
        List<RealEstate> estates = new ArrayList<>();
        String strQuery = "SELECT * FROM real_estate";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
        
            while (rs.next()) {
                RealEstate estate = new RealEstate();
                estate.setStrRealEstateId(rs.getString("realEstateId"));
                estate.setStrRealEstateLocation(rs.getString("realEstateLocation"));
                estate.setEnumRealEstateType(RealEstate.RealEstateType.fromString(rs.getString("realEstateType")));
                estate.setStrHousingAccountNo(rs.getString("housingAccountNo"));
                estate.setBdAcquisitionCost(rs.getBigDecimal("acquisitionCost"));
                estate.setBdMarketValue(rs.getBigDecimal("marketValue"));
                estate.setBdMortgageBalance(rs.getBigDecimal("mortgageBalance"));
                estate.setBdRentalIncome(rs.getBigDecimal("rentalIncome"));
                
                estates.add(estate);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching estates: ");
            e.printStackTrace();
        }
        
        return estates;
    }
}
