package edu.ufes.trabalho.presenter.usuario.manter;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.IUsuarioService;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.presenter.usuario.manter.observer.ITelaManterUsuarioObserver;
import edu.ufes.trabalho.presenter.usuario.manter.observer.ITelaManterUsuarioSubject;
import edu.ufes.trabalho.state.tela.manter.TelaManterUsuarioState;
import edu.ufes.trabalho.state.tela.manter.command.AbrirVisualizacaoUsuarioCommand;
import edu.ufes.trabalho.state.tela.manter.command.HabilitarEdicaoCommand;
import edu.ufes.trabalho.state.tela.manter.command.TelaManterUsuarioCommand;
import edu.ufes.trabalho.view.cadastro.TelaManterUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaManterUsuarioPresenter implements ITelaManterUsuarioSubject {

    private TelaManterUsuarioView view;
    private IUsuarioService usuarioService;
    private TelaManterUsuarioState estado;
    private TelaManterUsuarioCommand command;
    private List<ITelaManterUsuarioObserver> observers;
    private Usuario usuario;

    public TelaManterUsuarioPresenter() {
        this.view = new TelaManterUsuarioView();
        initServices();
        initListeners();
        setLblDtCadastro(LocalDate.now());
        initObservers();
        view.setVisible(true);
        view.requestFocus();
    }

    public TelaManterUsuarioPresenter(Usuario usuario) {
        this.view = new TelaManterUsuarioView();
        initServices();
        initListeners();
        setLblDtCadastro(usuario.getDataCadastro());
        this.usuario = usuario;
        initState(this.usuario);
        initObservers();
        view.setVisible(true);
        view.requestFocus();
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

        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitarEdicao();
            }
        });

        view.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remover();
            }
        });
    }

    private void initState(Usuario usuario) {
        this.command = new AbrirVisualizacaoUsuarioCommand(this, usuario);
    }

    private void initObservers() {
        this.observers = new ArrayList<>();
    }

    private void setLblDtCadastro(LocalDate dtCadastro) {
        String data = dtCadastro.format(DateTimeFormatter
                .ofPattern("dd/MM/yyyy"));
        view.getLblDataCadastro().setText(data);
    }

    private Usuario obterCampos(Usuario usuario) {
        String nome = view.getTfNome().getText();
        String login = view.getTfLogin().getText();
        String senha = new String(view.getPfSenha().getPassword());
        String confirmacao = new String(view.getPfConfirmacaoSenha().getPassword());
        if (!senha.isBlank() && !senha.equals(confirmacao)) {
            JOptionPane.showMessageDialog(view,
                    "A confirmação de senha deve ser exatamente\n "
                    + "igual a senha digitada.",
                    "Confirme as senhas",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } 

        boolean autorizacaoLogin = false;
        boolean administrador = false;

        if (usuario == null) {
            return new Usuario(nome, login, senha, administrador, autorizacaoLogin);
        }
        
        if(!senha.isEmpty())
            usuario.setSenha(senha);
        usuario.setNome(nome);
        usuario.setLogin(login);        
        usuario.setAdministrador(administrador);
        usuario.setAutorizado(autorizacaoLogin);
        return usuario;
    }

    private void cadastrar() {
        this.usuario = obterCampos(null);
        try {
            // Primeiro cadastro
            if (usuarioService.contarUsuarios() == 0) {
                usuario.setAdministrador(true);
                usuario.setAutorizado(true);
            }

            if (usuarioService.criar(usuario)) {
                JOptionPane.showMessageDialog(view,
                        "Usuário(a)\n"
                        + usuario.getNome() + "\ncadastrado(a) com sucesso",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                fechar();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    ex.getMessage(),
                    "Erro cadastro novo usuário",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void alterar() {
        this.usuario = obterCampos(this.usuario);
        try {
            if (usuarioService.alterar(usuario)) {
                notificar();
                JOptionPane.showMessageDialog(view,
                        "Usuário(a)\n"
                        + usuario.getNome() + "\nalterado(a) com sucesso",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                fechar();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir() {
        try {
            if (usuarioService.excluir(this.usuario.getId())) {
                notificar();
                JOptionPane.showMessageDialog(view,
                        "Usuário\n"
                        + usuario.getId() + "\n"
                        + usuario.getNome() + "\n"
                        + "removido com sucesso",
                        "Sucesso",
                        JOptionPane.ERROR_MESSAGE);
                fechar();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fechar() {
        this.view.dispose();
    }

    private void habilitarEdicao() {
        this.command = new HabilitarEdicaoCommand(this, this.usuario);
        this.command.executar();
    }

    private void remover() {
        this.estado.exclusao();
    }

    public TelaManterUsuarioView getView() {
        return this.view;
    }

    public void setEstado(TelaManterUsuarioState estado) {
        this.estado = estado;
    }

    @Override
    public void add(ITelaManterUsuarioObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(ITelaManterUsuarioObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notificar() {
        for (ITelaManterUsuarioObserver observer : observers) {
            observer.atualizar();
        }
    }

}
