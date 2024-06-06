
package ec.edu.espe.SystemForBakery.model;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class Consumer {
    private String consumerName;
    private double cash;
    private Bills bill;

    public Consumer(String consumerName, double cash, Bills bill) {
        this.consumerName = consumerName;
        this.cash = cash;
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Consumer{" + "consumerName=" + consumerName + ", cash=" + cash + ", bill=" + bill + '}';
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
     * @return the cash
     */
    public double getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(double cash) {
        this.cash = cash;
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
