
package ec.edu.espe.SystemForBakery.model;

import java.time.LocalDate;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class Product {
    private int productId;
    private String name;
    private double price;
    private int amount;
    private LocalDate date;

    public Product() {
    }

    public Product(int productId, String name, double price, int amount, LocalDate date) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "name:" + name + ", productId: " + productId + ", price: $" + price + ", amount: " + amount + ", date: " + date;
    }
    
    
    
    public String toCSV() {
        return getProductId() + "," + getName() + "," + getPrice() + "," + getAmount() + "," + getDate(); 
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    
    
    
}
