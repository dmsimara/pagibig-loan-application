
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberApply7 extends javax.swing.JPanel {

    private JFrame parentFrame;
    private JPanel previousPanel;
    private AuthService authService;
  
    public MemberApply7(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
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
        JLabel stepLabel = new JLabel("Step 7");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 140;
        JLabel loanLabel = new JLabel("Outstanding Credit");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(7); 
        contentPanel.add(progressBar);
        
        // Creditor Name
        JLabel creditorNameLabel = new JLabel("Creditor Name");
        creditorNameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        creditorNameLabel.setForeground(Color.BLACK);
        creditorNameLabel.setBounds(20, 160, 200, 30);  
        contentPanel.add(creditorNameLabel);

        JTextField creditorField1 = new JTextField();
        creditorField1.setBounds(20, 200, 200, 30);
        contentPanel.add(creditorField1);
        JTextField creditorField2 = new JTextField();
        creditorField2.setBounds(20, 240, 200, 30);
        contentPanel.add(creditorField2);
        JTextField creditorField3 = new JTextField();
        creditorField3.setBounds(20, 280, 200, 30);
        contentPanel.add(creditorField3);
        
        // Creditor Address
        JLabel creditorAddressLabel = new JLabel("Creditor Address");
        creditorAddressLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        creditorAddressLabel.setForeground(Color.BLACK);
        creditorAddressLabel.setBounds(240, 160, 200, 30); 
        contentPanel.add(creditorAddressLabel);

        JTextField creditorAddressField1 = new JTextField();
        creditorAddressField1.setBounds(240, 200, 300, 30);
        contentPanel.add(creditorAddressField1);
        JTextField creditorAddressField2 = new JTextField();
        creditorAddressField2.setBounds(240, 240, 300, 30);
        contentPanel.add(creditorAddressField2);
        JTextField creditorAddressField3 = new JTextField();
        creditorAddressField3.setBounds(240, 280, 300, 30);
        contentPanel.add(creditorAddressField3);

        // Security
        JLabel securityLabel = new JLabel("Security");
        securityLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        securityLabel.setForeground(Color.BLACK);
        securityLabel.setBounds(560, 160, 200, 30); // aligned horizontally with creditorAddressLabel
        contentPanel.add(securityLabel);

        String[] securityOptions = {
            "",
            "REAL_ESTATE_MORTGAGE",
            "CHATTEL_MORTGAGE",
            "POST_DATED_CHECKS",
            "CO_MAKER_GUARANTEE",
            "NONE"
        };

        JComboBox<String> securityBox1 = new JComboBox<>(securityOptions);
        securityBox1.setBounds(560, 200, 200, 30);
        contentPanel.add(securityBox1);
        JComboBox<String> securityBox2 = new JComboBox<>(securityOptions);
        securityBox2.setBounds(560, 240, 200, 30);
        contentPanel.add(securityBox2);
        JComboBox<String> securityBox3 = new JComboBox<>(securityOptions);
        securityBox3.setBounds(560, 280, 200, 30);
        contentPanel.add(securityBox3);
        
        // type of loan
        JLabel typeOfLoanLabel = new JLabel("Type of Loan");
        typeOfLoanLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        typeOfLoanLabel.setForeground(Color.BLACK);
        typeOfLoanLabel.setBounds(780, 160, 200, 30);  
        contentPanel.add(typeOfLoanLabel);

        String[] loanTypes = {
            "",
            "CREDIT_CARD",
            "PERSONAL_LOAN",
            "CAR_LOAN",
            "HOUSING_LOAN",
            "SALARY_LOAN",
            "BUSINESS_LOAN",
            "OTHERS"
        };

        JComboBox<String> loanTypeBox1 = new JComboBox<>(loanTypes);
        loanTypeBox1.setBounds(780, 200, 200, 30);
        contentPanel.add(loanTypeBox1);
        JComboBox<String> loanTypeBox2 = new JComboBox<>(loanTypes);
        loanTypeBox2.setBounds(780, 240, 200, 30);
        contentPanel.add(loanTypeBox2);
        JComboBox<String> loanTypeBox3 = new JComboBox<>(loanTypes);
        loanTypeBox3.setBounds(780, 280, 200, 30);
        contentPanel.add(loanTypeBox3);

        // maturity date
        JLabel maturityDateLabel = new JLabel("Maturity Date");
        maturityDateLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        maturityDateLabel.setForeground(Color.BLACK);
        maturityDateLabel.setBounds(20, 330, 200, 30); 
        contentPanel.add(maturityDateLabel);

        JTextField maturityDateField1 = new JTextField();
        maturityDateField1.setBounds(20, 370, 200, 30);
        contentPanel.add(maturityDateField1);
        JTextField maturityDateField2 = new JTextField();
        maturityDateField2.setBounds(20, 410, 200, 30);
        contentPanel.add(maturityDateField2);
        JTextField maturityDateField3 = new JTextField();
        maturityDateField3.setBounds(20, 450, 200, 30);
        contentPanel.add(maturityDateField3);
        
        // outstanding balance
        JLabel outstandingBalanceLabel = new JLabel("Outstanding Balance");
        outstandingBalanceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        outstandingBalanceLabel.setForeground(Color.BLACK);
        outstandingBalanceLabel.setBounds(240, 330, 200, 30);  
        contentPanel.add(outstandingBalanceLabel);

        JTextField outstandingBalanceField1 = new JTextField();
        outstandingBalanceField1.setBounds(240, 370, 200, 30);
        contentPanel.add(outstandingBalanceField1);
        JTextField outstandingBalanceField2 = new JTextField();
        outstandingBalanceField2.setBounds(240, 410, 200, 30);
        contentPanel.add(outstandingBalanceField2);
        JTextField outstandingBalanceField3 = new JTextField();
        outstandingBalanceField3.setBounds(240, 450, 200, 30);
        contentPanel.add(outstandingBalanceField3);

        // monthly amortization
        JLabel monthlyAmortizationLabel = new JLabel("Monthly Amortization");
        monthlyAmortizationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        monthlyAmortizationLabel.setForeground(Color.BLACK);
        monthlyAmortizationLabel.setBounds(460, 330, 200, 30); 
        contentPanel.add(monthlyAmortizationLabel);

        JTextField monthlyAmortizationField1 = new JTextField();
        monthlyAmortizationField1.setBounds(460, 370, 200, 30);
        contentPanel.add(monthlyAmortizationField1);

        JTextField monthlyAmortizationField2 = new JTextField();
        monthlyAmortizationField2.setBounds(460, 410, 200, 30);
        contentPanel.add(monthlyAmortizationField2);

        JTextField monthlyAmortizationField3 = new JTextField();
        monthlyAmortizationField3.setBounds(460, 450, 200, 30);
        contentPanel.add(monthlyAmortizationField3);

        // Next Button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.decode("#1F41BB"));
        nextButton.setBounds(contentPanel.getWidth() - 100, contentPanel.getHeight() - 50, 70, 30);
        nextButton.setFocusPainted(false);
        nextButton.setBorderPainted(false);
        nextButton.setOpaque(true);
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14));  
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#43404066")); 
        backButton.setBounds(nextButton.getX() - 80 - 10, nextButton.getY(), 70, 30);  
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setOpaque(true);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        nextButton.addActionListener(e -> {
            this.setVisible(false);  

            MemberApply8 memberApply8 = new MemberApply8(parentFrame, this, authService);
            memberApply8.setBounds(240, 70, 1000, 580);
            parentFrame.getContentPane().add(memberApply8);
            memberApply8.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();

            System.out.println("Next button clicked, moving to step 8.");
        });
        
        contentPanel.add(nextButton);

        backButton.addActionListener(e -> {
            this.setVisible(false);
            parentFrame.getContentPane().remove(this);

            previousPanel.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();
            System.out.println("Back button clicked, returning to step 6.");
        });

        contentPanel.add(backButton);

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
