package br.rotas.approtas.model;

import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 */
public class Rota {

    private int id;   
    private String nome;
    private Cidade cidade;
    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private String img;

   
    public Rota() {
    }

    public Rota(int id, String nome, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Rota(int id, String nome, String img){
        this.id = id;
        this.nome = nome;
        this.img = img;
    }
 
    public Rota(int id, String nome, Cidade cidade, ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.clientes = clientes;
        this.funcionarios = funcionarios;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
     public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
