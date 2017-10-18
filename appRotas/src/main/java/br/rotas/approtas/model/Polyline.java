/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.model;

import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 */
public class Polyline {

    private int id;
    private String nome;
    private ArrayList<Track> traks;

    public Polyline(int id, String nome, ArrayList<Track> traks) {
        this.id = id;
        this.nome = nome;
        this.traks = traks;
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
     * @return the traks
     */
    public ArrayList<Track> getTraks() {
        return traks;
    }

    /**
     * @param traks the traks to set
     */
    public void setTraks(ArrayList<Track> traks) {
        this.traks = traks;
    }
    
    
    
    
    
}
