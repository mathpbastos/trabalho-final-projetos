package edu.ufes.trabalho.state.tela.principal.command;

import edu.ufes.trabalho.presenter.login.TelaLoginPresenter;
import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;

public class AbrirTelaLoginCommand extends PrincipalPresenterCommand{

    public AbrirTelaLoginCommand(TelaPrincipalPresenter principalPresenter) {
        super(principalPresenter);
    }

    @Override
    public void executar() {
        TelaLoginPresenter loginPresenter = new TelaLoginPresenter();
        principalPresenter.getView().getDesktopPane().add(loginPresenter.getView());
    }

}
