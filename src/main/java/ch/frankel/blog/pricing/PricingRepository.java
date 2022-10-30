package ch.frankel.blog.pricing;

import ch.frankel.blog.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository extends JpaRepository<Pricing, Long> {

    Pricing findByProductId(Long productId);
}
