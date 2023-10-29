package Products;

import Classes.ProductPrice;
import org.bson.types.ObjectId;

public class ProductSeries extends Product {


    private ProductPrice price;
    private Integer quantity;
    private String seriesId;
    private ObjectId parentId;
    private String finalProductName;

    private String size;

    public ProductSeries(Integer productID, String producer,
                         String generalName, String category) {
        super(productID, producer, generalName, category);
    }

    public ProductSeries (Product product, ProductPrice price,
                          Integer quantity, String series, ObjectId parentId, String finalProductName, String size) {
        super(product);
        this.price = price;
        this.quantity = quantity;
        this.seriesId = series;
        this.parentId = parentId;
        this.finalProductName = finalProductName;
        this.size = size;
    }

    public ProductSeries(Integer productID, String producer, String generalName,
                         String category, ProductPrice price, Integer quantity,
                         String series, ObjectId parentId, String finalProductName, String size) {
        super(productID, producer, generalName, category);
        this.price = price;
        this.quantity = quantity;
        this.seriesId = series;
        this.parentId = parentId;
        this.finalProductName = finalProductName;
        this.size = size;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }
}
