
package ec.edu.espe.SystemForBakery.model;

import java.math.BigDecimal;

/**
 
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Consumer {
    private String consumerName;
    private BigDecimal cash;
    private Bills bill;

    public Consumer(String consumerName, BigDecimal cash, Bills bill) {
        if (consumerName == null || consumerName.isEmpty()) {
            throw new IllegalArgumentException("Consumer name cannot be empty");
        }
        if (cash == null || cash.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cash cannot be negative");
        }
        if (bill == null) {
            throw new IllegalArgumentException("The invoice cannot be void");
        }
        
        this.consumerName = consumerName;
        this.cash = cash;
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Consumer{" + "consumerName=" + consumerName + ", cash=" + cash + ", bill=" + bill + '}';
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        if (consumerName == null || consumerName.isEmpty()) {
            throw new IllegalArgumentException("Consumer name cannot be empty");
        }
        this.consumerName = consumerName;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        if (cash == null || cash.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cash cannot be negative");
        }
        this.cash = cash;
    }

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        if (bill == null) {
            throw new IllegalArgumentException("The invoice cannot be void");
        }
        this.bill = bill;
    }

    public void deductCash(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount to be discounted cannot be negative");
        }
        if (amount.compareTo(cash) > 0) {
            throw new IllegalArgumentException("insufficient funds");
        }
        this.cash = this.cash.subtract(amount);
    }
}
