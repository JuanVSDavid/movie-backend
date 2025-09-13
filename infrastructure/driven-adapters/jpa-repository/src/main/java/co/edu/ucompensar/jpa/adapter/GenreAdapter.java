package co.edu.ucompensar.jpa.adapter;
import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.GenreEntity;
import co.edu.ucompensar.jpa.repository.GenreEntityRepository;
import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.gateways.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GenreAdapter implements GenreRepository {

    private final GenreEntityRepository repository;
    private final DomainEntityMapper<Genre, GenreEntity> mapper;

    @Override
    public List<Genre> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Genre save(Genre language) {
        var entity = mapper.toEntity(language);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
