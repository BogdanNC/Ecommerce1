package Products;

import Classes.ProductPrice;

public class Product {
    private Integer productID;
    private String Producer;
    private String generalName;
    private String category;

    public Product(Integer productID, String producer, String generalName, String category) {
        this.productID = productID;
        Producer = producer;
        this.generalName = generalName;
        this.category = category;
    }
    public Product(Product product) {
        this.category = product.getCategory();
        this.productID = product.getProductID();
        this.generalName = product.getGeneralName();
        this.Producer = product.getProducer();
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public String getGeneralName() {
        return generalName;
    }

    public void setGeneralName(String generalName) {
        this.generalName = generalName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
