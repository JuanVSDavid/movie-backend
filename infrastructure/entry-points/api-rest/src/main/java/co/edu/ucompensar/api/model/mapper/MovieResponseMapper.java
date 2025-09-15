package co.edu.ucompensar.api.model.mapper;

import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MovieResponse;
import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.movie.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovieResponseMapper implements ResponseMapper<Movie, MovieResponse> {

    @Override
    public MovieResponse toResponse(Movie movie) {
        if (movie == null) {
            return null;
        }

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .overview(movie.getOverview())
                .releaseDate(movie.getReleaseDate())
                .genresId(
                        Optional.ofNullable(movie.getGenres()).orElse(Collections.emptySet())
                                .stream()
                                .map(genre -> genre.getId())
                                .collect(Collectors.toSet())
                )
                .spokenLanguagesId(
                        Optional.ofNullable(movie.getSpokenLanguages()).orElse(Collections.emptySet())
                                .stream()
                                .map(language -> language.getIso6391())
                                .collect(Collectors.toSet())
                )
                .originCountriesId(
                        Optional.ofNullable(movie.getOriginCountries()).orElse(Collections.emptySet())
                                .stream()
                                .map(country -> country.getCode())
                                .collect(Collectors.toSet())
                )
                .build();
    }

    public Page<MovieResponse> toResponsePage(Page<Movie> domainPage) {
        if (domainPage == null) {
            return null;
        }

        var responseContent = domainPage.content().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        return new Page<>(
                responseContent,
                domainPage.pageNumber(),
                domainPage.pageSize(),
                domainPage.totalElements()
        );
    }
}