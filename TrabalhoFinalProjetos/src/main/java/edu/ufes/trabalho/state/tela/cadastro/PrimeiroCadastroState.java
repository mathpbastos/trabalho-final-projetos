package edu.ufes.trabalho.state.tela.cadastro;

import edu.ufes.trabalho.presenter.usuario.TelaCadastroPresenter;

/* 
    Este estado serve para que o programa saiba quando está sendo utilizado 
    pela primeira vez, alterando algumas condições no cadastro.
    No primeiro cadastro, o usuário será administrador e autorizado.
*/

public class PrimeiroCadastroState extends TelaCadastroState{
    
    public PrimeiroCadastroState(TelaCadastroPresenter cadastroPresenter){
        super(cadastroPresenter);
        
        this.descricao = "PRIMEIRO CADASTRO";
    }
    
    public void cadastroPadrao(){
        this.cadastroPresenter
                .setEstado(new CadastroPadraoState(this.cadastroPresenter));
    }
    
}
