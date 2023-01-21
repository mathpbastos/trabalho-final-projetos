package edu.ufes.trabalho.persistencia.dao.usuario;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.conexao.ConexaoSQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO{
    
    private Connection conexao;
    private final DateTimeFormatter formatador = 
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

    @Override
    public long salvar(Usuario usuario) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            String query = "INSERT INTO usuarios ("
                    + "nm_usuario" //1
                    + ", login" //2
                    + ", senha" //3
                    + ", dt_cadastro" //4
                    + ", dt_modificacao)" //5
                    + " VALUES "
                    + "(?, ?, ?, ?, ?)"
                    + "RETURNING id_usuario;";
            
            ps = conexao.prepareStatement(query);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            /*
            Como o Sqlite utiliza strings para armazenar datas, realizamos a 
            conversão da hora atual para string.
            */
            ps.setString(4, 
                    formatador.format(LocalDate.now()));
            ps.setString(5, 
                    formatador.format(LocalDate.now()));
            
            rs = ps.executeQuery();
            
            if(!rs.next())
                throw new SQLException("Usuário não cadastrado.");
            
            return rs.getLong(1);
        } catch (SQLException ex){
            throw new SQLException("Erro ao cadastrar usuário."
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.fecharConexao(conexao, ps, rs);
        }
    }

    @Override
    public boolean alterar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario buscarPorId(long id) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String query = "SELECT "
                    + "u.nm_usuario"
                    + ", u.login"
                    + ", u.senha"
                    + ", u.dt_cadastro"
                    + ", u.dt_modificacao "
                    + "FROM usuarios u "
                    + "WHERE u.id_usuario = ?;"; // 1
            ps = conexao.prepareStatement(query);
            ps.setLong(1, id);
            
            rs = ps.executeQuery();
            if(!rs.next())
                throw new SQLException("Usuário com id " + id + 
                        " não encontrado.");
            String nome = rs.getString(1);
            String login = rs.getString(2);
            String senha = rs.getString(3);
            LocalDate dtCadastro = LocalDate.parse(rs.getString(4),
                    formatador);
            LocalDate dtModificacao = LocalDate.parse(rs.getString(5),
                    formatador);
            return new Usuario(id, 
                    nome, 
                    login, 
                    senha,
                    dtCadastro,
                    dtModificacao);
        } catch(SQLException ex) {
            throw new SQLException("Erro ao buscar o usuário.\n"
                    + ex.getMessage());
        } finally{
            ConexaoSQLite.fecharConexao(conexao, ps, rs);
        }        
    }

    @Override
    public List<Usuario> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
