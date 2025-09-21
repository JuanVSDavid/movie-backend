package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.api.model.mapper.ProductionCountryMapper;
import co.edu.ucompensar.api.model.response.ProductionCountryResponse;
import co.edu.ucompensar.model.movie.entity.ProductionCountry;
import co.edu.ucompensar.usecase.productioncountry.ProductionCountryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/production-countries")
@RequiredArgsConstructor
public class ProductionCountryController {

    private final ProductionCountryUseCase productionCountryUseCase;
    private final ProductionCountryMapper responseMapper;

    @PostMapping
    public ResponseEntity<ProductionCountryResponse> create(@RequestBody ProductionCountry request) {
        ProductionCountry created = productionCountryUseCase.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMapper.toResponse(created));
    }

    @GetMapping("/{isoCode}")
    public ResponseEntity<ProductionCountryResponse> getByIsoCode(@PathVariable String isoCode) {
        return productionCountryUseCase.findById(isoCode)
                .map(country -> ResponseEntity.ok(responseMapper.toResponse(country)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductionCountryResponse>> getAll() {
        List<ProductionCountry> countries = productionCountryUseCase.findAll();
        return ResponseEntity.ok(responseMapper.toResponseList(countries));
    }

    @DeleteMapping("/{isoCode}")
    public ResponseEntity<Void> delete(@PathVariable String isoCode) {
        try {
            productionCountryUseCase.deleteById(isoCode);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}