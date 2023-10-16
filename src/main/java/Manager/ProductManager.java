package Manager;

import Database.Database;
import Products.Producers;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    Database database = Database.getDatabase();
    Scanner scanner = new Scanner(System.in);

    public void getProductsCommand () {
        System.out.println("10.1 - add producer, 10.2 - add product");
        String action = scanner.next();
        if (action.equals("10.1")) {
            addProducer();
        } else {
            System.out.println("comanda invalida");
        }
    }
    public void addProducer () {
        ArrayList<Producers> producers = database.getProducers();
        
    }
}
