
package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class Supplier {
    private String suppierName;
    private String numberContact;

    public Supplier(String suppierName, String numberContact) {
        this.suppierName = suppierName;
        this.numberContact = numberContact;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "suppierName=" + suppierName + ", numberContact=" + numberContact + '}';
    }
    
    public String toCSV() {
        return suppierName + "," + numberContact;
    }

    /**
     * @return the suppierName
     */
    public String getSuppierName() {
        return suppierName;
    }

    /**
     * @param suppierName the suppierName to set
     */
    public void setSuppierName(String suppierName) {
        this.suppierName = suppierName;
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
