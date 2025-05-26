
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Bank;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private Connection connection;
    
    public BankService(Connection connection) {
        this.connection = connection;
    }
    
    public List<Bank> getBanks() {
        List<Bank> banks = new ArrayList<>();
        String strQuery = "SELECT * FROM bank";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
        
            while (rs.next()) {
                Bank bank = new Bank();
                bank.setStrBankId(rs.getString("bankId"));
                bank.setStrBankName(rs.getString("bankName"));
                bank.setIntAccountNumber(rs.getString("accountNumber"));
                bank.setIntHousingAccountNo(rs.getString("housingAccountNo"));
                bank.setStrBankBranch(rs.getString("bankBranch"));
                bank.setEnumAccountType(Bank.AccountType.valueOf(rs.getString("accountType")));
                bank.setDtDateOpened(rs.getDate("dateOpened").toLocalDate());
                bank.setBdAverageBalance(rs.getBigDecimal("averageBalance"));
            
                banks.add(bank);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching banks: ");
            e.printStackTrace();
        }
        
        return banks;
    }
}
