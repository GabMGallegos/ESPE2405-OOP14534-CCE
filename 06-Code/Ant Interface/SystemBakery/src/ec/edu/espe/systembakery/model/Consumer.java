package ec.edu.espe.systembakery.model;

import java.math.BigDecimal;
import ec.edu.espe.utils.JsonGenerator;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Consumer {

    private String consumerName;
    private BigDecimal cash;
    private Bills bill;
    private KindOfPayment.PaymentType paymentType;

    public Consumer(String consumerName, BigDecimal cash, Bills bill, KindOfPayment.PaymentType paymentType) {
        if (consumerName == null || consumerName.isEmpty()) {
            throw new IllegalArgumentException("Consumer name cannot be empty");
        }
        if (cash == null || cash.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cash cannot be negative");
        }
        if (bill == null) {
            throw new IllegalArgumentException("The invoice cannot be void");
        }
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }

        this.consumerName = consumerName;
        this.cash = cash;
        this.bill = bill;
        this.paymentType = paymentType;
    }

    public Consumer() {
    }
    
    @Override
    public String toString() {
        return "Consumer{" + "consumerName=" + consumerName + ", cash=" + cash + ", bill=" + bill + ", paymentType=" + paymentType + '}';
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

    public KindOfPayment.PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(KindOfPayment.PaymentType paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }
        this.paymentType = paymentType;
    }

    public void deductCash(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount to be discounted cannot be negative");
        }
        if (amount.compareTo(cash) > 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.cash = this.cash.subtract(amount);
    }

    public void createBill(Bills bill, KindOfPayment.PaymentType paymentType) {
        this.bill = bill;
        this.paymentType = paymentType;
        if (paymentType == KindOfPayment.PaymentType.TRANSFER) {
            // Add extra details if payment is by transfer
            // (Optional) you can add additional logic here
        }
        JsonGenerator.generateBillJson(bill);
    }
}
