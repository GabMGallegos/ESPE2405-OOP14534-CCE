
package ec.edu.espe.SystemForBakery.model;

/**
 
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Supplier {
    private String supplierName;
    private String numberContact;

    public Supplier() {
    }

    public Supplier(String supplierName, String numberContact) {
        if (supplierName == null || supplierName.isEmpty()) {
            throw new IllegalArgumentException("Provider name cannot be null or empty");
        }
        if (numberContact == null || numberContact.isEmpty()) {
            throw new IllegalArgumentException("Contact number cannot be null or empty");
        }
        this.supplierName = supplierName;
        this.numberContact = numberContact;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierName='" + supplierName + '\'' +
                ", numberContact='" + numberContact + '\'' +
                '}';
    }

    public String toCSV() {
        return supplierName + "," + numberContact;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        if (supplierName == null || supplierName.isEmpty()) {
            throw new IllegalArgumentException("Provider name cannot be null or empty");
        }
        this.supplierName = supplierName;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        if (numberContact == null || numberContact.isEmpty()) {
            throw new IllegalArgumentException("Contact number cannot be null or empty");
        }
        this.numberContact = numberContact;
    }
}
