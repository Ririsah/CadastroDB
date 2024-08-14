/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import cadastro.model.util.ConectorBD;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author okidata
 */
public class PessoaFisicaDAO {

    public ConectorBD connection = new ConectorBD();
    
    public PessoaFisica getPessoa(int id) throws Exception {
        
        PessoaFisica Pessoa = null;
        String sql = "SELECT pessoaF.Pessoa_idPessoa, pessoaF.cpf, Pessoa.nome, Pessoa.locadouro, Pessoa.cidade, Pessoa.estado, Pessoa.telefone, Pessoa.email "
            + "FROM PessoaFisica pessoaF "
            + "INNER JOIN Pessoa p ON pessoaF.Pessoa_idPessoa = Pessoa.idPessoa "
            + "WHERE pessoaF.Pessoa_idPessoa = ?";
            PreparedStatement stmt = connection.getPrepared(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Pessoa = new PessoaFisica(resultado.getInt("idPessoa"),
                resultado.getString("nome"),
                resultado.getString("locadouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cpf"));
            } return Pessoa;  
    }
    
    
    public ArrayList<PessoaFisica> getPessoas() throws SQLException {
        
        ArrayList<PessoaFisica> list = new ArrayList<>();
        String sql = "SELECT pessoaF.Pessoa_idPessoa, pessoaF.cpf, Pessoa.nome, Pessoa.locadouro, Pessoa.cidade, Pessoa.estado, Pessoa.telefone, Pessoa.email "
                + "FROM PessoaFisica pessoaF "
                + "INNER JOIN Pessoa p ON pessoaF.Pessoa_idPessoa = Pessoa.idPessoa";
        try (Connection conn = connection.getConnection(); PreparedStatement stmt =
            conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new PessoaFisica(
                    rs.getInt("Pessoa_idPessoa"),
                    rs.getString("nome"),
                    rs.getString("locadouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cpf")));
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    public void Incluir(Pessoa pessoa, Pessoa PessoaFisica) throws Exception {
        
        String sqlPessoa = "INSERT INTO Pessoa (nome, locadouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, 'F')";
        String sqlPessoaFisica = "INSERT INTO PessoaFisica (idPessoaFisica, cpf) VALUES (?, ?)";
        PreparedStatement p = connection.getPrepared(sqlPessoa);
        PreparedStatement pf = connection.getPrepared(sqlPessoaFisica);
            p.setString(1, pessoa.getNome());
            p.setString(2, pessoa.getEmail());
            p.setString(3, pessoa.getLocadouro());
            p.setString(4, pessoa.getCidade());
            p.setString(5, pessoa.getEstado());
            pf.setInt(6, PessoaFisica.getId());
            pf.setInt(7, PessoaFisica.getId());
            p.executeUpdate();
            pf.executeUpdate();
    
    }
    
    
    public void alterar(Pessoa pessoa, Pessoa PessoaFisica) throws Exception {
        
        String sqlPessoa = "UPDATE Pessoa SET nome = ?, locadouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, WHERE idPessoa = ?";
        String sqlPessoaFisica = "UPDATE PessoaFisica SET cpf = ? WHERE idPessoaFisica = ?";
        PreparedStatement p = connection.getPrepared(sqlPessoa);
        PreparedStatement pf = connection.getPrepared(sqlPessoaFisica);
            p.setString(1, pessoa.getNome());
            p.setString(2, pessoa.getLocadouro());
            p.setString(3, pessoa.getCidade());
            p.setString(4, pessoa.getEstado());
            p.setString(5, pessoa.getTelefone());
            p.setString(6, pessoa.getEmail());
            pf.setInt(7, pessoa.getId());
            p.executeUpdate();
            pf.executeUpdate();
    
    }
    
    
    public void excluir(int id) throws Exception {
        
        String sqlpessoa = "DELETE FROM Pessoa WHERE idPessoa="+id;
        String sqlPessoaFisica = "DELETE FROM Pessoa_Fisica WHERE idPessoa="+id;
        PreparedStatement p = connection.getPrepared(sqlPessoaFisica);
        PreparedStatement pf = connection.getPrepared(sqlpessoa);
            p.execute();
            pf.execute();
    }
    
   

}
    
   
