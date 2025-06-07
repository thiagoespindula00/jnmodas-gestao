package thiagoespindula00.jnmodasgestao.cliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    @Column(length = 8)
    private String cep;

    @Column(length = 50)
    private String cidade;

    @Column(length = 50)
    private String rua;

    @Column(length = 10)
    private String numero;

    @Column(length = 60)
    private String complemento;

    @Column(length = 50)
    private String bairro;

    @Column(length = 2)
    private String estado;

    @Column(length = 50)
    private String pais;

}
