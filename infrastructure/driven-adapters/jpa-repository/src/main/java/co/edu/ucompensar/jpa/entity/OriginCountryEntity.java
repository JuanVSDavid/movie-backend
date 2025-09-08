package co.edu.ucompensar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "origin_countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OriginCountryEntity {
    @Id
    @Column(name = "code", length = 10)
    private String code;
}
