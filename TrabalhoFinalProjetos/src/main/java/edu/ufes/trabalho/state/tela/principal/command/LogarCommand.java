package edu.ufes.trabalho.state.tela.principal.command;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import edu.ufes.trabalho.state.tela.principal.UsuarioLogadoState;

public class LogarCommand extends PrincipalPresenterCommand{

    public LogarCommand(TelaPrincipalPresenter principalPresenter) {
        super(principalPresenter);
    }

    @Override
    public void executar() {
        this.estado = new UsuarioLogadoState(principalPresenter);
    }
    
}
