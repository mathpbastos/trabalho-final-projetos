package edu.ufes.trabalho.presenter.login.observer;

public interface ITelaLoginSubject {
    
    public void add(ITelaLoginObserver observer);
    
    public void remover(ITelaLoginObserver observer);
    
    public void notificar();
    
}
