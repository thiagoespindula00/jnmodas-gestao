package thiagoespindula00.jnmodasgestao.emprestimo.feign_client.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente")
public interface ClienteClient {
    @GetMapping("/{id}")
    ClienteResponseDTO getCliente(@PathVariable("id") Long id);
}
