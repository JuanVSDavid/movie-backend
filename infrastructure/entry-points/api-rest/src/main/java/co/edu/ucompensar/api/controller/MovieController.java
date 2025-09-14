package co.edu.ucompensar.api.controller;
import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.usecase.movie.MovieUseCase;
import co.edu.ucompensar.usecase.movie.command.CreateMovieCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/api/movie", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MovieController {
    private final MovieUseCase movieUseCase;
    private final ResponseMapper<Movie, MovieResponse> movieResponseMapper;

    @PostMapping
    public MovieResponse create(@RequestBody CreateMovieCommand request){
        var movie = movieUseCase.create(request);
        return movieResponseMapper.toResponse(movie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieUseCase.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            movieUseCase.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
