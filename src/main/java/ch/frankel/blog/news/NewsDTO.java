package ch.frankel.blog.news;

import java.time.Instant;

public record NewsDTO(Long id, String label, Instant timestamp) {
}
