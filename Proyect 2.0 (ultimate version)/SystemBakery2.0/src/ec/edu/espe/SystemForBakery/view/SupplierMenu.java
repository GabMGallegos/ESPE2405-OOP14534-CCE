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

    ArrayList<Supplier> suppliers = new ArrayList<>();
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
<<<<<<< HEAD:2.0/SystemBakery2.0/src/ec/edu/espe/SystemForBakery/view/SupplierMenu.java
                            System.out.println("--- Proveedores Disponibles ---");
        
            viewSuppliers("supplier.json");
            deleteSupplier();

                            break;
                        case 3:
                            searchSupplier();

=======
                            // Delete supplier logic here
                            break;
                        case 3:
                            // Search supplier logic here
>>>>>>> 8e543469b9391b3f5f21d85d92d19b5a6dd71f05:Proyect 2.0 (ultimate version)/SystemBakery2.0/src/ec/edu/espe/SystemForBakery/view/SupplierMenu.java
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
<<<<<<< HEAD:2.0/SystemBakery2.0/src/ec/edu/espe/SystemForBakery/view/SupplierMenu.java

        public void searchSupplier() {
        //Scanner scanner = new Scanner(System.in);
try{
        System.out.println("Ingrese el Id: ");
        int idsear = scanner.nextInt();
        scanner.nextLine();
        Supplier supplierToRemove = null;
        
        
            boolean found = false;
        for (Supplier supplier : suppliers) {
            if (supplier.getIdSupplier() == idsear) {
                supplierToRemove = supplier;
            
                System.out.println("Proveedor encontrado:");
                System.out.println(supplier);
                found = true;
                break; 
            }
        }

        if (supplierToRemove != null) {
        suppliers.remove(supplierToRemove);
        System.out.println("Proveedor eliminado correctamente:");
        System.out.println("ID: " + supplierToRemove.getIdSupplier());
        System.out.println("Nombre de la empresa: " + supplierToRemove.getSupplierName());
        System.out.println("Contacto: " + supplierToRemove.getNumberContact());
    } else {
            System.out.println("No se encontró ningún proveedor con ese ID.");
        }
        }catch(InputMismatchException e) {
                System.out.println("Error: La entrada no es un número válido.");
                scanner.nextLine(); 
        }
    }
        
        public void deleteSupplier (){
            System.out.print("Ingrese el ID del proveedor que desea eliminar: ");
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
        System.out.println("Proveedor eliminado correctamente:");
        System.out.println("ID: " + supplierToRemove.getIdSupplier());
        System.out.println("Nombre de la empresa: " + supplierToRemove.getSupplierName());
        System.out.println("Contacto: " + supplierToRemove.getNumberContact());
    } else {
        System.out.println("No se encontró ningún proveedor con ese ID.");
    }

        JsonGenerator.generateSupplierJson(suppliers);
        }
=======
>>>>>>> 8e543469b9391b3f5f21d85d92d19b5a6dd71f05:Proyect 2.0 (ultimate version)/SystemBakery2.0/src/ec/edu/espe/SystemForBakery/view/SupplierMenu.java
}
