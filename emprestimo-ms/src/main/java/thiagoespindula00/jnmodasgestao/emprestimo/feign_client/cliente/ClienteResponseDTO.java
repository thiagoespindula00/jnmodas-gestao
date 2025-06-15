package thiagoespindula00.jnmodasgestao.emprestimo.feign_client.cliente;

public record ClienteResponseDTO(
        Long id,
        String cpf,
        String nome
) {
}
