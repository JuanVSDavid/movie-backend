package co.edu.ucompensar.api.model.mapper;


import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MoviesResponse;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.model.movie.entity.Genre;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MoviesResponseMapper implements ResponseMapper<Movie, MoviesResponse>{


    @Override
    public MoviesResponse toResponse(Movie movie) {
        return MoviesResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .adult(movie.getAdult())
                .backdropPath(movie.getBackdropPath())
                .originalLanguage(movie.getOriginalLanguage())
                .originalTitle(movie.getOriginalTitle())
                .overview(movie.getOverview())
                .popularity(movie.getPopularity())
                .posterPath(movie.getPosterPath())
                .releaseDate(movie.getReleaseDate())
                .video(movie.getVideo())
                .voteAverage(movie.getVoteAverage())
                .voteCount(movie.getVoteCount())
                .genresId(movie.getGenres().stream().map(Genre::getId).collect(Collectors.toSet()))
                .build();
    }
}
