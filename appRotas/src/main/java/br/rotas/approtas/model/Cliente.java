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
public class Cliente {

    

    private int id;
    private String nome;
    private String cpf;
    private String ondeDeixar;
    private Rua rua;
    private Cidade cidade;
    private int numero;
    private int codCorreio;
    private String latitude;
    private String longitude;
    private String complemento;
    private String email;
    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Rota rota;
    
    public Cliente( int id){
        this.id = id;
    }
    
    public Cliente(int id, String nome, String cpf, String ondeDeixar, Rua rua, Cidade cidade, int numero, int codCorreio, 
            String latitude, String longitude, String email, String complemento, String telefone1, String telefone2, String telefone3) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ondeDeixar = ondeDeixar;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.codCorreio = codCorreio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.email = email;
        this.complemento = complemento;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
    }
    
     public Cliente(int id, String nome, String cpf, String ondeDeixar, Rua rua, Cidade cidade, int numero, int codCorreio, String latitude, String longitude, Rota rota) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ondeDeixar = ondeDeixar;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.codCorreio = codCorreio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.setRota(rota);
    }
    
    public Cliente(int id, String nome, String cpf, String ondeDeixar, Rua rua, Cidade cidade, int numero, int codCorreio, String latitude, String longitude) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ondeDeixar = ondeDeixar;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.codCorreio = codCorreio;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Cliente(String nome, String cpf, String ondeDeixar, Rua rua, Cidade cidade, int numero, int codCorreio, String latitude, String longitude) {
        this.nome = nome;
        this.cpf = cpf;
        this.ondeDeixar = ondeDeixar;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.codCorreio = codCorreio;
        this.latitude = latitude;
        this.longitude = longitude;
    }
   
    public Cliente(String nome, String cpf, String ondeDeixar, int idRua, int idCidade, int numero, int codCorreio, String latitude, String longitude) {
        this.nome = nome;
        this.cpf = cpf;
        this.ondeDeixar = ondeDeixar;
        this.rua = new Rua();
        this.rua.setId(idRua);
        this.cidade = new Cidade();
        this.cidade.setId(idCidade);
        this.numero = numero;
        this.codCorreio = codCorreio;
        this.latitude = latitude;
        this.longitude = longitude;
    }
   
   
   
    public Cliente(){}

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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the ondeDeixar
     */
    public String getOndeDeixar() {
        return ondeDeixar;
    }

    /**
     * @param ondeDeixar the ondeDeixar to set
     */
    public void setOndeDeixar(String ondeDeixar) {
        this.ondeDeixar = ondeDeixar;
    }

    /**
     * @return the rua
     */
    public Rua getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(Rua rua) {
        this.rua = rua;
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

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the codCorreio
     */
    public int getCodCorreio() {
        return codCorreio;
    }

    /**
     * @param codCorreio the codCorreio to set
     */
    public void setCodCorreio(int codCorreio) {
        this.codCorreio = codCorreio;
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
    
    
    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone1
     */
    public String getTelefone1() {
        return telefone1;
    }

    /**
     * @param telefone1 the telefone1 to set
     */
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    /**
     * @return the telefone2
     */
    public String getTelefone2() {
        return telefone2;
    }

    /**
     * @param telefone2 the telefone2 to set
     */
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    /**
     * @return the telefone3
     */
    public String getTelefone3() {
        return telefone3;
    }

    /**
     * @param telefone3 the telefone3 to set
     */
    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    /**
     * @return the rota
     */
    public Rota getRota() {
        return rota;
    }

    /**
     * @param rota the rota to set
     */
    public void setRota(Rota rota) {
        this.rota = rota;
    }
    
    
    
}
