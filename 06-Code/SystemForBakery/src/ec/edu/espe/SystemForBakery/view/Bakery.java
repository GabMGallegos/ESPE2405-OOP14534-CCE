package ec.edu.espe.SystemForBakery.view;

import ec.edu.espe.SystemForBakery.model.Supplier;
import ec.edu.espe.SystemForBakery.model.SystemProfile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.FileManager;




public class Bakery{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //List<Product> product = new ArrayList<>();
        List<Supplier> suppliers = new ArrayList<>();

        while (true) {
            System.out.println("Team CodeCrafting Engineers");
            System.out.println("1. Product");
            System.out.println("2. Suppliers");
            System.out.println("3. Stock");
            System.out.println("4. Purchase Order ");
            System.out.println("5. Get Out");
            System.out.println("Select an option");
            int option = scanner.nextInt();

            scanner.nextLine();

            switch (option) {
                case 1:

                    break;
                case 2:
                    manageSuppliers(scanner, suppliers);
                    
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Leaving the system...");
                    break;
                default:
                    System.out.println("¡¡Invalid option. Try again.!!");
            }
        }
    }

    private static void manageSuppliers(Scanner scanner, List<Supplier> suppliers) {

        System.out.println("Enter the name of the supplier company");
        String suppliername = scanner.next();
        System.out.println("Enter the supplier contact");
        String numbercontact = scanner.next();
        
        System.out.println("Enter file type to save (csv/txt): ");
        String fileType = scanner.next().toLowerCase();
        
        Supplier supplier = new Supplier(suppliername, numbercontact);
        suppliers.add(supplier);
        FileManager.saveSupplierToCSV(supplier);
        
        
    }
    
}