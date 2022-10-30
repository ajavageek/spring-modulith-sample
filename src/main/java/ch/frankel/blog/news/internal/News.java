package ch.frankel.blog.news.internal;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class News {

    @Id
    private Long id;
    private Instant timestamp;
    private String label;

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
