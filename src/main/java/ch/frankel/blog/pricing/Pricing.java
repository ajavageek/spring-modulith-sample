package ch.frankel.blog.pricing;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pricing {

    @Id
    private Long productId;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public Long getProductId() {
        return productId;
    }
}
