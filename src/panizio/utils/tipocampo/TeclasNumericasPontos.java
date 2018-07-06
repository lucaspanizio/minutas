/**
 * Classe cria documentos de formatação que são utilizados nos campos
 * JTextField para delimitar tamanho do campo e teclas aceitas.
 * 
 * Aceita apenas numeros e pontos finais.
 */
package panizio.utils.tipocampo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Lucas Panizio
 */
public class TeclasNumericasPontos extends PlainDocument{
    private int tamanhoMax;
    
    public TeclasNumericasPontos(int limite){
       super();
       this.tamanhoMax = limite;
    }
    
    public TeclasNumericasPontos() {
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
         } else {                                               //[^0-9 | \\.]
             super.insertString(i, str.replaceAll("[^0-9 | \\.]",""), as); 
         }           
    }   

    @Override
    public void replace(int i, int il, String str, AttributeSet as) throws BadLocationException {
        if (str == null) return;
              
         String oldString = getText (0, getLength() );
         String newString = oldString.substring(0, i) + str + oldString.substring(i); 
                  
         if (newString.length() > tamanhoMax) {
             super.insertString(i, "", as);
         } else {             
             super.insertString(i, str.replaceAll("[^0-9 | \\.]",""), as); 
         }         
    }    
}
