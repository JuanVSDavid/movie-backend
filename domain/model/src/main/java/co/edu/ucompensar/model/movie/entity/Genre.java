package co.edu.ucompensar.model.movie.entity;

import lombok.Builder;

import java.util.Objects;

@Builder
public class Genre {
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
