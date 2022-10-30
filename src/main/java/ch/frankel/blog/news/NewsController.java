package ch.frankel.blog.news;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    private final NewsRepository repository;

    public NewsController(NewsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/news")
    public List<News> getAll() {
        return repository.findAll();
    }
}
