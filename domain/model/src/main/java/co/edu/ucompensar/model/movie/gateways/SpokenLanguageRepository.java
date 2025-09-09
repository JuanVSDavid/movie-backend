package co.edu.ucompensar.model.movie.gateways;

import co.edu.ucompensar.model.movie.entity.SpokenLanguage;

import java.util.List;
import java.util.Optional;


public interface SpokenLanguageRepository {
    List<SpokenLanguage> findAll();
    Optional<SpokenLanguage> findById(String iso6391);
    SpokenLanguage save(SpokenLanguage language);
    void deleteById(String iso6391);
}
