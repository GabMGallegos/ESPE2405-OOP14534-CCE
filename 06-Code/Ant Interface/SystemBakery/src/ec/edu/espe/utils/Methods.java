package ec.edu.espe.utils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Sorts.descending;
import ec.edu.espe.systembakery.model.Consumer;
import ec.edu.espe.systembakery.model.KindOfPayment;
import ec.edu.espe.systembakery.model.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public static Product addElemenToTable(MongoCollection collection, String firstPartCmbProductId,
            JTextField txtProductAmount, DefaultTableModel dtmProductList) {
        float totalPrice;
        Product product = new Product();
        String[] productPurchaseList = new String[5];
        MongoCursor<Document> cursor = collection.find().iterator();
        BigDecimal price;
        LocalDate date = LocalDate.now();
        
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
                    
                    product.setId(Integer.parseInt(productPurchaseList[0]));
                    product.setName(productPurchaseList[1]);
                    product.setAmount(Integer.parseInt(productPurchaseList[2]));
                    product.setPrice(price = new BigDecimal(productPurchaseList[3]));
                    product.setDate(date);
                    
                    dtmProductList.addRow(productPurchaseList);
                    return product;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al subir tabla");
        } finally {
            cursor.close();
            return product;
        }
    }
    
    public static String getNextBillId(MongoDatabase database){
        MongoCollection collection = BsonDownloadDocument.getCollection(database, "Bills");
        FindIterable<Document> iterable = collection.find().sort(descending("id")).limit(1);
        Document lastDocument = iterable.first();
        
        if (lastDocument != null) {
            String id = lastDocument.getString("id");
            int idNumber = Integer.parseInt(id.split("-")[2]);
            int nextId = idNumber + 1;
            int idDigits = String.valueOf(Math.abs(nextId)).length();
            id = id.substring(0, id.length() - idDigits);
            id = id + nextId;
            return id;
        } else {
            return "000-000-000000001";
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
