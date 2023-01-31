package edu.ufes.trabalho.state.tela.principal.command;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import edu.ufes.trabalho.state.tela.principal.TelaPrincipalState;

public abstract class PrincipalPresenterCommand {
    
    protected TelaPrincipalPresenter principalPresenter;
    protected TelaPrincipalState estado;
        
    public PrincipalPresenterCommand(TelaPrincipalPresenter principalPresenter) {
        this.principalPresenter = principalPresenter;
    }
    
    public abstract void executar();
    
}
