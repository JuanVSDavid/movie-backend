package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.entity.Movie;
import co.edu.ucompensar.usecase.movie.MovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.api.model.mapper.MovieResponseMapper;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MovieUseCase movieUseCase;
    private final MovieResponseMapper movieResponseMapper;

    @GetMapping("/now_playing")
    public Page<MovieResponse> getNowPlaying(Pageable pageable) {
        Page<movie> moviesPage = movieUseCase.findNowPlaying(pageable);
        return movieResponseMapper.toResponse(moviesPage);
    }
    @GetMapping("/top_rated")
    public Page<MovieResponse> getTopRated(Pageable pageable) {
        Page<Movie> moviesPage = movieUseCase.findTopRated(pageable);
        return movieResponseMapper.toResponse(moviesPage);
    }

    @GetMapping("/upcoming")
    public Page<MovieResponse> getUpcoming(Pageable pageable) {
        Page<Movie> moviesPage = movieUseCase.findUpcoming(pageable);
        return movieResponseMapper.toResponse(moviesPage);
    }

    @GetMapping("/popular")
    public Page<MovieResponse> getPopular(Pageable pageable) {
        Page<Movie> moviesPage = movieUseCase.findPopular(pageable);
        return movieResponseMapper.toResponse(moviesPage);
    }
}