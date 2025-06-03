
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class MemberApply2 extends javax.swing.JPanel {

    private final AuthService authService;
    
    public MemberApply2(AuthService authService) {
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
        JLabel stepLabel = new JLabel("Step 2");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 80;
        JLabel loanLabel = new JLabel("Member");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(2); 
        contentPanel.add(progressBar);
        
        // pag-IBIG MID
        JLabel midLabel = new JLabel("Pag-IBIG MID");
        midLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        midLabel.setForeground(Color.BLACK);
        midLabel.setBounds(20, 160, 150, 30);  
        contentPanel.add(midLabel);

        JTextField midField = new JTextField();
        midField.setBounds(20, 190, 150, 30);
        contentPanel.add(midField);
        
        // name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(190, 160, 100, 30); 
        contentPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(190, 190, 350, 30);
        contentPanel.add(nameField);
        
        // citizenship  
        JLabel citizenshipLabel = new JLabel("Citizenship");
        citizenshipLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        citizenshipLabel.setForeground(Color.BLACK);
        citizenshipLabel.setBounds(550, 160, 100, 30);  
        contentPanel.add(citizenshipLabel);

        String[] citizenshipOptions = {"", "Filipino", "Dual Citizen", "Foreign National"};
        JComboBox<String> citizenshipDropdown = new JComboBox<>(citizenshipOptions);
        citizenshipDropdown.setBounds(550, 190, 150, 30);  
        contentPanel.add(citizenshipDropdown);
        
        // date ofbirth 
        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        dobLabel.setForeground(Color.BLACK);
        dobLabel.setBounds(720, 160, 100, 30);
        contentPanel.add(dobLabel);

        JLabel dobSublabel = new JLabel("(yyyy/mm/dd)");
        dobSublabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        dobSublabel.setForeground(Color.BLACK);
        dobSublabel.setBounds(825, 170, 80, 15);
        contentPanel.add(dobSublabel);

        JFormattedTextField dobField = new JFormattedTextField(new SimpleDateFormat("yyyy/MM/dd"));
        dobField.setBounds(720, 190, 150, 30);
        dobField.setColumns(10);
        contentPanel.add(dobField);
        
        // sex  
        JLabel sexLabel = new JLabel("Sex");
        sexLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        sexLabel.setForeground(Color.BLACK);
        sexLabel.setBounds(890, 160, 100, 30);
        contentPanel.add(sexLabel);

        JPanel sexPanel = new JPanel();
        sexPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0)); 
        sexPanel.setBackground(Color.WHITE);
        sexPanel.setBounds(890, 190, 100, 30);  
        contentPanel.add(sexPanel);

        JRadioButton maleRadio = new JRadioButton("M");
        maleRadio.setBackground(Color.WHITE);
        maleRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JRadioButton femaleRadio = new JRadioButton("F");
        femaleRadio.setBackground(Color.WHITE);
        femaleRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleRadio);
        sexGroup.add(femaleRadio);

        sexPanel.add(maleRadio);
        sexPanel.add(femaleRadio);
        
        // marital Status  
        JLabel maritalStatusLabel = new JLabel("Marital Status");
        maritalStatusLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        maritalStatusLabel.setForeground(Color.BLACK);
        maritalStatusLabel.setBounds(20, 230, 150, 30);
        contentPanel.add(maritalStatusLabel);

        JPanel maritalStatusPanel = new JPanel();
        maritalStatusPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        maritalStatusPanel.setBackground(Color.WHITE);
        maritalStatusPanel.setBounds(140, 234, 500, 30); 
        contentPanel.add(maritalStatusPanel);

        JRadioButton singleRadio = new JRadioButton("Single/Unmarried");
        JRadioButton marriedRadio = new JRadioButton("Married");
        JRadioButton separatedRadio = new JRadioButton("Legally Separated");
        JRadioButton annulledRadio = new JRadioButton("Annulled");
        JRadioButton widowRadio = new JRadioButton("Widow/er");

        JRadioButton[] maritalButtons = {
            singleRadio, marriedRadio, separatedRadio, annulledRadio, widowRadio
        };

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        for (JRadioButton btn : maritalButtons) {
            btn.setBackground(Color.WHITE);
            btn.setFont(new Font("SansSerif", Font.PLAIN, 12));
            maritalStatusGroup.add(btn);
            maritalStatusPanel.add(btn);
        }

        // dependents 
        JLabel dependentsLabel = new JLabel("No. of Dependent/s");
        dependentsLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        dependentsLabel.setForeground(Color.BLACK);
        dependentsLabel.setBounds(660, 230, 150, 30);
        contentPanel.add(dependentsLabel);

        JTextField dependentsField = new JTextField();
        dependentsField.setBounds(810, 230, 130, 30); 
        contentPanel.add(dependentsField);

        // present home address  
        JLabel addressLabel = new JLabel("Present Home Address");
        addressLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setBounds(20, 270, 200, 30);  
        contentPanel.add(addressLabel);
        JTextField addressField = new JTextField();
        addressField.setBounds(20, 300, 460, 30); 
        contentPanel.add(addressField);

        // borrower's contact details
        JLabel contactDetailsLabel = new JLabel("Borrower's Contact Details");
        contactDetailsLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        contactDetailsLabel.setForeground(Color.BLACK);
        contactDetailsLabel.setBounds(500, 270, 250, 30);
        contentPanel.add(contactDetailsLabel);

        JLabel contactSublabel = new JLabel("(Indicate country code if abroad)");
        contactSublabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        contactSublabel.setForeground(Color.BLACK);
        contactSublabel.setBounds(500, 295, 200, 15);
        contentPanel.add(contactSublabel);

        JTextField homePhoneField = new JTextField();
        homePhoneField.setBounds(500, 315, 250, 30);
        contentPanel.add(homePhoneField);
        addPlaceholder(homePhoneField, "Home");

        JTextField cellPhoneField = new JTextField();
        cellPhoneField.setBounds(500, 350, 250, 30);
        contentPanel.add(cellPhoneField);
        addPlaceholder(cellPhoneField, "Cell Phone");

        // alternate mailing address 
        JLabel alternateMailingLabel = new JLabel("Alternate Mailing Address");
        alternateMailingLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        alternateMailingLabel.setForeground(Color.BLACK);
        alternateMailingLabel.setBounds(770, 270, 220, 30); 
        contentPanel.add(alternateMailingLabel);

        JPanel alternateMailingPanel = new JPanel();
        alternateMailingPanel.setLayout(new BoxLayout(alternateMailingPanel, BoxLayout.Y_AXIS)); 
        alternateMailingPanel.setBackground(Color.WHITE);
        alternateMailingPanel.setBounds(770, 300, 220, 90); 
        contentPanel.add(alternateMailingPanel);

        JRadioButton presentHomeRadio = new JRadioButton("Present Home Address");
        presentHomeRadio.setBackground(Color.WHITE);
        presentHomeRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JRadioButton permanentHomeRadio = new JRadioButton("Permanent Home Address");
        permanentHomeRadio.setBackground(Color.WHITE);
        permanentHomeRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JRadioButton employerRadio = new JRadioButton("Employer/Business Address");
        employerRadio.setBackground(Color.WHITE);
        employerRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));

        ButtonGroup alternateMailingGroup = new ButtonGroup();
        alternateMailingGroup.add(presentHomeRadio);
        alternateMailingGroup.add(permanentHomeRadio);
        alternateMailingGroup.add(employerRadio);

        alternateMailingPanel.add(presentHomeRadio);
        alternateMailingPanel.add(permanentHomeRadio);
        alternateMailingPanel.add(employerRadio);

        // permanent home address  
        JLabel permanentAddressLabel = new JLabel("Permanent Home Address");
        permanentAddressLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        permanentAddressLabel.setForeground(Color.BLACK);
        permanentAddressLabel.setBounds(20, 340, 220, 30); 
        contentPanel.add(permanentAddressLabel);

        JTextField permanentAddressField = new JTextField();
        permanentAddressField.setBounds(20, 370, 460, 30); 
        contentPanel.add(permanentAddressField);

        // home ownership 
        JLabel homeOwnershipLabel = new JLabel("Home Ownership");
        homeOwnershipLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        homeOwnershipLabel.setForeground(Color.BLACK);
        homeOwnershipLabel.setBounds(20, 410, 200, 30);
        contentPanel.add(homeOwnershipLabel);

        JPanel homeOwnershipPanel = new JPanel();
        homeOwnershipPanel.setLayout(new BoxLayout(homeOwnershipPanel, BoxLayout.Y_AXIS));
        homeOwnershipPanel.setBackground(Color.WHITE);
        homeOwnershipPanel.setBounds(20, 440, 180, 140);
        contentPanel.add(homeOwnershipPanel);

        JRadioButton ownedRadio = new JRadioButton("Owned");
        JRadioButton mortgagedRadio = new JRadioButton("Mortgaged");
        JRadioButton companyRadio = new JRadioButton("Company");
        JRadioButton livingWithRelativesRadio = new JRadioButton("Living w/ Relatives/Parents");

        JRadioButton[] homeOwnershipButtons = {
            ownedRadio, mortgagedRadio, companyRadio, livingWithRelativesRadio
        };

        for (JRadioButton rb : homeOwnershipButtons) {
            rb.setBackground(Color.WHITE);
            rb.setFont(new Font("SansSerif", Font.PLAIN, 12));
            rb.setAlignmentX(Component.LEFT_ALIGNMENT);  
            homeOwnershipPanel.add(rb);
        }

        JPanel rentedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        rentedPanel.setBackground(Color.WHITE);
        rentedPanel.setAlignmentX(Component.LEFT_ALIGNMENT); 

        JRadioButton rentedRadio = new JRadioButton("Rented");
        rentedRadio.setBackground(Color.WHITE);
        rentedRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        rentedPanel.add(rentedRadio);

        JTextField rentPriceField = new JTextField(8);
        rentPriceField.setMaximumSize(new Dimension(80, 20));
        rentPriceField.setToolTipText("Rent price per month");
        rentedPanel.add(rentPriceField);

        homeOwnershipPanel.add(rentedPanel);

        ButtonGroup homeOwnershipGroup = new ButtonGroup();
        homeOwnershipGroup.add(ownedRadio);
        homeOwnershipGroup.add(mortgagedRadio);
        homeOwnershipGroup.add(companyRadio);
        homeOwnershipGroup.add(livingWithRelativesRadio);
        homeOwnershipGroup.add(rentedRadio);

        rentPriceField.setEnabled(false);
        rentPriceField.setForeground(Color.GRAY);
        rentPriceField.setText("₱ /month");

        rentPriceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (!rentPriceField.isEnabled()) return;
                if (rentPriceField.getText().equals("₱ /month")) {
                    rentPriceField.setText("");
                    rentPriceField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (!rentPriceField.isEnabled()) return;
                if (rentPriceField.getText().isEmpty()) {
                    rentPriceField.setForeground(Color.GRAY);
                    rentPriceField.setText("₱ /month");
                }
            }
        });

        rentedRadio.addItemListener(e -> {
            boolean selected = rentedRadio.isSelected();
            rentPriceField.setEnabled(selected);
            if (!selected) {
                rentPriceField.setText("₱ /month");
                rentPriceField.setForeground(Color.GRAY);
            } else {
                rentPriceField.setText("");
                rentPriceField.setForeground(Color.BLACK);
            }
        });
        
        // years of stay in present home address  
        JLabel yearsOfStayLabel = new JLabel("Years of stay in present home address");
        yearsOfStayLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        yearsOfStayLabel.setForeground(Color.BLACK);
        yearsOfStayLabel.setBounds(200, 410, 300, 30); 
        contentPanel.add(yearsOfStayLabel);

        JTextField yearsOfStayField = new JTextField();
        yearsOfStayField.setBounds(200, 440, 200, 30); 
        contentPanel.add(yearsOfStayField);

        // EE SSS/ GSIS ID No.  
        JLabel idNoLabel = new JLabel("EE SSS/ GSIS ID No.");
        idNoLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        idNoLabel.setForeground(Color.BLACK);
        idNoLabel.setBounds(200, 470, 200, 30);
        contentPanel.add(idNoLabel);

        JTextField idNoField = new JTextField();
        idNoField.setBounds(200, 500, 200, 30);
        contentPanel.add(idNoField);

        // mailing address/ contact details 
        JLabel mailingAddressLabel = new JLabel("Email Address");
        mailingAddressLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        mailingAddressLabel.setForeground(Color.BLACK);
        mailingAddressLabel.setBounds(500, 390, 300, 30);
        contentPanel.add(mailingAddressLabel);

        JTextField emailAddressField = new JTextField();
        emailAddressField.setBounds(500, 420, 250, 30); 
        contentPanel.add(emailAddressField);

        // TIN Label
        JLabel tinLabel = new JLabel("TIN");
        tinLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        tinLabel.setForeground(Color.BLACK);
        tinLabel.setBounds(760, 390, 100, 30);
        contentPanel.add(tinLabel);

        JTextField tinField = new JTextField();
        tinField.setBounds(760, 420, 210, 30);
        contentPanel.add(tinField);

        // occupation Label
        JLabel occupationLabel = new JLabel("Occupation");
        occupationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        occupationLabel.setForeground(Color.BLACK);
        occupationLabel.setBounds(430, 460, 150, 30); 
        contentPanel.add(occupationLabel);

        JPanel occupationPanel = new JPanel();
        occupationPanel.setLayout(new BoxLayout(occupationPanel, BoxLayout.Y_AXIS)); 
        occupationPanel.setBackground(Color.WHITE);
        occupationPanel.setBounds(430, 490, 150, 60); 
        contentPanel.add(occupationPanel);

        JRadioButton employedRadio = new JRadioButton("Employed");
        employedRadio.setBackground(Color.WHITE);
        employedRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        employedRadio.setAlignmentX(Component.LEFT_ALIGNMENT);

        JRadioButton selfEmployedRadio = new JRadioButton("Self-Employed");
        selfEmployedRadio.setBackground(Color.WHITE);
        selfEmployedRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        selfEmployedRadio.setAlignmentX(Component.LEFT_ALIGNMENT);

        ButtonGroup occupationGroup = new ButtonGroup();
        occupationGroup.add(employedRadio);
        occupationGroup.add(selfEmployedRadio);

        occupationPanel.add(employedRadio);
        occupationPanel.add(selfEmployedRadio);

        // years in employment/business 
        JLabel yearsInEmploymentLabel = new JLabel("Years in Employment/Business");
        yearsInEmploymentLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        yearsInEmploymentLabel.setForeground(Color.BLACK);
        yearsInEmploymentLabel.setBounds(550, 460, 250, 30); 
        contentPanel.add(yearsInEmploymentLabel);

        JTextField yearsInEmploymentField = new JTextField();
        yearsInEmploymentField.setBounds(550, 490, 150, 30);
        contentPanel.add(yearsInEmploymentField);

        // position & department Label
        JLabel positionDepartmentLabel = new JLabel("Position & Department");
        positionDepartmentLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        positionDepartmentLabel.setForeground(Color.BLACK);
        positionDepartmentLabel.setBounds(800, 460, 250, 30); 
        contentPanel.add(positionDepartmentLabel);

        JTextField positionDepartmentField = new JTextField();
        positionDepartmentField.setBounds(800, 490, 150, 30); 
        contentPanel.add(positionDepartmentField);

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
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // Same font as nextButton
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#43404066")); // Background color
        backButton.setBounds(nextButton.getX() - 80 - 10, nextButton.getY(), 70, 30); // Positioned to the left of nextButton
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setOpaque(true);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        nextButton.addActionListener(e -> {
            contentPanel.setVisible(false); 
            MemberApply3 memberApply3 = new MemberApply3(); // If MemberApply3 needs authService, pass it here
            memberApply3.setBounds(240, 70, 1000, 580); 
            contentPanel.add(memberApply3);
            memberApply3.setVisible(true); 
            contentPanel.revalidate();
            contentPanel.repaint();
            System.out.println("Next button clicked, moving to step 3.");
        });
        contentPanel.add(nextButton);

        backButton.addActionListener(e -> {
            contentPanel.setVisible(false);
            
            MemberApply memberApply = new MemberApply(authService); // Pass authService back
            memberApply.setBounds(240, 70, 1000, 580);
            contentPanel.getParent().add(memberApply); // Use getParent() to add to the main container
            
            memberApply.setVisible(true);
            
            contentPanel.getParent().revalidate();
            contentPanel.getParent().repaint();
            System.out.println("Back button clicked, returned to MemberApply.");
        });
        contentPanel.add(backButton);


    }
    
    private void addPlaceholder(JTextField field, String placeholder) {
        field.setForeground(Color.GRAY);
        field.setText(placeholder);
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                }
            }
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
