

package Servico;

import Coneccao.AlunoDao;
import Classe.Aluno;
import Classe.Cadastro;

public class AlunoServico {
    private AlunoDao alunoDao;
    public AlunoServico() {
        this.alunoDao = new AlunoDao();
        
    }
    
    
    
    
    public Cadastro inserir(Cadastro cadastro){
        return alunoDao.cadastrar(cadastro);
    }
    
    public boolean alterar(int id, Cadastro cadastro ){
        return alunoDao.alterar(cadastro, id);
    }
    
    public Cadastro consultar(int id){
        return alunoDao.consultar(id);
    }
    
    public boolean consultarLogin(String celular, String senha){
        return alunoDao.consultar(celular, senha);
    }
    
}
