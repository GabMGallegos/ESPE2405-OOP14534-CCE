package ec.edu.espe.SystemForBakery.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import utils.FileManager;
import utils.JsonGenerator;
import utils.LocalDateAdapter;
import utils.LocalDateTimeAdapter;

/**
 *
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class Supplier {

    private int idSupplier;
    private String supplierName;
    private String numberContact;
    //agregar fecha de entrega del producto
    private List<Supplier> suppliers = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(int idSupplier, String supplierName, String numberContact) {
        this.idSupplier = idSupplier;
        this.supplierName = supplierName;
        this.numberContact = numberContact;
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
        return "ID: "+ idSupplier +
                "\nSupplier Name: " + supplierName
                + "\nNumber Contact: " + numberContact;
    }

}
