
package ec.edu.espe.SystemForBakery.model;

/**
 
 * @autor  CODE_CRAFTING_ENGINEERS
 */
public class KindOfPayment {
    private final PaymentType paymentType;

    public KindOfPayment(PaymentType paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "KindOfPayment{" + "paymentType=" + paymentType + '}';
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public enum PaymentType {
        CASH("Cash"),
        CREDIT_CARD("Credit card"),
        DEBIT_CARD("Debit card"),
        MOBILE_PAYMENT("mobile payment");

        private final String description;

        PaymentType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
