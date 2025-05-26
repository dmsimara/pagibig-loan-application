package com.mycompany.pagibigapplication.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bank {
    private String strBankId;              
    private String strBankName;            
    private String intAccountNumber;          
    private String intHousingAccountNo;    
    private String strBankBranch;        

    public enum AccountType {
        SAVINGS,
        CHECKING
    }
    private AccountType enumAccountType; 

    private LocalDate dtDateOpened;       
    private BigDecimal bdAverageBalance;  

    public Bank() {
    }

    public Bank(String strBankId, String strBankName, String intAccountNumber, String intHousingAccountNo,
                String strBankBranch, AccountType enumAccountType, LocalDate dtDateOpened, BigDecimal bdAverageBalance) {
        this.strBankId = strBankId;
        this.strBankName = strBankName;
        this.intAccountNumber = intAccountNumber;
        this.intHousingAccountNo = intHousingAccountNo;
        this.strBankBranch = strBankBranch;
        this.enumAccountType = enumAccountType;
        this.dtDateOpened = dtDateOpened;
        this.bdAverageBalance = bdAverageBalance;
    }


    public String getStrBankId() {
        return strBankId;
    }

    public void setStrBankId(String strBankId) {
        this.strBankId = strBankId;
    }

    public String getStrBankName() {
        return strBankName;
    }

    public void setStrBankName(String strBankName) {
        this.strBankName = strBankName;
    }

    public String getIntAccountNumber() {
        return intAccountNumber;
    }

    public void setIntAccountNumber(String intAccountNumber) {
        this.intAccountNumber = intAccountNumber;
    }

    public String getIntHousingAccountNo() {
        return intHousingAccountNo;
    }

    public void setIntHousingAccountNo(String intHousingAccountNo) {
        this.intHousingAccountNo = intHousingAccountNo;
    }

    public String getStrBankBranch() {
        return strBankBranch;
    }

    public void setStrBankBranch(String strBankBranch) {
        this.strBankBranch = strBankBranch;
    }

    public AccountType getEnumAccountType() {
        return enumAccountType;
    }

    public void setEnumAccountType(AccountType enumAccountType) {
        this.enumAccountType = enumAccountType;
    }

    public LocalDate getDtDateOpened() {
        return dtDateOpened;
    }

    public void setDtDateOpened(LocalDate dtDateOpened) {
        this.dtDateOpened = dtDateOpened;
    }

    public BigDecimal getBdAverageBalance() {
        return bdAverageBalance;
    }

    public void setBdAverageBalance(BigDecimal bdAverageBalance) {
        this.bdAverageBalance = bdAverageBalance;
    }
}
