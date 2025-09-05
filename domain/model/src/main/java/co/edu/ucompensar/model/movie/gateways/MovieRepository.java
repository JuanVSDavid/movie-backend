package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.Movie;

import java.util.List;

public interface MovieRepository {
    Movie create(Movie movie);
    Movie modify(Movie movie);
    Movie delete(Movie movie);
    List<Movie> getUpcoming();
}
