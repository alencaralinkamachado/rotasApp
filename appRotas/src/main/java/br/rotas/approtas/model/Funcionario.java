package br.rotas.approtas.model;

/**
 *
 * @author alencarmachado
 */
public class Funcionario {

    private int id;
    private String nome;
    private String cpf;

    public Funcionario(int id) {
        this.id = id;
    }

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Funcionario(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Funcionario() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
