package thiagoespindula00.jnmodasgestao.cliente.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import thiagoespindula00.jnmodasgestao.cliente.dto.ClienteDetalhesDTO;
import thiagoespindula00.jnmodasgestao.cliente.dto.ClienteRequestDTO;
import thiagoespindula00.jnmodasgestao.cliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UriComponentsBuilder uriBuilder;

    @PostMapping
    public ResponseEntity<ClienteDetalhesDTO> cadastrar(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO) {
        ClienteDetalhesDTO clienteCadastrado = clienteService.cadastrar(clienteRequestDTO);

        var location = uriBuilder
                .path("/clientes/{id}")
                .buildAndExpand(clienteCadastrado.id())
                .toUri();

        return ResponseEntity.created(location).body(clienteCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO clienteRequestDTO) {
        clienteService.atualizar(id, clienteRequestDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        clienteService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDetalhesDTO>> listar(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(clienteService.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalhesDTO> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.detalhar(id));
    }

    @GetMapping("/instancia")
    public String instancia(@Value("${server.port}") String porta) {
        return "Instancia do Servidor: " + porta;
    }

}
