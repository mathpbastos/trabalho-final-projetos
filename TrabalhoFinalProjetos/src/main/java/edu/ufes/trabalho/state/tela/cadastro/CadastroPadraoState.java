package edu.ufes.trabalho.state.tela.cadastro;

import edu.ufes.trabalho.presenter.cadastro.TelaCadastroPresenter;

public class CadastroPadraoState extends TelaCadastroState{

    public CadastroPadraoState(TelaCadastroPresenter cadastroPresenter) {
        super(cadastroPresenter);
        
        this.descricao = "CADASTRO PADRAO";
    }
    
}
