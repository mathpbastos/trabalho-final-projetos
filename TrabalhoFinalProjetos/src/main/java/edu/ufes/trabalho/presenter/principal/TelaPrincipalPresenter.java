package edu.ufes.trabalho.presenter.principal;

import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.presenter.cadastro.TelaCadastroPresenter;
import edu.ufes.trabalho.state.tela.principal.CadastroState;
import edu.ufes.trabalho.state.tela.principal.LoginState;
import edu.ufes.trabalho.state.tela.principal.TelaPrincipalState;
import edu.ufes.trabalho.view.principal.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaPrincipalPresenter {
    private TelaPrincipalView view;
    private TelaPrincipalState estado;
    private UsuarioService usuarioService;
    
    public TelaPrincipalPresenter(){
        view = new TelaPrincipalView();
        initServices();
        initState();
        initListeners();
        view.setVisible(true);
    }
    
    private void initServices(){
        this.usuarioService = new UsuarioService();
    }
    
    private void initListeners(){
        // Menu item novo usuário
        view.getMiNovoUsuario().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
        
        // Menu item sair
        view.getMiSair().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }
    
    private void abrirTelaCadastro(){
        TelaCadastroPresenter cadastroPresenter = new TelaCadastroPresenter();
        view.getDesktopPane().add(cadastroPresenter.getView());
    }
    
    private void sair(){
        System.exit(0);
    }
    
    private void initState(){
        try {
            // Caso não haja usuários cadastrados, iniciará no estado de cadastro.
            if(usuarioService.contarUsuarios() == 0){
                this.estado = new CadastroState(this);
            }
            else{
                this.estado = new LoginState(this);
            }        
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao inicializar o programa.\n", 
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Métodos de state.
    public void cadastro(){
        this.estado.cadastro();
    }
        
    public void login(){
        this.estado.login();
    }
    
    public TelaPrincipalView getView(){
        return this.view;
    }
    
    public void setEstado(TelaPrincipalState estado){
        this.estado = estado;
    }
}
