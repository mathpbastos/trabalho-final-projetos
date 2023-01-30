package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.usuario.TelaCadastroPresenter;
import edu.ufes.trabalho.presenter.login.TelaLoginPresenter;
import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import javax.swing.JOptionPane;

public class PrimeiroCadastroState extends TelaPrincipalState{

    public PrimeiroCadastroState(TelaPrincipalPresenter principalPresenter){
        super(principalPresenter);
        initTelaCadastro();
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
    public void logar() {
        TelaLoginPresenter loginPresenter = new TelaLoginPresenter();
        this.principalPresenter.getView().getDesktopPane().add(loginPresenter.getView());
        
        this.principalPresenter.setEstado(new UsuarioDeslogadoState(principalPresenter));
    }
    
}
