package co.edu.ucompensar.model.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class SpokenLanguage {
    private String iso6391;
    private String name;
    private String englishName;
}
