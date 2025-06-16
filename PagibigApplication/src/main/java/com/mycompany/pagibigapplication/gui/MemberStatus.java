
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.models.Application;
import com.mycompany.pagibigapplication.services.AuthService;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.services.MemberApplication;
import java.awt.Color;
import java.awt.Component;
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
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class MemberStatus extends javax.swing.JFrame {

    private JPanel topBar;
    private JPanel sideBar;
    private JSeparator applicantSeparator;
    private JLabel helpLabel;
    
    private List<JButton> sidebarButtons = new ArrayList<>();
    private JButton activeButton = null;
    
    private final AuthService authService;

    public MemberStatus(AuthService authService) {
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
        

        setActiveButton(applicantButton);
        
        // main content
        JLabel welcomeLabel = new JLabel("<html>Welcome home with <b>Pag-IBIG!</b></html>");
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        welcomeLabel.setBounds(240, 55, 400, 40);
        this.getContentPane().add(welcomeLabel);
        
        JLabel homeLabel = new JLabel("APPLICATION STATUS");
        homeLabel.setForeground(Color.BLACK);
        homeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        homeLabel.setBounds(240, 85, 300, 40);
        this.getContentPane().add(homeLabel);
        
        JSeparator topSeparator = new JSeparator();
        topSeparator.setForeground(Color.LIGHT_GRAY);
        int intSeparatorX = 220 + 20;
        int intSeparatorY = 90 + 40;
        int intSeparatorW = getWidth() - intSeparatorX - 30;
        topSeparator.setBounds(intSeparatorX, intSeparatorY, intSeparatorW, 2);
        this.getContentPane().add(topSeparator);
        
        // rounded content panel
        RoundedPanel contentPanel = new RoundedPanel(40);
        contentPanel.setBackground(Color.WHITE);
        int contentX = intSeparatorX; 
        int contentY = intSeparatorY + 20; 
        int contentWidth = intSeparatorW;
        int contentHeight = getHeight() - contentY - 65; 
        contentPanel.setBounds(contentX, contentY, contentWidth, contentHeight);
        contentPanel.setLayout(null); 
        this.getContentPane().add(contentPanel);

        JLabel applicationLabel = new JLabel("Your Application");
        applicationLabel.setForeground(Color.BLACK);
        applicationLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
        applicationLabel.setBounds(20, 20, 300, 30);  
        contentPanel.add(applicationLabel);

        // search 
        JTextField searchField = new JTextField();
        int searchWidth = 200;
        int searchHeight = 30;
        int paddingRight = 20;
        searchField.setBounds(contentWidth - searchWidth - paddingRight, 20, searchWidth, searchHeight);
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        contentPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(contentWidth - searchWidth - 90 - paddingRight, 20, 80, searchHeight);
        searchButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        searchButton.setBackground(new Color(0x12297D));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        contentPanel.add(searchButton);

        // table
        String[] columns = {
            "Application No.", "Member Name", "Date Submitted", "Pag-IBIG MID", "Record", "Status"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return column == 4; 
            }
        };

        JTable table = new JTable(model);
        table.setShowHorizontalLines(true); 
        table.setShowVerticalLines(false); 
        table.setGridColor(Color.LIGHT_GRAY);
        table.setBorder(BorderFactory.createEmptyBorder()); 
        table.setIntercellSpacing(new Dimension(0, 1)); 
        table.setRowHeight(25);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tbl, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(tbl, value, isSelected, hasFocus, row, column);
                c.setBackground(Color.WHITE);
                if (c instanceof JComponent) {
                    ((JComponent) c).setBorder(BorderFactory.createEmptyBorder()); 
                }
                return c;
            }
        });

        table.getColumn("Status").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = new JLabel(value != null ? value.toString() : "");
                label.setOpaque(true);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("SansSerif", Font.BOLD, 12));
                label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                label.setPreferredSize(new Dimension(100, 25));

                String status = value != null ? value.toString() : "";

                switch (status) {
                    case "Approved":
                        label.setBackground(new Color(0x16C09861, true)); 
                        label.setForeground(new Color(0x00B087));
                        label.setBorder(BorderFactory.createLineBorder(new Color(0x00B087)));
                        break;

                    case "Pending":
                        label.setBackground(new Color(0xFFF5CC)); 
                        label.setForeground(new Color(0xDFC204));
                        label.setBorder(BorderFactory.createLineBorder(new Color(0xDFC204)));
                        break;

                    case "Rejected":
                        label.setBackground(new Color(0xFFC5C5));
                        label.setForeground(new Color(0xDF0404));
                        label.setBorder(BorderFactory.createLineBorder(new Color(0xDF0404)));
                        break;

                    default:
                        label.setBackground(Color.WHITE);
                        label.setForeground(Color.BLACK);
                        label.setBorder(BorderFactory.createEmptyBorder());
                        break;
                }

                return label;
            }
        });

        table.getColumn("Record").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

                JButton button = new JButton("View Record");
                button.setForeground(Color.WHITE);
                button.setBackground(new Color(0x12297D));
                button.setFocusPainted(false);
                button.setBorderPainted(false);
                button.setFont(new Font("SansSerif", Font.PLAIN, 12));
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                return button;
            }
        });

        table.getColumn("Record").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            JButton button = new JButton("View Record");

            {
                button.setForeground(Color.WHITE);
                button.setBackground(new Color(0x12297D));
                button.setFocusPainted(false);
                button.setBorderPainted(false);
                button.setFont(new Font("SansSerif", Font.PLAIN, 12));
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));

                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button.setBackground(new Color(0x1F41BB));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setBackground(new Color(0x12297D));
                    }
                }); 

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        fireEditingStopped();
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow >= 0) {
                            int modelRow = table.convertRowIndexToModel(selectedRow);
                            int applicationNo = Integer.parseInt(model.getValueAt(modelRow, 0).toString());
                            String pagibigMid = (String) model.getValueAt(modelRow, 3);
                            try {
                                com.mycompany.pagibigapplication.dao.MemberDao memberDao = new com.mycompany.pagibigapplication.dao.impl.MemberDaoImpl();
                                com.mycompany.pagibigapplication.models.Member member = memberDao.getMemberByPagibigMid(pagibigMid);

                                com.mycompany.pagibigapplication.dao.LoanApplicationDao loanApplicationDao = new com.mycompany.pagibigapplication.dao.impl.LoanApplicationDaoImpl();
                                java.util.List<com.mycompany.pagibigapplication.models.LoanApplication> loanApplications = loanApplicationDao.getLoanApplicationsByApplicationNo(applicationNo);

                                com.mycompany.pagibigapplication.dao.CollateralDao collateralDao = new com.mycompany.pagibigapplication.dao.impl.CollateralDaoImpl();
                                com.mycompany.pagibigapplication.models.Collateral collateral = collateralDao.getCollateralByApplicationNo(applicationNo);

                                com.mycompany.pagibigapplication.dao.SpouseDao spouseDao = new com.mycompany.pagibigapplication.dao.impl.SpouseDaoImpl();
                                com.mycompany.pagibigapplication.models.Spouse spouse = spouseDao.getSpouseByPagibigMid(pagibigMid);

                                com.mycompany.pagibigapplication.dao.BankDao bankDao = new com.mycompany.pagibigapplication.dao.impl.BankDaoImpl();
                                java.util.List<com.mycompany.pagibigapplication.models.Bank> banks = bankDao.getBanksByApplicationNo(applicationNo);

                                com.mycompany.pagibigapplication.dao.RealEstateDao realEstateDao = new com.mycompany.pagibigapplication.dao.impl.RealEstateDaoImpl();
                                java.util.List<com.mycompany.pagibigapplication.models.RealEstate> realEstates = realEstateDao.getRealEstatesByApplicationNo(applicationNo);

                                com.mycompany.pagibigapplication.dao.OutstandingCreditsDao outstandingCreditsDao = new com.mycompany.pagibigapplication.dao.impl.OutstandingCreditsDaoImpl();
                                java.util.List<com.mycompany.pagibigapplication.models.OutstandingCredits> credits = outstandingCreditsDao.getOutstandingCreditsByApplicationNo(applicationNo);

                                com.mycompany.pagibigapplication.dao.EmployerDao employerDao = new com.mycompany.pagibigapplication.dao.impl.EmployerDaoImpl();
                                com.mycompany.pagibigapplication.models.Employer employer = null;
                                if (member != null) {
                                    employer = employerDao.getEmployerByEmployerId(String.valueOf(member.getEmployerId()));
                                }

                                com.mycompany.pagibigapplication.models.Application application = new com.mycompany.pagibigapplication.models.Application();
                                application.setApplicationNo(applicationNo);
                                application.setPagibigMid(pagibigMid);

                                Object dateSubmittedObj = model.getValueAt(modelRow, 2);
                                if (dateSubmittedObj != null) {
                                    try {
                                        application.setDateSubmitted(java.time.LocalDate.parse(dateSubmittedObj.toString()));
                                    } catch (java.time.format.DateTimeParseException ex) {
                                        application.setDateSubmitted(null);
                                    }
                                } else {
                                    application.setDateSubmitted(null);
                                }

                                Object statusObj = model.getValueAt(modelRow, 5);
                                if (statusObj != null) {
                                    try {
                                        application.setStatus(com.mycompany.pagibigapplication.models.Application.Status.valueOf(statusObj.toString()));
                                        if(application.getStatus() == null) {
                                            application.setStatus(com.mycompany.pagibigapplication.models.Application.Status.Pending);
                                        }
                                    } catch (IllegalArgumentException ex) {
                                        application.setStatus(com.mycompany.pagibigapplication.models.Application.Status.Pending);
                                    }
                                } else {
                                    application.setStatus(com.mycompany.pagibigapplication.models.Application.Status.Pending);
                                }

                                MemberRecordDialog dialog = new MemberRecordDialog(MemberStatus.this, application, loanApplications, collateral, spouse, banks, realEstates, credits, employer, pagibigMid);
                                dialog.setVisible(true);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(MemberStatus.this, "Failed to load record details.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                });
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
                return button;
            }

            @Override
            public Object getCellEditorValue() {
                return "View Record";
            }
        });

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.WHITE);
        tableHeader.setOpaque(true);
        tableHeader.setBorder(BorderFactory.createEmptyBorder());
        tableHeader.setFont(new Font("SansSerif", Font.BOLD, 13));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false); 

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 60, contentWidth - 40, contentHeight - 120); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE); 
        scrollPane.setOpaque(false); 
        contentPanel.add(scrollPane);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);  
        columnModel.getColumn(1).setPreferredWidth(200);  

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        try {
            Connection conn = DBConnection.getConnection();
            MemberApplication memberAppService = new MemberApplication(conn);
            List<Application> apps = memberAppService.getApplicationsForMember("123456789012");
            for (Application app : apps) {
                model.addRow(new Object[]{
                    app.getApplicationNo(),
                    app.getMemberName(),
                    app.getDateSubmitted(),
                    app.getPagibigMid(),
                    "View Record", 
                    app.getStatus() != null ? app.getStatus().name() : "Pending"
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading applications: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.");
        }

        searchButton.addActionListener(e -> {
            String text = searchField.getText().trim();
            if (text.isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(text)));
            }
        });



       

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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemberStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberStatus(new AuthService()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
