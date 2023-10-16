package DataManipulations;

import Database.Database;
import Products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProductsLoader implements DataLoader {

    Database database = Database.getDatabase();
    ArrayList<Product> products;
    @Override
    public void loadFromJsonFile(String filePath) {

    }

    @Override
    public void saveToDatabase() {

    }
    public void writeToJsonFile(String filePath) {
        File PasswdFile = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        this.products = database.getProducts();
        try {
            objectMapper.writeValue(PasswdFile, this.products);
            System.out.println("products info stored in products.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
