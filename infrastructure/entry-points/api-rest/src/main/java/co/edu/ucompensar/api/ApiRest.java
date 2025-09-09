package co.edu.ucompensar.api;
import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.usecase.createmovie.CreateMovieUseCase;
import co.edu.ucompensar.usecase.createmovie.command.CreateMovieCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/movie", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CreateMovieUseCase createMovieUseCase;
    private final ResponseMapper<Movie, MovieResponse> movieResponseMapper;

//    @PreAuthorize("hasRole('permission')")
//    @GetMapping(path = "/usecase/path")
//    public String commandName() {
//        return "";
//    }

    @PostMapping("/create")
    public MovieResponse create(@RequestBody CreateMovieCommand request){
        var movie = createMovieUseCase.create(request);
        return movieResponseMapper.toResponse(movie);
    }



//    @GetMapping
//    public Page<Movie> getAllMovies(Pageable pageable) {
//        return createMovieUseCase.listMovies(pageable);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return createMovieUseCase.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
