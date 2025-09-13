package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    List<Genre> findAll();
    Optional<Genre> findById(Long id);
    Genre save(Genre country);
    void deleteById(Long id);
}
