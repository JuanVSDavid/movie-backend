package co.edu.ucompensar.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
public class DatesResponse {
    private final String maximum = LocalDate.now().toString();
    private final String minimum = LocalDate.now().minusYears(1L).toString();
}
