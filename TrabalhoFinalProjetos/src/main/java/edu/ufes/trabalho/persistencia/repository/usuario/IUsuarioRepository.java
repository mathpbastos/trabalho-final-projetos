package edu.ufes.trabalho.persistencia.repository.usuario;

import edu.ufes.trabalho.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioRepository {

    public boolean criar(Usuario usuario) throws ClassNotFoundException, SQLException;

    public boolean excluir(Long id) throws ClassNotFoundException, SQLException;

    public boolean alterar(Usuario usuario) throws ClassNotFoundException, SQLException;

    public List<Usuario> buscarTodos() throws ClassNotFoundException, SQLException;

    public Usuario buscarPorId(long id) throws ClassNotFoundException, SQLException;

    public Usuario autenticar(String login, String senha)
            throws ClassNotFoundException, SQLException;
    
    public int contarUsuarios() throws ClassNotFoundException, SQLException;
}
