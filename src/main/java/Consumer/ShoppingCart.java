package Consumer;

import Products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private HashMap <Product, Integer> productListQuantity;
    private int numberOfProducts;
    private float totalPrice;

    public ShoppingCart() {
        this.productListQuantity = new HashMap<Product, Integer>();
        this.numberOfProducts = 0;
        this.totalPrice = 0;
    }

    public void AddProduct(Product selectedProduct, Integer quantity) {
        if (selectedProduct.getQuantity() < quantity) {
            System.out.println("Error , there aren't enough products");
            return;
        }
        this.productListQuantity.put(selectedProduct, quantity);
        this.numberOfProducts = this.numberOfProducts + quantity;
        this.totalPrice = this.totalPrice + selectedProduct.getPrice() * quantity;
    }
    
    public void PayCart(Float budget) {
        if (budget > totalPrice) {
            for (Map.Entry<Product, Integer> entry : productListQuantity.entrySet()) {
                Product buyProduct = entry.getKey();
                Integer buyQuantity = entry.getValue();
                if (buyProduct.getQuantity() >= buyQuantity) {
                    buyProduct.setQuantity(buyProduct.getQuantity() - buyQuantity);
                } else {
                    System.out.println("Produsul :" + buyProduct.getName() + "nu este disponibil in aceasta cantitate! cantitatea ramasa: " + buyProduct.getQuantity());
                    return;
                }
            }
            //buy (to implement)
        }
    }


}
