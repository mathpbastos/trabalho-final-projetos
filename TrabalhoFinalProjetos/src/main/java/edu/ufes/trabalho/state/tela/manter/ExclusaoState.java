package edu.ufes.trabalho.state.tela.manter;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;


public class ExclusaoState extends TelaManterUsuarioState {

    public ExclusaoState(TelaManterUsuarioPresenter manterUsuarioPresenter, 
            Usuario usuario) {
        super(manterUsuarioPresenter, usuario);
        excluir(usuario);
    }

    private void excluir(Usuario usuario){
        manterUsuarioPresenter.excluir();
    }

}
