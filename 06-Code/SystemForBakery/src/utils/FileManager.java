
package utils;

import ec.edu.espe.SystemForBakery.model.Product;
import ec.edu.espe.SystemForBakery.model.Supplier;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    private static void saveProductToCSV(Product product) {
        try (FileWriter writer = new FileWriter("products.csv", true)) {
            writer.append(product.toCSV());
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

