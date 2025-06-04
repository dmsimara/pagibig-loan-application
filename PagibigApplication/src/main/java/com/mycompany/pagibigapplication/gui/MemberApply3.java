
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

public class MemberApply3 extends javax.swing.JPanel {
    
    private JFrame parentFrame;
    private JPanel previousPanel;
    private AuthService authService;
    
    public MemberApply3(JFrame parentFrame, JPanel previousPanel, AuthService authService) {
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
        JLabel stepLabel = new JLabel("Step 3");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 80;
        JLabel loanLabel = new JLabel("Collateral");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(3); 
        contentPanel.add(progressBar);
        
        // TCT/OCT/CCT No. 
        JLabel tctLabel = new JLabel("TCT/OCT/CCT No.");
        tctLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        tctLabel.setForeground(Color.BLACK);
        tctLabel.setBounds(20, 160, 200, 30); 
        contentPanel.add(tctLabel);

        JTextField tctTextField = new JTextField();
        tctTextField.setBounds(20, 190, 200, 30); 
        contentPanel.add(tctTextField);
        
        // property location 
        JLabel propertyLocationLabel = new JLabel("Property Location");
        propertyLocationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        propertyLocationLabel.setForeground(Color.BLACK);
        propertyLocationLabel.setBounds(240, 160, 200, 30); 
        contentPanel.add(propertyLocationLabel);

        JTextField propertyLocationTextField = new JTextField();
        propertyLocationTextField.setBounds(240, 190, 350, 30); 
        contentPanel.add(propertyLocationTextField);
        
        // type of property 
        JLabel typeOfPropertyLabel = new JLabel("Type of Property");
        typeOfPropertyLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        typeOfPropertyLabel.setForeground(Color.BLACK);
        typeOfPropertyLabel.setBounds(610, 160, 200, 30); 
        contentPanel.add(typeOfPropertyLabel);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(2, 3)); 
        radioPanel.setBounds(610, 190, 350, 60); 
        radioPanel.setBackground(Color.WHITE);

        JRadioButton rowhouseButton = new JRadioButton("Rowhouse");
        rowhouseButton.setBackground(Color.WHITE);
        JRadioButton singleDetachedButton = new JRadioButton("Single Detached");
        singleDetachedButton.setBackground(Color.WHITE);
        JRadioButton townhouseButton = new JRadioButton("Townhouse");
        townhouseButton.setBackground(Color.WHITE);
        JRadioButton singleAttachedButton = new JRadioButton("Single Attached");
        singleAttachedButton.setBackground(Color.WHITE);
        JRadioButton condominiumButton = new JRadioButton("Condominium");
        condominiumButton.setBackground(Color.WHITE);
        JRadioButton duplexButton = new JRadioButton("Duplex");
        duplexButton.setBackground(Color.WHITE);

        ButtonGroup propertyTypeGroup = new ButtonGroup();
        propertyTypeGroup.add(rowhouseButton);
        propertyTypeGroup.add(singleDetachedButton);
        propertyTypeGroup.add(townhouseButton);
        propertyTypeGroup.add(singleAttachedButton);
        propertyTypeGroup.add(condominiumButton);
        propertyTypeGroup.add(duplexButton);

        radioPanel.add(rowhouseButton);
        radioPanel.add(singleDetachedButton);
        radioPanel.add(townhouseButton);
        radioPanel.add(singleAttachedButton);
        radioPanel.add(condominiumButton);
        radioPanel.add(duplexButton);
        contentPanel.add(radioPanel);
        
        // description of impprovement
        JLabel descriptionImprovementLabel = new JLabel("Description of Improvement");
        descriptionImprovementLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        descriptionImprovementLabel.setForeground(Color.BLACK);
        int intLabelY = radioPanel.getY() + radioPanel.getHeight() + 10;
        descriptionImprovementLabel.setBounds(610, intLabelY, 250, 30);
        contentPanel.add(descriptionImprovementLabel);
        
        JPanel descriptionRadioPanel = new JPanel();
        descriptionRadioPanel.setLayout(new GridLayout(1, 2, 10, 0));
        descriptionRadioPanel.setBounds(610, intLabelY + 30, 200, 30);
        descriptionRadioPanel.setBackground(Color.WHITE);
        
        JRadioButton existingButton = new JRadioButton("Existing");
        existingButton.setBackground(Color.WHITE);
        JRadioButton proposedButton = new JRadioButton("Proposed");
        proposedButton.setBackground(Color.WHITE);
        
        ButtonGroup descriptionGroup = new ButtonGroup();
        descriptionGroup.add(existingButton);
        descriptionGroup.add(proposedButton);
        
        descriptionRadioPanel.add(existingButton);
        descriptionRadioPanel.add(proposedButton);
        contentPanel.add(descriptionRadioPanel);
        
