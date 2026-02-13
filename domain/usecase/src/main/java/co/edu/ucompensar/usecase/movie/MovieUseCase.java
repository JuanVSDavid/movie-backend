package co.edu.ucompensar.usecase.movie;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.model.movie.gateways.MovieRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MovieUseCase {

    private final MovieRepository movieRepository;

    public Movie create(Movie movie) {
        return movieRepository.create(movie);
    }

    public Movie modify(Long id, Movie movie) {
        return movieRepository.modify(id, movie);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public Page<Movie> findNowPlaying(Pageable pageable) {
        return movieRepository.findNowPlaying(pageable);
    }

    public Page<Movie> findTopRated(Pageable pageable) {
        return movieRepository.findTopRated(pageable);
    }

    public Page<Movie> findUpcoming(Pageable pageable) {
        return movieRepository.findUpcoming(pageable);
    }

    public Page<Movie> findPopular(Pageable pageable) {
        return movieRepository.findPopular(pageable);
    }
}