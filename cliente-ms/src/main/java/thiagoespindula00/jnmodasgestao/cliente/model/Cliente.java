package thiagoespindula00.jnmodasgestao.cliente.model;

import jakarta.persistence.*;

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
}
