
package panizio.dao;

import panizio.conexao.ConexaoBanco;
import panizio.model.Nota_Fiscal;
import panizio.utils.AtributosGlobais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Panizio
 */
public class Nota_FiscalDAO {

    private ConexaoBanco conex;

    public Nota_FiscalDAO() {
        this.conex = new ConexaoBanco();
    }

    public boolean inserir(Nota_Fiscal model) {
        AtributosGlobais.ID_NF = ultimaNotaFiscal();
        
        this.conex.connect();        
        String sql = "INSERT INTO NOTA_FISCAL VALUES(SEQ_NF.NEXTVAL, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql); 
            pst.setInt(1, model.getQtdVolumes());
            pst.setString(2, model.getMetCubicos());
            pst.setString(3, model.getPeso());            
            pst.setString(4, model.getValor());
            pst.setString(5, model.getNf());           
            
            return pst.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir nota fiscal: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally{
          this.conex.disconnect();
        }
        return false;
    }
    
    private int ultimaNotaFiscal(){     
        this.conex.connect(); 
        String sql = "SELECT MAX(ID_NF) FROM NOTA_FISCAL";

        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql); 
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) return rs.getInt(1);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
           this.conex.disconnect();
        }
        return -1;
    }
    
    public Nota_Fiscal obterNotaFiscal(int id_minuta){     
        this.conex.connect(); 
        String sql = "SELECT * FROM NOTA_FISCAL WHERE ID_NF = "+id_minuta;

        try {
            Statement pst = this.conex.c.createStatement(); 
            ResultSet rs = pst.executeQuery(sql);
            
            while(rs.next()){
                return new Nota_Fiscal(rs.getInt("qtd_volumes"),rs.getString("met_cubicos"),
                     rs.getString("peso"),rs.getString("valor_nf"),rs.getString("nf"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
           this.conex.disconnect();
        }
        return null;
    }
    
//    public void alterar(Nota_Fiscal model){
//        this.conex.connect();
//        String sql = "UPDATE NOTA_FISCAL SET QTD_VOLUMES = ?, MET_CUBICOS = ?, "
//                   + "PESO = ?, VALOR_NF = ? WHERE ID_NF = ?";
//
//        try {
//            PreparedStatement pst = this.conex.c.prepareStatement(sql);
//            pst.setInt(1, model.getQtdVolumes());
//            pst.setString(2, model.getPeso());
//            pst.setString(3, model.getMetCubicos());
//            pst.setString(4, model.getValor());
//
//            pst.executeUpdate();
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao alterar nota fiscal: \n"+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
//        }finally{
//            this.conex.disconnect();
//        }
//    }
    
}