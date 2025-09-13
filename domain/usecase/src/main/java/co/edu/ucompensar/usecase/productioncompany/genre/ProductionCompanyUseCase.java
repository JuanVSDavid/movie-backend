package co.edu.ucompensar.usecase.productioncompany.genre;

import co.edu.ucompensar.model.movie.entity.ProductionCompany;
import co.edu.ucompensar.model.movie.gateways.ProductionCompanyRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductionCompanyUseCase {
    private final ProductionCompanyRepository repository;

    public List<ProductionCompany> findAll() {
        return repository.findAll();
    }

    public Optional<ProductionCompany> findById(Long id) {
        return repository.findById(id);
    }

    public ProductionCompany save(ProductionCompany language) {
        return repository.save(language);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
