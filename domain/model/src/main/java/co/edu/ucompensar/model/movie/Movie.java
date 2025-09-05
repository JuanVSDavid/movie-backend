package co.edu.ucompensar.model.movie;
import co.edu.ucompensar.model.movie.entity.Genre;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
public class Movie {
    private Long id;
    private String title;
    private Set<Genre> genres;

    @Builder(toBuilder = true)
    public Movie(Long id, String title, Set<Genre> genres) {
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.genres = genres;
    }
}
