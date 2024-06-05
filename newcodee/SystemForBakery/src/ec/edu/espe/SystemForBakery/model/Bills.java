
package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
class Bills {
    private int billNumber;
    private ArrayList  <Product> delivery = new ArrayList<>();
    private double amount;
    
    //don't have delivery
    public Bills(int billNumber, double amount) {
        this.billNumber = billNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bills{" + "billNumber=" + billNumber + ", delivery=" + delivery + ", amount=" + amount + '}';
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
    
    
}
