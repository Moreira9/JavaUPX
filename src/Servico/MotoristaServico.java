/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servico;
import Classe.Cadastro;
import Coneccao.MororistaDao;
import Classe.Motorista;


public class MotoristaServico extends Motorista {
    
    private MororistaDao motoristaDao;
    public MotoristaServico(){
        this.motoristaDao = new MororistaDao();
    }
    public Cadastro inserir(Cadastro cadastro){
        return motoristaDao.cadastrar(cadastro);
    }
    public boolean alterar(int id, Cadastro cadastro){
        return motoristaDao.alterar(cadastro, id);
    }
    public Cadastro consultar(int id){
        return motoristaDao.consultar(id);    
    }
    public Motorista inserirMotorista(Motorista motorista){
        return motoristaDao.cadastrar(motorista);
    }
    public boolean consultarLogin(String celular, String senha){
        return motoristaDao.consultar(celular, senha);
    }
    
    public Motorista consultarMotorista(int id){
        return motoristaDao.consultarMotorista(id);
    }
}
