package ec.edu.espe.SystemForBakery.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.SystemForBakery.model.Supplier;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ec.edu.espe.SystemForBakery.utils.FileManager;
import ec.edu.espe.SystemForBakery.utils.JsonGenerator;
import ec.edu.espe.SystemForBakery.utils.LocalDateAdapter;
import ec.edu.espe.SystemForBakery.utils.LocalDateTimeAdapter;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class SupplierMenu {

    Scanner scanner = new Scanner(System.in);

    public void displaySupplierMenu() {
        List<Supplier> suppliers = new ArrayList<>();
        int option = 0;
        Supplier supplier = new Supplier();
        while (true) {
            try {
                System.out.println("--------Option ----------");
                System.out.println("1. New Supplier");
                System.out.println("2. Delete Supplier");
                System.out.println("3. Search Supplier");
                System.out.println("4. View Suppliers");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter the option you want to view: ");
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            manageSuppliers(scanner, suppliers);
                            break;
                        case 2:
                            // Delete supplier logic here
                            break;
                        case 3:
                            // Search supplier logic here
                            break;
                        case 4:
                            viewSuppliers("supplier.json");
                            break;
                        case 5:
                            return;
                        default:
                            System.out.println("Invalid option, please enter again: ");
                            break;
                    }
                } else {
                    String input = scanner.nextLine();
                    System.out.println("Error: The input '" + input + "' is not a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: The input must be a valid number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void manageSuppliers(Scanner scanner, List<Supplier> suppliers) {
        System.out.print("Enter the supplier ID: ");
        int supplierId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of the supplier company:");
        String supplierName = scanner.nextLine();
        System.out.println("Enter the supplier contact:");
        String numberContact = scanner.nextLine();

        Supplier supplier = new Supplier(supplierId, supplierName, numberContact);
        suppliers.add(supplier);
        FileManager.saveSupplierToCSV(supplier);

        try {
            JsonGenerator.generateSupplierJson(suppliers);
            System.out.println("Supplier added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding supplier: " + e.getMessage());
        }
    }

    public static void viewSuppliers(String jsonFile) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        try (FileReader reader = new FileReader(jsonFile)) {
            Type supplierListType = new TypeToken<List<Supplier>>() {
            }.getType();
            List<Supplier> suppliers = gson.fromJson(reader, supplierListType);

            if (suppliers == null || suppliers.isEmpty()) {
                System.out.println("No suppliers available.");
            } else {
                System.out.println("--- List of Suppliers ---");
                for (Supplier supplier : suppliers) {
                    System.out.println(supplier);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
