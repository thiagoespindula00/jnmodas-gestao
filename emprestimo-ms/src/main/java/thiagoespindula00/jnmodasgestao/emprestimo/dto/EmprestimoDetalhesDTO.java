package thiagoespindula00.jnmodasgestao.emprestimo.dto;

import thiagoespindula00.jnmodasgestao.emprestimo.model.Emprestimo;
import thiagoespindula00.jnmodasgestao.emprestimo.model.StatusEmprestimo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public record EmprestimoDetalhesDTO(
        Long id,
        Long clienteId,
        LocalDate dataCriacao,
        LocalDate dataDevolucao,
        StatusEmprestimo status,
        List<ItemEmprestimoDetalhesDTO> itens
) {
    public static EmprestimoDetalhesDTO fromEntity(Emprestimo emprestimo) {
        return new EmprestimoDetalhesDTO(
                emprestimo.getId(),
                emprestimo.getClienteId(),
                emprestimo.getDataCriacao(),
                emprestimo.getDataDevolucao(),
                emprestimo.getStatus(),
                emprestimo.getItens().stream()
                        .map(ItemEmprestimoDetalhesDTO::fromEntity)
                        .collect(Collectors.toList())
        );
    }
}
