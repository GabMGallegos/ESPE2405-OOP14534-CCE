
package ec.edu.espe.SystemForBakery.model;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class KindOfPayment {
    private String paymentType;

    public KindOfPayment(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "KindOfPayment{" + "paymentType='" + paymentType + '\'' + '}';
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
}
