/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciarCompra;


import Connection.ConnectionFactory;
import biblioteca.traduzirElementos;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Compra;
import model.bean.ItemCompra;
import model.bean.Produto;
import model.dao.CompraDao;
import model.dao.ItemCompraDao;
import model.dao.ProdutoDao;

/**
 *
 * @author Bruno
 */
public class JFGerenciarCompra extends javax.swing.JFrame {

    /**
     * Creates new form JFGerenciarCompra
     */
    public JFGerenciarCompra() {
        initComponents();
        preencherNomes();   // preenche a combo box
        gerarNF();
        jTextField_data.setText(new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/GerenciarCompra/cart (6).png"))); 
        traduzirElementos();
        setResizable(false);
    }
    
   public void traduzirElementos(){
        try {

            traduzirElementos traduzir = new traduzirElementos();
            String language;

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Project_market\\language.txt"));
            language = reader.readLine();
            reader.close();

            jLabel14.setText(traduzir.TraduzirDados(language, jLabel14.getText()));
            jLabel7.setText(traduzir.TraduzirDados(language, jLabel7.getText()));
            jLabel8.setText(traduzir.TraduzirDados(language, jLabel8.getText()));
            jLabel10.setText(traduzir.TraduzirDados(language, jLabel10.getText()));
            jLabel6.setText(traduzir.TraduzirDados(language, jLabel6.getText()));
            jLabel9.setText(traduzir.TraduzirDados(language, jLabel9.getText()));
            
            jLabel5.setText(traduzir.TraduzirDados(language, jLabel5.getText()));
            jLabel9.setText(traduzir.TraduzirDados(language, jLabel9.getText()));
            jLabel15.setText(traduzir.TraduzirDados(language, jLabel15.getText()));

            jLabelSobreporExcluir.setText(traduzir.TraduzirDados(language, jLabelSobreporExcluir.getText()));
            jLabelSobreporAlterar.setText(traduzir.TraduzirDados(language, jLabelSobreporAlterar.getText()));
            jLabelSobreporCancelar.setText(traduzir.TraduzirDados(language, jLabelSobreporCancelar.getText()));

            jTable_selecionados.getColumnModel().getColumn(1).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(1).getHeaderValue()));

            jTable_selecionados.getColumnModel().getColumn(2).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(2).getHeaderValue()));

            jTable_selecionados.getColumnModel().getColumn(3).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(3).getHeaderValue()));

            jTable_selecionados.getColumnModel().getColumn(4).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(4).getHeaderValue()));

