package thiagoespindula00.jnmodasgestao.emprestimo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.EmprestimoDetalhesDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.EmprestimoRequestDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.model.Emprestimo;
import thiagoespindula00.jnmodasgestao.emprestimo.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository repository;

    @Transactional
    public EmprestimoDetalhesDTO cadastrar(EmprestimoRequestDTO emprestimoRequestDTO) {
        Emprestimo emprestimo = Emprestimo.fromDto(emprestimoRequestDTO);
        repository.save(emprestimo);

        return EmprestimoDetalhesDTO.fromEntity(emprestimo);
    }
}
