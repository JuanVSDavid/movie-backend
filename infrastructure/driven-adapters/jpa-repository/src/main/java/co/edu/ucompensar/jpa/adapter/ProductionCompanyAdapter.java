package co.edu.ucompensar.jpa.adapter;
import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.ProductionCompanyEntity;
import co.edu.ucompensar.jpa.repository.ProductionCompanyEntityRepository;
import co.edu.ucompensar.model.movie.entity.ProductionCompany;
import co.edu.ucompensar.model.movie.gateways.ProductionCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductionCompanyAdapter implements ProductionCompanyRepository {
    private final ProductionCompanyEntityRepository repository;
    private final DomainEntityMapper<ProductionCompany, ProductionCompanyEntity> mapper;

    @Override
    public List<ProductionCompany> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<ProductionCompany> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public ProductionCompany save(ProductionCompany language) {
        var entity = mapper.toEntity(language);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
