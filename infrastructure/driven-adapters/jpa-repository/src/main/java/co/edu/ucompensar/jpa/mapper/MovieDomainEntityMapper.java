package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.MovieEntity;
import co.edu.ucompensar.jpa.entity.OriginCountryEntity;
import co.edu.ucompensar.jpa.entity.SpokenLanguageEntity;
import co.edu.ucompensar.model.movie.entity.OriginCountry;
import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import co.edu.ucompensar.model.movie.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class MovieDomainEntityMapper implements DomainEntityMapper<Movie, MovieEntity> {
    private final DomainEntityMapper <SpokenLanguage, SpokenLanguageEntity> spokenLanguageDomainEntityMapper;
    private final DomainEntityMapper <OriginCountry, OriginCountryEntity> originCountryDomainEntityMapper;
    @Override
    public MovieEntity toEntity(Movie movie) {
        return MovieEntity.builder().title(movie.getTitle()).spokenLanguages((Set<SpokenLanguageEntity>) spokenLanguageDomainEntityMapper.toEntity(movie.getSpokenLanguages(), HashSet::new)).originCountries((Set<OriginCountryEntity>) originCountryDomainEntityMapper.toEntity(movie.getOriginCountries(), HashSet::new)).build();
    }

    public Movie toDomain(MovieEntity movieEntity) {
        return Movie.builder().id(movieEntity.getId()).title(movieEntity.getTitle()).spokenLanguages((Set<SpokenLanguage>) spokenLanguageDomainEntityMapper.toDomain(movieEntity.getSpokenLanguages(), HashSet::new)).originCountries((Set<OriginCountry>) originCountryDomainEntityMapper.toDomain(movieEntity.getOriginCountries(), HashSet::new)).build();
    }
}
