package Manager;

import Classes.ProductPrice;
import Database.MongoDB;
import Products.Product;
import Products.ProductSeries;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

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
            try {
                addProductSeries();
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
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

        if (productCollection.find(Filters.eq("productId", productId)).first() != null) {
            if (productCollection.find(Filters.eq("producer", producer)).first() != null) {
                client.close();
                throw new Exception("Already existing Id by this producer");
            }
        }

        Document ProductDocument = new Document("name", name).append("category", category).
                append("producer", producer).append("productId", productId);
        productCollection.insertOne(ProductDocument);
        client.close();

    }
    public void addProductSeries () throws Exception {
        MongoDB mongoClient = new MongoDB();
        MongoClient client = mongoClient.connectDB();

        MongoCollection<Document> productSeriesCollection = mongoClient.getCollection("productSeries", client);
        MongoCollection<Document> productCollection = mongoClient.getCollection("products", client);

        System.out.println("what is the product ID: ");
        Integer productId = scanner.nextInt();

        System.out.println("who is the producer ?");
        String producer = scanner.next();

        FindIterable<Document> productsWithId = productCollection.find(Filters.eq("productId", productId));

        if (productsWithId.first() != null) {
            Document product = productsWithId.filter(Filters.eq("producer", producer)).first();
            if (product != null) {
                System.out.println(product.toString());
                ObjectId ParentID = product.getObjectId("_id");
                String objName = product.getString("name");
                String category = product.getString("category");

                System.out.println("product name type: ");
                String finalProductName = scanner.next();

                System.out.println("product price: ");
                String priceString = scanner.next();
                ProductPrice productPrice = new ProductPrice(priceString, "lei", "19");

                System.out.println("product size : ");
                String size = scanner.next();

                System.out.println("product quantity: ");
                Integer quantity = scanner.nextInt();

                System.out.println("product seriesId : ");
                String seriesId = scanner.next();

                ProductSeries subProduct = new ProductSeries(productId, producer, objName, category, productPrice, quantity, seriesId, ParentID, finalProductName, size );

                Document subProductDocument = new Document("productId", productId).append("producer", producer).
                        append("name", objName).append("category", category).
                        append("price", priceString).append("quantity", quantity).append("size", size).append("seriesId",seriesId).
                        append("ParentID", ParentID).append("finalProductName",finalProductName);
                productSeriesCollection.insertOne(subProductDocument);
                client.close();

            } else {
                client.close();
                throw new Exception ("there is no such producer");
            }
        } else {
            client.close();
            throw new Exception ("there is no such ID");
        }
    }
}
