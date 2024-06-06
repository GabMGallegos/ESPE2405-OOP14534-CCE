
package ec.edu.espe.SystemForBakery.model;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class KindOfPayment {
    private double digitalPayment;
    private double cashPayment;

    public KindOfPayment(double digitalPayment, double cashPayment) {
        this.digitalPayment = digitalPayment;
        this.cashPayment = cashPayment;
    }

    @Override
    public String toString() {
        return "KindOfPayment{" + "digitalPayment=" + digitalPayment + ", cashPayment=" + cashPayment + '}';
    }

    /**
     * @return the digitalPayment
     */
    public double getDigitalPayment() {
        return digitalPayment;
    }

    /**
     * @param digitalPayment the digitalPayment to set
     */
    public void setDigitalPayment(double digitalPayment) {
        this.digitalPayment = digitalPayment;
    }

    /**
     * @return the cashPayment
     */
    public double getCashPayment() {
        return cashPayment;
    }

    /**
     * @param cashPayment the cashPayment to set
     */
    public void setCashPayment(double cashPayment) {
        this.cashPayment = cashPayment;
    }
    
    
}
