package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.api.model.mapper.MovieResponseMapper;

import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.usecase.movie.MovieUseCase;

import co.edu.ucompensar.usecase.movie.command.CreateMovieCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieUseCase movieUseCase;
    private final MovieResponseMapper movieResponseMapper;

    @PostMapping
    public ResponseEntity<MovieResponse> create(@RequestBody CreateMovieCommand request) {
        var movieCreated = movieUseCase.create(request);
        return ResponseEntity.ok(movieResponseMapper.toResponse(movieCreated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        return movieUseCase.findById(id)
                .map(movie -> ResponseEntity.ok(movieResponseMapper.toResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }
}