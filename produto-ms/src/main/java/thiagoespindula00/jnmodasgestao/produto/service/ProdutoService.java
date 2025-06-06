package thiagoespindula00.jnmodasgestao.produto.service;

import jakarta.persistence.EntityNotFoundException;
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

    private void validarDadosInformados(ProdutoRequestDTO produtoRequestDTO) {
        if (repository.existsByCodigo((produtoRequestDTO.codigo()))) {
            throw new ValidacaoException("Código informado já cadastrado");
        }
    }

    public ProdutoDetalhesDTO cadastrar(ProdutoRequestDTO produtoRequestDTO) {
        validarDadosInformados(produtoRequestDTO);

        Produto produto = repository.save(Produto.fromDTO(produtoRequestDTO));
        System.out.println(produto);
        return ProdutoDetalhesDTO.fromEntity(produto);
    }

    public void atualizar(Long id, ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!produto.getCodigo().equalsIgnoreCase(produtoRequestDTO.codigo())) {
            validarDadosInformados(produtoRequestDTO);
        }

        produto.setCampos(produtoRequestDTO);
        repository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(produto);
    }
}
