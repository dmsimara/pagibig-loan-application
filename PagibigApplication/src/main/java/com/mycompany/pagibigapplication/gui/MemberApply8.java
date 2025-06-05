
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MemberApply8 extends javax.swing.JPanel {

    private final AuthService authService;
    private JPanel previousPanel;
    private JFrame parentFrame;

    public MemberApply8(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
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
        JLabel stepLabel = new JLabel("Step 8");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 90;
        JLabel loanLabel = new JLabel("Employer");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(8); 
        contentPanel.add(progressBar);
        
        // employer name
        JLabel employerNameLabel = new JLabel("Employer Name");
        employerNameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        employerNameLabel.setForeground(Color.BLACK);
        employerNameLabel.setBounds(20, 160, 200, 30); 
        contentPanel.add(employerNameLabel);

        JTextField employerNameField = new JTextField();
        employerNameField.setBounds(20, 200, 200, 30);
        contentPanel.add(employerNameField);
        
        // employer address
        JLabel employerAddressLabel = new JLabel("Employer Address");
        employerAddressLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        employerAddressLabel.setForeground(Color.BLACK);
        employerAddressLabel.setBounds(240, 160, 200, 30);  
        contentPanel.add(employerAddressLabel);

        JTextField employerAddressField = new JTextField();
        employerAddressField.setBounds(240, 200, 300, 30);  
        contentPanel.add(employerAddressField);

        // employer email
        JLabel employerEmailLabel = new JLabel("Employer Email");
        employerEmailLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        employerEmailLabel.setForeground(Color.BLACK);
        employerEmailLabel.setBounds(560, 160, 200, 30);  
        contentPanel.add(employerEmailLabel);

        JTextField employerEmailField = new JTextField();
        employerEmailField.setBounds(560, 200, 200, 30);  
        contentPanel.add(employerEmailField);

        // employer phone direct
        JLabel employerPhoneLabel = new JLabel("Employer Phone Direct");
        employerPhoneLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        employerPhoneLabel.setForeground(Color.BLACK);
        employerPhoneLabel.setBounds(780, 160, 200, 30);  
        contentPanel.add(employerPhoneLabel);

        JTextField employerPhoneField = new JTextField();
        employerPhoneField.setBounds(780, 200, 200, 30);  
        contentPanel.add(employerPhoneField);

        // employer phone trunk
        JLabel employerPhoneTrunkLabel = new JLabel("Employer Phone Trunk");
        employerPhoneTrunkLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        employerPhoneTrunkLabel.setForeground(Color.BLACK);
        employerPhoneTrunkLabel.setBounds(20, 250, 200, 30);  
        contentPanel.add(employerPhoneTrunkLabel);

        JTextField employerPhoneTrunkField = new JTextField();
        employerPhoneTrunkField.setBounds(20, 290, 200, 30);  
        contentPanel.add(employerPhoneTrunkField);

        // industry
        JLabel industryLabel = new JLabel("Industry");
        industryLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        industryLabel.setForeground(Color.BLACK);
        industryLabel.setBounds(240, 250, 200, 30);   
        contentPanel.add(industryLabel);

        JTextField industryField = new JTextField();
        industryField.setBounds(240, 290, 200, 30);   
        contentPanel.add(industryField);

        // preferred contact time
        JLabel contactTimeLabel = new JLabel("Preferred Contact Time");
        contactTimeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        contactTimeLabel.setForeground(Color.BLACK);
        contactTimeLabel.setBounds(460, 250, 200, 30);  
        contentPanel.add(contactTimeLabel);

        JRadioButton morningOption = new JRadioButton("9:00 a.m. - 12:00 p.m.");
        morningOption.setBounds(460, 290, 200, 25);
        morningOption.setBackground(Color.WHITE);
        contentPanel.add(morningOption);

        JRadioButton afternoonOption = new JRadioButton("1:00 p.m. - 5:00 p.m.");
        afternoonOption.setBounds(460, 320, 200, 25);
        afternoonOption.setBackground(Color.WHITE);
        contentPanel.add(afternoonOption);

        JRadioButton eveningOption = new JRadioButton("6:00 p.m. - 9:00 p.m.");
        eveningOption.setBounds(460, 350, 200, 25);
        eveningOption.setBackground(Color.WHITE);
        contentPanel.add(eveningOption);

        ButtonGroup contactTimeGroup = new ButtonGroup();
        contactTimeGroup.add(morningOption);
        contactTimeGroup.add(afternoonOption);
        contactTimeGroup.add(eveningOption);

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

            MemberApply9 memberApply9 = new MemberApply9(parentFrame, this, authService);
            memberApply9.setBounds(240, 70, 1000, 580);
            parentFrame.getContentPane().add(memberApply9);
            memberApply9.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();

            System.out.println("Next button clicked, moving to step 9.");
        });
        
        contentPanel.add(nextButton);

        backButton.addActionListener(e -> {
            this.setVisible(false);
            parentFrame.getContentPane().remove(this);

            previousPanel.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();
            System.out.println("Back button clicked, returning to step 7.");
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
