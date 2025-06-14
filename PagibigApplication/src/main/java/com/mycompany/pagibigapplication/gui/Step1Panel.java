
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.models.LoanApplication;
import com.mycompany.pagibigapplication.services.ApplicationData;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentListener;
import org.w3c.dom.events.DocumentEvent;

public class Step1Panel extends javax.swing.JPanel {
    
    private JTextField tfHousingAccountNo;
    private JComboBox<String> cbPurposeOfLoan;
    private JCheckBox cbExistingApplication;
    private JTextField tfHousingApplicationNo;
    private JTextField tfLoanAmount;
    private JComboBox<String> cbLoanTerm;
    private JComboBox<String> cbRepricingPeriod;
    private JComboBox<String> cbModeOfPayment;
    private JTextField tfPagibigMid;
    private JButton btnNext;

    private final ApplicationData appData;
    private final MultiStepForm parent;

    public Step1Panel(MultiStepForm parent, ApplicationData appData) {
        this.parent = parent;
        this.appData = appData;
        initComponents();
        setupForm(); 
    }
    
    void setupForm() {
        this.removeAll();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.setBorder(null);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        this.add(Box.createVerticalStrut(20), gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 10, 8, 10);

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
            "Loan Application Details", TitledBorder.LEFT, TitledBorder.TOP));

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblHousingAccountNo = new JLabel("Housing Account No:");
        lblHousingAccountNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblHousingAccountNo, gbc);
        tfHousingAccountNo = new JTextField(15);
        tfHousingAccountNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfHousingAccountNo, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        JLabel lblPurposeOfLoan = new JLabel("Purpose of Loan:");
        lblPurposeOfLoan.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPurposeOfLoan, gbc);
        String[] purposeOptions = {
            "",
            "Purchase of residential lot",
            "Purchase of house and lot",
            "Purchase of townhouse",
            "Purchase of condominium unit",
            "House construction",
            "Home improvement",
            "Refinancing of existing loan",
            "Purchase of foreclosed property",
            "Combination of purposes"
        };
        cbPurposeOfLoan = new JComboBox<>(purposeOptions);
        cbPurposeOfLoan.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(cbPurposeOfLoan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblExistingApplication = new JLabel("Has Existing Application?");
        lblExistingApplication.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblExistingApplication, gbc);
        cbExistingApplication = new JCheckBox();
        cbExistingApplication.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(cbExistingApplication, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        JLabel lblHousingApplicationNo = new JLabel("Housing Application No:");
        lblHousingApplicationNo.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblHousingApplicationNo, gbc);
        tfHousingApplicationNo = new JTextField(15);
        tfHousingApplicationNo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfHousingApplicationNo.setEnabled(false);
        gbc.gridx = 3;
        this.add(tfHousingApplicationNo, gbc);

        cbExistingApplication.addActionListener(e -> {
            tfHousingApplicationNo.setEnabled(cbExistingApplication.isSelected());
            validateForm();
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblLoanAmount = new JLabel("Loan Amount:");
        lblLoanAmount.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblLoanAmount, gbc);
        tfLoanAmount = new JTextField(15);
        tfLoanAmount.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfLoanAmount.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a) 
                throws javax.swing.text.BadLocationException {
                if (str == null) return;
                if (str.chars().allMatch(Character::isDigit)) {
                    super.insertString(offs, str, a);
                }
            }
        });
        gbc.gridx = 1;
        this.add(tfLoanAmount, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        JLabel lblLoanTerm = new JLabel("Loan Term:");
        lblLoanTerm.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblLoanTerm, gbc);
        String[] loanTermOptions = {"", "5", "10", "15", "20", "25", "30"};
        cbLoanTerm = new JComboBox<>(loanTermOptions);
        cbLoanTerm.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(cbLoanTerm, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lblRepricingPeriod = new JLabel("Repricing Period:");
        lblRepricingPeriod.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblRepricingPeriod, gbc);
        String[] repricingOptions = {"", "1 year", "3 years", "5 years", "10 years"};
        cbRepricingPeriod = new JComboBox<>(repricingOptions);
        cbRepricingPeriod.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(cbRepricingPeriod, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        JLabel lblModeOfPayment = new JLabel("Mode of Payment:");
        lblModeOfPayment.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblModeOfPayment, gbc);
        String[] modeOfPaymentOptions = {
            "",
            "Pag-IBIG Branch",
            "Virtual Payment Channels",
            "Bayad Center",
            "SM Business Centers",
            "Robinsons Business Centers",
            "7-Eleven (CliQQ)",
            "Post-Dated Checks",
            "Salary Deduction",
            "Auto Debit Arrangement",
            "Online Banking / Bills Payment"
        };
        cbModeOfPayment = new JComboBox<>(modeOfPaymentOptions);
        cbModeOfPayment.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 3;
        this.add(cbModeOfPayment, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel lblPagibigMid = new JLabel("Pag-IBIG MID No:");
        lblPagibigMid.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPagibigMid, gbc);
        tfPagibigMid = new JTextField(15);
        tfPagibigMid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        this.add(tfPagibigMid, gbc);

        btnNext = new JButton("Next");
        btnNext.setEnabled(false); 
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(btnNext, gbc);

        DocumentListener documentListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
        };

        ActionListener actionListener = e -> validateForm();

        tfHousingAccountNo.getDocument().addDocumentListener(documentListener);
        cbPurposeOfLoan.addActionListener(actionListener);
        tfHousingApplicationNo.getDocument().addDocumentListener(documentListener);
        tfLoanAmount.getDocument().addDocumentListener(documentListener);
        cbLoanTerm.addActionListener(actionListener);
        cbRepricingPeriod.addActionListener(actionListener);
        cbModeOfPayment.addActionListener(actionListener);
        tfPagibigMid.getDocument().addDocumentListener(documentListener);

        // Remove existing action listeners to prevent duplicates
        for (ActionListener al : btnNext.getActionListeners()) {
            btnNext.removeActionListener(al);
        }

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNext.setEnabled(false); // disable to prevent double submission
                LoanApplication loan = appData.getLoan();

                loan.setHousingAccountNo(tfHousingAccountNo.getText());
                loan.setPurposeOfLoan((String) cbPurposeOfLoan.getSelectedItem());
                loan.setHasExistingApplication(cbExistingApplication.isSelected());
                loan.setHousingApplicationNo(tfHousingApplicationNo.getText());

                try {
                    loan.setLoanAmount(Integer.parseInt(tfLoanAmount.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Step1Panel.this, 
                        "Invalid loan amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    btnNext.setEnabled(true);
                    validateForm();
                    return;
                }

                loan.setLoanTerm((String) cbLoanTerm.getSelectedItem());
                loan.setRepricingPeriod((String) cbRepricingPeriod.getSelectedItem());
                loan.setModeOfPayment((String) cbModeOfPayment.getSelectedItem());
                loan.setPagibigMid(tfPagibigMid.getText());

                // Sync Pagibig MID to member object
                appData.getMember().setPagibigMid(tfPagibigMid.getText());

                System.out.println("\n=== Saved Loan Application Data ===");
                System.out.println("Housing Account No: " + loan.getHousingAccountNo());
                System.out.println("Purpose of Loan: " + loan.getPurposeOfLoan());
                System.out.println("Has Existing Application: " + loan.hasExistingApplication());
                System.out.println("Housing Application No: " + loan.getHousingApplicationNo());
                System.out.println("Loan Amount: " + loan.getLoanAmount());
                System.out.println("Loan Term: " + loan.getLoanTerm());
                System.out.println("Repricing Period: " + loan.getRepricingPeriod());
                System.out.println("Mode of Payment: " + loan.getModeOfPayment());
                System.out.println("Pagibig MID: " + loan.getPagibigMid());
                System.out.println("================================\n");

                parent.nextStep();
            }
        });

        // Repopulate fields with existing data from appData.getLoan()
        LoanApplication loan = appData.getLoan();
        tfHousingAccountNo.setText(loan.getHousingAccountNo() != null ? loan.getHousingAccountNo() : "");
        cbPurposeOfLoan.setSelectedItem(loan.getPurposeOfLoan() != null ? loan.getPurposeOfLoan() : "");
        cbExistingApplication.setSelected(loan.hasExistingApplication());
        tfHousingApplicationNo.setText(loan.getHousingApplicationNo() != null ? loan.getHousingApplicationNo() : "");
        tfHousingApplicationNo.setEnabled(cbExistingApplication.isSelected());
        tfLoanAmount.setText(loan.getLoanAmount() > 0 ? String.valueOf(loan.getLoanAmount()) : "");
        cbLoanTerm.setSelectedItem(loan.getLoanTerm() != null ? loan.getLoanTerm() : "");
        cbRepricingPeriod.setSelectedItem(loan.getRepricingPeriod() != null ? loan.getRepricingPeriod() : "");
        cbModeOfPayment.setSelectedItem(loan.getModeOfPayment() != null ? loan.getModeOfPayment() : "");
        tfPagibigMid.setText(loan.getPagibigMid() != null ? loan.getPagibigMid() : "");

        // Validate form after repopulating to enable or disable Next button
        validateForm();

        this.revalidate();
        this.repaint();
    }

    void validateForm() {
        boolean isValid = true;

        if (tfHousingAccountNo.getText().trim().isEmpty()) isValid = false;
        if (cbPurposeOfLoan.getSelectedIndex() == 0) isValid = false;
        if (cbExistingApplication.isSelected() && tfHousingApplicationNo.getText().trim().isEmpty()) isValid = false;
        if (tfLoanAmount.getText().trim().isEmpty()) isValid = false;
        if (cbLoanTerm.getSelectedIndex() == 0) isValid = false;
        if (cbRepricingPeriod.getSelectedIndex() == 0) isValid = false;
        if (cbModeOfPayment.getSelectedIndex() == 0) isValid = false;
        if (tfPagibigMid.getText().trim().isEmpty()) isValid = false;

        btnNext.setEnabled(isValid);
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
