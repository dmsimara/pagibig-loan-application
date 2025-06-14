
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.models.RealEstate;
import com.mycompany.pagibigapplication.models.RealEstate.RealEstateType;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentListener;

public class Step6Panel extends javax.swing.JPanel {
    
    private final ApplicationData appData;
    private final MultiStepForm parent;

    private JPanel panelContainer;
    private JButton btnAddBatch;
    private JButton btnRemoveBatch;
    private JButton btnNext;
    private JButton btnBack;

    private int batchCount = 0;
    private final int maxBatches = 3;

    private List<RealEstatePanel> realEstatePanels = new ArrayList<>();

    public Step6Panel(MultiStepForm parent, ApplicationData appData) {
        this.parent = parent;
        this.appData = appData;
        initComponents();
        setupForm();
    }

    void setupForm() {
        this.removeAll();
        this.setLayout(new BorderLayout());

        panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddBatch = new JButton("Add Real Estate Info");
        btnRemoveBatch = new JButton("Remove Real Estate Info");
        btnRemoveBatch.setEnabled(false);

        controlPanel.add(btnAddBatch);
        controlPanel.add(btnRemoveBatch);

        this.add(controlPanel, BorderLayout.SOUTH);

        List<RealEstate> savedRealEstates = appData.getRealEstateList();
        if (savedRealEstates != null && !savedRealEstates.isEmpty()) {
            for (int i = 0; i < savedRealEstates.size(); i++) {
                addRealEstatePanel(savedRealEstates.get(i), i + 1);
            }
        } else {
            addRealEstatePanel(null, 1);
        }

        btnAddBatch.addActionListener(e -> {
            if (batchCount < maxBatches) {
                addRealEstatePanel(null, batchCount + 1);
                btnRemoveBatch.setEnabled(true);
                if (batchCount + 1 >= maxBatches) {
                    btnAddBatch.setEnabled(false);
                }
            }
        });

        btnRemoveBatch.addActionListener(e -> {
            if (batchCount > 1) {
                removeRealEstatePanel();
                btnAddBatch.setEnabled(true);
                if (batchCount == 1) {
                    btnRemoveBatch.setEnabled(false);
                }
            }
        });

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnNext = new JButton("Next");
        btnBack = new JButton("Back");
        btnNext.setEnabled(false);

        navPanel.add(btnBack);
        navPanel.add(btnNext);

        this.add(navPanel, BorderLayout.NORTH);

        btnNext.addActionListener(e -> {
            if (saveAllRealEstateInfo()) {
                parent.nextStep();
            }
        });

        btnBack.addActionListener(e -> parent.previousStep());

        validateForm();
        this.revalidate();
        this.repaint();
    }

    private void addRealEstatePanel(RealEstate realEstateData, int index) {
        RealEstatePanel realEstatePanel = new RealEstatePanel(realEstateData, index);
        realEstatePanels.add(realEstatePanel);
        panelContainer.add(realEstatePanel);
        batchCount++;
        this.revalidate();
        this.repaint();
        if (btnNext != null) {
            validateForm();
        }
    }

    private void removeRealEstatePanel() {
        if (batchCount > 0) {
            RealEstatePanel toRemove = realEstatePanels.remove(realEstatePanels.size() - 1);
            panelContainer.remove(toRemove);
            batchCount--;
            this.revalidate();
            this.repaint();
            validateForm();
        }
    }

