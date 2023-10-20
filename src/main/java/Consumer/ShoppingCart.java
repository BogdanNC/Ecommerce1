package Consumer;

import Products.Product;
import Products.ProductSeries;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private HashMap <ProductSeries, Integer> productListQuantity;
    private int numberOfProducts;
    private BigDecimal totalPrice;

    public ShoppingCart() {
        this.productListQuantity = new HashMap<ProductSeries, Integer>();
        this.numberOfProducts = 0;
        this.totalPrice = BigDecimal.valueOf(0);
    }

    public void AddProduct(ProductSeries selectedProduct, Integer quantity) {
        if (selectedProduct.getQuantity() < quantity) {
            System.out.println("Error , there aren't enough products");
            return;
        }
        this.productListQuantity.put(selectedProduct, quantity);
        this.numberOfProducts = this.numberOfProducts + quantity;
        this.totalPrice = this.totalPrice.add(selectedProduct.getPrice().
                price.multiply(BigDecimal.valueOf(quantity)));
    }
    
    public void PayCart(Float budget) {
        if (totalPrice.compareTo(BigDecimal.valueOf(budget)) <= 0) {
            for (Map.Entry<ProductSeries, Integer> entry : productListQuantity.entrySet()) {
                ProductSeries buyProduct = entry.getKey();
                Integer buyQuantity = entry.getValue();
                if (buyProduct.getQuantity() >= buyQuantity) {
                    buyProduct.setQuantity(buyProduct.getQuantity() - buyQuantity);
                } else {
                    System.out.println("Produsul :" + buyProduct.getGeneralName() + "nu este disponibil in aceasta cantitate! cantitatea ramasa: " + buyProduct.getQuantity());
                    return;
                }
            }
            //buy (to implement)
        }
    }


}
