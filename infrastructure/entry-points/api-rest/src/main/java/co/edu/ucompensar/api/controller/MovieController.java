package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.api.model.mapper.MovieResponseMapper;
import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.model.movie.entity.Movie;
import co.edu.ucompensar.usecase.movie.MovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/movie", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MovieController {

    private final MovieUseCase movieUseCase;
    private final MovieResponseMapper movieResponseMapper;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody Movie movie) {
        var movieCreated = movieUseCase.create(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponseMapper.toResponse(movieCreated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        return movieUseCase.findById(id)
                .map(movieFound -> ResponseEntity.ok(movieResponseMapper.toResponse(movieFound)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        try {
            var movieModified = movieUseCase.modify(id, movie);
            return ResponseEntity.ok(movieResponseMapper.toResponse(movieModified));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            movieUseCase.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}