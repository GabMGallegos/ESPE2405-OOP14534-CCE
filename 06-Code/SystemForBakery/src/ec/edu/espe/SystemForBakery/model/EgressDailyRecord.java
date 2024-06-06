
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
    private ArrayList<Product> products = new ArrayList<>();
    private double egressRecord;

    public EgressDailyRecord(Date date, double egressRecord) {
        this.date = date;
        this.egressRecord = egressRecord;
    }

    @Override
    public String toString() {
        return "EgressDailyRecord{" + "date=" + date + ", person=" + person + ", products=" + products + ", egressRecord=" + egressRecord + '}';
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
