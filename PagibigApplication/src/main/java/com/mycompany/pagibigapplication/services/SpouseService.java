package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Spouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpouseService {
    private Connection connection;

    public SpouseService(Connection connection) {
        this.connection = connection;
    }

    public List<Spouse> getSpouses() {
        List<Spouse> spouses = new ArrayList<>();
        String strQuery = "SELECT s.*, e.employerName, m.name AS memberName " +
                          "FROM spouse s " +
                          "JOIN employer e ON s.employerId = e.employerId " +
                          "JOIN member m ON s.pagibigMid = m.pagibigMid";

        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Spouse spouse = new Spouse();
                spouse.setStrSpousePagibigMid(rs.getString("spousePagibigMid"));
                spouse.setStrSpouseName(rs.getString("spouseName"));
                
                String citizenship = rs.getString("spouseCitizenship");
                if (citizenship != null) {
                    spouse.setEnumSpouseCitizenship(Spouse.Citizenship.valueOf(citizenship));
                }

                Date dob = rs.getDate("spouseDOB");
                if (dob != null) {
                    spouse.setDtSpouseDOB(dob.toLocalDate());
                }

                spouse.setStrSpouseTin(rs.getString("spouseTin"));
                spouse.setStrSpouseOccupation(rs.getString("spouseOccupation"));
                spouse.setStrSpouseBusinessPhone(rs.getString("spouseBusinessPhone"));
                spouse.setEmployerName(rs.getString("employerName"));
                spouse.setStrSpousePosition(rs.getString("spousePosition"));
                spouse.setIntSpouseYearsEmployment(rs.getInt("spouseYearsEmployment"));
                spouse.setMemberName(rs.getString("memberName"));

                spouses.add(spouse);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching spouses: ");
            e.printStackTrace();
        }

        return spouses;
    }
}
