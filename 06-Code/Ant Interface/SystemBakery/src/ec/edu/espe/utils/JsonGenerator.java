package ec.edu.espe.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.systembakery.model.Bill;
import ec.edu.espe.systembakery.model.Stock;
import ec.edu.espe.systembakery.model.Supplier;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class JsonGenerator {

    private static final String FILE_BILL = "resources/json/bills.json";
    private static final String FILE_STOCK = "resources/json/stock.json";
    private static final String FILE_SUPPLIER = "supplier.json";

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public static void generateBillJson(Bill bill) {
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
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(FILE_SUPPLIER)) {
            gson.toJson(suppliers, writer);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}
