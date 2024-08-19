package ec.edu.espe.utils;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author David Pilaguano, Lenovo , DCCO-ESPE
 */
   
public class FieldCleaner {

    public void clearFields(JTextField productNameField, JTextField existenceProductField, JTextField stockQuantityField, JTextField supplierField, JDateChooser incomeDateChooser, JDateChooser dateOutputChooser, String stockQuantity, String supplier) {
        
        // Limpiar los campos de texto
        productNameField.setText("");
        existenceProductField.setText("");
        stockQuantityField.setText("");
        supplierField.setText("");
        
        // Limpiar los campos de fecha
        incomeDateChooser.setDate(null);
        dateOutputChooser.setDate(null);
    }
}

