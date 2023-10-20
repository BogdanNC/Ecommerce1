package Database;

import Products.Product;
import UserPack.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private final static Database database = new Database();
    private ArrayList<User> userList;
    private HashMap<Integer, String> indexAndPasswd;
    private Integer userIndexCounter;
    private ArrayList<Product> products;
//    private ArrayList<Producers> producers;

    public HashMap<Integer, String> getIndexAndPasswd() {
        return indexAndPasswd;
    }

    public void setIndexAndPasswd(HashMap<Integer, String> indexAndPasswd) {
        this.indexAndPasswd = indexAndPasswd;
    }

    private Database() {}

    public static Database getDatabase() {
        return database;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Integer getUserIndexCounter() {
        return userIndexCounter;
    }

    public void setUserIndexCounter(Integer userIndexCounter) {
        this.userIndexCounter = userIndexCounter;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

//    public ArrayList<Producers> getProducers() {
//        return producers;
//    }

//    public void setProducers(ArrayList<Producers> producers) {
//        this.producers = producers;
//    }
}
