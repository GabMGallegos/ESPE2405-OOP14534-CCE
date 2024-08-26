    package ec.edu.espe.systembakery.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Adrian Padilla CODE_CRAFTING_ENGINEERS
 */
public class Bill {

    private String billNumber;
    private List<Product> products;
    private BigDecimal totalPrice;
    private String consumerName;
    private LocalDateTime date;
    private KindOfPayment payment;

    public Bill(String billNumber, String consumerName, LocalDateTime date, KindOfPayment payment) {
        validateConsumerName(consumerName);
        validateDate(date);

        this.billNumber = billNumber;
        this.consumerName = consumerName;
        this.date = date;
        this.products = new ArrayList<>();
        this.totalPrice = BigDecimal.ZERO;
        this.payment = payment;
    }

    public Bill() {
    }

    public void addProduct(Product product, int quantity) {
        validateProduct(product);
        product.setAmount(quantity);
        products.add(product);
        totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            totalPrice = totalPrice.subtract(product.getPrice());
        }
    }

    @Override
    public String toString() {
        return "Bill{" + "billNumber=" + billNumber + ", products=" + products + ", amount=" + totalPrice + ", consumerName=" + consumerName + ", date=" + date + ", payment=" + payment + '}';
    }

    public String toCSV() {
        StringBuilder csv = new StringBuilder();
        csv.append(billNumber).append(",").append(totalPrice).append(",").append(consumerName).append(",").append(payment).append(",").append(date).append("\n");
        for (Product product : products) {
            csv.append(product.getId()).append(",").append(product.getName()).append(",").append(product.getPrice()).append(",").append(product.getAmount()).append("\n");
        }
        return csv.toString();
    }

    public String getBillNumber() {
        return billNumber;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
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

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPayment(KindOfPayment payment) {
        this.payment = payment;
    }
}
