/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classe;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Motorista extends Cadastro{
    private int id_motorista;
    private String placa;
    private String cnh;
    private String modeloVan;
    private int assentos;
    private ArrayList<String> instituicoes; 
    private double valorAcobrar;
    private int id_cadastro;

    public Motorista() {
    }

    public Motorista(int id_motorista, String cnh,String modeloVan,String placa,int assentos,double valorAcobrar,int id_cadastro) {
        this.id_motorista = id_motorista;
        this.placa = placa;
        this.cnh = cnh;
        this.modeloVan = modeloVan;
        this.assentos = assentos;
        this.valorAcobrar = valorAcobrar;
        this.id_cadastro = id_cadastro;
    }
    
    public Motorista(String placa, String cnh, String modeloVan, int assentos, ArrayList<String> instituicoes, double valorAcobrar, int id, String nome, String dataDeNascimento, String email, String celular, String senha, String bairro, String cidade, String estado, String rua, String numeroCasa) {
        super(id, nome, email, celular, senha, bairro, cidade, estado, rua, numeroCasa);
        this.placa = placa;
        this.cnh = cnh;
        this.modeloVan = modeloVan;
        this.assentos = assentos;
        this.instituicoes = instituicoes;
        this.valorAcobrar = valorAcobrar;
    }

    public int getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(int id_motorista) {
        this.id_motorista = id_motorista;
    }



    public int getId_cadastro() {
        return id_cadastro;
    }

    public void setId_cadastro(int id_cadastro) {
        this.id_cadastro = id_cadastro;
    }


    
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getModeloVan() {
        return modeloVan;
    }

    public void setModeloVan(String modeloVan) {
        this.modeloVan = modeloVan;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public ArrayList<String> getInstituicoes() {
        return instituicoes;
    }

    public void setInstituicoes(ArrayList<String> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public double getValorAcobrar() {
        return valorAcobrar;
    }

    public void setValorAcobrar(double valorAcobrar) {
        this.valorAcobrar = valorAcobrar;
    }
    
    
    
    
}
