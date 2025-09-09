package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.Movie;
import java.util.Optional;

import java.util.List;

public interface MovieRepository {
    Movie create(Movie movie);
    Movie modify(Movie movie);
    Movie delete(Movie movie);
//    Object findAll(Pageable pageable);
    Optional<Movie> findById(Long id);
}
