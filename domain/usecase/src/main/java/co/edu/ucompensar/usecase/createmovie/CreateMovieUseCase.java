package co.edu.ucompensar.usecase.createmovie;

import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.gateways.MovieRepository;
import co.edu.ucompensar.usecase.createmovie.command.CreateMovieCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateMovieUseCase {
    private final MovieRepository movieRepository;

    public Movie create(CreateMovieCommand command){
        var movie = Movie
                .builder()
                .title(command.getTitle())
                .genres(command.getGenresId().stream().map(id -> Genre.builder().id(id).build()).collect(Collectors.toSet()))
                .build();
        return movieRepository.create(movie);
    }

    public Page<Movie> listMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

}
