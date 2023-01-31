package edu.ufes.trabalho.presenter.login.observer;

import edu.ufes.trabalho.model.Usuario;

/*
    Assim que a tela de login tiver o usuário autenticado, este emitirá um
    update a todos seus subscribers para dizer qual usuário está logado
    no sistema.
*/

public interface ITelaLoginObserver {
    
    public void atualizar(Usuario usuario);
    
}
