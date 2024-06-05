
package ec.edu.espe.SystemForBakery.controller;
import ec.edu.espe.SystemForBakery.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class SaveiFle {
    
    public static Set<Integer> loadChickenIdsFromFile(String filename) throws IOException {
        Set<Integer> chickenIds = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID: ")) {
                    int id = Integer.parseInt(line.substring(4));
                    chickenIds.add(id);
                }
            }
        }
        return chickenIds;
    }
    
    public static void saveChickenToFile(Chicken chicken, String filename) throws IOException {
        Set<Integer> chickenIds = loadChickenIdsFromFile(filename);
        if (chickenIds.contains(chicken.getId())) {
            System.out.println("Chicken with ID " + chicken.getId() + " already exists. Skipping.");
            return;
        }

        try (FileWriter writer = new FileWriter(filename,true)) {
          writer.write("ID: " + chicken.getId() + "\n");
          writer.write("Name: " + chicken.getName() + "\n");
          writer.write("Color: " + chicken.getColor() + "\n");
          writer.write("Age: " + chicken.getAge() + "\n");
          writer.write("Molting: " + chicken.isMolting() + "\n");
          writer.write("Born on Date: " + chicken.getBornOnDate() + "\n");
          writer.write("\n");
        }
    }
}
