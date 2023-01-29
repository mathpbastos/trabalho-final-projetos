package edu.ufes.trabalho.state.tela.cadastro;

import edu.ufes.trabalho.presenter.cadastro.TelaCadastroPresenter;

public abstract class TelaCadastroState {
    
    protected TelaCadastroPresenter cadastroPresenter;
    protected String descricao;
    
    public TelaCadastroState(TelaCadastroPresenter cadastroPresenter){
        this.cadastroPresenter = cadastroPresenter;
    }
    
    public void cadastroPadrao(){
        throw new UnsupportedOperationException("Não é possível alterar "
                + "o estado a partir do estado atual.");
    }
 
    public final String getDescricao(){
        return this.descricao;
    }
    
}
