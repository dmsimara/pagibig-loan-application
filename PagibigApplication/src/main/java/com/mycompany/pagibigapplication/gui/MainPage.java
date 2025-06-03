
package com.mycompany.pagibigapplication.gui;

import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;

public class MainPage extends javax.swing.JFrame {


    public MainPage() {
        setTitle("PagIBIG Housing Loan Application");
        ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/logoIcon.png");
        setIconImage(icon.getImage());
        
        initComponents();
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout());
        
        // Logo Image
        ImageIcon logoIcon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/mainLogo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel titleLabel = new JLabel("Pag-IBIG Housing Loan");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.decode("#1F41BB"));
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 38));
        titleLabel.setBorder(new EmptyBorder(-10, 0, 0, 0));
        
        JLabel subtitleLabel = new JLabel("Application System");
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
        
        // buttons
        Color normalColor = Color.decode("#1F41BB");
        Color hoverColor = Color.decode("#12297D");
        
        JButton adminButton = new JButton("Admin");
        adminButton.setBackground(normalColor);
        adminButton.setForeground(Color.WHITE);
        adminButton.setFocusPainted(false);
        adminButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        adminButton.setPreferredSize(new Dimension(120, 40));
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAdminLogin();
            }
        });
        adminButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminButton.setBackground(hoverColor);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminButton.setBackground(normalColor);
            }
        });
        
        JButton memberButton = new JButton("Member");
        memberButton.setBackground(normalColor);
        memberButton.setForeground(Color.WHITE);
        memberButton.setFocusPainted(false);
        memberButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        memberButton.setPreferredSize(new Dimension(120, 40));
        memberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleMemberLogin();
            }
        });
        memberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                memberButton.setBackground(hoverColor);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                memberButton.setBackground(normalColor);
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        
        buttonPanel.add(adminButton);
        buttonPanel.add(memberButton);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(logoLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 2)));
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        centerPanel.add(subtitleLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(buttonPanel);
        
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        setSize(1280, 720);            
        setLocationRelativeTo(null);
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

    // this is the logic for admin button
    public void handleAdminLogin() {
        new AdminLogin().setVisible(true);
        this.dispose();
    }
    
    // this is the logic for member button
    public void handleMemberLogin() {
        new MemberLogin().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
