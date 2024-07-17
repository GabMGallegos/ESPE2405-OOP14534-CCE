/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.bakery.view;

/**
 *
 * @author Molina Gallegos Gabriel Anthony, CodeCrafting Engineers
 */
public class FrmBakery extends javax.swing.JFrame {

    /**
     * Creates new form FrmCyberPlanet
     */
    public FrmBakery() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuBakery = new javax.swing.JMenu();
        itmLogout = new javax.swing.JMenuItem();
        itmExit = new javax.swing.JMenuItem();
        mnuProducts = new javax.swing.JMenu();
        itmAddNewProduct = new javax.swing.JMenuItem();
        itmDeleteProduct = new javax.swing.JMenuItem();
        mnuListProducts = new javax.swing.JMenu();
        itmFoundProduct = new javax.swing.JMenuItem();
        mnuSuppliers = new javax.swing.JMenu();
        mnuPurchases = new javax.swing.JMenu();
        mnuHelp = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuBakery.setText("Panadería");

        itmLogout.setText("Logout");
        itmLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmLogoutActionPerformed(evt);
            }
        });
        mnuBakery.add(itmLogout);

        itmExit.setText("Exit");
        itmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExitActionPerformed(evt);
            }
        });
        mnuBakery.add(itmExit);

        jMenuBar1.add(mnuBakery);

        mnuProducts.setText("Productos");

        itmAddNewProduct.setText("Añadir nuevo(s) producto(s)");
        itmAddNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddNewProductActionPerformed(evt);
            }
        });
        mnuProducts.add(itmAddNewProduct);

        itmDeleteProduct.setText("Eliminar Producto(s)");
        mnuProducts.add(itmDeleteProduct);

        mnuListProducts.setText("Listar Productos");

        itmFoundProduct.setText("Buscar producto");
        mnuListProducts.add(itmFoundProduct);

        mnuProducts.add(mnuListProducts);

        jMenuBar1.add(mnuProducts);

        mnuSuppliers.setText("Proovedores");
        jMenuBar1.add(mnuSuppliers);

        mnuPurchases.setText("Compras");
        jMenuBar1.add(mnuPurchases);

        mnuHelp.setText("Ayuda");

        jMenuItem1.setText("jMenuItem1");
        mnuHelp.add(jMenuItem1);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmLogoutActionPerformed
        FrmLogin frmLogin = new FrmLogin();
        this.setVisible(false);
        frmLogin.setVisible(true);
    }//GEN-LAST:event_itmLogoutActionPerformed

    private void itmAddNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddNewProductActionPerformed
        FrmAddNewProduct frmAddNewProduct = new FrmAddNewProduct();
        this.setVisible(false);
        frmAddNewProduct.setVisible(true);
    }//GEN-LAST:event_itmAddNewProductActionPerformed

    private void itmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itmExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBakery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAddNewProduct;
    private javax.swing.JMenuItem itmDeleteProduct;
    private javax.swing.JMenuItem itmExit;
    private javax.swing.JMenuItem itmFoundProduct;
    private javax.swing.JMenuItem itmLogout;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu mnuBakery;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuListProducts;
    private javax.swing.JMenu mnuProducts;
    private javax.swing.JMenu mnuPurchases;
    private javax.swing.JMenu mnuSuppliers;
    // End of variables declaration//GEN-END:variables
}