;

        } catch (GeneralSecurityException | IOException ex) {
            System.out.println("Erro");
        }
    }
    
    public void gerarNF() {  // gera um nf aleatoria

        Random random = new Random();
        String letras = "0123456789";
 
        String armazenaChaves = "";
        int index = -1;
        for( int i = 0; i < 30; i++ ) {
        index = random.nextInt( letras.length() );
        armazenaChaves += letras.substring( index, index + 1 );
        
        }
 
        jTextField_nf.setText(armazenaChaves);       
        
        
}
    
    
        private void LimparCampos(){
        DefaultTableModel modelo = (DefaultTableModel) jTable_selecionados.getModel();     // limpar todo os campos apos uma venda
        
        jTextField_recebido.setText("0");
        jTextField_troco.setText("0");
        modelo.setRowCount(0);
        
    }
        
    private void LimparCampos2(){
        
        jTextField_qnt.setText("1");
        jTextField_valor.setText("0.00");
        
    }
    
  
    public void preencherNomes(){  
      
        Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt;
	ResultSet rs = null;
 
        ProdutoDao pdao = new ProdutoDao();

        try {
            stmt = con.prepareStatement("select * from estoque");
            rs = stmt.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(JFGerenciarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Produto p: pdao.read()){
	jComboBox_nomes.addItem(p);
   }
     

 }
    
    public void AtualizarTroco() {  // atualiza o valor do troco quando chamada
       double troco = 0;
        
        troco = (Double.parseDouble(jTextField_recebido.getText()) - Double.parseDouble(jTextField_total.getText()));
        
        double totale2 = (double) Math.round(troco * 100) / 100;
        jTextField_troco.setText(totale2 + "");
    
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_selecionados = new javax.swing.JTable();
        jLabelSobreporCancelar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_total = new javax.swing.JTextField();
        jTextField_valorProduto = new javax.swing.JTextField();
        jTextField_qnt = new javax.swing.JTextField();
        jLabelSobreporCancelar1 = new javax.swing.JLabel();
        jLabelSobreporAlterar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelSobreporExcluir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton_adicionar = new javax.swing.JButton();
        jTextField_nf = new javax.swing.JTextField();
        jTextField_recebido = new javax.swing.JTextField();
        jButton_cancela = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_troco = new javax.swing.JTextField();
        jTextField_data = new javax.swing.JTextField();
        jButton_elimina1 = new javax.swing.JButton();
        jButton_finalizar = new javax.swing.JButton();
        jComboBox_nomes = new javax.swing.JComboBox<Object>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_valor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COD_ESTOQUE:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Compras");
        setSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(null);

        jTable_selecionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "Quantidade", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_selecionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_selecionadosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable_selecionadosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_selecionados);
        if (jTable_selecionados.getColumnModel().getColumnCount() > 0) {
            jTable_selecionados.getColumnModel().getColumn(0).setMinWidth(40);
            jTable_selecionados.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(540, 80, 410, 300);

        jLabelSobreporCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporCancelar.setText("Cancelar");
        getContentPane().add(jLabelSobreporCancelar);
        jLabelSobreporCancelar.setBounds(460, 290, 110, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" NOMES EM ESTOQUE:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 130, 140, 17);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(530, 390, 120, 17);

        jTextField_total.setEditable(false);
        jTextField_total.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jTextField_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_totalActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_total);
        jTextField_total.setBounds(530, 410, 140, 54);

        jTextField_valorProduto.setEditable(false);
        jTextField_valorProduto.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_valorProduto.setText("0");
        jTextField_valorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_valorProdutoActionPerformed(evt);
            }
        });
        jTextField_valorProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_valorProdutoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_valorProduto);
        jTextField_valorProduto.setBounds(260, 290, 130, 30);

        jTextField_qnt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_qnt.setText("1");
        getContentPane().add(jTextField_qnt);
        jTextField_qnt.setBounds(260, 220, 130, 30);

        jLabelSobreporCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporCancelar1.setText("Cancelar");
        getContentPane().add(jLabelSobreporCancelar1);
        jLabelSobreporCancelar1.setBounds(180, 520, 110, 30);

        jLabelSobreporAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporAlterar.setText("Adicionar");
        getContentPane().add(jLabelSobreporAlterar);
        jLabelSobreporAlterar.setBounds(460, 140, 80, 50);

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("REALIZAR COMPRA");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(780, 400, 290, 70);

        jLabelSobreporExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporExcluir.setText("Excluir");
        getContentPane().add(jLabelSobreporExcluir);
        jLabelSobreporExcluir.setBounds(460, 220, 60, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("QUANTIDADE:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(260, 200, 140, 17);

        jButton_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar.png"))); // NOI18N
        jButton_adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_adicionarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_adicionar);
        jButton_adicionar.setBounds(410, 140, 118, 51);

        jTextField_nf.setEditable(false);
        jTextField_nf.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        getContentPane().add(jTextField_nf);
        jTextField_nf.setBounds(150, 80, 360, 30);

        jTextField_recebido.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_recebido.setText("0");
        jTextField_recebido.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jTextField_recebidoAncestorRemoved(evt);
            }
        });
        jTextField_recebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_recebidoActionPerformed(evt);
            }
        });
        jTextField_recebido.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField_recebidoPropertyChange(evt);
            }
        });
        jTextField_recebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_recebidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_recebidoKeyReleased(evt);
            }
        });
        getContentPane().add(jTextField_recebido);
        jTextField_recebido.setBounds(200, 430, 110, 30);

        jButton_cancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        jButton_cancela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_cancela);
        jButton_cancela.setBounds(410, 280, 116, 51);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VALOR RECEBIDO:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 410, 108, 17);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TROCO:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 410, 120, 17);

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DATA:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 60, 100, 17);

        jTextField_troco.setEditable(false);
        jTextField_troco.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_troco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_trocoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_troco);
        jTextField_troco.setBounds(350, 430, 120, 30);

        jTextField_data.setEditable(false);
        jTextField_data.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        getContentPane().add(jTextField_data);
        jTextField_data.setBounds(20, 80, 120, 30);

        jButton_elimina1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2.png"))); // NOI18N
        jButton_elimina1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_elimina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_elimina1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_elimina1);
        jButton_elimina1.setBounds(410, 210, 116, 51);

        jButton_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/finalizarcompra.png"))); // NOI18N
        jButton_finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_finalizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_finalizar);
        jButton_finalizar.setBounds(710, 410, 210, 54);

        jComboBox_nomes.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jComboBox_nomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_nomesActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_nomes);
        jComboBox_nomes.setBounds(20, 150, 220, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PRODUTOS SELECIONADOS:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(540, 60, 180, 17);

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("VALOR:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(260, 130, 70, 17);

        jTextField_valor.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_valor.setText("0.00");
        jTextField_valor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField_valorMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField_valorMouseReleased(evt);
            }
        });
        jTextField_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_valorKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_valor);
        jTextField_valor.setBounds(260, 150, 130, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NF:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(150, 60, 150, 20);

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TOTAL:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(260, 270, 90, 17);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/49239.jpg"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(-390, 50, 1530, 550);

        jPanel2.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel14.setText("REALIZAR COMPRAS");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(370, 50, 299, 26);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jPanel2.add(jTextField1);
        jTextField1.setBounds(1000, 50, 40, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, -40, 1080, 90);

        setSize(new java.awt.Dimension(1008, 556));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_selecionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_selecionadosMouseClicked

    }//GEN-LAST:event_jTable_selecionadosMouseClicked

    private void jButton_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_adicionarActionPerformed

        
       DefaultTableModel modelo = (DefaultTableModel) jTable_selecionados.getModel(); 
       Produto produto = (Produto) jComboBox_nomes.getSelectedItem();
         
       double z = 0, h = 0, totale = 0; 
       int u = 0;  
            
         u = Integer.parseInt(jTextField_qnt.getText());
         h = Double.parseDouble(jTextField_valor.getText());
         totale = (u*h);
         
         double totale2 = (double) Math.round(totale * 100) / 100;
         jTextField_valorProduto.setText(totale2 + "");           // Coloca valor total item
         
         
         modelo.addRow(new Object[]{produto.getCod_estoque(), produto.getNome(),jTextField_valor.getText(), jTextField_qnt.getText(), jTextField_valorProduto.getText()});
         

         for(int y = 0; y < jTable_selecionados.getRowCount(); y++) {                    // somar o total
	 z += Double.parseDouble(jTable_selecionados.getValueAt(y, 4).toString());
         }
        
	jTextField_total.setText(z + "");        // atualiza total a cada insercao
        
        AtualizarTroco(); 
        LimparCampos2();
        
        
        
    }//GEN-LAST:event_jButton_adicionarActionPerformed

  
    
    private void jTextField_recebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_recebidoActionPerformed

    }//GEN-LAST:event_jTextField_recebidoActionPerformed

    private void jTextField_recebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_recebidoKeyReleased

        AtualizarTroco();
        
    }//GEN-LAST:event_jTextField_recebidoKeyReleased

    private void jButton_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelaActionPerformed
        LimparCampos();

    }//GEN-LAST:event_jButton_cancelaActionPerformed

    private void jTextField_trocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_trocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_trocoActionPerformed

    private void jButton_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_finalizarActionPerformed
        
        Random random = new Random();
        String letras = "0123456789";
 
        String VALORCOD = "";
        int index = -1;
        for( int i = 0; i < 3; i++ ) {
        index = random.nextInt( letras.length() );
        VALORCOD += letras.substring( index, index + 1 );   
    }

        Compra c = new Compra();
        CompraDao dao = new CompraDao();
        
        ItemCompra ic = new ItemCompra();
        ItemCompraDao idao = new ItemCompraDao();
        
          // compra
          c.setCod_compra(Integer.parseInt(VALORCOD));
          c.setNumeroNF(jTextField_nf.getText());
          c.setSubtotal(Double.parseDouble(jTextField_troco.getText()));
          c.setTotal(Double.parseDouble(jTextField_total.getText()));
          c.setData_compra(jTextField_data.getText());
    
          dao.create(c);
          // item compra
       
       try{

        int rows= jTable_selecionados.getRowCount();
            
        
        for(int row = 0; row<rows; row++){
            
            String string= jTable_selecionados.getValueAt(row, 0).toString();
            String nome = (String)jTable_selecionados.getValueAt(row, 1);
            String valor = (String)jTable_selecionados.getValueAt(row, 2);
            String qnt = (String)jTable_selecionados.getValueAt(row, 3);
            String valortotal = (String)jTable_selecionados.getValueAt(row, 4);
            
          int cod_produto = Integer.parseInt(string);
            
          ic.setValorunitario(Double.parseDouble(valor));
          ic.setQuantidade(Integer.parseInt(qnt));
          ic.setTotal(Double.parseDouble(valortotal));
          ic.setCod_compra(Integer.parseInt(VALORCOD));
          ic.setCod_estoque(cod_produto);
          
          idao.create(ic); 
            
        }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
            
        }
          
          LimparCampos();
          gerarNF();
          
    }//GEN-LAST:event_jButton_finalizarActionPerformed

    private void jTextField_valorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_valorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_valorProdutoActionPerformed

    private void jTextField_valorProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_valorProdutoKeyTyped
        
    }//GEN-LAST:event_jTextField_valorProdutoKeyTyped

    private void jTextField_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_valorKeyTyped
       
    }//GEN-LAST:event_jTextField_valorKeyTyped

    private void jTextField_valorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_valorMouseExited

    }//GEN-LAST:event_jTextField_valorMouseExited

    private void jTextField_valorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_valorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_valorMouseReleased

    private void jTable_selecionadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_selecionadosMouseReleased
 
    }//GEN-LAST:event_jTable_selecionadosMouseReleased

    private void jTextField_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_totalActionPerformed

    private void jButton_elimina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_elimina1ActionPerformed
        double z = 0;
        
        if(jTable_selecionados.getSelectedRow() != -1){

        DefaultTableModel modelo = (DefaultTableModel) jTable_selecionados.getModel();         
            
        try{
	int SelectedRowIndex = jTable_selecionados.getSelectedRow();
	modelo.removeRow(SelectedRowIndex);
	}catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null, ex);
        }
                
        for(int y = 0; y < jTable_selecionados.getRowCount(); y++) {
	z += Double.parseDouble(jTable_selecionados.getValueAt(y, 4).toString());
        }
        
	jTextField_total.setText(z + "");
        AtualizarTroco();
        
 
} 
    }//GEN-LAST:event_jButton_elimina1ActionPerformed

    private void jTextField_recebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_recebidoKeyPressed
