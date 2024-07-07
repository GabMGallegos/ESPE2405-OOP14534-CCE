package ec.edu.espe.SystemForBakery.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import ec.edu.espe.SystemForBakery.model.Product;
import ec.edu.espe.SystemForBakery.model.Bills;
import ec.edu.espe.SystemForBakery.model.Supplier;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class FileManager {

    public static void saveProducts(String fileName, List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : products) {
                writer.write(product.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveProductToCSV(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/products.csv", true))) {
            writer.write(product.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSupplierToCSV(Supplier supplier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/suppliers.csv", true))) {
            writer.write(supplier.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveOrderToCSV(Bills bill) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/orders.csv", true))) {
            writer.write(bill.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product parseProduct(String csv) {
        try {
            String[] parts = csv.split(",");
            if (parts.length < 5) {
                throw new IllegalArgumentException("Invalid product format");
            }
            int productId = Integer.parseInt(parts[0]);
            String name = parts[1];
            BigDecimal price = new BigDecimal(parts[2]);
            int amount = Integer.parseInt(parts[3]);
            LocalDate date = LocalDate.parse(parts[4]);
            return new Product(productId, name, price, amount, date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void loadProductToCSV(List<Product> products) {
        File file = new File("resources/products.csv");
        if (!file.exists()) {
            System.out.println("products.csv file does not exist. Creating a new one.");
            try {
                Files.createFile(Paths.get("resources/products.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/products.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    Product product = parseProduct(line);
                    if (product != null) {
                        products.add(product);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading products from CSV: " + e.getMessage());
        }
    }

    public static void saveBillsToCSV(Bills bill) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/bills.csv", true))) {
            writer.write(bill.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadBillsFromCSV(List<Bills> bills) {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/bills.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length >= 5) {
                        int billNumber = Integer.parseInt(parts[0]);
                        BigDecimal amount = new BigDecimal(parts[1]);
                        String consumerName = parts[2];
                        String paymentType = parts[3];
                        LocalDateTime date = LocalDateTime.parse(parts[4]);

                        Bills bill = new Bills(billNumber, consumerName, date);
                        bill.setAmount(amount);
                        bill.setPaymentType(paymentType);

                        bills.add(bill);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading bills from CSV: " + e.getMessage());
        }
    }
}
