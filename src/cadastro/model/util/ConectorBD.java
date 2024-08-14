/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author okidata
 */
public class ConectorBD {
    
    public Connection getConnection() throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Driver do banco não encontrado.");
        }
            return null;   
    }  
    
    
    public PreparedStatement getPrepared(String sql) throws Exception {
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        return stmt;
    }
    
    
    public ResultSet getSelect(PreparedStatement stmt) throws Exception {
        ResultSet rs = stmt.executeQuery();
        return rs;
    }
    
    
    public void closeStatement(String sql) throws Exception{
       getPrepared(sql).close();
    }
    
    
    public void closeResult(PreparedStatement stmt)throws Exception{
        getSelect(stmt).close();
    }
    
    
    public void closeConnection() throws Exception{
       getConnection().close();
   }
    
}
