package edu.ufes.trabalho.presenter.principal;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.presenter.usuario.TelaCadastroPresenter;
import edu.ufes.trabalho.presenter.login.observer.ITelaLoginObserver;
import edu.ufes.trabalho.presenter.tabela.TelaListarUsuariosPresenter;
import edu.ufes.trabalho.presenter.usuario.TelaAlterarSenhaPresenter;
import edu.ufes.trabalho.state.tela.principal.PrimeiroCadastroState;
import edu.ufes.trabalho.state.tela.principal.UsuarioDeslogadoState;
import edu.ufes.trabalho.state.tela.principal.TelaPrincipalState;
import edu.ufes.trabalho.view.principal.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaPrincipalPresenter implements ITelaLoginObserver{
    private TelaPrincipalView view;
    private TelaPrincipalState estado;
    private UsuarioService usuarioService;
    private Usuario usuarioAtual;
    
    public TelaPrincipalPresenter(){
        view = new TelaPrincipalView();
        initServices();
        initState();
        initListeners();
        view.setVisible(true);
    }
    
    private void initServices(){
        this.usuarioService = new UsuarioService();
    }
    
    private void initListeners(){
        // Menu item novo usuário
        view.getMiNovoUsuario().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
        
        // Menu item sair
        view.getMiSair().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
        
        // Menu item listar usuarios
        view.getMiListarUsuarios().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirListaUsuarios();
            }
        });
        
        // Menu item deslogar
        view.getMiDeslogar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarSessao();
            }
        });
        
        // Menu item alterar senha
        view.getMiAlterarSenha().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAlterarSenha();
            }
        });
    }
    
    private void abrirTelaCadastro(){
        TelaCadastroPresenter cadastroPresenter = new TelaCadastroPresenter();
        view.getDesktopPane().add(cadastroPresenter.getView());
    }
    
    private void sair(){
        System.exit(0);
    }
    
    private void abrirListaUsuarios(){
        TelaListarUsuariosPresenter listarUsuariosPresenter 
                = new TelaListarUsuariosPresenter();
        view.getDesktopPane().add(listarUsuariosPresenter.getView());
    }
    
    private void encerrarSessao(){
        this.usuarioAtual = null;
        this.estado.deslogar();
    }
    
    public void abrirAlterarSenha(){
        TelaAlterarSenhaPresenter alterarSenhaPresenter =
                new TelaAlterarSenhaPresenter();
        
        view.getDesktopPane().add(alterarSenhaPresenter.getView());
    }
    
    private void initState(){
        try {
            // Caso não haja usuários cadastrados, iniciará no estado de cadastro.
            if(usuarioService.contarUsuarios() == 0){
                this.estado = new PrimeiroCadastroState(this);
            }
            else{
                this.estado = new UsuarioDeslogadoState(this);
            }        
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao inicializar o programa.\n", 
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public TelaPrincipalView getView(){
        return this.view;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }
    
    public void setEstado(TelaPrincipalState estado){
        this.estado = estado;
    }
    
    // Métodos de state.
    public void cadastro(){
        this.estado.cadastro();
    }
        
    public void logar(){
        this.estado.logar();
    }
    
    public void deslogar(){
        this.estado.deslogar();
    }
    
    @Override
    public void atualizar(Usuario usuario) {
        this.usuarioAtual = usuario;
        if(usuarioAtual != null)
            this.estado.logar();
    }
    
}
