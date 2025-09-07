package co.edu.ucompensar.usecase.spokenlanguage;

import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import co.edu.ucompensar.model.movie.gateways.SpokenLanguageRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SpokenLanguageUseCase {

    private final SpokenLanguageRepository repository;

    public List<SpokenLanguage> findAll() {
        return repository.findAll();
    }

    public Optional<SpokenLanguage> findById(String iso6391) {
        return repository.findById(iso6391);
    }

    public SpokenLanguage save(SpokenLanguage language) {
        return repository.save(language);
    }

    public void deleteById(String iso6391) {
        repository.deleteById(iso6391);
    }
}