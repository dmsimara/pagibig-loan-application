package com.mycompany.pagibigapplication.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OutstandingCredits {
    private String strCreditorId;           
    private String strCreditorName;        
    private String strCreditorAddress;     
    private String strHousingAccountNo;       
    
    public enum CreditSecurity {
        REAL_ESTATE_MORTGAGE,
        CHATTEL_MORTGAGE,
        POST_DATED_CHECKS,
        CO_MAKER_GUARANTEE,
        NONE;
        
        public static CreditSecurity fromString(String str) {
            return CreditSecurity.valueOf(str.toUpperCase().replace(" ", "_"));
        }
    }
    private CreditSecurity enumCreditSecurity;
    
    public enum CreditType {
        CREDIT_CARD,
        PERSONAL_LOAN,
        CAR_LOAN,
        HOUSING_LOAN,
        SALARY_LOAN,
        BUSINESS_LOAN,
        OTHERS;
        
        public static CreditType fromString(String str) {
            return CreditType.valueOf(str.toUpperCase().replace(" ", "_"));
        }
    }
    
    private CreditType enumCreditType;
    private LocalDate dtMaturityDate;      
    private BigDecimal bdOutstandingBalance;    
    private BigDecimal bdMonthlyAmortization;   
    private int intApplicationNo;

    public OutstandingCredits() {
    }

    public OutstandingCredits(String strCreditorId, String strCreditorName, String strCreditorAddress, String strHousingAccountNo,
                             CreditSecurity enumCreditSecurity, CreditType enumCreditType, LocalDate dtMaturityDate,
                             BigDecimal bdOutstandingBalance, BigDecimal bdMonthlyAmortization, int intApplicationNo) {
        this.strCreditorId = strCreditorId;
        this.strCreditorName = strCreditorName;
        this.strCreditorAddress = strCreditorAddress;
        this.strHousingAccountNo = strHousingAccountNo;
        this.enumCreditSecurity = enumCreditSecurity;
        this.enumCreditType = enumCreditType;
        this.dtMaturityDate = dtMaturityDate;
        this.bdOutstandingBalance = bdOutstandingBalance;
        this.bdMonthlyAmortization = bdMonthlyAmortization;
        this.intApplicationNo = intApplicationNo;
    }


    public String getStrCreditorId() {
        return strCreditorId;
    }

    public void setStrCreditorId(String strCreditorId) {
        this.strCreditorId = strCreditorId;
    }

    public String getStrCreditorName() {
        return strCreditorName;
    }

    public void setStrCreditorName(String strCreditorName) {
        this.strCreditorName = strCreditorName;
    }

    public String getStrCreditorAddress() {
        return strCreditorAddress;
    }

    public void setStrCreditorAddress(String strCreditorAddress) {
        this.strCreditorAddress = strCreditorAddress;
    }

    public String getStrHousingAccountNo() {
        return strHousingAccountNo;
    }

    public void setStrHousingAccountNo(String strHousingAccountNo) {
        this.strHousingAccountNo = strHousingAccountNo;
    }

    public CreditSecurity getEnumSecurity() {
        return enumCreditSecurity;
    }

    public void setEnumSecurity(CreditSecurity enumCreditSecurity) {
        this.enumCreditSecurity = enumCreditSecurity;
    }

    public CreditType getEnumType() {
        return enumCreditType;
    }

    public void setEnumType(CreditType enumCreditType) {
        this.enumCreditType = enumCreditType;
    }

    public LocalDate getDtMaturityDate() {
        return dtMaturityDate;
    }

    public void setDtMaturityDate(LocalDate dtMaturityDate) {
        this.dtMaturityDate = dtMaturityDate;
    }

    public BigDecimal getBdOutstandingBalance() {
        return bdOutstandingBalance;
    }

    public void setBdOutstandingBalance(BigDecimal bdOutstandingBalance) {
        this.bdOutstandingBalance = bdOutstandingBalance;
    }

    public BigDecimal getBdMonthlyAmortization() {
        return bdMonthlyAmortization;
    }

    public void setBdMonthlyAmortization(BigDecimal bdMonthlyAmortization) {
        this.bdMonthlyAmortization = bdMonthlyAmortization;
    }
    
    public int getIntApplicationNo() {
        return intApplicationNo;
    }

    public void setIntApplicationNo(int intApplicationNo) {
        this.intApplicationNo = intApplicationNo;
    }
}
