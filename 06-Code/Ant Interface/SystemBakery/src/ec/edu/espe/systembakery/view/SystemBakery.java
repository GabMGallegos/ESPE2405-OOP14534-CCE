package ec.edu.espe.systembakery.view;

import com.mongodb.client.MongoDatabase;
import ec.edu.espe.systembakery.*;
import ec.edu.espe.utils.Conection;
import javax.swing.JOptionPane;

public class SystemBakery {

    public static void main(String[] args) {
        Conection conn = new Conection();
        MongoDatabase database;

        if (conn != null) {
            conn = conn.createConection();
            database = conn.getMongoDatabase();

            // Create and display the splash screen
            FrmSystemBakerySplash splash = new FrmSystemBakerySplash();
            splash.setVisible(true);

            // Create the login form
            FrmLogin login = new FrmLogin(database);

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
        } else {
            JOptionPane.showMessageDialog(null, "Connection Error", "CONNECTION", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }
}