    private boolean saveAllRealEstateInfo() {
        List<RealEstate> realEstatesToSave = new ArrayList<>();
        for (RealEstatePanel panel : realEstatePanels) {
            if (!panel.isEmpty()) {
                if (!panel.isValidData()) {
                    JOptionPane.showMessageDialog(this, "Please fill all required fields correctly in all batches.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                realEstatesToSave.add(panel.getRealEstateData());
            }
        }
        appData.setRealEstateList(realEstatesToSave);
        if (!realEstatesToSave.isEmpty()) {
            appData.getRealEstate().setStrHousingAccountNo(appData.getLoan().getHousingAccountNo());
        }

        System.out.println("Saved Real Estate Records:");
        for (int i = 0; i < realEstatesToSave.size(); i++) {
            RealEstate re = realEstatesToSave.get(i);
            System.out.println("Batch " + (i + 1) + ":");
            System.out.println("  Real Estate Type: " + (re.getEnumRealEstateType() != null ? re.getEnumRealEstateType().name() : "null"));
            System.out.println("  Housing Account No: " + re.getStrHousingAccountNo());
            System.out.println("  Acquisition Cost: " + re.getBdAcquisitionCost());
            System.out.println("  Market Value: " + re.getBdMarketValue());
            System.out.println("  Mortgage Balance: " + re.getBdMortgageBalance());
            System.out.println("  Rental Income: " + re.getBdRentalIncome());
            System.out.println("  Real Estate Location: " + re.getStrRealEstateLocation());
        }

        return true;
    }

    void validateForm() {
        boolean anyValid = false;
        for (RealEstatePanel panel : realEstatePanels) {
            if (panel.isValidData()) {
                anyValid = true;
                break;
            }
        }
        btnNext.setEnabled(anyValid);
    }

    private class RealEstatePanel extends JPanel {
        private JComboBox<String> cbRealEstateType;
        private JTextField tfHousingAccountNo;
        private JTextField tfAcquisitionCost;
        private JTextField tfMarketValue;
        private JTextField tfMortgageBalance;
        private JTextField tfRentalIncome;
        private JTextField tfRealEstateLocation;

        private int batchIndex;

        public RealEstatePanel(RealEstate realEstateData, int index) {
            this.batchIndex = index;
            setupPanel(realEstateData);
        }

        private void setupPanel(RealEstate realEstateData) {
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Real Estate Batch " + batchIndex, TitledBorder.LEFT, TitledBorder.TOP));
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(2, 10, 5, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;

            int row = 0;
            
            // Real Estate Location
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblRealEstateLocation = new JLabel("Real Estate Location:");
            lblRealEstateLocation.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblRealEstateLocation, gbc);
            tfRealEstateLocation = new JTextField(15);
            tfRealEstateLocation.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfRealEstateLocation.setText(realEstateData != null && realEstateData.getStrRealEstateLocation() != null ? realEstateData.getStrRealEstateLocation() : "");
            gbc.gridx = 1;
            this.add(tfRealEstateLocation, gbc);

            // Real Estate Type
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblRealEstateType = new JLabel("Real Estate Type:");
            lblRealEstateType.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblRealEstateType, gbc);
            String[] realEstateTypeOptions = {
                "", "RESIDENTIAL LOT", "HOUSE AND LOT", "TOWNHOUSE", "CONDOMINIUM UNIT",
                "FORECLOSED PROPERTY", "ROWHOUSE", "DUPLEX", "VACANT LOT"
            };
            cbRealEstateType = new JComboBox<>(realEstateTypeOptions);
            cbRealEstateType.setFont(new Font("SansSerif", Font.PLAIN, 16));
            if (realEstateData != null && realEstateData.getEnumRealEstateType() != null) {
                cbRealEstateType.setSelectedItem(realEstateData.getEnumRealEstateType().name().replace("_", " "));
            } else {
                cbRealEstateType.setSelectedIndex(0);
            }
            gbc.gridx = 3;
            this.add(cbRealEstateType, gbc);

            row++;
            
            // Housing Account No (disabled)
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblHousingAccountNo = new JLabel("Housing Account No:");
            lblHousingAccountNo.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblHousingAccountNo, gbc);
            tfHousingAccountNo = new JTextField(15);
            tfHousingAccountNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
            String housingAccountNo = appData.getLoan().getHousingAccountNo();
            tfHousingAccountNo.setText(housingAccountNo != null ? housingAccountNo : "");
            tfHousingAccountNo.setEnabled(false);
            gbc.gridx = 1;
            this.add(tfHousingAccountNo, gbc);

            // Acquisition Cost
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblAcquisitionCost = new JLabel("Acquisition Cost:");
            lblAcquisitionCost.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblAcquisitionCost, gbc);
            tfAcquisitionCost = new JTextField(15);
            tfAcquisitionCost.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfAcquisitionCost.setText(realEstateData != null && realEstateData.getBdAcquisitionCost() != null ? realEstateData.getBdAcquisitionCost().toString() : "");
            ((PlainDocument) tfAcquisitionCost.getDocument()).setDocumentFilter(new DocumentFilter() {
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
            gbc.gridx = 3;
            this.add(tfAcquisitionCost, gbc);

            row++;
            
            // Market Value
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblMarketValue = new JLabel("Market Value:");
            lblMarketValue.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblMarketValue, gbc);
            tfMarketValue = new JTextField(15);
            tfMarketValue.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfMarketValue.setText(realEstateData != null && realEstateData.getBdMarketValue() != null ? realEstateData.getBdMarketValue().toString() : "");
            ((PlainDocument) tfMarketValue.getDocument()).setDocumentFilter(new DocumentFilter() {
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
            gbc.gridx = 1;
            this.add(tfMarketValue, gbc);


            // Mortgage Balance
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblMortgageBalance = new JLabel("Mortgage Balance:");
            lblMortgageBalance.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblMortgageBalance, gbc);
            tfMortgageBalance = new JTextField(15);
            tfMortgageBalance.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfMortgageBalance.setText(realEstateData != null && realEstateData.getBdMortgageBalance() != null ? realEstateData.getBdMortgageBalance().toString() : "");
            ((PlainDocument) tfMortgageBalance.getDocument()).setDocumentFilter(new DocumentFilter() {
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
            gbc.gridx = 3;
            this.add(tfMortgageBalance, gbc);

            row++;
            
            // Rental Income
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblRentalIncome = new JLabel("Rental Income:");
            lblRentalIncome.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblRentalIncome, gbc);
            tfRentalIncome = new JTextField(15);
            tfRentalIncome.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfRentalIncome.setText(realEstateData != null && realEstateData.getBdRentalIncome() != null ? realEstateData.getBdRentalIncome().toString() : "");
            ((PlainDocument) tfRentalIncome.getDocument()).setDocumentFilter(new DocumentFilter() {
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
            gbc.gridx = 1;
            this.add(tfRentalIncome, gbc);


            DocumentListener docListener = new DocumentListener() {
                public void insertUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
                public void removeUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
                public void changedUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            };
            tfAcquisitionCost.getDocument().addDocumentListener(docListener);
            tfMarketValue.getDocument().addDocumentListener(docListener);
            tfMortgageBalance.getDocument().addDocumentListener(docListener);
            tfRentalIncome.getDocument().addDocumentListener(docListener);
            cbRealEstateType.addActionListener(e -> validateForm());
            tfRealEstateLocation.addActionListener(e -> validateForm());
        }

        public RealEstate getRealEstateData() {
            RealEstate realEstate = new RealEstate();

            String selectedType = (String) cbRealEstateType.getSelectedItem();
            if (selectedType != null && !selectedType.isEmpty()) {
                realEstate.setEnumRealEstateType(RealEstateType.fromString(selectedType));
            } else {
                realEstate.setEnumRealEstateType(null);
            }
                    
 
            realEstate.setStrRealEstateLocation(tfRealEstateLocation.getText());

            realEstate.setStrHousingAccountNo(tfHousingAccountNo.getText());

            try {
                realEstate.setBdAcquisitionCost(new BigDecimal(tfAcquisitionCost.getText()));
            } catch (NumberFormatException e) {
                realEstate.setBdAcquisitionCost(null);
            }

            try {
                realEstate.setBdMarketValue(new BigDecimal(tfMarketValue.getText()));
            } catch (NumberFormatException e) {
                realEstate.setBdMarketValue(null);
            }

            try {
                realEstate.setBdMortgageBalance(new BigDecimal(tfMortgageBalance.getText()));
            } catch (NumberFormatException e) {
                realEstate.setBdMortgageBalance(null);
            }

            try {
                realEstate.setBdRentalIncome(new BigDecimal(tfRentalIncome.getText()));
            } catch (NumberFormatException e) {
                realEstate.setBdRentalIncome(null);
            }

            return realEstate;
        }

        public boolean isValidData() {
            if (cbRealEstateType.getSelectedIndex() == 0) return false;
            if (tfHousingAccountNo.getText().trim().isEmpty()) return false;
            if (tfAcquisitionCost.getText().trim().isEmpty()) return false;
            if (tfMarketValue.getText().trim().isEmpty()) return false;
            if (tfMortgageBalance.getText().trim().isEmpty()) return false;
            if (tfRentalIncome.getText().trim().isEmpty()) return false;
            if (tfRealEstateLocation.getText().trim().isEmpty()) return false;

            try {
                new BigDecimal(tfAcquisitionCost.getText());
                new BigDecimal(tfMarketValue.getText());
                new BigDecimal(tfMortgageBalance.getText());
                new BigDecimal(tfRentalIncome.getText());
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            return cbRealEstateType.getSelectedIndex() == 0 &&
                    tfAcquisitionCost.getText().trim().isEmpty() &&
                    tfMarketValue.getText().trim().isEmpty() &&
                    tfMortgageBalance.getText().trim().isEmpty() &&
                    tfRealEstateLocation.getText().trim().isEmpty() &&
                    tfRentalIncome.getText().trim().isEmpty();
        }
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
