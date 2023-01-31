package edu.ufes.trabalho.state.tela.manter.command;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;
import edu.ufes.trabalho.state.tela.manter.VisualizacaoState;

public class AbrirVisualizacaoUsuarioCommand extends TelaManterUsuarioCommand {

    public AbrirVisualizacaoUsuarioCommand(TelaManterUsuarioPresenter manterUsuarioPresenter, 
            Usuario usuario) {
        super(manterUsuarioPresenter, usuario);
    }

    @Override
    public void executar() {
         this.estado = new VisualizacaoState(manterUsuarioPresenter, usuario);
    }

}
