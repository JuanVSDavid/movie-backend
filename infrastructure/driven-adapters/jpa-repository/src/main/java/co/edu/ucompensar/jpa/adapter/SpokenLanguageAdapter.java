package co.edu.ucompensar.jpa.adapter;
import co.edu.ucompensar.jpa.entity.SpokenLanguageEntity;
import co.edu.ucompensar.jpa.mapper.SpokenLanguageDomainEntityMapper;
import co.edu.ucompensar.jpa.repository.SpokenLanguageEntityRepository;
import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import co.edu.ucompensar.model.movie.gateways.SpokenLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class SpokenLanguageAdapter implements SpokenLanguageRepository {

    private final SpokenLanguageEntityRepository repository;
    private final SpokenLanguageDomainEntityMapper mapper;

    @Override
    public List<SpokenLanguage> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<SpokenLanguage> findById(String iso6391) {
        return repository.findById(iso6391)
                .map(mapper::toDomain);
    }

    @Override
    public SpokenLanguage save(SpokenLanguage language) {
        SpokenLanguageEntity entity = mapper.toEntity(language);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deleteById(String iso6391) {
        repository.deleteById(iso6391);
    }
}
