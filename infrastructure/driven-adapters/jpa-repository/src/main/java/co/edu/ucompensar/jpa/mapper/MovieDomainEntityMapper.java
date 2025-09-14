package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.MovieEntity;
import co.edu.ucompensar.model.movie.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieDomainEntityMapper implements DomainEntityMapper<Movie, MovieEntity> {

    private final GenreDomainEntityMapper genreMapper;
    private final ProductionCompanyDomainEntityMapper productionCompanyMapper;
    private final ProductionCountryDomainEntityMapper productionCountryMapper;
    private final SpokenLanguageDomainEntityMapper spokenLanguageMapper;
    private final OriginCountryDomainEntityMapper originCountryMapper;

    @Override
    public MovieEntity toEntity(Movie domain) {
        if (domain == null) return null;

        MovieEntity entity = new MovieEntity();

        entity.setId(domain.getId());
        entity.setTitle(domain.getTitle());
        entity.setOriginalTitle(domain.getOriginalTitle());
        entity.setOverview(domain.getOverview());
        entity.setReleaseDate(domain.getReleaseDate());
        entity.setPopularity(domain.getPopularity());
        entity.setPosterPath(domain.getPosterPath());
        entity.setBackdropPath(domain.getBackdropPath());
        entity.setBudget(domain.getBudget());
        entity.setRevenue(domain.getRevenue());
        entity.setRuntime(domain.getRuntime());
        entity.setStatus(domain.getStatus());
        entity.setTagline(domain.getTagline());
        entity.setVoteAverage(domain.getVoteAverage());
        entity.setVoteCount(domain.getVoteCount());
        entity.setAdult(domain.getAdult());
        entity.setVideo(domain.getVideo());
        entity.setHomepage(domain.getHomepage());
        entity.setImdbId(domain.getImdbId());
        entity.setOriginalLanguage(domain.getOriginalLanguage());

        if (domain.getGenres() != null) {
            entity.setGenres(domain.getGenres().stream().map(g -> genreMapper.toEntity(g)).collect(Collectors.toSet()));
        }
        if (domain.getProductionCompanies() != null) {
            entity.setProductionCompanies(domain.getProductionCompanies().stream().map(pc -> productionCompanyMapper.toEntity(pc)).collect(Collectors.toSet()));
        }
        if (domain.getProductionCountries() != null) {
            entity.setProductionCountries(domain.getProductionCountries().stream().map(pc -> productionCountryMapper.toEntity(pc)).collect(Collectors.toSet()));
        }
        if (domain.getSpokenLanguages() != null) {
            entity.setSpokenLanguages(domain.getSpokenLanguages().stream().map(sl -> spokenLanguageMapper.toEntity(sl)).collect(Collectors.toSet()));
        }
        if (domain.getOriginCountries() != null) {
            entity.setOriginCountries(domain.getOriginCountries().stream().map(oc -> originCountryMapper.toEntity(oc)).collect(Collectors.toSet()));
        }

        return entity;
    }

    @Override
    public Movie toDomain(MovieEntity entity) {
        if (entity == null) return null;

        return Movie.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .originalTitle(entity.getOriginalTitle())
                .overview(entity.getOverview())
                .releaseDate(entity.getReleaseDate())
                .popularity(entity.getPopularity())
                .posterPath(entity.getPosterPath())
                .backdropPath(entity.getBackdropPath())
                .budget(entity.getBudget())
                .revenue(entity.getRevenue())
                .runtime(entity.getRuntime())
                .status(entity.getStatus())
                .tagline(entity.getTagline())
                .voteAverage(entity.getVoteAverage())
                .voteCount(entity.getVoteCount())
                .adult(entity.getAdult())
                .video(entity.getVideo())
                .homepage(entity.getHomepage())
                .imdbId(entity.getImdbId())
                .originalLanguage(entity.getOriginalLanguage())
                .genres(entity.getGenres().stream().map(g -> genreMapper.toDomain(g)).collect(Collectors.toSet()))
                .productionCompanies(entity.getProductionCompanies().stream().map(pc -> productionCompanyMapper.toDomain(pc)).collect(Collectors.toSet()))
                .productionCountries(entity.getProductionCountries().stream().map(pc -> productionCountryMapper.toDomain(pc)).collect(Collectors.toSet()))
                .spokenLanguages(entity.getSpokenLanguages().stream().map(sl -> spokenLanguageMapper.toDomain(sl)).collect(Collectors.toSet()))
                .originCountries(entity.getOriginCountries().stream().map(oc -> originCountryMapper.toDomain(oc)).collect(Collectors.toSet()))
                .build();
    }
}