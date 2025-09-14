package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.ProductionCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCountryJpaRepository extends JpaRepository<ProductionCountryEntity, String> {
    // <Entidad, Tipo de la Clave Primaria>
}