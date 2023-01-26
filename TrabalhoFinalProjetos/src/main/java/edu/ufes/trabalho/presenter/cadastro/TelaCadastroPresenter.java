package edu.ufes.trabalho.presenter.cadastro;

import edu.ufes.trabalho.view.cadastro.TelaCadastroView;

public class TelaCadastroPresenter {
    
    private TelaCadastroView view;
    
    public TelaCadastroPresenter(){
        this.view = new TelaCadastroView();
        
        view.setVisible(true);
    }
    
    public TelaCadastroView getView(){
        return this.view;
    }
   
}
