package Coneccao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Classe.Aluno;
import Classe.Cadastro;
import Classe.Motorista;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MororistaDao {

    private Connection conn;

    public MororistaDao() {
        conn = new ConectionFactory().getConnection();
    }

    public int maiorValor(Cadastro cadastro) {
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
        String query = "INSERT INTO Cadastro(nome, email, celular, senha, bairro,cidade,estado,rua, numeroCasa, motoristaOuAluno ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,'Motorista');";
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

    public boolean alterar(Cadastro cadastro, int id) {
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
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    public Cadastro consultar(int id) {
        Cadastro cadastro = new Cadastro();
        String query = "select * from Cadastro where id = ?";
        PreparedStatement preparedStatement;
        ResultSet resulSet;
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resulSet = preparedStatement.executeQuery();
            if (resulSet.next()) {
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

    public Motorista cadastrar(Motorista motorista) {
        String query = "INSERT INTO Motorista(cnh, modelo_van, placa,assentos, valor, cadastro_id) VALUES (?, ?, ?, ?, ?, ?);";
        ResultSet resultado = null;

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, motorista.getCnh());
            preparedStatement.setString(2, motorista.getModeloVan());
            preparedStatement.setString(3, motorista.getPlaca());
            preparedStatement.setInt(4, motorista.getAssentos());
            preparedStatement.setDouble(5, motorista.getValorAcobrar());
            preparedStatement.setInt(6, motorista.getId_cadastro());
           

            preparedStatement.executeUpdate();
            resultado = preparedStatement.getGeneratedKeys();

            if (resultado.next()) {
                motorista.setId_motorista(resultado.getInt(1));
            }
            return motorista;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        
       

}
    
    public Motorista consultarMotorista(int id){
        Motorista motorista = new Motorista();
        String query = "select * from Motorista where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;    
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                motorista.setId(resultSet.getInt("id"));
                motorista.setAssentos(resultSet.getInt("assentos"));
                motorista.setCnh(resultSet.getString("cnh"));
                motorista.setPlaca(resultSet.getString("placa"));
                
                
                
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
        
    }
    
    public boolean consultar(String celular,String senha){
        Cadastro cadastro = new Cadastro();
        String query = "select * from Cadastro where celular = ? and senha = ? and motoristaOuAluno = 'Motorista'";
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
