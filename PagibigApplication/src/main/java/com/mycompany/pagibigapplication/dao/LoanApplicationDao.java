package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.LoanApplication;
import java.util.List;

public interface LoanApplicationDao {
    void saveLoanApplication(List<LoanApplication> loanApplications) throws Exception;
    List<LoanApplication> getLoanApplicationsByHousingAccountNo(String housingAccountNo) throws Exception;
    List<LoanApplication> getLoanApplicationsByPagibigMid(String pagibigMid) throws Exception;
    List<LoanApplication> getLoanApplicationsByApplicationNo(int applicationNo) throws Exception;
}
