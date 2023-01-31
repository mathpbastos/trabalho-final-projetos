package edu.ufes.trabalho.state.tela.principal.command;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import edu.ufes.trabalho.presenter.usuario.TelaAlterarSenhaPresenter;


public class AbrirAlterarSenhaCommand extends PrincipalPresenterCommand{

    public AbrirAlterarSenhaCommand(TelaPrincipalPresenter principalPresenter) {
        super(principalPresenter);
    }
    
    public void executar(){
        TelaAlterarSenhaPresenter alterarSenhaPresenter
                = new TelaAlterarSenhaPresenter();

        principalPresenter.getView()
                .getDesktopPane().add(alterarSenhaPresenter.getView());
    }
}
