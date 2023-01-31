package edu.ufes.trabalho.presenter.login;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.IUsuarioService;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.presenter.login.observer.ITelaLoginObserver;
import edu.ufes.trabalho.view.login.TelaLoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import edu.ufes.trabalho.presenter.login.observer.ITelaLoginSubject;

public class TelaLoginPresenter implements ITelaLoginSubject {

    private TelaLoginView view;
    private IUsuarioService usuarioService;
    private Usuario usuarioAtual;
    private List<ITelaLoginObserver> observers;

    public TelaLoginPresenter() {
        this.view = new TelaLoginView();
        this.observers = new ArrayList<ITelaLoginObserver>();
        initServices();
        initButtonListeners();
        
        view.getTfLogin().setText("gdie@yelp.com");
        view.getPfSenha().setText("oipwkv0GUt");
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
        
        // btnSair
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }

    private void fechar() {
        this.view.dispose();
    }
    
    private void sair(){
        System.exit(0);
    }

    private void logar() {
        // Obtendo campos da tela
        String login = view.getTfLogin().getText();
        String senha = new String(view.getPfSenha().getPassword());
        if (!login.isEmpty() || !senha.isEmpty()) {
            try {
                this.usuarioAtual = usuarioService.autenticar(login, senha);
                if (usuarioAtual != null) {
                    notificar();
                    JOptionPane.showMessageDialog(view,
                            "Bem vindo " + usuarioAtual.getNome(),
                            "Logado",
                            JOptionPane.INFORMATION_MESSAGE);
                    fechar();
                }
            } catch (RuntimeException | ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(view,
                        ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                view.getTfLogin().setText("");
                view.getPfSenha().setText("");
                view.getTfLogin().requestFocus();
            }
        }
        else{
            JOptionPane.showMessageDialog(view,
                    "Favor preencher login e senha.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public TelaLoginView getView() {
        return view;
    }

    @Override
    public void add(ITelaLoginObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void remover(ITelaLoginObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notificar() {
        for (ITelaLoginObserver observer : observers) {
            observer.atualizar(usuarioAtual);
        }
    }

}
