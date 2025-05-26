package com.mycompany.pagibigapplication.tests;

import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.models.Employer;
import com.mycompany.pagibigapplication.services.EmployerService;


import java.sql.Connection;
import java.util.List;

public class AuthServiceTest {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            EmployerService employerService = new EmployerService(conn);

            // Fetch all loan applications
            List<Employer> employersList = employerService.getEmployers();

            // Print the results
            for (Employer employer : employersList) {
                System.out.println("Employer ID: " + employer.getEmployerId());
                System.out.println("Phone (Direct): " + employer.getEmployerPhoneDirect());
                System.out.println("Phone (Trunk): " + employer.getEmployerPhoneTrunk());
                System.out.println("Email: " + employer.getEmployerEmail());
                System.out.println("Name: " + employer.getEmployerName());
                System.out.println("Address: " + employer.getEmployerAddress());
                System.out.println("Industry: " + employer.getIndustry());
                System.out.println("Preferred Contact Time: " + employer.getPreferredContactTime());
                System.out.println("---------------");
            }


            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
