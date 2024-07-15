package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Entities.Category;
import dev.codex.cinestar.Movie.Domain.Exceptions.CategoryNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository sut;

    @AfterEach
    void tearDown() {
        sut.deleteAll();
    }

    @Test
    @DisplayName("It should return catetgory")
    void itShouldReturnCategoryByName() {
        // Arrange
        String name = "Action";
        Category actual = new Category(name, "Action movies");
        sut.save(actual);
        // Act
        Optional<Category> result = sut.findByName(name);
        // Assert
        assertThat(result.get().getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("It should throw exception when category not found")
    void itShouldThrowExceptionWhenCategoryNotFound() {
        // Arrange
        String name = "Action";
        // Act
        Optional<Category> actual = sut.findByName(name);
        // Assert
        assertThrows(CategoryNotFoundException.class, () -> {
            actual.orElseThrow(() -> new CategoryNotFoundException(name));
        });
    }
}