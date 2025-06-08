package thiagoespindula00.jnmodasgestao.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thiagoespindula00.jnmodasgestao.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
