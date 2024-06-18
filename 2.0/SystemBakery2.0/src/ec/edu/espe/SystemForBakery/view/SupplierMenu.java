/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import utils.FileManager;
import utils.JsonGenerator;
import utils.LocalDateAdapter;
import utils.LocalDateTimeAdapter;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
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
                System.out.println("1. Nuevo Provedor");
                System.out.println("2. Borrar Provedor");
                System.out.println("3. Buscar Provedor");
                System.out.println("4. Ver Provedores");
                System.out.println("5. Volver al Menu Principal");
                System.out.print("Ingrese la opción que desea visualizar: ");
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            manageSuppliers(scanner, suppliers);
                            break;
                        case 2:
                            System.out.println("--- Proveedores Disponibles ---");
        
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
                            System.out.println("Opción inválida, ingrese de nuevo: ");
                            break;
                    }
                } else {
                    String input = scanner.nextLine();
                    System.out.println("Error: La entrada '" + input + "' no es un número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: La entrada debe ser un número válido.");
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
        System.out.println("Enter the name of the supplier company");
        String supplierName = scanner.nextLine();
        System.out.println("Enter the supplier contact");
        String numberContact = scanner.nextLine();

        Supplier supplier = new Supplier(supplierId, supplierName, numberContact);
        suppliers.add(supplier);
        FileManager.saveSupplierToCSV(supplier);

        try {

            JsonGenerator.generateSupplierJson(suppliers);
            System.out.println("Supplier added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding suppliers: " + e.getMessage());
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
                System.out.println("No hay proveedores disponibles.");
            } else {
                System.out.println("--- List of Suppliers ---");
                for (Supplier supplier : suppliers) {
                    System.out.println(supplier);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

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
}
