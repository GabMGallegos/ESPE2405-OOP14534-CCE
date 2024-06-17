/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.SystemForBakery.model.Bills;
import ec.edu.espe.SystemForBakery.model.Stock;
import ec.edu.espe.SystemForBakery.model.Supplier;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class JsonGenerator {
    
    private static final String FILE_BILL = "bills.json";
    private static final String FILE_STOCK = "stock.json";
    private static final String FILE_SUPPLIER = "supplier.json";

    private static final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
        .create();

    public static void generateBillJson(Bills bill) {
        try (FileWriter writer = new FileWriter(FILE_BILL)) {
            gson.toJson(bill, writer);
            System.out.println("Archivo JSON generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo JSON: " + e.getMessage());
        }
    }

    public static void generateStockJson(Stock stock) {
        try (FileWriter writer = new FileWriter(FILE_STOCK)) {
            gson.toJson(stock, writer);
            System.out.println("Archivo JSON generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo JSON: " + e.getMessage());
        }
    }
    
    public static void generateSupplierJson(List<Supplier> suppliers) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter("supplier.json")) {
            gson.toJson(suppliers, writer);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }
    
}
