package ch.frankel.blog.pricing;

import ch.frankel.blog.pricing.internal.Pricing;
import ch.frankel.blog.pricing.internal.PricingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricingService {

    private final PricingRepository repository;

    public PricingService(PricingRepository repository) {
        this.repository = repository;
    }

    public List<Pricing> getPrice(List<Long> productIds) {
        return productIds.stream()
                .map(repository::findByProductId)
                .collect(Collectors.toList());
    }
}
