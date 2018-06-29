
package panizio.model;

/**
 *
 * @author Lucas Panizio
 */
public class Nota_Fiscal {
    private int id;
    private int qtdVolumes;
    private String peso;
    private String metCubicos;
    private String valor;
    private String nf;

    public Nota_Fiscal(int qtdVolumes, String metCubicos, String peso, String valor, String nf) { 
        this.nf = nf;
        this.qtdVolumes = qtdVolumes;
        this.peso = peso;
        this.metCubicos = metCubicos;
        this.valor = valor;
    }

    public String getNf() { return nf; }    
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQtdVolumes() { return qtdVolumes; }
    public void setQtdVolumes(int qtdVolumes) { this.qtdVolumes = qtdVolumes; }

    public String getPeso() { return peso; }
    public void setPeso(String peso) { this.peso = peso; }

    public String getMetCubicos() { return metCubicos; }
    public void setMetCubicos(String metCubicos) { this.metCubicos = metCubicos; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }
}
