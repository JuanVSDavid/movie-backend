package co.edu.ucompensar.usecase.genre;

import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.gateways.GenreRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class GenreUseCase {
    private final GenreRepository repository;

    public List<Genre> findAll() {
        return repository.findAll();
    }

    public Optional<Genre> findById(Long id) {
        return repository.findById(id);
    }

    public Genre save(Genre language) {
        return repository.save(language);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
