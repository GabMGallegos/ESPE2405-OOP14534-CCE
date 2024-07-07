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
import ec.edu.espe.SystemForBakery.utils.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class SupplierMenu {

    List<Supplier> suppliers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private static Set<Integer> existingSupplierIds = new HashSet<>();

    public void displaySupplierMenu() {

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

                            viewSuppliers("supplier.json");
                            deleteSupplier();
                            break;
                        case 3:

                            searchSupplier();
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

        if (existingSupplierIds.contains(supplierId)) {
            System.out.println("Error: Supplier ID already exists. Please enter a unique ID.");
            return; // Salir del método si el ID ya existe
        }

        System.out.println("Enter the name of the supplier company:");
        String supplierName = scanner.nextLine();
        System.out.println("Enter the supplier contact:");
        String numberContact = scanner.nextLine();

        Supplier supplier = new Supplier(supplierId, supplierName, numberContact);
        suppliers.add(supplier);
        existingSupplierIds.add(supplierId);
        FileManager.saveSupplierToCSV(supplier);
        saveSupplierIdToFile(supplierId);


        try {
            JsonGenerator.generateSupplierJson(suppliers);
            System.out.println("Supplier added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding supplier: " + e.getMessage());
        }
    }

    private static void saveSupplierIdToFile(int supplierId) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("supplier.json", true))) {
            writer.write(Integer.toString(supplierId));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Could not save supplier ID: " + e.getMessage());
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

    public void searchSupplier() {
        try {
            System.out.println("Enter the supplier ID: ");
            int idSearch = scanner.nextInt();
            scanner.nextLine();

            Supplier supplierToRemove = null;
            boolean found = false;

            for (Supplier supplier : suppliers) {
                if (supplier.getIdSupplier() == idSearch) {
                    supplierToRemove = supplier;
                    System.out.println("Supplier found:");
                    System.out.println(supplier);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No supplier found with that ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: The input is not a valid number.");
            scanner.nextLine();
        }
    }

    public void deleteSupplier() {
        System.out.print("Enter the ID of the supplier you want to delete: ");
        int idDelete = scanner.nextInt();
        scanner.nextLine();
        Supplier supplierToRemove = null;

        for (Supplier supplier : suppliers) {
            if (supplier.getIdSupplier() == idDelete) {
                supplierToRemove = supplier;
                break;
            }
        }

        if (supplierToRemove != null) {
            suppliers.remove(supplierToRemove);
            System.out.println("Supplier deleted successfully:");
            System.out.println("ID: " + supplierToRemove.getIdSupplier());
            System.out.println("Company Name: " + supplierToRemove.getSupplierName());
            System.out.println("Contact: " + supplierToRemove.getNumberContact());
            JsonGenerator.generateSupplierJson(suppliers);
        } else {
            System.out.println("No supplier found with that ID.");
        }
    }
}
