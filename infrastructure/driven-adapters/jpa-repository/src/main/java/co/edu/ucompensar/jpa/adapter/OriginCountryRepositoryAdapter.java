package co.edu.ucompensar.jpa.adapter;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.OriginCountryEntity;
import co.edu.ucompensar.jpa.repository.OriginCountryEntityRepository;
import co.edu.ucompensar.model.movie.entity.OriginCountry;
import co.edu.ucompensar.model.movie.gateways.OriginCountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OriginCountryRepositoryAdapter implements OriginCountryRepository {
    private final DomainEntityMapper<OriginCountry, OriginCountryEntity> mapper;
    private final OriginCountryEntityRepository repository;

    @Override
    public List<OriginCountry> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<OriginCountry> findById(String code) {
        return repository.findById(code).map(mapper::toDomain);
    }

    @Override
    public OriginCountry save(OriginCountry country) {
        OriginCountryEntity entity = mapper.toEntity(country);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deleteById(String code) {
        repository.deleteById(code);
    }
}
