package com.example.demo.MongoModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productVariation")
public class ProductVariation {
    @Id
    private String id;

    private String producer, name, category, price, size, variationId, masterId, productName;
    private Integer quantity;
    private Boolean isMaster;

    public ProductVariation(String id, String producer, String name, String category, String price, String size, String variationId, String masterId, String productName, Integer quantity, Boolean isMaster) {
        super();

        this.id = id;
        this.producer = producer;
        this.name = name;
        this.category = category;
        this.price = price;
        this.size = size;
        this.variationId = variationId;
        this.masterId = masterId;
        this.productName = productName;
        this.quantity = quantity;
        this.isMaster = isMaster;
    }


    public String getId() {
        return this.id;
    }

    public String getProducer() {
        return this.producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVariationId() {
        return this.variationId;
    }

    public void setVariationId(String variationId) {
        this.variationId = variationId;
    }

    public String getMasterId() {
        return this.masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean isMaster() {
        return this.isMaster;
    }


}
