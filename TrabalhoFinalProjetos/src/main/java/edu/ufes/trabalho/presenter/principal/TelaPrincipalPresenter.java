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
    
    private void initState(){
        try {
            int quantidadeUsuarios = usuarioService.contarUsuarios();            
            // Caso haja usuários cadastrados, iniciará no estado de login
            if(quantidadeUsuarios != 0){
                this.setEstado(new LoginState(this));
            }
            else {
                this.setEstado(new CadastroState(this));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao inicializar o programa.\n", 
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void initListeners(){
        view.getMiNovoUsuario().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
    }
    
    private void abrirTelaCadastro(){
        TelaCadastroPresenter cadastroPresenter = new TelaCadastroPresenter();
        view.getDesktopPane().add(cadastroPresenter.getView());
    }
        
    public TelaPrincipalView getView(){
        return this.view;
    }
    
    public void setEstado(TelaPrincipalState estado){
        this.estado = estado;
    }
}
