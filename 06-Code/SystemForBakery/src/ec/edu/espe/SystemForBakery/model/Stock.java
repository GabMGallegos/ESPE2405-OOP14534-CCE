
package ec.edu.espe.SystemForBakery.model;

import ec.edu.espe.SystemForBakery.model.Product;
import java.util.ArrayList;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class Stock {
    private ArrayList<Product> products= new ArrayList<>();

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" + "products=" + products + '}';
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
    
}
