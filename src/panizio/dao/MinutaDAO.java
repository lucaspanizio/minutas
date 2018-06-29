
package panizio.dao;

import panizio.conexao.ConexaoBanco;
import panizio.model.Minuta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Panizio
 */
public class MinutaDAO {

    private ConexaoBanco conex;

    public MinutaDAO() {
        this.conex = new ConexaoBanco();
    }

    public boolean inserir(Minuta model) {
        this.conex.connect();
        String sql = "INSERT INTO MINUTA VALUES(SEQ_MINUTA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
                
        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            System.out.println("Emissao no DAO : " + model.getEmissao()  );
            pst.setString(1, model.getEmissao());
            pst.setInt(2, model.getId_usuario());
            pst.setInt(3, model.getId_remetente());
            pst.setInt(4, model.getId_destinatario());
            pst.setString(5, model.getObs());
            pst.setString(6, model.getValor());  
            pst.setInt(7, model.getId_nf()); 
            
            return pst.executeUpdate() > 0;
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir minuta: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally{
            this.conex.disconnect();
        }
        return false;
    }
    
//    public boolean alterar(Minuta model){
//        this.conex.connect();
//        String sql = "UPDATE MINUTA SET DATA_EMISSAO = ?, ID_USUARIO = ?, ID_REMETENTE = ?, "
//                   + "ID_DESTINATARIO = ?, OBS = ?, VALOR = ? WHERE ID_MINUTA = ?";
//
//        try {
//            PreparedStatement pst = this.conex.c.prepareStatement(sql);
//            pst.setString(1, model.getEmissao());
//            pst.setInt(2, model.getId_usuario());
//            pst.setInt(3, model.getId_remetente());
//            pst.setInt(4, model.getId_destinatario());
//            pst.setString(5, model.getObs());
//            pst.setString(6, model.getValor());   
//            pst.setInt(7,model.getId());
//            
//            return pst.executeUpdate() > 0;
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao alterar minuta: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
//        }finally{
//            this.conex.disconnect();
//        }
//        return false;
//    }
    
    
    /**
     * Retorna o número da próxima minuta a ser inserida.
     * @return int Nº da minuta
     */
    public int obterProximo() {
        this.conex.connect();
        String sql = "SELECT NVL(MAX(ID_MINUTA),0) +1 FROM MINUTA";
        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.conex.disconnect();
        }
        return -1;
    }
   
}
