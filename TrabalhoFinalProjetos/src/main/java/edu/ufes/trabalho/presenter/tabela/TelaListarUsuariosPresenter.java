package edu.ufes.trabalho.presenter.tabela;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.IUsuarioService;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.view.tabela.TelaListarUsuariosView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TelaListarUsuariosPresenter {

    private TelaListarUsuariosView view;
    private DefaultTableModel tmUsuarios;
    private IUsuarioService usuarioService;
    private List<Usuario> usuarios;

    public TelaListarUsuariosPresenter() {
        this.view = new TelaListarUsuariosView();
        initServices();
        initTabela();
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

    public TelaListarUsuariosView getView() {
        return view;
    }

}
