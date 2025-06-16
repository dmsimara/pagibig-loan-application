package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.dao.impl.EmployerDaoImpl;
import javax.swing.*;
import java.awt.*;
import com.mycompany.pagibigapplication.models.Application;
import com.mycompany.pagibigapplication.models.Member;
import com.mycompany.pagibigapplication.models.Employer;
import com.mycompany.pagibigapplication.dao.impl.MemberDaoImpl;
import com.mycompany.pagibigapplication.dao.impl.LoanApplicationDaoImpl;
import com.mycompany.pagibigapplication.dao.impl.CollateralDaoImpl;
import com.mycompany.pagibigapplication.models.Collateral;
import com.mycompany.pagibigapplication.models.LoanApplication;
import java.util.List;

public class LoanRecordDialog extends JDialog {

    private Application application;
    private java.util.List<LoanApplication> loanApplications;
    private Collateral collateral;
    private com.mycompany.pagibigapplication.models.Spouse spouse;
    private java.util.List<com.mycompany.pagibigapplication.models.Bank> banks;
    private java.util.List<com.mycompany.pagibigapplication.models.RealEstate> realEstates;
    private java.util.List<com.mycompany.pagibigapplication.models.OutstandingCredits> credits;
    private com.mycompany.pagibigapplication.models.Employer employer;
    private String pagibigMid;

