/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panizio.model;

/**
 *
 * @author Lucas Panizio
 */
public class Ocorrencia {
    private int id_minuta;
    private String tipo;
    private String descricao;    
    private String recebedor;
    private int id_usuario; 
    private int id_ocorrencia;
    private String data;

    public Ocorrencia(String tipo, String descricao, String recebedor, int id_usuario, int id_minuta) {
        this.tipo = tipo;
        this.descricao = descricao;        
        this.recebedor = recebedor;
        this.id_usuario = id_usuario;
        this.id_minuta = id_minuta;
    }   
    
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    
    public int getId_ocorrencia() { return id_ocorrencia; }
    public void setId_ocorrencia(int id_minuta) { this.id_ocorrencia = id_ocorrencia; }
    
    public int getId_minuta() { return id_minuta; }
    public void setId_minuta(int id_minuta) { this.id_minuta = id_minuta; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getRecebedor() { return recebedor; }
    public void setRecebedor(String recebedor) { this.recebedor = recebedor; }

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }
}
