/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.model;

/**
 *
 * @author alencarmachado
 */
public class Rua {
    
    private int id;
    private String nome;
    private String CEP;
    private Cidade cidade;

    public Rua(){} 
    
    public Rua(int id, String nome, int idCidade){
        this.id = id;
        this.nome = nome;
        this.cidade = new Cidade();
        cidade.setId(idCidade);
    }
    
    public Rua(int id){
        this.id = id;
    }
    
    public Rua(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public Rua(String nome){
        this.nome = nome;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the CEP
     */
    public String getCEP() {
        return CEP;
    }

    /**
     * @param CEP the CEP to set
     */
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
}
