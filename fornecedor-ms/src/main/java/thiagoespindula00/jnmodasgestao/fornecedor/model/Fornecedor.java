package thiagoespindula00.jnmodasgestao.fornecedor.model;

import jakarta.persistence.*;

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
}
