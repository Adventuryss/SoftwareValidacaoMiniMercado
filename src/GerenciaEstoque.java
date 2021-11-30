import biblioteca.traduzirElementos;
import com.mysql.jdbc.Connection;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.bean.Produto;
import model.dao.ProdutoDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno
 */
public class GerenciaEstoque extends javax.swing.JFrame {
    public Connection c;
   
        
    public void readJTable() {             // Função que lê a tabela dos itens em estoque
    DefaultTableModel modelo = (DefaultTableModel) jTable_estoque.getModel();
    modelo.setNumRows(0);
    
    ProdutoDao pdao = new ProdutoDao();

    pdao.read().forEach((p) -> {
        modelo.addRow(new Object[]{
            p.getCod_estoque(),
            p.getNome(),
            p.getQuantidade(),
            p.getValorUnitario(),
            p.getQtdUnidade(),
            p.getTipoUnidade(),

        }); });
     }
    
          
    public void readJTableForDesc(String desc) {  // Função para o buscador
    DefaultTableModel modelo = (DefaultTableModel) jTable_estoque.getModel();
    modelo.setNumRows(0);
    
    ProdutoDao pdao = new ProdutoDao();

    pdao.readForDesc(desc).forEach((p) -> {
        modelo.addRow(new Object[]{
            p.getCod_estoque(),
            p.getNome(),
            p.getQuantidade(),
            p.getValorUnitario(),
            p.getQtdUnidade(),
            p.getTipoUnidade(),
            
        }); });
     }
         
    
    public GerenciaEstoque() {
        initComponents();     
        
        readJTable();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/cart (6).png")));   // Adicionar icone
        setResizable(false);   // Não deixar o tamanho ser ampliado
        
       traduzirElementos();
    }
                // A lista de Tags aceitas pelo Google Cloud Translation API
            //   pode ser encontrada no link: https://cloud.google.com/translate/docs/languages
    
    public void traduzirElementos(){
        try {

            traduzirElementos traduzir = new traduzirElementos();
            String language;

            BufferedReader reader = new BufferedReader(new FileReader("C:\\internacionalizacao.txt"));
            language = reader.readLine();
            reader.close();

            jLabel_1.setText(traduzir.TraduzirDados(language, jLabel_1.getText()));
            jLabel_2.setText(traduzir.TraduzirDados(language, jLabel_2.getText()));
            jLabel_3.setText(traduzir.TraduzirDados(language, jLabel_3.getText()));
            jLabel_4.setText(traduzir.TraduzirDados(language, jLabel_4.getText()));
            jLabel_5.setText(traduzir.TraduzirDados(language, jLabel_5.getText()));
            jLabel_6.setText(traduzir.TraduzirDados(language, jLabel_6.getText()));

            jLabelSobreporSalvar.setText(traduzir.TraduzirDados(language, jLabelSobreporSalvar.getText()));
            jLabelSobreporExcluir.setText(traduzir.TraduzirDados(language, jLabelSobreporExcluir.getText()));
            jLabelSobreporAlterar.setText(traduzir.TraduzirDados(language, jLabelSobreporAlterar.getText()));
            
            jLabelSobreporBuscar.setText(traduzir.TraduzirDados(language, jLabelSobreporBuscar.getText()));
            jLabelSobreporCancelar.setText(traduzir.TraduzirDados(language, jLabelSobreporCancelar.getText()));

            jTable_estoque.getColumnModel().getColumn(1).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(1).getHeaderValue()));

