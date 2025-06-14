package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.Spouse;

public interface SpouseDao {
    void saveSpouse(Spouse spouse, String memberPagibigMid) throws Exception;
    Spouse getSpouseBySpousePagibigMid(String spousePagibigMid) throws Exception;
}
