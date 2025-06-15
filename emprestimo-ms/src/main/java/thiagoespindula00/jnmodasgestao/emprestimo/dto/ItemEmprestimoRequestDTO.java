package thiagoespindula00.jnmodasgestao.emprestimo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemEmprestimoRequestDTO(
        @NotNull
        Long produtoId,

        @Positive
        @NotNull
        Integer quantidade
) {
}
