package dev.codex.cinestar.Movie.Domain.Exceptions;

public class CategoryNotFoundException extends RuntimeException {
    private final Long id;
    private final String name;

    public CategoryNotFoundException(Long id) {
        super("Category with id " + id + " not found");
        this.id = id;
        this.name = null;
    }

    public CategoryNotFoundException(String name) {
        super("Category with name " + name + " not found");
        this.name = name;
        this.id = null;
    }

    public Long getCategoryId() {
        return id;
    }

    public String getCategoryName() {
        return name;
    }
}
