package co.edu.ucompensar.api.model.mapper;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.movie.entity.Movie;
import co.edu.ucompensar.api.model.response.MovieResponse;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {

    MovieResponse movieToResponse(Movie movie);

    List<MovieResponse> moviesToResponses(List<Movie> movies);

    default Page<MovieResponse> toResponsePage(Page<Movie> domainPage) {
        if (domainPage == null) {
            return null;
        }
        List<MovieResponse> responseContent = moviesToResponses(domainPage.content());
        return new Page<>(
                responseContent,
                domainPage.pageNumber(),
                domainPage.pageSize(),
                domainPage.totalElements()
        );
    }
}