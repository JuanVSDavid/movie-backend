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

    private Set<GenreEntity> mapGenresToEntity(Set<Genre> genres) {
        if (genres == null) return Collections.emptySet();
        return genres.stream().map(g -> GenreEntity.builder().id(g.getId()).name(g.getName()).build()).collect(Collectors.toSet());
    }
    private Set<Genre> mapGenresToDomain(Set<GenreEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> Genre.builder().id(e.getId()).name(e.getName()).build()).collect(Collectors.toSet());
    }

    private Set<ProductionCompanyEntity> mapCompaniesToEntity(Set<ProductionCompany> companies) {
        if (companies == null) return Collections.emptySet();
        return companies.stream().map(c -> ProductionCompanyEntity.builder().id(c.getId()).name(c.getName()).logoPath(c.getLogoPath()).originCountry(c.getOriginCountry()).build()).collect(Collectors.toSet());
    }
    private Set<ProductionCompany> mapCompaniesToDomain(Set<ProductionCompanyEntity> entities) {
         if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> ProductionCompany.builder().id(e.getId()).name(e.getName()).logoPath(e.getLogoPath()).originCountry(e.getOriginCountry()).build()).collect(Collectors.toSet());
    }

    private Set<SpokenLanguageEntity> mapLanguagesToEntity(Set<SpokenLanguage> languages) {
        if (languages == null) return Collections.emptySet();
        return languages.stream().map(l -> SpokenLanguageEntity.builder().iso_639_1(l.getIso_639_1()).name(l.getName()).englishName(l.getEnglishName()).build()).collect(Collectors.toSet());
    }
    private Set<SpokenLanguage> mapLanguagesToDomain(Set<SpokenLanguageEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> SpokenLanguage.builder().iso_639_1(e.getIso_639_1()).name(e.getName()).englishName(e.getEnglishName()).build()).collect(Collectors.toSet());
    }

    private Set<ProductionCountryEntity> mapProdCountriesToEntity(Set<ProductionCountry> countries) {
        if (countries == null) return Collections.emptySet();
        return countries.stream().map(c -> ProductionCountryEntity.builder().iso_3166_1(c.getIso_3166_1()).name(c.getName()).build()).collect(Collectors.toSet());
    }
    private Set<ProductionCountry> mapProdCountriesToDomain(Set<ProductionCountryEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> ProductionCountry.builder().iso_3166_1(e.getIso_3166_1()).name(e.getName()).build()).collect(Collectors.toSet());
    }

    private Set<OriginCountryEntity> mapOriginCountriesToEntity(Set<OriginCountry> countries) {
        if (countries == null) return Collections.emptySet();
        return countries.stream().map(c -> OriginCountryEntity.builder().iso_3166_1(c.getIso_3166_1()).name(c.getName()).build()).collect(Collectors.toSet());
    }
    private Set<OriginCountry> mapOriginCountriesToDomain(Set<OriginCountryEntity> entities) {
        if (entities == null) return Collections.emptySet();
        return entities.stream().map(e -> OriginCountry.builder().iso_3166_1(e.getIso_3166_1()).name(e.getName()).build()).collect(Collectors.toSet());
    }

}
