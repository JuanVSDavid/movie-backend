package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.entity.ProductionCompany;

import java.util.List;
import java.util.Optional;

public interface ProductionCompanyRepository {
    List<ProductionCompany> findAll();
    Optional<ProductionCompany> findById(Long id);
    ProductionCompany save(ProductionCompany country);
    void deleteById(Long id);
}
