package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.ProductionCompanyEntity;
import co.edu.ucompensar.model.movie.entity.ProductionCompany;
import org.springframework.stereotype.Component;

@Component
public class ProductionCompanyDomainEntityMapper implements DomainEntityMapper<ProductionCompany, ProductionCompanyEntity> {
    @Override
    public ProductionCompanyEntity toEntity(ProductionCompany productionCompany) {
        return ProductionCompanyEntity.builder().id(productionCompany.getId()).name(productionCompany.getName()).build();
    }

    @Override
    public ProductionCompany toDomain(ProductionCompanyEntity productionCompanyEntity) {
        return ProductionCompany.builder().id(productionCompanyEntity.getId()).name(productionCompanyEntity.getName()).build();
    }
}
