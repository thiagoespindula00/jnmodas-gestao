package thiagoespindula00.jnmodasgestao.cliente.model;

import jakarta.persistence.*;
import thiagoespindula00.jnmodasgestao.cliente.dto.ClienteRequestDTO;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(length = 100)
    private String nome;

    @Column(length = 255, unique = true)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Cliente() {

    }

    private Cliente(ClienteRequestDTO clienteRequestDTO) {
        this.setCampos(clienteRequestDTO);
    }

    public static Cliente fromDTO(ClienteRequestDTO clienteRequestDTO) {
        return new Cliente(clienteRequestDTO);
    }

    public void setCampos(ClienteRequestDTO clienteRequestDTO) {
        this.cpf = clienteRequestDTO.cpf();
        this.nome = clienteRequestDTO.nome();
        this.email = clienteRequestDTO.email();
        this.telefone = clienteRequestDTO.telefone();
        this.endereco = Endereco.fromDTO(clienteRequestDTO.endereco());
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
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
