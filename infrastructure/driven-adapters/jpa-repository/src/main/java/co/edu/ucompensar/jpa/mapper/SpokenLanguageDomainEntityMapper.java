package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.SpokenLanguageEntity;
import co.edu.ucompensar.model.movie.entity.SpokenLanguage;
import org.springframework.stereotype.Component;

@Component
public class SpokenLanguageDomainEntityMapper implements DomainEntityMapper<SpokenLanguage, SpokenLanguageEntity> {

    public SpokenLanguage toDomain(SpokenLanguageEntity entity) {
        if (entity == null) return null;
        return SpokenLanguage.builder()
                .iso6391(entity.getIso6391())
                .name(entity.getName())
                .englishName(entity.getEnglishName())
                .build();
    }

    public SpokenLanguageEntity toEntity(SpokenLanguage domain) {
        if (domain == null) return null;
        return SpokenLanguageEntity.builder()
                .iso6391(domain.getIso6391())
                .name(domain.getName())
                .englishName(domain.getEnglishName())
                .build();
    }
}