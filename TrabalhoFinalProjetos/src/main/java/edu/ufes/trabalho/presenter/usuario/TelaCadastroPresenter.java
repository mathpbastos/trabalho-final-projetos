package edu.ufes.trabalho.presenter.cadastro;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.IUsuarioService;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.state.tela.cadastro.CadastroPadraoState;
import edu.ufes.trabalho.state.tela.cadastro.PrimeiroCadastroState;
import edu.ufes.trabalho.state.tela.cadastro.TelaCadastroState;
import edu.ufes.trabalho.view.cadastro.TelaCadastroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class TelaCadastroPresenter {

    private TelaCadastroView view;
    private IUsuarioService usuarioService;
    private TelaCadastroState estado;

    public TelaCadastroPresenter() {
        this.view = new TelaCadastroView();
        initServices();
        initListeners();
        setLblDtCadastro();
        initState();
        view.setVisible(true);
    }

    private void initServices() {
        this.usuarioService = new UsuarioService();
    }

    private void initListeners() {
        view.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });
    }

    private void initState() {
        // Estado inicial
        this.estado = new CadastroPadraoState(this);
        try {
            if (usuarioService.contarUsuarios() == 0) {
                this.estado = new PrimeiroCadastroState(this);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setLblDtCadastro() {
        String dataAtual = LocalDate.now().format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        view.getLblDataCadastro().setText(dataAtual);
    }

    private Usuario obterCampos() {
        String nome = view.getTfNome().getText();
        String login = view.getTfLogin().getText();
        String senha = new String(view.getPfSenha().getPassword());
        String confirmacao = new String(view.getPfConfirmacaoSenha().getPassword());
        if (!senha.equals(confirmacao)) {
            JOptionPane.showMessageDialog(view,
                    "A confirmação de senha deve ser exatamente\n "
                    + "igual a senha digitada.",
                    "Confirme as senhas",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        boolean autorizacaoLogin = false;
        boolean administrador = false;

        if (this.estado.getDescricao().equalsIgnoreCase("primeiro cadastro")) {
            autorizacaoLogin = true;
            administrador = true;
        }

        return new Usuario(nome, login, senha, administrador, autorizacaoLogin);
    }

    private void cadastrar() {
        Usuario usuario = obterCampos();
        usuario.toString();
        try {
            if (usuarioService.criar(usuario)) {
                JOptionPane.showMessageDialog(view,
                        "Usuário(a)\n"
                        + usuario.getNome() + "\ncadastrado(a) com sucesso",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    ex.getMessage(),
                    "Erro cadastro novo usuário",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setEstado(TelaCadastroState estado) {
        this.estado = estado;
    }
    
    public TelaCadastroView getView() {
        return this.view;
    }

}
