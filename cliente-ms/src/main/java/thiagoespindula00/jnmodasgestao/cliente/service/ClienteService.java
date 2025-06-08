package thiagoespindula00.jnmodasgestao.cliente.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thiagoespindula00.jnmodasgestao.cliente.dto.ClienteDetalhesDTO;
import thiagoespindula00.jnmodasgestao.cliente.dto.ClienteRequestDTO;
import thiagoespindula00.jnmodasgestao.cliente.model.Cliente;
import thiagoespindula00.jnmodasgestao.cliente.repository.ClienteRepository;
import thiagoespindula00.jnmodasgestao.cliente.trata_erros.ValidacaoException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    private void validaCPF(String cpf) {
        if (repository.existsByCpf(cpf)) {
            throw new ValidacaoException("CPF já cadastrado");
        }
    }

    private void validaEmail(String email) {
        if (repository.existsByEmail(email)) {
            throw new ValidacaoException("Email já cadastrado");
        }
    }

    @Transactional
    public ClienteDetalhesDTO cadastrar(ClienteRequestDTO clienteRequestDTO) {
        validaCPF(clienteRequestDTO.cpf());
        validaEmail(clienteRequestDTO.email());

        Cliente cliente = repository.save(Cliente.fromDTO(clienteRequestDTO));
        return ClienteDetalhesDTO.fromEntity(cliente);
    }

    @Transactional
    public void atualizar(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (!cliente.getCpf().equals(clienteRequestDTO.cpf())) {
            validaCPF(clienteRequestDTO.cpf());
        }
        if (!cliente.getEmail().equals(clienteRequestDTO.email())) {
            validaEmail(clienteRequestDTO.email());
        }

        cliente.setCampos(clienteRequestDTO);
        repository.save(cliente);
    }

    @Transactional
    public void deletar(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(cliente);
    }
}
