
package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Leydi Oña, Lenovo, DCCO-ESPE
 */
public class FileManage {
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

    public static void main(String[] args) {
        // Prueba del método genérico de guardado
        String data = "1,Leydi,Cajera";
        String fileName = "profile";
        
        try {
            // Guardar como CSV
            save(data, fileName, "csv");
            System.out.println("Data saved successfully as CSV.");
            
            // Guardar como TXT
            save(data, fileName, "txt");
            System.out.println("Data saved successfully as TXT.");
        } catch (IOException e) {
            System.err.println("An error occurred while saving the data: " + e.getMessage());
        }
    }
}

