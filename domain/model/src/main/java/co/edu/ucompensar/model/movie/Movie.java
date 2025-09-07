package co.edu.ucompensar.model.movie;
import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import lombok.Builder;
import lombok.Getter;
//import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Getter
public class Movie {
    private Long id;
    private String title;
    private Set<Genre> genres;
    private Set<SpokenLanguage> spokenLanguages;

    @Builder(toBuilder = true)
    public Movie(Long id, String title, Set<Genre> genres, Set<SpokenLanguage> spokenLanguages) {
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.genres = genres;
        this.spokenLanguages = spokenLanguages;
    }
}
