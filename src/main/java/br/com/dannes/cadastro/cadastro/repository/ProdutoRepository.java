package br.com.dannes.cadastro.cadastro.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dannes.cadastro.cadastro.model.Produto;

@Repository
public class ProdutoRepository {
    
    //@Autowired
    private List<Produto> produtos = new ArrayList<Produto>();

    private int ultimoId = 0;
    
    /**
     * Método para retornar uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu ID
     * @param id do produto que será localizado
     * @return retorna um produto caso tenha sido encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
         .stream()
         .filter(produto -> produto.getId() == id)
         .findFirst();
    }

    /**
     *  Metodo para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        
        ultimoId ++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Metodo para deletar o produto por ID
     * @param id do produto a ser deletado
     */
    public void deletar (Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista 
     * @param produto que será atualizado
     * @return o produto após atualizar na lista
     */
    public Produto atualizar(Produto produto){
        //Encontrar um produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }
        //Remover o produto antigo da lista 
        deletar(produto.getId());

        //Adicionar o produto atualizafo na lista 
        produtos.add(produto);

        return produto;
    }
    


}
