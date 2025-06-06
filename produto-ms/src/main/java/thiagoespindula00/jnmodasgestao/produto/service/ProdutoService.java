package thiagoespindula00.jnmodasgestao.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thiagoespindula00.jnmodasgestao.produto.dto.ProdutoRequestDTO;
import thiagoespindula00.jnmodasgestao.produto.dto.ProdutoDetalhesDTO;
import thiagoespindula00.jnmodasgestao.produto.model.Produto;
import thiagoespindula00.jnmodasgestao.produto.repository.ProdutoRepository;
import thiagoespindula00.jnmodasgestao.produto.trata_erros.ValidacaoException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoDetalhesDTO salvar(ProdutoRequestDTO produtoRequestDTO) {
        validar(produtoRequestDTO);

        Produto produto = repository.save(Produto.fromDTO(produtoRequestDTO));
        System.out.println(produto);
        return ProdutoDetalhesDTO.fromEntity(produto);
    }

    private void validar(ProdutoRequestDTO produtoRequestDTO) {
        if (repository.existsByCodigo((produtoRequestDTO.codigo()))) {
            throw new ValidacaoException("Código informado já cadastrado");
        }
    }
}
