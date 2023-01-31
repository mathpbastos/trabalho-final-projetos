/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ufes.trabalho.state.tela.manter.command;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;

/**
 *
 * @author b1n
 */
public class HabilitarEdicaoCommand extends TelaManterUsuarioCommand{

    public HabilitarEdicaoCommand(TelaManterUsuarioPresenter manterUsuarioPresenter,
            Usuario usuario) {
        super(manterUsuarioPresenter, usuario);
    }

    @Override
    public void executar() {
        this.estado.alteracao();
    }
    
}
