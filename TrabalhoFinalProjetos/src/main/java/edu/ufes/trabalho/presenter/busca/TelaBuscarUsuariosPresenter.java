package edu.ufes.trabalho.presenter.busca;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.IUsuarioService;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.presenter.usuario.manter.TelaManterUsuarioPresenter;
import edu.ufes.trabalho.presenter.usuario.manter.observer.ITelaManterUsuarioObserver;
import edu.ufes.trabalho.state.tela.manter.command.AbrirVisualizacaoUsuarioCommand;
import edu.ufes.trabalho.view.tabela.TelaBuscarUsuariosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TelaBuscarUsuariosPresenter implements ITelaManterUsuarioObserver {

    private TelaBuscarUsuariosView view;
    private DefaultTableModel tmUsuarios;
    private IUsuarioService usuarioService;
    private List<Usuario> usuarios;

    public TelaBuscarUsuariosPresenter() {
        this.view = new TelaBuscarUsuariosView();
        initServices();
        initTabela();
        initListeners();
        buscarTodos();
        populaTabela();
        view.setVisible(true);
    }

    private void initServices() {
        this.usuarioService = new UsuarioService();
    }

    private void buscarTodos() {
        try {
            this.usuarios = this.usuarioService.buscarTodos();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initTabela() {
        JTable tabela = view.getTblUsuarios();
        tmUsuarios = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome Completo",
                    "Dt. Cadastro",
                    "Notificações",
                    "Autorizado",
                    "Administrador"
                }) {
            Class[] types = new Class[]{
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Boolean.class,
                java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                false,
                false,
                false,
                false,
                false
            };
        };
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tmUsuarios.setNumRows(0);

        tabela.setModel(tmUsuarios);
    }

    private void limpaTabela() {
        int rowCount = tmUsuarios.getRowCount();
        if (rowCount > 0) {
            for (int i = rowCount - 1; i >= 0; i--) {
                tmUsuarios.removeRow(i);
            }
        }
    }

    private void populaTabela() {
        limpaTabela();

        for (Usuario usuario : usuarios) {
            tmUsuarios.addRow(new Object[]{
                usuario.getNome(),
                usuario.getDataCadastro(),
                "Add notificacoes aqui",
                usuario.isAutorizado(),
                usuario.isAdministrador()
            });
        }
    }

    private void initListeners() {
        this.view.getBtnDetalhes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizar();
            }
        });

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
    }

    private void visualizar() {
        JTable tabela = view.getTblUsuarios();
        int linha = tabela.getSelectedRow();
        try {
            String nome
                    = tabela.getModel()
                            .getValueAt(linha, 0)
                            .toString();
            LocalDate dtCadastro
                    = LocalDate.parse(tabela.getModel()
                            .getValueAt(linha, 1)
                            .toString());
            Usuario usuario = usuarioService.buscarPorIdECadastro(nome, dtCadastro);

            if (usuario != null) {
                TelaManterUsuarioPresenter manterUsuarioPresenter = new TelaManterUsuarioPresenter(usuario);
                AbrirVisualizacaoUsuarioCommand command
                        = new AbrirVisualizacaoUsuarioCommand(manterUsuarioPresenter, usuario);
                command.executar();

                manterUsuarioPresenter.add(this);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fechar() {
        this.view.dispose();
    }

    public TelaBuscarUsuariosView getView() {
        return view;
    }

    @Override
    public void atualizar() {
        buscarTodos();
        populaTabela();
    }

}
