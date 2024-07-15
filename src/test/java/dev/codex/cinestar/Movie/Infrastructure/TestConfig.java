package dev.codex.cinestar.Movie.Infrastructure;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("dev.codex.cinestar.Movie.Infrastructure")
@EntityScan("dev.codex.cinestar.Movie.Domain.Entities")
public class TestConfig {
}
