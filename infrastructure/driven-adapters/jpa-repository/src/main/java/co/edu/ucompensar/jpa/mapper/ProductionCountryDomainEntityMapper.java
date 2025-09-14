package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.ProductionCountryData; // Asegúrate de haberla renombrado a 'Data'
import co.edu.ucompensar.model.movie.entity.ProductionCountry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component // Para que Spring pueda inyectarlo
public class ProductionCountryDomainEntityMapper implements DomainEntityMapper<ProductionCountry, ProductionCountryData> {

    @Override
    public ProductionCountryData toEntity(ProductionCountry domain) {
        if (domain == null) return null;

        ProductionCountryData entity = new ProductionCountryData();
        entity.setIso31661(domain.getIso31661());
        entity.setName(domain.getName());
        return entity;
    }

    @Override
    public ProductionCountry toDomain(ProductionCountryData entity) {
        if (entity == null) return null;

        return ProductionCountry.builder()
                .iso31661(entity.getIso31661())
                .name(entity.getName())
                .build();
    }

    // Métodos de ayuda para listas
    public List<ProductionCountry> toDomainList(List<ProductionCountryData> entityList) {
        return entityList.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}