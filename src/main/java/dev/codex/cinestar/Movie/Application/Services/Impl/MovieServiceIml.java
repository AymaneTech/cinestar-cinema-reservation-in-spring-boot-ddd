package dev.codex.cinestar.Movie.Application.Services.Impl;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import dev.codex.cinestar.Movie.Application.Dtos.MovieRequest;
import dev.codex.cinestar.Movie.Domain.Movie;
import dev.codex.cinestar.Movie.Infrastructure.MovieRepository;
import dev.codex.cinestar.Movie.Application.Services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MovieServiceIml implements MovieService {

    private final MovieRepository repository;
    private final CategoryServiceImpl categoryServiceImpl;
    private final AuthorServiceImpl authorService;
    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Movie findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie create(MovieRequest dto) {
        Movie movie = mapper.map(dto, Movie.class);
        movie.setCategory(categoryServiceImpl.findById(dto.categoryId()));
        movie.setAuthors(authorService.createAll(dto.authors()));
        return repository.save(movie);
    }

    public Movie update(Long id, MovieRequest dto) {
        Movie existingMovie = repository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        mapper.map(dto, existingMovie);
        existingMovie.setCategory(categoryServiceImpl.findById(dto.categoryId()));
        existingMovie.setAuthors(authorService.sync(dto.authors()));
        return repository.save(existingMovie);
    }

    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Movie not found");
        repository.deleteById(id);
    }
}
