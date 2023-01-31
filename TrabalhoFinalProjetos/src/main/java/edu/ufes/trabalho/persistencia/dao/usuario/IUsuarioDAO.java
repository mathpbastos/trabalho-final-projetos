package edu.ufes.trabalho.persistencia.dao.usuario;

import edu.ufes.trabalho.model.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IUsuarioDAO {
    
    boolean salvar(Usuario usuario) throws SQLException;
    
    boolean atualizar(Usuario usuario) throws SQLException;
    
    Usuario buscarPorId(long id) throws SQLException;
    
    List<Usuario> buscarTodos() throws SQLException;
    
    Usuario buscarPorIdECadastro(String nome, LocalDate dtCadastro) throws SQLException;
    
    boolean excluir(long id) throws SQLException;
    
    Usuario autenticar(String login, String senha) throws SQLException;
    
    int contarUsuarios() throws SQLException;
    
}
