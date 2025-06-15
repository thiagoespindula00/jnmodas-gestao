package thiagoespindula00.jnmodasgestao.emprestimo.model;

import jakarta.persistence.*;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.ItemEmprestimoRequestDTO;

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
    private Integer quantidade;

    @Column(name = "preco_total", nullable = false)
    private double preco;

    public ItemEmprestimo() {

    }

    private ItemEmprestimo(ItemEmprestimoRequestDTO itemEmprestimoRequestDTO) {
        this.setCampos(itemEmprestimoRequestDTO);
    }

    public static ItemEmprestimo fromDto(ItemEmprestimoRequestDTO itemEmprestimoRequestDTO) {
        return new ItemEmprestimo(itemEmprestimoRequestDTO);
    }

    public void setCampos(ItemEmprestimoRequestDTO itemEmprestimoRequestDTO) {
        this.produtoId = itemEmprestimoRequestDTO.produtoId();
        this.quantidade = itemEmprestimoRequestDTO.quantidade();
        this.preco = 0;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Long getId() {
        return id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
}
