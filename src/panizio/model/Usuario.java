
package panizio.model;

/**
 *
 * @author Lucas Panizio
 */
public class Usuario {
    private int id;
    private String nome;
    private String perfil;
    private String situacao;
    private String login;
    private String senha;

    

    public Usuario(String nome, String perfil, String situacao, String login, String senha) {
        this.nome = nome;
        this.perfil = perfil;
        this.situacao = situacao;
        this.login = login;
        this.senha = senha;
    }
    
//    public Usuario(int id, String login, String perfil) {
//        this.id = id;
//        this.login = login;
//        this.perfil = perfil;        
//    }
//    
    public Usuario(int id, String nome, String perfil, String status, String login, String senha) {
        this(nome, perfil, status, login, senha);
        this.id = id;        
    }

    public Usuario() { }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }   
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }    

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }   
}
