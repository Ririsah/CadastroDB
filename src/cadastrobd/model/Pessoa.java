/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author okidata
 */
public class Pessoa {
    
    private int id;
    private String nome;
    private String locadouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    
    public Pessoa() {
        id = 0;
        nome = "";
        locadouro = "";
        cidade = "";
        estado = "";
        telefone = "";
        email = "";
    }
    
    public Pessoa(int id, String nome, String locadouro, String cidade,
            String estado, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.locadouro = locadouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
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

    public void setId(String nome) {
        this.nome = nome;
    }
    
    public String getLocadouro() {
        return locadouro;
    }

    public void setLocadouro(String locadouro) {
        this.locadouro = locadouro;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Locadouro: " + locadouro);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }

}
