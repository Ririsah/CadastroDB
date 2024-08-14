/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author okidata
 */
public class SequenceManager {
    
    public int getValue(String sequencia)throws Exception{
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;");
        String sql = "SELECT NEXT VALUE FOR "+sequencia+" as proximoId";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
            rs.getInt("proximoId");
        return 0;
    }
    
}
