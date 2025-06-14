package thiagoespindula00.jnmodasgestao.emprestimo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class AutoWiredConfiguration {
    @Bean
    public UriComponentsBuilder uriComponentsBuilder() {
        return UriComponentsBuilder.newInstance();
    }
}
