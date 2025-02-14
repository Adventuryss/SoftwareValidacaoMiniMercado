import java.awt.Toolkit;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        SetIcon();
        
        
    }
    
    private void SetIcon(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/user-silhouette.png"))); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_user = new javax.swing.JTextField();
        jPasswordField_senha = new javax.swing.JPasswordField();
        jLabel_senha = new javax.swing.JLabel();
        jLabel_user = new javax.swing.JLabel();
        jButton_sair = new javax.swing.JButton();
        jButton_acessar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(null);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tela de Login:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(240, 150, 110, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bompreco.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 60, 120, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user-silhouette.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 190, 20, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho_1.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 40, 90, 140);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/key.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(400, 246, 16, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minimercado.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 20, 150, 60);

        jTextField_user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_user);
        jTextField_user.setBounds(220, 190, 200, 30);

        jPasswordField_senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jPasswordField_senha);
        jPasswordField_senha.setBounds(220, 240, 200, 30);

        jLabel_senha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_senha.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_senha.setText("Senha:");
        getContentPane().add(jLabel_senha);
        jLabel_senha.setBounds(150, 240, 70, 30);

        jLabel_user.setBackground(new java.awt.Color(102, 102, 255));
        jLabel_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_user.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_user.setText("Usuário:");
        getContentPane().add(jLabel_user);
        jLabel_user.setBounds(150, 190, 70, 30);

        jButton_sair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_sair.setText("Sair");
        jButton_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_sair.setFocusPainted(false);
        jButton_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sairActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_sair);
        jButton_sair.setBounds(310, 290, 80, 30);

        jButton_acessar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_acessar.setText("Acessar");
        jButton_acessar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_acessar.setFocusPainted(false);
        jButton_acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_acessarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_acessar);
        jButton_acessar.setBounds(190, 290, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/smoke-spreading-blue-background_23-2147785936.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 560, 380);

        setSize(new java.awt.Dimension(575, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_acessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_acessarActionPerformed
        if(jTextField_user.getText().equals("admin") && jPasswordField_senha.getText().equals("1234")){
        FramePrincipal frame = null;
            try {
                frame = new FramePrincipal();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (GeneralSecurityException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame.setVisible(true);
        dispose();                                                                      // Para o login
        }else{
            JOptionPane.showMessageDialog(rootPane, "Senha ou Usuário Inválidos");
        }
    }//GEN-LAST:event_jButton_acessarActionPerformed

    private void jButton_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_sairActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_acessar;
    private javax.swing.JButton jButton_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_senha;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JPasswordField jPasswordField_senha;
    private javax.swing.JTextField jTextField_user;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
