package br.com.dannes.cadastro.cadastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dannes.cadastro.cadastro.model.Produto;
import br.com.dannes.cadastro.cadastro.repository.ProdutoRepository;

@Service
public class ProdutoServices {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        //Caso tenha a regra de negócio entra aqui
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu ID
     * @param id do produto que será localizado
     * @return retorna um produto caso tenha sido encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    /**
     *  Metodo para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        //Regra de negocio para validação seria implementada aqui
        return produtoRepository.adicionar(produto);        
    }

    /**
     * Metodo para deletar o produto por ID
     * @param id do produto a ser deletado
     */
    public void deletar (Integer id){
        //Regra de negócio para validar a exlusão
        produtoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o produto na lista 
     * @param produto que será atualizado
     * @return o produto após atualizar na lista
     */
    public Produto atualizar(Integer id, Produto produto){  
        //Regra para validação do ID
        produto.setId(id);

        return produtoRepository.atualizar(produto);

    }
}
