package edu.ufes.trabalho.presenter.usuario.manter.observer;

import edu.ufes.trabalho.presenter.usuario.manter.observer.ITelaManterUsuarioObserver;

public interface ITelaManterUsuarioSubject {

    public void add(ITelaManterUsuarioObserver observer);

    public void remove(ITelaManterUsuarioObserver observer);

    public void notificar();
    
}
