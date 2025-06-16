package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.dao.*;
import com.mycompany.pagibigapplication.dao.impl.*;
import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.services.AuthService;

import javax.swing.*;
import java.awt.*;

public class Step9Panel extends javax.swing.JPanel {

    private final MultiStepForm parent;
    private final ApplicationData appData;
    private final AuthService authService = null;

    private JButton btnSubmit;
    private JButton btnBack;

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
        buttonPanel.setOpaque(false); 
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

        btnSubmit.addActionListener(event -> {
            try {
                if (appData.getMember() != null) {
                    try {
                        if (appData.getMember().getDateOfBirth() == null) {
                            
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Invalid date of birth. Please enter a valid date.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                memberDao.saveMember(appData.getMember());

                com.mycompany.pagibigapplication.dao.ApplicationDao applicationDao = new com.mycompany.pagibigapplication.dao.impl.ApplicationDaoImpl();
                com.mycompany.pagibigapplication.models.Application application = new com.mycompany.pagibigapplication.models.Application();
                application.setPagibigMid(appData.getMember().getPagibigMid());
                application.setDateSubmitted(java.time.LocalDate.now());
                application.setStatus(com.mycompany.pagibigapplication.models.Application.Status.Pending);

                try (java.sql.Connection conn = com.mycompany.pagibigapplication.db.DBConnection.getConnection()) {
                    conn.setAutoCommit(false);
                    try {
                        int applicationNo = ((com.mycompany.pagibigapplication.dao.impl.ApplicationDaoImpl) applicationDao).saveApplication(conn, application);

                        appData.getLoan().setIntApplicationNo(applicationNo);
                        appData.getCollateral().setIntApplicationNo(applicationNo);
                        appData.getSpouse().setIntApplicationNo(applicationNo);
                        for (var realEstate : appData.getRealEstateList()) {
                            realEstate.setIntApplicationNo(applicationNo);
                        }
                        for (var credit : appData.getCreditsList()) {
                            credit.setIntApplicationNo(applicationNo);
                        }
                        
                        for (var bank : appData.getBankList()) {
                            bank.setIntApplicationNo(applicationNo);
                        }

                        ((com.mycompany.pagibigapplication.dao.impl.LoanApplicationDaoImpl) loanApplicationDao).saveLoanApplication(conn, appData.getLoan());
                        ((com.mycompany.pagibigapplication.dao.impl.CollateralDaoImpl) collateralDao).saveCollateral(conn, appData.getCollateral());
                        ((com.mycompany.pagibigapplication.dao.impl.SpouseDaoImpl) spouseDao).saveSpouse(conn, appData.getSpouse(), appData.getMember().getPagibigMid());
                        ((com.mycompany.pagibigapplication.dao.impl.BankDaoImpl) bankDao).saveBanks(conn, appData.getBankList());
                        ((com.mycompany.pagibigapplication.dao.impl.RealEstateDaoImpl) realEstateDao).saveRealEstates(conn, appData.getRealEstateList());
                        ((com.mycompany.pagibigapplication.dao.impl.OutstandingCreditsDaoImpl) outstandingCreditsDao).saveOutstandingCredits(conn, appData.getCreditsList());
                        ((com.mycompany.pagibigapplication.dao.impl.EmployerDaoImpl) employerDao).saveEmployer(conn, appData.getEmployer());

                        conn.commit();
                    } catch (Exception e) {
                        conn.rollback();
                        throw e;
                    } finally {
                        conn.setAutoCommit(true);
                    }
                }

                JOptionPane.showMessageDialog(this, "Application submitted successfully!", "Submission", JOptionPane.INFORMATION_MESSAGE);
                java.awt.EventQueue.invokeLater(() -> {
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    topFrame.dispose();
                    try {
                        JFrame dashboard = new com.mycompany.pagibigapplication.gui.MemberDashboard(authService);
                        dashboard.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to open Member Dashboard: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
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
