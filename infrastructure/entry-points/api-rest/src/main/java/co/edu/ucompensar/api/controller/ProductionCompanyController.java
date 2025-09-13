package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.model.movie.entity.Genre;
import co.edu.ucompensar.model.movie.entity.ProductionCompany;
import co.edu.ucompensar.usecase.genre.GenreUseCase;
import co.edu.ucompensar.usecase.productioncompany.genre.ProductionCompanyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production-companies")
@RequiredArgsConstructor
public class ProductionCompanyController {

    private final ProductionCompanyUseCase useCase;

    @GetMapping
    public List<ProductionCompany> getAll() {
        return useCase.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionCompany> getById(@PathVariable Long id) {
        return useCase.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductionCompany> create(@RequestBody ProductionCompany productionCompany) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.save(productionCompany));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductionCompany> update(@PathVariable Long id, @RequestBody ProductionCompany productionCompany) {
        if (useCase.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productionCompany.setId(id);
        return ResponseEntity.ok(useCase.save(productionCompany));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (useCase.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        useCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
