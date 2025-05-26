package com.mycompany.pagibigapplication.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Member {
    private String strPagibigMid;   
    private String strName;

    public enum Citizenship {
        F,  // Filipino
        DC, // Dual Citizen
        FN  // Foreign National
    }
    private Citizenship enumCitizenship;

    private LocalDate dtDateOfBirth;

    public enum Sex {
        F, M
    }
    private Sex enumSex;

    public enum MaritalStatus {
        S,  // Single
        M,  // Married
        LS, // Legally Separated
        A,  // Annulled
        W   // Widowed
    }
    private MaritalStatus enumMaritalStatus;

    private int intNumberOfDependents;
    private String strPresentHomeAddress;
    private String strPermanentHomeAddress;
    private String strHomePhone;
    private String strCellPhone;
    private String strEmailAddress;
    private String strAlternateMailingAddress;
    private String strSssGsisNo;
    private String strTin;
    private String strOccupation;
    private String strHomeOwnership;
    private BigDecimal bdMonthlyRent;
    private int intYearsOfStayAddress;
    private int intEmployerId;
    private String strEmployerName;
    private int intYearsEmployment;
    private String strPositionDepartment;

    public Member() {
    }

    public Member(String strPagibigMid, String strName, Citizenship enumCitizenship, LocalDate dtDateOfBirth, Sex enumSex,
                  MaritalStatus enumMaritalStatus, int intNumberOfDependents, String strPresentHomeAddress,
                  String strPermanentHomeAddress, String strHomePhone, String strCellPhone, String strEmailAddress, String strAlternateMailingAddress,
                  String strSssGsisNo, String strTin, String strOccupation, String strHomeOwnership, BigDecimal bdMonthlyRent,
                  int intYearsOfStayAddress, int intEmployerId, int intYearsEmployment, String strPositionDepartment) {
        this.strPagibigMid = strPagibigMid;
        this.strName = strName;
        this.enumCitizenship = enumCitizenship;
        this.dtDateOfBirth = dtDateOfBirth;
        this.enumSex = enumSex;
        this.enumMaritalStatus = enumMaritalStatus;
        this.intNumberOfDependents = intNumberOfDependents;
        this.strPresentHomeAddress = strPresentHomeAddress;
        this.strPermanentHomeAddress = strPermanentHomeAddress;
        this.strHomePhone = strHomePhone;
        this.strCellPhone = strCellPhone;
        this.strEmailAddress = strEmailAddress;
        this.strAlternateMailingAddress = strAlternateMailingAddress;
        this.strSssGsisNo = strSssGsisNo;
        this.strTin = strTin;
        this.strOccupation = strOccupation;
        this.strHomeOwnership = strHomeOwnership;
        this.bdMonthlyRent = bdMonthlyRent;
        this.intYearsOfStayAddress = intYearsOfStayAddress;
        this.intEmployerId = intEmployerId;
        this.intYearsEmployment = intYearsEmployment;
        this.strPositionDepartment = strPositionDepartment;
    }

    
    public String getPagibigMid() {
        return strPagibigMid;
    }

    public void setPagibigMid(String strPagibigMid) {
        this.strPagibigMid = strPagibigMid;
    }

    public String getName() {
        return strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public Citizenship getCitizenship() {
        return enumCitizenship;
    }

    public void setCitizenship(Citizenship enumCitizenship) {
        this.enumCitizenship = enumCitizenship;
    }

    public LocalDate getDateOfBirth() {
        return dtDateOfBirth;
    }

    public void setDateOfBirth(LocalDate dtDateOfBirth) {
        this.dtDateOfBirth = dtDateOfBirth;
    }

    public Sex getSex() {
        return enumSex;
    }

    public void setSex(Sex enumSex) {
        this.enumSex = enumSex;
    }

    public MaritalStatus getMaritalStatus() {
        return enumMaritalStatus;
    }

    public void setMaritalStatus(MaritalStatus enumMaritalStatus) {
        this.enumMaritalStatus = enumMaritalStatus;
    }

    public int getNumberOfDependents() {
        return intNumberOfDependents;
    }

    public void setNumberOfDependents(int intNumberOfDependents) {
        this.intNumberOfDependents = intNumberOfDependents;
    }

    public String getPresentHomeAddress() {
        return strPresentHomeAddress;
    }

    public void setPresentHomeAddress(String strPresentHomeAddress) {
        this.strPresentHomeAddress = strPresentHomeAddress;
    }

    public String getPermanentHomeAddress() {
        return strPermanentHomeAddress;
    }

    public void setPermanentHomeAddress(String strPermanentHomeAddress) {
        this.strPermanentHomeAddress = strPermanentHomeAddress;
    }

    public String getHomePhone() {
        return strHomePhone;
    }

    public void setHomePhone(String strHomePhone) {
        this.strHomePhone = strHomePhone;
    }

    public String getEmailAddress() {
        return strEmailAddress;
    }

    public void setEmailAddress(String strEmailAddress) {
        this.strEmailAddress = strEmailAddress;
    }

    public String getAlternateMailingAddress() {
        return strAlternateMailingAddress;
    }

    public void setAlternateMailingAddress(String strAlternateMailingAddress) {
        this.strAlternateMailingAddress = strAlternateMailingAddress;
    }

    public String getSssGsisNo() {
        return strSssGsisNo;
    }

    public void setSssGsisNo(String strSssGsisNo) {
        this.strSssGsisNo = strSssGsisNo;
    }

    public String getTin() {
        return strTin;
    }

    public void setTin(String strTin) {
        this.strTin = strTin;
    }

    public String getOccupation() {
        return strOccupation;
    }

    public void setOccupation(String strOccupation) {
        this.strOccupation = strOccupation;
    }

    public String getHomeOwnership() {
        return strHomeOwnership;
    }

    public void setHomeOwnership(String strHomeOwnership) {
        this.strHomeOwnership = strHomeOwnership;
    }

    public BigDecimal getMonthlyRent() {
        return bdMonthlyRent;
    }

    public void setMonthlyRent(BigDecimal bdMonthlyRent) {
        this.bdMonthlyRent = bdMonthlyRent;
    }

    public int getYearsOfStayAddress() {
        return intYearsOfStayAddress;
    }

    public void setYearsOfStayAddress(int intYearsOfStayAddress) {
        this.intYearsOfStayAddress = intYearsOfStayAddress;
    }

    public int getEmployerId() {
        return intEmployerId;
    }

    public void setEmployerId(int intEmployerId) {
        this.intEmployerId = intEmployerId;
    }

    public int getYearsEmployment() {
        return intYearsEmployment;
    }

    public void setYearsEmployment(int intYearsEmployment) {
        this.intYearsEmployment = intYearsEmployment;
    }

    public String getPositionDepartment() {
        return strPositionDepartment;
    }

    public void setPositionDepartment(String strPositionDepartment) {
        this.strPositionDepartment = strPositionDepartment;
    }
    
    public String getCellPhone() {
        return strCellPhone;
    }
    
    public void setCellPhone(String strCellPhone) {
        this.strCellPhone = strCellPhone;
    }
    
    public String getEmployerName() {
        return strEmployerName;
    }

    public void setEmployerName(String strEmployerName) {
        this.strEmployerName = strEmployerName;
    }
}
