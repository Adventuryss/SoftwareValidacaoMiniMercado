/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciarVendas;

import biblioteca.traduzirElementos;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.swing.table.DefaultTableModel;
import model.bean.ItemVenda;
import model.bean.Venda;
import model.dao.ItemVendaDao;
import model.dao.VendaDao;

/**
 *
 * @author Bruno
 */
public class JPanelAlterarExcluir extends javax.swing.JFrame {

    /**
     * Creates new form JPanelAlterarExcluir
     */
    public JPanelAlterarExcluir() {
        initComponents();
        readJTable();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/cart (6).png")));
        setResizable(false);
        traduzirElementos();
    }

    public void traduzirElementos() {
        try {

            traduzirElementos traduzir = new traduzirElementos();
            String language;

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Project_market\\language.txt"));
            language = reader.readLine();
            reader.close();

            jLabel3.setText(traduzir.TraduzirDados(language, jLabel3.getText()));
            jLabel6.setText(traduzir.TraduzirDados(language, jLabel6.getText()));
            jLabel5.setText(traduzir.TraduzirDados(language, jLabel5.getText()));
            jLabel14.setText(traduzir.TraduzirDados(language, jLabel14.getText()));
            jLabel2.setText(traduzir.TraduzirDados(language, jLabel2.getText()));
            jLabel16.setText(traduzir.TraduzirDados(language, jLabel16.getText()));
            jLabel7.setText(traduzir.TraduzirDados(language, jLabel7.getText()));
            jLabel8.setText(traduzir.TraduzirDados(language, jLabel8.getText()));
            jLabel9.setText(traduzir.TraduzirDados(language, jLabel9.getText()));
            jLabel10.setText(traduzir.TraduzirDados(language, jLabel10.getText()));
            jLabel11.setText(traduzir.TraduzirDados(language, jLabel11.getText()));
            jLabel12.setText(traduzir.TraduzirDados(language, jLabel2.getText()));
            jLabel15.setText(traduzir.TraduzirDados(language, jLabel15.getText()));

            jLabelSobreporExcluir.setText(traduzir.TraduzirDados(language, jLabelSobreporExcluir.getText()));
            jLabelSobreporAlterar.setText(traduzir.TraduzirDados(language, jLabelSobreporAlterar.getText()));
            jLabelSobreporExcluir1.setText(traduzir.TraduzirDados(language, jLabelSobreporExcluir1.getText()));
            jLabelSobreporAlterar1.setText(traduzir.TraduzirDados(language, jLabelSobreporAlterar1.getText()));

            jLabelSobreporBuscar.setText(traduzir.TraduzirDados(language, jLabelSobreporBuscar.getText()));
            jLabelSobreporCancelar.setText(traduzir.TraduzirDados(language, jLabelSobreporCancelar.getText()));

            jTableVendas.getColumnModel().getColumn(0).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableVendas.getColumnModel().getColumn(0).getHeaderValue()));

