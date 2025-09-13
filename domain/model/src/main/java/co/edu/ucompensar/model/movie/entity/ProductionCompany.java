package co.edu.ucompensar.model.movie.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class ProductionCompany {
    private Long id;
    private String name;

    @Builder
    public ProductionCompany(Long id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
    }

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
