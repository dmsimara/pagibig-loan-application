
package com.mycompany.pagibigapplication.models;


public class Employer {
    private int employerId;
    private String employerPhoneDirect;
    private String employerPhoneTrunk;
    private String employerEmail;
    private String employerName;
    private String employerAddress;
    private String industry;
    private String preferredContactTime;

    public Employer() {
    }

    public Employer(int employerId, String employerPhoneDirect, String employerPhoneTrunk,
                    String employerEmail, String employerName, String employerAddress,
                    String industry, String preferredContactTime) {
        this.employerId = employerId;
        this.employerPhoneDirect = employerPhoneDirect;
        this.employerPhoneTrunk = employerPhoneTrunk;
        this.employerEmail = employerEmail;
        this.employerName = employerName;
        this.employerAddress = employerAddress;
        this.industry = industry;
        this.preferredContactTime = preferredContactTime;
    }

    // Getters and Setters
    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getEmployerPhoneDirect() {
        return employerPhoneDirect;
    }

    public void setEmployerPhoneDirect(String employerPhoneDirect) {
        this.employerPhoneDirect = employerPhoneDirect;
    }

    public String getEmployerPhoneTrunk() {
        return employerPhoneTrunk;
    }

    public void setEmployerPhoneTrunk(String employerPhoneTrunk) {
        this.employerPhoneTrunk = employerPhoneTrunk;
    }

    public String getEmployerEmail() {
        return employerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPreferredContactTime() {
        return preferredContactTime;
    }

    public void setPreferredContactTime(String preferredContactTime) {
        this.preferredContactTime = preferredContactTime;
    }

}

