package ec.edu.espe.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.JOptionPane;
import java.util.Date;
import ec.edu.espe.utils.FieldCleaner;

/**
 *
 * @author David Pilaguano, Lenovo , DCCO-ESPE
 */

public class ProductDatabase {
    private MongoDatabase database;
    
    public ProductDatabase(MongoDatabase database) {
        this.database = database;
        this.fieldCleaner = new FieldCleaner();
    }
    
    private FieldCleaner fieldCleaner;
    
    public void saveProduct(String supplier, String existenceProduct, String productName, 
                            Date incomeDate, String stockQuantity,  
                            Date dateOutput) {
        if (database == null) {
            JOptionPane.showMessageDialog(null, "Base de datos no inicializada.");
            return;
        }

        MongoCollection<Document> collection = database.getCollection("Products");
        Document document = new Document("Proveedor", supplier)
                .append("Existencias", existenceProduct)
                .append("Nombre Producto", productName)
                .append("Fecha Ingreso", incomeDate)
                .append("Cantidad en Stock", stockQuantity)
                .append("Fecha de Salida", dateOutput);

        try {
            int existenceInt = Integer.parseInt(existenceProduct);
            collection.insertOne(document);
            JOptionPane.showMessageDialog(null, "Producto guardado con éxito.");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese solo enteros en el campo de existencias.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + e.getMessage());
        }
    }
}