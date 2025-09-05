package co.edu.ucompensar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class MovieEntity {
    @Id
    private Long id;
    private String title;
//    @Column(name = "poster_path")
//    private String posterPath;
}
