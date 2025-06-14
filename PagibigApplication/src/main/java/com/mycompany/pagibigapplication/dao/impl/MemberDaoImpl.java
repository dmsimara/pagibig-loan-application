package com.mycompany.pagibigapplication.dao.impl;

import com.mycompany.pagibigapplication.dao.MemberDao;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Member;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class MemberDaoImpl implements MemberDao {

    private static final String INSERT_SQL = "INSERT INTO member (pagibigMid, name, citizenship, dateOfBirth, sex, maritalStatus, numberOfDependents, presentHomeAddress, permanentHomeAddress, homePhone, emailAddress, alternateMailingAddress, sssGsisNo, tin, occupation, homeOwnership, monthlyRent, yearsOfStayAddress, employerId, yearsEmployment, positionDepartment, cellPhone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE member SET name = ?, citizenship = ?, dateOfBirth = ?, sex = ?, maritalStatus = ?, numberOfDependents = ?, presentHomeAddress = ?, permanentHomeAddress = ?, homePhone = ?, emailAddress = ?, alternateMailingAddress = ?, sssGsisNo = ?, tin = ?, occupation = ?, homeOwnership = ?, monthlyRent = ?, yearsOfStayAddress = ?, employerId = ?, yearsEmployment = ?, positionDepartment = ?, cellPhone = ? WHERE pagibigMid = ?";
    private static final String SELECT_EMPLOYER_BY_NAME = "SELECT employerId FROM Employer WHERE LOWER(employerName) = LOWER(?)";
    private static final String INSERT_EMPLOYER = "INSERT INTO Employer (employerName, employerAddress) VALUES (?, ?)";

    @Override
    public void saveMember(Member member) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                Integer employerId = findOrInsertEmployer(conn, member.getEmployerName());
                boolean updated = updateMember(conn, member, employerId);
                if (!updated) {
                    insertMember(conn, member, employerId);
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
            throw new Exception("Error saving Member record: " + e.getMessage(), e);
        }
    }

    private Integer findOrInsertEmployer(Connection conn, String employerName) throws SQLException {
        if (employerName == null || employerName.trim().isEmpty()) {
            return null;
        }
        try (PreparedStatement selectStmt = conn.prepareStatement(SELECT_EMPLOYER_BY_NAME)) {
            selectStmt.setString(1, employerName.trim());
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("employerId");
                }
            }
        }
        try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_EMPLOYER, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, employerName.trim());
            insertStmt.setString(2, ""); // Provide a default or empty value for employerAddress
            int affectedRows = insertStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting employer failed, no rows affected.");
            }
            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting employer failed, no ID obtained.");
                }
            }
        }
    }

    private boolean updateMember(Connection conn, Member member, Integer employerId) throws SQLException {
        try (PreparedStatement updateStmt = conn.prepareStatement(UPDATE_SQL)) {
            setMemberParameters(updateStmt, member, employerId);
            updateStmt.setString(22, member.getPagibigMid());
            int affectedRows = updateStmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    private void insertMember(Connection conn, Member member, Integer employerId) throws SQLException {
        try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_SQL)) {
            setMemberParameters(insertStmt, member, employerId);
            insertStmt.executeUpdate();
        }
    }

    private void setMemberParameters(PreparedStatement stmt, Member member, Integer employerId) throws SQLException {
        stmt.setString(1, member.getPagibigMid());
        stmt.setString(2, member.getName());
        stmt.setString(3, member.getCitizenship() != null ? member.getCitizenship().name() : null);
        stmt.setDate(4, member.getDateOfBirth() != null ? Date.valueOf(member.getDateOfBirth()) : null);
        stmt.setString(5, member.getSex() != null ? member.getSex().name() : null);
        stmt.setString(6, member.getMaritalStatus() != null ? member.getMaritalStatus().name() : null);
        stmt.setInt(7, member.getNumberOfDependents());
        stmt.setString(8, member.getPresentHomeAddress());
        stmt.setString(9, member.getPermanentHomeAddress());
        stmt.setString(10, member.getHomePhone());
        stmt.setString(11, member.getEmailAddress());
        stmt.setString(12, member.getAlternateMailingAddress());
        stmt.setString(13, member.getSssGsisNo());
        stmt.setString(14, member.getTin());
        stmt.setString(15, member.getOccupation());
        stmt.setString(16, member.getHomeOwnership());
        stmt.setBigDecimal(17, member.getMonthlyRent() != null ? member.getMonthlyRent() : BigDecimal.ZERO);
        stmt.setInt(18, member.getYearsOfStayAddress());
        stmt.setObject(19, employerId, Types.INTEGER);
        stmt.setInt(20, member.getYearsEmployment());
        stmt.setString(21, member.getPositionDepartment());
    }

    @Override
    public Member getMemberByPagibigMid(String pagibigMid) throws Exception {
        Member member = null;
        String sql = "SELECT pagibigMid, name, citizenship, dateOfBirth, sex, maritalStatus, numberOfDependents, presentHomeAddress, permanentHomeAddress, homePhone, emailAddress, alternateMailingAddress, sssGsisNo, tin, occupation, homeOwnership, monthlyRent, yearsOfStayAddress, employerId, yearsEmployment, positionDepartment, cellPhone FROM member WHERE pagibigMid = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pagibigMid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    member = new Member();
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
                    member.setEmailAddress(rs.getString("emailAddress"));
                    member.setAlternateMailingAddress(rs.getString("alternateMailingAddress"));
                    member.setSssGsisNo(rs.getString("sssGsisNo"));
                    member.setTin(rs.getString("tin"));
                    member.setOccupation(rs.getString("occupation"));
                    member.setHomeOwnership(rs.getString("homeOwnership"));
                    member.setMonthlyRent(rs.getBigDecimal("monthlyRent"));
                    member.setYearsOfStayAddress(rs.getInt("yearsOfStayAddress"));
                    member.setEmployerId(rs.getInt("employerId"));
                    member.setYearsEmployment(rs.getInt("yearsEmployment"));
                    member.setPositionDepartment(rs.getString("positionDepartment"));
                    member.setCellPhone(rs.getString("cellPhone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving Member by pagibigMid: " + e.getMessage(), e);
        }
        return member;
    }
}
