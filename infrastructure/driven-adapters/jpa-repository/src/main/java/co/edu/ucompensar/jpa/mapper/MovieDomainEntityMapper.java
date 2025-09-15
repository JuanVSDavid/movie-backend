package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.*;
import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.entity.OriginCountry;
import co.edu.ucompensar.model.movie.entity.ProductionCompany;
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
    private final DomainEntityMapper<SpokenLanguage, SpokenLanguageEntity> spokenLanguageDomainEntityMapper;
    private final DomainEntityMapper<OriginCountry, OriginCountryEntity> originCountryDomainEntityMapper;
    private final DomainEntityMapper<Genre, GenreEntity> genreDomainEntityMapper;
    private final DomainEntityMapper<ProductionCompany, ProductionCompanyEntity> productionCompanyEntityDomainMapper;

    @Override
    public MovieEntity toEntity(Movie movie) {
        return MovieEntity
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .adult(movie.getAdult())
                .backdropPath(movie.getBackdropPath())
                .budget(movie.getBudget())
                .imdbId(movie.getImdbId())
                .video(movie.getVideo())
                .originalLanguage(movie.getOriginalLanguage())
                .posterPath(movie.getPosterPath())
                .popularity(movie.getPopularity())
                .revenue(movie.getRevenue())
                .runtime(movie.getRuntime())
                .tagline(movie.getTagline())
                .status(movie.getStatus())
                .voteCount(movie.getVoteCount())
                .voteAverage(movie.getVoteAverage())
                .homepage(movie.getHomepage())
                .originalTitle(movie.getOriginalTitle())
                .overview(movie.getOverview())
                .originalLanguage(movie.getOriginalLanguage())
                .releaseDate(movie.getReleaseDate())
                .spokenLanguages((Set<SpokenLanguageEntity>) spokenLanguageDomainEntityMapper.toEntity(movie.getSpokenLanguages(), HashSet::new))
                .originCountries((Set<OriginCountryEntity>) originCountryDomainEntityMapper.toEntity(movie.getOriginCountries(), HashSet::new))
                .genres((Set<GenreEntity>) genreDomainEntityMapper.toEntity(movie.getGenres(), HashSet::new))
                .productionCompanies((Set<ProductionCompanyEntity>) productionCompanyEntityDomainMapper.toEntity(movie.getProductionCompanies(), HashSet::new))
                .build();
    }

    public Movie toDomain(MovieEntity movieEntity) {
        return Movie
                .builder()
                .id(movieEntity.getId())
                .title(movieEntity.getTitle())
                .adult(movieEntity.getAdult())
                .backdropPath(movieEntity.getBackdropPath())
                .budget(movieEntity.getBudget())
                .imdbId(movieEntity.getImdbId())
                .video(movieEntity.getVideo())
                .originalLanguage(movieEntity.getOriginalLanguage())
                .posterPath(movieEntity.getPosterPath())
                .popularity(movieEntity.getPopularity())
                .revenue(movieEntity.getRevenue())
                .runtime(movieEntity.getRuntime())
                .tagline(movieEntity.getTagline())
                .status(movieEntity.getStatus())
                .voteCount(movieEntity.getVoteCount())
                .voteAverage(movieEntity.getVoteAverage())
                .homepage(movieEntity.getHomepage())
                .originalTitle(movieEntity.getOriginalTitle())
                .overview(movieEntity.getOverview())
                .originalLanguage(movieEntity.getOriginalLanguage())
                .releaseDate(movieEntity.getReleaseDate())
                .spokenLanguages((Set<SpokenLanguage>) spokenLanguageDomainEntityMapper.toDomain(movieEntity.getSpokenLanguages(), HashSet::new))
                .originCountries((Set<OriginCountry>) originCountryDomainEntityMapper.toDomain(movieEntity.getOriginCountries(), HashSet::new))
                .genres((Set<Genre>) genreDomainEntityMapper.toDomain(movieEntity.getGenres(), HashSet::new))
                .productionCompanies((Set<ProductionCompany>) productionCompanyEntityDomainMapper.toDomain(movieEntity.getProductionCompanies(), HashSet::new))
                .build();
    }


}
