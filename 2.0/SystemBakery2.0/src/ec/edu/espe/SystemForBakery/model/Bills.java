package ec.edu.espe.SystemForBakery.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Bills {

    private int billNumber;
    private List<Product> delivery;
    
    private BigDecimal amount;
    private String consumerName;
    private LocalDateTime date;

    public Bills(int billNumber, String consumerName, LocalDateTime date) {
        if (billNumber <= 0) {
            throw new IllegalArgumentException("The invoice number must be positive");
        }
        if (consumerName == null || consumerName.isEmpty()) {
            throw new IllegalArgumentException("Consumer name cannot be empty");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        this.billNumber = billNumber;
        this.consumerName = consumerName;
        this.date = date;
        this.delivery = new ArrayList<>();
        this.amount = BigDecimal.ZERO;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The product cannot be null");
        }
        delivery.add(product);
        amount = amount.add(product.getPrice());
    }

    public void removeProduct(Product product) {
        if (delivery.remove(product)) {
            amount = amount.subtract(product.getPrice());
        }
    }

    @Override
    public String toString() {
        return "Bills{" + "billNumber=" + billNumber + ", delivery=" + delivery + ", amount=" + amount + ", consumerName=" + consumerName + ", date=" + date + '}';
    }

    public String toCSV() {
        StringBuilder csv = new StringBuilder();
        csv.append(billNumber).append(",").append(amount).append(",").append(consumerName).append(",").append(date).append("\n");
        for (Product product : delivery) {
            csv.append(product.toCSV()).append("\n");
        }
        return csv.toString();
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        if (billNumber <= 0) {
            throw new IllegalArgumentException("The invoice number must be positive");
        }
        this.billNumber = billNumber;
    }

    public List<Product> getDelivery() {
        return new ArrayList<>(delivery);
    }

    public void setDelivery(List<Product> delivery) {
        if (delivery == null) {
            throw new IllegalArgumentException("The delivery list cannot be null");
        }
        this.delivery = new ArrayList<>(delivery);
        this.amount = delivery.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount cannot be negative");
        }
        this.amount = amount;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }
}
