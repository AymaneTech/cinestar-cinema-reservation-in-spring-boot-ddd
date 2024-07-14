package dev.codex.cinestar.Movie.Application.Services.Impl;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import dev.codex.cinestar.Movie.Application.Dtos.MovieRequest;
import dev.codex.cinestar.Movie.Application.Services.CategoryService;
import dev.codex.cinestar.Movie.Application.Services.MovieService;
import dev.codex.cinestar.Movie.Domain.Category;
import dev.codex.cinestar.Movie.Domain.Movie;
import dev.codex.cinestar.Movie.Domain.MovieType;
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
    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public Movie create(MovieRequest dto) {
        Movie movie = mapper.map(dto, Movie.class);
        movie.setCategory(categoryService.findById(dto.categoryId()));
        movie.setAuthors(authorService.createAll(dto.authors()));
        return repository.save(movie);
    }

    @Override
    public Movie update(Long id, MovieRequest dto) {
        Movie existingMovie = repository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        mapper.map(dto, existingMovie);
        existingMovie.setCategory(categoryService.findById(dto.categoryId()));
        existingMovie.setAuthors(authorService.sync(dto.authors()));
        return repository.save(existingMovie);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Movie not found");
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

//    @Override
//    public List<Movie> filterByAuthor(String type) {
//        return List.of();
//    }
}
