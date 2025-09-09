package co.edu.ucompensar.api.model.mapper;


import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.model.movie.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapper implements ResponseMapper<Movie, MovieResponse>{


    @Override
    public MovieResponse toResponse(Movie movie) {
        return null;
    }
}
