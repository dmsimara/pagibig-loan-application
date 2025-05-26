
package com.mycompany.pagibigapplication;

import com.mycompany.pagibigapplication.gui.MainPage;
import com.mycompany.pagibigapplication.db.DBConnection;
import com.mycompany.pagibigapplication.services.AuthService;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AuthService authService = new AuthService();
            new MainPage().setVisible(true);
        });
    }
}
