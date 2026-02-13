package co.edu.ucompensar.api.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductionCountryResponse {
    private String iso31661;
    private String name;
}