/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panizio.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas Panizio
 */
public class ConexaoBanco {

    public Connection c;

    private final String url;
    private final String user;
    private final String pass;    
    
    public ConexaoBanco() {
        this.url = "jdbc:oracle:thin:@localhost:1521:xe";
        this.user = "hr";
        this.pass = "hr";        
    }

    public boolean connect() {
        try {            
            this.c = DriverManager.getConnection(url, user, pass);
            return true;
            //this.c.setAutoCommit(false);
        }catch( SQLException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } 
        return false;
    }
    
    public Connection getConnection() {
        try {            
            return DriverManager.getConnection(url, user, pass);            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());   
        }
        return null;
    }

    public void disconnect() {
        try {
            this.c = DriverManager.getConnection(url, user, pass);
            this.c.close();
        }catch(SQLException e){
            e.printStackTrace();        
            System.out.println(e.getMessage());   
        }
    }
    
    /**
     * Esse método executa a query dada, e retorna um ResultSet
     * Talvez fosse melhor idéia fazer esse método lançar uma exception
     * a faze-lo retornar null como eu fiz, porém isso é apenas um exemplo
     * para demonstrar a funcionalidade do comando execute
     *
     * @param query String contendo a query que se deseja executar
     * @return ResultSet em caso de estar tudo Ok, null em caso de erro.
     */
    public ResultSet executar( String query ) {
        Statement st;
        ResultSet rs;
       
        try {
            st = this.c.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
       
        return null;
    }
   
//    /**
//     * Executa uma query como update, delete ou insert.
//     * Retorna o número de registros afetados quando falamos de um update ou delete
//     * ou retorna 1 quando o insert é bem sucedido. Em outros casos retorna -1
//     *
//     * @param query A query que se deseja executar
//     * @return 0 para um insert bem sucedido. -1 para erro
//     */
//    public int inserir( String query ) {
//        Statement st;
//        int result = -1;
//       
//        try {
//            st = this.con.createStatement();
//            result = st.executeUpdate(query);
//        } catch ( SQLException e ) {
//            e.printStackTrace();
//        }
//       
//        return result;
//    } 
}
