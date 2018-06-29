package panizio.dao;

import panizio.conexao.ConexaoBanco;
import panizio.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Lucas Panizio
 */
public class UsuarioDAO {

    private ConexaoBanco conex;

    public UsuarioDAO() {
        this.conex = new ConexaoBanco();
    }

    public void inserir(Usuario model) {
        this.conex.connect();
        String sql = "INSERT INTO USUARIO VALUES(SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            pst.setString(1, model.getLogin());
            pst.setString(2, model.getSenha());
            pst.setString(3, model.getNome());
            pst.setString(4, model.getPerfil());
            pst.setString(5, model.getStatus());

            if (pst.executeUpdate() > 0) {//SE O NÚMERO DE LINHAS AFETAS FOI MAIOR QUE 0, SIGNIFICA QUE FOI INSERIDO
                JOptionPane.showMessageDialog(null, "Usuário " + model.getLogin() + " inserido com sucesso!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.conex.disconnect();
        }
    }

    public void alterar(Usuario model) {
        this.conex.connect();
        String sql = "UPDATE USUARIO SET LOGIN = ?, SENHA = ?, NOME = ?, PERFIL = ?, SITUACAO = ? WHERE ID_USUARIO = ?";

        try {
            PreparedStatement pst = this.conex.c.prepareStatement(sql);
            pst.setString(1, model.getLogin());
            pst.setString(2, model.getSenha());
            pst.setString(3, model.getNome());
            pst.setString(4, model.getPerfil());
            pst.setString(5, model.getStatus());
            pst.setInt(6, model.getId());

            if (pst.executeUpdate() > 0) {//SE O NÚMERO DE LINHAS AFETAS FOI MAIOR QUE 0, SIGNIFICA QUE FOI INSERIDO
                JOptionPane.showMessageDialog(null, "Usuário " + model.getLogin() + " alterado com sucesso!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuário: \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.conex.disconnect();
        }
    }
    
    public void commit() throws SQLException {
        this.conex.c.commit();
    }
    
    public void rollback() throws SQLException {
        this.conex.c.rollback();
    }

    public List<Usuario> listarUsuarios() {
        this.conex.connect();

        try {
            String sql = "SELECT ID_USUARIO,NOME,PERFIL,SITUACAO,LOGIN,SENHA FROM USUARIO";
            Statement stmt = this.conex.c.createStatement();
            List<Usuario> listaUsuario = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Usuario user = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));

                listaUsuario.add(user);
            }

            return listaUsuario;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
