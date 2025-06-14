package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.RealEstateDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.RealEstate;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RealEstateDaoImpl implements RealEstateDao {

    private static final String INSERT_SQL = "INSERT INTO real_estate (realEstateId, realEstateLocation, realEstateType, housingAccountNo, acquisitionCost, marketValue, mortgageBalance, rentalIncome) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE real_estate SET realEstateLocation = ?, realEstateType = ?, housingAccountNo = ?, acquisitionCost = ?, marketValue = ?, mortgageBalance = ?, rentalIncome = ? WHERE realEstateId = ?";
    private static final String SELECT_BY_HOUSING_ACCOUNT_NO_SQL = "SELECT realEstateId, realEstateLocation, realEstateType, housingAccountNo, acquisitionCost, marketValue, mortgageBalance, rentalIncome FROM real_estate WHERE housingAccountNo = ?";
    private static final String SELECT_MAX_REAL_ESTATE_ID_SQL = "SELECT realEstateId FROM real_estate ORDER BY realEstateId DESC LIMIT 1";
    private static final String SELECT_BY_REAL_ESTATE_ID_SQL = "SELECT realEstateId FROM real_estate WHERE realEstateId = ?";

    @Override
    public void saveRealEstates(List<RealEstate> realEstates) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                for (RealEstate realEstate : realEstates) {
                    if (realEstate.getStrRealEstateId() == null || realEstate.getStrRealEstateId().isEmpty()) {
                        String nextRealEstateId = getNextRealEstateId(conn);
                        realEstate.setStrRealEstateId(nextRealEstateId);
                    }
                    if (existsByRealEstateId(conn, realEstate.getStrRealEstateId())) {
                        updateRealEstate(conn, realEstate);
                    } else {
                        insertRealEstate(conn, realEstate);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving RealEstate records: " + e.getMessage(), e);
        }
    }

    @Override
    public List<RealEstate> getRealEstatesByRealEstateId(String housingAccountNo) throws Exception {
        List<RealEstate> realEstates = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_HOUSING_ACCOUNT_NO_SQL)) {
            stmt.setString(1, housingAccountNo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RealEstate realEstate = mapResultSetToRealEstate(rs);
                    realEstates.add(realEstate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving RealEstates by housingAccountNo: " + e.getMessage(), e);
        }
        return realEstates;
    }

    private String getNextRealEstateId(Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_MAX_REAL_ESTATE_ID_SQL);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String lastRealEstateId = rs.getString("realEstateId");
                int lastNumber = Integer.parseInt(lastRealEstateId.substring(1));
                int nextNumber = lastNumber + 1;
                return String.format("R%03d", nextNumber);
            } else {
                return "R001";
            }
        }
    }

    private boolean existsByRealEstateId(Connection conn, String realEstateId) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_BY_REAL_ESTATE_ID_SQL)) {
            stmt.setString(1, realEstateId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private void insertRealEstate(Connection conn, RealEstate realEstate) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, realEstate.getStrRealEstateId());
            stmt.setString(2, realEstate.getStrRealEstateLocation());
            stmt.setString(3, realEstate.getEnumRealEstateType() != null ? realEstate.getEnumRealEstateType().name().replace("_", " ") : null);
            stmt.setString(4, realEstate.getStrHousingAccountNo());
            stmt.setBigDecimal(5, realEstate.getBdAcquisitionCost());
            stmt.setBigDecimal(6, realEstate.getBdMarketValue());
            stmt.setBigDecimal(7, realEstate.getBdMortgageBalance());
            stmt.setBigDecimal(8, realEstate.getBdRentalIncome());
            stmt.executeUpdate();
        }
    }

    private void updateRealEstate(Connection conn, RealEstate realEstate) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            stmt.setString(1, realEstate.getStrRealEstateLocation());
            stmt.setString(2, realEstate.getEnumRealEstateType() != null ? realEstate.getEnumRealEstateType().name().replace("_", " ") : null);
            stmt.setString(3, realEstate.getStrHousingAccountNo());
            stmt.setBigDecimal(4, realEstate.getBdAcquisitionCost());
            stmt.setBigDecimal(5, realEstate.getBdMarketValue());
            stmt.setBigDecimal(6, realEstate.getBdMortgageBalance());
            stmt.setBigDecimal(7, realEstate.getBdRentalIncome());
            stmt.setString(8, realEstate.getStrRealEstateId());
            stmt.executeUpdate();
        }
    }

    private RealEstate mapResultSetToRealEstate(ResultSet rs) throws SQLException {
        RealEstate realEstate = new RealEstate();
        realEstate.setStrRealEstateId(rs.getString("realEstateId"));
        realEstate.setStrRealEstateLocation(rs.getString("realEstateLocation"));
        String realEstateTypeStr = rs.getString("realEstateType");
        if (realEstateTypeStr != null) {
            try {
                realEstate.setEnumRealEstateType(RealEstate.RealEstateType.fromString(realEstateTypeStr));
            } catch (IllegalArgumentException e) {
                realEstate.setEnumRealEstateType(null);
            }
        } else {
            realEstate.setEnumRealEstateType(null);
        }
        realEstate.setStrHousingAccountNo(rs.getString("housingAccountNo"));
        realEstate.setBdAcquisitionCost(rs.getBigDecimal("acquisitionCost"));
        realEstate.setBdMarketValue(rs.getBigDecimal("marketValue"));
        realEstate.setBdMortgageBalance(rs.getBigDecimal("mortgageBalance"));
        realEstate.setBdRentalIncome(rs.getBigDecimal("rentalIncome"));
        return realEstate;
    }
}
