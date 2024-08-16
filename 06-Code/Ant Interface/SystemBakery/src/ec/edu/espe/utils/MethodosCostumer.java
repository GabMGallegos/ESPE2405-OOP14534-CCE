/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.utils;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.systembakery.model.Costumer;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Filters;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

/**
 *
 * @author leydi
 */
public class MethodosCostumer implements ICostumer {

    Conection conn = new Conection();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;
    private SecretKey secretKey;

    public MethodosCostumer() throws Exception {
        if (conn != null) {
            this.conn = conn.createConection();
            this.database = conn.getMongoDatabase();
            this.coleccion = database.getCollection("Costumer");
        }
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE);
        this.secretKey = keyGen.generateKey();

    }

    private void closeConnection() {
        try {
            conn.getMongoClient().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.toString());
        }
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decrypted);
    }

    @Override
    public boolean GetIntroCostumer(Costumer costumer) {
        Document documento;
        try {
            documento = new Document("user", costumer.getUser())
                    .append("password", costumer.getPassword());

            coleccion.insertOne(documento);
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error when entering data: " + ex.toString());
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public boolean verifyCostumer(Costumer costumer) {
        try {
            // Encriptar user y password para la verificación
            String encryptedUser = encrypt(costumer.getUser());
            String encryptedPassword = encrypt(costumer.getPassword());

            // Buscar un documento que coincida con el usuario encriptado
            Bson filter = Filters.and(Filters.eq("user", encryptedUser), Filters.eq("password", encryptedPassword));
            Document found = coleccion.find(filter).first();

            // Si se encuentra el documento, los valores coinciden
            return found != null;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error in MongoDB operation: " + ex.toString());
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error verifying data: " + ex.toString());
            return false;
        } finally {
            closeConnection();
        }
    }
}
