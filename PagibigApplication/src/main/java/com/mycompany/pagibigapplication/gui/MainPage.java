
package com.mycompany.pagibigapplication.gui;

import javax.swing.ImageIcon;


public class MainPage extends javax.swing.JFrame {


    public MainPage() {
        setTitle("PagIBIG Housing Loan Application");
        ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/pagibigapplication/resources/logoIcon.png");
        setIconImage(icon.getImage());
        
        initComponents();
        setSize(1280, 720);            
        setLocationRelativeTo(null);
    }
    
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

    
    // GUI Code -> Migo
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminButton = new javax.swing.JButton();
        memberButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminButton.setText("Admin");
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        memberButton.setText("Member");
        memberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(adminButton)
                .addGap(61, 61, 61)
                .addComponent(memberButton)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminButton)
                    .addComponent(memberButton))
                .addGap(111, 111, 111))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        handleAdminLogin();
    }//GEN-LAST:event_adminButtonActionPerformed

    private void memberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberButtonActionPerformed
        handleMemberLogin();
    }//GEN-LAST:event_memberButtonActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton memberButton;
    // End of variables declaration//GEN-END:variables
}
