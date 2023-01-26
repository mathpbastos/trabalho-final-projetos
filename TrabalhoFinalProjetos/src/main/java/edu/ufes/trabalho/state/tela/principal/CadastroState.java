package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.cadastro.TelaCadastroPresenter;
import edu.ufes.trabalho.presenter.login.TelaLoginPresenter;
import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import javax.swing.JOptionPane;

public class CadastroState extends TelaPrincipalState{

    public CadastroState(TelaPrincipalPresenter principalPresenter){
        super(principalPresenter);
        initTelaCadastro();
        this.principalPresenter.setEstado(this);
    }
    
    private void initTelaCadastro(){
        TelaCadastroPresenter cadastroPresenter = new TelaCadastroPresenter();
        
        String mensagem = "Bem-vindo(a).\n"
                + "Como é a primeira vez que o sistema é iniciado,\n"
                + "realizaremos o cadastro do primeiro usuário.";
        
        JOptionPane.showMessageDialog(principalPresenter.getView(),
                mensagem, 
                "Primeiro Uso", 
                JOptionPane.INFORMATION_MESSAGE);
        this.principalPresenter.getView().getDesktopPane().add(cadastroPresenter.getView());
    }
    
    @Override
    public void login() {
        TelaLoginPresenter loginPresenter = new TelaLoginPresenter();
        this.principalPresenter.getView().getDesktopPane().add(loginPresenter.getView());
    }
    
}
