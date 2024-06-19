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
        List<Bills> bills = new ArrayList<>();

        FileManager.loadProductToCSV(stock.getProducts());
        FileManager.loadBillsFromCSV(bills);

        SystemProfile profile = new SystemProfile();
        profile.login();

        int option = 0;

        while (true) {
            try {
                System.out.println("-------Main Menu------");
                System.out.println("1. Manage Products");
                System.out.println("2. Manage Suppliers");
                System.out.println("3. View Stock");
                System.out.println("4. Make Purchase");
                System.out.println("5. View Purchases");
                System.out.println("6. Exit");
                System.out.print("Select an option: ");
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
                        makePurchase(scanner, stock, bills);
                        break;
                    case 5:
                        showPurchases(bills);
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

    private static void makePurchase(Scanner scanner, Stock stock, List<Bills> bills) {
        List<Product> orderProducts = new ArrayList<>();
        BigDecimal totalOrderPrice = BigDecimal.ZERO;

        while (true) {
            System.out.print("Enter the product ID to add to the order (enter -1 to finish): ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (productId == -1) {
                break;
            }

            Product product = stock.findProductById(productId);
            if (product == null) {
                System.out.println("Product not found. Try again.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (quantity > product.getAmount()) {
                System.out.println("Not enough stock available. Try again.");
                continue;
            }

            BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            totalOrderPrice = totalOrderPrice.add(totalPrice);

            for (int i = 0; i < quantity; i++) {
                orderProducts.add(product);
            }

            product.setAmount(product.getAmount() - quantity);
        }

        if (orderProducts.isEmpty()) {
            System.out.println("No products selected. Purchase canceled.");
            return;
        }

        System.out.println("Enter consumer name (or 'FINAL CONSUMER' if not applicable): ");
        String consumerName = scanner.nextLine();

        System.out.println("Enter payment type (CASH/TRANSFER): ");
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
        bill.setPaymentType(paymentType.toString());

        for (Product product : orderProducts) {
            bill.addProduct(product, 1);
        }

        try {
            FileManager.saveBillsToCSV(bill);
            JsonGenerator.generateBillJson(bill);
            bills.add(bill);
            JsonGenerator.generateStockJson(stock);

            System.out.println("Purchase completed successfully:");
            System.out.println(bill);
        } catch (Exception e) {
            System.out.println("Error completing purchase: " + e.getMessage());
        }
    }

    private static void showPurchases(List<Bills> bills) {
        if (bills.isEmpty()) {
            System.out.println("No purchases available.");
        } else {
            System.out.println("\n----- List of purchases: ------");
            for (Bills bill : bills) {
                System.out.println(bill);
            }
        }
    }
}
