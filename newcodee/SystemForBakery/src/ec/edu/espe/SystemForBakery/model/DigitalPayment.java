
package ec.edu.espe.SystemForBakery.model;

import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class DigitalPayment {
    private Date paymentDate;
    private double payment;

    public DigitalPayment(Date paymentDate, double payment) {
        this.paymentDate = paymentDate;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "CashPayment{" + "paymentDate=" + paymentDate + ", payment=" + payment + '}';
    }

    /**
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }
}
