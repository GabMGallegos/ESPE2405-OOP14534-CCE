/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.systembakery;

import javax.swing.JOptionPane;

/**
 *
 * @author Leydi Oña
 */
public class FrmBakery extends javax.swing.JFrame {

    /**
     * Creates new form FrmBakery
     */
    public FrmBakery() {
        initComponents();
    }

    private void cerrar() {
        String botones[] = {"CERRAR", "CANCELAR"};
        int eleccion = JOptionPane.showOptionDialog(this, "Desea cerrar el programa", "Titulo",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.out.println("Se cancelo el cierre");
        }

    }

    private void showFrmBillMenu() {
        if (jTabbedPane1.getSelectedComponent() == jPanel4) {
            jTabbedPane1.setSelectedComponent(jPanel2);
        } else {
            FrmCreateBillConsumer bill = new FrmCreateBillConsumer();
            jPanel4.add( bill.getContentPane());
            bill.setVisible(false);
            jTabbedPane1.setSelectedComponent(jPanel4);
        }
    }
    private void showFrmBillMake() {
        if (jTabbedPane1.getSelectedComponent() == jPanel3) {
            jTabbedPane1.setSelectedComponent(jPanel2);
        } else {
            FrmCreatePurchaseOrder bill = new FrmCreatePurchaseOrder ();
            jPanel3.add( bill.getContentPane());
            bill.setVisible(false);
            jTabbedPane1.setSelectedComponent(jPanel3);
        }
    }
    
