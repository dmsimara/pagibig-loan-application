package com.mycompany.pagibigapplication.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;

import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.models.Collateral;

public class Step3Panel extends javax.swing.JPanel {
    
    private JTextField tfTctOctCctNo;
    private JTextField tfPrimaryPropertyLocation;
    private JComboBox<String> cbPropertyType;
    private JTextField tfDeveloperTitleHolder;
    private JComboBox<String> cbDescriptionOfImprovements;
    private JTextField tfTaxDeclarationNo;
    private JTextField tfLotUnitNo;
    private JTextField tfBlockBuildingNo;
    private JTextField tfNumberOfStoreys;
    private JCheckBox chkIsPropertyMortgaged;
    private JTextField tfLandAreaSqm;
    private JTextField tfFloorAreaSqm;
    private JTextField tfAgeOfHouse;
    private JTextField tfTotalFloorAreaSqm;
    private JCheckBox chkIsOffsiteCollateral;
    private JTextField tfOffsiteCollateralReason;
    private JTextField tfHousingAccountNo;

    private JButton btnNext;
    private JButton btnBack;

    private final ApplicationData appData;
    private final MultiStepForm parent;

    public Step3Panel(MultiStepForm parent, ApplicationData appData) {
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
                "Property Information", TitledBorder.LEFT, TitledBorder.TOP));
        
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // TctOctCctNo
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblTctOctCctNo = new JLabel("TCT/OCT/CCT No:");
        lblTctOctCctNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblTctOctCctNo, gbc);
        tfTctOctCctNo = new JTextField(15);
        tfTctOctCctNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfTctOctCctNo, gbc);

        // Primary Property Location
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblPrimaryPropertyLocation = new JLabel("Primary Property Location:");
        lblPrimaryPropertyLocation.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPrimaryPropertyLocation, gbc);
        tfPrimaryPropertyLocation = new JTextField(15);
        tfPrimaryPropertyLocation.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfPrimaryPropertyLocation, gbc);

        row++;

        // Property Type
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblPropertyType = new JLabel("Property Type:");
        lblPropertyType.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPropertyType, gbc);
        cbPropertyType = new JComboBox<>(new String[]{
                "RESIDENTIAL LOT",
                "HOUSE AND LOT",
                "TOWNHOUSE",
                "CONDOMINIUM UNIT",
                "FORECLOSED PROPERTY"
        });
        cbPropertyType.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(cbPropertyType, gbc);

        // Developer Title Holder
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblDeveloperTitleHolder = new JLabel("Developer Title Holder:");
        lblDeveloperTitleHolder.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblDeveloperTitleHolder, gbc);
        tfDeveloperTitleHolder = new JTextField(15);
        tfDeveloperTitleHolder.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfDeveloperTitleHolder, gbc);

        row++;

        // Description Of Improvements
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblDescriptionOfImprovements = new JLabel("Description Of Improvements:");
        lblDescriptionOfImprovements.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblDescriptionOfImprovements, gbc);
        cbDescriptionOfImprovements = new JComboBox<>(new String[]{
                "EXISTING",
                "PROPOSED"
        });
        cbDescriptionOfImprovements.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(cbDescriptionOfImprovements, gbc);

        // Tax Declaration No
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblTaxDeclarationNo = new JLabel("Tax Declaration No:");
        lblTaxDeclarationNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblTaxDeclarationNo, gbc);
        tfTaxDeclarationNo = new JTextField(15);
        tfTaxDeclarationNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfTaxDeclarationNo, gbc);

        row++;

        // Lot/Unit No
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblLotUnitNo = new JLabel("Lot/Unit No:");
        lblLotUnitNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblLotUnitNo, gbc);
        tfLotUnitNo = new JTextField(15);
        tfLotUnitNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfLotUnitNo, gbc);

        // Block/Building No
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblBlockBuildingNo = new JLabel("Block/Building No:");
        lblBlockBuildingNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblBlockBuildingNo, gbc);
        tfBlockBuildingNo = new JTextField(15);
        tfBlockBuildingNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(tfBlockBuildingNo, gbc);

        row++;

        // Number Of Storeys
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblNumberOfStoreys = new JLabel("Number Of Storeys:");
        lblNumberOfStoreys.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblNumberOfStoreys, gbc);
        tfNumberOfStoreys = new JTextField(15);
        tfNumberOfStoreys.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setNumericDocumentFilter(tfNumberOfStoreys);
        gbc.gridx = 1;
        this.add(tfNumberOfStoreys, gbc);

        // Is Property Mortgaged
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblIsPropertyMortgaged = new JLabel("Is Property Mortgaged:");
        lblIsPropertyMortgaged.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblIsPropertyMortgaged, gbc);
        chkIsPropertyMortgaged = new JCheckBox();
        gbc.gridx = 3;
        this.add(chkIsPropertyMortgaged, gbc);

        row++;

        // Land Area Sqm
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblLandAreaSqm = new JLabel("Land Area (sqm):");
        lblLandAreaSqm.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblLandAreaSqm, gbc);
        tfLandAreaSqm = new JTextField(15);
        tfLandAreaSqm.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setDecimalDocumentFilter(tfLandAreaSqm);
        gbc.gridx = 1;
        this.add(tfLandAreaSqm, gbc);

        // Floor Area Sqm
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblFloorAreaSqm = new JLabel("Floor Area (sqm):");
        lblFloorAreaSqm.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblFloorAreaSqm, gbc);
        tfFloorAreaSqm = new JTextField(15);
        tfFloorAreaSqm.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setDecimalDocumentFilter(tfFloorAreaSqm);
        gbc.gridx = 3;
        this.add(tfFloorAreaSqm, gbc);

        row++;

        // Age Of House
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblAgeOfHouse = new JLabel("Age Of House:");
        lblAgeOfHouse.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblAgeOfHouse, gbc);
        tfAgeOfHouse = new JTextField(15);
        tfAgeOfHouse.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setNumericDocumentFilter(tfAgeOfHouse);
        gbc.gridx = 1;
        this.add(tfAgeOfHouse, gbc);

        // Total Floor Area Sqm
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblTotalFloorAreaSqm = new JLabel("Total Floor Area (sqm):");
        lblTotalFloorAreaSqm.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblTotalFloorAreaSqm, gbc);
        tfTotalFloorAreaSqm = new JTextField(15);
        tfTotalFloorAreaSqm.setFont(new Font("SansSerif", Font.PLAIN, 16));
        setDecimalDocumentFilter(tfTotalFloorAreaSqm);
        gbc.gridx = 3;
        this.add(tfTotalFloorAreaSqm, gbc);

        row++;

        // Is Offsite Collateral
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblIsOffsiteCollateral = new JLabel("Is Offsite Collateral:");
        lblIsOffsiteCollateral.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblIsOffsiteCollateral, gbc);
        chkIsOffsiteCollateral = new JCheckBox();
        chkIsOffsiteCollateral.addItemListener(e -> {
            boolean selected = chkIsOffsiteCollateral.isSelected();
            tfOffsiteCollateralReason.setEnabled(selected);
            validateForm(); 
        });
        gbc.gridx = 1;
        this.add(chkIsOffsiteCollateral, gbc);

        // Offsite Collateral Reason
        gbc.gridx = 2;
        gbc.gridy = row;
        JLabel lblOffsiteCollateralReason = new JLabel("Offsite Collateral Reason:");
        lblOffsiteCollateralReason.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblOffsiteCollateralReason, gbc);
        tfOffsiteCollateralReason = new JTextField(15);
        tfOffsiteCollateralReason.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfOffsiteCollateralReason.setEnabled(false); 
        gbc.gridx = 3;
        this.add(tfOffsiteCollateralReason, gbc);

        row++;

        // Housing Account No
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblHousingAccountNo = new JLabel("Housing Account No:");
        lblHousingAccountNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblHousingAccountNo, gbc);
        tfHousingAccountNo = new JTextField(15);
        tfHousingAccountNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfHousingAccountNo.setEnabled(false); 
        gbc.gridx = 1;
        this.add(tfHousingAccountNo, gbc);

        row++;

        // Buttons
        btnNext = new JButton("Next");
        btnNext.setEnabled(false);
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(btnNext, gbc);

        btnBack = new JButton("Back");
        GridBagConstraints gbcBack = new GridBagConstraints();
        gbcBack.gridx = 2;
        gbcBack.gridy = row;
        gbcBack.anchor = GridBagConstraints.EAST;
        this.add(btnBack, gbcBack);

        btnNext.addActionListener(e -> {
            if (!validateForm()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields correctly.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            saveData();
            parent.nextStep();
        });

        btnBack.addActionListener(e -> {
            saveData(); 
            parent.previousStep();
        });

        setupValidationListeners();

        loadData();

        tfOffsiteCollateralReason.setEnabled(chkIsOffsiteCollateral.isSelected());

        this.revalidate();
        this.repaint();
    }

    private void loadData() {
        Collateral collateral = appData.getCollateral();

        tfTctOctCctNo.setText(collateral.getIntTctOctCctNo() != null ? collateral.getIntTctOctCctNo() : "");
        tfPrimaryPropertyLocation.setText(collateral.getStrPrimaryPropertyLocation() != null ? collateral.getStrPrimaryPropertyLocation() : "");

        if (collateral.getEnumPropertyType() != null) {
            cbPropertyType.setSelectedItem(collateral.getEnumPropertyType().name().replace("_", " "));
        } else {
            cbPropertyType.setSelectedIndex(-1);
        }

        tfDeveloperTitleHolder.setText(collateral.getStrDeveloperTitleHolder() != null ? collateral.getStrDeveloperTitleHolder() : "");

        if (collateral.getEnumDescriptionOfImprovements() != null) {
            cbDescriptionOfImprovements.setSelectedItem(collateral.getEnumDescriptionOfImprovements().name());
        } else {
            cbDescriptionOfImprovements.setSelectedIndex(-1);
        }

        tfTaxDeclarationNo.setText(collateral.getStrTaxDeclarationNo() != null ? collateral.getStrTaxDeclarationNo() : "");
        tfLotUnitNo.setText(collateral.getStrLotUnitNo() != null ? collateral.getStrLotUnitNo() : "");
        tfBlockBuildingNo.setText(collateral.getStrBlockBuildingNo() != null ? collateral.getStrBlockBuildingNo() : "");

        Integer numberOfStoreys = collateral.getIntNumberOfStoreys();
        tfNumberOfStoreys.setText(numberOfStoreys != 0 && numberOfStoreys > 0 ? String.valueOf(numberOfStoreys) : "");

        chkIsPropertyMortgaged.setSelected(collateral.isBoolIsPropertyMortgaged());

        tfLandAreaSqm.setText(collateral.getBdLandAreaSqm() != null ? collateral.getBdLandAreaSqm().toString() : "");
        tfFloorAreaSqm.setText(collateral.getBdFloorAreaSqm() != null ? collateral.getBdFloorAreaSqm().toString() : "");

        Integer ageOfHouse = collateral.getIntAgeOfHouse();
        tfAgeOfHouse.setText(ageOfHouse != 0 && ageOfHouse > 0 ? String.valueOf(ageOfHouse) : "");

        tfTotalFloorAreaSqm.setText(collateral.getBdTotalFloorAreaSqm() != null ? collateral.getBdTotalFloorAreaSqm().toString() : "");
        chkIsOffsiteCollateral.setSelected(collateral.isBoolIsOffsiteCollateral());
        tfOffsiteCollateralReason.setText(collateral.getStrOffsiteCollateralReason() != null ? collateral.getStrOffsiteCollateralReason() : "");

        tfHousingAccountNo.setText(appData.getLoan().getHousingAccountNo() != null ? appData.getLoan().getHousingAccountNo() : "");
    }

    private void saveData() {
        Collateral collateral = appData.getCollateral();

        collateral.setIntTctOctCctNo(tfTctOctCctNo.getText().trim());
        collateral.setStrPrimaryPropertyLocation(tfPrimaryPropertyLocation.getText().trim());

        String propertyTypeStr = (String) cbPropertyType.getSelectedItem();
        if (propertyTypeStr != null && !propertyTypeStr.isEmpty()) {
            collateral.setEnumPropertyType(Collateral.PropertyType.fromString(propertyTypeStr));
        } else {
            collateral.setEnumPropertyType(null);
        }

        collateral.setStrDeveloperTitleHolder(tfDeveloperTitleHolder.getText().trim());

        String descImpStr = (String) cbDescriptionOfImprovements.getSelectedItem();
        if (descImpStr != null && !descImpStr.isEmpty()) {
            collateral.setEnumDescriptionOfImprovements(Collateral.DescriptionOfImprovements.valueOf(descImpStr));
        } else {
            collateral.setEnumDescriptionOfImprovements(null);
        }

        collateral.setStrTaxDeclarationNo(tfTaxDeclarationNo.getText().trim());
        collateral.setStrLotUnitNo(tfLotUnitNo.getText().trim());
        collateral.setStrBlockBuildingNo(tfBlockBuildingNo.getText().trim());

        try {
            String numberOfStoreysText = tfNumberOfStoreys.getText().trim();
            collateral.setIntNumberOfStoreys(!numberOfStoreysText.isEmpty() ? Integer.parseInt(numberOfStoreysText) : null);
        } catch (NumberFormatException e) {
            collateral.setIntNumberOfStoreys(0);
        }

        collateral.setBoolIsPropertyMortgaged(chkIsPropertyMortgaged.isSelected());

        try {
            String landAreaText = tfLandAreaSqm.getText().trim();
            collateral.setBdLandAreaSqm(!landAreaText.isEmpty() ? new BigDecimal(landAreaText) : null);
        } catch (NumberFormatException e) {
            collateral.setBdLandAreaSqm(null);
        }

        try {
            String floorAreaText = tfFloorAreaSqm.getText().trim();
            collateral.setBdFloorAreaSqm(!floorAreaText.isEmpty() ? new BigDecimal(floorAreaText) : null);
        } catch (NumberFormatException e) {
            collateral.setBdFloorAreaSqm(null);
        }

        try {
            String ageOfHouseText = tfAgeOfHouse.getText().trim();
            collateral.setIntAgeOfHouse(!ageOfHouseText.isEmpty() ? Integer.parseInt(ageOfHouseText) : null);
        } catch (NumberFormatException e) {
            collateral.setIntAgeOfHouse(0);
        }

        try {
            String totalFloorAreaText = tfTotalFloorAreaSqm.getText().trim();
            collateral.setBdTotalFloorAreaSqm(!totalFloorAreaText.isEmpty() ? new BigDecimal(totalFloorAreaText) : null);
        } catch (NumberFormatException e) {
            collateral.setBdTotalFloorAreaSqm(null);
        }

        collateral.setBoolIsOffsiteCollateral(chkIsOffsiteCollateral.isSelected());
        collateral.setStrOffsiteCollateralReason(tfOffsiteCollateralReason.getText().trim());

        // Preserve housing account no from step1
        collateral.setStrHousingAccountNo(appData.getLoan().getHousingAccountNo());

        System.out.println("Saving Collateral Data:");
        System.out.println("TCT/OCT/CCT No: " + collateral.getIntTctOctCctNo());
        System.out.println("Primary Property Location: " + collateral.getStrPrimaryPropertyLocation());
        System.out.println("Property Type: " + collateral.getEnumPropertyType());
        System.out.println("Developer Title Holder: " + collateral.getStrDeveloperTitleHolder());
        System.out.println("Description Of Improvements: " + collateral.getEnumDescriptionOfImprovements());
        System.out.println("Tax Declaration No: " + collateral.getStrTaxDeclarationNo());
        System.out.println("Lot/Unit No: " + collateral.getStrLotUnitNo());
        System.out.println("Block/Building No: " + collateral.getStrBlockBuildingNo());
        System.out.println("Number Of Storeys: " + collateral.getIntNumberOfStoreys());
        System.out.println("Is Property Mortgaged: " + collateral.isBoolIsPropertyMortgaged());
        System.out.println("Land Area (sqm): " + collateral.getBdLandAreaSqm());
        System.out.println("Floor Area (sqm): " + collateral.getBdFloorAreaSqm());
        System.out.println("Age Of House: " + collateral.getIntAgeOfHouse());
        System.out.println("Total Floor Area (sqm): " + collateral.getBdTotalFloorAreaSqm());
        System.out.println("Is Offsite Collateral: " + collateral.isBoolIsOffsiteCollateral());
        System.out.println("Offsite Collateral Reason: " + collateral.getStrOffsiteCollateralReason());
        System.out.println("Housing Account No: " + collateral.getStrHousingAccountNo());
    }


    private void setupValidationListeners() {
        tfTctOctCctNo.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfPrimaryPropertyLocation.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        cbPropertyType.addActionListener(e -> validateForm());
        tfDeveloperTitleHolder.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        cbDescriptionOfImprovements.addActionListener(e -> validateForm());
        tfTaxDeclarationNo.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfLotUnitNo.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfBlockBuildingNo.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfNumberOfStoreys.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        chkIsPropertyMortgaged.addActionListener(e -> validateForm());
        tfLandAreaSqm.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfFloorAreaSqm.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfAgeOfHouse.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfTotalFloorAreaSqm.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        chkIsOffsiteCollateral.addActionListener(e -> validateForm());
        tfOffsiteCollateralReason.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
        tfHousingAccountNo.getDocument().addDocumentListener(new SimpleDocumentListener(this::validateForm));
    }

    boolean validateForm() {
        boolean valid = true;

        if (tfTctOctCctNo.getText().trim().isEmpty()) valid = false;
        if (tfPrimaryPropertyLocation.getText().trim().isEmpty()) valid = false;
        if (cbPropertyType.getSelectedIndex() == -1) valid = false;
        if (tfDeveloperTitleHolder.getText().trim().isEmpty()) valid = false;
        if (cbDescriptionOfImprovements.getSelectedIndex() == -1) valid = false;
        if (tfTaxDeclarationNo.getText().trim().isEmpty()) valid = false;
        if (tfLotUnitNo.getText().trim().isEmpty()) valid = false;
        if (tfBlockBuildingNo.getText().trim().isEmpty()) valid = false;
        if (tfNumberOfStoreys.getText().trim().isEmpty()) valid = false;
        if (tfLandAreaSqm.getText().trim().isEmpty()) valid = false;
        if (tfFloorAreaSqm.getText().trim().isEmpty()) valid = false;
        if (tfAgeOfHouse.getText().trim().isEmpty()) valid = false;
        if (tfTotalFloorAreaSqm.getText().trim().isEmpty()) valid = false;
        if (chkIsOffsiteCollateral.isSelected() && tfOffsiteCollateralReason.getText().trim().isEmpty()) valid = false;
        if (tfHousingAccountNo.getText().trim().isEmpty()) valid = false;

        btnNext.setEnabled(valid);
        return valid;
    }

    private static class SimpleDocumentListener implements javax.swing.event.DocumentListener {
        private final Runnable onChange;

        public SimpleDocumentListener(Runnable onChange) {
            this.onChange = onChange;
        }

        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            onChange.run();
        }

        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            onChange.run();
        }

        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            onChange.run();
        }
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

    private void setDecimalDocumentFilter(JTextField textField) {
        PlainDocument doc = (PlainDocument) textField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) return;
                if (string.matches("[0-9.]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;
                if (text.matches("[0-9.]*")) {
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
