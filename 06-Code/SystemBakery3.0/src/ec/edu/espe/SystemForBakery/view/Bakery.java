package ec.edu.espe.SystemForBakery.view;

import ec.edu.espe.SystemForBakery.utils.LocalDateAdapter;
import ec.edu.espe.SystemForBakery.utils.LocalDateTimeAdapter;
import ec.edu.espe.SystemForBakery.utils.SystemProfile;
import ec.edu.espe.SystemForBakery.utils.FileManager;
import ec.edu.espe.SystemForBakery.utils.JsonGenerator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.SystemForBakery.model.*;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public class Bakery {
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        Stock stock = new Stock();
        List<Supplier> suppliers = new ArrayList<>();

        FileManager.loadProductToCSV(stock.getProducts());

        SystemProfile profile = new SystemProfile();
        profile.login();

        int option = 0;

        while (true) {
            try {
                System.out.println("-------Main Menu------");
                System.out.println("1. Product");
                System.out.println("2. Suppliers");
                System.out.println("3. Stock");
                System.out.println("4. Purchase Order ");
                System.out.println("5. Bills");
                System.out.println("6. Exit");
                System.out.println("Select an option:");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        manageProduct(scanner, stock);
                        break;
                    case 2:
                        SupplierMenu supplierMenu = new SupplierMenu();
                        supplierMenu.displaySupplierMenu();
                        break;
                    case 3:
                        manageOutputProducts("resources/json/stock.json");
                        break;
                    case 4:
                        createOrder(scanner, stock);
                        break;
                    case 5:
                        manageBills(scanner, stock);
                        break;
                    case 6:
                        System.out.println("Leaving the system...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid option. Must enter a number.");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Input must be a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Argument error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void manageProduct(Scanner scanner, Stock stock) {
        System.out.println("Enter the product ID:");
        int idProduct = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter the name:");
        String name = scanner.nextLine();

        System.out.println("Enter the price:");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.println("Enter the amount:");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product(idProduct, name, price, amount, LocalDate.now());

        try {
            stock.addProduct(product);
            FileManager.saveProductToCSV(product);

            // Generate JSON for stock
            JsonGenerator.generateStockJson(stock);

            System.out.println("Product added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    private static void manageOutputProducts(String filePath) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        try (FileReader reader = new FileReader(filePath)) {
            Stock stock = gson.fromJson(reader, Stock.class);
            List<Product> products = stock.getProducts();
            System.out.println("\n----- List of products: ------");
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    private static void createOrder(Scanner scanner, Stock stock) {
        List<Product> orderProducts = new ArrayList<>();
        BigDecimal totalOrderPrice = BigDecimal.ZERO;

        while (true) {
            System.out.print("Enter the product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Product product = stock.findProductById(productId);
            if (product == null) {
                System.out.println("Product not found. Try again.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            totalOrderPrice = totalOrderPrice.add(totalPrice);

            for (int i = 0; i < quantity; i++) {
                orderProducts.add(product);
            }

            System.out.print("Do you want to add another product to the order? (yes/no): ");
            String addMore = scanner.nextLine();
            if (!addMore.equalsIgnoreCase("yes")) {
                break;
            }
        }

        int billNumber = (int) (Math.random() * 10000);
        Bills bill = new Bills(billNumber, "Consumer Name", LocalDateTime.now());

        for (Product product : orderProducts) {
            bill.addProduct(product);
        }

        try {
            FileManager.saveOrderToCSV(bill);
            JsonGenerator.generateBillJson(bill);

            System.out.println("Order created successfully:");
            System.out.println(bill);
        } catch (Exception e) {
            System.out.println("Error creating order: " + e.getMessage());
        }
    }

    private static void manageBills(Scanner scanner, Stock stock) {
        System.out.println("Enter consumer name:");
        String consumerName = scanner.nextLine();

        System.out.println("Enter payment type (CASH/TRANSFER):");
        String paymentTypeStr = scanner.nextLine().toUpperCase();
        KindOfPayment.PaymentType paymentType;

        try {
            paymentType = KindOfPayment.PaymentType.valueOf(paymentTypeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid payment type. Defaulting to CASH.");
            paymentType = KindOfPayment.PaymentType.CASH;
        }

        int billNumber = (int) (Math.random() * 10000);
        Bills bill = new Bills(billNumber, consumerName, LocalDateTime.now());

        for (Product product : stock.getProducts()) {
            bill.addProduct(product);
        }

        Consumer consumer = new Consumer(consumerName, BigDecimal.ZERO, bill, paymentType);
        consumer.createBill(bill, paymentType);

        try {
            System.out.println("Bill created successfully:");
            System.out.println(bill);
        } catch (Exception e) {
            System.out.println("Error creating bill: " + e.getMessage());
        }
    }
}
