package com.mycompany.pagibigapplication.tests;

import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Application;
import com.mycompany.pagibigapplication.services.MemberApplication;

import java.sql.Connection;
import java.util.List;

public class AuthServiceTest {
    public static void main(String[] args) {
        try {
            // Get DB connection
            Connection conn = DBConnection.getConnection();

            // Create MemberApplication service with injected connection
            MemberApplication memberAppService = new MemberApplication(conn);

            // Test with specific member name
            String testMemberName = "123456789012";
            List<Application> applicationsList = memberAppService.getApplicationsForMember(testMemberName);

            // Print the fetched application details
            if (applicationsList.isEmpty()) {
                System.out.println("No applications found for member name: " + testMemberName);
            } else {
                for (Application app : applicationsList) {
                    System.out.println("Application No: " + app.getApplicationNo());
                    System.out.println("Pagibig MID: " + app.getPagibigMid());
                    System.out.println("Member Name: " + app.getMemberName());
                    System.out.println("Date Submitted: " + app.getDateSubmitted());
                    System.out.println("Status: " + app.getStatus());
                    System.out.println("---------------");
                }
            }

            // Close the connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
