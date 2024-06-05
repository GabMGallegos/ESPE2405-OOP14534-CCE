
package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class RecordRegistrationSuppliers {
    public Date date;
    private ArrayList <Suppliers> person = new ArrayList<>();

    public RecordRegistrationSuppliers() {
        
    }

    @Override
    public String toString() {
        return "RecordRegistrationSuppliers{" + "date=" + date + ", person=" + person + '}';
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
    public ArrayList <Suppliers> getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(ArrayList <Suppliers> person) {
        this.person = person;
    }
    
    
}
