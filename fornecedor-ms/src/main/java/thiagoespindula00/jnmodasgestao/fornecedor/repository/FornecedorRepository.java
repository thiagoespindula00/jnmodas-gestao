package thiagoespindula00.jnmodasgestao.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thiagoespindula00.jnmodasgestao.fornecedor.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    boolean existsByCnpj(String cnpj);
    boolean existsByEmail(String email);
}
