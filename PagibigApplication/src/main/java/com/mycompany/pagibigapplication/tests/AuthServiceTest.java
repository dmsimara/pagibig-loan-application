package com.mycompany.pagibigapplication.tests;

import com.mycompany.pagibigapplication.services.AuthService;

public class AuthServiceTest {
    public static void main(String[] args) {
        AuthService authService = new AuthService();

        // Test correct admin login
        boolean success1 = authService.adminLogin("admin1", "thisisadmin1");
        System.out.println("Test 1 (correct credentials): " + (success1 ? "Passed" : "Failed"));

        // Test incorrect username
        boolean success2 = authService.adminLogin("wronguser", "admin123");
        System.out.println("Test 2 (wrong username): " + (!success2 ? "Passed" : "Failed"));

        // Test incorrect password
        boolean success3 = authService.adminLogin("admin", "wrongpass");
        System.out.println("Test 3 (wrong password): " + (!success3 ? "Passed" : "Failed"));

        // Test both wrong
        boolean success4 = authService.adminLogin("wronguser", "wrongpass");
        System.out.println("Test 4 (both wrong): " + (!success4 ? "Passed" : "Failed"));
    }
}
