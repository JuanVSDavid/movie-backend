package co.edu.ucompensar.api.model.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class MovieResponse {
    private Long id;
    private String title;
    private Set<Long> genresId;
    private String overview;
    private LocalDate releaseDate;
    private Set<Long> spokenLanguagesId;
    private Set<Long> originCountriesId;
}