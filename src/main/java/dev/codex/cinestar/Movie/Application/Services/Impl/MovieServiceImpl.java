package dev.codex.cinestar.Movie.Application.Services.Impl;

import dev.codex.cinestar.Movie.Application.DTOs.Requests.MovieRequest;
import dev.codex.cinestar.Movie.Application.Services.CategoryService;
import dev.codex.cinestar.Movie.Application.Services.MovieService;
import dev.codex.cinestar.Movie.Domain.Entities.Category;
import dev.codex.cinestar.Movie.Domain.Entities.Movie;
import dev.codex.cinestar.Movie.Domain.Exceptions.MovieNotFoundException;
import dev.codex.cinestar.Movie.Domain.ValueObjects.MovieType;
import dev.codex.cinestar.Movie.Infrastructure.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final AuthorServiceImpl authorService;

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Movie create(MovieRequest dto) {
        Movie movie = map(dto);
        return repository.save(movie);
    }

    @Override
    public Movie update(Long id, MovieRequest dto) {
        Movie existingMovie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        existingMovie.setTitle(dto.title());
        existingMovie.setDescription(dto.description());
        existingMovie.setDirector(dto.director());
        existingMovie.setLanguage(dto.language());
        existingMovie.setReleaseYear(dto.releaseDate());
        existingMovie.setDuration(dto.duration());
        existingMovie.setType(dto.type());
        existingMovie.setCategory(categoryService.findById(dto.categoryId()));
        existingMovie.setAuthors(authorService.sync(dto.authors()));
        existingMovie.setCountry(dto.country());
        return repository.save(existingMovie);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new MovieNotFoundException(id);
        repository.deleteById(id);
    }

    @Override
    public List<Movie> filterByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Movie> filterByCategory(String categoryName) {
        Category category = categoryService.findByName(categoryName);
        return repository.findByCategory(category);
    }

    @Override
    public List<Movie> filterByMovieType(MovieType type) {
        return repository.findByType(type);
    }

    private Movie map(MovieRequest dto) {
        return new Movie(
                dto.title(),
                dto.description(),
                dto.director(),
                dto.language(),
                dto.releaseDate(),
                dto.duration(),
                dto.type(),
                categoryService.findById(dto.categoryId()),
                authorService.createAll(dto.authors()),
                dto.country()
        );
    }

//    @Override
//    public List<Movie> filterByAuthor(String type) {
//        return List.of();
//    }
}
