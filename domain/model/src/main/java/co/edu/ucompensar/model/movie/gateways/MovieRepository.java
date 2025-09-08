package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import java.util.List;

public interface MovieRepository {
    Movie create(Movie movie);
    Movie modify(Movie movie);
    Movie delete(Movie movie);
    Page<Movie> findAll(Pageable pageable);
    Optional<Movie> findById(Long id);
}
