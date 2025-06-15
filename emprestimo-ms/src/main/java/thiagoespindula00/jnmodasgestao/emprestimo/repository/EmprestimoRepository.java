package thiagoespindula00.jnmodasgestao.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thiagoespindula00.jnmodasgestao.emprestimo.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
