package co.edu.ucompensar.api.model.mapper;

import co.edu.ucompensar.api.model.response.ProductionCountryResponse;
import co.edu.ucompensar.model.movie.entity.ProductionCountry;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductionCountryMapper {

    public ProductionCountryResponse toResponse(ProductionCountry domain) {
        if (domain == null) return null;
        return ProductionCountryResponse.builder()
                .iso31661(domain.getIso31661())
                .name(domain.getName())
                .build();
    }

    public List<ProductionCountryResponse> toResponseList(List<ProductionCountry> domainList) {
        return domainList.stream()
                         .map(this::toResponse)
                         .collect(Collectors.toList());
    }
}