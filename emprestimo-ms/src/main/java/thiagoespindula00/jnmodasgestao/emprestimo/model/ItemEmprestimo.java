package thiagoespindula00.jnmodasgestao.emprestimo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_emprestimo")
public class ItemEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emprestimo_id", nullable = false)
    private Emprestimo emprestimo;

    @Column(nullable = false)
    private Long produtoId;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = false)
    private double preco;
}
