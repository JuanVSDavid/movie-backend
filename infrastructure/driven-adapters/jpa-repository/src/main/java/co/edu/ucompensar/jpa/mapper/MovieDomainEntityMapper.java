package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.MovieEntity;
import co.edu.ucompensar.jpa.entity.SpokenLanguageEntity;
import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import co.edu.ucompensar.model.movie.Movie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.Set;


@Component
public class MovieDomainEntityMapper implements DomainEntityMapper<Movie, MovieEntity> {
    @Override
    public MovieEntity toEntity(Movie movie) {
        return MovieEntity.builder().title(movie.getTitle()).spokenLanguages(toEntityLanguages(movie.getSpokenLanguages())).build();
    }

    @Override
    public Movie toDomain(MovieEntity movieEntity) {
        return Movie.builder().id(movieEntity.getId()).title(movieEntity.getTitle()).spokenLanguages(toDomainLanguages(movieEntity.getSpokenLanguages())).build();
    }
    private static Set<SpokenLanguage> toDomainLanguages(Set<SpokenLanguageEntity> entities) {
        if (entities == null) return Set.of();
        return entities.stream()
                .map(lang -> SpokenLanguage.builder()
                        .iso6391(lang.getIso6391())
                        .name(lang.getName())
                        .englishName(lang.getEnglishName())
                        .build())
                .collect(Collectors.toSet());
    }
    private static Set<SpokenLanguageEntity> toEntityLanguages(Set<SpokenLanguage> models) {
        if (models == null) return Set.of();
        return models.stream()
                .map(lang -> SpokenLanguageEntity.builder()
                        .iso6391(lang.getIso6391())
                        .name(lang.getName())
                        .englishName(lang.getEnglishName())
                        .build())
                .collect(Collectors.toSet());
    }
}
