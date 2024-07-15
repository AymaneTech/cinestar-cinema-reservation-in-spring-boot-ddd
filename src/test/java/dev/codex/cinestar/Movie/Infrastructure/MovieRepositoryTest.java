package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Entities.Author;
import dev.codex.cinestar.Movie.Domain.Entities.Category;
import dev.codex.cinestar.Movie.Domain.Entities.Movie;
import dev.codex.cinestar.Movie.Domain.ValueObjects.MovieType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestConfig.class)
class MovieRepositoryTest {

    @Autowired
    private MovieRepository sut;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuthorRepository authorRepository;

    private Category category;
    private List<Author> authors;
    private Movie movie;

    @BeforeEach
    void setUp() {
        category = categoryRepository.save(new Category("Action", "Action movies"));
        authors = authorRepository.saveAll(List.of(new Author("John Doe")));

        movie = new Movie(
                "The Matrix",
                "A computer programmer discovers a fantastical reality",
                "Wachowski Sisters",
                "English",
                Date.from(Instant.now()),
                "136 minutes",
                MovieType.ACTION,
                category,
                authors,
                "USA"
        );
        sut.save(movie);
    }

    @AfterEach
    void tearDown() {
        sut.deleteAll();
        categoryRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    @DisplayName("Should find movie by title")
    void shouldFindMovieByTitle() {
        // Act
        List<Movie> result = sut.findByTitle("The Matrix");

        // Assert
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getTitle()).isEqualTo("The Matrix");
    }

    @Test
    @DisplayName("Should return empty list when movie title not found")
    void shouldReturnEmptyListWhenMovieTitleNotFound() {
        // Act
        List<Movie> result = sut.findByTitle("Nonexistent Movie");

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Should find movies by category")
    void shouldFindMoviesByCategory() {
        // Act
        List<Movie> result = sut.findByCategory(category);

        // Assert
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getCategory().getName()).isEqualTo("Action");
    }

    @Test
    @DisplayName("Should find movies by type")
    void shouldFindMoviesByType() {
        // Act
        List<Movie> result = sut.findByType(MovieType.ACTION);

        // Assert
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getType()).isEqualTo(MovieType.ACTION);
    }

    @Test
    @DisplayName("Should save movie")
    void shouldSaveMovie() {
        // Arrange
        Movie newMovie = new Movie(
                "Inception",
                "A thief who enters the dreams of others",
                "Christopher Nolan",
                "English",
                Date.from(Instant.now()),
                "148 minutes",
                MovieType.SCI_FI,
                category,
                authors,
                "USA"
        );

        // Act
        Movie savedMovie = sut.save(newMovie);

        // Assert
        assertThat(savedMovie.getId()).isNotNull();
        assertThat(savedMovie.getTitle()).isEqualTo("Inception");
    }

    // Add more tests as needed...
}