package com.mycompany.pagibigapplication.models;

import java.time.LocalDate;

public class Application {
    private int intApplicationNo;
    private String strMemberName;   
    private LocalDate dtDateSubmitted;
    
    public enum Status {
        Pending,
        Approved,
        Rejected
    }
    private Status enumStatus;
    
    private String strPagibigMid;
    
    public Application() {
    
    }
    
    public Application(int intApplicationNo, String strMemberName, LocalDate dtDateSubmitted, Status enumStatus, String strPagibigMid) {
        this.intApplicationNo = intApplicationNo;
        this.strMemberName = strMemberName;
        this.dtDateSubmitted = dtDateSubmitted;
        this.enumStatus = enumStatus;
        this.strPagibigMid = strPagibigMid;
    }
    
    public int getApplicationNo() {
        return intApplicationNo;
    }
    
    public void setApplicationNo(int intApplicationNo) {
        this.intApplicationNo = intApplicationNo;
    }
    
    public String getMemberName() {
        return strMemberName;
    }
    
    public void setMemberName(String strMemberName) {
        this.strMemberName = strMemberName;
    }
    
    public String getPagibigMid() {
        return strPagibigMid;
    }
    
    public void setPagibigMid(String strPagibigMid) {
        this.strPagibigMid = strPagibigMid;
    }
    
    public LocalDate getDateSubmitted() {
        return dtDateSubmitted;
    }
    
    public void setDateSubmitted(LocalDate dtDateSubmitted) {
        this.dtDateSubmitted = dtDateSubmitted;
    }
    
    public Status getStatus() {
        return enumStatus;
    }
    
    public void setStatus(Status enumStatus) {
        this.enumStatus = enumStatus;
    }
}
