
package com.mycompany.pagibigapplication.gui;

import com.mycompany.pagibigapplication.services.AuthService;
import com.mycompany.pagibigapplication.gui.MemberDashboard;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberLogin extends javax.swing.JFrame {

    private AuthService authService;

    public MemberLogin() {
        this(new AuthService());
        
    }

    public MemberLogin(AuthService authService) {
        this.authService = authService;
        
        setTitle("PagIBIG Housing Loan Application");
        ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/logoIcon.png");
        setIconImage(icon.getImage());
        
        initComponents();
        
        setSize(1280, 720);            
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#1F41BB"));
        leftPanel.setBounds(0, 0, (int)(getWidth() * 0.6), getHeight());
        leftPanel.setLayout(null);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds((int)(getWidth() * 0.6), 0, (int)(getWidth() * 0.4), getHeight());
        rightPanel.setLayout(null);
        
        // logo
        ImageIcon loginIcon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/loginLogo.png");
        Image scaledImg = loginIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel loginIconLabel = new JLabel(scaledIcon);
        
        int intPanelWidth = rightPanel.getWidth();
        int intX = (intPanelWidth - 200) / 2;
        int intY = 40;
        loginIconLabel.setBounds(intX, intY, 200, 200);
        rightPanel.add(loginIconLabel);
        
        JLabel loginTitle = new JLabel("Member Portal Login");
        loginTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        loginTitle.setForeground(Color.decode("#1F41BB"));
        loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        loginTitle.setBounds(0, 250, rightPanel.getWidth(), 40);
        rightPanel.add(loginTitle);
        
        JLabel loginSubtitle = new JLabel("Apply for a housing loan, access details");
        loginSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 15));  
        loginSubtitle.setForeground(Color.BLACK);
        loginSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
        loginSubtitle.setBounds((rightPanel.getWidth() - 400) / 2, 295, 400, 30);  
        rightPanel.add(loginSubtitle);
        
        JLabel loginSubtitle2 = new JLabel("and track your application status");
        loginSubtitle2.setFont(new Font("SansSerif", Font.PLAIN, 15));  
        loginSubtitle2.setForeground(Color.BLACK);
        loginSubtitle2.setHorizontalAlignment(SwingConstants.CENTER);
        loginSubtitle2.setBounds((rightPanel.getWidth() - 400) / 2, 320, 400, 25);  
        rightPanel.add(loginSubtitle2);
        
        // username
        int intFieldWidth = 260;
        int intFieldHeight = 40;
        int intFieldY = 335 + 45;   
        int intFieldX = (rightPanel.getWidth() - intFieldWidth) / 2;

        JTextField memberIdField = new JTextField("User Id");
        memberIdField.setBounds(intFieldX, intFieldY, intFieldWidth, intFieldHeight);
        memberIdField.setBackground(Color.decode("#F1F4FF"));
        memberIdField.setForeground(Color.GRAY);
        memberIdField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        LineBorder lineBorder = new LineBorder(Color.decode("#1F41BB"), 2);
        EmptyBorder padding = new EmptyBorder(0, 10, 0, 10);
        memberIdField.setBorder(new CompoundBorder(lineBorder, padding));

        memberIdField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (memberIdField.getText().equals("User Id")) {
                    memberIdField.setText("");
                    memberIdField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (memberIdField.getText().isEmpty()) {
                    memberIdField.setForeground(Color.GRAY);
                    memberIdField.setText("User Id");
                }
            }
        });

        rightPanel.add(memberIdField);
        
        // password
        int intPasswordFieldWidth = 260;
        int intPasswordFieldHeight = 40;
        int intSpacingBelowMemberId = 15;

        int intPasswordFieldY = intFieldY + intFieldHeight + intSpacingBelowMemberId;
        int intPasswordFieldX = (rightPanel.getWidth() - intPasswordFieldWidth) / 2;

        JPasswordField passwordField = new JPasswordField("Password");
        passwordField.setBounds(intPasswordFieldX, intPasswordFieldY, intPasswordFieldWidth, intPasswordFieldHeight);
        passwordField.setBackground(Color.decode("#F1F4FF"));
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        LineBorder passwordBorder = new LineBorder(Color.decode("#1F41BB"), 2);
        EmptyBorder passwordPadding = new EmptyBorder(0, 10, 0, 10);
        passwordField.setBorder(new CompoundBorder(passwordBorder, passwordPadding));

        passwordField.setEchoChar((char) 0);  
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');  
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);  
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        rightPanel.add(passwordField);
        
        int intCheckboxY = intPasswordFieldY + intPasswordFieldHeight + 10;   
        JCheckBox showPasswordCheckbox = new JCheckBox("Show Password");
        showPasswordCheckbox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        showPasswordCheckbox.setBackground(Color.WHITE);  
        showPasswordCheckbox.setForeground(Color.BLACK);
        showPasswordCheckbox.setFocusPainted(false);
        showPasswordCheckbox.setBounds(intPasswordFieldX, intCheckboxY, 200, 20);  

        showPasswordCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    if (!String.valueOf(passwordField.getPassword()).equals("Password")) {
                        passwordField.setEchoChar((char) 0);   
                    }
                } else {
                    if (!String.valueOf(passwordField.getPassword()).equals("Password")) {
                        passwordField.setEchoChar('•');   
                    }
                }
            }
        });

        rightPanel.add(showPasswordCheckbox);
        
        // Login Button
        int intLoginButtonY = intCheckboxY + 50;  
        JButton loginButton = new JButton("Log in");
        loginButton.setBackground(Color.decode("#1F41BB"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setBounds(intPasswordFieldX, intLoginButtonY, intPasswordFieldWidth, 40);  

        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strMemberId = memberIdField.getText().trim();
                String strPassword = String.valueOf(passwordField.getPassword()).trim();

                if (strMemberId.equals("Member Id") || strPassword.equals("Password") || strMemberId.isEmpty() || strPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both Member Id and Password.", "Missing Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                boolean isValid = authService.memberLogin(strMemberId, strPassword);

                if (isValid) {
                    JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();  
                    new MemberDashboard(authService).setVisible(true);   
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Member Id or Password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        rightPanel.add(loginButton);


        getContentPane().add(leftPanel);
        getContentPane().add(rightPanel);

        rightPanel.requestFocusInWindow();
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

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
