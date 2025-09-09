package co.edu.ucompensar.usecase.origincountry;

import co.edu.ucompensar.model.movie.entity.OriginCountry;
import co.edu.ucompensar.model.movie.gateways.OriginCountryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OriginCountryUseCase {

    private final OriginCountryRepository repository;

    public List<OriginCountry> findAll() {
        return repository.findAll();
    }

    public Optional<OriginCountry> findById(String code) {
        return repository.findById(code);
    }

    public OriginCountry save(OriginCountry country) {
        return repository.save(country);
    }

    public void deleteById(String code) {
        repository.deleteById(code);
    }
}
