package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.MovieEntity;
import co.edu.ucompensar.model.movie.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDomainEntityMapper implements DomainEntityMapper<Movie, MovieEntity> {
    @Override
    public MovieEntity toEntity(Movie movie) {
        return MovieEntity.builder().title(movie.getTitle()).build();
    }

    @Override
    public Movie toDomain(MovieEntity movieEntity) {
        return Movie.builder().id(movieEntity.getId()).title(movieEntity.getTitle()).build();
    }
}
