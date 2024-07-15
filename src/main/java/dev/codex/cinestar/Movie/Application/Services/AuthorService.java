package dev.codex.cinestar.Movie.Application.Services;

import dev.codex.cinestar.Movie.Application.DTOs.Requests.AuthorRequest;
import dev.codex.cinestar.Movie.Domain.Entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> createAll(List<AuthorRequest> dtos);

    List<Author> sync(List<AuthorRequest> dtos);
}
