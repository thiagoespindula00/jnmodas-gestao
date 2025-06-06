package thiagoespindula00.jnmodasgestao.produto.model;


import jakarta.persistence.*;
import thiagoespindula00.jnmodasgestao.produto.dto.ProdutoRequestDTO;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String codigo;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double preco;

    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Departamento departamento;

    public Produto() {
    }

    private Produto(ProdutoRequestDTO produtoRequestDTO) {
        this.codigo = produtoRequestDTO.codigo();
        this.descricao = produtoRequestDTO.descricao();
        this.preco = produtoRequestDTO.preco();
        this.tamanho = produtoRequestDTO.tamanho();
        this.categoria = produtoRequestDTO.categoria();
        this.departamento = produtoRequestDTO.departamento();
    }

    public static Produto fromDTO(ProdutoRequestDTO produtoRequestDTO) {
        return new Produto(produtoRequestDTO);
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
