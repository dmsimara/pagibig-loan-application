package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.models.Spouse;
import com.mycompany.pagibigapplication.models.Spouse.Citizenship;

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

public class Step4Panel extends javax.swing.JPanel {
    
    private JTextField tfSpousePagibigMid;
    private JTextField tfSpouseName;
    private JComboBox<String> cbSpouseCitizenship;
    private JTextField tfSpouseDOB;
    private JTextField tfSpouseTin;
    private JTextField tfSpouseOccupation;
    private JTextField tfSpouseBusinessPhone;
    private JTextField tfEmployerName;
    private JTextField tfSpousePosition;
    private JTextField tfSpouseYearsEmployment;
    private JButton btnNext;
    private JButton btnBack;

    private final ApplicationData appData;
    private final MultiStepForm parent;
    
    public Step4Panel(MultiStepForm parent, ApplicationData appData) {
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
                "Spouse Information", TitledBorder.LEFT, TitledBorder.TOP));

        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Spouse Pagibig MID
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblSpousePagibigMid = new JLabel("Spouse Pag-IBIG MID No:");
        lblSpousePagibigMid.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpousePagibigMid, gbc);
        tfSpousePagibigMid = new JTextField(15);
        tfSpousePagibigMid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String spousePagibigMid = appData.getSpouse().getStrSpousePagibigMid();
        tfSpousePagibigMid.setText(spousePagibigMid != null ? spousePagibigMid : "");
        gbc.gridx = 1;
        this.add(tfSpousePagibigMid, gbc);

        // Spouse Name
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblSpouseName = new JLabel("Spouse Name:");
        lblSpouseName.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpouseName, gbc);
        tfSpouseName = new JTextField(15);
        tfSpouseName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String spouseName = appData.getSpouse().getStrSpouseName();
        tfSpouseName.setText(spouseName != null ? spouseName : "");
        gbc.gridx = 3;
        this.add(tfSpouseName, gbc);

        row++;

        // Spouse Citizenship
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblSpouseCitizenship = new JLabel("Spouse Citizenship:");
        lblSpouseCitizenship.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpouseCitizenship, gbc);
        String[] citizenshipOptions = {"", "Filipino", "Dual Citizen", "Foreign National"};
        cbSpouseCitizenship = new JComboBox<>(citizenshipOptions);
        cbSpouseCitizenship.setFont(new Font("SansSerif", Font.PLAIN, 16));
        Spouse.Citizenship spouseCitizenship = appData.getSpouse().getEnumSpouseCitizenship();
        if (spouseCitizenship != null) {
            switch (spouseCitizenship) {
                case F -> cbSpouseCitizenship.setSelectedItem("Filipino");
                case DC -> cbSpouseCitizenship.setSelectedItem("Dual Citizen");
                case FN -> cbSpouseCitizenship.setSelectedItem("Foreign National");
                default -> cbSpouseCitizenship.setSelectedIndex(0);
            }
        } else {
            cbSpouseCitizenship.setSelectedIndex(0);
        }
        gbc.gridx = 1;
        this.add(cbSpouseCitizenship, gbc);

        // Spouse Date of Birth
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblSpouseDOB = new JLabel("Spouse Date of Birth (yyyy-MM-dd):");
        lblSpouseDOB.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpouseDOB, gbc);
        tfSpouseDOB = new JTextField(15);
        tfSpouseDOB.setFont(new Font("SansSerif", Font.PLAIN, 16));
        LocalDate spouseDOB = appData.getSpouse().getDtSpouseDOB();
        tfSpouseDOB.setText(spouseDOB != null ? spouseDOB.toString() : "");
        gbc.gridx = 3;
        this.add(tfSpouseDOB, gbc);

        row++;

        // Spouse TIN
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblSpouseTin = new JLabel("Spouse TIN:");
        lblSpouseTin.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpouseTin, gbc);
        tfSpouseTin = new JTextField(15);
        tfSpouseTin.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String spouseTin = appData.getSpouse().getStrSpouseTin();
        tfSpouseTin.setText(spouseTin != null ? spouseTin : "");
        gbc.gridx = 1;
        this.add(tfSpouseTin, gbc);

        // Spouse Occupation
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblSpouseOccupation = new JLabel("Spouse Occupation:");
        lblSpouseOccupation.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpouseOccupation, gbc);
        tfSpouseOccupation = new JTextField(15);
        tfSpouseOccupation.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String spouseOccupation = appData.getSpouse().getStrSpouseOccupation();
        tfSpouseOccupation.setText(spouseOccupation != null ? spouseOccupation : "");
        gbc.gridx = 3;
        this.add(tfSpouseOccupation, gbc);

        row++;

        // Spouse Business Phone
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblSpouseBusinessPhone = new JLabel("Spouse Business Phone:");
        lblSpouseBusinessPhone.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpouseBusinessPhone, gbc);
        tfSpouseBusinessPhone = new JTextField(15);
        tfSpouseBusinessPhone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String spouseBusinessPhone = appData.getSpouse().getStrSpouseBusinessPhone();
        tfSpouseBusinessPhone.setText(spouseBusinessPhone != null ? spouseBusinessPhone : "");
        gbc.gridx = 1;
        this.add(tfSpouseBusinessPhone, gbc);

        // Employer Name
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblEmployerName = new JLabel("Employer Name:");
        lblEmployerName.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmployerName, gbc);
        tfEmployerName = new JTextField(15);
        tfEmployerName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String employerName = appData.getSpouse().getEmployerName();
        tfEmployerName.setText(employerName != null ? employerName : "");
        gbc.gridx = 3;
        this.add(tfEmployerName, gbc);

        row++;
        
        // Spouse Position
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblSpousePosition = new JLabel("Spouse Position:");
        lblSpousePosition.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpousePosition, gbc);
        tfSpousePosition = new JTextField(15);
        tfSpousePosition.setFont(new Font("SansSerif", Font.PLAIN, 16));
        String spousePosition = appData.getSpouse().getStrSpousePosition();
        tfSpousePosition.setText(spousePosition != null ? spousePosition : "");
        gbc.gridx = 1;
        this.add(tfSpousePosition, gbc);

        // Spouse Years Employment
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblSpouseYearsEmployment = new JLabel("Spouse Years Employment:");
        lblSpouseYearsEmployment.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblSpouseYearsEmployment, gbc);
        tfSpouseYearsEmployment = new JTextField(15);
        tfSpouseYearsEmployment.setFont(new Font("SansSerif", Font.PLAIN, 16));
        Integer spouseYearsEmployment = appData.getSpouse().getIntSpouseYearsEmployment();
        tfSpouseYearsEmployment.setText(spouseYearsEmployment != 0 ? spouseYearsEmployment.toString() : "");
        gbc.gridx = 3;
        this.add(tfSpouseYearsEmployment, gbc);

        row++;

        // Next button
        btnNext = new JButton("Next");
        btnNext.setEnabled(false);
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(btnNext, gbc);

        btnNext.addActionListener(e -> {
            btnNext.setEnabled(false);
            Spouse spouse = appData.getSpouse();

            if (tfSpousePagibigMid.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Step4Panel.this, "Spouse Pag-IBIG MID cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                btnNext.setEnabled(true);
                return;
            }
            spouse.setStrSpousePagibigMid(tfSpousePagibigMid.getText().trim());

            spouse.setStrSpouseName(tfSpouseName.getText());

            String citizenship = (String) cbSpouseCitizenship.getSelectedItem();
            if ("Filipino".equals(citizenship)) {
                spouse.setEnumSpouseCitizenship(Citizenship.F);
            } else if ("Dual Citizen".equals(citizenship)) {
                spouse.setEnumSpouseCitizenship(Citizenship.DC);
            } else if ("Foreign National".equals(citizenship)) {
                spouse.setEnumSpouseCitizenship(Citizenship.FN);
            } else {
                spouse.setEnumSpouseCitizenship(null);
            }

            try {
                spouse.setDtSpouseDOB(LocalDate.parse(tfSpouseDOB.getText(), DateTimeFormatter.ISO_LOCAL_DATE));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Step4Panel.this, "Invalid date format. Use yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                btnNext.setEnabled(true);
                return;
            }

            spouse.setStrSpouseTin(tfSpouseTin.getText());
            spouse.setStrSpouseOccupation(tfSpouseOccupation.getText());
            spouse.setStrSpouseBusinessPhone(tfSpouseBusinessPhone.getText());

            spouse.setEmployerName(tfEmployerName.getText());
            spouse.setStrSpousePosition(tfSpousePosition.getText());

            try {
                spouse.setIntSpouseYearsEmployment(Integer.parseInt(tfSpouseYearsEmployment.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Step4Panel.this, "Invalid years of employment.", "Error", JOptionPane.ERROR_MESSAGE);
                btnNext.setEnabled(true);
                return;
            }

            // Set member's PagibigMid as foreign key in spouse
            spouse.setPagibigMid(appData.getMember().getPagibigMid());

            System.out.println("Saved Spouse Data:");
            System.out.println("Pag-IBIG MID: " + spouse.getStrSpousePagibigMid());
            System.out.println("Name: " + spouse.getStrSpouseName());
            System.out.println("Citizenship: " + spouse.getEnumSpouseCitizenship());
            System.out.println("Date of Birth: " + spouse.getDtSpouseDOB());
            System.out.println("TIN: " + spouse.getStrSpouseTin());
            System.out.println("Occupation: " + spouse.getStrSpouseOccupation());
            System.out.println("Business Phone: " + spouse.getStrSpouseBusinessPhone());
            System.out.println("Employer ID: " + spouse.getIntEmployerId());
            System.out.println("Employer Name: " + spouse.getEmployerName());
            System.out.println("Position: " + spouse.getStrSpousePosition());
            System.out.println("Years Employment: " + spouse.getIntSpouseYearsEmployment());

            parent.nextStep();
        });

        // Back button
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

        validateForm();

        this.revalidate();
        this.repaint();
    }

    private void setupValidationListeners() {
        DocumentListener docListener = new DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
        };

        tfSpousePagibigMid.getDocument().addDocumentListener(docListener);
        tfSpouseName.getDocument().addDocumentListener(docListener);
        tfSpouseDOB.getDocument().addDocumentListener(docListener);
        tfSpouseTin.getDocument().addDocumentListener(docListener);
        tfSpouseOccupation.getDocument().addDocumentListener(docListener);
        tfSpouseBusinessPhone.getDocument().addDocumentListener(docListener);
        tfEmployerName.getDocument().addDocumentListener(docListener);
        tfSpousePosition.getDocument().addDocumentListener(docListener);
        tfSpouseYearsEmployment.getDocument().addDocumentListener(docListener);

        cbSpouseCitizenship.addActionListener(e -> validateForm());
    }

    void validateForm() {
        boolean valid = true;

        if (tfSpousePagibigMid.getText().trim().isEmpty()) valid = false;
        if (tfSpouseName.getText().trim().isEmpty()) valid = false;
        if (cbSpouseCitizenship.getSelectedIndex() == 0) valid = false;
        if (tfSpouseDOB.getText().trim().isEmpty()) valid = false;
        else {
            try {
                LocalDate.parse(tfSpouseDOB.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (tfSpouseTin.getText().trim().isEmpty()) valid = false;
        if (tfSpouseOccupation.getText().trim().isEmpty()) valid = false;
        if (tfSpouseBusinessPhone.getText().trim().isEmpty()) valid = false;
        if (tfEmployerName.getText().trim().isEmpty()) valid = false;
        if (tfSpousePosition.getText().trim().isEmpty()) valid = false;
        if (tfSpouseYearsEmployment.getText().trim().isEmpty()) valid = false;

        btnNext.setEnabled(valid);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
