package co.edu.ucompensar.usecase.movie;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.entity.Movie;
import co.edu.ucompensar.model.movie.gateways.MovieRepository;
import co.edu.ucompensar.usecase.movie.command.CreateMovieCommand;
import lombok.RequiredArgsConstructor;

import java.util.Optional; // <-- Necesitarás este import
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieUseCase {

    private final MovieRepository movieRepository;

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie create(CreateMovieCommand command) {
        var genres = command.getGenresId().stream()
                .map(id -> Genre.builder().id(id).build())
                .collect(Collectors.toSet());

        var movieToCreate = Movie.builder()
                .title(command.getTitle())
                .genres(genres)
                .build();

        return movieRepository.create(movieToCreate);
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

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}