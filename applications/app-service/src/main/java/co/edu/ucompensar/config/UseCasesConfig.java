package co.edu.ucompensar.config;

import co.edu.ucompensar.model.movie.gateways.SpokenLanguageRepository;
import co.edu.ucompensar.usecase.spokenlanguage.SpokenLanguageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.edu.ucompensar.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
    @Bean
    public SpokenLanguageUseCase spokenLanguageUseCase(SpokenLanguageRepository repository) {
        return new SpokenLanguageUseCase(repository);
    }
}
