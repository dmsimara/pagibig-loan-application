
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.BorderFactory;


public class MemberApply extends javax.swing.JFrame {

    private JPanel topBar;
    private JPanel sideBar;
    private JSeparator applicantSeparator;
    private JLabel helpLabel;
    
    private List<JButton> sidebarButtons = new ArrayList<>();
    private JButton activeButton = null;
    
    private final AuthService authService;
   
    public MemberApply(AuthService authService) {
        this.authService = authService;
        
        setTitle("PagIBIG Housing Loan Application");
        ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/logoIcon.png");
        setIconImage(icon.getImage());
        
        initComponents();
        setSize(1280, 720);            
        setLocationRelativeTo(null);
        setLayout(null);    
        addCustomComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCustomComponents() {
        
        // for top bar
        topBar = new JPanel();
        topBar.setBackground(Color.WHITE);
        topBar.setBounds(0, 0, getWidth(), 45);  
        topBar.setLayout(null);  
        this.getContentPane().add(topBar);
        
        // icon header
        ImageIcon header = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/header.png");
        int intWidth = header.getIconWidth();
        int intHeight = header.getIconHeight();
        int intTargetH = 40;
        int intTargetW = (intWidth * intTargetH) / intHeight;
        Image scaledImage = header.getImage().getScaledInstance(intTargetW, intTargetH, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        int intYOffset = (45 - intTargetH) / 2;
        imageLabel.setBounds(10, intYOffset, intTargetW, intTargetH);
        topBar.add(imageLabel);
        
        // profile
        ImageIcon profileIcon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/profile.png");
        int intProfileH = 30;
        int intProfileW = (profileIcon.getIconWidth() * intProfileH) / profileIcon.getIconHeight();
        Image profileImage = profileIcon.getImage().getScaledInstance(intProfileW, intProfileH, Image.SCALE_SMOOTH);
        ImageIcon scaledProfileIcon = new ImageIcon(profileImage);
        JLabel profileLabel = new JLabel(scaledProfileIcon);
        
        int intProfileO = (45 - intProfileH) / 2;
        int intProfileX = topBar.getWidth() - 170;
        profileLabel.setBounds(intProfileX, intProfileO, intProfileW, intProfileH);
        topBar.add(profileLabel);
        
        // "Hello, User"
        JLabel greetingLabel = new JLabel("<html><b>Hello,</b> John!</html>");
        greetingLabel.setForeground(Color.BLACK);
        greetingLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        int intGreeting = intProfileX + intProfileW + 10;
        greetingLabel.setBounds(intGreeting, intProfileO, 100, intProfileH);
        topBar.add(greetingLabel);
        
        // for sidebar
        sideBar = new JPanel();
        sideBar.setBackground(Color.decode("#1F41BB"));   
        sideBar.setBounds(0, 45, 220, getHeight() - 45);   
        sideBar.setLayout(null);  
        this.getContentPane().add(sideBar);
        
        JLabel mainMenuLabel = new JLabel("Main Menu");
        mainMenuLabel.setForeground(Color.WHITE);
        mainMenuLabel.setFont(new Font("Poppins", Font.BOLD, 12));   
        mainMenuLabel.setBounds(20, 15, 160, 30);  
        sideBar.add(mainMenuLabel);
        
        JButton dashboardButton = createSidebarButton("Home", "src/main/java/com/mycompany/pagibigapplication/resources/dashboardIcon.png", 50);
        JButton loanQueueButton = createSidebarButton("Apply for Loan", "src/main/java/com/mycompany/pagibigapplication/resources/loanQueueIcon.png", 100);
        JButton applicantButton = createSidebarButton("Application Status", "src/main/java/com/mycompany/pagibigapplication/resources/applicantIcon.png", 150);
        
        sideBar.add(dashboardButton);
        sideBar.add(loanQueueButton);
        sideBar.add(applicantButton);
        

        // separator
        applicantSeparator = new JSeparator();
        applicantSeparator.setForeground(Color.WHITE);
        applicantSeparator.setBounds(15, 195, 180, 1);
        sideBar.add(applicantSeparator);
        
        // settings
        JLabel helpLabel = new JLabel("Help and Support");
        helpLabel.setForeground(Color.WHITE);
        helpLabel.setFont(new Font("Poppins", Font.BOLD, 12));
        helpLabel.setBounds(20, applicantSeparator.getY() + 10, 160, 30);
        sideBar.add(helpLabel);
        
        JButton settingsButton = createSidebarButton("Settings", "src/main/java/com/mycompany/pagibigapplication/resources/settingsIcon.png", 240);
        sideBar.add(settingsButton);
        addHoverEffect(settingsButton);
        sidebarButtons.add(settingsButton);
        
        // logout
        JSeparator bottomSeparator = new JSeparator();
        bottomSeparator.setForeground(Color.WHITE);
        bottomSeparator.setBounds(10, sideBar.getHeight() - 100, 180, 1);
        sideBar.add(bottomSeparator);
        
        int logoutY = sideBar.getHeight() - 90; 
        JButton logoutButton = createSidebarButton("Log out", "src/main/java/com/mycompany/pagibigapplication/resources/logoutIcon.png", logoutY);
        sideBar.add(logoutButton);
        addHoverEffect(logoutButton);
        sidebarButtons.add(logoutButton);
        
        logoutButton.addActionListener(e -> {
            int intChoice = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
            
            if (intChoice == JOptionPane.YES_OPTION) {
                String strRole = authService.getCurrentUserRole();
                authService.logout();
                
                JOptionPane.showMessageDialog(this, "You have been logged out.");
                this.dispose();
                
                if ("admin".equals(strRole)) {
                    new AdminLogin(authService).setVisible(true);
                } else if ("member".equals(strRole)) {
                    new MemberLogin(authService).setVisible(true);
                } else {
                    new AdminLogin(authService).setVisible(true);
                }
            }
        });
     
        dashboardButton.addActionListener(e -> {
            setActiveButton(dashboardButton);
            new MemberDashboard(authService).setVisible(true);
            this.dispose();
        });

        loanQueueButton.addActionListener(e -> {
            setActiveButton(loanQueueButton);
            new MemberApply(authService).setVisible(true);
            this.dispose();
        });
        
        applicantButton.addActionListener(e -> {
            setActiveButton(applicantButton);
            new MemberStatus().setVisible(true);
            this.dispose();
        });

        addHoverEffect(dashboardButton);
        addHoverEffect(loanQueueButton);
        addHoverEffect(applicantButton);

        sidebarButtons.add(dashboardButton);
        sidebarButtons.add(loanQueueButton);
        sidebarButtons.add(applicantButton);
        

        setActiveButton(loanQueueButton);
        
        // main content
        RoundedPanel contentPanel = new RoundedPanel(40);
        contentPanel.setBounds(240, 70, 1000, 580);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);
        this.getContentPane().add(contentPanel);
        
        // headlines
        JLabel applicationLabel = new JLabel("Application Form");
        applicationLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        applicationLabel.setForeground(Color.BLACK);
        applicationLabel.setBounds(20, 20, 300, 30);
        contentPanel.add(applicationLabel);
        
        int intStepX = contentPanel.getWidth() - 90;
        JLabel stepLabel = new JLabel("Step 1");
        stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        stepLabel.setForeground(Color.decode("#1F41BB"));
        stepLabel.setBounds(intStepX, 20, 100, 30);
        contentPanel.add(stepLabel);
        
        int intLoanX = stepLabel.getX() - 130;
        JLabel loanLabel = new JLabel("Loan Particular");
        loanLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        loanLabel.setForeground(Color.BLACK);
        loanLabel.setBounds(intLoanX, 22, 150, 30);
        contentPanel.add(loanLabel);
        
        // progress bar
        CircularStepProgressBar progressBar = new CircularStepProgressBar();
        progressBar.setBounds(0, 50, 1000, 100); 
        progressBar.setCurrentStep(1); 
        contentPanel.add(progressBar);
        
        // purpose of loan
        JLabel purposeLabel = new JLabel("Purpose of Loan");
        purposeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        purposeLabel.setForeground(Color.BLACK);
        purposeLabel.setBounds(20, 155, 300, 20);  
        contentPanel.add(purposeLabel);
        
        // desired loan amount
        JLabel desiredLoanAmountLabel = new JLabel("Desired Loan Amount");
        desiredLoanAmountLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        desiredLoanAmountLabel.setForeground(Color.BLACK);
        desiredLoanAmountLabel.setBounds(530, 155, 200, 20);  
        contentPanel.add(desiredLoanAmountLabel);
        
        JLabel exclusiveNoteLabel = new JLabel("(Exclusive of the co-borrower’s desired loan amount, if any)");
        exclusiveNoteLabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        exclusiveNoteLabel.setForeground(Color.BLACK);
        exclusiveNoteLabel.setBounds(530, 175, 300, 15);   
        contentPanel.add(exclusiveNoteLabel);
        
        JTextField desiredLoanAmountField = new JTextField();
        desiredLoanAmountField.setBounds(530, 195, 200, 25);   
        desiredLoanAmountField.setFont(new Font("SansSerif", Font.PLAIN, 12));
        contentPanel.add(desiredLoanAmountField);
        
        // desired loan term
        JLabel desiredLoanTermLabel = new JLabel("Desired Loan Term");
        desiredLoanTermLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        desiredLoanTermLabel.setForeground(Color.BLACK);
        desiredLoanTermLabel.setBounds(770, 155, 200, 20);
        contentPanel.add(desiredLoanTermLabel);
        
        JLabel yearsLabel = new JLabel("(Years)");
        yearsLabel.setFont(new Font("SansSerif", Font.PLAIN, 8));
        yearsLabel.setForeground(Color.BLACK);
        yearsLabel.setBounds(770, 175, 100, 15);
        contentPanel.add(yearsLabel);
        
        JTextField desiredLoanTermField = new JTextField();
        desiredLoanTermField.setBounds(770, 195, 200, 25);
        desiredLoanTermField.setFont(new Font("SansSerif", Font.PLAIN, 12));
        contentPanel.add(desiredLoanTermField);
        
        // repricing period
        JLabel repricingPeriodLabel = new JLabel("Desired Re-Pricing Period");
        repricingPeriodLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        repricingPeriodLabel.setForeground(Color.BLACK);
        repricingPeriodLabel.setBounds(530, 230, 200, 20);
        contentPanel.add(repricingPeriodLabel);
        
        JLabel repricingNote = new JLabel("(Years)");
        repricingNote.setFont(new Font("SansSerif", Font.PLAIN, 8));
        repricingNote.setForeground(Color.BLACK);
        repricingNote.setBounds(530, 250, 300, 15);   
        contentPanel.add(repricingNote);
        
        JPanel radioPanel = new JPanel();
        radioPanel.setBounds(530, 270, 450, 30); 
        radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        radioPanel.setBackground(Color.WHITE); 

        JRadioButton option1 = new JRadioButton("1");
        JRadioButton option3 = new JRadioButton("3");
        JRadioButton option5 = new JRadioButton("5");
        JRadioButton option10 = new JRadioButton("10");
        JRadioButton option15 = new JRadioButton("15");
        JRadioButton option20 = new JRadioButton("20");
        JRadioButton option25 = new JRadioButton("25");
        JRadioButton option30 = new JRadioButton("30");
        
        JRadioButton[] radioOptions = {option1, option3, option5, option10, option15, option20, option25, option30};
        for (JRadioButton rb : radioOptions) {
            rb.setBackground(Color.WHITE);
            rb.setOpaque(true);
        }

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(option1);
        radioGroup.add(option3);
        radioGroup.add(option5);
        radioGroup.add(option10);
        radioGroup.add(option15);
        radioGroup.add(option20);
        radioGroup.add(option25);
        radioGroup.add(option30);
        radioPanel.add(option1);
        radioPanel.add(option3);
        radioPanel.add(option5);
        radioPanel.add(option10);
        radioPanel.add(option15);
        radioPanel.add(option20);
        radioPanel.add(option25);
        radioPanel.add(option30);
        contentPanel.add(radioPanel);
        
        // mode of payment
        JLabel paymentLabel = new JLabel("Mode of Payment");
        paymentLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        paymentLabel.setForeground(Color.BLACK);
        paymentLabel.setBounds(530, 320, 200, 20);
        contentPanel.add(paymentLabel);
        
        JPanel paymentPanel = new JPanel();
        paymentPanel.setBounds(530, 350, 450, 150);
        paymentPanel.setLayout(new GridLayout(1, 2));
        paymentPanel.setBackground(Color.WHITE);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.WHITE);
        
        JRadioButton salaryDeduction = new JRadioButton("Salary Deduction");
        salaryDeduction.setBackground(Color.WHITE);
        salaryDeduction.setOpaque(true);
        leftPanel.add(salaryDeduction);
        leftPanel.add(Box.createVerticalStrut(5));
        
        JPanel otcPanel = new JPanel();
        otcPanel.setLayout(new BoxLayout(otcPanel, BoxLayout.Y_AXIS));
        otcPanel.setBackground(Color.WHITE);
        
        JRadioButton overTheCounter = new JRadioButton("Over-the-Counter");
        overTheCounter.setBackground(Color.WHITE);
        overTheCounter.setOpaque(true);
        otcPanel.add(overTheCounter);
        otcPanel.add(Box.createVerticalStrut(3));
        
        JRadioButton postDatedChecks = new JRadioButton("Post-Dated Checks");
        postDatedChecks.setBackground(Color.WHITE);
        postDatedChecks.setOpaque(true);
        postDatedChecks.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        JRadioButton cashCheck = new JRadioButton("Cash/Check");
        cashCheck.setBackground(Color.WHITE);
        cashCheck.setOpaque(true);
        cashCheck.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        otcPanel.add(postDatedChecks);
        otcPanel.add(cashCheck);
        leftPanel.add(otcPanel);
        
        JPanel rightPanel= new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(Color.WHITE);
        
        JRadioButton collectingAgent = new JRadioButton("Collecting Agent");
        collectingAgent.setBackground(Color.WHITE);
        collectingAgent.setOpaque(true);
        rightPanel.add(collectingAgent);
        rightPanel.add(Box.createVerticalStrut(3));
        
        JRadioButton bank = new JRadioButton("Bank");
        bank.setBackground(Color.WHITE);
        bank.setOpaque(true);
        bank.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        JRadioButton developer = new JRadioButton("Developer");
        developer.setBackground(Color.WHITE);
        developer.setOpaque(true);
        developer.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        JRadioButton remittanceCenter = new JRadioButton("Remittance Center");
        remittanceCenter.setBackground(Color.WHITE);
        remittanceCenter.setOpaque(true);
        remittanceCenter.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        rightPanel.add(bank);
        rightPanel.add(developer);
        rightPanel.add(remittanceCenter);
        
        paymentPanel.add(leftPanel);
        paymentPanel.add(rightPanel);
        
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(salaryDeduction);
        paymentGroup.add(overTheCounter);
        paymentGroup.add(postDatedChecks);
        paymentGroup.add(cashCheck);
        paymentGroup.add(collectingAgent);
        paymentGroup.add(bank);
        paymentGroup.add(developer);
        paymentGroup.add(remittanceCenter);
        
        contentPanel.add(paymentPanel);

        String[] options = {
            "Purchase of fully developed residential lot or adjoining residential lots",
            "Purchase of a residential house and lot, townhouse or condominium unit, inclusive of a parking slot",
            "Construction or completion of a residential unit on a residential lot",
            "Home improvement",
            "Refinancing of an existing housing loan",
            "Purchase of a parking slot",
            "Purchase of residential lot plus cost of transfer of title",
            "Purchase of residential unit plus cost of transfer of title"
        };
        
        List<JRadioButton> radioButtons = new ArrayList<>();

        ButtonGroup group = new ButtonGroup();
        int yOffset = 180;
        for (String option : options) {
            JRadioButton radio = new JRadioButton("<html><body style='width:550px'>" + option + "</body></html>");  
            radio.setBackground(Color.WHITE);
            radio.setBounds(20, yOffset, 500, 30);   
            radio.setFont(new Font("SansSerif", Font.PLAIN, 11));
            group.add(radio);
            radioButtons.add(radio);
            contentPanel.add(radio);
            yOffset += 30;  
        }
        
        
        // with existing housing application
        JLabel existingAppLabel = new JLabel("With Existing Housing Application");
        existingAppLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        existingAppLabel.setForeground(Color.BLACK);
        existingAppLabel.setBounds(20, yOffset + 10, 300, 20);
        contentPanel.add(existingAppLabel);

        // Yes/No radio buttons
        ButtonGroup yesNoGroup = new ButtonGroup();
        JRadioButton yesRadio = new JRadioButton("Yes");
        yesRadio.setBackground(Color.WHITE);
        yesRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        yesRadio.setBounds(20, yOffset + 35, 60, 20);

        JRadioButton noRadio = new JRadioButton("No");
        noRadio.setBackground(Color.WHITE);
        noRadio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        noRadio.setBounds(90, yOffset + 35, 60, 20);

        yesNoGroup.add(yesRadio);
        yesNoGroup.add(noRadio);

        contentPanel.add(yesRadio);
        contentPanel.add(noRadio);

        // Label and text field for Housing Application No.
        JLabel housingAppNoLabel = new JLabel("If yes, indicate Housing Application No.");
        housingAppNoLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        housingAppNoLabel.setForeground(Color.BLACK);
        housingAppNoLabel.setBounds(20, yOffset + 65, 250, 20);
        contentPanel.add(housingAppNoLabel);

        JTextField housingAppNoField = new JTextField();
        housingAppNoField.setBounds(280, yOffset + 65, 200, 22);
        contentPanel.add(housingAppNoField);
        
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.decode("#1F41BB"));
        nextButton.setBounds(contentPanel.getWidth() - 120, contentPanel.getHeight() - 60, 100, 30);
        nextButton.setFocusPainted(false); 
        nextButton.setBorderPainted(false); 
        nextButton.setOpaque(true);  
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        nextButton.addActionListener(e -> {
            purposeLabel.setVisible(false);
            desiredLoanAmountLabel.setVisible(false);
            exclusiveNoteLabel.setVisible(false);
            desiredLoanAmountField.setVisible(false);
            desiredLoanTermLabel.setVisible(false);
            yearsLabel.setVisible(false);
            desiredLoanTermField.setVisible(false);
            repricingPeriodLabel.setVisible(false);
            repricingNote.setVisible(false);
            radioPanel.setVisible(false);
            paymentLabel.setVisible(false);
            paymentPanel.setVisible(false);
            existingAppLabel.setVisible(false);
            yesRadio.setVisible(false);
            noRadio.setVisible(false);
            housingAppNoLabel.setVisible(false);
            housingAppNoField.setVisible(false);
            for (JRadioButton radioButton : radioButtons) {
                radioButton.setVisible(false); 
            }
            progressBar.setCurrentStep(2);
            System.out.println("Next button clicked, moving to step 2.");
        });
        contentPanel.add(nextButton);
        



        this.getContentPane().repaint();
        this.getContentPane().revalidate();
    }

    private JButton createSidebarButton(String text, String iconPath, int yPosition) {
        ImageIcon icon = new ImageIcon(iconPath);
        JButton button = new JButton(text, icon);
        button.setBounds(10, yPosition, 220, 40);
        button.setFont(new Font("Poppins", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#1F41BB"));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setHorizontalAlignment(JButton.LEFT);
        button.setIconTextGap(10);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }
    
    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (button != activeButton) {
                    button.setBackground(Color.decode("#12297D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (button != activeButton) {
                    button.setBackground(Color.decode("#1F41BB"));
                }
            }
        });
    }

    private void setActiveButton(JButton button) {
        for (JButton btn : sidebarButtons) {
            if (btn == button) {
                btn.setBackground(Color.decode("#12297D")); 
            } else {
                btn.setBackground(Color.decode("#1F41BB")); 
            }
        }
        activeButton = button;
    }
    
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberApply(new AuthService()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
