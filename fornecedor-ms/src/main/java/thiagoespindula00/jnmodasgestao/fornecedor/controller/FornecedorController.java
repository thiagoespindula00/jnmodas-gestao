package thiagoespindula00.jnmodasgestao.fornecedor.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import thiagoespindula00.jnmodasgestao.fornecedor.dto.FornecedorDetalhesDTO;
import thiagoespindula00.jnmodasgestao.fornecedor.dto.FornecedorRequestDTO;
import thiagoespindula00.jnmodasgestao.fornecedor.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @Autowired
    private UriComponentsBuilder uriBuilder;

    @PostMapping
    public ResponseEntity<FornecedorDetalhesDTO> cadastrar(@RequestBody @Valid FornecedorRequestDTO fornecedorRequestDTO) {
        FornecedorDetalhesDTO fornecedorCadastrado = service.cadastrar(fornecedorRequestDTO);

        var location = uriBuilder
                .path("/fornecedor/{id}")
                .buildAndExpand(fornecedorCadastrado.id())
                .toUri();

        return ResponseEntity.created(location).body(fornecedorCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid FornecedorRequestDTO fornecedorRequestDTO) {
        service.atualizar(id, fornecedorRequestDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<FornecedorDetalhesDTO>> listar(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDetalhesDTO> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(service.detalhar(id));
    }
}
