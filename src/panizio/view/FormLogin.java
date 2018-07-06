package panizio.view;

import panizio.conexao.ConexaoBanco;
import panizio.model.Usuario;
import panizio.utils.AtributosGlobais;
import panizio.utils.ManipularCampos;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lucas Panizio
 */
public class FormLogin extends javax.swing.JFrame {

    /**
     * Creates new form FormLogin
     */
    private ConexaoBanco conex;

    public FormLogin() {
        initComponents();
        getRootPane().setDefaultButton(btnEntrar);
        this.conex = new ConexaoBanco();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        lblDesenvolvedor = new javax.swing.JLabel();
        lblVersao = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SoftPan - Login");
        setMinimumSize(new java.awt.Dimension(489, 524));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        lblLogin.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(102, 102, 102));
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panizio/imagens/usuario 30x30.png"))); // NOI18N
        lblLogin.setText("Login");
        getContentPane().add(lblLogin);
        lblLogin.setBounds(100, 140, 90, 30);
        getContentPane().add(txtLogin);
        txtLogin.setBounds(40, 170, 216, 24);

        lblSenha.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(102, 102, 102));
        lblSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panizio/imagens/padlock 32x32.png"))); // NOI18N
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(100, 210, 100, 30);

        btnSair.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(102, 102, 102));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(160, 280, 100, 34);

        btnEntrar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(102, 102, 102));
        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(40, 280, 100, 34);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(40, 240, 216, 22);

        lblDesenvolvedor.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        lblDesenvolvedor.setForeground(new java.awt.Color(153, 153, 153));
        lblDesenvolvedor.setText("by Lucas Panizio");
        getContentPane().add(lblDesenvolvedor);
        lblDesenvolvedor.setBounds(330, 440, 120, 20);

        lblVersao.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        lblVersao.setForeground(new java.awt.Color(153, 153, 153));
        lblVersao.setText("Versão 2.2 - 07/2018");
        getContentPane().add(lblVersao);
        lblVersao.setBounds(330, 460, 140, 15);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panizio/imagens/fundo-login.png"))); // NOI18N
        lblFundo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 490, 530);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        List<JTextField> listaCampos = Arrays.asList(txtLogin, txtSenha);

        if (!ManipularCampos.camposVazios(listaCampos)) {  
            Usuario _usuario = ManipularCampos.checarUsuario(txtLogin.getText().toUpperCase(), txtSenha.getText());            
            if (_usuario != null) {
                AtributosGlobais.usuario = _usuario;
                new FormMinuta().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
                txtLogin.requestFocus();
                txtSenha.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos Vazios", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //txtLogin.setDocument(new TeclasMaiusculasPontos());
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblDesenvolvedor;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblVersao;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
