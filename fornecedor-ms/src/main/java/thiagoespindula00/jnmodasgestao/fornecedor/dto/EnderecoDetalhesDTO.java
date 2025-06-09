package thiagoespindula00.jnmodasgestao.fornecedor.dto;


import thiagoespindula00.jnmodasgestao.fornecedor.model.Endereco;

public record EnderecoDetalhesDTO(
        String cep,
        String cidade,
        String rua,
        String numero,
        String complemento,
        String bairro,
        String estado,
        String pais
) {
    public static EnderecoDetalhesDTO fromEntity(Endereco endereco) {
        return new EnderecoDetalhesDTO(
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getEstado(),
                endereco.getPais()
        );
    }
}
