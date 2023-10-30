package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.MongoModel.Product;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product, String> {
    @Query("{_id:'?0'}")
    Product findProductById(String id);

    @Query(value = "{category:'?0'}")
    List<Product> findProductsByCategory(String category);


}
