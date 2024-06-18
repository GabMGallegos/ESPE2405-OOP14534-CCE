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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.csv", true))) {
            writer.write(product.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSupplierToCSV(Supplier supplier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suppliers.csv", true))) {
            writer.write(supplier.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveOrderToCSV(Bills bill) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.csv", true))) {
            writer.write(bill.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product parseProduct(String csv) {
        try {
            String[] parts = csv.split(",");
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
        try (BufferedReader reader = new BufferedReader(new FileReader("products.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                BigDecimal price = new BigDecimal(parts[2]);
                int amount = Integer.parseInt(parts[3]);
                LocalDate date = LocalDate.parse(parts[4]);

                Product product = new Product(id, name, price, amount, date);
                products.add(product);
            }
        } catch (IOException e) {
            System.err.println("Error loading products from CSV: " + e.getMessage());
        }
    }
}
