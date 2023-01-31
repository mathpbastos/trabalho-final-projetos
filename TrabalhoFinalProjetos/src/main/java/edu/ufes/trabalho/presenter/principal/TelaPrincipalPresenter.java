package edu.ufes.trabalho.presenter.principal;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.presenter.login.observer.ITelaLoginObserver;
import edu.ufes.trabalho.state.tela.principal.command.AbrirAlterarSenhaCommand;
import edu.ufes.trabalho.state.tela.principal.command.AbrirTelaCadastroCommand;
import edu.ufes.trabalho.state.tela.principal.command.AbrirTelaLoginCommand;
import edu.ufes.trabalho.state.tela.principal.command.DeslogarCommand;
import edu.ufes.trabalho.state.tela.principal.command.LogarCommand;
import edu.ufes.trabalho.state.tela.principal.command.AbrirBuscarUsuarioCommand;
import edu.ufes.trabalho.state.tela.principal.command.PrincipalPresenterCommand;
import edu.ufes.trabalho.view.principal.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipalPresenter implements ITelaLoginObserver {

    private TelaPrincipalView view;
    private UsuarioService usuarioService;
    private Usuario usuarioAtual;
    private PrincipalPresenterCommand command;

    public TelaPrincipalPresenter() {
        view = new TelaPrincipalView();
        initServices();
        initState();
        initListeners();
        view.setVisible(true);
    }

    private void initServices() {
        this.usuarioService = new UsuarioService();
    }

    private void initListeners() {
        // Menu item novo usuário
        view.getMiNovoUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });

        // Menu item sair
        view.getMiSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });

        // Menu item listar usuarios
        view.getMiListarUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirBuscarUsuarios();
            }
        });

        // Menu item deslogar
        view.getMiDeslogar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarSessao();
            }
        });

        // Menu item alterar senha
        view.getMiAlterarSenha().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAlterarSenha();
            }
        });

        view.getMiLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirLogin();
            }
        });
    }

    private void initState() {
        this.command = new DeslogarCommand(this);
        command.executar();
    }

    private void abrirLogin() {
        this.command = new AbrirTelaLoginCommand(this);
        this.command.executar();
    }

    private void abrirTelaCadastro() {
        this.command = new AbrirTelaCadastroCommand(this);
        this.command.executar();
    }

    private void sair() {
        this.view.dispose();
    }

    private void abrirBuscarUsuarios() {
        this.command = new AbrirBuscarUsuarioCommand(this);
        command.executar();
    }

    private void encerrarSessao() {
        this.command = new DeslogarCommand(this);
        this.command.executar();
    }

    public void abrirAlterarSenha() {
        this.command = new AbrirAlterarSenhaCommand(this);
        this.command.executar();
    }

    public TelaPrincipalView getView() {
        return this.view;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    @Override
    public void atualizar(Usuario usuario) {
        this.usuarioAtual = usuario;
        if (usuarioAtual != null) {
            this.command = new LogarCommand(this);
            command.executar();
        }
    }

}