            jTable_estoque.getColumnModel().getColumn(2).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(2).getHeaderValue()));

            jTable_estoque.getColumnModel().getColumn(3).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(3).getHeaderValue()));

            jTable_estoque.getColumnModel().getColumn(4).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(4).getHeaderValue()));

            jTable_estoque.getColumnModel().getColumn(5).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(5).getHeaderValue()));

        } catch (GeneralSecurityException | IOException ex) {
            Logger.getLogger(GerenciaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparCampos(){
        jTFNome.setText("");
        jTFQuantidade.setText("");
        jTFValor.setText("");
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel_1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelSobreporAlterar = new javax.swing.JLabel();
        jLabelSobreporSalvar = new javax.swing.JLabel();
        jLabelSobreporExcluir = new javax.swing.JLabel();
        jLabelSobreporCancelar = new javax.swing.JLabel();
        jLabelSobreporBuscar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFMoeda = new javax.swing.JTextField();
        jLabel_5 = new javax.swing.JLabel();
        jLabel_6 = new javax.swing.JLabel();
        jButton_2 = new javax.swing.JButton();
        jButton_3 = new javax.swing.JButton();
        jLabel_2 = new javax.swing.JLabel();
        jLabel_3 = new javax.swing.JLabel();
        jLabel_4 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jTFQuantidade = new javax.swing.JTextField();
        jTFValor = new javax.swing.JTextField();
        jButton_1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_estoque = new javax.swing.JTable();
        jButton_4 = new javax.swing.JButton();
        jTextFieldBusca = new javax.swing.JTextField();
        jButton_5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel_1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel_1.setText("GERENCIAMENTO DE ESTOQUE");
        jPanel2.add(jLabel_1);
        jLabel_1.setBounds(230, 60, 299, 26);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(-10, -50, 790, 100);
        jPanel2.getAccessibleContext().setAccessibleName("Gerenciar Estoque");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minimercado.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 550, 150, 60);

        jLabelSobreporAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporAlterar.setText("Alterar");
        getContentPane().add(jLabelSobreporAlterar);
        jLabelSobreporAlterar.setBounds(170, 450, 80, 30);

        jLabelSobreporSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporSalvar.setText("Salva");
        getContentPane().add(jLabelSobreporSalvar);
        jLabelSobreporSalvar.setBounds(80, 450, 50, 30);

        jLabelSobreporExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporExcluir.setText("Excluir");
        getContentPane().add(jLabelSobreporExcluir);
        jLabelSobreporExcluir.setBounds(280, 450, 60, 30);

        jLabelSobreporCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporCancelar.setText("Cancelar");
        getContentPane().add(jLabelSobreporCancelar);
        jLabelSobreporCancelar.setBounds(180, 520, 110, 30);

        jLabelSobreporBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporBuscar.setText("Procura");
        getContentPane().add(jLabelSobreporBuscar);
        jLabelSobreporBuscar.setBounds(690, 80, 70, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bompreco.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 580, 120, 60);

        jTFMoeda.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTFMoeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFMoedaActionPerformed(evt);
            }
        });
        getContentPane().add(jTFMoeda);
        jTFMoeda.setBounds(20, 320, 270, 30);

        jLabel_5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_5.setText("TIPO DA UNIDADE:");
        getContentPane().add(jLabel_5);
        jLabel_5.setBounds(20, 360, 150, 17);

        jLabel_6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_6.setText("UNIDADE:");
        getContentPane().add(jLabel_6);
        jLabel_6.setBounds(20, 300, 150, 17);

        jButton_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Alterar.png"))); // NOI18N
        jButton_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_2);
        jButton_2.setBounds(130, 440, 98, 51);

        jButton_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jButton_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_3);
        jButton_3.setBounds(240, 440, 98, 51);

        jLabel_2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2.setText("NOME:");
        getContentPane().add(jLabel_2);
        jLabel_2.setBounds(20, 100, 120, 20);

        jLabel_3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_3.setText("QUANTIDADE:");
        getContentPane().add(jLabel_3);
        jLabel_3.setBounds(20, 170, 150, 17);

        jLabel_4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_4.setText("VALOR UNITÁRIO:");
        getContentPane().add(jLabel_4);
        jLabel_4.setBounds(20, 240, 150, 17);

        jTFNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNome);
        jTFNome.setBounds(20, 120, 270, 30);

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quilograma", "Pound", "Litro", "Gallon" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(20, 386, 270, 30);

        jTFQuantidade.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTFQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFQuantidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jTFQuantidade);
        jTFQuantidade.setBounds(20, 190, 270, 30);

        jTFValor.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTFValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFValorActionPerformed(evt);
            }
        });
        getContentPane().add(jTFValor);
        jTFValor.setBounds(20, 260, 270, 30);

        jButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar3.png"))); // NOI18N
        jButton_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_1);
        jButton_1.setBounds(20, 440, 100, 51);

        jTable_estoque.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable_estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "QUANTIDADE", "VALOR UNITÁRIO", "UNIDADE", "TIPO UNIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_estoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_estoque);
        if (jTable_estoque.getColumnModel().getColumnCount() > 0) {
            jTable_estoque.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_estoque.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(350, 120, 410, 490);

        jButton_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        jButton_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_4);
        jButton_4.setBounds(130, 510, 116, 51);

        jTextFieldBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldBusca);
        jTextFieldBusca.setBounds(350, 80, 300, 30);

        jButton_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        jButton_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_5);
        jButton_5.setBounds(660, 80, 100, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/istockphoto-656453072-612x612_1.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-20, -30, 860, 770);

        setSize(new java.awt.Dimension(797, 676));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_2ActionPerformed

        if (jTable_estoque.getSelectedRow() != -1) {     // Pega a linha selecionada

            Produto p = new Produto();
            ProdutoDao dao = new ProdutoDao();

            p.setNome(jTFNome.getText());                                 // Pega a nova variavel e manda pros novos valores
            p.setQuantidade(Integer.parseInt(jTFQuantidade.getText()));
            p.setValorUnitario(Double.parseDouble(jTFValor.getText()));
            p.setQtdUnidade(Double.parseDouble(jTFMoeda.getText()));
            p.setTipoUnidade(jComboBox1.getSelectedItem().toString());
            p.setCod_estoque((int) jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 0));

            dao.update(p);                                                                        // atualiza o banco
            limparCampos();

            readJTable();
        }
    }//GEN-LAST:event_jButton_2ActionPerformed

    private void jButton_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_3ActionPerformed
        if (jTable_estoque.getSelectedRow() != -1) {   // pega linha

            Produto p = new Produto();
            ProdutoDao dao = new ProdutoDao();

            p.setCod_estoque((int) jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 0));   //Pega o cod do selecionado
            dao.delete(p);                                                                            // exclui do banco
            limparCampos();

            readJTable();
    }
        
    }//GEN-LAST:event_jButton_3ActionPerformed

    private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeActionPerformed

    private void jTFQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFQuantidadeActionPerformed

    private void jTFValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFValorActionPerformed

    private void jButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1ActionPerformed

        Produto p = new Produto();
        ProdutoDao dao = new ProdutoDao();
        
          p.setNome(jTFNome.getText());
          p.setQuantidade(Integer.parseInt(jTFQuantidade.getText()));    // pega os itens novos escritos
          p.setValorUnitario(Double.parseDouble(jTFValor.getText()));
          p.setQtdUnidade(Double.parseDouble(jTFMoeda.getText()));
          p.setTipoUnidade(jComboBox1.getSelectedItem().toString());
          
          dao.create(p);                                                    // insere no banco
          limparCampos();
          
          readJTable();
    }//GEN-LAST:event_jButton_1ActionPerformed

    private void jTable_estoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_estoqueMouseClicked
        
        if (jTable_estoque.getSelectedRow() != -1) {
            jTFNome.setText(jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 1).toString());  // manda os itens selecionados para os campos
            jTFQuantidade.setText(jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 2).toString());
            jTFValor.setText(jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 3).toString());
        }
        jButton_1.setEnabled(false); // se tiver selecionado algum produto, bloqueia o salvar

    }//GEN-LAST:event_jTable_estoqueMouseClicked

    private void jButton_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_4ActionPerformed
        limparCampos();
        
        jButton_1.setEnabled(true); // ativa o botão salvar
    }//GEN-LAST:event_jButton_4ActionPerformed

    private void jButton_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_5ActionPerformed
        readJTableForDesc(jTextFieldBusca.getText());
    }//GEN-LAST:event_jButton_5ActionPerformed

    private void jTextFieldBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscaActionPerformed
  
    }//GEN-LAST:event_jTextFieldBuscaActionPerformed

    private void jTFMoedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFMoedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFMoedaActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciaEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_1;
    private javax.swing.JButton jButton_2;
    private javax.swing.JButton jButton_3;
    private javax.swing.JButton jButton_4;
    private javax.swing.JButton jButton_5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelSobreporAlterar;
    private javax.swing.JLabel jLabelSobreporBuscar;
    private javax.swing.JLabel jLabelSobreporCancelar;
    private javax.swing.JLabel jLabelSobreporExcluir;
    private javax.swing.JLabel jLabelSobreporSalvar;
    private javax.swing.JLabel jLabel_1;
    private javax.swing.JLabel jLabel_2;
    private javax.swing.JLabel jLabel_3;
    private javax.swing.JLabel jLabel_4;
    private javax.swing.JLabel jLabel_5;
    private javax.swing.JLabel jLabel_6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFMoeda;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFQuantidade;
    private javax.swing.JTextField jTFValor;
    private javax.swing.JTable jTable_estoque;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration//GEN-END:variables
}
