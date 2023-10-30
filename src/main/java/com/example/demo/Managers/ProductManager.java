package com.example.demo.Managers;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.MongoModel.Product;
import com.example.demo.MongoModel.ProductVariation;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Repository.ProductVariationRepo;


public class ProductManager {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductVariationRepo productVariationRepo;

    public Object getProductById(String id) {
        Product product = productRepo.findProductById(id);

        if (product == null) {
            ProductVariation productVariation = productVariationRepo.findProductVariationById(id);

            if (productVariation == null) {
                return "null";
            }

            return productVariation;
        }

        return product;
    }
}
