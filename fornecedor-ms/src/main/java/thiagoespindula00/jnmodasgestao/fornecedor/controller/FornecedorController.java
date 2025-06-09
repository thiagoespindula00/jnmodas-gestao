package thiagoespindula00.jnmodasgestao.fornecedor.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