//teste
      
    }//GEN-LAST:event_jTextField_recebidoKeyPressed

    private void jTextField_recebidoAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextField_recebidoAncestorRemoved
        
    }//GEN-LAST:event_jTextField_recebidoAncestorRemoved

    private void jTextField_recebidoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField_recebidoPropertyChange
 
    }//GEN-LAST:event_jTextField_recebidoPropertyChange

    private void jComboBox_nomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_nomesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_nomesActionPerformed

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
            java.util.logging.Logger.getLogger(JFGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFGerenciarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFGerenciarCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_adicionar;
    private javax.swing.JButton jButton_cancela;
    private javax.swing.JButton jButton_elimina1;
    private javax.swing.JButton jButton_finalizar;
    private javax.swing.JComboBox<Object> jComboBox_nomes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSobreporAlterar;
    private javax.swing.JLabel jLabelSobreporCancelar;
    private javax.swing.JLabel jLabelSobreporCancelar1;
    private javax.swing.JLabel jLabelSobreporExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_selecionados;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_data;
    private javax.swing.JTextField jTextField_nf;
    private javax.swing.JTextField jTextField_qnt;
    private javax.swing.JTextField jTextField_recebido;
    private javax.swing.JTextField jTextField_total;
    private javax.swing.JTextField jTextField_troco;
    private javax.swing.JTextField jTextField_valor;
    private javax.swing.JTextField jTextField_valorProduto;
    // End of variables declaration//GEN-END:variables
}
