/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
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

    public void connect() {
        try {            
            this.c = DriverManager.getConnection(url, user, pass);
            //this.c.setAutoCommit(false);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            this.c = DriverManager.getConnection(url, user, pass);
            this.c.close();
        }catch(SQLException ex){
            ex.printStackTrace();        }
    }
}
