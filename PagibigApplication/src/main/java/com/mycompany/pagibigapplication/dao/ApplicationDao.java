package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.Application;

public interface ApplicationDao {
    void saveApplication(Application application) throws Exception;
}
