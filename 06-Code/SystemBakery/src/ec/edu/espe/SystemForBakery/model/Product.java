package ec.edu.espe.SystemForBakery.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Product {

    private int id;
    private String name;
    private BigDecimal price;
    private int amount;
    private LocalDate date;

    public Product(int id, String name, BigDecimal price, int amount, LocalDate date) {
        if (id <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The price cannot be negative");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("The quantity cannot be negative");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The price cannot be negative");
        }
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The quantity cannot be negative");
        }
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

    public String toCSV() {
        return id + "," + name + "," + price + "," + amount + "," + date;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", price=" + price
                + ", amount=" + amount
                + ", date=" + date
                + '}';
    }
}
