
package com.mycompany.pagibigapplication.gui;

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

import com.mycompany.pagibigapplication.services.AuthService;
import java.awt.Image;
import java.net.URL;

public class AdminDashboard extends javax.swing.JFrame {

    private JPanel topBar;
    private JPanel sideBar;
    private JSeparator applicantSeparator;
    private JLabel helpLabel;
    
    private List<JButton> sidebarButtons = new ArrayList<>();
    private JButton activeButton = null;
    
    private final AuthService authService;
    
    public AdminDashboard(AuthService authService) {
        this.authService = authService;
        
        setTitle("PagIBIG Housing Loan Application");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logoIcon.png"));
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
        ImageIcon header = new ImageIcon(getClass().getResource("/images/header.png"));
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
        ImageIcon profileIcon = new ImageIcon(getClass().getResource("/images/profile.png"));
        int intProfileH = 30;
        int intProfileW = (profileIcon.getIconWidth() * intProfileH) / profileIcon.getIconHeight();
        Image profileImage = profileIcon.getImage().getScaledInstance(intProfileW, intProfileH, Image.SCALE_SMOOTH);
        ImageIcon scaledProfileIcon = new ImageIcon(profileImage);
        JLabel profileLabel = new JLabel(scaledProfileIcon);
        
        int intProfileO = (45 - intProfileH) / 2;
        int intProfileX = topBar.getWidth() - 170;
        profileLabel.setBounds(intProfileX, intProfileO, intProfileW, intProfileH);
        topBar.add(profileLabel);
        
        // "Hello, Admin"
        JLabel greetingLabel = new JLabel("<html><b>Hello,</b> Admin!</html>");
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
        
        JButton dashboardButton = createSidebarButton("Dashboard", "/images/dashboardIcon.png", 50);
        JButton loanQueueButton = createSidebarButton("Loan Queue", "/images/loanQueueIcon.png", 100);
        JButton applicantButton = createSidebarButton("Applicant Records ˅", "/images/applicantIcon.png", 150);
        
        sideBar.add(dashboardButton);
        sideBar.add(loanQueueButton);
        sideBar.add(applicantButton);
        
        

        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(null);
        dropdownPanel.setBounds(10, 190, 230, 240);
        dropdownPanel.setBackground(Color.decode("#1F41BB"));
        dropdownPanel.setVisible(false);
        sideBar.add(dropdownPanel);

        String[] subItems = {
            "Loan Particular", "Member", "Collateral", "Spouse",
            "Bank", "Real Estate", "Outstanding Credits", "Employer"
        };

        for (int i = 0; i < subItems.length; i++) {
            JButton subButton = new JButton(subItems[i]);
            subButton.setBounds(15, i * 30, 200, 30);
            subButton.setFont(new Font("Poppins", Font.PLAIN, 13));
            subButton.setForeground(Color.WHITE);
            subButton.setBackground(Color.decode("#1F41BB"));
            subButton.setBorderPainted(false);
            subButton.setFocusPainted(false);
            subButton.setHorizontalAlignment(JButton.LEFT);
            subButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            addHoverEffect(subButton);

            String strItem = subItems[i];
            subButton.addActionListener(e -> {
                setActiveButton(subButton);
                switch (strItem) {
                    case "Loan Particular":
                        new LoanParticular(authService).setVisible(true);
                        break;
                    case "Bank":
                        new BankPage(authService).setVisible(true);
                        break;
                    case "Member":
                        new MemberPage(authService).setVisible(true);
                        break;
                    case "Collateral":
                        new CollateralPage(authService).setVisible(true);
                        break;
                    case "Spouse":
                        new SpousePage(authService).setVisible(true);
                        break;
                    case "Real Estate":
                        new RealEstatePage(authService).setVisible(true);
                        break;
                    case "Outstanding Credits":
                        new OutstandingCreditsPage(authService).setVisible(true);
                        break;
                    case "Employer":
                        new EmployerPage(authService).setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Page not yet implemented.");
                }
                this.dispose();
            });

            dropdownPanel.add(subButton);
        }

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
        
        JButton settingsButton = createSidebarButton("Settings", "/images/settingsIcon.png", 250);
        sideBar.add(settingsButton);
        addHoverEffect(settingsButton);
        sidebarButtons.add(settingsButton);
        
        // logout
        JSeparator bottomSeparator = new JSeparator();
        bottomSeparator.setForeground(Color.WHITE);
        bottomSeparator.setBounds(10, sideBar.getHeight() - 100, 180, 1);
        sideBar.add(bottomSeparator);
        
        int logoutY = sideBar.getHeight() - 90; 
        JButton logoutButton = createSidebarButton("Log out", "/images/logoutIcon.png", logoutY);
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

        applicantButton.addActionListener(e -> {
            boolean isVisible = dropdownPanel.isVisible();
            dropdownPanel.setVisible(!isVisible);
            applicantButton.setText("Applicant Records " + (isVisible ? "˅" : "˄"));            
            int intDropdownHeight = dropdownPanel.getComponentCount() * 30;
            int intNewY = isVisible ? 200 : 200 + intDropdownHeight;
            
            applicantSeparator.setBounds(10, intNewY, 180, 1);
            helpLabel.setBounds(20, intNewY + 10, 160, 30);
            settingsButton.setBounds(10, intNewY + 50, 180, 40);
        });

        dashboardButton.addActionListener(e -> {
            setActiveButton(dashboardButton);
            new AdminDashboard(authService).setVisible(true);
            this.dispose();
        });

        loanQueueButton.addActionListener(e -> {
            setActiveButton(loanQueueButton);
            new LoanQueue(authService).setVisible(true);
            this.dispose();
        });

        addHoverEffect(dashboardButton);
        addHoverEffect(loanQueueButton);

        sidebarButtons.add(dashboardButton);
        sidebarButtons.add(loanQueueButton);
        
        setActiveButton(dashboardButton);
        
        JLabel dashboardLabel = new JLabel("DASHBOARD");
        dashboardLabel.setForeground(Color.BLACK);
        dashboardLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        dashboardLabel.setBounds(240, 60, 200, 40);
        this.getContentPane().add(dashboardLabel);
        
        RoundedPanel contentPanel = new RoundedPanel(40);
        int contentX = 240;
        int contentY = 110;
        int contentWidth = getWidth() - contentX - 40;
        int contentHeight = ((getHeight() - contentY - 50) / 3) + 30;
        contentPanel.setBounds(contentX, contentY, contentWidth, contentHeight);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);
        this.getContentPane().add(contentPanel);

