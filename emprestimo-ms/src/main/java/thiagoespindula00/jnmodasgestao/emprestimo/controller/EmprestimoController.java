package thiagoespindula00.jnmodasgestao.emprestimo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.EmprestimoDetalhesDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.dto.EmprestimoRequestDTO;
import thiagoespindula00.jnmodasgestao.emprestimo.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoService service;

    @Autowired
    private UriComponentsBuilder uriBuilder;

    @PostMapping
    public ResponseEntity<EmprestimoDetalhesDTO> cadastrar(@RequestBody @Valid EmprestimoRequestDTO emprestimoRequestDTO) {
        EmprestimoDetalhesDTO emprestimoCadastrado = service.cadastrar(emprestimoRequestDTO);

        var location = uriBuilder
                .path("/emprestimos/{id}")
                .buildAndExpand(emprestimoCadastrado.id())
                .toUri();

        return ResponseEntity.created(location).body(emprestimoCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid EmprestimoRequestDTO emprestimoRequestDTO) {
        service.atualizar(id, emprestimoRequestDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<?> devolucao(@PathVariable Long id) {
        service.realizarDevolucao(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<EmprestimoDetalhesDTO>> listar(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDetalhesDTO> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(service.detalhar(id));
    }
}
