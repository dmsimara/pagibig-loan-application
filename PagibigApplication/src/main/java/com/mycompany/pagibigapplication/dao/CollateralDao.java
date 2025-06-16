package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.Collateral;

public interface CollateralDao {
    void saveCollateral(Collateral collateral) throws Exception;
    Collateral getCollateralByTctOctCctNo(String tctOctCctNo) throws Exception;
    Collateral getCollateralByHousingAccountNo(String housingAccountNo) throws Exception;
    Collateral getCollateralByApplicationNo(int applicationNo) throws Exception;
}