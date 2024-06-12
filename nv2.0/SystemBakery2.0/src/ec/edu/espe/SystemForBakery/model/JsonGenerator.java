/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.SystemForBakery.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class JsonGenerator {
    private static final String FILE_NAME = "facturas.json";
    public static void generateJson(Stock stock) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(stock, writer);
            System.out.println("Archivo JSON generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo JSON: " + e.getMessage());
        }
    }
}
