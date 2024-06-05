
package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class EgressDailyRecord {
    private Date date;
    private ArrayList<Suppliers> person = new ArrayList<>();
    private double totalBill;
    private ArrayList<Product> products = new ArrayList<>();
    private double totalMiscellaneousProducts;
    private double egressRecord;

    // don't have person and products
    public EgressDailyRecord(Date date, double totalBill, double totalMiscellaneousProducts, double egressRecord) {
        this.date = date;
        this.totalBill = totalBill;
        this.totalMiscellaneousProducts = totalMiscellaneousProducts;
        this.egressRecord = egressRecord;
    }

    @Override
    public String toString() {
        return "EgressDailyRecord{" + "date=" + date + ", person=" + person + ", totalBill=" + totalBill + ", products=" + products + ", totalMiscellaneousProducts=" + totalMiscellaneousProducts + ", egressRecord=" + egressRecord + '}';
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the person
     */
    public ArrayList<Suppliers> getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(ArrayList<Suppliers> person) {
        this.person = person;
    }

    /**
     * @return the totalBill
     */
    public double getTotalBill() {
        return totalBill;
    }

    /**
     * @param totalBill the totalBill to set
     */
    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * @return the totalMiscellaneousProducts
     */
    public double getTotalMiscellaneousProducts() {
        return totalMiscellaneousProducts;
    }

    /**
     * @param totalMiscellaneousProducts the totalMiscellaneousProducts to set
     */
    public void setTotalMiscellaneousProducts(double totalMiscellaneousProducts) {
        this.totalMiscellaneousProducts = totalMiscellaneousProducts;
    }

    /**
     * @return the egressRecord
     */
    public double getEgressRecord() {
        return egressRecord;
    }

    /**
     * @param egressRecord the egressRecord to set
     */
    public void setEgressRecord(double egressRecord) {
        this.egressRecord = egressRecord;
    }
    
    
}
