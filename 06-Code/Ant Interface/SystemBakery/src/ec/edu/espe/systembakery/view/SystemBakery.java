package ec.edu.espe.systembakery.view;

import ec.edu.espe.systembakery.*;

public class SystemBakery {

    public static void main(String[] args) {
        // Create and display the splash screen
        FrmSystemBakerySplash splash = new FrmSystemBakerySplash();
        splash.setVisible(true);

        // Create the login form
        FrmLogin login = new FrmLogin();

        // Simulate progress and update the splash screen
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);  // Simulate time-consuming task
                final int percent = i;
                javax.swing.SwingUtilities.invokeLater(() -> {
                    splash.setBarValue(percent);
                    splash.getProgress().setText(percent + " %");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Hide the splash screen and show the login form
        javax.swing.SwingUtilities.invokeLater(() -> {
            splash.setVisible(false);
            login.setVisible(true);
            splash.dispose();
        });
    }
}
