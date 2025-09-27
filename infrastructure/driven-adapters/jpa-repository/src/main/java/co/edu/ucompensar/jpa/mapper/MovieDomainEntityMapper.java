package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.*;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.model.movie.entity.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieDomainEntityMapper implements DomainEntityMapper<Movie, MovieEntity> {

    @Override
    public MovieEntity toEntity(Movie movie) {
        if (movie == null) {
            return null;
        }

        return MovieEntity.builder()
                .title(movie.getTitle())
                .originalTitle(movie.getOriginalTitle())
                .overview(movie.getOverview())
                .releaseDate(movie.getReleaseDate())
                .posterPath(movie.getPosterPath())
                .backdropPath(movie.getBackdropPath())
                .budget(movie.getBudget())
                .revenue(movie.getRevenue())
                .runtime(movie.getRuntime())
                .status(movie.getStatus())
                .tagline(movie.getTagline())
                .voteCount(movie.getVoteCount())
                .adult(movie.getAdult())
                .video(movie.getVideo())
                .homepage(movie.getHomepage())
                .imdbId(movie.getImdbId())
                .originalLanguage(movie.getOriginalLanguage())
                .voteAverage(movie.getVoteAverage())
                .popularity(movie.getPopularity())

                .genres(mapGenresToEntity(movie.getGenres()))
                .productionCompanies(mapCompaniesToEntity(movie.getProductionCompanies()))
                .productionCountries(mapProdCountriesToEntity(movie.getProductionCountries()))
                .spokenLanguages(mapLanguagesToEntity(movie.getSpokenLanguages()))
                .originCountries(mapOriginCountriesToEntity(movie.getOriginCountries()))
                .build();
    }

    @Override
    public Movie toDomain(MovieEntity entity) {
        if (entity == null) {
            return null;
        }

        return Movie.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .originalTitle(entity.getOriginalTitle())
                .overview(entity.getOverview())
                .releaseDate(entity.getReleaseDate())
                .posterPath(entity.getPosterPath())
                .backdropPath(entity.getBackdropPath())
                .budget(entity.getBudget())
                .revenue(entity.getRevenue())
                .runtime(entity.getRuntime())
                .status(entity.getStatus())
                .tagline(entity.getTagline())
                .voteCount(entity.getVoteCount())
                .adult(entity.getAdult())
                .video(entity.getVideo())
                .homepage(entity.getHomepage())
                .imdbId(entity.getImdbId())
                .originalLanguage(entity.getOriginalLanguage())
                .voteAverage(entity.getVoteAverage())
                .popularity(entity.getPopularity())

                .genres(mapGenresToDomain(entity.getGenres()))
                .productionCompanies(mapCompaniesToDomain(entity.getProductionCompanies()))
                .productionCountries(mapProdCountriesToDomain(entity.getProductionCountries()))
                .spokenLanguages(mapLanguagesToDomain(entity.getSpokenLanguages()))
                .originCountries(mapOriginCountriesToDomain(entity.getOriginCountries()))
                .build();
    }

    // Métodos
    private Set<GenreEntity> mapGenresToEntity(Set<Genre> genres) {
        if (genres == null) return Collections.emptySet();
        return genres.stream().map(g -> new GenreEntity(g.getId(), g.getName())).collect(Collectors.toSet());
    }
    private Set<Genre> mapGenresToDomain(Set<GenreEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> Genre.builder().id(e.getId()).name(e.getName()).build()).collect(Collectors.toSet());
    }

    private Set<ProductionCompanyEntity> mapCompaniesToEntity(Set<ProductionCompany> companies) {
        if (companies == null) return Collections.emptySet();
        return companies.stream().map(c -> new ProductionCompanyEntity(c.getId(), c.getName())).collect(Collectors.toSet());
    }
    private Set<ProductionCompany> mapCompaniesToDomain(Set<ProductionCompanyEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> ProductionCompany.builder().id(e.getId()).name(e.getName()).build()).collect(Collectors.toSet());
    }

    private Set<SpokenLanguageEntity> mapLanguagesToEntity(Set<SpokenLanguage> languages) {
        if (languages == null) return Collections.emptySet();
        return languages.stream().map(l -> new SpokenLanguageEntity(l.getIso6391(), l.getName(), l.getEnglishName())).collect(Collectors.toSet());
    }
    private Set<SpokenLanguage> mapLanguagesToDomain(Set<SpokenLanguageEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> SpokenLanguage.builder().iso6391(e.getIso6391()).name(e.getName()).englishName(e.getEnglishName()).build()).collect(Collectors.toSet());
    }

    private Set<ProductionCountryEntity> mapProdCountriesToEntity(Set<ProductionCountry> countries) {
        if (countries == null) return Collections.emptySet();
        return countries.stream().map(c -> {
            ProductionCountryEntity entity = new ProductionCountryEntity();
            entity.setIso31661(c.getIso31661());
            entity.setName(c.getName());
            return entity;
        }).collect(Collectors.toSet());
    }
    private Set<ProductionCountry> mapProdCountriesToDomain(Set<ProductionCountryEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> ProductionCountry.builder().iso31661(e.getIso31661()).name(e.getName()).build()).collect(Collectors.toSet());
    }

    private Set<OriginCountryEntity> mapOriginCountriesToEntity(Set<OriginCountry> countries) {
        if (countries == null) return Collections.emptySet();
        return countries.stream().map(c -> new OriginCountryEntity(c.getCode())).collect(Collectors.toSet());
    }
    private Set<OriginCountry> mapOriginCountriesToDomain(Set<OriginCountryEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> OriginCountry.builder().code(e.getCode()).build()).collect(Collectors.toSet());
    }
}

