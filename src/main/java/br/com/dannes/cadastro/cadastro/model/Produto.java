package br.com.dannes.cadastro.cadastro.model;

import lombok.Data;

@Data
public class Produto {
    
    //#region Atributos
    private int id;

    private String nome;

    private int quantidade;

    private Double valor;

    private String observacao;
    //#endregion

}
