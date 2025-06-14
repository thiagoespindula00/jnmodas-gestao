package thiagoespindula00.jnmodasgestao.emprestimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmprestimoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmprestimoApplication.class, args);
    }
}
