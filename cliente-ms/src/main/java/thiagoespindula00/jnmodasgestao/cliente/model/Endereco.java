package thiagoespindula00.jnmodasgestao.cliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import thiagoespindula00.jnmodasgestao.cliente.dto.EnderecoRequestDTO;

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

    public Endereco() {

    }

    private Endereco(EnderecoRequestDTO enderecoRequestDTO) {
        this.setCampos(enderecoRequestDTO);
    }

    public static Endereco fromDTO(EnderecoRequestDTO enderecoRequestDTO) {
        return new Endereco(enderecoRequestDTO);
    }

    public void setCampos(EnderecoRequestDTO enderecoRequestDTO) {
        this.cep = enderecoRequestDTO.cep();
        this.cidade = enderecoRequestDTO.cidade();
        this.rua = enderecoRequestDTO.rua();
        this.numero = enderecoRequestDTO.numero();
        this.complemento = enderecoRequestDTO.complemento();
        this.bairro = enderecoRequestDTO.bairro();
        this.estado = enderecoRequestDTO.estado();
        this.pais = enderecoRequestDTO.pais();
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }
}
