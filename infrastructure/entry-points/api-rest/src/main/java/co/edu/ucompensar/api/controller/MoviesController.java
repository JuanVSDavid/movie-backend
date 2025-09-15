package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MoviesResponse;
import co.edu.ucompensar.api.model.response.PageResponse;
import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.usecase.movie.MovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/movies", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MoviesController {
    private final MovieUseCase movieQueryUseCase;
    private final ResponseMapper<Movie, MoviesResponse> movieResponseMapper;
    private final ResponseMapper<Page<MoviesResponse>, PageResponse> pageResponseMapper;

    @GetMapping("/now_playing")
    public PageResponse getNowPlaying(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        var moviesPage = movieQueryUseCase.getNowPlaying(pageable);

        var responses = moviesPage.content().stream()
                .map(movieResponseMapper::toResponse)
                .toList();

        return pageResponseMapper.toResponse(new Page<>(
                responses,
                moviesPage.pageNumber(),
                moviesPage.pageSize(),
                moviesPage.totalElements()
        ));
    }

    @GetMapping("/top_rated")
    public PageResponse getTopRated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        var moviesPage = movieQueryUseCase.getTopRated(pageable);

        var responses = moviesPage.content().stream()
                .map(movieResponseMapper::toResponse)
                .toList();

        return pageResponseMapper.toResponse(new Page<>(
                responses,
                moviesPage.pageNumber(),
                moviesPage.pageSize(),
                moviesPage.totalElements()
        ));
    }

    @GetMapping("/upcoming")
    public PageResponse getUpcoming(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        var moviesPage = movieQueryUseCase.getUpcoming(pageable);

        var responses = moviesPage.content().stream()
                .map(movieResponseMapper::toResponse)
                .toList();

        return pageResponseMapper.toResponse(new Page<>(
                responses,
                moviesPage.pageNumber(),
                moviesPage.pageSize(),
                moviesPage.totalElements()
        ));
    }

    @GetMapping("/popular")
    public PageResponse getPopular(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        var moviesPage = movieQueryUseCase.getPopular(pageable);

        var responses = moviesPage.content().stream()
                .map(movieResponseMapper::toResponse)
                .toList();

        return pageResponseMapper.toResponse(new Page<>(
                responses,
                moviesPage.pageNumber(),
                moviesPage.pageSize(),
                moviesPage.totalElements()
        ));
    }
}
