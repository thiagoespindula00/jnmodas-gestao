package thiagoespindula00.jnmodasgestao.emprestimo.dto;

import thiagoespindula00.jnmodasgestao.emprestimo.model.ItemEmprestimo;

public record ItemEmprestimoDetalhesDTO(
        Long id,
        Long produtoId,
        Integer quantidade,
        double preco
) {
    public static ItemEmprestimoDetalhesDTO fromEntity(ItemEmprestimo item) {
        return new ItemEmprestimoDetalhesDTO(
                item.getId(),
                item.getProdutoId(),
                item.getQuantidade(),
                item.getPreco()
        );
    }
}
