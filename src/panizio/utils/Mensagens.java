/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panizio.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Panizio
 */
public class Mensagens {
    
    public static void erro_tipoFrete(){    
       JOptionPane.showMessageDialog(null, "Tipo do frete não especificado.", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void erro_campoVazio(){    
       JOptionPane.showMessageDialog(null, "Verifique se os campos foram preenchidos corretamente.", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void erro_abrirMinuta(){    
       JOptionPane.showMessageDialog(null, " Não foi possível apresentar o documento.", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    
}
