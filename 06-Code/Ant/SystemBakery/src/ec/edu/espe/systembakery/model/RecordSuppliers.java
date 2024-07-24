package ec.edu.espe.systembakery.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un registro de proveedores en la panadería.
 *
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class RecordSuppliers {

    private LocalDate date;
    private BigDecimal amount;
    private List<Supplier> suppliers;

    public RecordSuppliers(LocalDate date, BigDecimal amount) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount cannot be negative");
        }

        this.date = date;
        this.amount = amount;
        this.suppliers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "RecordSuppliers{" + "date=" + date + ", amount=" + amount + ", suppliers=" + suppliers + '}';
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount cannot be negative");
        }
        this.amount = amount;
    }

    public void addSupplier(Supplier supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Provider cannot be null");
        }
        suppliers.add(supplier);
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
}
