    package ec.edu.espe.systembakery.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Adrian Padilla CODE_CRAFTING_ENGINEERS
 */
public class Bill {

    private int billNumber;
    private List<Product> products;
    private BigDecimal amount;
    private String consumerName;
    private LocalDateTime date;
    private KindOfPayment payment;

    public Bill(int billNumber, String consumerName, LocalDateTime date, KindOfPayment payment) {
        validateBillNumber(billNumber);
        validateConsumerName(consumerName);
        validateDate(date);

        this.billNumber = billNumber;
        this.consumerName = consumerName;
        this.date = date;
        this.products = new ArrayList<>();
        this.amount = BigDecimal.ZERO;
        this.payment = payment;
    }

    public Bill() {
    }

    public void addProduct(Product product, int quantity) {
        validateProduct(product);
        product.setAmount(quantity);
        products.add(product);
        amount = amount.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            amount = amount.subtract(product.getPrice());
        }
    }

    @Override
    public String toString() {
        return "Bill{" + "billNumber=" + billNumber + ", products=" + products + ", amount=" + amount + ", consumerName=" + consumerName + ", date=" + date + ", payment=" + payment + '}';
    }

    public String toCSV() {
        StringBuilder csv = new StringBuilder();
        csv.append(billNumber).append(",").append(amount).append(",").append(consumerName).append(",").append(payment).append(",").append(date).append("\n");
        for (Product product : products) {
            csv.append(product.getId()).append(",").append(product.getName()).append(",").append(product.getPrice()).append(",").append(product.getAmount()).append("\n");
        }
        return csv.toString();
    }

    public int getBillNumber() {
        return billNumber;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public KindOfPayment getPayment() {
        return payment;
    }

    private void validateBillNumber(int billNumber) {
        if (billNumber <= 0) {
            throw new IllegalArgumentException("The invoice number must be positive");
        }
    }

    private void validateConsumerName(String consumerName) {
        if (consumerName == null || consumerName.isEmpty()) {
            throw new IllegalArgumentException("Consumer name cannot be empty");
        }
    }

    private void validateDate(LocalDateTime date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }

    private void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The product cannot be null");
        }
    }
}
