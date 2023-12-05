
package Coneccao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Classe.Aluno;
import Classe.Cadastro;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDao extends Cadastro {

    private Connection conn;

    public AlunoDao() {
        conn = new ConectionFactory().getConnection();

    }
    public int maiorValor(Cadastro cadastro){
        String query = "SELECT MAX(id) AS max_id FROM Cadastro";
        int maxId = 0;
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                maxId = resultSet.getInt("max_id");
            }

        } catch (SQLException e) {
            e.getMessage(); // Trate a exceção de acordo com sua lógica de tratamento de erros
        }
        return maxId;
    }
    public Cadastro cadastrar(Cadastro cadastro) {
        String query = "INSERT INTO Cadastro(nome, email, celular, senha, bairro,cidade,estado,rua, numeroCasa, motoristaOuAluno ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,'Aluno');";
        ResultSet resultado = null;

        try {
            
            PreparedStatement preparedStatement = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, cadastro.getNome());
            preparedStatement.setString(2, cadastro.getEmail());
            preparedStatement.setString(3, cadastro.getCelular());
            preparedStatement.setString(4, cadastro.getSenha());
            preparedStatement.setString(5, cadastro.getBairro());
            preparedStatement.setString(6, cadastro.getCidade());
            preparedStatement.setString(7, cadastro.getEstado());
            preparedStatement.setString(8, cadastro.getRua());
            preparedStatement.setString(9, cadastro.getNumeroCasa());
        
            preparedStatement.executeUpdate();
            resultado = preparedStatement.getGeneratedKeys();

            if (resultado.next()) {
                cadastro.setId(resultado.getInt(1));
            }

            return cadastro;

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
    }
    public boolean alterar(Cadastro cadastro,int id){
        String query = "update Cadastro set nome = ?,email = ?,celular = ?,senha = ?,bairro = ?,cidade = ?,estado = ?,rua = ?, numeroCasa = ? where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conn.prepareCall(query);
            preparedStatement.setString(1, cadastro.getNome());
            preparedStatement.setString(2, cadastro.getEmail());
            preparedStatement.setString(3, cadastro.getCelular());
            preparedStatement.setString(4, cadastro.getSenha());
            preparedStatement.setString(5, cadastro.getBairro());
            preparedStatement.setString(6, cadastro.getCidade());
            preparedStatement.setString(7, cadastro.getEstado());
            preparedStatement.setString(8, cadastro.getRua());
            preparedStatement.setString(9, cadastro.getNumeroCasa());
            preparedStatement.setInt(10, id);
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
      
            return false;
           
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
            
        }
    }
    
    
    public Cadastro consultar(int id){
        Cadastro cadastro = new Cadastro();
        String query = "select * from Cadastro where id = ?";
        PreparedStatement preparedStatement;
        ResultSet resulSet;
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resulSet = preparedStatement.executeQuery();
            if(resulSet.next()){
                cadastro.setId(resulSet.getInt("id"));
                cadastro.setNome(resulSet.getString("nome"));
                cadastro.setEmail(resulSet.getString("email"));
                cadastro.setCelular(resulSet.getString("celular"));
                cadastro.setSenha(resulSet.getString("senha"));
                cadastro.setBairro(resulSet.getString("bairro"));
                cadastro.setCidade(resulSet.getString("cidade"));
                cadastro.setEstado(resulSet.getString("estado"));
                cadastro.setRua(resulSet.getString("rua"));
                cadastro.setNumeroCasa(resulSet.getString("numeroCasa"));
                   
            }
            return cadastro;
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public boolean consultar(String celular, String senha){
        Cadastro cadastro = new Cadastro();
        
        String query = "select * from Cadastro where celular = ? and senha = ? and motoristaOuAluno = 'Aluno'";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, celular);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            return false;
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    
    
}
