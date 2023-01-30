package edu.ufes.trabalho.state.tela.principal;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;

public class UsuarioLogadoState extends TelaPrincipalState{
    
    public UsuarioLogadoState(TelaPrincipalPresenter principalPresenter){
        super(principalPresenter);
        initComponents();
    }
    
    private void initComponents(){
        ativarMenuUsuario();
        if(validaPrivilegios()){
            ativarMenuAdministrador();
        }
    }
    
    private void ativarMenuUsuario(){
        this.principalPresenter.getView().getMiDeslogar()
                .setVisible(true);        
        this.principalPresenter.getView().getSubMenuGerenciamento()
                .setVisible(true);
        this.principalPresenter.getView().getMiAlterarSenha()
                .setVisible(true);
        this.principalPresenter.getView().getNotificacoesMenu()
                .setVisible(true);
        this.principalPresenter.getView().getMiVisualizarNotificacoes()
                .setVisible(true);
        this.principalPresenter.getView().getAjudaMenu()
                .setVisible(true);
        
        this.principalPresenter.getView().getMiLogin()
                .setVisible(false);
        this.principalPresenter.getView().getMiNovoUsuario()
                .setVisible(false);
        this.principalPresenter.getView().getMiNovaNotificacao()
                .setVisible(false);
    }
    
    private void ativarMenuAdministrador(){
        this.principalPresenter.getView().getMiAlterarDados()
                .setVisible(true);
        this.principalPresenter.getView().getMiListarUsuarios()
                .setVisible(true);
        this.principalPresenter.getView().getMiNovaNotificacao()
                .setVisible(true);
        this.principalPresenter.getView().getMiNovoUsuario()
                .setVisible(true);
    }
    
    private boolean validaPrivilegios(){
        return principalPresenter.getUsuarioAtual().isAdministrador();
    }
    
    public void deslogar(){
        principalPresenter.setEstado(new UsuarioDeslogadoState(principalPresenter));
    }
    
}
