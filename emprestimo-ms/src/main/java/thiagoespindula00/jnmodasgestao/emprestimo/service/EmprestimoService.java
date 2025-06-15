package thiagoespindula00.jnmodasgestao.emprestimo.service;

import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.EmprestimoDetalhesDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.EmprestimoRequestDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.feign_client.cliente.ClienteClient;
import thiagoespindula00.jnmodasgestao.emprestimo.feign_client.cliente.ClienteResponseDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.model.Emprestimo;
import thiagoespindula00.jnmodasgestao.emprestimo.repository.EmprestimoRepository;
import thiagoespindula00.jnmodasgestao.emprestimo.trata_erros.ValidacaoException;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private ClienteClient feignClientCliente;

    private void validarClienteId(Long id) {
        try {
            feignClientCliente.getCliente(id);
        }
        catch (FeignException.NotFound ex) {
            throw new ValidacaoException("Cliente com ID " + id + " não encontrado");
        }
    }

    @Transactional
    public EmprestimoDetalhesDTO cadastrar(EmprestimoRequestDTO emprestimoRequestDTO) {
        validarClienteId(emprestimoRequestDTO.clienteId());

        Emprestimo emprestimo = Emprestimo.fromDto(emprestimoRequestDTO);
        repository.save(emprestimo);

        return EmprestimoDetalhesDTO.fromEntity(emprestimo);
    }

    @Transactional
    public void atualizar(Long id, EmprestimoRequestDTO emprestimoRequestDTO) {
        Emprestimo emprestimo = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        emprestimo.setCampos(emprestimoRequestDTO);
        repository.save(emprestimo);
    }

    @Transactional
    public void deletar(Long id) {
        Emprestimo emprestimo = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(emprestimo);
    }

    @Transactional
    public void realizarDevolucao(Long id) {
        Emprestimo emprestimo = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (emprestimo.getDataDevolucao() != null) {
            throw new ValidacaoException("A devolução desse empréstimo já foi realizada");
        }

        emprestimo.realizarDevolucao();
        repository.save(emprestimo);
    }

    public Page<EmprestimoDetalhesDTO> listar(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(EmprestimoDetalhesDTO::fromEntity);
    }

    public EmprestimoDetalhesDTO detalhar(Long id) {
        Emprestimo cliente = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return EmprestimoDetalhesDTO.fromEntity(cliente);
    }
}
