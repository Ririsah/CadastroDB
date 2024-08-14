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
public class PessoaJuridicaDAO {
    
        public ConectorBD connection = new ConectorBD();
    
    public PessoaJuridica getPessoa(int id) throws Exception {
        
        PessoaJuridica Pessoa = null;
        String sql = "SELECT pessoaJ.Pessoa_idPessoa, pessoaJ.cpf, Pessoa.nome, Pessoa.locadouro, Pessoa.cidade, Pessoa.estado, Pessoa.telefone, Pessoa.email "
            + "FROM PessoaJuridica pessoaF "
            + "INNER JOIN Pessoa p ON pessoaF.Pessoa_idPessoa = Pessoa.idPessoa "
            + "WHERE pessoaF.Pessoa_idPessoa = ?";
            PreparedStatement stmt = connection.getPrepared(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Pessoa = new PessoaJuridica(resultado.getInt("idPessoa"),
                resultado.getString("nome"),
                resultado.getString("locadouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cpf"));
            } return Pessoa;  
    }
    
    
    public ArrayList<PessoaJuridica> getPessoas() throws SQLException {
        
        ArrayList<PessoaJuridica> list = new ArrayList<>();
        String sql = "SELECT pessoaJ.Pessoa_idPessoa, pessoaJ.cnpj, Pessoa.nome, Pessoa.locadouro, Pessoa.cidade, Pessoa.estado, Pessoa.telefone, Pessoa.email "
                + "FROM PessoaJuridica pessoaF "
                + "INNER JOIN Pessoa p ON pessoaJ.Pessoa_idPessoa = Pessoa.idPessoa";
        try (Connection conn = connection.getConnection(); PreparedStatement stmt =
            conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new PessoaJuridica(
                    rs.getInt("Pessoa_idPessoa"),
                    rs.getString("nome"),
                    rs.getString("locadouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cnpj")));
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaJuridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    public void Incluir(Pessoa pessoa, Pessoa PessoaJuridica) throws Exception {
        
        String sqlPessoa = "INSERT INTO Pessoa (nome, locadouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, 'F')";
        String sqlPessoaJuridica = "INSERT INTO PessoaJuridica (idPessoaJuridica, cnpj) VALUES (?, ?)";
        PreparedStatement p = connection.getPrepared(sqlPessoa);
        PreparedStatement pj = connection.getPrepared(sqlPessoaJuridica);
            p.setString(1, pessoa.getNome());
            p.setString(2, pessoa.getEmail());
            p.setString(3, pessoa.getLocadouro());
            p.setString(4, pessoa.getCidade());
            p.setString(5, pessoa.getEstado());
            pj.setInt(6, PessoaJuridica.getId());
            pj.setInt(7, PessoaJuridica.getId());
            p.executeUpdate();
            pj.executeUpdate();
    
    }
    
    
    public void alterar(Pessoa pessoa, Pessoa PessoaJuridica) throws Exception {
        
        String sqlPessoa = "UPDATE Pessoa SET nome = ?, locadouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, WHERE idPessoa = ?";
        String sqlPessoaJuridica = "UPDATE PessoaJuridica SET cpf = ? WHERE idPessoaJuridica = ?";
        PreparedStatement p = connection.getPrepared(sqlPessoa);
        PreparedStatement pj = connection.getPrepared(sqlPessoaJuridica);
            p.setString(1, pessoa.getNome());
            p.setString(2, pessoa.getLocadouro());
            p.setString(3, pessoa.getCidade());
            p.setString(4, pessoa.getEstado());
            p.setString(5, pessoa.getTelefone());
            p.setString(6, pessoa.getEmail());
            pj.setInt(7, pessoa.getId());
            p.executeUpdate();
            pj.executeUpdate();
    
    }
    
    
    public void excluir(int id) throws Exception {
        
        String sqlpessoa = "DELETE FROM Pessoa WHERE idPessoa="+id;
        String sqlPessoaJuridica = "DELETE FROM Pessoa_Fisica WHERE idPessoa="+id;
        PreparedStatement p = connection.getPrepared(sqlPessoaJuridica);
        PreparedStatement pf = connection.getPrepared(sqlpessoa);
            p.execute();
            pf.execute();
    }

}