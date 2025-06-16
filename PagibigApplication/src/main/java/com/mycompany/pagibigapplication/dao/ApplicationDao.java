package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.Application;

public interface ApplicationDao {
    void saveApplication(Application application) throws Exception;
    void updateApplicationStatus(int applicationNo, Application.Status status) throws Exception;
    void deleteApplicationAndRelatedRecords(int applicationNo) throws Exception;
}
