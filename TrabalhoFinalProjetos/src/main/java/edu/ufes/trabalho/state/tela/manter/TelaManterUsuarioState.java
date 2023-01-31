package edu.ufes.trabalho.state.tela.manter;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;

public abstract class TelaManterUsuarioState {
    
    protected Usuario usuario;
    protected TelaManterUsuarioPresenter manterUsuarioPresenter;
    
    public TelaManterUsuarioState(TelaManterUsuarioPresenter manterUsuarioPresenter,
            Usuario usuario){
        this.usuario = usuario;
        this.manterUsuarioPresenter = manterUsuarioPresenter;
    }
    
    public void visualizacao(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
    
    public void alteracao(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
    
    public void exclusao(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
    
}
