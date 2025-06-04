
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

public class MemberApply4 extends javax.swing.JPanel {
    
    private final AuthService authService;
    private JPanel previousPanel;
    private JFrame parentFrame;


    public MemberApply4(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
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
        JLabel stepLabel = new JLabel("Step 4");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 80;
        JLabel loanLabel = new JLabel("Spouse");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(4); 
        contentPanel.add(progressBar);
        
        // pag-ibig mid 
        int pagibigLabelY = progressBar.getY() + progressBar.getHeight() + 10;

        JLabel pagibigLabel = new JLabel("Pag-IBIG MID");
        pagibigLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        pagibigLabel.setForeground(Color.BLACK);
        pagibigLabel.setBounds(20, pagibigLabelY, 150, 30);
        contentPanel.add(pagibigLabel);

        JTextField pagibigTextField = new JTextField();
        pagibigTextField.setBounds(20, pagibigLabelY + 30, 200, 30);
        contentPanel.add(pagibigTextField);
        
        // name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(240, pagibigLabelY, 100, 30);
        contentPanel.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240, pagibigLabelY + 30, 350, 30);
        contentPanel.add(nameTextField);
        
        // citizenship 
        JLabel citizenshipLabel = new JLabel("Citizenship");
        citizenshipLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        citizenshipLabel.setForeground(Color.BLACK);
        citizenshipLabel.setBounds(600, pagibigLabelY, 100, 30); 
        contentPanel.add(citizenshipLabel);

        String[] citizenshipOptions = {"Filipino", "Dual Citizen", "Foreign National"};
        JComboBox<String> citizenshipComboBox = new JComboBox<>(citizenshipOptions);
        citizenshipComboBox.setBounds(600, pagibigLabelY + 30, 200, 30); 
        contentPanel.add(citizenshipComboBox);
        
        // date of birth 
        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        dobLabel.setForeground(Color.BLACK);
        dobLabel.setBounds(820, pagibigLabelY, 100, 30); 
        contentPanel.add(dobLabel);

        JLabel dobFormatLabel = new JLabel("(yyyy/mm/dd)");
        dobFormatLabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        dobFormatLabel.setForeground(Color.BLACK);
        dobFormatLabel.setBounds(920, pagibigLabelY + 5, 80, 20); 
        contentPanel.add(dobFormatLabel);

        JTextField dobTextField = new JTextField();
        dobTextField.setBounds(820, pagibigLabelY + 30, 160, 30);  
        contentPanel.add(dobTextField);
        
        // TIN 
        int tinLabelY = pagibigTextField.getY() + pagibigTextField.getHeight() + 15;

        JLabel tinLabel = new JLabel("TIN");
        tinLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        tinLabel.setForeground(Color.BLACK);
        tinLabel.setBounds(20, tinLabelY, 100, 30);
        contentPanel.add(tinLabel);

        JTextField tinTextField = new JTextField();
        tinTextField.setBounds(20, tinLabelY + 30, 200, 30);
        contentPanel.add(tinTextField);

        // occupation 
        JLabel occupationLabel = new JLabel("Occupation");
        occupationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        occupationLabel.setForeground(Color.BLACK);
        occupationLabel.setBounds(250, tinLabelY, 150, 30); 
        contentPanel.add(occupationLabel);

        JPanel occupationRadioPanel = new JPanel();
        occupationRadioPanel.setLayout(new GridLayout(1, 2, 10, 0)); 
        occupationRadioPanel.setBounds(250, tinLabelY + 30, 220, 30); 
        occupationRadioPanel.setBackground(Color.WHITE);

        JRadioButton employedButton = new JRadioButton("Employed");
        employedButton.setBackground(Color.WHITE);
        JRadioButton selfEmployedButton = new JRadioButton("Self Employed");
        selfEmployedButton.setBackground(Color.WHITE);

        ButtonGroup occupationGroup = new ButtonGroup();
        occupationGroup.add(employedButton);
        occupationGroup.add(selfEmployedButton);

        occupationRadioPanel.add(employedButton);
        occupationRadioPanel.add(selfEmployedButton);
        contentPanel.add(occupationRadioPanel);

        // business phone 
        JLabel businessPhoneLabel = new JLabel("Business Phone");
        businessPhoneLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        businessPhoneLabel.setForeground(Color.BLACK);
        businessPhoneLabel.setBounds(500, tinLabelY, 150, 30);
        contentPanel.add(businessPhoneLabel);

        JTextField businessPhoneTextField = new JTextField();
        businessPhoneTextField.setBounds(500, tinLabelY + 30, 200, 30); 
        contentPanel.add(businessPhoneTextField);

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

            MemberApply5 memberApply5 = new MemberApply5(parentFrame, this, authService);
            memberApply5.setBounds(240, 70, 1000, 580);
            parentFrame.getContentPane().add(memberApply5);
            memberApply5.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();

            System.out.println("Next button clicked, moving to step 5.");
        });
        
        contentPanel.add(nextButton);

        backButton.addActionListener(e -> {
            this.setVisible(false);
            parentFrame.getContentPane().remove(this);

            previousPanel.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();
            System.out.println("Back button clicked, returning to step 3.");
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
