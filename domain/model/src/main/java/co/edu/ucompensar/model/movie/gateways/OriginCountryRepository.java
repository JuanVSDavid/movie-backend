package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.entity.OriginCountry;

import java.util.List;
import java.util.Optional;

public interface OriginCountryRepository {
    List<OriginCountry> findAll();
    Optional<OriginCountry> findById(String code);
    OriginCountry save(OriginCountry country);
    void deleteById(String code);
}
