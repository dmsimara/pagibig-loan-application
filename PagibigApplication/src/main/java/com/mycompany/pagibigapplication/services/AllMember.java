package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Member;

import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AllMember {
    private Connection connection;

    public AllMember(Connection connection) {
        this.connection = connection;
    }

    public List<Member> getAllMembers() throws SQLException {
        List<Member> members = new ArrayList<>();

        String query = "SELECT m.*, e.employerName " +
                       "FROM member m " +
                       "LEFT JOIN employer e ON m.employerId = e.employerId";

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Member member = new Member();

                member.setPagibigMid(rs.getString("pagibigMid"));
                member.setName(rs.getString("name"));

                String citizenshipStr = rs.getString("citizenship");
                if (citizenshipStr != null) {
                    member.setCitizenship(Member.Citizenship.valueOf(citizenshipStr));
                }

                Date dob = rs.getDate("dateOfBirth");
                if (dob != null) {
                    member.setDateOfBirth(dob.toLocalDate());
                }

                String sexStr = rs.getString("sex");
                if (sexStr != null) {
                    member.setSex(Member.Sex.valueOf(sexStr));
                }

                String maritalStatusStr = rs.getString("maritalStatus");
                if (maritalStatusStr != null) {
                    member.setMaritalStatus(Member.MaritalStatus.valueOf(maritalStatusStr));
                }

                member.setNumberOfDependents(rs.getInt("numberOfDependents"));
                member.setPresentHomeAddress(rs.getString("presentHomeAddress"));
                member.setPermanentHomeAddress(rs.getString("permanentHomeAddress"));
                member.setHomePhone(rs.getString("homePhone"));
                member.setCellPhone(rs.getString("cellPhone"));
                member.setEmailAddress(rs.getString("emailAddress"));
                member.setAlternateMailingAddress(rs.getString("alternateMailingAddress"));
                member.setSssGsisNo(rs.getString("sssGsisNo"));
                member.setTin(rs.getString("tin"));
                member.setOccupation(rs.getString("occupation"));
                member.setHomeOwnership(rs.getString("homeOwnership"));

                BigDecimal monthlyRent = rs.getBigDecimal("monthlyRent");
                member.setMonthlyRent(monthlyRent);

                member.setYearsOfStayAddress(rs.getInt("yearsOfStayAddress"));
                member.setEmployerId(rs.getInt("employerId"));

                String employerName = rs.getString("employerName");
                member.setEmployerName(employerName);

                member.setYearsEmployment(rs.getInt("yearsEmployment"));
                member.setPositionDepartment(rs.getString("positionDepartment"));

                members.add(member);
            }
        }

        return members;
    }
}
