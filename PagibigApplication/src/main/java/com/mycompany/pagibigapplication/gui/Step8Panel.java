
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.ApplicationData;
import com.mycompany.pagibigapplication.models.Employer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Step8Panel extends javax.swing.JPanel {

    private final ApplicationData appData;
    private final MultiStepForm parent;

    private JTextField tfEmployerPhoneDirect;
    private JTextField tfEmployerPhoneTrunk;
    private JTextField tfEmployerEmail;
    private JTextField tfEmployerName;
    private JTextField tfEmployerAddress;
    private JTextField tfIndustry;
    private JTextField tfPreferredContactTime;

    private JButton btnNext;
    private JButton btnBack;

    public Step8Panel(MultiStepForm parent, ApplicationData appData) {
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
                "Employer Information", TitledBorder.LEFT, TitledBorder.TOP));

        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        Employer employer = appData.getEmployer();

        int row = 0;

        // Employer Phone Direct
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lblEmployerPhoneDirect = new JLabel("Employer Phone Direct:");
        lblEmployerPhoneDirect.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmployerPhoneDirect, gbc);
        tfEmployerPhoneDirect = new JTextField(20);
        tfEmployerPhoneDirect.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfEmployerPhoneDirect.setText(employer != null && employer.getEmployerPhoneDirect() != null ? employer.getEmployerPhoneDirect() : "");
        gbc.gridx = 1;
        this.add(tfEmployerPhoneDirect, gbc);

        // Employer Phone Trunk
        gbc.gridx = 0;
        gbc.gridy = ++row;
        JLabel lblEmployerPhoneTrunk = new JLabel("Employer Phone Trunk:");
        lblEmployerPhoneTrunk.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmployerPhoneTrunk, gbc);
        tfEmployerPhoneTrunk = new JTextField(20);
        tfEmployerPhoneTrunk.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfEmployerPhoneTrunk.setText(employer != null && employer.getEmployerPhoneTrunk() != null ? employer.getEmployerPhoneTrunk() : "");
        gbc.gridx = 1;
        this.add(tfEmployerPhoneTrunk, gbc);

        // Employer Email
        gbc.gridx = 0;
        gbc.gridy = ++row;
        JLabel lblEmployerEmail = new JLabel("Employer Email:");
        lblEmployerEmail.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmployerEmail, gbc);
        tfEmployerEmail = new JTextField(20);
        tfEmployerEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfEmployerEmail.setText(employer != null && employer.getEmployerEmail() != null ? employer.getEmployerEmail() : "");
        gbc.gridx = 1;
        this.add(tfEmployerEmail, gbc);

        // Employer Name
        gbc.gridx = 0;
        gbc.gridy = ++row;
        JLabel lblEmployerName = new JLabel("Employer Name:");
        lblEmployerName.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmployerName, gbc);
        tfEmployerName = new JTextField(20);
        tfEmployerName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfEmployerName.setText(employer != null && employer.getEmployerName() != null ? employer.getEmployerName() : "");
        gbc.gridx = 1;
        this.add(tfEmployerName, gbc);

        // Employer Address
        gbc.gridx = 0;
        gbc.gridy = ++row;
        JLabel lblEmployerAddress = new JLabel("Employer Address:");
        lblEmployerAddress.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblEmployerAddress, gbc);
        tfEmployerAddress = new JTextField(20);
        tfEmployerAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfEmployerAddress.setText(employer != null && employer.getEmployerAddress() != null ? employer.getEmployerAddress() : "");
        gbc.gridx = 1;
        this.add(tfEmployerAddress, gbc);

        // Industry
        gbc.gridx = 0;
        gbc.gridy = ++row;
        JLabel lblIndustry = new JLabel("Industry:");
        lblIndustry.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblIndustry, gbc);
        tfIndustry = new JTextField(20);
        tfIndustry.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfIndustry.setText(employer != null && employer.getIndustry() != null ? employer.getIndustry() : "");
        gbc.gridx = 1;
        this.add(tfIndustry, gbc);

        // Preferred Contact Time
        gbc.gridx = 0;
        gbc.gridy = ++row;
        JLabel lblPreferredContactTime = new JLabel("Preferred Contact Time:");
        lblPreferredContactTime.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.add(lblPreferredContactTime, gbc);
        tfPreferredContactTime = new JTextField(20);
        tfPreferredContactTime.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfPreferredContactTime.setText(employer != null && employer.getPreferredContactTime() != null ? employer.getPreferredContactTime() : "");
        gbc.gridx = 1;
        this.add(tfPreferredContactTime, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnBack = new JButton("Back");
        btnNext = new JButton("Next");
        btnNext.setEnabled(false);
        buttonPanel.add(btnBack);
        buttonPanel.add(btnNext);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(buttonPanel, gbc);

        // Add listeners for validation
        DocumentListener docListener = new DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateForm(); }
        };

        tfEmployerPhoneDirect.getDocument().addDocumentListener(docListener);
        tfEmployerPhoneTrunk.getDocument().addDocumentListener(docListener);
        tfEmployerEmail.getDocument().addDocumentListener(docListener);
        tfEmployerName.getDocument().addDocumentListener(docListener);
        tfEmployerAddress.getDocument().addDocumentListener(docListener);
        tfIndustry.getDocument().addDocumentListener(docListener);
        tfPreferredContactTime.getDocument().addDocumentListener(docListener);

        btnNext.addActionListener(e -> {
            if (saveEmployerData()) {
                parent.nextStep();
            }
        });

        btnBack.addActionListener(e -> parent.previousStep());

        validateForm();

        this.revalidate();
        this.repaint();
    }

    void validateForm() {
        boolean valid = true;
        if (tfEmployerPhoneDirect.getText().trim().isEmpty()) valid = false;
        if (tfEmployerPhoneTrunk.getText().trim().isEmpty()) valid = false;
        if (tfEmployerEmail.getText().trim().isEmpty()) valid = false;
        if (tfEmployerName.getText().trim().isEmpty()) valid = false;
        if (tfEmployerAddress.getText().trim().isEmpty()) valid = false;
        if (tfIndustry.getText().trim().isEmpty()) valid = false;
        if (tfPreferredContactTime.getText().trim().isEmpty()) valid = false;
        btnNext.setEnabled(valid);
    }

    private boolean saveEmployerData() {
        Employer employer = appData.getEmployer();
        employer.setEmployerPhoneDirect(tfEmployerPhoneDirect.getText());
        employer.setEmployerPhoneTrunk(tfEmployerPhoneTrunk.getText());
        employer.setEmployerEmail(tfEmployerEmail.getText());
        employer.setEmployerName(tfEmployerName.getText());
        employer.setEmployerAddress(tfEmployerAddress.getText());
        employer.setIndustry(tfIndustry.getText());
        employer.setPreferredContactTime(tfPreferredContactTime.getText());

        System.out.println("Saved Employer Data:");
        System.out.println("Phone Direct: " + employer.getEmployerPhoneDirect());
        System.out.println("Phone Trunk: " + employer.getEmployerPhoneTrunk());
        System.out.println("Email: " + employer.getEmployerEmail());
        System.out.println("Name: " + employer.getEmployerName());
        System.out.println("Address: " + employer.getEmployerAddress());
        System.out.println("Industry: " + employer.getIndustry());
        System.out.println("Preferred Contact Time: " + employer.getPreferredContactTime());

        return true;
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
