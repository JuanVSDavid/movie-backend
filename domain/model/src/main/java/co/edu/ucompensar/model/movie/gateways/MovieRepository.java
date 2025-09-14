package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.entity.Movie; // Asegúrate que el import sea correcto
import java.util.Optional;

public interface MovieRepository {

    Movie create(Movie movie);

    Movie modify(Long id, Movie movie);

    void deleteById(Long id);

    Optional<Movie> findById(Long id);

    Page<Movie> findAll(Pageable pageable);

    Page<Movie> findNowPlaying(Pageable pageable);

    Page<Movie> findTopRated(Pageable pageable);

    Page<Movie> findUpcoming(Pageable pageable);

    Page<Movie> findPopular(Pageable pageable);
}