
package ec.edu.espe.SystemForBakery.model;

import ec.edu.espe.SystemForBakery.model.Product;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
class Bills {
    private int billNumber;
    private ArrayList  <Product> delivery = new ArrayList<>();
    private double amount;
    private String consumerName;
    public Date date;
    
    
    
    public Bills(int billNumber, double amount, String consumerName, Date date) {
        this.billNumber = billNumber;
        this.amount = amount;
        this.consumerName = consumerName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bills{" + "billNumber=" + billNumber + ", delivery=" + delivery + ", amount=" + amount + ", consumerName=" + consumerName + ", date=" + date + '}';
    }
      
    
    /**
     * @return the billNumber
     */
    public int getBillNumber() {
        return billNumber;
    }

    /**
     * @param billNumber the billNumber to set
     */
    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    /**
     * @return the delivery
     */
    public ArrayList  <Product> getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(ArrayList  <Product> delivery) {
        this.delivery = delivery;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the consumerName
     */
    public String getConsumerName() {
        return consumerName;
    }

    /**
     * @param consumerName the consumerName to set
     */
    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
