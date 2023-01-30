/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package edu.ufes.trabalho.view.principal;

import edu.ufes.trabalho.view.login.TelaLoginView;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author b1n
 */
public class TelaPrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public TelaPrincipalView() {
        initComponents();
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JMenuItem getMiAlterarDados() {
        return miAlterarDados;
    }

    public JMenuItem getMiAlterarSenha() {
        return miAlterarSenha;
    }

    public JMenuItem getMiDeslogar() {
        return miDeslogar;
    }

    public JMenuItem getMiVisualizarNotificacoes() {
        return miVisualizarNotificacoes;
    }

    public JMenuItem getMiListarUsuarios() {
        return miListarUsuarios;
    }

    public JMenuItem getMiNovaNotificacao() {
        return miNovaNotificacao;
    }

    public JMenuItem getMiNovoUsuario() {
        return miNovoUsuario;
    }

    public JMenuItem getMiSair() {
        return miSair;
    }

    public JMenuItem getMiSobre() {
        return miSobre;
    }

    public JMenu getAjudaMenu() {
        return ajudaMenu;
    }

    public JMenu getSessaoMenu() {
        return sessaoMenu;
    }

    public JMenu getUsuariosMenu() {
        return usuariosMenu;
    }

    public JMenu getNotificacoesMenu() {
        return notificacoesMenu;
    }

    public JMenu getSubMenuGerenciamento() {
        return subMenuGerenciamento;
    }

    public JMenuItem getMiLogin() {
        return miLogin;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        sessaoMenu = new javax.swing.JMenu();
        miLogin = new javax.swing.JMenuItem();
        miDeslogar = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        usuariosMenu = new javax.swing.JMenu();
        miNovoUsuario = new javax.swing.JMenuItem();
        miListarUsuarios = new javax.swing.JMenuItem();
        subMenuGerenciamento = new javax.swing.JMenu();
        miAlterarSenha = new javax.swing.JMenuItem();
        miAlterarDados = new javax.swing.JMenuItem();
        notificacoesMenu = new javax.swing.JMenu();
        miNovaNotificacao = new javax.swing.JMenuItem();
        miVisualizarNotificacoes = new javax.swing.JMenuItem();
        ajudaMenu = new javax.swing.JMenu();
        miSobre = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sessaoMenu.setMnemonic('f');
        sessaoMenu.setText("Sessão");

        miLogin.setText("Login");
        sessaoMenu.add(miLogin);

        miDeslogar.setMnemonic('a');
        miDeslogar.setText("Deslogar");
        sessaoMenu.add(miDeslogar);

        miSair.setMnemonic('x');
        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        sessaoMenu.add(miSair);

        menuBar.add(sessaoMenu);

        usuariosMenu.setMnemonic('e');
        usuariosMenu.setText("Usuários");

        miNovoUsuario.setMnemonic('t');
        miNovoUsuario.setText("Novo usuário");
        usuariosMenu.add(miNovoUsuario);

        miListarUsuarios.setMnemonic('y');
        miListarUsuarios.setText("Listar usuários");
        usuariosMenu.add(miListarUsuarios);

        subMenuGerenciamento.setText("Gerenciamento");

        miAlterarSenha.setText("Alterar senha");
        subMenuGerenciamento.add(miAlterarSenha);

        miAlterarDados.setText("Alterar dados");
        subMenuGerenciamento.add(miAlterarDados);

        usuariosMenu.add(subMenuGerenciamento);

        menuBar.add(usuariosMenu);

        notificacoesMenu.setText("Notificações");

        miNovaNotificacao.setText("Nova Notificação");
        notificacoesMenu.add(miNovaNotificacao);

        miVisualizarNotificacoes.setText("Visualizar Notificações");
        notificacoesMenu.add(miVisualizarNotificacoes);

        menuBar.add(notificacoesMenu);

        ajudaMenu.setMnemonic('h');
        ajudaMenu.setText("Ajuda");

        miSobre.setMnemonic('a');
        miSobre.setText("Sobre");
        ajudaMenu.add(miSobre);

        menuBar.add(ajudaMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1024, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajudaMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miAlterarDados;
    private javax.swing.JMenuItem miAlterarSenha;
    private javax.swing.JMenuItem miDeslogar;
    private javax.swing.JMenuItem miListarUsuarios;
    private javax.swing.JMenuItem miLogin;
    private javax.swing.JMenuItem miNovaNotificacao;
    private javax.swing.JMenuItem miNovoUsuario;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSobre;
    private javax.swing.JMenuItem miVisualizarNotificacoes;
    private javax.swing.JMenu notificacoesMenu;
    private javax.swing.JMenu sessaoMenu;
    private javax.swing.JMenu subMenuGerenciamento;
    private javax.swing.JMenu usuariosMenu;
    // End of variables declaration//GEN-END:variables

}
