package co.edu.ucompensar.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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
    @Column
    private LocalDateTime releaseDate;
    @Column
    private BigDecimal voteAverage;
    @Column
    private BigDecimal popularity;

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
}
