
package DAO;

import Conexao.ConexaoBanco;
import Model.Remetente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Panizio
 */
public class RemetenteDAO {

    private ConexaoBanco conex;

    public RemetenteDAO() {
        this.conex = new ConexaoBanco();
    }

    public boolean inserir(Remetente model) {
        this.conex.connect();
        String sql = "INSERT INTO REMETENTE VALUES(SEQ_REMETENTE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            pst.setString(1, model.getEndereco());
            pst.setString(2, model.getNome());
            pst.setInt(3, model.getNumero());
            pst.setString(4, model.getCep());
            pst.setString(5, model.getTelefone());
            pst.setString(6, model.getCnpj());
            pst.setString(7, model.getCidade());
            pst.setString(8, model.getEstado());
            
            return pst.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir remetente: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally{
            this.conex.disconnect();
        }
        return false;
    }
    
    public boolean alterar(Remetente model){
        this.conex.connect();
        String sql = "UPDATE REMETENTE SET ENDERECO = ?, NOME = ?, NUMERO = ?, CEP = ?, "
                   + "TELEFONE = ?, CNPJ = ?, CIDADE = ?, ESTADO = ? WHERE ID_REMETENTE = ?";

        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            pst.setString(1, model.getEndereco().toUpperCase());
            pst.setString(2, model.getNome().toUpperCase());
            pst.setInt(3, model.getNumero());
            pst.setString(4, model.getCep());
            pst.setString(5, model.getTelefone());
            pst.setString(6, model.getCnpj());
            pst.setString(7, model.getCidade().toUpperCase());
            pst.setString(8, model.getEstado().toUpperCase());
            pst.setInt(9,model.getId());
            
            return pst.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar remetente: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally{
            this.conex.disconnect();
        }
        return false;
    }
   
    
    public Remetente getRemetente(int id){
        this.conex.connect();
        String sql = "SELECT ENDERECO, NUMERO, NOME, CNPJ, CIDADE, ESTADO, TELEFONE, CEP "
                   + "FROM REMETENTE WHERE ID_REMETENTE = ?";                         

        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            pst.setInt(1, id); 
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
               return new Remetente(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
               rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
            
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao consultar remetente: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally{
            this.conex.disconnect();
        }
        return null;
    }

}
