/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.utils;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.systembakery.model.Costumer;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author leydi
 */
public class MethodosCostumer implements ICostumer{
    
    Conection conn = new Conection();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;
    private MongoCollection<Document> coleccion2;

    public MethodosCostumer() {
        if (conn != null) {
            this.conn = conn.createConection();
            this.database = conn.getMongoDatabase();
            this.coleccion = database.getCollection("Costumer");
        }
    }

    private void closeConnection() {
        try {
            conn.getMongoClient().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.toString());
        }
    }
    public String encryptSHA256(String cadena) {
        String encriptacion = "";
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha.digest(cadena.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            encriptacion = hexString.toString();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error when encrypting");
        }
        return encriptacion;
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
}
