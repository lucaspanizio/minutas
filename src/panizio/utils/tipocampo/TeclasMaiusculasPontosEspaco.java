/**
 * Classe cria documentos de formatação que são utilizados nos campos
 * JTextField para delimitar tamanho do campo e teclas aceitas.
 * 
 * Transforma qualquer letra em maiuscula e aceita algumas pontuações
 * (,  .  /  -  |  :  ;)
 */
package panizio.utils.tipocampo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Lucas Panizio
 */
public class TeclasMaiusculasPontosEspaco extends PlainDocument{
    private int tamanhoMax;
    
    public TeclasMaiusculasPontosEspaco(int limite){
       super();
       this.tamanhoMax = limite;
    }
    
    public TeclasMaiusculasPontosEspaco() {
        super();
        this.tamanhoMax = 1000;
    }
    
    @Override
    public void insertString(int i, String str, AttributeSet as) throws BadLocationException {
        if (str == null) return;
              
         String oldString = getText (0, getLength() );
         String newString = oldString.substring(0, i) + str + oldString.substring(i); 
                  
         if (newString.length() > tamanhoMax) {
             super.insertString(i, "", as);
         } else {             
             super.insertString(i, str.toUpperCase().replaceAll("([^(a-zA-Z) | \\. | \\; | \\/ | \\| \\- | \\: | \\s])",""), as);
         }         
    }

    @Override
    public void replace(int i, int i1, String str, AttributeSet as) throws BadLocationException {
        if (str == null) return;
              
         String oldString = getText (0, getLength() );
         String newString = oldString.substring(0, i) + str + oldString.substring(i); 
                  
         if (newString.length() > tamanhoMax) {
             super.insertString(i, "", as);
         } else {             
             super.insertString(i, str.toUpperCase().replaceAll("([^(a-zA-Z) | \\. | \\; | \\/ | \\| \\- | \\: | \\s])",""), as);
         }          
    }
         
        
}
