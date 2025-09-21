package co.edu.ucompensar.usecase.productioncountry;

import co.edu.ucompensar.model.movie.entity.ProductionCountry;
import co.edu.ucompensar.model.movie.gateways.ProductionCountryRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductionCountryUseCase {

    private final ProductionCountryRepository productionCountryRepository;

    public ProductionCountry create(ProductionCountry productionCountry) {
        return productionCountryRepository.save(productionCountry);
    }

    public Optional<ProductionCountry> findById(String isoCode) {
        return productionCountryRepository.findById(isoCode);
    }

    public List<ProductionCountry> findAll() {
        return productionCountryRepository.findAll();
    }

    public void deleteById(String isoCode) {
        productionCountryRepository.deleteById(isoCode);
    }
}