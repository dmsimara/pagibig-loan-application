
package com.mycompany.pagibigapplication.gui;

import javax.swing.*;
import java.awt.*;
import com.mycompany.pagibigapplication.services.ApplicationData;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.pagibigapplication.services.AuthService;

public class MultiStepForm extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private ApplicationData appData = new ApplicationData();
    private int step = 1;
    private JPanel topBar;
    private JPanel stepIndicatorPanel;
    private final String[] stepNames = {
        "Loan Particular", "Member", "Collateral", "Spouse", "Bank",
        "Real State", "Outstanding Credits", "Employer", "Confirm"
    };
    private List<JLabel> stepLabels = new ArrayList<>();
    private JPanel sideBar;
    private List<JButton> sidebarButtons = new ArrayList<>();
    private JButton activeButton;
    private AuthService authService = new AuthService();
    
    public MultiStepForm() {
        setTitle("PagIBIG Housing Loan Application");
        ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/logoIcon.png");
        setIconImage(icon.getImage());
        
        initComponents();
        setLayout(null);  
        setSize(1280, 720);            
        setLocationRelativeTo(null); 
        setupCustomLayout();
        
        revalidate();
        repaint();
    }
    
    private void setupStepIndicator() {
        stepIndicatorPanel = new JPanel();
        stepIndicatorPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        stepIndicatorPanel.setBackground(Color.WHITE);
        stepLabels.clear();

        for (int i = 0; i < stepNames.length; i++) {
            JLabel stepLabel = new JLabel(stepNames[i]);
            stepLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            stepLabel.setOpaque(true);
            stepLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            stepLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            stepLabels.add(stepLabel);
            stepIndicatorPanel.add(stepLabel);
        }
        updateStepIndicator();
        // Add stepIndicatorPanel to content pane outside cardPanel
        this.getContentPane().add(stepIndicatorPanel);
        stepIndicatorPanel.setBounds(240, 60, getWidth() - 240, 40);
    }

    private void updateStepIndicator() {
        for (int i = 0; i < stepLabels.size(); i++) {
            JLabel label = stepLabels.get(i);
            if (i == step - 1) {
                label.setBackground(Color.decode("#1F41BB"));
                label.setForeground(Color.WHITE);
                label.setFont(new Font("SansSerif", Font.BOLD, 14));
            } else {
                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLACK);
                label.setFont(new Font("SansSerif", Font.PLAIN, 14));
            }
        }
    }

    private RoundedPanel step1Panel;
    private Step1Panel step1PanelContent;
    private RoundedPanel step2Panel;
    private Step2Panel step2PanelContent;
    private RoundedPanel step3Panel;
    private Step3Panel step3PanelContent;
    private RoundedPanel step4Panel;
    private Step4Panel step4PanelContent;
    private RoundedPanel step5Panel;
    private Step5Panel step5PanelContent;
    private RoundedPanel step6Panel;
    private Step6Panel step6PanelContent;
    private RoundedPanel step7Panel;
    private Step7Panel step7PanelContent;
    private RoundedPanel step8Panel;
    private Step8Panel step8PanelContent;
    private RoundedPanel step9Panel;
    private Step9Panel step9PanelContent;

    public void nextStep() {
        if (step < stepNames.length) {
            step++;
            cardLayout.show(cardPanel, String.valueOf(step));
            updateStepIndicator();
            if (step == 1) {
                step1PanelContent.setupForm();
                step1PanelContent.validateForm();
            } else if (step == 2) {
                step2PanelContent.setupForm();
                step2PanelContent.validateForm();
            } else if (step == 3) {
                step3PanelContent.setupForm();
                step3PanelContent.validateForm();
            } else if (step == 4) {
                step4PanelContent.setupForm();
                step4PanelContent.validateForm();
            } else if (step == 5) {
                step5PanelContent.setupForm();
                step5PanelContent.validateForm();
            } else if (step == 6) {
                step6PanelContent.setupForm();
                step6PanelContent.validateForm();
            } else if (step == 7) {
                step7PanelContent.setupForm();
                step7PanelContent.validateForm();
            } else if (step == 8) {
                step8PanelContent.setupForm();
                step8PanelContent.validateForm();
            } else if (step == 9) {
                step9PanelContent.setupForm();
            }
        }
    }

    public void previousStep() {
        if (step > 1) {
            step--;
            cardLayout.show(cardPanel, String.valueOf(step));
            updateStepIndicator();
            if (step == 1) {
                step1PanelContent.setupForm();
                step1PanelContent.validateForm();
            } else if (step == 2) {
                step2PanelContent.setupForm();
                step2PanelContent.validateForm();
            } else if (step == 3) {
                step3PanelContent.setupForm();
                step3PanelContent.validateForm();
            } else if (step == 4) {
                step4PanelContent.setupForm();
                step4PanelContent.validateForm();
            } else if (step == 5) {
                step5PanelContent.setupForm();
                step5PanelContent.validateForm();
            } else if (step == 6) {
                step6PanelContent.setupForm();
                step6PanelContent.validateForm();
            } else if (step == 7) {
                step7PanelContent.setupForm();
                step7PanelContent.validateForm();
            } else if (step == 8) {
                step8PanelContent.setupForm();
                step8PanelContent.validateForm();
            } else if (step == 9) {
                step9PanelContent.setupForm();
            }
        }
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

    
    
    private void setupCustomLayout() {
        // for top bar
        topBar = new JPanel();
        topBar.setBackground(Color.WHITE);
        topBar.setBounds(0, 0, getWidth(), 45);
        topBar.setLayout(null);
        this.getContentPane().add(topBar);

        setupStepIndicator();

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
        JSeparator applicantSeparator = new JSeparator();
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
                    new AdminLogin().setVisible(true);
                } else if ("member".equals(strRole)) {
                    new MemberLogin().setVisible(true);
                } else {
                    new AdminLogin().setVisible(true);
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
            new MultiStepForm().setVisible(true);
            this.dispose();
        });

        applicantButton.addActionListener(e -> {
            setActiveButton(applicantButton);
            new MemberStatus(authService).setVisible(true);
            this.dispose();
        });

        addHoverEffect(dashboardButton);
        addHoverEffect(loanQueueButton);
        addHoverEffect(applicantButton);

        sidebarButtons.add(dashboardButton);
        sidebarButtons.add(loanQueueButton);
        sidebarButtons.add(applicantButton);

        setActiveButton(loanQueueButton);

        // Main content using CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(240, 100, 1000, 550);
        cardPanel.setOpaque(false);
        this.getContentPane().add(cardPanel);

        
        step1Panel = new RoundedPanel(40);
        step1Panel.setLayout(new BorderLayout());
        step1Panel.setBackground(Color.WHITE);
        step1PanelContent = new Step1Panel(this, appData);
        step1Panel.add(step1PanelContent, BorderLayout.CENTER);
        cardPanel.add(step1Panel, "1");

        step2Panel = new RoundedPanel(40);
        step2Panel.setLayout(new BorderLayout());
        step2Panel.setBackground(Color.WHITE);
        step2PanelContent = new Step2Panel(this, appData);
        step2Panel.add(step2PanelContent, BorderLayout.CENTER);
        cardPanel.add(step2Panel, "2");
        
        step3Panel = new RoundedPanel(40);
        step3Panel.setLayout(new BorderLayout());
        step3Panel.setBackground(Color.WHITE);
        step3PanelContent = new Step3Panel(this, appData);
        step3Panel.add(step3PanelContent, BorderLayout.CENTER);
        cardPanel.add(step3Panel, "3");
        
        step4Panel = new RoundedPanel(40);
        step4Panel.setLayout(new BorderLayout());
        step4Panel.setBackground(Color.WHITE);
        step4PanelContent = new Step4Panel(this, appData);
        step4Panel.add(step4PanelContent, BorderLayout.CENTER);
        cardPanel.add(step4Panel, "4");
        
        step5Panel = new RoundedPanel(40);
        step5Panel.setLayout(new BorderLayout());
        step5Panel.setBackground(Color.WHITE);
        step5PanelContent = new Step5Panel(this, appData);
        step5Panel.add(step5PanelContent, BorderLayout.CENTER);
        cardPanel.add(step5Panel, "5");
        
        step6Panel = new RoundedPanel(40);
        step6Panel.setLayout(new BorderLayout());
        step6Panel.setBackground(Color.WHITE);
        step6PanelContent = new Step6Panel(this, appData);
        step6Panel.add(step6PanelContent, BorderLayout.CENTER);
        cardPanel.add(step6Panel, "6");
        
        step7Panel = new RoundedPanel(40);
        step7Panel.setLayout(new BorderLayout());
        step7Panel.setBackground(Color.WHITE);
        step7PanelContent = new Step7Panel(this, appData);
        step7Panel.add(step7PanelContent, BorderLayout.CENTER);
        cardPanel.add(step7Panel, "7");

        step8Panel = new RoundedPanel(40);
        step8Panel.setLayout(new BorderLayout());
        step8Panel.setBackground(Color.WHITE);
        step8PanelContent = new Step8Panel(this, appData);
        step8Panel.add(step8PanelContent, BorderLayout.CENTER);
        cardPanel.add(step8Panel, "8");
        
        step9Panel = new RoundedPanel(40);
        step9Panel.setLayout(new BorderLayout());
        step9Panel.setBackground(Color.WHITE);
        step9PanelContent = new Step9Panel(this, appData);
        step9Panel.add(step9PanelContent, BorderLayout.CENTER);
        cardPanel.add(step9Panel, "9");
        
        // Show first step
        cardLayout.show(cardPanel, "1");
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
        SwingUtilities.invokeLater(() -> {
            MultiStepForm form = new MultiStepForm();
            form.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
