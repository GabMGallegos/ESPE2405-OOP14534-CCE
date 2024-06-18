package ec.edu.espe.SystemForBakery.utils;

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
 * @autor CODE_CRAFTING_ENGINEERS
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
        try (FileWriter writer = new FileWriter(FILE_BILL, true)) { // Append mode
            gson.toJson(bill, writer);
            System.out.println("JSON file generated successfully.");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public static void generateStockJson(Stock stock) {
        try (FileWriter writer = new FileWriter(FILE_STOCK)) {
            gson.toJson(stock, writer);
            System.out.println("JSON file generated successfully.");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public static void generateSupplierJson(List<Supplier> suppliers) {
        try (FileWriter writer = new FileWriter(FILE_SUPPLIER)) {
            gson.toJson(suppliers, writer);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}
