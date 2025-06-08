package thiagoespindula00.jnmodasgestao.cliente.service;

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

    private void validarCamposUnique(ClienteRequestDTO clienteRequestDTO) {
        if (repository.existsByCpf(clienteRequestDTO.cpf())) {
            throw new ValidacaoException("CPF já cadastrado");
        }

        if (repository.existsByEmail(clienteRequestDTO.email())) {
            throw new ValidacaoException("Email já cadastrado");
        }
    }

    @Transactional
    public ClienteDetalhesDTO cadastrar(ClienteRequestDTO clienteRequestDTO) {
        validarCamposUnique(clienteRequestDTO);

        Cliente cliente = repository.save(Cliente.fromDTO(clienteRequestDTO));
        return ClienteDetalhesDTO.fromEntity(cliente);
    }
}
