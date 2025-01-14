/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author okidata
 */
public class PessoaFisica extends Pessoa {
    
    private String cpf;
    
    public PessoaFisica() {
        cpf = "";
    }
    
    public PessoaFisica(int id, String nome, String locadouro, String cidade,
            String estado, String telefone, String email, String cpf) {
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("cpf: " + getCpf());
    }
    
}
