package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.GenreEntity;
import co.edu.ucompensar.jpa.entity.OriginCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreEntityRepository extends JpaRepository<GenreEntity, Long> {
}
