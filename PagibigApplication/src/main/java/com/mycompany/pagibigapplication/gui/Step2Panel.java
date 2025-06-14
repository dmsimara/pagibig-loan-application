
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.models.Member;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Step2Panel extends javax.swing.JPanel {

    private JTextField tfPagibigMid;
    private JTextField tfName;
    private JComboBox<String> cbCitizenship;
    private JTextField tfDateOfBirth;
    private JComboBox<String> cbSex;
    private JComboBox<String> cbMaritalStatus;
    private JTextField tfNumberOfDependents;
    private JTextField tfPresentHomeAddress;
    private JTextField tfPermanentHomeAddress;
    private JTextField tfHomePhone;
    private JTextField tfCellPhone;
    private JTextField tfEmailAddress;
    private JTextField tfAlternateMailingAddress;
    private JTextField tfSssGsisNo;
    private JTextField tfTin;
    private JTextField tfOccupation;
    private JComboBox<String> cbHomeOwnership;
    private JTextField tfMonthlyRent;
    private JTextField tfYearsOfStayAddress;
    private JTextField tfEmployerName;
    private JTextField tfYearsEmployment;
    private JTextField tfPositionDepartment;
    private JButton btnNext;
    private JButton btnBack;

    private final ApplicationData appData;
    private final MultiStepForm parent;
    
    public Step2Panel(MultiStepForm parent, ApplicationData appData) {
        this.parent = parent;
        this.appData = appData;
        initComponents();
        setupForm();
    }
    
    void setupForm() {
        this.removeAll();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Member Information", TitledBorder.LEFT, TitledBorder.TOP));

        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Pagibig MID
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblPagibigMid = new JLabel("Pag-IBIG MID No:");
        lblPagibigMid.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPagibigMid, gbc);
        tfPagibigMid = new JTextField(15);
        tfPagibigMid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String pagibigMid = appData.getMember().getPagibigMid();
        tfPagibigMid.setText(pagibigMid != null ? pagibigMid : "");
        tfPagibigMid.setEditable(false);
        gbc.gridx = 1;
        this.add(tfPagibigMid, gbc);

        // Name
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblName, gbc);
        tfName = new JTextField(15);
        tfName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfName, gbc);

        row++;

        // Citizenship
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblCitizenship = new JLabel("Citizenship:");
        lblCitizenship.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblCitizenship, gbc);
        String[] citizenshipOptions = {"", "Filipino", "Dual Citizen", "Foreign National"};
        cbCitizenship = new JComboBox<>(citizenshipOptions);
        cbCitizenship.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(cbCitizenship, gbc);

        // Date of Birth
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblDateOfBirth = new JLabel("Date of Birth (yyyy-MM-dd):");
        lblDateOfBirth.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblDateOfBirth, gbc);
        tfDateOfBirth = new JTextField(15);
        tfDateOfBirth.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfDateOfBirth, gbc);

        row++;

        // Sex
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblSex = new JLabel("Sex:");
        lblSex.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSex, gbc);
        String[] sexOptions = {"", "Female", "Male"};
        cbSex = new JComboBox<>(sexOptions);
        cbSex.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(cbSex, gbc);

        // Marital Status
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblMaritalStatus = new JLabel("Marital Status:");
        lblMaritalStatus.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblMaritalStatus, gbc);
        String[] maritalStatusOptions = {"", "Single", "Married", "Legally Separated", "Annulled", "Widowed"};
        cbMaritalStatus = new JComboBox<>(maritalStatusOptions);
        cbMaritalStatus.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(cbMaritalStatus, gbc);

        row++;

        // Number of Dependents
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblNumberOfDependents = new JLabel("Number of Dependents:");
        lblNumberOfDependents.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblNumberOfDependents, gbc);
        tfNumberOfDependents = new JTextField(15);
        tfNumberOfDependents.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setNumericDocumentFilter(tfNumberOfDependents);
        gbc.gridx = 1;
        this.add(tfNumberOfDependents, gbc);

        // Present Home Address
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblPresentHomeAddress = new JLabel("Present Home Address:");
        lblPresentHomeAddress.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPresentHomeAddress, gbc);
        tfPresentHomeAddress = new JTextField(15);
        tfPresentHomeAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfPresentHomeAddress, gbc);

        row++;

        // Permanent Home Address
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblPermanentHomeAddress = new JLabel("Permanent Home Address:");
        lblPermanentHomeAddress.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPermanentHomeAddress, gbc);
        tfPermanentHomeAddress = new JTextField(15);
        tfPermanentHomeAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfPermanentHomeAddress, gbc);

        // Home Phone
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblHomePhone = new JLabel("Home Phone:");
        lblHomePhone.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblHomePhone, gbc);
        tfHomePhone = new JTextField(15);
        tfHomePhone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfHomePhone, gbc);

        row++;

        // Cell Phone
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblCellPhone = new JLabel("Cell Phone:");
        lblCellPhone.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblCellPhone, gbc);
        tfCellPhone = new JTextField(15);
        tfCellPhone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfCellPhone, gbc);

        // Email Address
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmailAddress, gbc);
        tfEmailAddress = new JTextField(15);
        tfEmailAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfEmailAddress, gbc);

        row++;

        // Alternate Mailing Address
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblAlternateMailingAddress = new JLabel("Alternate Mailing Address:");
        lblAlternateMailingAddress.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblAlternateMailingAddress, gbc);
        tfAlternateMailingAddress = new JTextField(15);
        tfAlternateMailingAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfAlternateMailingAddress, gbc);

        // SSS/GSIS No
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblSssGsisNo = new JLabel("SSS/GSIS No:");
        lblSssGsisNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSssGsisNo, gbc);
        tfSssGsisNo = new JTextField(15);
        tfSssGsisNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfSssGsisNo, gbc);

        row++;

        // TIN
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblTin = new JLabel("TIN:");
        lblTin.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblTin, gbc);
        tfTin = new JTextField(15);
        tfTin.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfTin, gbc);

        // Occupation
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblOccupation = new JLabel("Occupation:");
        lblOccupation.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblOccupation, gbc);
        tfOccupation = new JTextField(15);
        tfOccupation.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfOccupation, gbc);

        row++;

        // Home Ownership
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblHomeOwnership = new JLabel("Home Ownership:");
        lblHomeOwnership.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblHomeOwnership, gbc);
        String[] homeOwnershipOptions = {"", "Owned", "Rented", "Mortgaged", "Living with Relatives"};
        cbHomeOwnership = new JComboBox<>(homeOwnershipOptions);
        cbHomeOwnership.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(cbHomeOwnership, gbc);

        // Monthly Rent
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblMonthlyRent = new JLabel("Monthly Rent:");
        lblMonthlyRent.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblMonthlyRent, gbc);
        tfMonthlyRent = new JTextField(15);
        tfMonthlyRent.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfMonthlyRent.setEnabled(false);
        gbc.gridx = 3;
        this.add(tfMonthlyRent, gbc);

        row++;

        // Years of Stay Address
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblYearsOfStayAddress = new JLabel("Years of Stay at Address:");
        lblYearsOfStayAddress.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblYearsOfStayAddress, gbc);
        tfYearsOfStayAddress = new JTextField(15);
        tfYearsOfStayAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setNumericDocumentFilter(tfYearsOfStayAddress);
        gbc.gridx = 1;
        this.add(tfYearsOfStayAddress, gbc);

        // Employer Name
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblEmployerName = new JLabel("Employer Name:");
        lblEmployerName.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmployerName, gbc);
        tfEmployerName = new JTextField(15);
        tfEmployerName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfEmployerName, gbc);

        row++;

        // Years Employment
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblYearsEmployment = new JLabel("Years of Employment:");
        lblYearsEmployment.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblYearsEmployment, gbc);
        tfYearsEmployment = new JTextField(15);
        tfYearsEmployment.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setNumericDocumentFilter(tfYearsEmployment);
        gbc.gridx = 1;
        this.add(tfYearsEmployment, gbc);

        row++;

        // Position Department
        gbc.gridx = 2;
        gbc.gridy = row - 1; 
        JLabel lblPositionDepartment = new JLabel("Position/Department:");
        lblPositionDepartment.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPositionDepartment, gbc);
        tfPositionDepartment = new JTextField(15);
        tfPositionDepartment.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfPositionDepartment, gbc);

        row++;

        // Next button
        btnNext = new JButton("Next");
        btnNext.setEnabled(false); 
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(btnNext, gbc);

        for (ActionListener al : btnNext.getActionListeners()) {
            btnNext.removeActionListener(al);
        }

        btnNext.addActionListener(e -> {
            btnNext.setEnabled(false);
            Member member = appData.getMember();

            member.setName(tfName.getText());

            String citizenship = (String) cbCitizenship.getSelectedItem();
            if ("Filipino".equals(citizenship)) {
                member.setCitizenship(Member.Citizenship.F);
            } else if ("Dual Citizen".equals(citizenship)) {
                member.setCitizenship(Member.Citizenship.DC);
            } else if ("Foreign National".equals(citizenship)) {
                member.setCitizenship(Member.Citizenship.FN);
            } else {
                member.setCitizenship(null);
            }

            try {
                member.setDateOfBirth(LocalDate.parse(tfDateOfBirth.getText(), DateTimeFormatter.ISO_LOCAL_DATE));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Step2Panel.this, "Invalid date format. Use yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                btnNext.setEnabled(true);
                return;
            }

            String sex = (String) cbSex.getSelectedItem();
            if ("Female".equals(sex)) {
                member.setSex(Member.Sex.F);
            } else if ("Male".equals(sex)) {
                member.setSex(Member.Sex.M);
            } else {
                member.setSex(null);
            }

            String maritalStatus = (String) cbMaritalStatus.getSelectedItem();
            if ("Single".equals(maritalStatus)) {
                member.setMaritalStatus(Member.MaritalStatus.S);
            } else if ("Married".equals(maritalStatus)) {
                member.setMaritalStatus(Member.MaritalStatus.M);
            } else if ("Legally Separated".equals(maritalStatus)) {
                member.setMaritalStatus(Member.MaritalStatus.LS);
            } else if ("Annulled".equals(maritalStatus)) {
                member.setMaritalStatus(Member.MaritalStatus.A);
            } else if ("Widowed".equals(maritalStatus)) {
                member.setMaritalStatus(Member.MaritalStatus.W);
            } else {
                member.setMaritalStatus(null);
            }

            try {
                member.setNumberOfDependents(Integer.parseInt(tfNumberOfDependents.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Step2Panel.this, "Invalid number of dependents.", "Error", JOptionPane.ERROR_MESSAGE);
                btnNext.setEnabled(true);
                return;
            }

            member.setPresentHomeAddress(tfPresentHomeAddress.getText());
            member.setPermanentHomeAddress(tfPermanentHomeAddress.getText());
            member.setHomePhone(tfHomePhone.getText());
            member.setCellPhone(tfCellPhone.getText());
            member.setEmailAddress(tfEmailAddress.getText());
            member.setAlternateMailingAddress(tfAlternateMailingAddress.getText());
            member.setSssGsisNo(tfSssGsisNo.getText());
            member.setTin(tfTin.getText());
            member.setOccupation(tfOccupation.getText());

            String homeOwnership = (String) cbHomeOwnership.getSelectedItem();
            member.setHomeOwnership(homeOwnership);

            if ("Rented".equals(homeOwnership)) {
                try {
                    member.setMonthlyRent(new java.math.BigDecimal(tfMonthlyRent.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Step2Panel.this, "Invalid monthly rent.", "Error", JOptionPane.ERROR_MESSAGE);
                    btnNext.setEnabled(true);
                    return;
                }
            } else {
                member.setMonthlyRent(null);
            }

            try {
                member.setYearsOfStayAddress(Integer.parseInt(tfYearsOfStayAddress.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Step2Panel.this, "Invalid years of stay at address.", "Error", JOptionPane.ERROR_MESSAGE);
                btnNext.setEnabled(true);
                return;
            }

            member.setEmployerName(tfEmployerName.getText());

            try {
                member.setYearsEmployment(Integer.parseInt(tfYearsEmployment.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Step2Panel.this, "Invalid years of employment.", "Error", JOptionPane.ERROR_MESSAGE);
                btnNext.setEnabled(true);
                return;
            }

            member.setPositionDepartment(tfPositionDepartment.getText());

            System.out.println("Saved Member Data:");
            System.out.println("Pag-IBIG MID: " + member.getPagibigMid());
            System.out.println("Name: " + member.getName());
            System.out.println("Citizenship: " + member.getCitizenship());
            System.out.println("Date of Birth: " + member.getDateOfBirth());
            System.out.println("Sex: " + member.getSex());
            System.out.println("Marital Status: " + member.getMaritalStatus());
            System.out.println("Number of Dependents: " + member.getNumberOfDependents());
            System.out.println("Present Home Address: " + member.getPresentHomeAddress());
            System.out.println("Permanent Home Address: " + member.getPermanentHomeAddress());
            System.out.println("Home Phone: " + member.getHomePhone());
            System.out.println("Cell Phone: " + member.getCellPhone());
            System.out.println("Email Address: " + member.getEmailAddress());
            System.out.println("Alternate Mailing Address: " + member.getAlternateMailingAddress());
            System.out.println("SSS/GSIS No: " + member.getSssGsisNo());
            System.out.println("TIN: " + member.getTin());
            System.out.println("Occupation: " + member.getOccupation());
            System.out.println("Home Ownership: " + member.getHomeOwnership());
            System.out.println("Monthly Rent: " + member.getMonthlyRent());
            System.out.println("Years of Stay at Address: " + member.getYearsOfStayAddress());
            System.out.println("Employer Name: " + member.getEmployerName());
            System.out.println("Years of Employment: " + member.getYearsEmployment());
            System.out.println("Position/Department: " + member.getPositionDepartment());

            parent.nextStep();
        });

        cbHomeOwnership.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selected = (String) cbHomeOwnership.getSelectedItem();
                if ("Rented".equals(selected)) {
                    tfMonthlyRent.setEnabled(true);
                } else {
                    tfMonthlyRent.setEnabled(false);
                }
                validateForm();
            }
        });

        btnBack = new JButton("Back");
        GridBagConstraints gbcBack = new GridBagConstraints();
        gbcBack.gridx = 2;
        gbcBack.gridy = row; 
        gbcBack.anchor = GridBagConstraints.EAST;
        this.add(btnBack, gbcBack);

        btnBack.addActionListener(e -> {
            parent.previousStep();
        });

        setupValidationListeners();
        
        Member member = appData.getMember();

    tfPagibigMid.setText(member.getPagibigMid() != null ? member.getPagibigMid() : "");
    tfName.setText(member.getName() != null ? member.getName() : "");
    cbCitizenship.setSelectedItem(member.getCitizenship() != null ? 
        (member.getCitizenship() == Member.Citizenship.F ? "Filipino" :
         member.getCitizenship() == Member.Citizenship.DC ? "Dual Citizen" :
         member.getCitizenship() == Member.Citizenship.FN ? "Foreign National" : "") : "");
    tfDateOfBirth.setText(member.getDateOfBirth() != null ? member.getDateOfBirth().toString() : "");
    cbSex.setSelectedItem(member.getSex() != null ? 
        (member.getSex() == Member.Sex.F ? "Female" :
         member.getSex() == Member.Sex.M ? "Male" : "") : "");
    cbMaritalStatus.setSelectedItem(member.getMaritalStatus() != null ? 
        (member.getMaritalStatus() == Member.MaritalStatus.S ? "Single" :
         member.getMaritalStatus() == Member.MaritalStatus.M ? "Married" :
         member.getMaritalStatus() == Member.MaritalStatus.LS ? "Legally Separated" :
         member.getMaritalStatus() == Member.MaritalStatus.A ? "Annulled" :
         member.getMaritalStatus() == Member.MaritalStatus.W ? "Widowed" : "") : "");
    tfNumberOfDependents.setText(safeDisplayInt(member.getNumberOfDependents()));   
    tfPresentHomeAddress.setText(member.getPresentHomeAddress() != null ? member.getPresentHomeAddress() : "");
    tfPermanentHomeAddress.setText(member.getPermanentHomeAddress() != null ? member.getPermanentHomeAddress() : "");
    tfHomePhone.setText(member.getHomePhone() != null ? member.getHomePhone() : "");
    tfCellPhone.setText(member.getCellPhone() != null ? member.getCellPhone() : "");
    tfEmailAddress.setText(member.getEmailAddress() != null ? member.getEmailAddress() : "");
    tfAlternateMailingAddress.setText(member.getAlternateMailingAddress() != null ? member.getAlternateMailingAddress() : "");
    tfSssGsisNo.setText(member.getSssGsisNo() != null ? member.getSssGsisNo() : "");
    tfTin.setText(member.getTin() != null ? member.getTin() : "");
    tfOccupation.setText(member.getOccupation() != null ? member.getOccupation() : "");
    cbHomeOwnership.setSelectedItem(member.getHomeOwnership() != null ? member.getHomeOwnership() : "");
    tfMonthlyRent.setText(member.getMonthlyRent() != null ? member.getMonthlyRent().toString() : "0");
    tfMonthlyRent.setEnabled("Rented".equals(member.getHomeOwnership()));
    tfYearsOfStayAddress.setText(safeDisplayInt(member.getYearsOfStayAddress()));
    tfEmployerName.setText(member.getEmployerName() != null ? member.getEmployerName() : "");
    tfYearsEmployment.setText(safeDisplayInt(member.getYearsEmployment()));
    tfPositionDepartment.setText(member.getPositionDepartment() != null ? member.getPositionDepartment() : "");

        validateForm();

        this.revalidate();
        this.repaint();
    }
    
    private String safeDisplayInt(Integer value) {
        return (value == null) ? "0" : value.toString();
    }

    private void setupValidationListeners() {
        DocumentListener docListener = new DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
        };

        tfName.getDocument().addDocumentListener(docListener);
        tfDateOfBirth.getDocument().addDocumentListener(docListener);
        tfNumberOfDependents.getDocument().addDocumentListener(docListener);
        tfPresentHomeAddress.getDocument().addDocumentListener(docListener);
        tfPermanentHomeAddress.getDocument().addDocumentListener(docListener);
        tfHomePhone.getDocument().addDocumentListener(docListener);
        tfCellPhone.getDocument().addDocumentListener(docListener);
        tfEmailAddress.getDocument().addDocumentListener(docListener);
        tfAlternateMailingAddress.getDocument().addDocumentListener(docListener);
        tfSssGsisNo.getDocument().addDocumentListener(docListener);
        tfTin.getDocument().addDocumentListener(docListener);
        tfOccupation.getDocument().addDocumentListener(docListener);
        tfMonthlyRent.getDocument().addDocumentListener(docListener);
        tfYearsOfStayAddress.getDocument().addDocumentListener(docListener);
        tfEmployerName.getDocument().addDocumentListener(docListener);
        tfYearsEmployment.getDocument().addDocumentListener(docListener);
        tfPositionDepartment.getDocument().addDocumentListener(docListener);

        cbCitizenship.addActionListener(e -> validateForm());
        cbSex.addActionListener(e -> validateForm());
        cbMaritalStatus.addActionListener(e -> validateForm());
        cbHomeOwnership.addActionListener(e -> validateForm());
    }
   
    void validateForm() {
        boolean valid = true;

        if (tfName.getText().trim().isEmpty()) valid = false;
        if (cbCitizenship.getSelectedIndex() == 0) valid = false;
        if (tfDateOfBirth.getText().trim().isEmpty()) valid = false;
        else {
            try {
                LocalDate.parse(tfDateOfBirth.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (cbSex.getSelectedIndex() == 0) valid = false;
        if (cbMaritalStatus.getSelectedIndex() == 0) valid = false;
        if (tfNumberOfDependents.getText().trim().isEmpty()) valid = false;
        if (tfPresentHomeAddress.getText().trim().isEmpty()) valid = false;
        if (tfPermanentHomeAddress.getText().trim().isEmpty()) valid = false;
        if (tfHomePhone.getText().trim().isEmpty()) valid = false;
        if (tfCellPhone.getText().trim().isEmpty()) valid = false;
        if (tfEmailAddress.getText().trim().isEmpty()) valid = false;
        if (tfAlternateMailingAddress.getText().trim().isEmpty()) valid = false;
        if (tfSssGsisNo.getText().trim().isEmpty()) valid = false;
        if (tfTin.getText().trim().isEmpty()) valid = false;
        if (tfOccupation.getText().trim().isEmpty()) valid = false;
        if (cbHomeOwnership.getSelectedIndex() == 0) valid = false;
        if ("Rented".equals(cbHomeOwnership.getSelectedItem())) {
            if (tfMonthlyRent.getText().trim().isEmpty()) valid = false;
        }
        if (tfYearsOfStayAddress.getText().trim().isEmpty()) valid = false;
        if (tfEmployerName.getText().trim().isEmpty()) valid = false;
        if (tfYearsEmployment.getText().trim().isEmpty()) valid = false;
        if (tfPositionDepartment.getText().trim().isEmpty()) valid = false;

        btnNext.setEnabled(valid);
    }


    private void setNumericDocumentFilter(JTextField textField) {
        PlainDocument doc = (PlainDocument) textField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) return;
                if (string.chars().allMatch(Character::isDigit)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;
                if (text.chars().allMatch(Character::isDigit)) {
                    super.replace(fb, offset, length, text, attrs);
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
