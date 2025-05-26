package com.mycompany.pagibigapplication.models;

import java.math.BigDecimal;

public class RealEstate {
    private String strRealEstateId;        
    private String strRealEstateLocation;   
    
    public enum RealEstateType {
        RESIDENTIAL_LOT,
        HOUSE_AND_LOT,
        TOWNHOUSE,
        CONDOMINIUM_UNIT,
        FORECLOSED_PROPERTY,
        ROWHOUSE,
        DUPLEX,
        VACANT_LOT;
        
        public static RealEstateType fromString(String str) {
            return RealEstateType.valueOf(str.toUpperCase().replace(" ", "_"));
        }
    }
    private RealEstateType enumRealEstateType;
    
   
    private String strHousingAccountNo;         
    private BigDecimal bdAcquisitionCost;   
    private BigDecimal bdMarketValue;        
    private BigDecimal bdMortgageBalance;   
    private BigDecimal bdRentalIncome;      

    public RealEstate() {
    }

    public RealEstate(String strRealEstateId, String strRealEstateLocation, RealEstateType enumRealEstateType, String strHousingAccountNo,
                      BigDecimal bdAcquisitionCost, BigDecimal bdMarketValue, BigDecimal bdMortgageBalance, BigDecimal bdRentalIncome) {
        this.strRealEstateId = strRealEstateId;
        this.strRealEstateLocation = strRealEstateLocation;
        this.enumRealEstateType = enumRealEstateType;
        this.strHousingAccountNo = strHousingAccountNo;
        this.bdAcquisitionCost = bdAcquisitionCost;
        this.bdMarketValue = bdMarketValue;
        this.bdMortgageBalance = bdMortgageBalance;
        this.bdRentalIncome = bdRentalIncome;
    }


    public String getStrRealEstateId() {
        return strRealEstateId;
    }

    public void setStrRealEstateId(String strRealEstateId) {
        this.strRealEstateId = strRealEstateId;
    }

    public String getStrRealEstateLocation() {
        return strRealEstateLocation;
    }

    public void setStrRealEstateLocation(String strRealEstateLocation) {
        this.strRealEstateLocation = strRealEstateLocation;
    }

    public RealEstateType getEnumRealEstateType() {
        return enumRealEstateType;
    }

    public void setEnumRealEstateType(RealEstateType enumRealEstateType) {
        this.enumRealEstateType = enumRealEstateType;
    }

    public String getStrHousingAccountNo() {
        return strHousingAccountNo;
    }

    public void setStrHousingAccountNo(String strHousingAccountNo) {
        this.strHousingAccountNo = strHousingAccountNo;
    }

    public BigDecimal getBdAcquisitionCost() {
        return bdAcquisitionCost;
    }

    public void setBdAcquisitionCost(BigDecimal bdAcquisitionCost) {
        this.bdAcquisitionCost = bdAcquisitionCost;
    }

    public BigDecimal getBdMarketValue() {
        return bdMarketValue;
    }

    public void setBdMarketValue(BigDecimal bdMarketValue) {
        this.bdMarketValue = bdMarketValue;
    }

    public BigDecimal getBdMortgageBalance() {
        return bdMortgageBalance;
    }

    public void setBdMortgageBalance(BigDecimal bdMortgageBalance) {
        this.bdMortgageBalance = bdMortgageBalance;
    }

    public BigDecimal getBdRentalIncome() {
        return bdRentalIncome;
    }

    public void setBdRentalIncome(BigDecimal bdRentalIncome) {
        this.bdRentalIncome = bdRentalIncome;
    }
}
