package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.login.TelaLoginPresenter;
import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;

public class UsuarioDeslogadoState extends TelaPrincipalState{
    
    public UsuarioDeslogadoState(TelaPrincipalPresenter principalPresenter){
        super(principalPresenter);
        initTelaLogin();
        initLoginMenu();
    }
    
    private void initTelaLogin(){
        TelaLoginPresenter loginPresenter = new TelaLoginPresenter();
        this.principalPresenter.getView().getDesktopPane()
                .add(loginPresenter.getView());
        
        loginPresenter.add(principalPresenter);
    }
    
    private void initLoginMenu(){
        this.principalPresenter.getView().getSubMenuGerenciamento()
                .setVisible(false);
        this.principalPresenter.getView().getMiAlterarDados()
                .setVisible(false);
        this.principalPresenter.getView().getMiAlterarSenha()
                .setVisible(false);
        this.principalPresenter.getView().getMiListarUsuarios()
                .setVisible(false);
        this.principalPresenter.getView().getNotificacoesMenu()
                .setVisible(false);
        this.principalPresenter.getView().getAjudaMenu()
                .setVisible(false);
        this.principalPresenter.getView().getMiDeslogar()
                .setVisible(false);
        
        this.principalPresenter.getView().getMiLogin()
                .setVisible(true);
    }
    
    @Override
    public void logar(){
        this.principalPresenter
                .setEstado(new UsuarioLogadoState(this.principalPresenter));
    }
    
}
