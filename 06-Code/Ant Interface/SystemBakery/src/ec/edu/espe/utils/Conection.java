/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.utils;

import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;

import javax.swing.JOptionPane;

/**
 *
 * @author CodeCrafting Engineers
 */
public class Conection {

    private String connectionString = "mongodb+srv://julioluis:12345@cluster0.ukucs8a.mongodb.net/";
    private ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
    private MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(connectionString)).serverApi(serverApi).build();
    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;

    public Conection(MongoDatabase mongoDatabase, MongoClient mongoClient) {
        this.mongoDatabase = mongoDatabase;
        this.mongoClient = mongoClient;
    }
    
    public Conection() {
    }
    
    public Conection createConection() {
        try {
            mongoClient = MongoClients.create(settings);
            mongoDatabase = mongoClient.getDatabase("BakeryDB");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error Conection :" + ex.toString());
        }
        return new Conection(mongoDatabase, mongoClient);
    }

    /**
     * @return the mongoDatabase
     */
    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    /**
     * @param mongoDatabase the mongoDatabase to set
     */
    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    /**
     * @return the mongoClient
     */
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    /**
     * @param mongoClient the mongoClient to set
     */
    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
    
}
