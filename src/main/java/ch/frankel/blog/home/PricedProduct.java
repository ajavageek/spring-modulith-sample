package ch.frankel.blog.home;

public class PricedProduct {

    private final Long productId;
    private final String name;
    private final String description;
    private final Double price;

    public PricedProduct(Long productId, String name, String description, Double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
