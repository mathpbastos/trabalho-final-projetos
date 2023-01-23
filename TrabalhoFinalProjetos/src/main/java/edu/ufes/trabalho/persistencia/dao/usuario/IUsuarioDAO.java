package edu.ufes.trabalho.persistencia.dao.usuario;

import edu.ufes.trabalho.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {
    
    boolean salvar(Usuario usuario) throws SQLException;
    
    boolean atualizar(Usuario usuario) throws SQLException;
    
    Usuario buscarPorId(long id) throws SQLException;
    
    List<Usuario> buscarTodos() throws SQLException;
    
    boolean excluir(long id) throws SQLException;
    
}
