package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.OriginCountryEntity;
import co.edu.ucompensar.model.movie.entity.OriginCountry;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OriginCountryDomainEntityMapper implements DomainEntityMapper<OriginCountry, OriginCountryEntity> {


    public OriginCountry toDomain(OriginCountryEntity entity) {
        if (entity == null) return null;
        return OriginCountry.builder().code(entity.getCode()).build();
    }

    public OriginCountryEntity toEntity(OriginCountry domain) {
        if (domain == null) return null;
        return OriginCountryEntity.builder().code(domain.getCode()).build();
    }

}
