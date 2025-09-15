package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.api.model.mapper.MovieResponseMapper;
import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.usecase.movie.MovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/movies", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MoviesController {

    private final MovieUseCase movieQueryUseCase;
    private final MovieResponseMapper movieResponseMapper;

    @GetMapping("/now_playing")
    public Page<MovieResponse> getNowPlaying(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        return movieResponseMapper.toResponsePage(movieQueryUseCase.getNowPlaying(pageable));
    }

    @GetMapping("/top_rated")
    public Page<MovieResponse> getTopRated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        return movieResponseMapper.toResponsePage(movieQueryUseCase.getTopRated(pageable));
    }

    @GetMapping("/upcoming")
    public Page<MovieResponse> getUpcoming(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        return movieResponseMapper.toResponsePage(movieQueryUseCase.getUpcoming(pageable));
    }

    @GetMapping("/popular")
    public Page<MovieResponse> getPopular(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = new Pageable(page, size);
        return movieResponseMapper.toResponsePage(movieQueryUseCase.getPopular(pageable));
    }
}