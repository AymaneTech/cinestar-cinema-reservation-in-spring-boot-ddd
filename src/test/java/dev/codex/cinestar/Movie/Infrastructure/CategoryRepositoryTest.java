package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Entities.Category;
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
    @DisplayName("It should return category by name")
    void itShouldReturnCategoryByName() {
        // Arrange
        String name = "Action";
        String description = "Action movies";
        Category expected = new Category(name, description);
        sut.save(expected);
        // Act
        Optional<Category> result = sut.findByName(name);
        // Assert
        assertTrue(result.isPresent());
        Category actual = result.get();
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(actual.getDescription()).isEqualTo(description);
    }


    @Test
    @DisplayName("It should return empty Optional when category not found")
    void itShouldReturnEmptyOptionalWhenCategoryNotFound() {
        // Arrange
        String name = "Action";
        // Act
        Optional<Category> result = sut.findByName(name);
        // Assert
        assertTrue(result.isEmpty());
    }
}