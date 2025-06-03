
package com.mycompany.pagibigapplication.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.awt.FontMetrics;


public class CircularStepProgressBar extends javax.swing.JPanel {
    
    private int currentStep = 1;
    private final String[] steps = {
        "Loan Particular",
        "Member",
        "Collateral",
        "Spouse",
        "Bank",
        "Real Estate",
        "Outstanding Credits",
        "Employer",
        "Confirm"
    };

    public CircularStepProgressBar() {
        initComponents();
        this.setPreferredSize(new Dimension(1000, 120));
        this.setBackground(Color.WHITE);
    }
    
    public void setCurrentStep(int step) {
        if (step < 1) step = 1;
        if (step > steps.length) step = steps.length;
        this.currentStep = step;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int circleDiameter = 25;    
        int circleRadius = circleDiameter / 2;

        int padding = 50;  
        int usableWidth = width - 2 * padding;
        int stepCount = steps.length;

        int stepWidth = usableWidth / (stepCount - 1);

        int circleY = 30;
        int labelY = circleY + circleDiameter + 20;

        Font labelFont = new Font("SansSerif", Font.PLAIN, 12);
        FontMetrics fm = g2.getFontMetrics(labelFont);

        for (int i = 0; i < stepCount - 1; i++) {
            int x1 = padding + i * stepWidth + circleRadius;
            int x2 = padding + (i + 1) * stepWidth + circleRadius;
            int y = circleY + circleRadius;

            if (i < currentStep - 1) {
                g2.setColor(new Color(31, 65, 187)); 
            } else {
                g2.setColor(Color.LIGHT_GRAY);
            }
            g2.fillRect(x1, y - 1, x2 - x1, 2);
        }

        for (int i = 0; i < stepCount; i++) {
            int x = padding + i * stepWidth;
            int circleX = x;

            if (i < currentStep) {
                g2.setColor(new Color(31, 65, 187)); 
                g2.fillOval(circleX, circleY, circleDiameter, circleDiameter);
            } else {
                g2.setColor(Color.WHITE);
                g2.fillOval(circleX, circleY, circleDiameter, circleDiameter);
            }

            g2.setColor(Color.BLACK);
            g2.drawOval(circleX, circleY, circleDiameter, circleDiameter);


            g2.setColor(Color.BLACK);
            g2.setFont(labelFont);
            String label = steps[i];
            int labelWidth = fm.stringWidth(label);
            int labelX = circleX + circleRadius - labelWidth / 2;

            g2.drawString(label, labelX, labelY);
        }
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