    public LoanRecordDialog(JFrame parent, Application application, java.util.List<LoanApplication> loanApplications, Collateral collateral, com.mycompany.pagibigapplication.models.Spouse spouse, java.util.List<com.mycompany.pagibigapplication.models.Bank> banks, java.util.List<com.mycompany.pagibigapplication.models.RealEstate> realEstates, java.util.List<com.mycompany.pagibigapplication.models.OutstandingCredits> credits, com.mycompany.pagibigapplication.models.Employer employer, String pagibigMid) {
        super(parent, "Loan Record Details", true);
        this.application = application;
        this.loanApplications = loanApplications;
        this.collateral = collateral;
        this.spouse = spouse;
        this.banks = banks;
        this.realEstates = realEstates;
        this.credits = credits;
        this.employer = employer;
        this.pagibigMid = pagibigMid;

        setSize(700, 600);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Member member = null;
        try {
            MemberDaoImpl memberDao = new MemberDaoImpl();
            member = memberDao.getMemberByPagibigMid(pagibigMid);
            System.out.println("Debug: Member fetched in LoanRecordDialog: " + (member != null ? member.getName() : "null"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        contentPanel.add(new JLabel("Application No.: " + application.getApplicationNo()));
        contentPanel.add(new JLabel("Date Submitted: " + application.getDateSubmitted()));
        contentPanel.add(new JLabel("Status: " + application.getStatus()));
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        contentPanel.add(new JLabel("Member Information:"));
        if (member != null) {
            contentPanel.add(new JLabel("Name: " + member.getName()));
            contentPanel.add(new JLabel("Citizenship: " + (member.getCitizenship() != null ? member.getCitizenship().name() : "")));
            contentPanel.add(new JLabel("Date of Birth: " + member.getDateOfBirth()));
            contentPanel.add(new JLabel("Sex: " + (member.getSex() != null ? member.getSex().name() : "")));
            contentPanel.add(new JLabel("Marital Status: " + (member.getMaritalStatus() != null ? member.getMaritalStatus().name() : "")));
            contentPanel.add(new JLabel("Number of Dependents: " + member.getNumberOfDependents()));
            contentPanel.add(new JLabel("Present Home Address: " + member.getPresentHomeAddress()));
            contentPanel.add(new JLabel("Permanent Home Address: " + member.getPermanentHomeAddress()));
            contentPanel.add(new JLabel("Home Phone: " + member.getHomePhone()));
            contentPanel.add(new JLabel("Email Address: " + member.getEmailAddress()));
            contentPanel.add(new JLabel("Alternate Mailing Address: " + member.getAlternateMailingAddress()));
            contentPanel.add(new JLabel("SSS/GSIS No: " + member.getSssGsisNo()));
            contentPanel.add(new JLabel("TIN: " + member.getTin()));
            contentPanel.add(new JLabel("Occupation: " + member.getOccupation()));
            contentPanel.add(new JLabel("Home Ownership: " + member.getHomeOwnership()));
            contentPanel.add(new JLabel("Monthly Rent: " + member.getMonthlyRent()));
            contentPanel.add(new JLabel("Years of Stay Address: " + member.getYearsOfStayAddress()));
            contentPanel.add(new JLabel("Years Employment: " + member.getYearsEmployment()));
            contentPanel.add(new JLabel("Position/Department: " + member.getPositionDepartment()));
            contentPanel.add(new JLabel("Cell Phone: " + member.getCellPhone()));
        } else {
            contentPanel.add(new JLabel("Member information not available."));
        }
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Employer info
        contentPanel.add(new JLabel("Employer Information:"));
        if (employer != null) {
            contentPanel.add(new JLabel("Employer Name: " + employer.getEmployerName()));
            contentPanel.add(new JLabel("Employer Address: " + employer.getEmployerAddress()));
            contentPanel.add(new JLabel("Industry: " + employer.getIndustry()));
            contentPanel.add(new JLabel("Preferred Contact Time: " + employer.getPreferredContactTime()));
            contentPanel.add(new JLabel("Employer Phone Direct: " + employer.getEmployerPhoneDirect()));
            contentPanel.add(new JLabel("Employer Phone Trunk: " + employer.getEmployerPhoneTrunk()));
            contentPanel.add(new JLabel("Employer Email: " + employer.getEmployerEmail()));
        } else {
            contentPanel.add(new JLabel("Employer information not available."));
        }
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Collateral info
        contentPanel.add(new JLabel("Collateral Information:"));
        if (collateral != null) {
            contentPanel.add(new JLabel("TCT/OCT/CCT No: " + collateral.getIntTctOctCctNo()));
            contentPanel.add(new JLabel("Primary Property Location: " + collateral.getStrPrimaryPropertyLocation()));
            contentPanel.add(new JLabel("Property Type: " + (collateral.getEnumPropertyType() != null ? collateral.getEnumPropertyType().name() : "")));
            contentPanel.add(new JLabel("Developer Title Holder: " + collateral.getStrDeveloperTitleHolder()));
            contentPanel.add(new JLabel("Description of Improvements: " + (collateral.getEnumDescriptionOfImprovements() != null ? collateral.getEnumDescriptionOfImprovements().name() : "")));
            contentPanel.add(new JLabel("Tax Declaration No: " + collateral.getStrTaxDeclarationNo()));
            contentPanel.add(new JLabel("Lot/Unit No: " + collateral.getStrLotUnitNo()));
            contentPanel.add(new JLabel("Block/Building No: " + collateral.getStrBlockBuildingNo()));
            contentPanel.add(new JLabel("Number of Storeys: " + collateral.getIntNumberOfStoreys()));
            contentPanel.add(new JLabel("Is Property Mortgaged: " + collateral.isBoolIsPropertyMortgaged()));
            contentPanel.add(new JLabel("Land Area (sqm): " + collateral.getBdLandAreaSqm()));
            contentPanel.add(new JLabel("Floor Area (sqm): " + collateral.getBdFloorAreaSqm()));
            contentPanel.add(new JLabel("Age of House: " + collateral.getIntAgeOfHouse()));
            contentPanel.add(new JLabel("Total Floor Area (sqm): " + collateral.getBdTotalFloorAreaSqm()));
            contentPanel.add(new JLabel("Is Offsite Collateral: " + collateral.isBoolIsOffsiteCollateral()));
            contentPanel.add(new JLabel("Offsite Collateral Reason: " + collateral.getStrOffsiteCollateralReason()));
            contentPanel.add(new JLabel("Housing Account No: " + collateral.getStrHousingAccountNo()));
        } else {
            contentPanel.add(new JLabel("Collateral information not available."));
        }
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Loan Application info
        contentPanel.add(new JLabel("Loan Application Information:"));
        if (loanApplications != null && !loanApplications.isEmpty()) {
            for (LoanApplication loanApp : loanApplications) {
                contentPanel.add(new JLabel("Housing Account No: " + loanApp.getHousingAccountNo()));
                contentPanel.add(new JLabel("Purpose of Loan: " + loanApp.getPurposeOfLoan()));
                contentPanel.add(new JLabel("Has Existing Application: " + loanApp.hasExistingApplication()));
                contentPanel.add(new JLabel("Housing Application No: " + loanApp.getHousingApplicationNo()));
                contentPanel.add(new JLabel("Loan Amount: " + loanApp.getLoanAmount()));
                contentPanel.add(new JLabel("Loan Term: " + loanApp.getLoanTerm()));
                contentPanel.add(new JLabel("Repricing Period: " + loanApp.getRepricingPeriod()));
                contentPanel.add(new JLabel("Mode of Payment: " + loanApp.getModeOfPayment()));
                contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        } else {
            contentPanel.add(new JLabel("Loan Application information not available."));
        }

        contentPanel.add(new JLabel("Spouse Information:"));
        if (spouse != null) {
            contentPanel.add(new JLabel("Name: " + spouse.getStrSpouseName()));
            contentPanel.add(new JLabel("Citizenship: " + (spouse.getEnumSpouseCitizenship() != null ? spouse.getEnumSpouseCitizenship().name() : "")));
            contentPanel.add(new JLabel("Date of Birth: " + spouse.getDtSpouseDOB()));
            contentPanel.add(new JLabel("TIN: " + spouse.getStrSpouseTin()));
            contentPanel.add(new JLabel("Occupation: " + spouse.getStrSpouseOccupation()));
            contentPanel.add(new JLabel("Business Phone: " + spouse.getStrSpouseBusinessPhone()));
            contentPanel.add(new JLabel("Position: " + spouse.getStrSpousePosition()));
            contentPanel.add(new JLabel("Years Employment: " + spouse.getIntSpouseYearsEmployment()));
        } else {
            contentPanel.add(new JLabel("Spouse information not available."));
        }
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        contentPanel.add(new JLabel("Bank Information:"));
        if (banks != null && !banks.isEmpty()) {
            for (com.mycompany.pagibigapplication.models.Bank bank : banks) {
                contentPanel.add(new JLabel("Bank Name: " + bank.getStrBankName()));
                contentPanel.add(new JLabel("Account Number: " + bank.getIntAccountNumber()));
                contentPanel.add(new JLabel("Bank Branch: " + bank.getStrBankBranch()));
                contentPanel.add(new JLabel("Account Type: " + (bank.getEnumAccountType() != null ? bank.getEnumAccountType().name() : "")));
                contentPanel.add(new JLabel("Date Opened: " + bank.getDtDateOpened()));
                contentPanel.add(new JLabel("Average Balance: " + bank.getBdAverageBalance()));
                contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        } else {
            contentPanel.add(new JLabel("Bank information not available."));
        }
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        contentPanel.add(new JLabel("Real Estate Information:"));
        if (realEstates != null && !realEstates.isEmpty()) {
            for (com.mycompany.pagibigapplication.models.RealEstate realEstate : realEstates) {
                contentPanel.add(new JLabel("Location: " + realEstate.getStrRealEstateLocation()));
                contentPanel.add(new JLabel("Type: " + (realEstate.getEnumRealEstateType() != null ? realEstate.getEnumRealEstateType().name() : "")));
                contentPanel.add(new JLabel("Acquisition Cost: " + realEstate.getBdAcquisitionCost()));
                contentPanel.add(new JLabel("Market Value: " + realEstate.getBdMarketValue()));
                contentPanel.add(new JLabel("Mortgage Balance: " + realEstate.getBdMortgageBalance()));
                contentPanel.add(new JLabel("Rental Income: " + realEstate.getBdRentalIncome()));
                contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        } else {
            contentPanel.add(new JLabel("Real Estate information not available."));
        }
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        contentPanel.add(new JLabel("Outstanding Balance:"));
        if (credits != null && !credits.isEmpty()) {
            for (com.mycompany.pagibigapplication.models.OutstandingCredits credit : credits) {
                contentPanel.add(new JLabel("Creditor Name: " + credit.getStrCreditorName()));
                contentPanel.add(new JLabel("Creditor Address: " + credit.getStrCreditorAddress()));
                contentPanel.add(new JLabel("Credit Security: " + (credit.getEnumSecurity() != null ? credit.getEnumSecurity().name() : "")));
                contentPanel.add(new JLabel("Credit Type: " + (credit.getEnumType() != null ? credit.getEnumType().name() : "")));
                contentPanel.add(new JLabel("Maturity Date: " + credit.getDtMaturityDate()));
                contentPanel.add(new JLabel("Outstanding Balance: " + credit.getBdOutstandingBalance()));
                contentPanel.add(new JLabel("Monthly Amortization: " + credit.getBdMonthlyAmortization()));
                contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        } else {
            contentPanel.add(new JLabel("Outstanding balance information not available."));
        }
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(new JLabel("Update Application Status:"));
        String[] statuses = {"Pending", "Approved", "Rejected", "Closed"};
        JComboBox<String> statusComboBox = new JComboBox<>(statuses);
        statusComboBox.setSelectedItem(application.getStatus().name());
        leftPanel.add(statusComboBox);

        JButton updateStatusButton = new JButton("Update Status");
        leftPanel.add(updateStatusButton);

        statusPanel.add(leftPanel, BorderLayout.WEST);

        JButton deleteButton = new JButton("Delete");
        leftPanel.add(deleteButton);

        updateStatusButton.addActionListener(e -> {
            String selectedStatusStr = (String) statusComboBox.getSelectedItem();
            if (selectedStatusStr != null && !selectedStatusStr.equals(application.getStatus().name())) {
                try {
                    com.mycompany.pagibigapplication.dao.ApplicationDao applicationDao = new com.mycompany.pagibigapplication.dao.impl.ApplicationDaoImpl();
                    com.mycompany.pagibigapplication.models.Application.Status selectedStatus = com.mycompany.pagibigapplication.models.Application.Status.valueOf(selectedStatusStr);
                    application.setStatus(selectedStatus);
                    applicationDao.updateApplicationStatus(application.getApplicationNo(), selectedStatus);
                    JOptionPane.showMessageDialog(this, "Application status updated to: " + selectedStatusStr);
                    statusComboBox.setSelectedItem(selectedStatusStr);
                    for (Component comp : contentPanel.getComponents()) {
                        if (comp instanceof JLabel) {
                            JLabel label = (JLabel) comp;
                            if (label.getText().startsWith("Status:")) {
                                label.setText("Status: " + selectedStatusStr);
                                break;
                            }
                        }
                    }
                    this.dispose();
                    if (getParent() instanceof JFrame) {
                        ((JFrame) getParent()).dispose();
                    }
                    java.awt.EventQueue.invokeLater(() -> {
                        try {
                            com.mycompany.pagibigapplication.gui.LoanQueue loanQueue = new com.mycompany.pagibigapplication.gui.LoanQueue(new com.mycompany.pagibigapplication.services.AuthService());
                            loanQueue.setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to update application status.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this application and all related records?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    com.mycompany.pagibigapplication.dao.ApplicationDao applicationDao = new com.mycompany.pagibigapplication.dao.impl.ApplicationDaoImpl();
                    applicationDao.deleteApplicationAndRelatedRecords(application.getApplicationNo());
                    JOptionPane.showMessageDialog(this, "Application and related records deleted successfully.");
                    this.dispose();
                    if (getParent() instanceof JFrame) {
                        ((JFrame) getParent()).dispose();
                    }
                    java.awt.EventQueue.invokeLater(() -> {
                        try {
                            com.mycompany.pagibigapplication.gui.LoanQueue loanQueue = new com.mycompany.pagibigapplication.gui.LoanQueue(new com.mycompany.pagibigapplication.services.AuthService());
                            loanQueue.setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to delete application.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        buttonPanel.add(deleteButton);
        buttonPanel.add(closeButton);
        add(statusPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }
 }
