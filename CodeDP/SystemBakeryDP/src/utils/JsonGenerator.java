package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.SystemForBakery.model.Bills;
import ec.edu.espe.SystemForBakery.model.Product;
import ec.edu.espe.SystemForBakery.model.Stock;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class JsonGenerator {
    
    private static final String FILE_BILL = "bills.json";
    private static final String FILE_STOCK = "stock.json";
    
    public static void generateBillJson(Bills bill) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_BILL)) {
            gson.toJson(bill, writer);
            System.out.println("Archivo JSON generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo JSON: " + e.getMessage());
        }
    }
    
    
    
    public static void generateStockJson(Stock stock) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_STOCK)) {
            gson.toJson(stock, writer);
            System.out.println("Archivo JSON generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo JSON: " + e.getMessage());
        }
    }

    public static void generateProductJson(Product product) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
         try (FileWriter writer = new FileWriter(FILE_STOCK)) {
            gson.toJson(product, writer);
            System.out.println("Archivo JSON generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo JSON: " + e.getMessage());
        }   
    }

