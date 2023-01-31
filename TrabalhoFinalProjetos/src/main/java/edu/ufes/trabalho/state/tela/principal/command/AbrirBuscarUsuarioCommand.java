package edu.ufes.trabalho.state.tela.principal.command;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import edu.ufes.trabalho.state.tela.principal.ManterUsuarioState;

public class AbrirBuscarUsuarioCommand extends PrincipalPresenterCommand{

    public AbrirBuscarUsuarioCommand(TelaPrincipalPresenter principalPresenter) {
        super(principalPresenter);
    }

    @Override
    public void executar() {
        this.estado = new ManterUsuarioState(principalPresenter);
    }
    
}