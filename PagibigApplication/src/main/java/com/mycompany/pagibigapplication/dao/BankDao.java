package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.Bank;
import java.util.List;

public interface BankDao {
    void saveBanks(List<Bank> banks) throws Exception;
    List<Bank> getBanksByBankId(String housingAccountNo) throws Exception;
    List<Bank> getBanksByApplicationNo(int applicationNo) throws Exception;
}
