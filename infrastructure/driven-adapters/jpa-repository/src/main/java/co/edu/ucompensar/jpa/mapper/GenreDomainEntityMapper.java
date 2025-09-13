package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.GenreEntity;
import co.edu.ucompensar.model.movie.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreDomainEntityMapper implements DomainEntityMapper<Genre, GenreEntity> {
    @Override
    public GenreEntity toEntity(Genre genre) {
        return GenreEntity.builder().id(genre.getId()).name(genre.getName()).build();
    }

    @Override
    public Genre toDomain(GenreEntity genreEntity) {
        return Genre.builder().id(genreEntity.getId()).name(genreEntity.getName()).build();
    }
}