        // tax declaration no. 
        JLabel taxDeclarationLabel = new JLabel("Tax Declaration No.");
        taxDeclarationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        taxDeclarationLabel.setForeground(Color.BLACK);
        taxDeclarationLabel.setBounds(830, descriptionImprovementLabel.getY(), 200, 30); 
        contentPanel.add(taxDeclarationLabel);

        JTextField taxDeclarationTextField = new JTextField();
        taxDeclarationTextField.setBounds(830, descriptionImprovementLabel.getY() + 30, 150, 30); 
        contentPanel.add(taxDeclarationTextField);
        
        // developer name
        int intNameY = tctTextField.getY() + tctTextField.getHeight() + 20;
        
        JLabel developerNameLabel = new JLabel("Name of Developer/Registered Title Holder");
        developerNameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        developerNameLabel.setForeground(Color.BLACK);
        developerNameLabel.setBounds(20, intNameY, 350, 30);
        contentPanel.add(developerNameLabel);
        
        JTextField developerNameTextField = new JTextField();
        developerNameTextField.setBounds(20, intNameY + 30, 570, 30);
        contentPanel.add(developerNameTextField);

        // is property presently mortgaged?
        int mortgagedLabelY = descriptionImprovementLabel.getY() + 70; 

        JLabel mortgagedLabel = new JLabel("Is Property Presently Mortgaged?");
        mortgagedLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        mortgagedLabel.setForeground(Color.BLACK);
        mortgagedLabel.setBounds(610, mortgagedLabelY, 300, 30);
        contentPanel.add(mortgagedLabel);

        JPanel mortgagedRadioPanel = new JPanel();
        mortgagedRadioPanel.setLayout(new GridLayout(1, 2, 5, 0)); 
        mortgagedRadioPanel.setBounds(610 + 245, mortgagedLabelY, 150, 30); 
        mortgagedRadioPanel.setBackground(Color.WHITE);

        JRadioButton yesButton = new JRadioButton("Yes");
        yesButton.setBackground(Color.WHITE);
        JRadioButton noButton = new JRadioButton("No");
        noButton.setBackground(Color.WHITE);

        ButtonGroup mortgagedGroup = new ButtonGroup();
        mortgagedGroup.add(yesButton);
        mortgagedGroup.add(noButton);

        mortgagedRadioPanel.add(yesButton);
        mortgagedRadioPanel.add(noButton);
        contentPanel.add(mortgagedRadioPanel);

        // lot/unit no.
        int lotUnitLabelY = developerNameTextField.getY() + developerNameTextField.getHeight() + 20;

        JLabel lotUnitLabel = new JLabel("Lot/Unit No.");
        lotUnitLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        lotUnitLabel.setForeground(Color.BLACK);
        lotUnitLabel.setBounds(20, lotUnitLabelY, 100, 30);
        contentPanel.add(lotUnitLabel);

        JTextField lotUnitTextField = new JTextField();
        lotUnitTextField.setBounds(20, lotUnitLabelY + 30, 170, 30);
        contentPanel.add(lotUnitTextField);
        
        // block/bldg no.
        JLabel blockBldgLabel = new JLabel("Block/Bldg No.");
        blockBldgLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        blockBldgLabel.setForeground(Color.BLACK);
        blockBldgLabel.setBounds(210, lotUnitLabelY, 120, 30);
        contentPanel.add(blockBldgLabel);

        JTextField blockBldgTextField = new JTextField();
        blockBldgTextField.setBounds(210, lotUnitLabelY + 30, 170, 30);
        contentPanel.add(blockBldgTextField);

        // no. of storeys
        JLabel storeysLabel = new JLabel("No. of Storeys");
        storeysLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        storeysLabel.setForeground(Color.BLACK);
        storeysLabel.setBounds(400, lotUnitLabelY, 120, 30);
        contentPanel.add(storeysLabel);

        JTextField storeysTextField = new JTextField();
        storeysTextField.setBounds(400, lotUnitLabelY + 30, 170, 30);
        contentPanel.add(storeysTextField);
        
        // land area
        int landAreaLabelY = lotUnitTextField.getY() + lotUnitTextField.getHeight() + 10;

        JLabel landAreaLabel = new JLabel("Land Area");
        landAreaLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        landAreaLabel.setForeground(Color.BLACK);
        landAreaLabel.setBounds(20, landAreaLabelY, 100, 30);
        contentPanel.add(landAreaLabel);
        
        JLabel sqmLabel = new JLabel("(in sqm)");
        sqmLabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        sqmLabel.setForeground(Color.BLACK);
        sqmLabel.setBounds(100, landAreaLabelY + 10, 50, 15);
        contentPanel.add(sqmLabel);

        JTextField landAreaTextField = new JTextField();
        landAreaTextField.setBounds(20, landAreaLabelY + 30, 170, 30);
        contentPanel.add(landAreaTextField);

