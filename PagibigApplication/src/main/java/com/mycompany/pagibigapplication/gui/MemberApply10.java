
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MemberApply10 extends javax.swing.JPanel {

    private JFrame parentFrame;
    private JPanel previousPanel;
    private AuthService authService;

    public MemberApply10(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
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
        int panelWidth = 500;   
        int panelHeight = 270;  
        int panelX = (contentPanel.getWidth() - panelWidth) / 2;   
        int panelY = 170;  

        RoundedPanel acknowledgementPanel = new RoundedPanel(20); 
        acknowledgementPanel.setBackground(Color.decode("#D9D9D9"));
        acknowledgementPanel.setBounds(panelX, panelY, panelWidth, panelHeight);  
        acknowledgementPanel.setLayout(null);
        contentPanel.add(acknowledgementPanel);

        ImageIcon originalIcon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/success.png");
        int newWidth = (int) (originalIcon.getIconWidth() * 0.8); 
        int newHeight = (int) (originalIcon.getIconHeight() * 0.8); 
        Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        int iconWidth = scaledIcon.getIconWidth();
        int iconHeight = scaledIcon.getIconHeight();
        int intPanelWidth = acknowledgementPanel.getWidth();
        int intPanelHeight = acknowledgementPanel.getHeight();
        int iconX = (intPanelWidth - iconWidth) / 2;
        int iconY = (intPanelHeight - iconHeight) / 4; 
        imageLabel.setBounds(iconX, iconY, iconWidth, iconHeight);
        acknowledgementPanel.add(imageLabel);

        int labelY = iconY + iconHeight + 10; 

        JLabel successLabel = new JLabel("Your house loan application has been successfully completed.");
        successLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        successLabel.setForeground(Color.BLACK);
        successLabel.setBounds(0, labelY, acknowledgementPanel.getWidth(), 25);
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        acknowledgementPanel.add(successLabel);

        JLabel instructionLabel = new JLabel("Please wait for an update and check your application status regularly.");
        instructionLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        instructionLabel.setForeground(Color.BLACK);
        instructionLabel.setBounds(0, labelY + 20, acknowledgementPanel.getWidth(), 20);
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        acknowledgementPanel.add(instructionLabel);

        JLabel valueLabel = new JLabel("We value you!");
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        valueLabel.setForeground(Color.decode("#1F41BB"));
        valueLabel.setBounds(0, labelY + 50, acknowledgementPanel.getWidth(), 20);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        acknowledgementPanel.add(valueLabel);
        
        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(Color.decode("#1F41BB"));
        homeButton.setFocusPainted(false);
        homeButton.setBounds(panelX + (panelWidth - 100)/2, panelY + panelHeight + 20, 100, 40);
        homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        homeButton.addActionListener(e -> {
            MemberDashboard dashboard = new MemberDashboard(authService);
            dashboard.setVisible(true);
            SwingUtilities.getWindowAncestor(contentPanel).dispose();
        });
        
        contentPanel.add(homeButton);
        

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
