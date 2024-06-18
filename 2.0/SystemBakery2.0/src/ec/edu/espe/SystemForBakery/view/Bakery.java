package ec.edu.espe.SystemForBakery.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.SystemForBakery.model.*;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import utils.*;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public class Bakery {

    Scanner scanner = new Scanner(System.in);

    public void someMethod() {
        int billNumber = 1;
        String consumerName = "Consumer Name";
        LocalDateTime now = LocalDateTime.now();
        Bills bill = new Bills(billNumber, consumerName, now);
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock();
        List<Supplier> suppliers = new ArrayList<>();

        FileManager.loadProductToCSV(stock.getProducts());

        SystemProfile profile = new SystemProfile();
        profile.login();
        int option = 0;

        while (true){

            try {
                System.out.println("-------Main Menu------");
                System.out.println("1. Product");
                System.out.println("2. Suppliers");
                System.out.println("3. Stock");
                System.out.println("4. Purchase Order ");
                System.out.println("5. Exit");
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
                        manageOutputProducts("stock.json");
                        break;
                    case 4:
                        createOrder(scanner, stock);
                        break;
                    case 5:
                        System.out.println("Leaving the system...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Opción inválida. Debe ingresar un número.");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: La entrada debe ser un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error de argumento: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        } 
    }    
    private static void manageProduct(Scanner scanner, Stock stock) {
        System.out.println("Enter the product ID");
        int idProduct = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Enter the name");
        String name = scanner.next();
        System.out.println("Enter the price");
        double price = Double.parseDouble(scanner.next());
        System.out.println("Enter the amount");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        BigDecimal priceBigDecimal = BigDecimal.valueOf(price); // Convertir el precio a BigDecimal
        Product product = new Product(idProduct, name, priceBigDecimal, amount, LocalDate.now());
        //products.add(product);

        try {
            stock.addProduct(product);
            FileManager.saveProductToCSV(product);

            // Generar JSON para el stock
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
        BigDecimal totalOrderPrice = BigDecimal.ZERO; // Inicializar totalOrderPrice como BigDecimal

        while (true) {
            System.out.print("Enter the product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Product product = stock.findProductById(productId);
            if (product == null) {
                System.out.println("Product not found. Try again.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            totalOrderPrice = totalOrderPrice.add(totalPrice); // Realizar la suma con add()

            for (int i = 0; i < quantity; i++) {
                orderProducts.add(product);
            }

            System.out.print("Do you want to add another product to the order? (yes/no): ");
            String addMore = scanner.nextLine();
            if (!addMore.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Generate bill number (random for this example)
        int billNumber = (int) (Math.random() * 10000);
        Bills bill = new Bills(billNumber, "Consumer Name", LocalDateTime.now()); // Ajustar la llamada al constructor

        for (Product product : orderProducts) {
            bill.addProduct(product);
        }

        // Save order to CSV file
        FileManager.saveOrderToCSV(bill);

        JsonGenerator.generateBillJson(bill);

        System.out.println("Order created successfully:");
        System.out.println(bill);
    }

    private static Product findProductById(List<Product> products, int productId) {
        for (Product product : products) {
            if (product.getId() == productId) { // Cambiar getProductId() a getId()
                return product;
            }
        }
        return null;
    }
}
