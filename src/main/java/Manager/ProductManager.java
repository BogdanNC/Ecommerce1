package Manager;

import Database.Database;
import Products.Product;
import Products.ProductSeries;

import java.util.Scanner;

public class ProductManager {
    Database database = Database.getDatabase();
    Scanner scanner = new Scanner(System.in);

    public void getProductsCommand () {
        System.out.println("10.1 - add product, 10.2 - add product series at a certain product type");
        String action = scanner.next();
        if (action.equals("10.1")) {
            addProduct();
        } else  if (action.equals("10.2")) {
            addProductSeries();
        } else {
            System.out.println("comanda invalida");
        }
    }
    public void addProduct () {
        System.out.println("product generalName: ");
        String name = scanner.next();

        System.out.println("product category: ");
        String category = scanner.next();

        System.out.println("product producer: ");
        String producer = scanner.next();

        Integer productId = assignProductID();

        Product product = new Product(productId, producer, name, category);

        //to do : store product to database

    }
    private Integer assignProductID () {
        //to do : assign unique Product ID;
        return 0;
    }
    public void addProductSeries () {

    }
}
