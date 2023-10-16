package Products;

public class Producers {
    private Integer producerId;
    private String nume;

    public Producers(Integer producerId, String nume) {
        this.producerId = producerId;
        this.nume = nume;
    }

    public Integer getProducerId() {
        return producerId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
