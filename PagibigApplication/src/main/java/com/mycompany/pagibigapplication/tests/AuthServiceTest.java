package com.mycompany.pagibigapplication.tests;

import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Application;
import com.mycompany.pagibigapplication.services.ApplicationService;


import java.sql.Connection;
import java.util.List;

public class AuthServiceTest {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            ApplicationService applicationService = new ApplicationService(conn);

            // Fetch all loan applications
            List<Application> applicationsList = applicationService.getApplications();

            // Print the results
            for (Application app : applicationsList) {
                System.out.println("Application No: " + app.getApplicationNo());
                System.out.println("Pagibig MID: " + app.getPagibigMid());
                System.out.println("Member Name: " + app.getMemberName());
                System.out.println("Date Submitted: " + app.getDateSubmitted());
                System.out.println("Status: " + app.getStatus());
               
                System.out.println("---------------");
            }


            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
