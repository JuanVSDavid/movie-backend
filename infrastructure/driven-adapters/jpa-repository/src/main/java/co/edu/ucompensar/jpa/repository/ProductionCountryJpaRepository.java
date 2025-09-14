package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.ProductionCountryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCountryJpaRepository extends JpaRepository<ProductionCountryData, String> {
    // <Entidad, Tipo de la Clave Primaria>
}