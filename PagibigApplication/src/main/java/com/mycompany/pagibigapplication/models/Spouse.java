package com.mycompany.pagibigapplication.models;

import java.time.LocalDate;

public class Spouse {
    private String strSpousePagibigMid;    
    private String strSpouseName;        

    public enum Citizenship {
        F,   // Filipino
        DC,  // Dual Citizen
        FN   // Foreign National
    }

    private Citizenship enumSpouseCitizenship;
    private LocalDate dtSpouseDOB;        
    private String strSpouseTin;             
    private String strSpouseOccupation;  
    private String strSpouseBusinessPhone; 
    private int intEmployerId;      
    private String strEmployerName;
    private String strSpousePosition;    
    private int intSpouseYearsEmployment; 
    private String strPagibigMid;
    private String memberName;

    public Spouse() {
    }

    public Spouse(String strSpousePagibigMid, String strSpouseName, Citizenship enumSpouseCitizenship, LocalDate dtSpouseDOB,
                  String strSpouseTin, String strSpouseOccupation, String strSpouseBusinessPhone, int intEmployerId,
                  String strSpousePosition, int intSpouseYearsEmployment, String strPagibigMid, String memberName) {
        this.strSpousePagibigMid = strSpousePagibigMid;
        this.strSpouseName = strSpouseName;
        this.enumSpouseCitizenship = enumSpouseCitizenship;
        this.dtSpouseDOB = dtSpouseDOB;
        this.strSpouseTin = strSpouseTin;
        this.strSpouseOccupation = strSpouseOccupation;
        this.strSpouseBusinessPhone = strSpouseBusinessPhone;
        this.intEmployerId = intEmployerId;
        this.strSpousePosition = strSpousePosition;
        this.intSpouseYearsEmployment = intSpouseYearsEmployment;
        this.strPagibigMid = strPagibigMid;
        this.memberName = memberName;
    }

    public String getStrSpousePagibigMid() {
        return strSpousePagibigMid;
    }

    public void setStrSpousePagibigMid(String strSpousePagibigMid) {
        this.strSpousePagibigMid = strSpousePagibigMid;
    }

    public String getStrSpouseName() {
        return strSpouseName;
    }

    public void setStrSpouseName(String strSpouseName) {
        this.strSpouseName = strSpouseName;
    }

    public Citizenship getEnumSpouseCitizenship() {
        return enumSpouseCitizenship;
    }

    public void setEnumSpouseCitizenship(Citizenship enumSpouseCitizenship) {
        this.enumSpouseCitizenship = enumSpouseCitizenship;
    }

    public LocalDate getDtSpouseDOB() {
        return dtSpouseDOB;
    }

    public void setDtSpouseDOB(LocalDate dtSpouseDOB) {
        this.dtSpouseDOB = dtSpouseDOB;
    }

    public String getStrSpouseTin() {
        return strSpouseTin;
    }

    public void setStrSpouseTin(String strSpouseTin) {
        this.strSpouseTin = strSpouseTin;
    }

    public String getStrSpouseOccupation() {
        return strSpouseOccupation;
    }

    public void setStrSpouseOccupation(String strSpouseOccupation) {
        this.strSpouseOccupation = strSpouseOccupation;
    }

    public String getStrSpouseBusinessPhone() {
        return strSpouseBusinessPhone;
    }

    public void setStrSpouseBusinessPhone(String strSpouseBusinessPhone) {
        this.strSpouseBusinessPhone = strSpouseBusinessPhone;
    }

    public int getIntEmployerId() {
        return intEmployerId;
    }

    public void setIntEmployerId(int intEmployerId) {
        this.intEmployerId = intEmployerId;
    }

    public String getStrSpousePosition() {
        return strSpousePosition;
    }

    public void setStrSpousePosition(String strSpousePosition) {
        this.strSpousePosition = strSpousePosition;
    }

    public int getIntSpouseYearsEmployment() {
        return intSpouseYearsEmployment;
    }

    public void setIntSpouseYearsEmployment(int intSpouseYearsEmployment) {
        this.intSpouseYearsEmployment = intSpouseYearsEmployment;
    }

    public String getEmployerName() {
        return strEmployerName;
    }

    public void setEmployerName(String strEmployerName) {
        this.strEmployerName = strEmployerName;
    }
    
    public String getPagibigMid() {
        return strPagibigMid;
    }

    public void setPagibigMid(String strPagibigMid) {
        this.strPagibigMid = strPagibigMid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
