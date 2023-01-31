package edu.ufes.trabalho;

import edu.ufes.trabalho.presenter.principal.TelaPrincipalPresenter;
import java.sql.SQLException;

public class AppRun {

    public static void main(String[] args) {
        new TelaPrincipalPresenter();
        
        /*IUsuarioService usuarioService = new UsuarioService();
        
        Usuario u = usuarioService.buscarPorId(15L);
        
        System.out.println(u.getNome());
        
        u.setNome("Jonas Martins");
        
        usuarioService.alterar(u);*/
        
    }
}
