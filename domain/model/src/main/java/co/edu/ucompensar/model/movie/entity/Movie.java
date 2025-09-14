package co.edu.ucompensar.model.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long id;
    private String title;
    private String originalTitle;
    private String overview;
    private LocalDate releaseDate;
    private String posterPath;
    private String backdropPath;
    private Long budget;
    private Long revenue;
    private Integer runtime;
    private String status;
    private String tagline;
    private Integer voteCount;
    private Boolean adult;
    private Boolean video;
    private String homepage;
    private String imdbId;
    private String originalLanguage;

    private BigDecimal voteAverage;
    private BigDecimal popularity;

    private Set<Genre> genres;
    private Set<ProductionCompany> productionCompanies;
    private Set<ProductionCountry> productionCountries;
    private Set<SpokenLanguage> spokenLanguages;
    private Set<OriginCountry> originCountries;
}