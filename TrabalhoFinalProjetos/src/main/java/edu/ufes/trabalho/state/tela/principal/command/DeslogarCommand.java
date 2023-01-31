package edu.ufes.trabalho.state.tela.principal.command;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import edu.ufes.trabalho.state.tela.principal.UsuarioDeslogadoState;

public class DeslogarCommand extends PrincipalPresenterCommand {

    public DeslogarCommand(TelaPrincipalPresenter principalPresenter) {
        super(principalPresenter);
    }

    @Override
    public void executar() {
        this.principalPresenter.setUsuarioAtual(null);
        this.estado = new UsuarioDeslogadoState(principalPresenter);
    }

}
