package co.edu.ucompensar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "production_countries")
public class ProductionCountryEntity {

    @Id
    @Column(name = "iso_3166_1")
    private String iso31661;

    @Column(nullable = false)
    private String name;
}