/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panizio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import panizio.conexao.ConexaoBanco;
import panizio.model.Ocorrencia;

/**
 *
 * @author Lucas Panizio
 */
public class OcorrenciaDAO {

    private ConexaoBanco conex;

    public OcorrenciaDAO() {
        this.conex = new ConexaoBanco();
    }

    public boolean inserir(Ocorrencia model) {
        this.conex.connect();
        String sql = "INSERT INTO OCORRENCIA VALUES(SEQ_OCORRENCIA.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?)";

        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);

            //pst.setInt(1, model.getId_ocorrencia());
            pst.setString(1, model.getTipo());
            pst.setString(2, model.getDescricao().toUpperCase());
            pst.setString(3, model.getRecebedor().toUpperCase());
            pst.setInt(4, model.getId_usuario());
            pst.setInt(5, model.getId_minuta());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            if (ex instanceof SQLDataException) {
                JOptionPane.showMessageDialog(null, "A data informada não é válida. \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao incluir ocorrência: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            this.conex.disconnect();
        }
        return false;
    }

    public Ocorrencia obter(int id_ocorrencia) {
        this.conex.connect();

        try {
            String sql = "SELECT * FROM OCORRENCIA WHERE ID_OCORRENCIA = ?";

            PreparedStatement pst = this.conex.getConnection().prepareStatement(sql);
            pst.setInt(1, id_ocorrencia);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {                
                Ocorrencia oc = new Ocorrencia(rs.getString("TIPO"), rs.getString("DESCRICAO"),
                        rs.getString("RECEBEDOR"), rs.getInt("ID_USUARIO"), rs.getInt("ID_MINUTA"));
                oc.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getDate("DATA")));
                return oc;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao obter minuta: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            this.conex.disconnect();
        }
        return null;
    }

    public boolean remover(int id_ocorrencia) {
        this.conex.connect();

        try {
            String sql = "DELETE OCORRENCIA WHERE ID_OCORRENCIA = " + id_ocorrencia;
            Statement pst = this.conex.c.createStatement();

            return pst.executeUpdate(sql) > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar ocorrência: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            this.conex.disconnect();
        }
        return false;
    }
}
