package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.RealEstate;
import java.util.List;

public interface RealEstateDao {
    void saveRealEstates(List<RealEstate> realEstates) throws Exception;
    List<RealEstate> getRealEstatesByRealEstateId(String housingAccountNo) throws Exception;
    List<RealEstate> getRealEstatesByApplicationNo(int applicationNo) throws Exception;
}
