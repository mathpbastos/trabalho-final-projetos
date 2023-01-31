package edu.ufes.trabalho.state.tela.manter.command;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;
import edu.ufes.trabalho.state.tela.manter.TelaManterUsuarioState;

public abstract class TelaManterUsuarioCommand {

    protected TelaManterUsuarioPresenter manterUsuarioPresenter;
    protected TelaManterUsuarioState estado;
    protected Usuario usuario;

    public TelaManterUsuarioCommand(TelaManterUsuarioPresenter manterUsuarioPresenter,
            Usuario usuario) {
        this.manterUsuarioPresenter = manterUsuarioPresenter;
        this.usuario = usuario;
    }

    public abstract void executar();
}
