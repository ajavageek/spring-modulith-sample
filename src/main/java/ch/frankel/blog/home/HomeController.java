package ch.frankel.blog.home;

import ch.frankel.blog.catalog.ProductDTO;
import ch.frankel.blog.catalog.ProductService;
import ch.frankel.blog.news.NewsService;
import ch.frankel.blog.pricing.PricingDTO;
import ch.frankel.blog.pricing.PricingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    private final PricingService pricingService;
    private final ProductService productService;
    private final NewsService newsService;

    public HomeController(PricingService pricingService, ProductService productService, NewsService newsRepository) {
        this.pricingService = pricingService;
        this.productService = productService;
        this.newsService = newsRepository;
    }

    private static PricedProduct toPricedProduct(List<ProductDTO> products, List<PricingDTO> pricings, int i) {
        var product = products.get(i);
        var pricing = pricings.get(i);
        return new PricedProduct(product.id(), product.name(), product.description(), pricing.price());
    }

    @GetMapping("/")
    public String getPricedProducts(Model model) {
        var products = productService.findAll();
        var pricings = pricingService.getPrice(products.stream().map(ProductDTO::id).toList());
        var pricedProducts = IntStream.range(0, products.size())
                .mapToObj(i -> toPricedProduct(products, pricings, i)).toList();
        model.addAttribute("products", pricedProducts);
        model.addAttribute("news", newsService.findAll());
        return "index";
    }
}
