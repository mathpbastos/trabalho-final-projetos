package edu.ufes.trabalho.persistencia.repository.usuario.service;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.IUsuarioRepository;
import edu.ufes.trabalho.persistencia.repository.usuario.UsuarioRepository;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class UsuarioService implements IUsuarioService{
    
    private IUsuarioRepository usuarioRepository;
    
    public UsuarioService(){
        this.usuarioRepository = new UsuarioRepository();
    }

    @Override
    public boolean criar(Usuario usuario) throws ClassNotFoundException, SQLException {
        return usuarioRepository.criar(usuario);
    }

    @Override
    public boolean excluir(Long id) throws ClassNotFoundException, SQLException {
        return usuarioRepository.excluir(id);
    }

    @Override
    public boolean alterar(Usuario usuario) throws ClassNotFoundException, SQLException {
        return usuarioRepository.alterar(usuario);
    }

    @Override
    public List<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {
        return usuarioRepository.buscarTodos();
    }

    @Override
    public Usuario buscarPorId(long id) throws ClassNotFoundException, SQLException {
        return usuarioRepository.buscarPorId(id);
    }

    @Override
    public Usuario autenticar(String login, String senha) throws ClassNotFoundException, SQLException {
        return usuarioRepository.autenticar(login, senha);
    }

    @Override
    public int contarUsuarios() throws ClassNotFoundException, SQLException {
        return usuarioRepository.contarUsuarios();
    }

    @Override
    public Usuario buscarPorIdECadastro(String nome, LocalDate dtCadastro) 
            throws ClassNotFoundException, SQLException {
        return usuarioRepository.buscarPorIdECadastro(nome, dtCadastro);
    }
    
}
