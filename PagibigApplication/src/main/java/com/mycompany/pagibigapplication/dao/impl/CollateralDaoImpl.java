package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.CollateralDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Collateral;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CollateralDaoImpl implements CollateralDao {

    private static final String INSERT_SQL = "INSERT INTO collateral (tctOctCctNo, primaryPropertyLocation, propertyType, developerTitleHolder, descriptionOfImprovements, taxDeclarationNo, lotUnitNo, blockBuildingNo, numberOfStoreys, isPropertyMortgaged, landAreaSqm, floorAreaSqm, ageOfHouse, totalFloorAreaSqm, isOffsiteCollateral, offsiteCollateralReason, housingAccountNo, applicationNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String UPDATE_SQL = "UPDATE collateral SET primaryPropertyLocation = ?, propertyType = ?, developerTitleHolder = ?, descriptionOfImprovements = ?, taxDeclarationNo = ?, lotUnitNo = ?, blockBuildingNo = ?, numberOfStoreys = ?, isPropertyMortgaged = ?, landAreaSqm = ?, floorAreaSqm = ?, ageOfHouse = ?, totalFloorAreaSqm = ?, isOffsiteCollateral = ?, offsiteCollateralReason = ?, applicationNo = ? WHERE tctOctCctNo = ?";
    
    private static final String SELECT_BY_TCT_OCT_CCT_NO_SQL = "SELECT tctOctCctNo, primaryPropertyLocation, propertyType, developerTitleHolder, descriptionOfImprovements, taxDeclarationNo, lotUnitNo, blockBuildingNo, numberOfStoreys, isPropertyMortgaged, landAreaSqm, floorAreaSqm, ageOfHouse, totalFloorAreaSqm, isOffsiteCollateral, offsiteCollateralReason, housingAccountNo FROM collateral WHERE tctOctCctNo = ?";
    
    private static final String SELECT_BY_HOUSING_ACCOUNT_NO_SQL = "SELECT tctOctCctNo, primaryPropertyLocation, propertyType, developerTitleHolder, descriptionOfImprovements, taxDeclarationNo, lotUnitNo, blockBuildingNo, numberOfStoreys, isPropertyMortgaged, landAreaSqm, floorAreaSqm, ageOfHouse, totalFloorAreaSqm, isOffsiteCollateral, offsiteCollateralReason, housingAccountNo FROM collateral WHERE housingAccountNo = ?";

    @Override
    public void saveCollateral(Collateral collateral) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            try (PreparedStatement updateStmt = conn.prepareStatement(UPDATE_SQL)) {
                updateStmt.setString(1, collateral.getStrPrimaryPropertyLocation());
                updateStmt.setString(2, collateral.getEnumPropertyType() != null ? collateral.getEnumPropertyType().name().replace("_", " ") : null);
                updateStmt.setString(3, collateral.getStrDeveloperTitleHolder());
                updateStmt.setString(4, collateral.getEnumDescriptionOfImprovements() != null ? collateral.getEnumDescriptionOfImprovements().name() : null);
                updateStmt.setString(5, collateral.getStrTaxDeclarationNo());
                updateStmt.setString(6, collateral.getStrLotUnitNo());
                updateStmt.setString(7, collateral.getStrBlockBuildingNo());
                updateStmt.setInt(8, collateral.getIntNumberOfStoreys());
                updateStmt.setBoolean(9, collateral.isBoolIsPropertyMortgaged());
                updateStmt.setBigDecimal(10, collateral.getBdLandAreaSqm());
                updateStmt.setBigDecimal(11, collateral.getBdFloorAreaSqm());
                updateStmt.setInt(12, collateral.getIntAgeOfHouse());
                updateStmt.setBigDecimal(13, collateral.getBdTotalFloorAreaSqm());
                updateStmt.setBoolean(14, collateral.isBoolIsOffsiteCollateral());
                updateStmt.setString(15, collateral.getStrOffsiteCollateralReason());
                updateStmt.setInt(16, collateral.getIntApplicationNo());
                updateStmt.setString(17, collateral.getIntTctOctCctNo());

                int affectedRows = updateStmt.executeUpdate();
                if (affectedRows == 0) {
                    try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_SQL)) {
                        insertStmt.setString(1, collateral.getIntTctOctCctNo());
                        insertStmt.setString(2, collateral.getStrPrimaryPropertyLocation());
                        insertStmt.setString(3, collateral.getEnumPropertyType() != null ? collateral.getEnumPropertyType().name().replace("_", " ") : null);
                        insertStmt.setString(4, collateral.getStrDeveloperTitleHolder());
                        insertStmt.setString(5, collateral.getEnumDescriptionOfImprovements() != null ? collateral.getEnumDescriptionOfImprovements().name() : null);
                        insertStmt.setString(6, collateral.getStrTaxDeclarationNo());
                        insertStmt.setString(7, collateral.getStrLotUnitNo());
                        insertStmt.setString(8, collateral.getStrBlockBuildingNo());
                        insertStmt.setInt(9, collateral.getIntNumberOfStoreys());
                        insertStmt.setBoolean(10, collateral.isBoolIsPropertyMortgaged());
                        insertStmt.setBigDecimal(11, collateral.getBdLandAreaSqm());
                        insertStmt.setBigDecimal(12, collateral.getBdFloorAreaSqm());
                        insertStmt.setInt(13, collateral.getIntAgeOfHouse());
                        insertStmt.setBigDecimal(14, collateral.getBdTotalFloorAreaSqm());
                        insertStmt.setBoolean(15, collateral.isBoolIsOffsiteCollateral());
                        insertStmt.setString(16, collateral.getStrOffsiteCollateralReason());
                        insertStmt.setString(17, collateral.getStrHousingAccountNo());
                        insertStmt.setInt(18, collateral.getIntApplicationNo());
                        insertStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving Collateral record: " + e.getMessage(), e);
        }
    }

    public void saveCollateral(Connection conn, Collateral collateral) throws Exception {
        try {
            try (PreparedStatement updateStmt = conn.prepareStatement(UPDATE_SQL)) {
                updateStmt.setString(1, collateral.getStrPrimaryPropertyLocation());
                updateStmt.setString(2, collateral.getEnumPropertyType() != null ? collateral.getEnumPropertyType().name().replace("_", " ") : null);
                updateStmt.setString(3, collateral.getStrDeveloperTitleHolder());
                updateStmt.setString(4, collateral.getEnumDescriptionOfImprovements() != null ? collateral.getEnumDescriptionOfImprovements().name() : null);
                updateStmt.setString(5, collateral.getStrTaxDeclarationNo());
                updateStmt.setString(6, collateral.getStrLotUnitNo());
                updateStmt.setString(7, collateral.getStrBlockBuildingNo());
                updateStmt.setInt(8, collateral.getIntNumberOfStoreys());
                updateStmt.setBoolean(9, collateral.isBoolIsPropertyMortgaged());
                updateStmt.setBigDecimal(10, collateral.getBdLandAreaSqm());
                updateStmt.setBigDecimal(11, collateral.getBdFloorAreaSqm());
                updateStmt.setInt(12, collateral.getIntAgeOfHouse());
                updateStmt.setBigDecimal(13, collateral.getBdTotalFloorAreaSqm());
                updateStmt.setBoolean(14, collateral.isBoolIsOffsiteCollateral());
                updateStmt.setString(15, collateral.getStrOffsiteCollateralReason());
                updateStmt.setInt(16, collateral.getIntApplicationNo());
                updateStmt.setString(17, collateral.getIntTctOctCctNo());

                int affectedRows = updateStmt.executeUpdate();
                if (affectedRows == 0) {
                    try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_SQL)) {
                        insertStmt.setString(1, collateral.getIntTctOctCctNo());
                        insertStmt.setString(2, collateral.getStrPrimaryPropertyLocation());
                        insertStmt.setString(3, collateral.getEnumPropertyType() != null ? collateral.getEnumPropertyType().name().replace("_", " ") : null);
                        insertStmt.setString(4, collateral.getStrDeveloperTitleHolder());
                        insertStmt.setString(5, collateral.getEnumDescriptionOfImprovements() != null ? collateral.getEnumDescriptionOfImprovements().name() : null);
                        insertStmt.setString(6, collateral.getStrTaxDeclarationNo());
                        insertStmt.setString(7, collateral.getStrLotUnitNo());
                        insertStmt.setString(8, collateral.getStrBlockBuildingNo());
                        insertStmt.setInt(9, collateral.getIntNumberOfStoreys());
                        insertStmt.setBoolean(10, collateral.isBoolIsPropertyMortgaged());
                        insertStmt.setBigDecimal(11, collateral.getBdLandAreaSqm());
                        insertStmt.setBigDecimal(12, collateral.getBdFloorAreaSqm());
                        insertStmt.setInt(13, collateral.getIntAgeOfHouse());
                        insertStmt.setBigDecimal(14, collateral.getBdTotalFloorAreaSqm());
                        insertStmt.setBoolean(15, collateral.isBoolIsOffsiteCollateral());
                        insertStmt.setString(16, collateral.getStrOffsiteCollateralReason());
                        insertStmt.setString(17, collateral.getStrHousingAccountNo());
                        insertStmt.setInt(18, collateral.getIntApplicationNo());
                        insertStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving Collateral record: " + e.getMessage(), e);
        }
    }

    @Override
    public Collateral getCollateralByTctOctCctNo(String tctOctCctNo) throws Exception {
        Collateral collateral = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_TCT_OCT_CCT_NO_SQL)) {
            stmt.setString(1, tctOctCctNo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    collateral = new Collateral();
                    collateral.setIntTctOctCctNo(rs.getString("tctOctCctNo"));
                    collateral.setStrPrimaryPropertyLocation(rs.getString("primaryPropertyLocation"));
                    String propertyTypeStr = rs.getString("propertyType");
                    if (propertyTypeStr != null) {
                        // Fix enum value to match Java enum naming convention (replace spaces and lowercase)
                        String enumValue = propertyTypeStr.replace(" ", "_").replace("-", "_").toUpperCase();
                        collateral.setEnumPropertyType(Collateral.PropertyType.valueOf(enumValue));
                    }
                    collateral.setStrDeveloperTitleHolder(rs.getString("developerTitleHolder"));
                    String descriptionStr = rs.getString("descriptionOfImprovements");
                    if (descriptionStr != null) {
                        collateral.setEnumDescriptionOfImprovements(Collateral.DescriptionOfImprovements.valueOf(descriptionStr));
                    }
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving Collateral by tctOctCctNo: " + e.getMessage(), e);
        }
        return collateral;
    }
    
    @Override
    public Collateral getCollateralByApplicationNo(int applicationNo) throws Exception {
        Collateral collateral = null;
        String sql = "SELECT tctOctCctNo, primaryPropertyLocation, propertyType, developerTitleHolder, descriptionOfImprovements, taxDeclarationNo, lotUnitNo, blockBuildingNo, numberOfStoreys, isPropertyMortgaged, landAreaSqm, floorAreaSqm, ageOfHouse, totalFloorAreaSqm, isOffsiteCollateral, offsiteCollateralReason, housingAccountNo FROM collateral WHERE applicationNo = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, applicationNo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    collateral = new Collateral();
                    collateral.setIntTctOctCctNo(rs.getString("tctOctCctNo"));
                    collateral.setStrPrimaryPropertyLocation(rs.getString("primaryPropertyLocation"));
                    String propertyTypeStr = rs.getString("propertyType");
                    if (propertyTypeStr != null) {
                        String enumValue = propertyTypeStr.replace(" ", "_").replace("-", "_").toUpperCase();
                        collateral.setEnumPropertyType(Collateral.PropertyType.valueOf(enumValue));
                    }
                    collateral.setStrDeveloperTitleHolder(rs.getString("developerTitleHolder"));
                    String descriptionStr = rs.getString("descriptionOfImprovements");
                    if (descriptionStr != null) {
                        collateral.setEnumDescriptionOfImprovements(Collateral.DescriptionOfImprovements.valueOf(descriptionStr));
                    }
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving Collateral by applicationNo: " + e.getMessage(), e);
        }
        return collateral;
    }

    @Override
    public Collateral getCollateralByHousingAccountNo(String housingAccountNo) throws Exception {
        Collateral collateral = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_HOUSING_ACCOUNT_NO_SQL)) {
            stmt.setString(1, housingAccountNo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    collateral = new Collateral();
                    collateral.setIntTctOctCctNo(rs.getString("tctOctCctNo"));
                    collateral.setStrPrimaryPropertyLocation(rs.getString("primaryPropertyLocation"));
                    String propertyTypeStr = rs.getString("propertyType");
                    if (propertyTypeStr != null) {
                        // Fix enum value to match Java enum naming convention (replace spaces and lowercase)
                        String enumValue = propertyTypeStr.replace(" ", "_").replace("-", "_").toUpperCase();
                        collateral.setEnumPropertyType(Collateral.PropertyType.valueOf(enumValue));
                    }
                    collateral.setStrDeveloperTitleHolder(rs.getString("developerTitleHolder"));
                    String descriptionStr = rs.getString("descriptionOfImprovements");
                    if (descriptionStr != null) {
                        collateral.setEnumDescriptionOfImprovements(Collateral.DescriptionOfImprovements.valueOf(descriptionStr));
                    }
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving Collateral by housingAccountNo: " + e.getMessage(), e);
        }
        return collateral;
    }
}
