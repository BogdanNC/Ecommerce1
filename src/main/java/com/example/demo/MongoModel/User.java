package com.example.demo.MongoModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    private String name, email;
    @Id
    private String id;

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
