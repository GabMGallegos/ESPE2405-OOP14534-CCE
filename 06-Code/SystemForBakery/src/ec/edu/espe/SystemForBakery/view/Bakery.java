package ec.edu.espe.SystemForBakery.view;

import ec.edu.espe.SystemForBakery.model.Bills;
import ec.edu.espe.SystemForBakery.model.Consumer;
import ec.edu.espe.SystemForBakery.model.KindOfPayment;
import ec.edu.espe.SystemForBakery.model.Supplier;
import ec.edu.espe.SystemForBakery.model.SystemProfile;
import ec.edu.espe.SystemForBakery.model.Product;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import utils.FileManager;




public class Bakery{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
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
                    manageProduct(scanner, products);
                    break;
                case 2:
                    manageSuppliers(scanner, suppliers);
                    
                    break;
                case 3:
                    manageoutputproducts(products);
                    break;
                case 4:
                    createOrder(scanner, products);
                    break;
                case 5:
                    System.out.println("Leaving the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("¡¡Invalid option. Try again.!!");
            }
        }
    }
    
    private static void manageProduct (Scanner scanner,List<Product> products){
        System.out.println("Enter the product Id");
        int idProduct =scanner.nextInt();
        System.out.println("Enter the name");
        String name = scanner.next();
        System.out.println("Enter the price");
        double price = scanner.nextDouble();
        System.out.println("Enter the amount");
        int amount = scanner.nextInt();
        LocalDate date = LocalDate.now();
        
        System.out.println("Enter file type to save (csv/txt): ");
        String fileType = scanner.next().toLowerCase();
        
        Product product = new Product(idProduct, name, price, amount, date);
        products.add(product);
        FileManager.saveProductToCSV(product);
        
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
    
    private static void manageoutputproducts(List<Product> products){
        System.out.println("\nList of products:");
        for (Product product: products){
            System.out.println(product);
        }
    }
    
    private static void createOrder(Scanner scanner, List<Product> products) {
        Bills bill = null;
        
        System.out.print("Invoice client, consumer: (F/C)");
        String consumerName = scanner.nextLine();
        Consumer consumer;
        
        if (consumerName.equalsIgnoreCase("f")) {
            System.out.print("Enter customer name:");
            String customerName = scanner.nextLine();
            System.out.print("Enter customer contact: ");
            String contact = scanner.nextLine();
            consumer= new Consumer(consumerName, 0, bill);
        } else {
            consumer= new Consumer(consumerName, 0, bill);
        }

        System.out.print("Enter the payment type (Cash/Transfer):  ");
        String paymentType = scanner.nextLine();
        KindOfPayment payment = new KindOfPayment(paymentType);

        List<Product> orderProducts = new ArrayList<>();
        double totalOrderPrice = 0;

        while (true) {
            System.out.print("Enter the product ID ");
            int productId = scanner.nextInt();
            System.out.print("Enter the amount: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            Product product = products.stream()
                                      .filter(p -> p.getProductId()== productId)
                                      .findFirst()
                                      .orElse(null);

            if (product == null) {
                System.out.println("Product not found. Try again.");
                continue;
            }

            double totalPrice = product.getPrice() * quantity;
            for (int i = 0; i < quantity; i++) {
                orderProducts.add(product);
            }
            totalOrderPrice += totalPrice;

            System.out.print(" Do you want to add another product to the order? (y/n):");
            String addMore = scanner.nextLine();
            if (!addMore.equalsIgnoreCase("s")) {
                break;
            }
        }

        int billNumber = (int) (Math.random() * 10000); // Número de factura aleatorio
        Date date = new Date();
        bill = new Bills(billNumber, totalOrderPrice, consumerName, date);
        for (Product product : orderProducts) {
            bill.addProduct(product);
        }

        consumer = new Consumer(consumerName, totalOrderPrice, bill);
        
                
        FileManager.saveOrderToCSV(bill);

        System.out.println("Orden creada:\n" + consumer);
    }
    
}