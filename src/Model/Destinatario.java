
package Model;

/**
 *
 * @author Lucas Panizio
 */
public class Destinatario {
    private int id;
    private String endereco;
    private int numero;
    private String nome;
    private String cnpj;
    private String cidade;
    private String estado;
    private String telefone;
    private String cep;

    public Destinatario(String endereco, int numero, String nome, String cnpj, String cidade, String estado, String telefone, String cep) {
        this.endereco = endereco.toUpperCase();
        this.numero = numero;
        this.nome = nome.toUpperCase();
        this.cnpj = cnpj;
        this.cidade = cidade.toUpperCase();
        this.estado = estado.toUpperCase();
        this.telefone = telefone;
        this.cep = cep;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco.toUpperCase(); }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome.toUpperCase(); }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade.toUpperCase(); }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado.toUpperCase(); }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}