        JLabel overviewLabel = new JLabel("Overview Cards");
        overviewLabel.setForeground(Color.BLACK);
        overviewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        overviewLabel.setBounds(20, 20, 200, 30);
        contentPanel.add(overviewLabel);

        JLabel summaryLabel = new JLabel("This is the quick summary of Pag-IBIG Housing Loan Application");
        summaryLabel.setForeground(Color.GRAY);
        summaryLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        summaryLabel.setBounds(20, 50, 600, 20);
        contentPanel.add(summaryLabel);
        
        java.net.URL imgURL = getClass().getResource("/images/memberCard.png");
        ImageIcon memberCardIcon = new ImageIcon(imgURL);
        int imgWidth = memberCardIcon.getIconWidth();
        int imgHeight = memberCardIcon.getIconHeight();
        int targetHeight = 40;
        int targetWidth = (imgWidth * targetHeight) / imgHeight;
        Image scaledMember = memberCardIcon.getImage().getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon IconMember = new ImageIcon(scaledMember);
        JLabel memberLabel = new JLabel(IconMember);
        int imageX = contentPanel.getWidth() - targetWidth - 20;
        int imageY = 20;
        memberLabel.setBounds(imageX, imageY, targetWidth, targetHeight);
        contentPanel.add(memberLabel);
        
        java.net.URL submittedImgURL = getClass().getResource("/images/submitted.png");
        ImageIcon submittedIcon = new ImageIcon(submittedImgURL);
        int submittedImgWidth = submittedIcon.getIconWidth();
        int submittedImgHeight = submittedIcon.getIconHeight();
        int submittedTargetHeight = submittedIcon.getIconHeight() - 10;
        int submittedTargetWidth = (submittedIcon.getIconWidth() * submittedTargetHeight) / submittedIcon.getIconHeight();
        Image submittedScaledImage = submittedIcon.getImage().getScaledInstance(submittedTargetWidth, submittedTargetHeight, Image.SCALE_SMOOTH);
        ImageIcon submittedScaledIcon = new ImageIcon(submittedScaledImage);
        JLabel submittedImageLabel = new JLabel(submittedScaledIcon);

        String[] iconPaths = {"/images/approved.png", "/images/pending.png", "/images/rejected.png"};
        java.util.List<ImageIcon> iconsList = new java.util.ArrayList<>();
        int spacingIcons = 30; 
        int totalWidth = submittedTargetWidth + (iconPaths.length * spacingIcons);
        for (String iconPath : iconPaths) {
            java.net.URL iconURL = getClass().getResource(iconPath);
            if (iconURL != null) {
                ImageIcon iconImg = new ImageIcon(iconURL);
                int iconWidthImg = iconImg.getIconWidth();
                int iconHeightImg = iconImg.getIconHeight();
                int targetHeightImg = submittedTargetHeight;
                int targetWidthImg = (iconWidthImg * targetHeightImg) / iconHeightImg;
                Image scaledIconImg = iconImg.getImage().getScaledInstance(targetWidthImg, targetHeightImg, Image.SCALE_SMOOTH);
                ImageIcon scaledIconIcon = new ImageIcon(scaledIconImg);
                iconsList.add(scaledIconIcon);
                totalWidth += targetWidthImg;
            }
        }

        int startXIcons = (contentPanel.getWidth() - totalWidth) / 2;
        int imageYIcons = 80;
        int currentXIcons = startXIcons;

