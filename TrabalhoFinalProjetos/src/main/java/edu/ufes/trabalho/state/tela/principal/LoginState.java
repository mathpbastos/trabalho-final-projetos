package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.login.TelaLoginPresenter;
import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;

public class LoginState extends TelaPrincipalState{
    
    public LoginState(TelaPrincipalPresenter principalPresenter){
        super(principalPresenter);
        initTelaLogin();
        this.principalPresenter.setEstado(this);
    }
    
    private void initTelaLogin(){
        TelaLoginPresenter loginPresenter = new TelaLoginPresenter();
        this.principalPresenter.getView().getDesktopPane().add(loginPresenter.getView());
    }

    /*@Override
    public void cadastro() {
        TelaCadastroPresenter cadastroPresenter = new TelaCadastroPresenter();
        this.principalPresenter.getView().getDesktopPane().add(loginPresenter.getView());
    }*/
    
}
