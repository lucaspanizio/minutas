/**
 * Classe cria documentos de formatação que são utilizados nos campos
 * JTextField para delimitar tamanho do campo e teclas aceitas.
 * 
 * Aceita apenas numeros.
 */
package FormatarCampos;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Lucas Panizio
 */
public class TeclasNumericas extends PlainDocument{
    private int tamanhoMax;
    
    public TeclasNumericas(int limite){
       super();
       this.tamanhoMax = limite;
    }
    
    public TeclasNumericas() {
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
             // Repassa para o pai.
             super.insertString(i, str.toUpperCase().replaceAll("[^0-9]",""),as);
         }
        //super.insertString(i, str.toUpperCase().replaceAll("[^0-9]",""),as);
        
    }

    @Override
    public void replace(int i, int i1, String str, AttributeSet as) throws BadLocationException {
        if (str == null) return;
              
         String oldString = getText (0, getLength() );
         String newString = oldString.substring(0, i) + str + oldString.substring(i); 
                  
         if (newString.length() > tamanhoMax) {
             super.insertString(i, "", as);
         } else {
             // Repassa para o pai.
             super.insertString(i, str.toUpperCase().replaceAll("[^0-9]",""),as);
         }
        //super.insertString(i, str.toUpperCase().replaceAll("[^0-9]",""),as);
    }
    
}