        // floor area
        JLabel floorAreaLabel = new JLabel("Floor Area");
        floorAreaLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        floorAreaLabel.setForeground(Color.BLACK);
        floorAreaLabel.setBounds(210, landAreaLabelY, 120, 30);
        contentPanel.add(floorAreaLabel);
        
        JLabel sqmAreaLabel = new JLabel("(in sqm)");
        sqmAreaLabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        sqmAreaLabel.setForeground(Color.BLACK);
        sqmAreaLabel.setBounds(290, landAreaLabelY + 10, 50, 15);
        contentPanel.add(sqmAreaLabel);

        JTextField floorAreaField = new JTextField();
        floorAreaField.setBounds(210, landAreaLabelY + 30, 170, 30);
        contentPanel.add(floorAreaField);
        
        // age of house
        JLabel houseAgeLabel = new JLabel("Age of House");
        houseAgeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        houseAgeLabel.setForeground(Color.BLACK);
        houseAgeLabel.setBounds(400, landAreaLabelY, 120, 30);
        contentPanel.add(houseAgeLabel);

        JTextField houseAgeTextField = new JTextField();
        houseAgeTextField.setBounds(400, landAreaLabelY + 30, 170, 30);
        contentPanel.add(houseAgeTextField);
        
        // total floor area 
        int floorAreaLabelY = mortgagedLabelY + 55;

        JLabel totalAreaLabel = new JLabel("Total Floor Area");
        totalAreaLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        totalAreaLabel.setForeground(Color.BLACK);
        totalAreaLabel.setBounds(610, floorAreaLabelY, 150, 30);
        contentPanel.add(totalAreaLabel);

        JLabel floorAreaSubLabel = new JLabel("(in sqm)");
        floorAreaSubLabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        floorAreaSubLabel.setForeground(Color.BLACK);
        floorAreaSubLabel.setBounds(735, floorAreaLabelY + 10, 50, 15);
        contentPanel.add(floorAreaSubLabel);

        JTextField floorAreaTextField = new JTextField();
        floorAreaTextField.setBounds(610, floorAreaLabelY + 30, 350, 30);
        contentPanel.add(floorAreaTextField);
        
        // is offsite collateral?
        int offsiteLabelY = landAreaLabelY + 80;

        JLabel offsiteLabel = new JLabel("Is the Property an offsite collateral?");
        offsiteLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        offsiteLabel.setForeground(Color.BLACK);
        offsiteLabel.setBounds(20, offsiteLabelY, 300, 30);
        contentPanel.add(offsiteLabel);
        
        // offsite reason
        JLabel reasonLabel = new JLabel("Reason for use of offsite collateral");
        reasonLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        reasonLabel.setForeground(Color.BLACK);
        reasonLabel.setBounds(300, offsiteLabelY - 10, 300, 30);
        contentPanel.add(reasonLabel);

        JTextField reasonTextField = new JTextField();
        reasonTextField.setBounds(300, offsiteLabelY + 20, 660, 30);
        contentPanel.add(reasonTextField);

        JPanel offsiteRadioPanel = new JPanel();
        offsiteRadioPanel.setLayout(new GridLayout(1, 2, 10, 0));
        offsiteRadioPanel.setBounds(20, offsiteLabelY + 30, 160, 30);
        offsiteRadioPanel.setBackground(Color.WHITE);

        JRadioButton offsiteYes = new JRadioButton("Yes");
        offsiteYes.setBackground(Color.WHITE);
        JRadioButton offsiteNo = new JRadioButton("No");
        offsiteNo.setBackground(Color.WHITE);

        ButtonGroup offsiteGroup = new ButtonGroup();
        offsiteGroup.add(offsiteYes);
        offsiteGroup.add(offsiteNo);

        offsiteRadioPanel.add(offsiteYes);
        offsiteRadioPanel.add(offsiteNo);
        contentPanel.add(offsiteRadioPanel);

        JLabel offsiteNote = new JLabel("If yes, use separate sheet for the offsite collateral details");
        offsiteNote.setFont(new Font("SansSerif", Font.PLAIN, 9));
        offsiteNote.setForeground(Color.BLACK);
        offsiteNote.setBounds(20, offsiteLabelY + 65, 350, 20);
        contentPanel.add(offsiteNote);
        
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

            MemberApply4 memberApply4 = new MemberApply4(parentFrame, this, authService);
            memberApply4.setBounds(240, 70, 1000, 580);
            parentFrame.getContentPane().add(memberApply4);
            memberApply4.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();

            System.out.println("Next button clicked, moving to step 4.");
        });
        
        contentPanel.add(nextButton);

        backButton.addActionListener(e -> {
            this.setVisible(false);
            parentFrame.getContentPane().remove(this);

            previousPanel.setVisible(true);

            parentFrame.revalidate();
            parentFrame.repaint();
            System.out.println("Back button clicked, returning to step 2.");
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
