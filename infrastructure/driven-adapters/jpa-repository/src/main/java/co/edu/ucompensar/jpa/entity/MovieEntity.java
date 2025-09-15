package co.edu.ucompensar.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column(name = "original_title")
    private String originalTitle;
    @Column
    private String overview;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column
    private BigDecimal popularity;
    @Column(name = "poster_path")
    private String posterPath;
    @Column(name = "backdrop_path")
    private String backdropPath;
    @Column
    private BigInteger budget;
    @Column
    private BigInteger revenue;
    @Column
    private Integer runtime;
    @Column
    private String status;
    @Column
    private String tagline;
    @Column(name = "vote_average")
    private BigDecimal voteAverage;
    @Column(name = "vote_count")
    private Integer voteCount;
    @Column
    private Boolean adult;
    @Column
    private Boolean video;
    @Column
    private String homepage;
    @Column(name = "imdb_id")
    private String imdbId;
    @Column(name = "original_language")
    private String originalLanguage;


    @ManyToMany
    @JoinTable(
            name = "movie_spoken_languages",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "language_iso")
    )
    private Set<SpokenLanguageEntity> spokenLanguages = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "movie_origin_countries",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_code")
    )
    private Set<OriginCountryEntity> originCountries = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreEntity> genres = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "movie_production_companies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<ProductionCompanyEntity> productionCompanies = new HashSet<>();

//    @ManyToMany
//    @JoinTable(
//            name = "movie_production_countries",
//            joinColumns = @JoinColumn(name = "movie_id"),
//            inverseJoinColumns = @JoinColumn(name = "country_iso")
//    )
//    private Set<GenreEntity> productionCountries = new HashSet<>();
}
