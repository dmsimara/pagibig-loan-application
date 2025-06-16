package com.mycompany.pagibigapplication.models;

public class LoanApplication {
    private String strHousingAccountNo;          
    private String strPurposeOfLoan;
    private boolean bHasExistingApplication;   
    private String strHousingApplicationNo;
    private int intLoanAmount;
    private String strLoanTerm;
    private String strRepricingPeriod;
    private String strModeOfPayment;
    private String strPagibigMid;
    private int intApplicationNo;

    public LoanApplication() {
    }

    public LoanApplication(String strHousingAccountNo, String strPurposeOfLoan, boolean bHasExistingApplication,
                           String strHousingApplicationNo, int intLoanAmount, String strLoanTerm,
                           String strRepricingPeriod, String strModeOfPayment, String strPagibigMid, int intApplicationNo) {
        this.strHousingAccountNo = strHousingAccountNo;
        this.strPurposeOfLoan = strPurposeOfLoan;
        this.bHasExistingApplication = bHasExistingApplication;
        this.strHousingApplicationNo = strHousingApplicationNo;
        this.intLoanAmount = intLoanAmount;
        this.strLoanTerm = strLoanTerm;
        this.strRepricingPeriod = strRepricingPeriod;
        this.strModeOfPayment = strModeOfPayment;
        this.strPagibigMid = strPagibigMid;
        this.intApplicationNo = intApplicationNo;
    }

    // Getters and setters

    public String getHousingAccountNo() {
        return strHousingAccountNo;
    }

    public void setHousingAccountNo(String strHousingAccountNo) {
        this.strHousingAccountNo = strHousingAccountNo;
    }

    public String getPurposeOfLoan() {
        return strPurposeOfLoan;
    }

    public void setPurposeOfLoan(String strPurposeOfLoan) {
        this.strPurposeOfLoan = strPurposeOfLoan;
    }

    public boolean hasExistingApplication() {
        return bHasExistingApplication;
    }

    public void setHasExistingApplication(boolean bHasExistingApplication) {
        this.bHasExistingApplication = bHasExistingApplication;
    }

    public String getHousingApplicationNo() {
        return strHousingApplicationNo;
    }

    public void setHousingApplicationNo(String strHousingApplicationNo) {
        this.strHousingApplicationNo = strHousingApplicationNo;
    }

    public int getLoanAmount() {
        return intLoanAmount;
    }

    public void setLoanAmount(int intLoanAmount) {
        this.intLoanAmount = intLoanAmount;
    }

    public String getLoanTerm() {
        return strLoanTerm;
    }

    public void setLoanTerm(String strLoanTerm) {
        this.strLoanTerm = strLoanTerm;
    }

    public String getRepricingPeriod() {
        return strRepricingPeriod;
    }

    public void setRepricingPeriod(String strRepricingPeriod) {
        this.strRepricingPeriod = strRepricingPeriod;
    }

    public String getModeOfPayment() {
        return strModeOfPayment;
    }

    public void setModeOfPayment(String strModeOfPayment) {
        this.strModeOfPayment = strModeOfPayment;
    }

    public String getPagibigMid() {
        return strPagibigMid;
    }

    public void setPagibigMid(String strPagibigMid) {
        this.strPagibigMid = strPagibigMid;
    }
    
    public int getIntApplicationNo() {
        return intApplicationNo;
    }

    public void setIntApplicationNo(int intApplicationNo) {
        this.intApplicationNo = intApplicationNo;
    }

}
