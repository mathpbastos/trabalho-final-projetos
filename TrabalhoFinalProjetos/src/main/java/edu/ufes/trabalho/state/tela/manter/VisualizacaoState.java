package edu.ufes.trabalho.state.tela.manter;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;
import java.time.format.DateTimeFormatter;

public class VisualizacaoState extends TelaManterUsuarioState {

    public VisualizacaoState(TelaManterUsuarioPresenter manterUsuarioPresenter,
            Usuario usuario) {
        super(manterUsuarioPresenter, usuario);
        initComponents();
        preencherCampos();
        if(usuario == null)
            System.out.println("usuario nulo");
    }

    public void initComponents() {
        this.manterUsuarioPresenter.getView().getTfNome()
                .setEnabled(false);
        this.manterUsuarioPresenter.getView().getTfLogin()
                .setEnabled(false);
        this.manterUsuarioPresenter.getView().getBtnCadastrar()
                .setEnabled(false);
        this.manterUsuarioPresenter.getView().getPfSenha()
                .setVisible(false);
        this.manterUsuarioPresenter.getView().getPfConfirmacaoSenha()
                .setVisible(false);
        this.manterUsuarioPresenter.getView().getLblSenha()
                .setVisible(false);
        this.manterUsuarioPresenter.getView().getLblConfimacaoSenha()
                .setVisible(false);
        this.manterUsuarioPresenter.getView().getCbAdministrador()
                .setEnabled(false);
        this.manterUsuarioPresenter.getView().getCbAutorizado()
                .setEnabled(false);

        this.manterUsuarioPresenter.getView().getLblId()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getLblIdInfo()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getBtnSair()
                .setEnabled(true);
        this.manterUsuarioPresenter.getView().getBtnEditar()
                .setEnabled(true);
        this.manterUsuarioPresenter.getView().getBtnExcluir()
                .setEnabled(true);
    }

    private void preencherCampos() {
        this.manterUsuarioPresenter.getView()
                .getTfNome().setText(usuario.getNome());
        this.manterUsuarioPresenter.getView()
                .getTfLogin().setText(usuario.getLogin());
        this.manterUsuarioPresenter.getView()
                .getLblDataCadastro().setText(usuario.getDataCadastro()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.manterUsuarioPresenter.getView()
                .getLblDataModificacaoInfo().setText(usuario.getDataModificacao()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.manterUsuarioPresenter.getView()
                .getLblIdInfo().setText(Long.toString(usuario.getId()));
        this.manterUsuarioPresenter.getView()
                .getCbAdministrador().setSelected(usuario.isAdministrador());
        this.manterUsuarioPresenter.getView()
                .getCbAutorizado().setSelected(usuario.isAutorizado());
    }

    @Override
    public void alteracao() {
        this.manterUsuarioPresenter
                .setEstado(new EdicaoState(
                        this.manterUsuarioPresenter, this.usuario));
    }
    
    @Override
    public void exclusao() {
        this.manterUsuarioPresenter
                .setEstado(new ExclusaoState(manterUsuarioPresenter, usuario));
    }

}
