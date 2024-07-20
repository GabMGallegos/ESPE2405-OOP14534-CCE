package ec.edu.espe.bakery.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Stock {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The product cannot be null");
        }
        if (products.contains(product)) {
            throw new IllegalArgumentException("The product already exists in stock");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setProducts(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("The product list cannot be null");
        }
        this.products = new ArrayList<>(products);
    }

    public int getTotalQuantity() {
        return products.stream().mapToInt(Product::getAmount).sum();
    }

    public BigDecimal getTotalValue() {
        return products.stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "List Stock \n" + "Products:" + products
                + "\ntotalQuantity=" + getTotalQuantity()
                + "\ntotalValue=$" + getTotalValue();
    }
}
