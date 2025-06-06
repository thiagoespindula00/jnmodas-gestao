package thiagoespindula00.jnmodasgestao.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thiagoespindula00.jnmodasgestao.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByCodigo(String codigo);
}
