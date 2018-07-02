
package panizio.model;

/**
 *
 * @author Lucas Panizio
 */
public class Minuta {    
    private int id;
    private int id_nf;
    private String emissao;
    private String valor;
    private int id_usuario;
    private int id_destinatario;
    private int id_remetente;    
    private String obs;

    public Minuta(String emissao, String valor, int id_usuario, int id_destinatario, int id_remetente, String obs, int id_nf) {
        this.id_nf = id_nf;
        this.emissao = emissao;
        this.valor  = valor;        
        this.id_usuario = id_usuario;
        this.id_destinatario = id_destinatario;
        this.id_remetente = id_remetente;
        this.obs = obs == null ? "" : obs.toUpperCase();
    }

    public int getId_nf() { return id_nf;  }
    
    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public String getEmissao() { return emissao; }
    public void setEmissao(String emissao) { this.emissao = emissao; }

    public int getId() { return id; } 
    public void setId(int id) { this.id = id; }

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

    public int getId_destinatario() { return id_destinatario; }
    public void setId_destinatario(int id_destinatario) { this.id_destinatario = id_destinatario; }

    public int getId_remetente() { return id_remetente; }
    public void setId_remetente(int id_remetente) { this.id_remetente = id_remetente; }
    
    public String getObs() { return obs; }
    public void setObs(String obs) { this.obs = obs; }       
}
