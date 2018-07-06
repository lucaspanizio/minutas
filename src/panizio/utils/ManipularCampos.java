package panizio.utils;

import panizio.dao.UsuarioDAO;
import panizio.model.Usuario;
import panizio.utils.tipocampo.TeclasNaoNumericas;
import panizio.utils.tipocampo.TeclasNumericas;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultStyledDocument;
import panizio.utils.tipocampo.TeclasNumericasVirgulas;

public class ManipularCampos {

    /**
     * Percorre a lista de suporte em busca de um que tenha usuario e senha
     * identico com os que estão passados por parametro
     *
     * @param login - login em String
     * @param senha - senha em char[]
     * @return Suporte correspondente com usuario e senha, se não houver retorna
     * null
     */
    public static Usuario checarUsuario(String login, String senha) {
        UsuarioDAO userDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = userDAO.listarUsuarios();
        for (Usuario user : listaUsuarios) {
            if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Percorre toda a lista de campos, se houver algum vazio retorna true
     *
     * @param listaCampos - Campos para validar
     * @return true se houver ao menos um campos em branco, false se todos
     * estiverem preenchidos.
     */
    public static boolean camposVazios(List<JTextField> listaCampos) {
        return listaCampos.stream().anyMatch((cmp) -> (cmp.getText().equals("")));
    }

    /**
     * Percorre toda a lista de campos, e retorna todos os campos vazios se não
     * houver nenhum, retorna null
     *
     * @param listaCampos - lista dos campos para validar
     * @return lista com campos em brancos
     */
    public static List<JTextField> camposEmBranco(List<JTextField> listaCampos) {
        List<JTextField> campos = new ArrayList<>();
        listaCampos.stream().filter((cmp) -> (cmp.getText().equals(""))).forEachOrdered((cmp) -> {
            campos.add(cmp);
        });
        return !campos.isEmpty() ? campos : null;
    }

    /**
     * Percorre toda uma lista de campos (JTextField/Formated/Area), se houver
     * algum vazio retorna true
     *
     * @param campos - lista de campos para validar
     * @return true se não houver campos em branco, false se houver
     */
    public static boolean camposVaziosGenerico(List<Component> campos) {

        for (Component c : campos) {
            if (c instanceof JFormattedTextField) {
                if (((JFormattedTextField) c).getValue() == null) {
                    return true;
                }
            } else if (c instanceof JTextField) {
                if (((JTextField) c).getText().isEmpty()) {
                    return true;
                }
            } else if (c instanceof JTextArea) {
                if (((JTextArea) c).getText().isEmpty()) {
                    return true;
                }
            } else if (c instanceof JComboBox) {
                if (((JComboBox) c).getSelectedIndex() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

//    /**
//     * Seta default no formato do texto (teclas aceitas).
//     *
//     * @param List<JTextField> - campos a serem setados com formatação padrão.
//     */
//    public static void formatarCampoDefault(List<Component> campos) {
//        for (Component txt : campos) {
//            if (txt instanceof JTextField) {
//                ((JTextField) txt).setDocument(new DefaultStyledDocument());
//            }
//        }
//    }

    /**
     * Defini que o campo somente permitirá teclas alfabéticas (letras).
     *
     * @param JTextField - campo a ser formatado.
     * @param int - quantidade de teclas permitidas.
     */
    public static void formatarCampoNaoNumerico(JTextField txt, int tamanho) {
        txt.setDocument(new TeclasNaoNumericas(tamanho));
    }

    /**
     * Defini que o campo somente permitirá teclas numéricas.
     *
     * @param JTextField - campo a ser formatado.
     * @param int - quantidade de teclas permitidas.
     */
    public static void formatarCampoNumerico(JTextField txt, int tamanho) {
        txt.setDocument(new TeclasNumericas(tamanho));
    }

    /**
     * Defini que o campo somente permitirá teclas númericas e as vírgulas.
     *
     * @param JTextField - campo a ser formatado.
     * @param int - quantidade de teclas permitidas.
     */
    public static void formatarCampoNumericasVirgulas(JTextField txt, int tamanho) {
        txt.setDocument(new TeclasNumericasVirgulas(tamanho));
    }

    /**
     * Passado uma lista de campos (JTextField/Formatted/Area), um loop os
     * percorrerá e limpará seus textos.
     *
     * @param text - lista de campos a serem limpos.
     */
    public static void limparCampos(List<Component> text) {
        for (Component c : text) {            
            if (c instanceof JFormattedTextField) {                 
                ((JFormattedTextField) c).setText(null);
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setText(null);
            } else if (c instanceof JTextField) {
                ((JTextField) c).setDocument(new DefaultStyledDocument());
                ((JTextField) c).setText(null);
            } else if (c instanceof JComboBox){
                ((JComboBox) c).setSelectedIndex(0);
            }
        }
    }

    /**
     * Método tem o propósito de habilitar (enable(true)) ou desabilitar (enable
     * (false)) os campos (JTextField/Formatted/Area) passados em parametro.
     *
     * @param cpnt - lista de campos a serem limpos.
     * @param flag - true para habilitar, false para desabilitar.
     */
    public static void habilitar_desabilitar(List<Component> cpnt, boolean flag) {
        for (Component c : cpnt) {
            c.setEnabled(flag);
        }
    }

    public static String obterOcorrencia(String valor) {
        switch (valor) {
            case "01":
                return "ENTREGA REALIZADA";
            case "02":
                return "AVARIA";
            case "03":
                return "CLIENTE AUSENTE";
            case "04":
                return "RECUSA";
            case "05":
                return "DEVOLUCAO";
            case "06":
                return "EXTRAVIO";
            case "07":
                return "OCORRENCIA FECHADA";
            case "08":
                return "FALTA DE TEMPO";
            case "09":
                return "OUTRAS OCORRENCIAS";
            default:
                return "";
        }
    }

//    /**
//     * Percorre toda uma lista de campos (JTextField/Formated/Area), habilitando
//     * ou desabilitando a editação.
//     *
//     * @param campos - lista de campos.
//     */
//    public static void habilitar_desabilitar_editacao(List<Component> campos, boolean flag){ 
//       
//       for(Component c : campos){
//            if (c instanceof JFormattedTextField) {
//                if(((JFormattedTextField) c).getText().isEmpty()) {
//                    ((JFormattedTextField) c).setEditable(flag);
//                }  
//            } else if (c instanceof JTextField){
//                if(((JTextField) c).getText().isEmpty()) {               
//                    ((JTextField) c).setEditable(flag);
//                }
//            } else if (c instanceof JTextField){
//                if(((JTextArea) c).getText().isEmpty()) {               
//                    ((JTextArea) c).setEditable(flag);
//                }
//              }
//        }
//    }
}
