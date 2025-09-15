package co.edu.ucompensar.api.controller;
import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MoviesResponse;
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
    private final ResponseMapper<Movie, MoviesResponse> movieResponseMapper;

    @PostMapping
    public MoviesResponse create(@RequestBody CreateMovieCommand request){
        var movie = movieUseCase.create(request);
        return movieResponseMapper.toResponse(movie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieUseCase.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
