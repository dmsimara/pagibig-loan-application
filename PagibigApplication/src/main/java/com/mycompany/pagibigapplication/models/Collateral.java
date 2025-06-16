package com.mycompany.pagibigapplication.models;

import java.math.BigDecimal;

public class Collateral {
    private String strTctOctCctNo;                      
    private String strPrimaryPropertyLocation;    
  
    public enum PropertyType {
        RESIDENTIAL_LOT,
        HOUSE_AND_LOT,
        TOWNHOUSE,
        CONDOMINIUM_UNIT,
        FORECLOSED_PROPERTY;
        
        public static PropertyType fromString(String str) {
            return PropertyType.valueOf(str.toUpperCase().replace(" ", "_"));
        }
    }
    private PropertyType enumPropertyType;

    private String strDeveloperTitleHolder;          

    public enum DescriptionOfImprovements {
        EXISTING,
        PROPOSED
    }
    private DescriptionOfImprovements enumDescriptionOfImprovements;   

    private String strTaxDeclarationNo;              
    private String strLotUnitNo;                      
    private String strBlockBuildingNo;                 
    private int intNumberOfStoreys;                    
    private boolean bIsPropertyMortgaged;           
    private BigDecimal bdLandAreaSqm;                 
    private BigDecimal bdFloorAreaSqm;                 
    private int intAgeOfHouse;                           
    private BigDecimal bdTotalFloorAreaSqm;             
    private boolean bIsOffsiteCollateral;        
    private String strOffsiteCollateralReason;   
    private String strHousingAccountNo;
    private int intApplicationNo;

    public Collateral() {
    }

    public Collateral(String strTctOctCctNo, String strPrimaryPropertyLocation, PropertyType enumPropertyType,
                      String strDeveloperTitleHolder, DescriptionOfImprovements enumDescriptionOfImprovements,
                      String strTaxDeclarationNo, String strLotUnitNo, String strBlockBuildingNo, int intNumberOfStoreys,
                      boolean bIsPropertyMortgaged, BigDecimal bdLandAreaSqm, BigDecimal bdFloorAreaSqm,
                      int intAgeOfHouse, BigDecimal bdTotalFloorAreaSqm, boolean bIsOffsiteCollateral,
                      String strOffsiteCollateralReason, String strHousingAccountNo, int intApplicationNo) {
        this.strTctOctCctNo = strTctOctCctNo;
        this.strPrimaryPropertyLocation = strPrimaryPropertyLocation;
        this.enumPropertyType = enumPropertyType;
        this.strDeveloperTitleHolder = strDeveloperTitleHolder;
        this.enumDescriptionOfImprovements = enumDescriptionOfImprovements;
        this.strTaxDeclarationNo = strTaxDeclarationNo;
        this.strLotUnitNo = strLotUnitNo;
        this.strBlockBuildingNo = strBlockBuildingNo;
        this.intNumberOfStoreys = intNumberOfStoreys;
        this.bIsPropertyMortgaged = bIsPropertyMortgaged;
        this.bdLandAreaSqm = bdLandAreaSqm;
        this.bdFloorAreaSqm = bdFloorAreaSqm;
        this.intAgeOfHouse = intAgeOfHouse;
        this.bdTotalFloorAreaSqm = bdTotalFloorAreaSqm;
        this.bIsOffsiteCollateral = bIsOffsiteCollateral;
        this.strOffsiteCollateralReason = strOffsiteCollateralReason;
        this.strHousingAccountNo = strHousingAccountNo;
        this.intApplicationNo = intApplicationNo;
    }


    public String getIntTctOctCctNo() {
        return strTctOctCctNo;
    }

    public void setIntTctOctCctNo(String strTctOctCctNo) {
        this.strTctOctCctNo = strTctOctCctNo;
    }

    public String getStrPrimaryPropertyLocation() {
        return strPrimaryPropertyLocation;
    }

    public void setStrPrimaryPropertyLocation(String strPrimaryPropertyLocation) {
        this.strPrimaryPropertyLocation = strPrimaryPropertyLocation;
    }

