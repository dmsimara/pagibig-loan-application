
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Collateral;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollateralService {
    private Connection connection;
    
    public CollateralService(Connection connection) {
        this.connection = connection;
    }
    
    public List<Collateral> getCollaterals() {
        List<Collateral> collaterals = new ArrayList<>();
        String strQuery = "SELECT * FROM collateral";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Collateral collateral = new Collateral();
                collateral.setIntTctOctCctNo(rs.getString("tctOctCctNo"));
                collateral.setStrPrimaryPropertyLocation(rs.getString("primaryPropertyLocation"));
                collateral.setEnumPropertyType(Collateral.PropertyType.fromString(rs.getString("propertyType")));
                collateral.setStrDeveloperTitleHolder(rs.getString("developerTitleHolder"));
                collateral.setEnumDescriptionOfImprovements(Collateral.DescriptionOfImprovements.valueOf(rs.getString("descriptionOfImprovements")));
                collateral.setStrTaxDeclarationNo(rs.getString("taxDeclarationNo"));
                collateral.setStrLotUnitNo(rs.getString("lotUnitNo"));
                collateral.setStrBlockBuildingNo(rs.getString("blockBuildingNo"));
                collateral.setIntNumberOfStoreys(rs.getInt("numberOfStoreys"));
                collateral.setBoolIsPropertyMortgaged(rs.getBoolean("isPropertyMortgaged"));
                collateral.setBdLandAreaSqm(rs.getBigDecimal("landAreaSqm"));
                collateral.setBdFloorAreaSqm(rs.getBigDecimal("floorAreaSqm"));
                collateral.setIntAgeOfHouse(rs.getInt("ageOfHouse"));
                collateral.setBdTotalFloorAreaSqm(rs.getBigDecimal("totalFloorAreaSqm"));
                collateral.setBoolIsOffsiteCollateral(rs.getBoolean("isOffsiteCollateral"));
                collateral.setStrOffsiteCollateralReason(rs.getString("offsiteCollateralReason"));
                collateral.setStrHousingAccountNo(rs.getString("housingAccountNo"));
                
                collaterals.add(collateral);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching collaterals: ");
            e.printStackTrace();
        }
        
        return collaterals;
    }
}
