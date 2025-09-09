package co.edu.ucompensar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "spoken_languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpokenLanguageEntity {
    @Id
    @Column(name = "iso_639_1", length = 5)
    private String iso6391;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "english_name", length = 100)
    private String englishName;
}