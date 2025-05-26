
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllMemberService {
    private Connection connection;
    
    public AllMemberService(Connection connection) {
        this.connection = connection;
    }
    
    public List<Member> getAllMembers() {
        List<Member> allMembers = new ArrayList<>();
        String strQuery = "SELECT m.*, e.employerName " +
                  "FROM member m " +
                  "JOIN employer e ON m.employerId = e.employerId";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Member allMember = new Member();
                allMember.setPagibigMid(rs.getString("pagibigMid"));
                allMember.setName(rs.getString("name"));
                allMember.setCitizenship(Member.Citizenship.valueOf(rs.getString("citizenship")));
                allMember.setMaritalStatus(Member.MaritalStatus.valueOf(rs.getString("maritalStatus")));
                allMember.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                allMember.setNumberOfDependents(rs.getInt("numberOfDependents"));
                allMember.setYearsOfStayAddress(rs.getInt("yearsOfStayAddress"));
                allMember.setEmployerName(rs.getString("employerName"));
                allMember.setYearsEmployment(rs.getInt("yearsEmployment"));
                allMember.setPresentHomeAddress(rs.getString("presentHomeAddress"));
                allMember.setPermanentHomeAddress(rs.getString("permanentHomeAddress"));
                allMember.setHomePhone(rs.getString("homePhone"));
                allMember.setEmailAddress(rs.getString("emailAddress"));
                allMember.setAlternateMailingAddress(rs.getString("alternateMailingAddress"));
                allMember.setSssGsisNo(rs.getString("sssGsisNo"));
                allMember.setTin(rs.getString("tin"));
                allMember.setOccupation(rs.getString("occupation"));
                allMember.setHomeOwnership(rs.getString("homeOwnership"));
                allMember.setPositionDepartment(rs.getString("positionDepartment"));
                allMember.setCellPhone(rs.getString("cellPhone"));
                allMember.setMonthlyRent(rs.getBigDecimal("monthlyRent"));
                
                allMembers.add(allMember);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching members: ");
            e.printStackTrace();
        }
        
        return allMembers;
    }
    
}
