package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.entity.Genre;

import java.util.List;

public interface GenreRepository {
    Genre create(Genre genre);
    List<Genre> getGenres();
}
