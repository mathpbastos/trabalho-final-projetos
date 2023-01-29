package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.cadastro.TelaCadastroPresenter;
import edu.ufes.trabalho.presenter.login.TelaLoginPresenter;
import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;

public class LoginState extends TelaPrincipalState{
    
    public LoginState(TelaPrincipalPresenter principalPresenter){
        super(principalPresenter);
        initTelaLogin();
        desativarMenus();
    }
    
    private void initTelaLogin(){
        TelaLoginPresenter loginPresenter = new TelaLoginPresenter();
        this.principalPresenter.getView().getDesktopPane()
                .add(loginPresenter.getView());
    }
    
    private void desativarMenus(){
        this.principalPresenter.getView().getMiNovoUsuario().setEnabled(false);
        this.principalPresenter.getView().getMiListarUsuarios().setEnabled(false);
        this.principalPresenter.getView().getMiNovaNotificacao().setEnabled(false);
        this.principalPresenter.getView().getMiListarNotificacoes().setEnabled(false);
        this.principalPresenter.getView().getMiAlterarDados().setEnabled(false);
        this.principalPresenter.getView().getMiAlterarSenha().setEnabled(false);
        this.principalPresenter.getView().getMiDeslogar().setEnabled(false);
    }
    
    public void cadastro(){
        TelaCadastroPresenter cadastroPresenter = new TelaCadastroPresenter();
        this.principalPresenter.getView().getDesktopPane()
                .add(cadastroPresenter.getView());
        
        this.principalPresenter
                .setEstado(new CadastroState(this.principalPresenter));
    }
    
}
