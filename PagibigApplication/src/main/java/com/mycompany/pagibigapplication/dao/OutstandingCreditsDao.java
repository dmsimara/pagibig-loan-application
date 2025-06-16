package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.OutstandingCredits;
import java.util.List;

public interface OutstandingCreditsDao {
    void saveOutstandingCredits(List<OutstandingCredits> credits) throws Exception;
    List<OutstandingCredits> getOutstandingCreditsByCreditorId(String housingAccountNo) throws Exception;
    List<OutstandingCredits> getOutstandingCreditsByApplicationNo(int applicationNo) throws Exception;
}
