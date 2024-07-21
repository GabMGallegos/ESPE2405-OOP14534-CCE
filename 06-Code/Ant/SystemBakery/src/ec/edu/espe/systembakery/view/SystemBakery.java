/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espe.systembakery.view;

import ec.edu.espe.systembakery.FrmLogin;
import ec.edu.espe.systembakery.FrmSystemBakerySplash;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leydi Oña
 */
public class SystemBakery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrmSystemBakerySplash splash = new FrmSystemBakerySplash();
                splash.setVisible(true);

                // Run progress bar update in a new thread
                new Thread(new Runnable() {
                    public void run() {
                        FrmLogin login = new FrmLogin();
                        try {
                            for (int i = 0; i <= 100; i++) {
                                Thread.sleep(40);
                                final int percent = i;
                                
                                
                                
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                splash.setVisible(false);
                                login.setVisible(true);
                                splash.dispose();
                            }
                        });
                    }
                }).start();
            }
        });
    }
    
}
