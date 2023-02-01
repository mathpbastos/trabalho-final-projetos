/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package edu.ufes.trabalho.view.cadastro;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author b1n
 */
public class TelaManterUsuarioView extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadastroView
     */
    public TelaManterUsuarioView() {
        initComponents();
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    public JLabel getLblDataCadastro() {
        return lblDataCadastro;
    }

    public JPasswordField getPfConfirmacaoSenha() {
        return pfConfirmacaoSenha;
    }

    public JPasswordField getPfSenha() {
        return pfSenha;
    }

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public JLabel getLblDataModificacaoInfo() {
        return lblDataModificacaoInfo;
    }

    public JLabel getLblDataModificacao() {
        return lblDataModificacao;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public JLabel getLblIdInfo() {
        return lblIdInfo;
    }

    public JLabel getLblConfimacaoSenha() {
        return lblConfimacaoSenha;
    }

    public JLabel getLblSenha() {
        return lblSenha;
    }

    public JCheckBox getCbAdministrador() {
        return cbAdministrador;
    }

    public JCheckBox getCbAutorizado() {
        return cbAutorizado;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblConfimacaoSenha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDataCadastro = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        tfLogin = new javax.swing.JTextField();
        pfSenha = new javax.swing.JPasswordField();
        pfConfirmacaoSenha = new javax.swing.JPasswordField();
        lblDataModificacao = new javax.swing.JLabel();
        lblDataModificacaoInfo = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblIdInfo = new javax.swing.JLabel();
        cbAdministrador = new javax.swing.JCheckBox();
        cbAutorizado = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Nome:");

        jLabel2.setText("Login:");

        lblSenha.setText("Senha:");

        lblConfimacaoSenha.setText("Confirme a senha:");

        jLabel5.setText("Dt. do Cadastro:");

        lblDataCadastro.setText("dd/MM/yyyy");

        btnCadastrar.setText("Cadastrar");

        btnSair.setText("Sair");

        lblDataModificacao.setText("Dt. Modificação:");

        lblDataModificacaoInfo.setText("dd/MM/yyyy");

        btnEditar.setText("Editar");

        btnExcluir.setText("Excluir");

        lblId.setFont(new java.awt.Font("YaHei Consolas Hybrid", 1, 14)); // NOI18N
        lblId.setText("ID:");

        lblIdInfo.setFont(new java.awt.Font("YaHei Consolas Hybrid", 1, 14)); // NOI18N
        lblIdInfo.setText("xxx");

        cbAdministrador.setText("Administrador");

        cbAutorizado.setText("Autorizado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDataCadastro)
                                        .addGap(53, 53, 53)
                                        .addComponent(lblConfimacaoSenha))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblSenha)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pfSenha)
                                    .addComponent(pfConfirmacaoSenha)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIdInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbAdministrador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbAutorizado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDataModificacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDataModificacaoInfo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfimacaoSenha)
                    .addComponent(jLabel5)
                    .addComponent(lblDataCadastro)
                    .addComponent(pfConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAdministrador)
                    .addComponent(cbAutorizado)
                    .addComponent(lblId)
                    .addComponent(lblIdInfo))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataModificacao)
                    .addComponent(lblDataModificacaoInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 618, 268);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox cbAdministrador;
    private javax.swing.JCheckBox cbAutorizado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblConfimacaoSenha;
    private javax.swing.JLabel lblDataCadastro;
    private javax.swing.JLabel lblDataModificacao;
    private javax.swing.JLabel lblDataModificacaoInfo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdInfo;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField pfConfirmacaoSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}