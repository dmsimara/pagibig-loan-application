
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MemberApply9 extends javax.swing.JPanel {

    private JFrame parentFrame;
    private JPanel previousPanel;
    private AuthService authService;

    public MemberApply9(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
        this.parentFrame = parentFrame;
        this.previousPanel = previousPanel;
        this.authService = authService;
        initComponents();
        
        RoundedPanel contentPanel = new RoundedPanel(40);
        contentPanel.setBounds(0, 0, 1000, 580);  
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);  
        this.add(contentPanel);  
        
        // headlines
        JLabel applicationLabel = new JLabel("Application Form");
        applicationLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        applicationLabel.setForeground(Color.BLACK);
        applicationLabel.setBounds(20, 20, 300, 30);
        contentPanel.add(applicationLabel);
        
        int intStepX = contentPanel.getWidth() - 90;
        JLabel stepLabel = new JLabel("Step 9");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 140;
        JLabel loanLabel = new JLabel("Acknowledgement");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(9); 
        contentPanel.add(progressBar);
        
        // acknowledgement panel 
        RoundedPanel acknowledgementPanel = new RoundedPanel(20); 
        acknowledgementPanel.setBackground(Color.decode("#D9D9D9"));
        acknowledgementPanel.setBounds(150, 170, 700, 230);  
        acknowledgementPanel.setLayout(null);
        contentPanel.add(acknowledgementPanel);
        
        JLabel acknowledgementTitle = new JLabel("Acknowledgement");
        acknowledgementTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        acknowledgementTitle.setForeground(Color.decode("#1F41BB"));
        acknowledgementTitle.setBounds(20, 10, 200, 30);   
        acknowledgementPanel.add(acknowledgementTitle);
        
        JLabel infoLabel1 = new JLabel("<html>By clicking the button below, you confirm that all information you have provided is true and correct.<br>You also agree to the terms and conditions for the Pag-IBIG Housing Loan.</html>");
        infoLabel1.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoLabel1.setForeground(Color.BLACK);
        infoLabel1.setHorizontalAlignment(SwingConstants.LEFT); 
        infoLabel1.setBounds(50, 60, 600, 50); 
        acknowledgementPanel.add(infoLabel1);

        JLabel infoLabel2 = new JLabel("Please click the button below to submit your application.");
        infoLabel2.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoLabel2.setForeground(Color.BLACK);
        infoLabel2.setHorizontalAlignment(SwingConstants.LEFT); 
        infoLabel2.setBounds(50, 120, 600, 30); 
        acknowledgementPanel.add(infoLabel2);

        // buttons
        int panelWidth = acknowledgementPanel.getWidth();
        int buttonWidth = 100;
        int spacing = 20; 

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#43404066"));
        backButton.setBounds((panelWidth / 2) - buttonWidth - spacing / 2, 180, buttonWidth, 30);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setOpaque(true);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        acknowledgementPanel.add(backButton);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.decode("#1F41BB"));
        submitButton.setBounds((panelWidth / 2) + spacing / 2, 180, buttonWidth, 30);
        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.setOpaque(true);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        acknowledgementPanel.add(submitButton);

        submitButton.addActionListener(e -> {
            this.setVisible(false);  

            MemberApply10 memberApply10 = new MemberApply10(parentFrame, this, authService);
            memberApply10.setBounds(240, 70, 1000, 580);
            parentFrame.getContentPane().add(memberApply10);
            memberApply10.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();

            System.out.println("Next button clicked, moving to step 10.");
        });
        
        backButton.addActionListener(e -> {
            this.setVisible(false);
            parentFrame.getContentPane().remove(this);

            previousPanel.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();
            System.out.println("Back button clicked, returning to step 8.");
        });



    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