            jTableVendas.getColumnModel().getColumn(1).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableVendas.getColumnModel().getColumn(1).getHeaderValue()));

            jTableVendas.getColumnModel().getColumn(3).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableVendas.getColumnModel().getColumn(3).getHeaderValue()));

            jTableVendas.getColumnModel().getColumn(4).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableVendas.getColumnModel().getColumn(4).getHeaderValue()));

            jTable_iv.getColumnModel().getColumn(0).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_iv.getColumnModel().getColumn(0).getHeaderValue()));

            jTable_iv.getColumnModel().getColumn(1).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_iv.getColumnModel().getColumn(1).getHeaderValue()));

            jTable_iv.getColumnModel().getColumn(2).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_iv.getColumnModel().getColumn(2).getHeaderValue()));

            jTable_iv.getColumnModel().getColumn(3).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_iv.getColumnModel().getColumn(3).getHeaderValue()));

            jTable_iv.getColumnModel().getColumn(4).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_iv.getColumnModel().getColumn(4).getHeaderValue()));

        } catch (GeneralSecurityException | IOException ex) {
            System.out.println("Erro");
        }
    }

    public void limparCampos() {
        jTFData.setText("");
        jTFNF.setText("");
        jTFSubtotal.setText("");
        jTextFieldTotal.setText("");
        jTextField_VendaCodVenda.setText("");

        jTextField_codItemVenda.setText("");
        jTextField_IVValorUnitario.setText("");
        jTextField_IVQuant.setText("");
        jTextField_IVTotal.setText("");
        jTextField_IVCod_Venda.setText("");
        jTextField_IVCod_estoque.setText("");

    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTableVendas.getModel();
        modelo.setNumRows(0);

        VendaDao vdao = new VendaDao();

        vdao.read().forEach((v) -> {
            modelo.addRow(new Object[]{
                v.getCod_venda(),
                v.getData_venda(),
                v.getNumeroNF(),
                v.getSubtotal(),
                v.getTotal(),});
        });
    }

    public void readJTableForDesc(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable_iv.getModel();
        modelo.setNumRows(0);

        ItemVendaDao vdao = new ItemVendaDao();

        vdao.readForDesc(desc).forEach((v) -> {
            modelo.addRow(new Object[]{
                v.getCod_itemvenda(),
                v.getValorunitario(),
                v.getQuantidade(),
                v.getTotal(),
                v.getCod_venda(),
                v.getCod_estoque(),});
        });
    }

    public void readJTableForDescVenda(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTableVendas.getModel();
        modelo.setNumRows(0);

        VendaDao vdao = new VendaDao();

        vdao.readForDesc(desc).forEach((v) -> {
            modelo.addRow(new Object[]{
                v.getCod_venda(),
                v.getData_venda(),
                v.getNumeroNF(),
                v.getSubtotal(),
                v.getTotal(),});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSobreporAlterar = new javax.swing.JLabel();
        jLabelSobreporExcluir1 = new javax.swing.JLabel();
        jLabelSobreporCancelar = new javax.swing.JLabel();
        jLabelSobreporBuscar = new javax.swing.JLabel();
        jLabelSobreporAlterar1 = new javax.swing.JLabel();
        jLabelSobreporExcluir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFData = new javax.swing.JTextField();
        jTFNF = new javax.swing.JTextField();
        jTFSubtotal = new javax.swing.JTextField();
        jButton_buscar = new javax.swing.JButton();
        jTextField_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_iv = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField_VendaCodVenda = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_codItemVenda = new javax.swing.JTextField();
        jTextField_IVQuant = new javax.swing.JTextField();
        jTextField_IVValorUnitario = new javax.swing.JTextField();
        jTextField_IVTotal = new javax.swing.JTextField();
        jTextField_IVCod_Venda = new javax.swing.JTextField();
        jTextField_IVCod_estoque = new javax.swing.JTextField();
        jButton_alterarIV = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Vendas");
        getContentPane().setLayout(null);

        jLabelSobreporAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporAlterar.setText("Alterar");
        getContentPane().add(jLabelSobreporAlterar);
        jLabelSobreporAlterar.setBounds(100, 490, 80, 30);

        jLabelSobreporExcluir1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporExcluir1.setText("Excluir");
        getContentPane().add(jLabelSobreporExcluir1);
        jLabelSobreporExcluir1.setBounds(250, 490, 60, 30);

        jLabelSobreporCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporCancelar.setText("Cancelar");
        getContentPane().add(jLabelSobreporCancelar);
        jLabelSobreporCancelar.setBounds(400, 490, 110, 30);

        jLabelSobreporBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporBuscar.setText("Procura");
        getContentPane().add(jLabelSobreporBuscar);
        jLabelSobreporBuscar.setBounds(410, 180, 70, 30);

        jLabelSobreporAlterar1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporAlterar1.setText("Alterar");
        getContentPane().add(jLabelSobreporAlterar1);
        jLabelSobreporAlterar1.setBounds(640, 490, 80, 30);

        jLabelSobreporExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporExcluir.setText("Excluir");
        getContentPane().add(jLabelSobreporExcluir);
        jLabelSobreporExcluir.setBounds(800, 490, 60, 30);

        jTableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATA COMPRA", "NF:", "SUBTOTAL", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVendas);
        if (jTableVendas.getColumnModel().getColumnCount() > 0) {
            jTableVendas.getColumnModel().getColumn(0).setMinWidth(40);
            jTableVendas.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 240, 464, 230);

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar2.png"))); // NOI18N
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar);
        jButtonAlterar.setBounds(50, 480, 118, 51);

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2.png"))); // NOI18N
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir);
        jButtonExcluir.setBounds(200, 480, 118, 51);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATA VENDA:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 140, 18);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 480, 118, 51);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NF:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 60, 150, 18);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ITENS DA VENDA SELECIONADA:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(680, 220, 240, 18);

        jTFData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDataActionPerformed(evt);
            }
        });
        getContentPane().add(jTFData);
        jTFData.setBounds(30, 80, 160, 30);

        jTFNF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNFActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNF);
        jTFNF.setBounds(200, 80, 290, 30);

        jTFSubtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSubtotalActionPerformed(evt);
            }
        });
        getContentPane().add(jTFSubtotal);
        jTFSubtotal.setBounds(180, 140, 170, 30);

        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        jButton_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscar);
        jButton_buscar.setBounds(380, 180, 100, 30);

        jTextField_buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_buscar);
        jTextField_buscar.setBounds(30, 180, 340, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 120, 100, 18);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bompreco.png"))); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(950, 500, 120, 60);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minimercado.png"))); // NOI18N
        getContentPane().add(jLabel17);
        jLabel17.setBounds(890, 470, 150, 60);

        jTextFieldTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldTotal);
        jTextFieldTotal.setBounds(360, 140, 130, 30);

        jTable_iv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "VALOR UNITÁRIO", "QUANTIDADE", "TOTAL", "ID VENDA", "ID ESTOQUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_iv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ivMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_iv);
        if (jTable_iv.getColumnModel().getColumnCount() > 0) {
            jTable_iv.getColumnModel().getColumn(0).setMinWidth(40);
            jTable_iv.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(530, 240, 490, 230);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CÓDIGO VENDA:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 120, 140, 18);

        jTextField_VendaCodVenda.setEditable(false);
        jTextField_VendaCodVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_VendaCodVenda);
        jTextField_VendaCodVenda.setBounds(30, 140, 140, 30);

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("VENDAS:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(220, 220, 150, 18);

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("COD ITEM VENDA:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(530, 100, 190, 18);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("VALOR UNITÁRIO:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(700, 100, 160, 18);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("QUANTIDADE:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(870, 100, 150, 18);

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(530, 160, 140, 18);

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CÓDIGO VENDA:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(700, 160, 190, 18);

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("SUBTOTAL:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(180, 120, 150, 18);

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CÓDIGO ESTOQUE:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(870, 160, 160, 18);

        jTextField_codItemVenda.setEditable(false);
        jTextField_codItemVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_codItemVenda);
        jTextField_codItemVenda.setBounds(530, 120, 150, 30);

        jTextField_IVQuant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVQuant);
        jTextField_IVQuant.setBounds(870, 120, 150, 30);

        jTextField_IVValorUnitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVValorUnitario);
        jTextField_IVValorUnitario.setBounds(700, 120, 150, 30);

        jTextField_IVTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVTotal);
        jTextField_IVTotal.setBounds(530, 180, 150, 30);

        jTextField_IVCod_Venda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVCod_Venda);
        jTextField_IVCod_Venda.setBounds(700, 180, 150, 30);

        jTextField_IVCod_estoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVCod_estoque);
        jTextField_IVCod_estoque.setBounds(870, 180, 150, 30);

        jButton_alterarIV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar2.png"))); // NOI18N
        jButton_alterarIV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_alterarIV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarIVActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_alterarIV);
        jButton_alterarIV.setBounds(590, 480, 118, 51);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2_1.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(750, 480, 118, 51);

        jPanel1.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel14.setText("GERENCIAR VENDAS");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(440, 30, 299, 26);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, -20, 1360, 70);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/49239.jpg"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(-440, 40, 1860, 570);

        setSize(new java.awt.Dimension(1088, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        if (jTableVendas.getSelectedRow() != -1) {

            Venda v = new Venda();
            VendaDao dao = new VendaDao();

            v.setNumeroNF(jTFNF.getText());
            v.setSubtotal(Double.parseDouble(jTFSubtotal.getText()));
            v.setTotal(Double.parseDouble(jTextFieldTotal.getText()));
            v.setData_venda(jTFData.getText());

            v.setCod_venda((int) jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 0));

            dao.update(v);

            limparCampos();

            readJTable();

        }


    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        if (jTableVendas.getSelectedRow() != -1) {

            Venda v = new Venda();
            VendaDao dao = new VendaDao();

            v.setCod_venda((int) jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 0));
            dao.delete(v);
            limparCampos();

            readJTable();

        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable_iv.getModel();
        modelo.setRowCount(0);

        limparCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTFDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDataActionPerformed

    private void jTFNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNFActionPerformed

    private void jTFSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFSubtotalActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        readJTableForDescVenda(jTextField_buscar.getText());

    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jTableVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendasMouseClicked

        if (jTableVendas.getSelectedRow() != -1) {

            jTFData.setText(jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 1).toString());
            jTFNF.setText(jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 2).toString());
            jTFSubtotal.setText(jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 3).toString());
            jTextFieldTotal.setText(jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 4).toString());
            jTextField_VendaCodVenda.setText(jTableVendas.getValueAt(jTableVendas.getSelectedRow(), 0).toString());

            readJTableForDesc(jTextField_VendaCodVenda.getText());
        }


    }//GEN-LAST:event_jTableVendasMouseClicked

    private void jTable_ivMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ivMouseClicked

        if (jTable_iv.getSelectedRow() != -1) {

            jTextField_codItemVenda.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 0).toString());
            jTextField_IVValorUnitario.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 1).toString());
            jTextField_IVQuant.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 2).toString());
            jTextField_IVTotal.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 3).toString());
            jTextField_IVCod_Venda.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 4).toString());
            jTextField_IVCod_estoque.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 5).toString());

        }
    }//GEN-LAST:event_jTable_ivMouseClicked

    private void jButton_alterarIVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarIVActionPerformed

        if (jTable_iv.getSelectedRow() != -1) {

            ItemVenda iv = new ItemVenda();
            ItemVendaDao dao = new ItemVendaDao();

            iv.setValorunitario(Double.parseDouble(jTextField_IVValorUnitario.getText()));
            iv.setQuantidade(Integer.parseInt(jTextField_IVQuant.getText()));
            iv.setTotal(Double.parseDouble(jTextField_IVTotal.getText()));
            iv.setCod_venda(Integer.parseInt(jTextField_IVCod_Venda.getText()));
            iv.setCod_estoque(Integer.parseInt(jTextField_IVCod_estoque.getText()));

            iv.setCod_itemvenda((int) jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 0));

            dao.update(iv);

            limparCampos();
            readJTableForDesc(jTextField_VendaCodVenda.getText());

        }
    }//GEN-LAST:event_jButton_alterarIVActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jTable_iv.getSelectedRow() != -1) {

            ItemVenda iv = new ItemVenda();
            ItemVendaDao dao = new ItemVendaDao();

            iv.setCod_itemvenda((int) jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 0));
            dao.delete(iv);
            limparCampos();

            readJTableForDesc(jTextField_VendaCodVenda.getText());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JPanelAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPanelAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPanelAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPanelAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPanelAlterarExcluir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButton_alterarIV;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSobreporAlterar;
    private javax.swing.JLabel jLabelSobreporAlterar1;
    private javax.swing.JLabel jLabelSobreporBuscar;
    private javax.swing.JLabel jLabelSobreporCancelar;
    private javax.swing.JLabel jLabelSobreporExcluir;
    private javax.swing.JLabel jLabelSobreporExcluir1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFData;
    private javax.swing.JTextField jTFNF;
    private javax.swing.JTextField jTFSubtotal;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTable jTable_iv;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextField_IVCod_Venda;
    private javax.swing.JTextField jTextField_IVCod_estoque;
    private javax.swing.JTextField jTextField_IVQuant;
    private javax.swing.JTextField jTextField_IVTotal;
    private javax.swing.JTextField jTextField_IVValorUnitario;
    private javax.swing.JTextField jTextField_VendaCodVenda;
    private javax.swing.JTextField jTextField_buscar;
    private javax.swing.JTextField jTextField_codItemVenda;
    // End of variables declaration//GEN-END:variables
}
