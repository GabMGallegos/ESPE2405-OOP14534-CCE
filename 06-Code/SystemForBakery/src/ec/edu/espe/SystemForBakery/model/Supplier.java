
package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class Supplier {
    private String supplierName;
    private String numberContact;

    public Supplier() {
    }
    
    public Supplier(String suppierName, String numberContact) {
        this.supplierName = suppierName;
        this.numberContact = numberContact;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "suppierName=" + supplierName + ", numberContact=" + numberContact + '}';
    }
    
    public String toCSV() {
        return supplierName + "," + numberContact;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the numberContact
     */
    public String getNumberContact() {
        return numberContact;
    }

    /**
     * @param numberContact the numberContact to set
     */
    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }
    
    
}
