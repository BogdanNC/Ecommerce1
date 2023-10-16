package Products;

public class Product {
    private Integer producerId;
    private float price;
    private Integer quantity;
    private String name;

    public Product(Integer producerId, float price, Integer quantity, String name) {
        this.producerId = producerId;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public Integer getProducerId() {
        return producerId;
    }

    public float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
}
