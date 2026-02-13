package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.entity.ProductionCountry;

import java.util.List;
import java.util.Optional;

public interface ProductionCountryRepository {
    ProductionCountry save(ProductionCountry productionCountry);

    Optional<ProductionCountry> findById(String isoCode);
    List<ProductionCountry> findAll();

    void deleteById(String isoCode);
}
