package thiagoespindula00.jnmodasgestao.fornecedor.model;

import jakarta.persistence.*;
import thiagoespindula00.jnmodasgestao.fornecedor.dto.FornecedorRequestDTO;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 14)
    private String cnpj;

    @Column(length = 100)
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Fornecedor() {}

    private Fornecedor(FornecedorRequestDTO fornecedorRequestDTO) {
        this.setCampos(fornecedorRequestDTO);
    }

    public static Fornecedor fromDto(FornecedorRequestDTO fornecedorRequestDTO) {
        return new Fornecedor(fornecedorRequestDTO);
    }

    public void setCampos(FornecedorRequestDTO fornecedorRequestDTO) {
        this.cnpj = fornecedorRequestDTO.cnpj();
        this.nome = fornecedorRequestDTO.nome();
        this.email = fornecedorRequestDTO.email();
        this.telefone = fornecedorRequestDTO.telefone();
        this.endereco = Endereco.fromDto(fornecedorRequestDTO.endereco());
    }

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
