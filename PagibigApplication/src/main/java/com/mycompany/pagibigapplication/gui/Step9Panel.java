package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.dao.*;
import com.mycompany.pagibigapplication.dao.impl.*;
import com.mycompany.pagibigapplication.models.*;
import com.mycompany.pagibigapplication.services.ApplicationData;

import javax.swing.*;
import java.awt.*;

public class Step9Panel extends javax.swing.JPanel {

    private final MultiStepForm parent;
    private final ApplicationData appData;

    private JButton btnSubmit;
    private JButton btnBack;

    // DAO instances
    private final LoanApplicationDao loanApplicationDao;
    private final MemberDao memberDao;
    private final CollateralDao collateralDao;
    private final SpouseDao spouseDao;
    private final BankDao bankDao;
    private final RealEstateDao realEstateDao;
    private final OutstandingCreditsDao outstandingCreditsDao;
    private final EmployerDao employerDao;

    public Step9Panel(MultiStepForm parent, ApplicationData appData) {
        this.parent = parent;
        this.appData = appData;

        // Initialize DAO implementations
        this.loanApplicationDao = new LoanApplicationDaoImpl();
        this.memberDao = new MemberDaoImpl();
        this.collateralDao = new CollateralDaoImpl();
        this.spouseDao = new SpouseDaoImpl();
        this.bankDao = new BankDaoImpl();
        this.realEstateDao = new RealEstateDaoImpl();
        this.outstandingCreditsDao = new OutstandingCreditsDaoImpl();
        this.employerDao = new EmployerDaoImpl();

        initComponents();
        setupForm();
    }

    void setupForm() {
        // Clear existing components
        this.removeAll();
        this.revalidate();
        this.repaint();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();

        JPanel rectanglePanel = new JPanel();
        rectanglePanel.setBackground(new Color(0xD9D9D9));
        rectanglePanel.setLayout(new GridBagLayout());
        rectanglePanel.setPreferredSize(new Dimension(500, 250));
        rectanglePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblTitle = new JLabel("Acknowledgement");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(new Color(0x1F41BB));
        rectanglePanel.add(lblTitle, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblInfo1 = new JLabel("<html>By clicking the button below, you confirm that all information you have provided is true and correct. You also agree to the terms and conditions for the Pag-IBIG Housing Loan.</html>");
        lblInfo1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        rectanglePanel.add(lblInfo1, gbc);

        gbc.gridy++;
        JLabel lblInfo2 = new JLabel("Please click the button below to submit your application.");
        lblInfo2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        rectanglePanel.add(lblInfo2, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false); // Make background transparent
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(new Color(0x1F41BB));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 14));

        buttonPanel.add(btnBack);
        buttonPanel.add(btnSubmit);

        rectanglePanel.add(buttonPanel, gbc);

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        this.add(rectanglePanel, gbcMain);

        btnSubmit.addActionListener(e -> {
            try {
                // Validate dateOfBirth before saving
                if (appData.getMember() != null) {
                    try {
                        if (appData.getMember().getDateOfBirth() == null) {
                            // Optionally, you can set a default date or show error
                            // For now, just allow null
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Invalid date of birth. Please enter a valid date.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Save data to respective DAOs
                loanApplicationDao.saveLoanApplication(java.util.Collections.singletonList(appData.getLoan()));
                memberDao.saveMember(appData.getMember());
                collateralDao.saveCollateral(appData.getCollateral());
                spouseDao.saveSpouse(appData.getSpouse(), appData.getMember().getPagibigMid());
                bankDao.saveBanks(appData.getBankList());
                realEstateDao.saveRealEstates(appData.getRealEstateList());
                outstandingCreditsDao.saveOutstandingCredits(appData.getCreditsList());
                employerDao.saveEmployer(appData.getEmployer());

                JOptionPane.showMessageDialog(this, "Application submitted successfully!", "Submission", JOptionPane.INFORMATION_MESSAGE);
                parent.nextStep();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error submitting application: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        btnBack.addActionListener(e -> parent.previousStep());
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
