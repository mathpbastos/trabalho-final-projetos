package edu.ufes.trabalho.state.tela.principal.command;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;

public class AbrirTelaCadastroCommand extends PrincipalPresenterCommand{

    public AbrirTelaCadastroCommand(TelaPrincipalPresenter principalPresenter) {
        super(principalPresenter);
    }

    @Override
    public void executar() {
        TelaManterUsuarioPresenter cadastroPresenter = new TelaManterUsuarioPresenter();
        principalPresenter.getView().getDesktopPane()
                .add(cadastroPresenter.getView());
    }
}
