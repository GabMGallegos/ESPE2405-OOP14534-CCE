
package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class RecordSuppliers {
    public Date date;
    private double amount;
    private ArrayList <Suppliers> suppliers = new ArrayList<>();

    public RecordSuppliers(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RecordSuppliers{" + "date=" + date + ", amount=" + amount + ", suppliers=" + suppliers + '}';
    }

    

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void Suppliers(Suppliers supplier){
        suppliers.add(supplier);
    }

    /**
     * @return the suppliers
     */
    public ArrayList <Suppliers> getSuppliers() {
        return suppliers;
    }

    /**
     * @param suppliers the suppliers to set
     */
    public void setSuppliers(ArrayList <Suppliers> suppliers) {
        this.suppliers = suppliers;
    }
}
