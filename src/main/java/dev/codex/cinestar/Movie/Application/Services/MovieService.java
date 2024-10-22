package dev.codex.cinestar.Movie.Application.Services;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.Movie.Application.DTOs.Requests.MovieRequest;
import dev.codex.cinestar.Movie.Domain.Entities.Movie;
import dev.codex.cinestar.Movie.Domain.ValueObjects.MovieType;

import java.util.List;

public interface MovieService extends CrudService<Movie, Long, MovieRequest> {
    List<Movie> filterByTitle(String title);

    List<Movie> filterByCategory(String categoryName);

    List<Movie> filterByMovieType(MovieType type);

//    List<Movie> filterByAuthor(String type);
}
