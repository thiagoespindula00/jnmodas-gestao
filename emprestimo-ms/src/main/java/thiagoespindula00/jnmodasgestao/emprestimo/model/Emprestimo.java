package thiagoespindula00.jnmodasgestao.emprestimo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long produtoId;

    @Column(nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private Date dataCriacao;

    @Column(nullable = false)
    private Date dataDevolucao;

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    private List<ItemEmprestimo> itens;
}
