
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.models.Bank;
import com.mycompany.pagibigapplication.models.Bank.AccountType;
import static com.mycompany.pagibigapplication.models.Bank.AccountType.CHECKING;
import static com.mycompany.pagibigapplication.models.Bank.AccountType.SAVINGS;

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

import com.mycompany.pagibigapplication.services.ApplicationData;

public class Step5Panel extends javax.swing.JPanel {
    
    private final ApplicationData appData;
    private final MultiStepForm parent;

    private JPanel panelContainer;
    private JButton btnAddBatch;
    private JButton btnRemoveBatch;
    private JButton btnNext;
    private JButton btnBack;

    private int batchCount = 0;
    private final int maxBatches = 3;

    private List<BankInfoPanel> bankInfoPanels = new ArrayList<>();

    public Step5Panel(MultiStepForm parent, ApplicationData appData) {
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
        btnAddBatch = new JButton("Add Bank Info");
        btnRemoveBatch = new JButton("Remove Bank Info");
        btnRemoveBatch.setEnabled(false);

        controlPanel.add(btnAddBatch);
        controlPanel.add(btnRemoveBatch);

        this.add(controlPanel, BorderLayout.SOUTH);

        List<Bank> savedBankInfos = appData.getBankList();
        if (savedBankInfos != null && !savedBankInfos.isEmpty()) {
            for (int i = 0; i < savedBankInfos.size(); i++) {
                addBankInfoPanel(savedBankInfos.get(i), i + 1);
            }
        } else {
            addBankInfoPanel(null, 1);
        }
        SwingUtilities.invokeLater(() -> {
            if (!bankInfoPanels.isEmpty() && bankInfoPanels.get(0).isValidData()) {
                btnNext.setEnabled(true);
            } else {
                btnNext.setEnabled(true);
            }
        });

        btnAddBatch.addActionListener(e -> {
            if (batchCount < maxBatches) {
                addBankInfoPanel(null, batchCount + 1);
                btnRemoveBatch.setEnabled(true);
                if (batchCount + 1 >= maxBatches) {
                    btnAddBatch.setEnabled(false);
                }
            }
        });

        btnRemoveBatch.addActionListener(e -> {
            if (batchCount > 1) {
                removeBankInfoPanel();
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
            if (saveAllBankInfo()) {
                parent.nextStep();
            }
        });

        btnBack.addActionListener(e -> parent.previousStep());

        validateForm();
        this.revalidate();
        this.repaint();
    }

    private void addBankInfoPanel(Bank bankData, int index) {
        BankInfoPanel bankInfoPanel = new BankInfoPanel(bankData, index);
        bankInfoPanels.add(bankInfoPanel);
        panelContainer.add(bankInfoPanel);
        batchCount++;
        this.revalidate();
        this.repaint();
        if (btnNext != null) {
            validateForm();
        }
    }

    private void removeBankInfoPanel() {
        if (batchCount > 0) {
            BankInfoPanel toRemove = bankInfoPanels.remove(bankInfoPanels.size() - 1);
            panelContainer.remove(toRemove);
            batchCount--;
            this.revalidate();
            this.repaint();
            validateForm();
        }
    }

    private boolean saveAllBankInfo() {
        List<Bank> banksToSave = new ArrayList<>();
        for (BankInfoPanel panel : bankInfoPanels) {
            if (!panel.isEmpty()) {
                if (!panel.isValidData()) {
                    JOptionPane.showMessageDialog(this, "Please fill all required fields correctly in all batches.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                banksToSave.add(panel.getBankData());
            }
        }
        appData.setBankList(banksToSave);
        if (!banksToSave.isEmpty()) {
            appData.setBank(banksToSave.get(0)); 

            System.out.println("Saved Bank Records:");
            for (int i = 0; i < banksToSave.size(); i++) {
                Bank b = banksToSave.get(i);
                System.out.println("Batch " + (i + 1) + ":");
                System.out.println("  Bank Name: " + b.getStrBankName());
                System.out.println("  Account Number: " + b.getIntAccountNumber());
                System.out.println("  Housing Account No: " + b.getIntHousingAccountNo());
                System.out.println("  Bank Branch: " + b.getStrBankBranch());
                System.out.println("  Account Type: " + b.getEnumAccountType());
                System.out.println("  Date Opened: " + b.getDtDateOpened());
                System.out.println("  Average Balance: " + b.getBdAverageBalance());
            }
        }
        return true;
    }

    void validateForm() {
        boolean anyValid = false;
        for (BankInfoPanel panel : bankInfoPanels) {
            if (panel.isValidData()) {
                anyValid = true;
                break;
            }
        }
        btnNext.setEnabled(anyValid);
    }

    private class BankInfoPanel extends JPanel {
        private JTextField tfBankName;
        private JTextField tfAccountNumber;
        private JTextField tfHousingAccountNo;
        private JTextField tfBankBranch;
        private JComboBox<String> cbAccountType;
        private JTextField tfDateOpened;
        private JTextField tfAverageBalance;

        private int batchIndex;

        public BankInfoPanel(Bank bankData, int index) {
            this.batchIndex = index;
            setupPanel(bankData);
        }

        private void setupPanel(Bank bankData) {
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Bank Info Batch " + batchIndex, TitledBorder.LEFT, TitledBorder.TOP));
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(5, 10, 5, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;

            int row = 0;

            // Bank Name
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblBankName = new JLabel("Bank Name:");
            lblBankName.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblBankName, gbc);
            tfBankName = new JTextField(15);
            tfBankName.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfBankName.setText(bankData != null && bankData.getStrBankName() != null ? bankData.getStrBankName() : "");
            gbc.gridx = 1;
            this.add(tfBankName, gbc);

            // Account Number
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblAccountNumber = new JLabel("Account Number:");
            lblAccountNumber.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblAccountNumber, gbc);
            tfAccountNumber = new JTextField(15);
            tfAccountNumber.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfAccountNumber.setText(bankData != null && bankData.getIntAccountNumber() != null ? bankData.getIntAccountNumber() : "");
            gbc.gridx = 3;
            this.add(tfAccountNumber, gbc);

            row++;

            // Housing Account No
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

            // Bank Branch
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblBankBranch = new JLabel("Bank Branch:");
            lblBankBranch.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblBankBranch, gbc);
            tfBankBranch = new JTextField(15);
            tfBankBranch.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfBankBranch.setText(bankData != null && bankData.getStrBankBranch() != null ? bankData.getStrBankBranch() : "");
            gbc.gridx = 3;
            this.add(tfBankBranch, gbc);

            row++;

            // Account Type
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblAccountType = new JLabel("Account Type:");
            lblAccountType.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblAccountType, gbc);
            String[] accountTypeOptions = {"", "SAVINGS", "CHECKING"};
            cbAccountType = new JComboBox<>(accountTypeOptions);
            cbAccountType.setFont(new Font("SansSerif", Font.PLAIN, 16));
            if (bankData != null && bankData.getEnumAccountType() != null) {
                switch (bankData.getEnumAccountType()) {
                    case SAVINGS -> cbAccountType.setSelectedItem("SAVINGS");
                    case CHECKING -> cbAccountType.setSelectedItem("CHECKING");
                    default -> cbAccountType.setSelectedIndex(0);
                }
            } else {
                cbAccountType.setSelectedIndex(0);
            }
            gbc.gridx = 1;
            this.add(cbAccountType, gbc);

            // Date Opened
            gbc.gridx = 2;
            gbc.gridy = row;
            JLabel lblDateOpened = new JLabel("Date Opened (yyyy-MM-dd):");
            lblDateOpened.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblDateOpened, gbc);
            tfDateOpened = new JTextField(15);
            tfDateOpened.setFont(new Font("SansSerif", Font.PLAIN, 16));
            if (bankData != null && bankData.getDtDateOpened() != null) {
                tfDateOpened.setText(bankData.getDtDateOpened().toString());
            } else {
                tfDateOpened.setText("");
            }
            gbc.gridx = 3;
            this.add(tfDateOpened, gbc);

            row++;

            // Average Balance
            gbc.gridx = 0;
            gbc.gridy = row;
            JLabel lblAverageBalance = new JLabel("Average Balance:");
            lblAverageBalance.setFont(new Font("SansSerif", Font.BOLD, 16));
            this.add(lblAverageBalance, gbc);
            tfAverageBalance = new JTextField(15);
            tfAverageBalance.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tfAverageBalance.setText(bankData != null && bankData.getBdAverageBalance() != null ? bankData.getBdAverageBalance().toString() : "");
            ((PlainDocument) tfAverageBalance.getDocument()).setDocumentFilter(new DocumentFilter() {
                @Override
                public void insertString(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                    if (string == null) return;
                    if (string.matches("[0-9.]*")) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
                @Override
                public void replace(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if (text == null) return;
                    if (text.matches("[0-9.]*")) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            });
            gbc.gridx = 1;
            this.add(tfAverageBalance, gbc);

            row++;
        }

        public Bank getBankData() {
            Bank bank = new Bank();
            bank.setStrBankName(tfBankName.getText());
            bank.setIntAccountNumber(tfAccountNumber.getText());
            bank.setIntHousingAccountNo(tfHousingAccountNo.getText());
            bank.setStrBankBranch(tfBankBranch.getText());

            String accountTypeStr = (String) cbAccountType.getSelectedItem();
            if ("SAVINGS".equals(accountTypeStr)) {
                bank.setEnumAccountType(AccountType.SAVINGS);
            } else if ("CHECKING".equals(accountTypeStr)) {
                bank.setEnumAccountType(AccountType.CHECKING);
            } else {
                bank.setEnumAccountType(null);
            }

            try {
                bank.setDtDateOpened(LocalDate.parse(tfDateOpened.getText(), DateTimeFormatter.ISO_LOCAL_DATE));
            } catch (Exception ex) {

            }

            try {
                bank.setBdAverageBalance(new BigDecimal(tfAverageBalance.getText()));
            } catch (NumberFormatException ex) {

            }
            return bank;
        }

        public boolean isValidData() {
            if (tfBankName.getText().trim().isEmpty()) return false;
            if (tfAccountNumber.getText().trim().isEmpty()) return false;
            if (tfHousingAccountNo.getText().trim().isEmpty()) return false;
            if (tfBankBranch.getText().trim().isEmpty()) return false;
            if (cbAccountType.getSelectedIndex() == 0) return false;
            if (tfDateOpened.getText().trim().isEmpty()) return false;
            try {
                LocalDate.parse(tfDateOpened.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (Exception e) {
                return false;
            }
            if (tfAverageBalance.getText().trim().isEmpty()) return false;
            try {
                new BigDecimal(tfAverageBalance.getText());
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            return tfBankName.getText().trim().isEmpty() &&
                    tfAccountNumber.getText().trim().isEmpty() &&
                    tfBankBranch.getText().trim().isEmpty() &&
                    tfDateOpened.getText().trim().isEmpty() &&
                    tfAverageBalance.getText().trim().isEmpty();
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
