package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import co.edu.ucompensar.usecase.spokenlanguage.SpokenLanguageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spoken-languages")
@RequiredArgsConstructor
public class SpokenLanguageController {

    private final SpokenLanguageUseCase useCase;

    @GetMapping
    public List<SpokenLanguage> getAll() {
        return useCase.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpokenLanguage> getById(@PathVariable String id) {
        return useCase.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SpokenLanguage> create(@RequestBody SpokenLanguage language) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.save(language));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpokenLanguage> update(@PathVariable String id, @RequestBody SpokenLanguage language) {
        if (useCase.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        language.setIso6391(id);
        return ResponseEntity.ok(useCase.save(language));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (useCase.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        useCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
