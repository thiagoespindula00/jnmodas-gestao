package thiagoespindula00.jnmodasgestao.produto.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity cadastrar(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) {
        ProdutoDetalhesDTO produtoCadastrado = produtoService.salvar(produtoRequestDTO);

        var location = uriBuilder
                .path("produtos/{id}")
                .buildAndExpand(produtoCadastrado.id())
                .toUri();

        return ResponseEntity.created(location).body(produtoCadastrado);
    }
}
