package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.busca.TelaBuscarUsuariosPresenter;
import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;

public class ManterUsuarioState extends TelaPrincipalState{

    public ManterUsuarioState(TelaPrincipalPresenter principalPresenter) {
        super(principalPresenter);
        manter();
    }

    @Override
    public void manter() {
        TelaBuscarUsuariosPresenter buscarUsuarioPresenter = 
                new TelaBuscarUsuariosPresenter();
        
        this.principalPresenter.getView().getDesktopPane()
                .add(buscarUsuarioPresenter.getView());
    }
    
}
