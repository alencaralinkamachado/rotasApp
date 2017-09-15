/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.model;

/**
 *
 * @author alencarmachado
 * 
 * 
 ﻿create table cidade (
id_cidade serial,
nome_cidade varchar(100) not null,
latitude_cidade varchar(30),
longitude_cidade varchar(30),
primary key (id_cidade)
)
* 
* ﻿insert into cidade (nome_cidade, latitude_cidade, longitude_cidade) values ('São Gabriel','-30.3345289','-54.9343841')
 * 
 */
public class Cidade {
    
    private int id;
    private String nome;
    private String latitude;
    private String longitude;

    public Cidade(int id, String nome, String lagitude, String longitude){
        this.id = id;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
     public Cidade(int id){
        this.id = id;        
    }
    
    public Cidade(){}
    
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
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
