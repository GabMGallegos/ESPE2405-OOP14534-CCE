package ec.edu.espe.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.systembakery.model.Consumer;
import ec.edu.espe.systembakery.model.KindOfPayment;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author CodeCrafting Engineers
 */
public class Methods {

    public static void addElemenToTable(MongoCollection collection, String firstPartCmbProductId,
            JTextField txtProductAmount, DefaultTableModel dtmProductList) {
        float totalPrice;
        String[] productPurchaseList = new String[5];
        MongoCursor<Document> cursor = collection.find().iterator();
        
        try {

            while (cursor.hasNext()) {
                Document document = cursor.next();
                String namedItem = document.get("Id", firstPartCmbProductId);

                if (firstPartCmbProductId.equals(namedItem)) {
                    productPurchaseList[0] = document.getString("Id");
                    productPurchaseList[1] = document.getString("Nombre");
                    productPurchaseList[2] = txtProductAmount.getText().trim();
                    productPurchaseList[3] = document.getString("Precio U.");
                    totalPrice = Math.round( (Float.parseFloat(productPurchaseList[2]) 
                            * Float.parseFloat(productPurchaseList[3])) * 100)/100f;
                    productPurchaseList[4] = String.format(Locale.US,"%.2f",totalPrice);

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

    public static void insertItemsComboBox(MongoCollection collection, String item, JComboBox cmbBox) {
        ArrayList<String> list;
        list = BsonDownloadDocument.getListItem(collection, item);

        for (String itemList : list) {
            cmbBox.addItem(itemList);
        }
    }

    public static void insertItemsComboBox(MongoCollection collection, String itemId, String itemName, JComboBox cmbBox) {
        ArrayList<String> listId, listName, listIdAndName;
        listId = BsonDownloadDocument.getListItem(collection, itemId);
        listName = BsonDownloadDocument.getListItem(collection, itemName);
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
    
    public static Consumer getConsumer(String  consumerName, MongoCollection collection){
        Consumer consumer = new Consumer();
        MongoCursor<Document> cursor = collection.find().iterator();
        
        try {

            while (cursor.hasNext()) {
                Document document = cursor.next();
                String namedItem = document.get("Nombre",consumerName);

                if (consumerName.equals(namedItem)) {
                    consumer.setcI(document.getString("CI"));
                    consumer.setBillsId(new ArrayList<>(document.getList("Facturas", String.class)));
                    consumer.setConsumerName(document.getString("Nombre"));
                    consumer.setPaymentType(KindOfPayment.PaymentType.CASH);
                    return consumer;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener al consumidor");
        } finally {
            cursor.close();
        }
        return null;
    }

}
