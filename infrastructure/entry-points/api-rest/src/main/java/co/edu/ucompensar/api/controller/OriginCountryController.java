package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.model.movie.entity.OriginCountry;
import co.edu.ucompensar.usecase.origincountry.OriginCountryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/origin-countries")
@RequiredArgsConstructor
public class OriginCountryController {

    private final OriginCountryUseCase useCase;

    @GetMapping
    public ResponseEntity<List<OriginCountry>> getAll() {
        return ResponseEntity.ok(useCase.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<OriginCountry> getById(@PathVariable String code) {
        return useCase.findById(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OriginCountry> create(@RequestBody OriginCountry country) {
        return ResponseEntity.ok(useCase.save(country));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        useCase.deleteById(code);
        return ResponseEntity.noContent().build();
    }
}