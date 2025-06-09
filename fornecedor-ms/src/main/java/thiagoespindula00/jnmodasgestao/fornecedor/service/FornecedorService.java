package thiagoespindula00.jnmodasgestao.fornecedor.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thiagoespindula00.jnmodasgestao.fornecedor.dto.FornecedorDetalhesDTO;
import thiagoespindula00.jnmodasgestao.fornecedor.dto.FornecedorRequestDTO;
import thiagoespindula00.jnmodasgestao.fornecedor.model.Fornecedor;
import thiagoespindula00.jnmodasgestao.fornecedor.repository.FornecedorRepository;
import thiagoespindula00.jnmodasgestao.fornecedor.trata_erros.ValidacaoException;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    private void validaCnpj(String cnpj) {
        if (repository.existsByCnpj(cnpj)) {
            throw new ValidacaoException("CNPJ já cadastrado");
        }
    }

    private void validaEmail(String email) {
        if (repository.existsByEmail(email)) {
            throw new ValidacaoException("E-mail já cadastrado");
        }
    }

    @Transactional
    public FornecedorDetalhesDTO cadastrar(FornecedorRequestDTO fornecedorRequestDTO) {
        validaCnpj(fornecedorRequestDTO.cnpj());
        validaEmail(fornecedorRequestDTO.email());

        Fornecedor fornecedor = repository.save(Fornecedor.fromDto(fornecedorRequestDTO));
        return FornecedorDetalhesDTO.fromEntity(fornecedor);
    }

    @Transactional
    public void atualizar(Long id, FornecedorRequestDTO fornecedorRequestDTO) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (!fornecedor.getCnpj().equals(fornecedorRequestDTO.cnpj())) {
            validaCnpj(fornecedorRequestDTO.cnpj());
        }

        if (!fornecedor.getEmail().equals(fornecedorRequestDTO.email())) {
            validaEmail(fornecedorRequestDTO.email());
        }

        fornecedor.setCampos(fornecedorRequestDTO);
        repository.save(fornecedor);
    }

    @Transactional
    public void deletar(Long id) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(fornecedor);
    }

    public Page<FornecedorDetalhesDTO> listar(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(FornecedorDetalhesDTO::fromEntity);
    }

    public FornecedorDetalhesDTO detalhar(Long id) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return FornecedorDetalhesDTO.fromEntity(fornecedor);
    }
}
