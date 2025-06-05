
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

public class MemberApply6 extends javax.swing.JPanel {

    private final AuthService authService;
    private JPanel previousPanel;
    private JFrame parentFrame;

    public MemberApply6(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
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
        JLabel stepLabel = new JLabel("Step 6");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 140;
        JLabel loanLabel = new JLabel("Real State Owned");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(6); 
        contentPanel.add(progressBar);
        
        // real state location 
        JLabel realStateLocationLabel = new JLabel("Real State Location");
        realStateLocationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        realStateLocationLabel.setForeground(Color.BLACK);
        realStateLocationLabel.setBounds(20, 160, 250, 30);  
        contentPanel.add(realStateLocationLabel);

        JTextField locationField1 = new JTextField();
        locationField1.setBounds(20, 200, 380, 30);   
        contentPanel.add(locationField1);
        JTextField locationField2 = new JTextField();
        locationField2.setBounds(20, 240, 380, 30);
        contentPanel.add(locationField2);
        JTextField locationField3 = new JTextField();
        locationField3.setBounds(20, 280, 380, 30);
        contentPanel.add(locationField3);

        
        // property type
        JLabel propertyTypeLabel = new JLabel("Type of Property");
        propertyTypeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        propertyTypeLabel.setForeground(Color.BLACK);
        propertyTypeLabel.setBounds(420, 160, 200, 30);
        contentPanel.add(propertyTypeLabel);

        String[] propertyTypes = {
            "",
            "RESIDENTIAL_LOT",
            "HOUSE_AND_LOT",
            "TOWNHOUSE",
            "CONDOMINIUM_UNIT",
            "FORECLOSED_PROPERTY",
            "ROWHOUSE",
            "DUPLEX",
            "VACANT_LOT"
        };

        JComboBox<String> propertyTypeBox1 = new JComboBox<>(propertyTypes);
        propertyTypeBox1.setBounds(420, 200, 250, 30);
        contentPanel.add(propertyTypeBox1);
        JComboBox<String> propertyTypeBox2 = new JComboBox<>(propertyTypes);
        propertyTypeBox2.setBounds(420, 240, 250, 30);
        contentPanel.add(propertyTypeBox2);
        JComboBox<String> propertyTypeBox3 = new JComboBox<>(propertyTypes);
        propertyTypeBox3.setBounds(420, 280, 250, 30);
        contentPanel.add(propertyTypeBox3);

        // housing account no.
        JLabel housingAccountLabel = new JLabel("Housing Account No.");
        housingAccountLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        housingAccountLabel.setForeground(Color.BLACK);
        housingAccountLabel.setBounds(700, 160, 200, 30); 
        contentPanel.add(housingAccountLabel);

        JTextField housingField1 = new JTextField();
        housingField1.setBounds(700, 200, 250, 30);
        contentPanel.add(housingField1);
        JTextField housingField2 = new JTextField();
        housingField2.setBounds(700, 240, 250, 30);
        contentPanel.add(housingField2);
        JTextField housingField3 = new JTextField();
        housingField3.setBounds(700, 280, 250, 30);
        contentPanel.add(housingField3);

        // acquisition cost
        JLabel acquisitionCostLabel = new JLabel("Acquisition Cost");
        acquisitionCostLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        acquisitionCostLabel.setForeground(Color.BLACK);
        acquisitionCostLabel.setBounds(20, 330, 200, 30); 
        contentPanel.add(acquisitionCostLabel);

        JTextField acquisitionCostField1 = new JTextField();
        acquisitionCostField1.setBounds(20, 370, 250, 30);  
        contentPanel.add(acquisitionCostField1);
        JTextField acquisitionCostField2 = new JTextField();
        acquisitionCostField2.setBounds(20, 410, 250, 30);
        contentPanel.add(acquisitionCostField2);
        JTextField acquisitionCostField3 = new JTextField();
        acquisitionCostField3.setBounds(20, 450, 250, 30);
        contentPanel.add(acquisitionCostField3);

        // market value
        JLabel marketValueLabel = new JLabel("Market Value");
        marketValueLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        marketValueLabel.setForeground(Color.BLACK);
        marketValueLabel.setBounds(290, 330, 200, 30);   
        contentPanel.add(marketValueLabel);

        JTextField marketValueField1 = new JTextField();
        marketValueField1.setBounds(290, 370, 250, 30);
        contentPanel.add(marketValueField1);
        JTextField marketValueField2 = new JTextField();
        marketValueField2.setBounds(290, 410, 250, 30);
        contentPanel.add(marketValueField2);
        JTextField marketValueField3 = new JTextField();
        marketValueField3.setBounds(290, 450, 250, 30);
        contentPanel.add(marketValueField3);
        
        // mortgage balance
        JLabel mortgageBalanceLabel = new JLabel("Mortgage Balance");
        mortgageBalanceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        mortgageBalanceLabel.setForeground(Color.BLACK);
        mortgageBalanceLabel.setBounds(560, 330, 200, 30);  
        contentPanel.add(mortgageBalanceLabel);

        JTextField mortgageBalanceField1 = new JTextField();
        mortgageBalanceField1.setBounds(560, 370, 200, 30);
        contentPanel.add(mortgageBalanceField1);
        JTextField mortgageBalanceField2 = new JTextField();
        mortgageBalanceField2.setBounds(560, 410, 200, 30);
        contentPanel.add(mortgageBalanceField2);
        JTextField mortgageBalanceField3 = new JTextField();
        mortgageBalanceField3.setBounds(560, 450, 200, 30);
        contentPanel.add(mortgageBalanceField3);
        
        // rental income
        JLabel rentalIncomeLabel = new JLabel("Rental Income");
        rentalIncomeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        rentalIncomeLabel.setForeground(Color.BLACK);
        rentalIncomeLabel.setBounds(780, 330, 200, 30); 
        contentPanel.add(rentalIncomeLabel);

        JTextField rentalIncomeField1 = new JTextField();
        rentalIncomeField1.setBounds(780, 370, 200, 30);
        contentPanel.add(rentalIncomeField1);
        JTextField rentalIncomeField2 = new JTextField();
        rentalIncomeField2.setBounds(780, 410, 200, 30);
        contentPanel.add(rentalIncomeField2);
        JTextField rentalIncomeField3 = new JTextField();
        rentalIncomeField3.setBounds(780, 450, 200, 30);
        contentPanel.add(rentalIncomeField3);

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

            MemberApply7 memberApply7 = new MemberApply7(parentFrame, this, authService);
            memberApply7.setBounds(240, 70, 1000, 580);
            parentFrame.getContentPane().add(memberApply7);
            memberApply7.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();

            System.out.println("Next button clicked, moving to step 7.");
        });
        
        contentPanel.add(nextButton);

        backButton.addActionListener(e -> {
            this.setVisible(false);
            parentFrame.getContentPane().remove(this);

            previousPanel.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();
            System.out.println("Back button clicked, returning to step 5.");
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
