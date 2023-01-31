package edu.ufes.trabalho.persistencia.repository.usuario;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.dao.usuario.IUsuarioDAO;
import edu.ufes.trabalho.persistencia.dao.usuario.UsuarioDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class UsuarioRepository implements IUsuarioRepository {

    private IUsuarioDAO usuarioDAO;

    public UsuarioRepository() {
    }

    private void abrirConexoes() throws ClassNotFoundException, SQLException {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public boolean criar(Usuario usuario) throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.salvar(usuario);
    }

    @Override
    public boolean excluir(Long id) throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.excluir(id);
    }

    @Override
    public boolean alterar(Usuario usuario) throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.atualizar(usuario);
    }

    @Override
    public List<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.buscarTodos();
    }

    @Override
    public Usuario buscarPorId(long id) throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.buscarPorId(id);
    }

    @Override
    public Usuario autenticar(String login, String senha) throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.autenticar(login, senha);
    }

    @Override
    public int contarUsuarios() throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.contarUsuarios();
    }

    @Override
    public Usuario buscarPorIdECadastro(String nome, LocalDate dtCadastro) 
            throws ClassNotFoundException, SQLException {
        abrirConexoes();
        return usuarioDAO.buscarPorIdECadastro(nome, dtCadastro);
    }
    
}
