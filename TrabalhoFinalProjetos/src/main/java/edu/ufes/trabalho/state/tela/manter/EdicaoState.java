package edu.ufes.trabalho.state.tela.manter;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;

public class EdicaoState extends TelaManterUsuarioState {

    public EdicaoState(TelaManterUsuarioPresenter manterUsuarioPresenter, Usuario usuario) {
        super(manterUsuarioPresenter, usuario);
        initComponents();
        modificarListeners();
    }

    private void initComponents() {
        this.manterUsuarioPresenter.getView().getTfNome()
                .setEnabled(true);
        this.manterUsuarioPresenter.getView().getTfLogin()
                .setEnabled(true);
        this.manterUsuarioPresenter.getView().getPfSenha()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getPfConfirmacaoSenha()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getLblSenha()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getLblConfimacaoSenha()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getLblDataModificacao()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getLblDataModificacaoInfo()
                .setVisible(true);
        this.manterUsuarioPresenter.getView().getBtnCadastrar()
                .setEnabled(true);

        this.manterUsuarioPresenter.getView().getBtnCadastrar()
                .setText("Salvar");
        this.manterUsuarioPresenter.getView().getBtnSair()
                .setText("Cancelar");

        this.manterUsuarioPresenter.getView().getBtnEditar()
                .setEnabled(false);
        this.manterUsuarioPresenter.getView().getBtnExcluir()
                .setEnabled(false);
    }

    private void modificarListeners() {
        // Removendo o action listener atual para cadastro.
        JButton btnCadastrar = this.manterUsuarioPresenter
                .getView().getBtnCadastrar();
        List<ActionListener> listenersBtnCadastrar = Arrays.asList(
                btnCadastrar.getActionListeners());

        for (ActionListener listener : listenersBtnCadastrar) {
            btnCadastrar.removeActionListener(listener);
        }

        JButton btnSair = this.manterUsuarioPresenter
                .getView().getBtnSair();

        List<ActionListener> listenersBtnSair = Arrays.asList(
                btnSair.getActionListeners());
        for (ActionListener listener : listenersBtnSair) {
            btnSair.removeActionListener(listener);
        }

        // Adicionando o novo listener.
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manterUsuarioPresenter.alterar();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               visualizacao();
            }
        });
    }

    @Override
    public void exclusao() {
        this.manterUsuarioPresenter
                .setEstado(new ExclusaoState(manterUsuarioPresenter, usuario));
    }
    
    @Override
    public void visualizacao() {
        manterUsuarioPresenter
                       .setEstado(new VisualizacaoState(manterUsuarioPresenter, usuario));
    }

}
