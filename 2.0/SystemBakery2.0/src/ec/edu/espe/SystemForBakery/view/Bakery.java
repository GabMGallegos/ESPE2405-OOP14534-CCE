package ec.edu.espe.SystemForBakery.view;

import ec.edu.espe.SystemForBakery.model.Bills;
import ec.edu.espe.SystemForBakery.model.Product;
import ec.edu.espe.SystemForBakery.model.Supplier;
import utils.SystemProfile;
import utils.FileManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.JsonGenerator;

public class Bakery {

    public void someMethod() {
        int billNumber = 1;
        String consumerName = "Consumer Name";
        LocalDateTime now = LocalDateTime.now();
        Bills bill = new Bills(billNumber, consumerName, now);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        List<Supplier> suppliers = new ArrayList<>();

        FileManager.loadProductToCSV(products);
        Bakery bakery = new Bakery();
        bakery.login();

        

        while (true) {
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    manageProduct(scanner, products);
                    break;
                case 2:
                    manageSuppliers(scanner, suppliers);
                    break;
                case 3:
                    manageOutputProducts(products);
                    break;
                case 4:
                    createOrder(scanner, products);
                    break;
                case 5:
                    System.out.println("Leaving the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        SystemProfile systemProfile = new SystemProfile();       

        int intentosRestantes = 3;
        boolean accesoConcedido = false;

        while (intentosRestantes > 0 && !accesoConcedido) {
            System.out.println("Ingrese el usuario:");
            String username = scanner.nextLine();

            System.out.println("Ingrese su contrasenia:");
            String password = scanner.nextLine();

            if (systemProfile.authenticate(username, password)) {
                accesoConcedido = true;
            } else {
                intentosRestantes--;
                System.out.println("Nombre de usuario o contrasenia incorrectos. Intentos restantes: " + intentosRestantes);
            }
        }

        if (accesoConcedido) {
            System.out.println("Acceso concedido.");
        } else {
            System.out.println("Acceso denegado. Ha superado el número de intentos permitidos.");
        }
    }
    private static void displayMenu() {
        System.out.println("Team CodeCrafting Engineers");
        System.out.println("1. Product");
        System.out.println("2. Suppliers");
        System.out.println("3. Stock");
        System.out.println("4. Purchase Order ");
        System.out.println("5. Exit");
        System.out.println("Select an option:");
    }

    private static void manageProduct(Scanner scanner, List<Product> products) {
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
        products.add(product);
        FileManager.saveProductToCSV(product);
        
        JsonGenerator.generateStockJson(product);
        System.out.println("Product added successfully!");
    }

    private static void manageSuppliers(Scanner scanner, List<Supplier> suppliers) {
        System.out.println("Enter the name of the supplier company");
        String supplierName = scanner.nextLine();
        System.out.println("Enter the supplier contact");
        String numberContact = scanner.nextLine();

        Supplier supplier = new Supplier(supplierName, numberContact);
        suppliers.add(supplier);
        FileManager.saveSupplierToCSV(supplier);
        System.out.println("Supplier added successfully!");
    }

    private static void manageOutputProducts(List<Product> products) {
        System.out.println("\nList of products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void createOrder(Scanner scanner, List<Product> products) {
        List<Product> orderProducts = new ArrayList<>();
        BigDecimal totalOrderPrice = BigDecimal.ZERO; // Inicializar totalOrderPrice como BigDecimal

        while (true) {
            System.out.print("Enter the product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Product product = findProductById(products, productId);
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
