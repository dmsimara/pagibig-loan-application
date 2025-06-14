package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.Employer;

public interface EmployerDao {
    void saveEmployer(Employer employer) throws Exception;
    Employer getEmployerByEmployerId(String housingAccountNo) throws Exception;
}
