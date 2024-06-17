
package ec.edu.espe.SystemForBakery.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class EgressDailyRecord {
    private LocalDate date;
    private List<Supplier> suppliers;
    private List<Product> products;
    private BigDecimal egressRecord;

    public EgressDailyRecord(LocalDate date, BigDecimal egressRecord) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (egressRecord == null || egressRecord.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The expenditure record cannot be negative");
        }
        
        this.date = date;
        this.egressRecord = egressRecord;
        this.suppliers = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "EgressDailyRecord{" + "date=" + date + ", suppliers=" + suppliers + ", products=" + products + ", egressRecord=" + egressRecord + '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

    public List<Supplier> getSuppliers() {
        return new ArrayList<>(suppliers);
    }

    public void setSuppliers(List<Supplier> suppliers) {
        if (suppliers == null) {
            throw new IllegalArgumentException("The supplier list cannot be null");
        }
        this.suppliers = new ArrayList<>(suppliers);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setProducts(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("The product list cannot be null");
        }
        this.products = new ArrayList<>(products);
    }

    public BigDecimal getEgressRecord() {
        return egressRecord;
    }

    public void setEgressRecord(BigDecimal egressRecord) {
        if (egressRecord == null || egressRecord.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The expenditure record cannot be negative");
        }
        this.egressRecord = egressRecord;
    }

    public void addSupplier(Supplier supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Provider cannot be null");
        }
        this.suppliers.add(supplier);
    }

    public void removeSupplier(Supplier supplier) {
        this.suppliers.remove(supplier);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The product cannot be null");
        }
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
