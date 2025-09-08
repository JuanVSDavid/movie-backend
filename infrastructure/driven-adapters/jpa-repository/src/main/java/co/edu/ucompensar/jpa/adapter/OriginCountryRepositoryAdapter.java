package co.edu.ucompensar.jpa.adapter;

import co.edu.ucompensar.jpa.entity.OriginCountryEntity;
import co.edu.ucompensar.jpa.mapper.MovieDomainEntityMapper;
import co.edu.ucompensar.jpa.repository.OriginCountryDataRepository;
import co.edu.ucompensar.model.movie.entity.OriginCountry;
import co.edu.ucompensar.model.movie.gateways.OriginCountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OriginCountryRepositoryAdapter implements OriginCountryRepository {

    private final OriginCountryDataRepository repository;

    @Override
    public List<OriginCountry> findAll() {
        return repository.findAll()
                .stream()
                .map(MovieDomainEntityMapper::toDomainCountry)
                .toList();
    }

    @Override
    public Optional<OriginCountry> findById(String code) {
        return repository.findById(code).map(MovieDomainEntityMapper::toDomainCountry);
    }

    @Override
    public OriginCountry save(OriginCountry country) {
        OriginCountryEntity entity = MovieDomainEntityMapper.toEntityCountry(country);
        return MovieDomainEntityMapper.toDomainCountry(repository.save(entity));
    }

    @Override
    public void deleteById(String code) {
        repository.deleteById(code);
    }
}
