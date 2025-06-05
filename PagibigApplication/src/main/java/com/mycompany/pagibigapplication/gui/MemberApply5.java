
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MemberApply5 extends javax.swing.JPanel {
    
    private JFrame parentFrame;
    private JPanel previousPanel;
    private AuthService authService;

    public MemberApply5(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
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
        JLabel stepLabel = new JLabel("Step 5");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 120;
        JLabel loanLabel = new JLabel("Bank Accounts");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(5); 
        contentPanel.add(progressBar);
        
        // account no. 
        int accountNoLabelY = progressBar.getY() + progressBar.getHeight() + 10;

        JLabel accountNoLabel = new JLabel("Account No.");
        accountNoLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        accountNoLabel.setForeground(Color.BLACK);
        accountNoLabel.setBounds(20, accountNoLabelY, 150, 30);
        contentPanel.add(accountNoLabel);

        // bank name 
        JLabel bankNameLabel = new JLabel("Bank Name");
        bankNameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        bankNameLabel.setForeground(Color.BLACK);
        bankNameLabel.setBounds(250, accountNoLabelY, 150, 30);
        contentPanel.add(bankNameLabel);

        JLabel bankNameSublabel = new JLabel("(Indicate your 3 most active)");
        bankNameSublabel.setFont(new Font("SansSerif", Font.PLAIN, 9));
        bankNameSublabel.setForeground(Color.BLACK);
        bankNameSublabel.setBounds(250, accountNoLabelY + 30, 200, 20);
        contentPanel.add(bankNameSublabel);
        
        // bank branch 
        JLabel bankBranchLabel = new JLabel("Bank Branch");
        bankBranchLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        bankBranchLabel.setForeground(Color.BLACK);
        bankBranchLabel.setBounds(480, accountNoLabelY, 150, 30);
        contentPanel.add(bankBranchLabel);
        
        // date opened
        JLabel dateOpenedLabel = new JLabel("Date Opened");
        dateOpenedLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        dateOpenedLabel.setForeground(Color.BLACK);
        dateOpenedLabel.setBounds(790, accountNoLabelY, 150, 30); 
        contentPanel.add(dateOpenedLabel);
        
        JLabel accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        accountTypeLabel.setForeground(Color.BLACK);
        accountTypeLabel.setBounds(20, 340, 150, 30);
        contentPanel.add(accountTypeLabel);

        // average balance
        JLabel averageBalanceLabel = new JLabel("Average Balance");
        averageBalanceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        averageBalanceLabel.setForeground(Color.BLACK);
        averageBalanceLabel.setBounds(250, 340, 150, 30);  
        contentPanel.add(averageBalanceLabel);
        

        int firstRowY = accountNoLabelY + 50; 

        JTextField accountNoTextField1 = new JTextField();
        accountNoTextField1.setBounds(20, firstRowY, 200, 30);
        contentPanel.add(accountNoTextField1);
        JTextField accountNoTextField2 = new JTextField();
        accountNoTextField2.setBounds(20, firstRowY + 40, 200, 30);
        contentPanel.add(accountNoTextField2);
        JTextField accountNoTextField3 = new JTextField();
        accountNoTextField3.setBounds(20, firstRowY + 80, 200, 30);
        contentPanel.add(accountNoTextField3);

        JTextField bankNameTextField1 = new JTextField();
        bankNameTextField1.setBounds(250, firstRowY, 200, 30);
        contentPanel.add(bankNameTextField1);
        JTextField bankNameTextField2 = new JTextField();
        bankNameTextField2.setBounds(250, firstRowY + 40, 200, 30);
        contentPanel.add(bankNameTextField2);
        JTextField bankNameTextField3 = new JTextField();
        bankNameTextField3.setBounds(250, firstRowY + 80, 200, 30);
        contentPanel.add(bankNameTextField3);

        JTextField bankBranchTextField1 = new JTextField();
        bankBranchTextField1.setBounds(480, firstRowY, 300, 30);
        contentPanel.add(bankBranchTextField1);
        JTextField bankBranchTextField2 = new JTextField();
        bankBranchTextField2.setBounds(480, firstRowY + 40, 300, 30);
        contentPanel.add(bankBranchTextField2);
        JTextField bankBranchTextField3 = new JTextField();
        bankBranchTextField3.setBounds(480, firstRowY + 80, 300, 30);
        contentPanel.add(bankBranchTextField3);

        JTextField dateOpenedTextField1 = new JTextField();
        dateOpenedTextField1.setBounds(790, firstRowY, 200, 30);
        contentPanel.add(dateOpenedTextField1);
        JTextField dateOpenedTextField2 = new JTextField();
        dateOpenedTextField2.setBounds(790, firstRowY + 40, 200, 30);
        contentPanel.add(dateOpenedTextField2);
        JTextField dateOpenedTextField3 = new JTextField();
        dateOpenedTextField3.setBounds(790, firstRowY + 80, 200, 30);
        contentPanel.add(dateOpenedTextField3);
        
        JRadioButton savingsRadio1 = new JRadioButton("Savings");
        savingsRadio1.setBounds(20, 380, 100, 25);
        savingsRadio1.setBackground(Color.WHITE);
        contentPanel.add(savingsRadio1);
        JRadioButton savingsRadio2 = new JRadioButton("Savings");
        savingsRadio2.setBounds(20, 410, 100, 25);
        savingsRadio2.setBackground(Color.WHITE);
        contentPanel.add(savingsRadio2);
        JRadioButton savingsRadio3 = new JRadioButton("Savings");
        savingsRadio3.setBounds(20, 440, 100, 25);
        savingsRadio3.setBackground(Color.WHITE);
        contentPanel.add(savingsRadio3);
        
        JRadioButton checkingRadio1 = new JRadioButton("Checking");
        checkingRadio1.setBounds(140, 380, 100, 25);
        checkingRadio1.setBackground(Color.WHITE);
        contentPanel.add(checkingRadio1);
        JRadioButton checkingRadio2 = new JRadioButton("Checking");
        checkingRadio2.setBounds(140, 410, 100, 25);
        checkingRadio2.setBackground(Color.WHITE);
        contentPanel.add(checkingRadio2);
        JRadioButton checkingRadio3 = new JRadioButton("Checking");
        checkingRadio3.setBounds(140, 440, 100, 25);
        checkingRadio3.setBackground(Color.WHITE);
        contentPanel.add(checkingRadio3);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(savingsRadio1);
        group1.add(checkingRadio1);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(savingsRadio2);
        group2.add(checkingRadio2);
        ButtonGroup group3 = new ButtonGroup();
        group3.add(savingsRadio3);
        group3.add(checkingRadio3);

        JTextField averageBalanceTextField1 = new JTextField();
        averageBalanceTextField1.setBounds(250, 380, 200, 30);
        contentPanel.add(averageBalanceTextField1);
        JTextField averageBalanceTextField2 = new JTextField();
        averageBalanceTextField2.setBounds(250, 420, 200, 30);
        contentPanel.add(averageBalanceTextField2);
        JTextField averageBalanceTextField3 = new JTextField();
        averageBalanceTextField3.setBounds(250, 460, 200, 30);
        contentPanel.add(averageBalanceTextField3);

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

            MemberApply6 memberApply6 = new MemberApply6(parentFrame, this, authService);
            memberApply6.setBounds(240, 70, 1000, 580);
            parentFrame.getContentPane().add(memberApply6);
            memberApply6.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();

            System.out.println("Next button clicked, moving to step 6.");
        });
        
        contentPanel.add(nextButton);

        backButton.addActionListener(e -> {
            this.setVisible(false);
            parentFrame.getContentPane().remove(this);

            previousPanel.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();
            System.out.println("Back button clicked, returning to step 4.");
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
