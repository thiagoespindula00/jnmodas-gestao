package thiagoespindula00.jnmodasgestao.produto.dto;

import thiagoespindula00.jnmodasgestao.produto.model.Categoria;
import thiagoespindula00.jnmodasgestao.produto.model.Departamento;
import thiagoespindula00.jnmodasgestao.produto.model.Produto;
import thiagoespindula00.jnmodasgestao.produto.model.Tamanho;

public record ProdutoDetalhesDTO(
        Long id,
        String codigo,
        String descricao,
        double preco,
        Tamanho tamanho,
        Categoria categoria,
        Departamento departamento
) {
    public static ProdutoDetalhesDTO fromEntity(Produto produto) {
        return new ProdutoDetalhesDTO(
                produto.getId(),
                produto.getCodigo(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getTamanho(),
                produto.getCategoria(),
                produto.getDepartamento()
        );
    }
}