    private void showFrmAddSupplier() {
        if (jTabbedPane1.getSelectedComponent() == jPanel5) {
            jTabbedPane1.setSelectedComponent(jPanel2);
        } else {
            FrmAddSupplier bill = new FrmAddSupplier();
            jPanel5.add( bill.getContentPane());
            bill.setVisible(false);
            jTabbedPane1.setSelectedComponent(jPanel5);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        Mnu = new javax.swing.JMenu();
        mnuitSignOff = new javax.swing.JMenuItem();
        mnuitmExit = new javax.swing.JMenuItem();
        mnuProduct = new javax.swing.JMenu();
        mnuAddProducts = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuSuppliers = new javax.swing.JMenu();
        mnuAddSuppliers = new javax.swing.JMenu();
        mnuCosultSuppliers = new javax.swing.JMenu();
        mnuMakeOrder = new javax.swing.JMenu();
        itmMakePurchaseOrderToSupplier = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        itmMakeBillToConsumer = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuBill = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        mnuSetting = new javax.swing.JMenu();
        mnuitUsers = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        bill = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imagenes/Main.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 110));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(187, 83, 20));
        jLabel2.setText("Panaderia El Trigo de Oro");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 460, 60));

        jInternalFrame1.setBorder(null);
        jInternalFrame1.setForeground(new java.awt.Color(248, 222, 222));
        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(248, 222, 222));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imagenes/fondoMenus.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab6", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab7", jPanel8);

        jInternalFrame1.getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        jMenuBar2.setForeground(new java.awt.Color(248, 222, 222));

        Mnu.setText("Inicio");
        Mnu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                MnuMenuSelected(evt);
            }
        });

        mnuitSignOff.setText("Cerrar Sesion");
        Mnu.add(mnuitSignOff);

        mnuitmExit.setText("Salir del sistema");
        mnuitmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitmExitActionPerformed(evt);
            }
        });
        Mnu.add(mnuitmExit);

        jMenuBar2.add(Mnu);

        mnuProduct.setText("Producto");
        mnuProduct.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuProductMenuSelected(evt);
            }
        });

        mnuAddProducts.setText("Agregar Productos");
        mnuAddProducts.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuAddProductsMenuSelected(evt);
            }
        });
        mnuProduct.add(mnuAddProducts);
        mnuProduct.add(jSeparator1);

        jMenu3.setText("Buscar Producto");
        jMenu3.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu3MenuSelected(evt);
            }
        });

        jMenuItem1.setText("Eliminar Producto");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Actualizar");
        jMenu3.add(jMenuItem2);

        mnuProduct.add(jMenu3);

        jMenuBar2.add(mnuProduct);

        mnuSuppliers.setText("Proveedor");
        mnuSuppliers.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuSuppliersMenuSelected(evt);
            }
        });

        mnuAddSuppliers.setText("Agregar Proveedor");
        mnuAddSuppliers.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuAddSuppliersMenuSelected(evt);
            }
        });
        mnuSuppliers.add(mnuAddSuppliers);

        mnuCosultSuppliers.setText("Consultar Proveedor");
        mnuCosultSuppliers.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuCosultSuppliersMenuSelected(evt);
            }
        });
        mnuSuppliers.add(mnuCosultSuppliers);

        jMenuBar2.add(mnuSuppliers);

        mnuMakeOrder.setText("Crear Orden");
        mnuMakeOrder.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuMakeOrderMenuSelected(evt);
            }
        });

        itmMakePurchaseOrderToSupplier.setText("Realizar Orden de Compra a Proveedor");
        itmMakePurchaseOrderToSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmMakePurchaseOrderToSupplierMouseClicked(evt);
            }
        });

        jMenuItem6.setText("Imprimir Orden");
        itmMakePurchaseOrderToSupplier.add(jMenuItem6);

        jMenuItem7.setText("Guardar Orden");
        itmMakePurchaseOrderToSupplier.add(jMenuItem7);

        jMenuItem8.setText("Borrar Campos");
        itmMakePurchaseOrderToSupplier.add(jMenuItem8);

        mnuMakeOrder.add(itmMakePurchaseOrderToSupplier);

        itmMakeBillToConsumer.setText("Realizar Factura a Consumidor");
        itmMakeBillToConsumer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmMakeBillToConsumerMouseClicked(evt);
            }
        });

        jMenuItem9.setText("Imprimir Orden");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem9MouseClicked(evt);
            }
        });
        itmMakeBillToConsumer.add(jMenuItem9);

        jMenuItem10.setText("Guardar Orden");
        itmMakeBillToConsumer.add(jMenuItem10);

        jMenuItem11.setText("Borrar Campos");
        itmMakeBillToConsumer.add(jMenuItem11);

        mnuMakeOrder.add(itmMakeBillToConsumer);
        mnuMakeOrder.add(jSeparator2);

        jMenu5.setText("Consultar");

        jMenuItem4.setText("Orden de Compras");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Facturas");
        jMenu5.add(jMenuItem5);

        mnuMakeOrder.add(jMenu5);

        jMenuBar2.add(mnuMakeOrder);

        mnuBill.setText("Facturas");
        mnuBill.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuBillMenuSelected(evt);
            }
        });

        jMenu7.setText("Proveedores");
        mnuBill.add(jMenu7);

        jMenu8.setText("Clientes");
        mnuBill.add(jMenu8);

        jMenuBar2.add(mnuBill);

        mnuSetting.setText("Configuracion");
        mnuSetting.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnuSettingMenuSelected(evt);
            }
        });

        mnuitUsers.setText("Sobre");
        mnuSetting.add(mnuitUsers);

        jMenu2.setText("Usuario");

        jMenuItem3.setText("Ingresar usuario");
        jMenu2.add(jMenuItem3);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Eliminar usuarios");
        jMenu2.add(jCheckBoxMenuItem1);

        mnuSetting.add(jMenu2);

        jMenuBar2.add(mnuSetting);

        jInternalFrame1.setJMenuBar(jMenuBar2);

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 780, 460));

        bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imagenes/fondoMenu1.png"))); // NOI18N
        getContentPane().add(bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));
        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuitmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitmExitActionPerformed
        cerrar();
    }//GEN-LAST:event_mnuitmExitActionPerformed

    private void itmMakePurchaseOrderToSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmMakePurchaseOrderToSupplierMouseClicked
        showFrmBillMake();

    }//GEN-LAST:event_itmMakePurchaseOrderToSupplierMouseClicked

    private void itmMakeBillToConsumerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmMakeBillToConsumerMouseClicked
        showFrmBillMenu();
    }//GEN-LAST:event_itmMakeBillToConsumerMouseClicked

    private void mnuAddSuppliersMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuAddSuppliersMenuSelected
        showFrmAddSupplier();
    }//GEN-LAST:event_mnuAddSuppliersMenuSelected

    private void mnuCosultSuppliersMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuCosultSuppliersMenuSelected
        if (jTabbedPane1.getSelectedComponent() == jPanel6) {
            jTabbedPane1.setSelectedComponent(jPanel2);
        } else {
            FrmSearchSupplier bill = new FrmSearchSupplier();
            jPanel6.add( bill.getContentPane());
            bill.setVisible(false);
            jTabbedPane1.setSelectedComponent(jPanel6);
        }
    }//GEN-LAST:event_mnuCosultSuppliersMenuSelected

    private void mnuAddProductsMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuAddProductsMenuSelected
        if (jTabbedPane1.getSelectedComponent() == jPanel7) {
            jTabbedPane1.setSelectedComponent(jPanel2);
        } else {
            FrmAddNewProduct bill = new FrmAddNewProduct();
            jPanel7.add( bill.getContentPane());
            bill.setVisible(false);
            jTabbedPane1.setSelectedComponent(jPanel7);
        }
    }//GEN-LAST:event_mnuAddProductsMenuSelected

    private void jMenu3MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu3MenuSelected
        if (jTabbedPane1.getSelectedComponent() == jPanel8) {
            jTabbedPane1.setSelectedComponent(jPanel2);
        } else {
            FrmConsultProduct bill = new FrmConsultProduct();
            jPanel8.add( bill.getContentPane());
            bill.setVisible(false);
            jTabbedPane1.setSelectedComponent(jPanel8);
        }
    }//GEN-LAST:event_jMenu3MenuSelected

    private void mnuMakeOrderMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuMakeOrderMenuSelected
        jTabbedPane1.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_mnuMakeOrderMenuSelected

    private void mnuSuppliersMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuSuppliersMenuSelected
        jTabbedPane1.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_mnuSuppliersMenuSelected

    private void mnuProductMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuProductMenuSelected
        jTabbedPane1.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_mnuProductMenuSelected

    private void MnuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_MnuMenuSelected
        jTabbedPane1.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_MnuMenuSelected

    private void mnuBillMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuBillMenuSelected
        jTabbedPane1.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_mnuBillMenuSelected

    private void mnuSettingMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnuSettingMenuSelected
        jTabbedPane1.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_mnuSettingMenuSelected

    private void jMenuItem9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MouseClicked
        
    }//GEN-LAST:event_jMenuItem9MouseClicked

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
    private javax.swing.JMenu Mnu;
    private javax.swing.JLabel bill;
    private javax.swing.JMenu itmMakeBillToConsumer;
    private javax.swing.JMenu itmMakePurchaseOrderToSupplier;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu mnuAddProducts;
    private javax.swing.JMenu mnuAddSuppliers;
    private javax.swing.JMenu mnuBill;
    private javax.swing.JMenu mnuCosultSuppliers;
    private javax.swing.JMenu mnuMakeOrder;
    private javax.swing.JMenu mnuProduct;
    private javax.swing.JMenu mnuSetting;
    private javax.swing.JMenu mnuSuppliers;
    private javax.swing.JMenuItem mnuitSignOff;
    private javax.swing.JMenuItem mnuitUsers;
    private javax.swing.JMenuItem mnuitmExit;
    // End of variables declaration//GEN-END:variables
}