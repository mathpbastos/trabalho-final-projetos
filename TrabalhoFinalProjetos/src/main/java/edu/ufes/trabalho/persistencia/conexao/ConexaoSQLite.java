package edu.ufes.trabalho.persistencia.conexao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            
            try{
                Dotenv env = Dotenv.configure()
                        .directory("./resources")
                        .filename(".env")
                        .load();
                conexao = DriverManager.getConnection(
                        env.get("DB_URL")
                );
            }
            catch(SQLException ex){
                throw new SQLException("Erro durante conexão com o banco."
                        + ex.getMessage());
            }
        }
        catch (ClassNotFoundException ex){
            throw new SQLException("Classe não encontrada.\n"
                    + ex.getMessage());
        }
        
        return conexao;
    }

    public static void fecharConexao(Connection conexao) throws SQLException {
        if(conexao != null){
            try{
                conexao.close();
            }
            catch (SQLException ex){
                throw new SQLException("Não foi possível encerrar a conexão"
                        + ex.getMessage());
            }
        }
    }

    public static void fecharConexao(Connection conexao, Statement statement) 
            throws SQLException {
        if(conexao != null){
            try{
                conexao.close();
            }
            catch (SQLException ex){
                throw new SQLException("Não foi possível encerrar a conexão"
                        + ex.getMessage());
            }
        }
        if(statement != null)
            statement.close();
    }

    public static void fecharConexao(Connection conexao, Statement statement, 
            ResultSet resultSet) throws SQLException {
        if(conexao != null){
            try{
                conexao.close();
            }
            catch (SQLException ex){
                throw new SQLException("Não foi possível encerrar a conexão"
                        + ex.getMessage());
            }
        }
        if(statement != null)
            statement.close();
        if(resultSet != null)
            resultSet.close();
    }
           
}
