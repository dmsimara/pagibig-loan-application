
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
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;


public class MemberDashboard extends javax.swing.JFrame {
    
    private JPanel topBar;
    private JPanel sideBar;
    private JSeparator applicantSeparator;
    private JLabel helpLabel;
    
    private List<JButton> sidebarButtons = new ArrayList<>();
    private JButton activeButton = null;
    
    private final AuthService authService;

    public MemberDashboard(AuthService authService) {
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
        

        setActiveButton(dashboardButton);
        
        // main content
        JLabel welcomeLabel = new JLabel("<html>Welcome home with <b>Pag-IBIG!</b></html>");
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        welcomeLabel.setBounds(240, 55, 400, 40);
        this.getContentPane().add(welcomeLabel);
        
        JLabel homeLabel = new JLabel("HOME");
        homeLabel.setForeground(Color.BLACK);
        homeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        homeLabel.setBounds(240, 85, 200, 40);
        this.getContentPane().add(homeLabel);
        
        JSeparator topSeparator = new JSeparator();
        topSeparator.setForeground(Color.LIGHT_GRAY);
        int intSeparatorX = 220 + 20;
        int intSeparatorY = 90 + 40;
        int intSeparatorW = getWidth() - intSeparatorX - 30;
        topSeparator.setBounds(intSeparatorX, intSeparatorY, intSeparatorW, 2);
        this.getContentPane().add(topSeparator);
        
        // choice box
        int intRectX = 220 + ((getWidth() - 220 - 500) / 2);
        int intRectY = ((getHeight() - 300) / 2);
        JPanel borderedPanel = new JPanel();
        borderedPanel.setOpaque(false);
        borderedPanel.setBounds(intRectX, intRectY, 500, 300);
        borderedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        borderedPanel.setLayout(null);
        this.getContentPane().add(borderedPanel);
        
        JLabel questionLabel = new JLabel("What brings you here today?");
        questionLabel.setForeground(Color.BLACK);
        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        int intLabelX = (borderedPanel.getWidth() - 400) / 2;
        questionLabel.setBounds(intLabelX, 30, 400, 40);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        borderedPanel.add(questionLabel);
        
        JLabel subLabel = new JLabel("Click your preferred button to proceed.");
        subLabel.setForeground(Color.LIGHT_GRAY);
        subLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        int intSubLabelX = (borderedPanel.getWidth() - 400) / 2;
        int intSubLabelY = 20 + 40 + 10;
        subLabel.setBounds(intSubLabelX, intSubLabelY, 400, 25);
        subLabel.setHorizontalAlignment(SwingConstants.CENTER);
        borderedPanel.add(subLabel);
        
        // apply button
        JButton applyNowButton = new JButton("Apply Now!");
        applyNowButton.setBackground(Color.decode("#1F41BB"));
        applyNowButton.setForeground(Color.WHITE);
        applyNowButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        applyNowButton.setFocusPainted(false);
        int intBtnX = (borderedPanel.getWidth() - 160) / 2;
        int intBtnY = subLabel.getY() + subLabel.getHeight() + 30;
        applyNowButton.setBounds(intBtnX, intBtnY, 160, 40);
        applyNowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        applyNowButton.addActionListener(e -> {
            MemberApply memberApply = new MemberApply(authService);
            memberApply.setVisible(true);
            this.dispose();
        });
        
        borderedPanel.add(applyNowButton);
        
        // status button
        JButton checkStatusBtn = new JButton("Check Status");
        checkStatusBtn.setBackground(Color.decode("#008767"));
        checkStatusBtn.setForeground(Color.WHITE);
        checkStatusBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        checkStatusBtn.setFocusPainted(false);
        int intCheckBtnX = (borderedPanel.getWidth() - 160) / 2;
        int intCheckBtnY = applyNowButton.getY() + applyNowButton.getHeight() + 15;
        checkStatusBtn.setBounds(intCheckBtnX, intCheckBtnY, 160, 40);
        checkStatusBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        checkStatusBtn.addActionListener(e -> {
            MemberStatus memberStatus = new MemberStatus();
            memberStatus.setVisible(true);
            this.dispose();
        });
        borderedPanel.add(checkStatusBtn);

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
                new MemberDashboard(new AuthService()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
