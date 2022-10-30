package ch.frankel.blog.home;

import ch.frankel.blog.catalog.Product;
import ch.frankel.blog.catalog.ProductRepository;
import ch.frankel.blog.news.NewsRepository;
import ch.frankel.blog.pricing.internal.Pricing;
import ch.frankel.blog.pricing.PricingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    private final PricingService pricingService;
    private final ProductRepository productRepository;
    private final NewsRepository newsRepository;

    public HomeController(PricingService pricingService, ProductRepository productRepository, NewsRepository newsRepository) {
        this.pricingService = pricingService;
        this.productRepository = productRepository;
        this.newsRepository = newsRepository;
    }

    private static PricedProduct toPricedProduct(List<Product> products, List<Pricing> pricings, int i) {
        var product = products.get(i);
        var pricing = pricings.get(i);
        return new PricedProduct(product.getId(), product.getName(), product.getDescription(), pricing.getPrice());
    }

    @GetMapping("/")
    public String getPricedProducts(Model model) {
        var products = productRepository.findAll();
        var pricings = pricingService.getPrice(products.stream().map(Product::getId).toList());
        var pricedProducts = IntStream.range(0, products.size())
                .mapToObj(i -> toPricedProduct(products, pricings, i)).toList();
        model.addAttribute("products", pricedProducts);
        model.addAttribute("news", newsRepository.findAll());
        return "index";
    }
}
