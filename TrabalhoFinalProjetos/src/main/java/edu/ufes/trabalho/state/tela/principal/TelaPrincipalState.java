package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;

public abstract class TelaPrincipalState {
    
    protected TelaPrincipalPresenter principalPresenter;
    
    public TelaPrincipalState(TelaPrincipalPresenter principalPresenter){
        this.principalPresenter = principalPresenter;
    }
    
    public void cadastro(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
    
    public void logar(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
    
    public void deslogar(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
    
    public void manter(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
    
}
