package com.example.demo.MongoModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {
    @Id
    private String id;

    private String name, category, productId;
    private Boolean isMaster;

    public Product(String id, String name, String category, Boolean isMaster) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.isMaster = isMaster;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }    

    public Boolean isMaster() {
        return this.isMaster;
    }
}
