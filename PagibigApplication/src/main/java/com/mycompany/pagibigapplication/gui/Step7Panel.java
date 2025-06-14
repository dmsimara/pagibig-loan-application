
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.models.OutstandingCredits;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Step7Panel extends javax.swing.JPanel {
    
    private final ApplicationData appData;
    private final MultiStepForm parent;

    private JPanel panelContainer;
    private JButton btnAddBatch;
    private JButton btnRemoveBatch;
    private JButton btnNext;
    private JButton btnBack;

    private int batchCount = 0;
    private final int maxBatches = 3;

    private List<OutstandingCreditPanel> creditPanels = new ArrayList<>();

    public Step7Panel(MultiStepForm parent, ApplicationData appData) {
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
        btnAddBatch = new JButton("Add Credit Info");
        btnRemoveBatch = new JButton("Remove Credit Info");
        btnRemoveBatch.setEnabled(false);

        controlPanel.add(btnAddBatch);
        controlPanel.add(btnRemoveBatch);

        this.add(controlPanel, BorderLayout.SOUTH);

        List<OutstandingCredits> savedCredits = appData.getCreditsList();
        if (savedCredits != null && !savedCredits.isEmpty()) {
            for (int i = 0; i < savedCredits.size(); i++) {
                addCreditPanel(savedCredits.get(i), i + 1);
            }
        } else {
            addCreditPanel(null, 1);
        }

        btnAddBatch.addActionListener(e -> {
            if (batchCount < maxBatches) {
                addCreditPanel(null, batchCount + 1);
                btnRemoveBatch.setEnabled(true);
                if (batchCount + 1 >= maxBatches) {
                    btnAddBatch.setEnabled(false);
                }
            }
        });

        btnRemoveBatch.addActionListener(e -> {
            if (batchCount > 1) {
                removeCreditPanel();
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
            if (saveAllCreditInfo()) {
                parent.nextStep();
            }
        });

        btnBack.addActionListener(e -> parent.previousStep());

        validateForm();
        this.revalidate();
        this.repaint();
    }

    private void addCreditPanel(OutstandingCredits creditData, int index) {
        OutstandingCreditPanel creditPanel = new OutstandingCreditPanel(creditData, index);
        creditPanels.add(creditPanel);
        panelContainer.add(creditPanel);
        batchCount++;
        this.revalidate();
        this.repaint();
        if (btnNext != null) {
            validateForm();
        }
    }

    private void removeCreditPanel() {
        if (batchCount > 0) {
            OutstandingCreditPanel toRemove = creditPanels.remove(creditPanels.size() - 1);
            panelContainer.remove(toRemove);
            batchCount--;
            this.revalidate();
            this.repaint();
            validateForm();
        }
    }

    private boolean saveAllCreditInfo() {
        List<OutstandingCredits> creditsToSave = new ArrayList<>();
        for (OutstandingCreditPanel panel : creditPanels) {
            if (!panel.isEmpty()) {
                if (!panel.isValidData()) {
                    JOptionPane.showMessageDialog(this, "Please fill all required fields correctly in all batches.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                creditsToSave.add(panel.getCreditData());
            }
        }
        appData.setCreditsList(creditsToSave);
        if (!creditsToSave.isEmpty()) {
            appData.getOutstandingCredits().setStrHousingAccountNo(appData.getLoan().getHousingAccountNo()); // For backward compatibility
        }

        // Print saved credit data for verification
        System.out.println("Saved Outstanding Credit Records:");
        for (int i = 0; i < creditsToSave.size(); i++) {
            OutstandingCredits c = creditsToSave.get(i);
            System.out.println("Batch " + (i + 1) + ":");
            System.out.println("  Creditor Name: " + c.getStrCreditorName());
            System.out.println("  Creditor Address: " + c.getStrCreditorAddress());
            System.out.println("  Credit Security: " + (c.getEnumSecurity() != null ? c.getEnumSecurity().name() : "null"));
            System.out.println("  Credit Type: " + (c.getEnumType() != null ? c.getEnumType().name() : "null"));
            System.out.println("  Maturity Date: " + c.getDtMaturityDate());
            System.out.println("  Outstanding Balance: " + c.getBdOutstandingBalance());
            System.out.println("  Monthly Amortization: " + c.getBdMonthlyAmortization());
        }

        return true;
    }

    void validateForm() {
        boolean anyValid = false;
        for (OutstandingCreditPanel panel : creditPanels) {
            if (panel.isValidData()) {
                anyValid = true;
                break;
            }
        }
        btnNext.setEnabled(anyValid);
    }

    private class OutstandingCreditPanel extends JPanel {
        private JTextField tfCreditorName;
        private JTextField tfCreditorAddress;
        private JTextField tfHousingAccountNo;
        private JComboBox<String> cbCreditSecurity;
        private JComboBox<String> cbCreditType;
        private JTextField tfMaturityDate;
        private JTextField tfOutstandingBalance;
        private JTextField tfMonthlyAmortization;

        private int batchIndex;

        public OutstandingCreditPanel(OutstandingCredits creditData, int index) {
            this.batchIndex = index;
            setupPanel(creditData);
        }

        private void setupPanel(OutstandingCredits creditData) {
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Credit Info Batch " + batchIndex, TitledBorder.LEFT, TitledBorder.TOP));
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(5, 10, 5, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;

            int row = 0;

            // Creditor Name
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblCreditorName = new JLabel("Creditor Name:");
            lblCreditorName.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblCreditorName, gbc);
            tfCreditorName = new JTextField(15);
            tfCreditorName.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfCreditorName.setText(creditData != null && creditData.getStrCreditorName() != null ? creditData.getStrCreditorName() : "");
            gbc.gridx = 1;
            this.add(tfCreditorName, gbc);

            // Creditor Address
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblCreditorAddress = new JLabel("Creditor Address:");
            lblCreditorAddress.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblCreditorAddress, gbc);
            tfCreditorAddress = new JTextField(15);
            tfCreditorAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfCreditorAddress.setText(creditData != null && creditData.getStrCreditorAddress() != null ? creditData.getStrCreditorAddress() : "");
            gbc.gridx = 3;
            this.add(tfCreditorAddress, gbc);

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


            // Credit Security
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblCreditSecurity = new JLabel("Credit Security:");
            lblCreditSecurity.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblCreditSecurity, gbc);
            String[] creditSecurityOptions = {
                "", "REAL_ESTATE_MORTGAGE", "CHATTEL_MORTGAGE", "POST_DATED_CHECKS", "CO_MAKER_GUARANTEE", "NONE"
            };
            cbCreditSecurity = new JComboBox<>(creditSecurityOptions);
            cbCreditSecurity.setFont(new Font("SansSerif", Font.PLAIN, 16));
            if (creditData != null && creditData.getEnumSecurity() != null) {
                cbCreditSecurity.setSelectedItem(creditData.getEnumSecurity().name());
            } else {
                cbCreditSecurity.setSelectedIndex(0);
            }
            gbc.gridx = 3;
            this.add(cbCreditSecurity, gbc);

            row++;
            
            // Credit Type
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblCreditType = new JLabel("Credit Type:");
            lblCreditType.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblCreditType, gbc);
            String[] creditTypeOptions = {
                "", "CREDIT_CARD", "PERSONAL_LOAN", "CAR_LOAN", "HOUSING_LOAN", "SALARY_LOAN", "BUSINESS_LOAN", "OTHERS"
            };
            cbCreditType = new JComboBox<>(creditTypeOptions);
            cbCreditType.setFont(new Font("SansSerif", Font.PLAIN, 16));
            if (creditData != null && creditData.getEnumType() != null) {
                cbCreditType.setSelectedItem(creditData.getEnumType().name());
            } else {
                cbCreditType.setSelectedIndex(0);
            }
            gbc.gridx = 1;
            this.add(cbCreditType, gbc);


            // Maturity Date
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblMaturityDate = new JLabel("Maturity Date (yyyy-MM-dd):");
            lblMaturityDate.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblMaturityDate, gbc);
            tfMaturityDate = new JTextField(15);
            tfMaturityDate.setFont(new Font("SansSerif", Font.PLAIN, 16));
            if (creditData != null && creditData.getDtMaturityDate() != null) {
                tfMaturityDate.setText(creditData.getDtMaturityDate().toString());
            } else {
                tfMaturityDate.setText("");
            }
            gbc.gridx = 3;
            this.add(tfMaturityDate, gbc);

            row++;
            
            // Outstanding Balance
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblOutstandingBalance = new JLabel("Outstanding Balance:");
            lblOutstandingBalance.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblOutstandingBalance, gbc);
            tfOutstandingBalance = new JTextField(15);
            tfOutstandingBalance.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfOutstandingBalance.setText(creditData != null && creditData.getBdOutstandingBalance() != null ? creditData.getBdOutstandingBalance().toString() : "");
            ((PlainDocument) tfOutstandingBalance.getDocument()).setDocumentFilter(new DocumentFilter() {
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
            this.add(tfOutstandingBalance, gbc);


            // Monthly Amortization
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblMonthlyAmortization = new JLabel("Monthly Amortization:");
            lblMonthlyAmortization.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblMonthlyAmortization, gbc);
            tfMonthlyAmortization = new JTextField(15);
            tfMonthlyAmortization.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfMonthlyAmortization.setText(creditData != null && creditData.getBdMonthlyAmortization() != null ? creditData.getBdMonthlyAmortization().toString() : "");
            ((PlainDocument) tfMonthlyAmortization.getDocument()).setDocumentFilter(new DocumentFilter() {
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
            this.add(tfMonthlyAmortization, gbc);


            // Add validation listeners to all fields to trigger form validation
            DocumentListener docListener = new DocumentListener() {
                public void insertUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
                public void removeUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
                public void changedUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            };
            tfCreditorName.getDocument().addDocumentListener(docListener);
            tfCreditorAddress.getDocument().addDocumentListener(docListener);
            tfMaturityDate.getDocument().addDocumentListener(docListener);
            tfOutstandingBalance.getDocument().addDocumentListener(docListener);
            tfMonthlyAmortization.getDocument().addDocumentListener(docListener);
            cbCreditSecurity.addActionListener(e -> validateForm());
            cbCreditType.addActionListener(e -> validateForm());
        }

        public OutstandingCredits getCreditData() {
            OutstandingCredits credit = new OutstandingCredits();
            credit.setStrCreditorName(tfCreditorName.getText());
            credit.setStrCreditorAddress(tfCreditorAddress.getText());
            credit.setStrHousingAccountNo(tfHousingAccountNo.getText());

            String creditSecurityStr = (String) cbCreditSecurity.getSelectedItem();
            if (creditSecurityStr != null && !creditSecurityStr.isEmpty()) {
                credit.setEnumSecurity(OutstandingCredits.CreditSecurity.fromString(creditSecurityStr));
            } else {
                credit.setEnumSecurity(null);
            }

            String creditTypeStr = (String) cbCreditType.getSelectedItem();
            if (creditTypeStr != null && !creditTypeStr.isEmpty()) {
                credit.setEnumType(OutstandingCredits.CreditType.fromString(creditTypeStr));
            } else {
                credit.setEnumType(null);
            }

            try {
                credit.setDtMaturityDate(LocalDate.parse(tfMaturityDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE));
            } catch (Exception e) {
                credit.setDtMaturityDate(null);
            }

            try {
                credit.setBdOutstandingBalance(new BigDecimal(tfOutstandingBalance.getText()));
            } catch (NumberFormatException e) {
                credit.setBdOutstandingBalance(null);
            }

            try {
                credit.setBdMonthlyAmortization(new BigDecimal(tfMonthlyAmortization.getText()));
            } catch (NumberFormatException e) {
                credit.setBdMonthlyAmortization(null);
            }

            return credit;
        }

        public boolean isValidData() {
            if (tfCreditorName.getText().trim().isEmpty()) return false;
            if (tfCreditorAddress.getText().trim().isEmpty()) return false;
            if (tfHousingAccountNo.getText().trim().isEmpty()) return false;
            if (cbCreditSecurity.getSelectedIndex() == 0) return false;
            if (cbCreditType.getSelectedIndex() == 0) return false;
            if (tfMaturityDate.getText().trim().isEmpty()) return false;
            try {
                LocalDate.parse(tfMaturityDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (Exception e) {
                return false;
            }
            if (tfOutstandingBalance.getText().trim().isEmpty()) return false;
            try {
                new BigDecimal(tfOutstandingBalance.getText());
            } catch (NumberFormatException e) {
                return false;
            }
            if (tfMonthlyAmortization.getText().trim().isEmpty()) return false;
            try {
                new BigDecimal(tfMonthlyAmortization.getText());
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            return tfCreditorName.getText().trim().isEmpty() &&
                    tfCreditorAddress.getText().trim().isEmpty() &&
                    tfHousingAccountNo.getText().trim().isEmpty() &&
                    cbCreditSecurity.getSelectedIndex() == 0 &&
                    cbCreditType.getSelectedIndex() == 0 &&
                    tfMaturityDate.getText().trim().isEmpty() &&
                    tfOutstandingBalance.getText().trim().isEmpty() &&
                    tfMonthlyAmortization.getText().trim().isEmpty();
        }
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
