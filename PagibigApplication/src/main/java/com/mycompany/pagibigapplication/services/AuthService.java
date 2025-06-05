
package com.mycompany.pagibigapplication.services;

// import this class for member and admin login

public class AuthService {
    
    private static final String strAdminUsername = "admin1";
    private static final String strAdminPassword = "thisisadmin1";
    private static final String strMemberUsername = "123456789012";
    private static final String strMemberPassword = "samplemember1";
    
    private static String strCurrentUser = null;
    private static String strCurrentUserRole = null;
    
    public boolean adminLogin(String strAUsername, String strAPassword) {
        boolean valid = strAdminUsername.equals(strAUsername) && strAdminPassword.equals(strAPassword);
        
        if (valid) {
            strCurrentUser = strAUsername;
            strCurrentUserRole = "admin";
        }
        
        return valid;
    }
    
    public boolean memberLogin(String strMUsername, String strMPassword) {
        boolean valid = strMemberUsername.equals(strMUsername) && strMemberPassword.equals(strMPassword);
        
        if (valid) {
            strCurrentUser = strMUsername;
            strCurrentUserRole = "member";
        }
        
        return valid;
    }
    
    public void logout() {
        strCurrentUser = null;
        strCurrentUserRole = null;
    }
    
    public boolean isLoggedIn() {
        return strCurrentUser != null;
    }
    
    public String getCurrentUser() {
        return strCurrentUser;
    }
    
    public String getCurrentUserRole() {
        return strCurrentUserRole;
    }
}
