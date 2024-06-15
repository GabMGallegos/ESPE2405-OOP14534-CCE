package ec.edu.espe.SystemForBakery.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Supplier {

    private String supplierName;
    private String numberContact;
    //agregar fecha de entrega del producto

    Scanner scanner = new Scanner(System.in);

    public static void manageSuppliers(Scanner scanner, List<Supplier> suppliers) {
        System.out.println("Enter the name of the supplier company");
        String supplierName = scanner.nextLine();
        System.out.println("Enter the supplier contact");
        String numberContact = scanner.nextLine();

        Supplier supplier = new Supplier(supplierName, numberContact);
        suppliers.add(supplier);
        FileManager.saveSupplierToCSV(supplier);
        System.out.println("Supplier added successfully!");
    }

    public static void viewSuppliers(String jsonFile) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        try (FileReader reader = new FileReader(jsonFile)) {
            Supplier[] suppliersArray = gson.fromJson(reader, Supplier[].class);
            List<Supplier> suppliers = Arrays.asList(suppliersArray);

            if (suppliers.isEmpty()) {
                System.out.println("No hay proveedores disponibles.");
            } else {
                System.out.println("--- List of Suppliers ---");
                for (Supplier supplier : suppliers) {
                    System.out.println(supplier);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }

    
    }

    public Supplier() {
    }
    

    public Supplier(String supplierName, String numberContact) {

        this.supplierName = supplierName;
        this.numberContact = numberContact;
    }

    @Override
    public String toString() {
        return "Supplier{"
                + "supplierName='" + supplierName + '\''
                + ", numberContact='" + numberContact + '\''
                + '}';
    }

    public String toCSV() {
        return supplierName + "," + numberContact;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        if (supplierName == null || supplierName.isEmpty()) {
            throw new IllegalArgumentException("Provider name cannot be null or empty");
        }
        this.supplierName = supplierName;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        if (numberContact == null || numberContact.isEmpty()) {
            throw new IllegalArgumentException("Contact number cannot be null or empty");
        }
        this.numberContact = numberContact;
    }
}
