package ec.edu.espe.utils;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.JOptionPane;

/**
 *
 * @author David Pilaguano, Lenovo , DCCO-ESPE
 */
public class SupplierDatabase {
    private MongoDatabase database;
    
        public SupplierDatabase(MongoDatabase database) {
        this.database = database;
    }
            
     public void saveSupplier(String supplierName, String cellPhone, String address, String homePhone, String ruc, String email) {
        if (database == null) {
            JOptionPane.showMessageDialog(null, "Base de datos no inicializada.");
            return;
        }

        MongoCollection<Document> collection = database.getCollection("Suppliers");
        Document document = new Document("Proveedor Nombre", supplierName)
                .append("Telefono", cellPhone)
                .append("Direccion", address)
                .append("Convencional",homePhone)
                .append("RUC", ruc)
                .append("email", email);

        try {
            collection.insertOne(document);
            JOptionPane.showMessageDialog(null, "Producto guardado con éxito.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + e.getMessage());
        }
    }
}
