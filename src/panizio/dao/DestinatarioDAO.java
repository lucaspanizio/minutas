
package panizio.dao;

import panizio.conexao.ConexaoBanco;
import panizio.model.Destinatario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Panizio
 */
public class DestinatarioDAO {

    private ConexaoBanco conex;

    public DestinatarioDAO() {
        this.conex = new ConexaoBanco();
    }

    public boolean inserir(Destinatario model) {
        this.conex.connect();
        String sql = "INSERT INTO DESTINATARIO VALUES(SEQ_DESTINATARIO.NEXTVAL, ?, ?, ?, ?, ?,?, ?, ?)";

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
            JOptionPane.showMessageDialog(null, "Erro ao inserir destinatário: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally{
            this.conex.disconnect();
        }
        return false;
    }
    
    public boolean alterar(Destinatario model){
        this.conex.connect();
        String sql = "UPDATE DESTINATARIO SET ENDERECO = ?, NOME = ?, NUMERO = ?, CEP = ?, "
                   + "TELEFONE = ?, CNPJ = ?, CIDADE = ?, ESTADO = ? WHERE ID_DESTINATARIO = ?";

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
            JOptionPane.showMessageDialog(null, "Erro ao alterar destinatário: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally{
            this.conex.disconnect();
        }
        return false;
    }
    
    
    public Destinatario obter(int id){
        this.conex.connect();
                    

        try {
            String sql = "SELECT ENDERECO, NUMERO, NOME, CNPJ, CIDADE, ESTADO, TELEFONE, CEP "
                   + "FROM DESTINATARIO WHERE ID_DESTINATARIO = ?";  
            
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            
            pst.setInt(1, id); 
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
               return new Destinatario(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
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
