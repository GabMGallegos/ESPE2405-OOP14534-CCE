
package utils;

import ec.edu.espe.SystemForBakery.model.Bills;
import ec.edu.espe.SystemForBakery.model.Product;
import ec.edu.espe.SystemForBakery.model.Supplier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leydi Oña, Lenovo, DCCO-ESPE
 */
public class FileManager {
    public static void save(String data, String fileName, String type) throws IOException {
        // Verifica que el tipo sea CSV o TXT
        if (!type.equalsIgnoreCase("csv") && !type.equalsIgnoreCase("txt")) {
            throw new IllegalArgumentException("Unsupported file type: " + type);
        }

        // Añade la extensión adecuada al nombre del archivo si no está presente
        if (!fileName.toLowerCase().endsWith("." + type.toLowerCase())) {
            fileName += "." + type.toLowerCase();
        }

        // Usa BufferedWriter para escribir los datos en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine(); // Añade una nueva línea después de escribir los datos
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            throw e;
        }
    }

    public static void saveSupplierToCSV(Supplier supplier) {
        try (FileWriter writer = new FileWriter("providers.csv", true)) {
            writer.append(supplier.toCSV());
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveProductToCSV(Product product) {
        try (FileWriter writer = new FileWriter("products.csv", true)) {
            writer.append(String.format("%d,%s,%.2f,%d,%s\n", 
                                    product.getProductId(), 
                                    product.getName(), 
                                    product.getPrice(), 
                                    product.getAmount(), 
                                    product.getDate()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveOrderToCSV(Bills bill) {
        try (FileWriter writer = new FileWriter("orders.csv", true)) {
            writer.append(bill.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadProductToCSV(List<Product> products) {
        String[] productString;
        
        try (BufferedReader r = new BufferedReader(new FileReader("products.csv"))){
            String line;
            while((line = r.readLine()) != null){
                productString = line.split(",");
                Product product = new Product( Integer.parseInt(productString[0])
                        , productString[1]
                        , Double.parseDouble(productString[2])
                        , Integer.parseInt(productString[3])
                        , LocalDate.parse(productString[4], DateTimeFormatter.ISO_DATE));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

