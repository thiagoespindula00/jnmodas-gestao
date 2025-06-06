package thiagoespindula00.jnmodasgestao.produto.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import thiagoespindula00.jnmodasgestao.produto.dto.ProdutoRequestDTO;
import thiagoespindula00.jnmodasgestao.produto.dto.ProdutoDetalhesDTO;
import thiagoespindula00.jnmodasgestao.produto.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UriComponentsBuilder uriBuilder;

    @PostMapping
    public ResponseEntity<ProdutoDetalhesDTO> cadastrar(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) {
        ProdutoDetalhesDTO produtoCadastrado = produtoService.cadastrar(produtoRequestDTO);

        var location = uriBuilder
                .path("produtos/{id}")
                .buildAndExpand(produtoCadastrado.id())
                .toUri();

        return ResponseEntity.created(location).body(produtoCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) {
        produtoService.atualizar(id, produtoRequestDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        produtoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
