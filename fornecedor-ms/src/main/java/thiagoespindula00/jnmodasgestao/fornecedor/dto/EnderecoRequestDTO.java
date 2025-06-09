package thiagoespindula00.jnmodasgestao.fornecedor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EnderecoRequestDTO(
        @Size(max = 8, min = 8)
        @NotBlank
        String cep,

        @Size(max = 50, min = 2)
        @NotBlank
        String cidade,

        @Size(max = 50, min = 2)
        @NotBlank
        String rua,

        @Size(max = 10)
        @NotBlank
        String numero,

        @Size(max = 60)
        @NotNull
        String complemento,

        @Size(max = 50, min = 2)
        @NotBlank
        String bairro,

        @Size(min = 2, max = 2)
        @NotBlank
        String estado,

        @Size(max = 50, min = 2)
        @NotBlank
        String pais
) {
}
