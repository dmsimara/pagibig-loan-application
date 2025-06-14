package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.LoanApplication;
import com.mycompany.pagibigapplication.models.Member;
import com.mycompany.pagibigapplication.models.Collateral;
import com.mycompany.pagibigapplication.models.Spouse;
import com.mycompany.pagibigapplication.models.Bank;
import com.mycompany.pagibigapplication.models.RealEstate;
import com.mycompany.pagibigapplication.models.OutstandingCredits;
import com.mycompany.pagibigapplication.models.Employer;

import java.util.ArrayList;
import java.util.List;

public class ApplicationData {
    private LoanApplication loan = new LoanApplication();
    private Member member = new Member();
    private Collateral collateral = new Collateral();
    private Spouse spouse = new Spouse();
    private Bank bank = new Bank();
    private RealEstate estate = new RealEstate();
    private OutstandingCredits credit = new OutstandingCredits();
    private Employer employer = new Employer();

    private List<Bank> bankList = new ArrayList<>();
    private List<RealEstate> realEstateList = new ArrayList<>();
    private List<OutstandingCredits> creditsList = new ArrayList<>();

    // getters
    public LoanApplication getLoan() {
        return loan;
    }

    public Member getMember() {
        return member;
    }

    public Collateral getCollateral() {
        return collateral;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public RealEstate getRealEstate() {
        return estate;
    }

    public OutstandingCredits getOutstandingCredits() {
        return credit;
    }
    
    public List<OutstandingCredits> getCreditsList() {
        return creditsList;
    }
    
    public void setCreditsList(List<OutstandingCredits> creditsList) {
        this.creditsList = creditsList;
    }

    public Employer getEmployer() {
        return employer;
    }
    
    public List<RealEstate> getRealEstateList() {
        return realEstateList;
    }
    
    public void setRealEstateList(List<RealEstate> realEstateList) {
        this.realEstateList = realEstateList;
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }
}
