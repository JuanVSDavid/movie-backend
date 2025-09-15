package co.edu.ucompensar.model.movie;
import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.entity.OriginCountry;
import co.edu.ucompensar.model.movie.entity.ProductionCompany;
import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
public class Movie {
    private Long id;
    private String title;
    private Set<Genre> genres;
    private Set<SpokenLanguage> spokenLanguages;
    private Set<OriginCountry> originCountries;
    private Set<ProductionCompany> productionCompanies;
    private String originalTitle;
    private String overview;
    private LocalDate releaseDate;
    private BigDecimal popularity;
    private String posterPath;
    private String backdropPath;
    private BigInteger budget;
    private BigInteger revenue;
    private Integer runtime;
    private String status;
    private String tagline;
    private BigDecimal voteAverage;
    private Integer voteCount;
    private Boolean adult;
    private Boolean video;
    private String homepage;
    private String imdbId;
    private String originalLanguage;

    @Builder(toBuilder = true)
    public Movie(
            Long id,
            String title,
            Set<Genre> genres,
            Set<SpokenLanguage> spokenLanguages,
            Set<OriginCountry> originCountries,
            Set<ProductionCompany> productionCompanies,
            String originalTitle,
            String overview,
            LocalDate releaseDate,
            BigDecimal popularity,
            String posterPath,
            String backdropPath,
            BigInteger budget,
            BigInteger revenue,
            Integer runtime,
            String status,
            String tagline,
            BigDecimal voteAverage,
            Integer voteCount,
            Boolean adult,
            Boolean video,
            String homepage,
            String imdbId,
            String originalLanguage
    ) {
        this.id = Objects.requireNonNull(id);
        this.title = Objects.requireNonNull(title);
        this.genres = Objects.requireNonNull(genres);
        this.spokenLanguages = Objects.requireNonNull(spokenLanguages);
        this.originCountries = Objects.requireNonNull(originCountries);
        this.productionCompanies = Objects.requireNonNull(productionCompanies);
        this.originalTitle = Objects.requireNonNull(originalTitle);
        this.overview = Objects.requireNonNull(overview);
        this.releaseDate = Objects.requireNonNull(releaseDate);
        this.popularity = Objects.requireNonNull(popularity);
        this.posterPath = Objects.requireNonNull(posterPath);
        this.backdropPath = Objects.requireNonNull(backdropPath);
        this.budget = Objects.requireNonNull(budget);
        this.revenue = Objects.requireNonNull(revenue);
        this.runtime = Objects.requireNonNull(runtime);
        this.status = Objects.requireNonNull(status);
        this.tagline = Objects.requireNonNull(tagline);
        this.voteAverage = Objects.requireNonNull(voteAverage);
        this.voteCount = Objects.requireNonNull(voteCount);
        this.adult = Objects.requireNonNull(adult);
        this.video = Objects.requireNonNull(video);
        this.homepage = Objects.requireNonNull(homepage);
        this.imdbId = Objects.requireNonNull(imdbId);
        this.originalLanguage = Objects.requireNonNull(originalLanguage);
    }
}
