package ec.edu.espe.systembakery;

import com.mongodb.client.MongoDatabase;
import ec.edu.espe.systembakery.view.FrmLogin;
import ec.edu.espe.systembakery.view.FrmSystemBakerySplash;
import ec.edu.espe.utils.Conection;
import javax.swing.JOptionPane;

public class SystemBakery {

    public static void main(String[] args) {
        Conection conn = new Conection();
        MongoDatabase database;

        try {
            conn = conn.createConection();
            database = conn.getMongoDatabase();

            if (database == null) {
                throw new Exception("Database connection is null.");
            }
            // Create and display the splash screen
            FrmSystemBakerySplash splash = new FrmSystemBakerySplash();
            splash.setVisible(true);

            // Create the login form
            FrmLogin login = new FrmLogin(database);

            // Simulate progress and update the splash screen
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(45);  // Simulate time-consuming task
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
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error", "CONNECTION", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }
}
