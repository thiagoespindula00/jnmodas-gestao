package thiagoespindula00.jnmodasgestao.fornecedor.dto;


import thiagoespindula00.jnmodasgestao.fornecedor.model.Fornecedor;

public record FornecedorDetalhesDTO(
        Long id,
        String cnpj,
        String nome,
        String email,
        String telefone,
        EnderecoDetalhesDTO endereco
) {
    public static FornecedorDetalhesDTO fromEntity(Fornecedor fornecedor) {
        return new FornecedorDetalhesDTO(
                fornecedor.getId(),
                fornecedor.getCnpj(),
                fornecedor.getNome(),
                fornecedor.getEmail(),
                fornecedor.getTelefone(),
                EnderecoDetalhesDTO.fromEntity(fornecedor.getEndereco())
        );
    }
}
