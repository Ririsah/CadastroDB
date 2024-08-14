/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author okidata
 */
public class PessoaJuridica extends Pessoa {
    
    private String cnpj;
    
    public PessoaJuridica() {
        cnpj = "";
    }
    
    public PessoaJuridica(int id, String nome, String locadouro, String cidade,
            String estado, String telefone, String email, String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCpf(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("cnpj: " + getCnpj());
    }
    
}
