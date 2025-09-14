package co.edu.ucompensar.jpa.adapter;

import co.edu.ucompensar.jpa.mapper.ProductionCountryDomainEntityMapper;
import co.edu.ucompensar.jpa.repository.ProductionCountryJpaRepository;
import co.edu.ucompensar.model.movie.entity.ProductionCountry;
import co.edu.ucompensar.model.movie.gateways.ProductionCountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductionCountryRepositoryAdapter implements ProductionCountryRepository {

    private final ProductionCountryJpaRepository jpaRepository;
    private final ProductionCountryDomainEntityMapper mapper;

    @Override
    @Transactional
    public ProductionCountry save(ProductionCountry productionCountry) {
        var entity = mapper.toEntity(productionCountry);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductionCountry> findById(String isoCode) {
        return jpaRepository.findById(isoCode)
                .map(mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductionCountry> findAll() {
        return mapper.toDomainList(jpaRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteById(String isoCode) {
        if (!jpaRepository.existsById(isoCode)) {
            throw new RuntimeException("Production Country with code " + isoCode + " not found.");
        }
        jpaRepository.deleteById(isoCode);
    }
}