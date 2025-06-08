package thiagoespindula00.jnmodasgestao.cliente.dto;

import thiagoespindula00.jnmodasgestao.cliente.model.Cliente;

public record ClienteDetalhesDTO(
        Long id,
        String cpf,
        String nome,
        String email,
        String telefone,
        EnderecoDetalhesDTO endereco
) {
    public static ClienteDetalhesDTO fromEntity(Cliente cliente) {
        return new ClienteDetalhesDTO(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                EnderecoDetalhesDTO.fromEntity(cliente.getEndereco())
        );
    }
}
