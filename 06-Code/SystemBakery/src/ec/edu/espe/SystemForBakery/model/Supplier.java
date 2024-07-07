package ec.edu.espe.SystemForBakery.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Supplier {

    private int idSupplier;
    private String supplierName;
    private String numberContact;
    private List<Supplier> suppliers = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(int idSupplier, String supplierName, String numberContact) {
        this.idSupplier = idSupplier;
        setSupplierName(supplierName);
        setNumberContact(numberContact);
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
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

    public String toCSV() {
        return supplierName + "," + numberContact;
    }

    @Override
    public String toString() {
        return "ID: " + idSupplier
                + "\nSupplier Name: " + supplierName
                + "\nNumber Contact: " + numberContact;
    }
}
