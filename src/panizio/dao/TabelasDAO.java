/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panizio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import panizio.conexao.ConexaoBanco;
import panizio.utils.AtributosGlobais;

/**
 *
 * @author Lucas Panizio
 */
public class TabelasDAO {
    
    private ConexaoBanco conex;
    private SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");
    
    public TabelasDAO() {
        this.conex = new ConexaoBanco();
    }
    
    
    
    /**
     * Método atualiza valores da tabela de ocorrências do formConsultarMinutas,
     * de acordo com query sql passada como parâmetro.
     *
     * @param DefaultTableModel - modelo padrão de tabelas
     * @param String - query a ser executada, se null uma query é
     * definida no método.
     */
    public void atualizarTblMinutas(DefaultTableModel modelo, String sql) {
        this.conex.connect();

        try {
            if (sql == null) {
                sql = "SELECT M.ID_MINUTA, R.NOME, D.NOME, N.NF "
                        + "FROM MINUTA M, NOTA_FISCAL N, REMETENTE R, DESTINATARIO D "
                        + "WHERE M.ID_NF = N.ID_NF AND "
                        + "M.ID_REMETENTE = R.ID_REMETENTE AND "
                        + "M.ID_DESTINATARIO = D.ID_DESTINATARIO "
                        + "ORDER BY 1 DESC";
            }

            ResultSet rs = this.conex.executar(sql);
            DefaultTableModel model = modelo;

            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.conex.disconnect();
        }
    }
    
    
    /**
     * Método atualiza valores da tabela de ocorrências do formPesquisar 
     * (Remententes ou Destinatários), de acordo com query sql passada 
     * como parâmetro, se sql = null, uma query é definida no escopo.
     * 
     * @param DefaultTableModel - modelo padrão de tabelas
     * @param String - query a ser executada, se null uma query é
     * definida no método.
     */
    public void atualizarTblRemOuDest(DefaultTableModel modelo, String sql) {
        this.conex.connect();

        try {
            if (sql == null) {
                sql = "SELECT ID_" + AtributosGlobais.tabela + ", NOME, CNPJ, ENDERECO "
                        + "FROM " + AtributosGlobais.tabela + " ORDER BY 1 DESC";
            }

            ResultSet rs = this.conex.executar(sql);
            DefaultTableModel model = modelo;

            while (model.getRowCount() > 0) model.removeRow(0); 
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)});
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.conex.disconnect();
        }
    }


    
    /**
     * Método atualiza valores da tabela de ocorrências do FormOcorrencias,
     * de acordo com query sql passada como parâmetro.
     *
     * @param DefaultTableModel - modelo padrão de tabelas
     * @param int - id da minuta
     */
    public void atualizarTblOcorrencias(DefaultTableModel modelo, int id_minuta) {
        this.conex.connect();

        try {
            String sql = "SELECT O.TIPO, O.DATA "
                    + "FROM MINUTA M, OCORRENCIA O "
                    + "WHERE M.ID_MINUTA = O.ID_MINUTA AND "
                    + "M.ID_MINUTA = " + id_minuta + " ORDER BY 2 DESC";

            ResultSet rs = this.conex.executar(sql);
            DefaultTableModel model = modelo;

            while (model.getRowCount() > 0) model.removeRow(0);
            while (rs.next()) {
                String oc = obterOcorrencia(rs.getInt(1));
                model.addRow(new Object[]{oc, formatoData.format(rs.getTimestamp(2)), AtributosGlobais.usuario.getLogin()});                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.conex.disconnect();
        }
    }
    
    private String obterOcorrencia(int valor) {
        switch (valor) {
            case 1:
                return "ENTREGA REALIZADA";
            case 2:
                return "AVARIA";
            case 3:
                return "CLIENTE AUSENTE";
            case 4:
                return "RECUSA";
            case 5:
                return "DEVOLUCAO";
            case 6:
                return "EXTRAVIO";
            case 7:
                return "OCORRENCIA FECHADA";
            case 8:
                return "FALTA DE TEMPO";
            case 9:
                return "OUTRAS OCORRENCIAS";
            default:
                return "";
        }
    }
}
