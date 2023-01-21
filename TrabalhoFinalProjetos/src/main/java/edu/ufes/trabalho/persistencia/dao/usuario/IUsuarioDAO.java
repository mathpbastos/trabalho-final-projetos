package edu.ufes.trabalho.persistencia.dao.usuario;

import edu.ufes.trabalho.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {
    
    long salvar(Usuario usuario) throws SQLException;
    
    boolean alterar(Usuario usuario) throws SQLException;
    
    Usuario buscarPorId(long id) throws SQLException;
    
    List<Usuario> buscarTodos();
    
    boolean excluir(long id);
    
}
