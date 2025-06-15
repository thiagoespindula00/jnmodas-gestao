package thiagoespindula00.jnmodasgestao.emprestimo.model;

import jakarta.persistence.*;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.EmprestimoRequestDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.ItemEmprestimoRequestDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private LocalDate dataCriacao;

    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEmprestimo> itens;

    public Emprestimo() {

    }

    private Emprestimo(EmprestimoRequestDTO emprestimoRequestDTO) {
        this.clienteId = emprestimoRequestDTO.clienteId();
        this.dataCriacao = LocalDate.now();
        this.status = StatusEmprestimo.PENDENTE;
        this.itens = emprestimoRequestDTO.itens().stream()
                .map(ItemEmprestimo::fromDto)
                .peek(item -> item.setEmprestimo(this))
                .collect(Collectors.toList());
    }

    public static Emprestimo fromDto(EmprestimoRequestDTO emprestimoRequestDTO) {
        return new Emprestimo(emprestimoRequestDTO);
    }

    public void setCampos(EmprestimoRequestDTO emprestimoRequestDTO) {
        this.clienteId = emprestimoRequestDTO.clienteId();
        this.itens.clear();
        for (ItemEmprestimoRequestDTO item : emprestimoRequestDTO.itens()) {
            ItemEmprestimo itemEmprestimo = ItemEmprestimo.fromDto(item);
            itemEmprestimo.setEmprestimo(this);
            this.itens.add(itemEmprestimo);
        }
    }

    public void realizarDevolucao() {
        this.dataDevolucao = LocalDate.now();
        this.status = StatusEmprestimo.DEVOLVIDO;
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public List<ItemEmprestimo> getItens() {
        return itens;
    }
}
