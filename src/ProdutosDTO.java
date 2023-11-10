/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class ProdutosDTO {
    private Integer id;
    private String nome;
    private String valor;
    private String status;

    public ProdutosDTO(Integer id, String nome, String valor, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    public ProdutosDTO(String nome, String valor, String status) {
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    public ProdutosDTO(String status) {
        this.status = status;
    }

    public ProdutosDTO(Integer id, String status) {
        this.id = id;
        this.status = status;
    }
    
    

    ProdutosDTO() {

    }
    
    

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
