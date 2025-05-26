
package com.mycompany.pagibigapplication.services;

import com.mycompany.pagibigapplication.models.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private Connection connection;
    
    public MemberService(Connection connection) {
        this.connection = connection;
    }
    
    // fetch pagibig mid and name
    public List<Member> getPagibigMidAndName() {
        List<Member> memberList = new ArrayList<>();
        String strQuery = "SELECT pagibigMid, name FROM member";
        
        try (PreparedStatement stmt = connection.prepareStatement(strQuery);
                ResultSet rs = stmt.executeQuery()) {
                
            while (rs.next()) {
                Member member = new Member();
                member.setPagibigMid(rs.getString("pagibigMid"));
                member.setName(rs.getString("name"));
                memberList.add(member);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching pagibig MID and name: ");
            e.printStackTrace();
        }
        
        return memberList;
    }
}
