package ec.edu.espe.systembakery.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Adrian Padilla CODE_CRAFTING_ENGINEERS
 */
public class Stock {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        validateProduct(product);
        if (products.contains(product)) {
            throw new IllegalArgumentException("The product already exists in stock");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        validateProduct(product);
        products.remove(product);
    }

    public Product findProductById(int productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setProducts(List<Product> products) {
        validateProductList(products);
        this.products.clear();
        this.products.addAll(products);
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

    private void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The product cannot be null");
        }
    }

    private void validateProductList(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("The product list cannot be null");
        }
    }
}
