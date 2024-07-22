package ec.edu.espe.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author CodeCrafting Engineers
 */
public class BsonMethods {

    public static void addElemenToTable(MongoDatabase database, MongoCollection collection, String firstPartCmbProductId, JTextField txtProductAmount, String[] productPurchaseList, DefaultTableModel dtmProductList) {
        collection = database.getCollection("Products");
        MongoCursor<Document> cursor = collection.find().iterator();

        try {

            while (cursor.hasNext()) {
                Document document = cursor.next();
                String namedItem = document.get("Id", firstPartCmbProductId);

                if (firstPartCmbProductId.equals(namedItem)) {
                    productPurchaseList[0] = document.getString("Id");
                    productPurchaseList[1] = document.getString("Nombre");
                    productPurchaseList[2] = txtProductAmount.getText().trim();
                    //add method to rest in the MongoDB document
                    productPurchaseList[3] = document.getString("Precio U.");
                    productPurchaseList[4] = "4";//realizar calculo para el total

                    dtmProductList.addRow(productPurchaseList);

                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al subir tabla");
        } finally {
            cursor.close();
        }
    }

    public static void ComboBoxInsertItemsPeople(String collectionName, String item, JComboBox cmbBox, MongoDatabase database) {
        ArrayList<String> list;
        list = BsonDownloadDocument.ObtainListItem(database.getCollection(collectionName), item);

        for (String itemList : list) {
            cmbBox.addItem(itemList);
        }
    }

    public static void ComboBoxInsertItemsProducts(String collectionName, String itemId, String itemName, JComboBox cmbBox, MongoDatabase database) {
        ArrayList<String> listId, listName, listIdAndName;
        listId = BsonDownloadDocument.ObtainListItem(database.getCollection(collectionName), itemId);
        listName = BsonDownloadDocument.ObtainListItem(database.getCollection(collectionName), itemName);
        listIdAndName = JoinLists(listId, listName);

        for (String itemList : listIdAndName) {

            cmbBox.addItem(itemList);
        }
    }

    public static ArrayList<String> JoinLists(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> newList = new ArrayList<>();
        int count = list1.size();
        for (int i = 0; i < count; i++) {
            newList.add(i, list1.get(i).toString() + " --> " + list2.get(i).toString());
        }
        return newList;
    }

}
