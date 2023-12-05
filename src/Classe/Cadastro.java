
package Classe;

import java.util.Date;

public class Cadastro {
    
    private int id;
    private String nome;
    private String email;
    private String celular;
    private String senha;
    private String bairro;
    private String cidade;
    private String estado;
    private String rua;
    private String numeroCasa;
  
    

    public Cadastro() {
    }

    public Cadastro(int id, String nome, String email, String celular, String senha, String bairro, String cidade, String estado, String rua, String numeroCasa) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
      
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }



    
    
    
}
