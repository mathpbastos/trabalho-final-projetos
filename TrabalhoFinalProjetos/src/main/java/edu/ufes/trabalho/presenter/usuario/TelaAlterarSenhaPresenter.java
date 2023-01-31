package edu.ufes.trabalho.presenter.usuario;

import edu.ufes.trabalho.persistencia.repository.usuario.service.IUsuarioService;
import edu.ufes.trabalho.persistencia.repository.usuario.service.UsuarioService;
import edu.ufes.trabalho.view.usuario.TelaAlterarSenhaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlterarSenhaPresenter {
    
    private TelaAlterarSenhaView view;
    private IUsuarioService usuarioService;
    
    public TelaAlterarSenhaPresenter(){
        view = new TelaAlterarSenhaView();
        initListeners();
        initServices();
        this.view.setVisible(true);
    }

    private void initListeners(){
        view.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmar();
            }
        });
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
    }
    
    private void initServices(){
        this.usuarioService = new UsuarioService();
    }
    
    private void confirmar(){
        String senhaAntiga = new String(view.getPfSenhaAntiga()
                .getPassword());
        String senhaNova = new String(view.getPfNovaSenha()
                .getPassword());
        String confirmacaoSenha = new String(view.getPfConfirmacao()
                .getPassword());
        
    }
    
    private void fechar(){
        this.view.dispose();
    }
    
    public TelaAlterarSenhaView getView() {
        return view;
    }
    
}