        submittedImageLabel.setBounds(currentXIcons, imageYIcons, submittedTargetWidth, submittedTargetHeight);
        contentPanel.add(submittedImageLabel);
        currentXIcons += submittedTargetWidth + spacingIcons;

        for (ImageIcon icon : iconsList) {
            int iconWidthImg = icon.getIconWidth();
            JLabel labelIcon = new JLabel(icon);
            labelIcon.setBounds(currentXIcons, imageYIcons, iconWidthImg, submittedTargetHeight);
            contentPanel.add(labelIcon);
            currentXIcons += iconWidthImg + spacingIcons;
        }
        
        java.net.URL applicationImgURL = getClass().getResource("/images/applications.png");
        if (applicationImgURL != null) {
            ImageIcon applicationIcon = new ImageIcon(applicationImgURL);
            int originalWidth = applicationIcon.getIconWidth();
            int originalHeight = applicationIcon.getIconHeight();
            int appHeight = originalHeight - 20; 
            int appWidth = (originalWidth * appHeight) / originalHeight;
            Image scaledApplicationImage = applicationIcon.getImage().getScaledInstance(appWidth, appHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledApplicationIcon = new ImageIcon(scaledApplicationImage);
            JLabel applicationLabel = new JLabel(scaledApplicationIcon);
            int appImageX = 240; 
            int appImageY = 110 + ((getHeight() - 110 - 50) / 3) + 40; 
            applicationLabel.setBounds(appImageX, appImageY, appWidth, appHeight);
            this.getContentPane().add(applicationLabel);

            java.net.URL usersImgURL = getClass().getResource("/images/users.png");
            if (usersImgURL != null) {
                ImageIcon usersIcon = new ImageIcon(usersImgURL);
                int usersOriginalWidth = usersIcon.getIconWidth();
                int usersOriginalHeight = usersIcon.getIconHeight();

                int usersTargetHeight = appHeight;
                int usersTargetWidth = (usersOriginalWidth * usersTargetHeight) / usersOriginalHeight;
                Image scaledUsersImage = usersIcon.getImage().getScaledInstance(usersTargetWidth, usersTargetHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledUsersIcon = new ImageIcon(scaledUsersImage);
                JLabel usersLabel = new JLabel(scaledUsersIcon);
                int usersImageX = 240 + appWidth + 20; 
                int usersImageY = 110 + ((getHeight() - 110 - 50) / 3) + 40; 
                usersLabel.setBounds(usersImageX, usersImageY, usersTargetWidth, usersTargetHeight);
                this.getContentPane().add(usersLabel);
            }
            
            int baseY = 110 + ((getHeight() - 110 - 50) / 3) + 40;
            int spacingBelow = 5;
            int intImageX = 240;
            int gapBetweenImages = 0;

            URL breakdownImgURL = getClass().getResource("/images/breakdown.png");
            if (breakdownImgURL != null) {
                ImageIcon breakdownIcon = new ImageIcon(breakdownImgURL);
                int breakdownOriginalWidth = breakdownIcon.getIconWidth();
                int breakdownOriginalHeight = breakdownIcon.getIconHeight();

                int breakdownTargetHeight = appHeight; 
                int breakdownTargetWidth = (breakdownOriginalWidth * breakdownTargetHeight) / breakdownOriginalHeight;

                Image scaledBreakdownImage = breakdownIcon.getImage().getScaledInstance(breakdownTargetWidth, breakdownTargetHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledBreakdownIcon = new ImageIcon(scaledBreakdownImage);

                JLabel breakdownLabel = new JLabel(scaledBreakdownIcon);
                int breakdownImageY = baseY + appHeight + spacingBelow;
                breakdownLabel.setBounds(intImageX, breakdownImageY, breakdownTargetWidth, breakdownTargetHeight);
                this.getContentPane().add(breakdownLabel);

                URL timeImgURL = getClass().getResource("/images/time.png");
                if (timeImgURL != null) {
                    ImageIcon timeIcon = new ImageIcon(timeImgURL);
                    int timeOriginalWidth = timeIcon.getIconWidth();
                    int timeOriginalHeight = timeIcon.getIconHeight();

                    int timeTargetHeight = appHeight;
                    int timeTargetWidth = (timeOriginalWidth * timeTargetHeight) / timeOriginalHeight + 25;


                    Image scaledTimeImage = timeIcon.getImage().getScaledInstance(timeTargetWidth, timeTargetHeight, Image.SCALE_SMOOTH);
                    ImageIcon scaledTimeIcon = new ImageIcon(scaledTimeImage);

                    JLabel timeLabel = new JLabel(scaledTimeIcon);
                    int timeImageX = intImageX + breakdownTargetWidth - 40;
                    timeLabel.setBounds(timeImageX, breakdownImageY, timeTargetWidth, timeTargetHeight);
                    this.getContentPane().add(timeLabel);
                }
            }

        }

        this.getContentPane().repaint();
        this.getContentPane().revalidate();
    }

    private JButton createSidebarButton(String text, String iconPath, int yPosition) {
        ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
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
                new AdminDashboard(new AuthService()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
