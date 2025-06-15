package thiagoespindula00.jnmodasgestao.emprestimo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EmprestimoRequestDTO(
        @NotNull
        Long clienteId,

        @NotNull
        @Valid
        List<ItemEmprestimoRequestDTO> itens
) {
}
