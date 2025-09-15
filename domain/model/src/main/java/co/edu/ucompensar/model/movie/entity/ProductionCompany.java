package co.edu.ucompensar.model.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionCompany {
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductionCompany productionCompany = (ProductionCompany) o;
        return Objects.equals(name, productionCompany.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
