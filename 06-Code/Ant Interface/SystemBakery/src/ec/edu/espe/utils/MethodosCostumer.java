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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
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
        String hashedPassword = hashPassword(costumer.getPassword());
        Bson filter = Filters.eq("user", costumer.getUser());
        Document found = coleccion.find(filter).first();

        if (found != null) {
            String storedPassword = found.getString("password");
            System.out.println("Stored Password: " + storedPassword);

            // Compare both hashes
            if (hashedPassword.equals(storedPassword)) {
                return true; 
            } else {
                System.out.println("Passwords do not match.");
                return false; 
            }
        } else {
            System.out.println("User not found.");
            return false; 
        }

    } catch (MongoException ex) {
        JOptionPane.showMessageDialog(null, "Error in MongoDB operation: " + ex.toString());
        return false;
    } finally {
        closeConnection();
    }
        }
}
