
package com.mycompany.pagibigapplication.services;

// import this class for member and admin login

public class AuthService {
    
    private static final String strAdminUsername = "admin1";
    private static final String strAdminPassword = "thisisadmin1";
    private static final String strMemberUsername = "102345678910";
    private static final String strMemberPassword = "samplemember1";
    
    public boolean adminLogin(String strAUsername, String strAPassword) {
        return strAdminUsername.equals(strAUsername) && strAdminPassword.equals(strAPassword);
    }
    
    public boolean memberLogin(String strMUsername, String strMPassword) {
        return strMemberUsername.equals(strMUsername) && strMemberPassword.equals(strMPassword);
    }
}
