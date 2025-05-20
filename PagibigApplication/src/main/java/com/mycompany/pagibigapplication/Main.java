
package com.mycompany.pagibigapplication;

import com.mycompany.pagibigapplication.gui.MainPage;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }
}
