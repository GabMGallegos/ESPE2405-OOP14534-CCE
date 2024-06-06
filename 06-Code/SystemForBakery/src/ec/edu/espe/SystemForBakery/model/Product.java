
package ec.edu.espe.SystemForBakery.model;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
class Product {
    private String name;
    private double price;
    private int amount;
    private int productId;

    public Product(String name, double price, int amount, int productId) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", amount=" + amount + ", productId=" + productId + '}';
    }
    
    
    public String toCSV() {
        return name + "," + price + "," + amount + "," + productId; 
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
    
    
}
