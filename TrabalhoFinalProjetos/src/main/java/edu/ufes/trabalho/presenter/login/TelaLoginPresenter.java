package edu.ufes.trabalho.presenter.login;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.IUsuarioService;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.view.login.TelaLoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaLoginPresenter {

    private TelaLoginView view;
    private IUsuarioService usuarioService;

    public TelaLoginPresenter() {
        this.view = new TelaLoginView();
        initServices();
        initButtonListeners();
        view.setVisible(true);
    }

    private void initServices() {
        this.usuarioService = new UsuarioService();
    }

    private void initButtonListeners() {
        // btnEntrar
        view.getBtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }
        });
    }

    private void fechar(){
        this.view.dispose();
    }
    
    private void logar() {
        // Obtendo campos da tela
        String login = view.getTfLogin().getText();
        String senha = new String(view.getPfSenha().getPassword());
        
        try {
            Usuario usuario = usuarioService.autenticar(login, senha);
            if(usuario != null){
                JOptionPane.showMessageDialog(view, 
                        "Bem vindo " + usuario.getNome(),
                        "Logado", JOptionPane.INFORMATION_MESSAGE);
                fechar();
            }                
        } catch (RuntimeException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    "Ocorreu um erro durante o login.\n" + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public TelaLoginView getView() {
        return view;
    }

}
