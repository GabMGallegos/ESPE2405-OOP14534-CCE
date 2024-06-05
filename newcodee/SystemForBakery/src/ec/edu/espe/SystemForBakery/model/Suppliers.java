
package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
    public class Suppliers {
    private ArrayList <Product> brandedProducts = new ArrayList<>();
    private String brand;
    private int amount;
    private Date orderDay;
    private Date delivery;
    private Bills bill;
    
    //don't have branded Products
    public Suppliers(String brand, int amount, Date orderDay, Date delivery, Bills bill) {
        this.brand = brand;
        this.amount = amount;
        this.orderDay = orderDay;
        this.delivery = delivery;
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "brandedProducts=" + brandedProducts + ", brand=" + brand + ", amount=" + amount + ", orderDay=" + orderDay + ", delivery=" + delivery + ", bill=" + bill + '}';
    }

    /**
     * @return the brandedProducts
     */
    public ArrayList <Product> getBrandedProducts() {
        return brandedProducts;
    }

    /**
     * @param brandedProducts the brandedProducts to set
     */
    public void setBrandedProducts(ArrayList <Product> brandedProducts) {
        this.brandedProducts = brandedProducts;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * @return the orderDay
     */
    public Date getOrderDay() {
        return orderDay;
    }

    /**
     * @param orderDay the orderDay to set
     */
    public void setOrderDay(Date orderDay) {
        this.orderDay = orderDay;
    }

    /**
     * @return the delivery
     */
    public Date getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    /**
     * @return the bill
     */
    public Bills getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(Bills bill) {
        this.bill = bill;
    }
    
    
}
