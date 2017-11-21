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
    private ArrayList<Track> tracks;
    private ArrayList<Track> pontosEntrega;

    public Polyline(int id, String nome, ArrayList<Track> traks) {
        this.id = id;
        this.nome = nome;
        this.tracks = traks;
    }

    public Polyline(int id, String nome, ArrayList<Track> tracks, ArrayList<Track> pontosEntrega) {
        this.id = id;
        this.nome = nome;
        this.tracks = tracks;
        this.pontosEntrega = pontosEntrega;
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
     * @return the tracks
     */
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    /**
     * @param traks the tracks to set
     */
    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }        

    /**
     * @return the pontosEntrega
     */
    public ArrayList<Track> getPontosEntrega() {
        return pontosEntrega;
    }

    /**
     * @param pontosEntrega the pontosEntrega to set
     */
    public void setPontosEntrega(ArrayList<Track> pontosEntrega) {
        this.pontosEntrega = pontosEntrega;
    }
    
    
    
    
    
}
