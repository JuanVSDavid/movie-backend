package co.edu.ucompensar.usecase.createmovie;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.gateways.MovieRepository;
import co.edu.ucompensar.usecase.createmovie.command.CreateMovieCommand;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import java.util.stream.Collectors;

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

    public Page<Movie> getNowPlaying(Pageable pageable) {
        return movieRepository.findNowPlaying(pageable);
    }

    public Page<Movie> getTopRated(Pageable pageable) {
        return movieRepository.findTopRated(pageable);
    }

    public Page<Movie> getUpcoming(Pageable pageable) {
        return movieRepository.findUpcoming(pageable);
    }

    public Page<Movie> getPopular(Pageable pageable) {
        return movieRepository.findPopular(pageable);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

}
