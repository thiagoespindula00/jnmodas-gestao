package thiagoespindula00.jnmodasgestao.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import thiagoespindula00.jnmodasgestao.produto.model.Categoria;
import thiagoespindula00.jnmodasgestao.produto.model.Departamento;
import thiagoespindula00.jnmodasgestao.produto.model.Tamanho;

public record ProdutoRequestDTO(
        @NotBlank
        @Size(min = 2, max = 50)
        String codigo,
        @NotBlank
        @Size(min = 2, max = 255)
        String descricao,
        @Positive
        double preco,
        @NotNull
        Tamanho tamanho,
        @NotNull
        Categoria categoria,
        @NotNull
        Departamento departamento
) {
}
