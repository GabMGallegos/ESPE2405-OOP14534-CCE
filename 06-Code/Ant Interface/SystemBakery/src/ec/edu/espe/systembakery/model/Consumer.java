package ec.edu.espe.systembakery.model;

import java.util.ArrayList;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Consumer {

    private String cI;
    private String consumerName;
    private ArrayList<String> billsId;
    private KindOfPayment.PaymentType paymentType;

    public Consumer(String cI, String consumerName, ArrayList<String> billsId, KindOfPayment.PaymentType paymentType) {
        this.cI = cI;
        this.consumerName = consumerName;
        this.billsId = billsId;
        this.paymentType = paymentType;
    }

    public Consumer() {
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

    public KindOfPayment.PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(KindOfPayment.PaymentType paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }
        this.paymentType = paymentType;
    }
    
    /**
     * @return the cI
     */
    public String getcI() {
        return cI;
    }

    /**
     * @param cI the cI to set
     */
    public void setcI(String cI) {
        if (cI == null || cI.isEmpty()) {
            throw new IllegalArgumentException("Consumer name cannot be empty");
        }
        this.cI = cI;
    }

    /**
     * @return the billsId
     */
    public ArrayList<String> getBillsId() {
        return billsId;
    }

    /**
     * @param billsId the billsId to set
     */
    public void setBillsId(ArrayList<String> billsId) {
        this.billsId = billsId;
    }
}
