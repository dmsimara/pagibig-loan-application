package com.mycompany.pagibigapplication.dao;

import com.mycompany.pagibigapplication.models.Member;

public interface MemberDao {
    void saveMember(Member member) throws Exception;
    Member getMemberByPagibigMid(String pagibigMid) throws Exception;
}
