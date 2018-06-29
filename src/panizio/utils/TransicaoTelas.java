package panizio.utils;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Lucas Panizio
 */
public class TransicaoTelas {

    /**
     * Abre o frame especificado
     *
     * @param Component frame - tela a ser aberta
     */
    public static void abrir(Component frame) {       
        if (frame instanceof JFrame) {
            ((JFrame) frame).setLocationRelativeTo(null);
            ((JFrame) frame).setVisible(true);
        } else if (frame instanceof JDialog){
            ((JDialog) frame).setLocationRelativeTo(null);
            ((JDialog) frame).setVisible(true);
        }
    }
    
    /**
     * Abre determinado frame com titulo especificado
     *
     * @param Component frame - tela a ser aberta
     * @param String titulo - texto no topo da janela
     */
    public static void abrirComTitulo(Component frame, String titulo) {
        if (frame instanceof JFrame) {
            ((JFrame) frame).setLocationRelativeTo(null);
            ((JFrame) frame).setTitle(titulo);
            ((JFrame) frame).setVisible(true);
        } else if (frame instanceof JDialog){
            ((JDialog) frame).setLocationRelativeTo(null);
            ((JDialog) frame).setTitle(titulo);
            ((JDialog) frame).setVisible(true);
        }
    }

    /**
     * Fecha o primeiro frame e abre o segundo com o título
     * especificado.
     *
     * @param Component framePrimeiro - tela de saída
     * @param Component frameSegundo - tela de chegada
     * @param String titulo - título do topo da janela final
     */
    public static void trocarComTitulo(Component framePrimeiro, Component frameSegundo, String titulo) {
        if (framePrimeiro instanceof JFrame && frameSegundo instanceof JFrame) {
            ((JFrame) framePrimeiro).dispose();
            ((JFrame) frameSegundo).setLocationRelativeTo(null);
            ((JFrame) frameSegundo).setTitle(titulo);
            ((JFrame) frameSegundo).setVisible(true);
        } else {
            ((JDialog) framePrimeiro).dispose();
            ((JDialog) frameSegundo).setLocationRelativeTo(null);
            ((JDialog) frameSegundo).setTitle(titulo);
            ((JDialog) frameSegundo).setVisible(true);
        }
    }

    /**
     * Fecha o primeiro frame e abre o segundo
     *
     * @param Component framePrimeiro - tela de saída
     * @param Component frameSegundo - tela de chegada
     */
    public static void trocar(Component framePrimeiro, Component frameSegundo) {
        if (framePrimeiro instanceof JFrame && frameSegundo instanceof JFrame) {
            ((JFrame) framePrimeiro).dispose();            
            ((JFrame) frameSegundo).setVisible(true);
        } else {
            ((JDialog) framePrimeiro).dispose();            
            ((JDialog) frameSegundo).setVisible(true);
        }
    }
    
    /**
     * Fecha o primeiro frame e abre o segundo com o foco o textfield
     * especificado.
     *
     * @param Component framePrimeiro - tela de saída
     * @param Component frameSegundo - tela de chegada
     * @param JTextField txt - campo de foco na tela final
     */
    public static void trocarComFoco(Component framePrimeiro, Component frameSegundo, JTextField txt) {
        if (framePrimeiro instanceof JFrame && frameSegundo instanceof JFrame) {
            ((JFrame) framePrimeiro).setLocationRelativeTo(null);
            txt.requestFocus();
            ((JFrame) frameSegundo).setVisible(true);
        } else {
            ((JDialog) framePrimeiro).setLocationRelativeTo(null);
            txt.requestFocus();
            ((JDialog) frameSegundo).setVisible(true);
        }
    }
    
    /**
     * Fecha o primeiro frame e abre o segundo com o foco no textfield
     * especificado e titulo.
     *
     * @param Component - framePrimeiro tela de saída
     * @param Component - frameSegundo tela de chegada
     * @param JTextField txt - campo de foco na tela final
     * @param String titulo - texto no topo da janela
     */
//    public static void trocarComFocoTitulo(Component framePrimeiro, Component frameSegundo, JTextField txt, String titulo) {
//        if (framePrimeiro instanceof JFrame && frameSegundo instanceof JFrame) {
//            ((JFrame) framePrimeiro).setLocationRelativeTo(null);
//            ((JFrame) framePrimeiro).setTitle(titulo);           
//            ((JFrame) frameSegundo).setVisible(true);
//            txt.requestFocus(true);
//        } else {
//            ((JDialog) framePrimeiro).setLocationRelativeTo(null);
//            ((JDialog) framePrimeiro).setTitle(titulo);            
//            ((JDialog) frameSegundo).setVisible(true);
//            txt.requestFocus();
//        }
//    }
    
    /**
     * Abre determinado frame com titulo e foco num campo especificado
     *
     * @param Component frame - tela a ser aberta
     * @param JTextField txt - campo de foco na tela
     * @param String titulo - texto no topo da janela
     */
    public static void abrirComFocoTitulo(Component frame, JTextField txt, String titulo) {
        if (frame instanceof JFrame) {
            ((JFrame) frame).setLocationRelativeTo(null);
            ((JFrame) frame).setTitle(titulo);
            ((JFrame) frame).setVisible(true);
            txt.requestFocus();            
        } else {
            ((JDialog) frame).setLocationRelativeTo(null);
            ((JDialog) frame).setTitle(titulo);
            ((JDialog) frame).setVisible(true);
            txt.requestFocus(); 
        }
    }
}