    public PropertyType getEnumPropertyType() {
        return enumPropertyType;
    }

    public void setEnumPropertyType(PropertyType enumPropertyType) {
        this.enumPropertyType = enumPropertyType;
    }

    public String getStrDeveloperTitleHolder() {
        return strDeveloperTitleHolder;
    }

    public void setStrDeveloperTitleHolder(String strDeveloperTitleHolder) {
        this.strDeveloperTitleHolder = strDeveloperTitleHolder;
    }

    public DescriptionOfImprovements getEnumDescriptionOfImprovements() {
        return enumDescriptionOfImprovements;
    }

    public void setEnumDescriptionOfImprovements(DescriptionOfImprovements enumDescriptionOfImprovements) {
        this.enumDescriptionOfImprovements = enumDescriptionOfImprovements;
    }

    public String getStrTaxDeclarationNo() {
        return strTaxDeclarationNo;
    }

    public void setStrTaxDeclarationNo(String strTaxDeclarationNo) {
        this.strTaxDeclarationNo = strTaxDeclarationNo;
    }

    public String getStrLotUnitNo() {
        return strLotUnitNo;
    }

    public void setStrLotUnitNo(String strLotUnitNo) {
        this.strLotUnitNo = strLotUnitNo;
    }

    public String getStrBlockBuildingNo() {
        return strBlockBuildingNo;
    }

    public void setStrBlockBuildingNo(String strBlockBuildingNo) {
        this.strBlockBuildingNo = strBlockBuildingNo;
    }

    public int getIntNumberOfStoreys() {
        return intNumberOfStoreys;
    }

    public void setIntNumberOfStoreys(int intNumberOfStoreys) {
        this.intNumberOfStoreys = intNumberOfStoreys;
    }

    public boolean isBoolIsPropertyMortgaged() {
        return bIsPropertyMortgaged;
    }

    public void setBoolIsPropertyMortgaged(boolean bIsPropertyMortgaged) {
        this.bIsPropertyMortgaged = bIsPropertyMortgaged;
    }

    public BigDecimal getBdLandAreaSqm() {
        return bdLandAreaSqm;
    }

    public void setBdLandAreaSqm(BigDecimal bdLandAreaSqm) {
        this.bdLandAreaSqm = bdLandAreaSqm;
    }

    public BigDecimal getBdFloorAreaSqm() {
        return bdFloorAreaSqm;
    }

    public void setBdFloorAreaSqm(BigDecimal bdFloorAreaSqm) {
        this.bdFloorAreaSqm = bdFloorAreaSqm;
    }

    public int getIntAgeOfHouse() {
        return intAgeOfHouse;
    }

    public void setIntAgeOfHouse(int intAgeOfHouse) {
        this.intAgeOfHouse = intAgeOfHouse;
    }

    public BigDecimal getBdTotalFloorAreaSqm() {
        return bdTotalFloorAreaSqm;
    }

    public void setBdTotalFloorAreaSqm(BigDecimal bdTotalFloorAreaSqm) {
        this.bdTotalFloorAreaSqm = bdTotalFloorAreaSqm;
    }

    public boolean isBoolIsOffsiteCollateral() {
        return bIsOffsiteCollateral;
    }

    public void setBoolIsOffsiteCollateral(boolean bIsOffsiteCollateral) {
        this.bIsOffsiteCollateral = bIsOffsiteCollateral;
    }

    public String getStrOffsiteCollateralReason() {
        return strOffsiteCollateralReason;
    }

    public void setStrOffsiteCollateralReason(String strOffsiteCollateralReason) {
        this.strOffsiteCollateralReason = strOffsiteCollateralReason;
    }
    
    public String getStrHousingAccountNo() {
        return strHousingAccountNo;
    }
    
    public void setStrHousingAccountNo(String strHousingAccountNo) {
        this.strHousingAccountNo = strHousingAccountNo;
    }
    
    public int getIntApplicationNo() {
        return intApplicationNo;
    }

    public void setIntApplicationNo(int intApplicationNo) {
        this.intApplicationNo = intApplicationNo;
    }
}
