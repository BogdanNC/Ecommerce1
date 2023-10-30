package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.MongoModel.ProductVariation;

public interface ProductVariationRepo extends MongoRepository<ProductVariation, String> {
    @Query("{_id:'?0'}")
    ProductVariation findProductVariationById(String id);
}
