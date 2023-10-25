package Manager;

import Database.MongoDB;
import Products.Product;
import Products.ProductSeries;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);

    public void getProductsCommand () {
        System.out.println("10.1 - add product, 10.2 - add product series at a certain product type");
        String action = scanner.next();
        if (action.equals("10.1")) {
            try {
                addProduct();
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        } else  if (action.equals("10.2")) {
            addProductSeries();
        } else {
            System.out.println("comanda invalida");
        }
    }
    public void addProduct () throws Exception {

        MongoDB mongoClient = new MongoDB();
        MongoClient client = mongoClient.connectDB();

        MongoCollection<Document> productCollection = mongoClient.getCollection("products", client);

        System.out.println("product generalName: ");
        String name = scanner.next();

        System.out.println("product category: ");
        String category = scanner.next();

        System.out.println("product producer: ");
        String producer = scanner.next();

        System.out.println("assign product ID: ");
        Integer productId = scanner.nextInt();
       // Integer productId = assignProductID();

        //Product product = new Product(productId, producer, name, category);
        if (productCollection.find(Filters.eq("productId", productId)).first() != null) {
            if (productCollection.find(Filters.eq("producer", producer)).first() != null)) {
                throw new Exception("Already existing Id by this producer");
            }
        }

        Document ProductDocument = new Document("name", name).append("category", category).
                append("producer", producer).append("productId", productId);
        productCollection.insertOne(ProductDocument);
        //to do : store product to database

    }
    private Integer assignProductID () {
        //to do : assign unique Product ID;
        return 0;
    }
    public void addProductSeries () {

    }
}
