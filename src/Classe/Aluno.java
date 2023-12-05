/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classe;

import java.util.Date;

/**
 *
 * @author User
 */
public class Aluno extends Cadastro{
    
    private String periodo;
    private String instituicao;
    private String confimarIda;
    private String confirmarLivre;

    public Aluno(int id, String nome, String dataDeNascimento, String email, String celular, String senha, String bairro, String cidade, String estado, String rua, String numeroCasa) {
        super(id, nome, email, celular, senha, bairro, cidade, estado, rua, numeroCasa);
        this.periodo = periodo;
        this.instituicao = instituicao;
        this.confimarIda = confimarIda;
        this.confirmarLivre = confirmarLivre;
    }

    public Aluno(String periodo, String instituicao, String confimarIda, String confirmarLivre) {
        this.periodo = periodo;
        this.instituicao = instituicao;
        this.confimarIda = confimarIda;
        this.confirmarLivre = confirmarLivre;
    }
    
    
    



 

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
    
    
    
    
}
