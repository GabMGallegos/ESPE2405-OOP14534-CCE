
package ec.edu.espe.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author  CodeCrafting Engineers
 */
public class BsonDownloadDocument {
    
    
    
    
    public static ArrayList ObtainListItem(MongoCollection collection,String findItem){
        ArrayList items;
        items = new ArrayList();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {                
                Document document = cursor.next();
                String namedItem = document.getString(findItem);
                
                if (namedItem != null) {
                    items.add(namedItem);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la Lista", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            cursor.close();
        }
        return items;
    }
    
}
