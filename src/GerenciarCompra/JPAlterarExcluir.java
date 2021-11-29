/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciarCompra;

import biblioteca.traduzirElementos;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.swing.table.DefaultTableModel;
import model.bean.Compra;
import model.bean.ItemCompra;
import model.dao.CompraDao;
import model.dao.ItemCompraDao;

/**
 *
 * @author Bruno
 */
public class JPAlterarExcluir extends javax.swing.JFrame {

    /**
     * Creates new form JPAlterarExcluir
     */
    public JPAlterarExcluir() {
        initComponents();
        readJTable();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/GerenciarCompra/cart (6).png"))); 
        setResizable(false);
        traduzirElementos();
        
    }
    
        public void limparCampos(){
        jTFData.setText("");
        jTFNF.setText("");
        jTFSubtotal.setText("");
        jTextFieldTotal.setText("");
        jTextField_CompracodCompra.setText("");
        
        jTextField_codItemVenda.setText("");
        jTextField_IVValorUnitario.setText("");
        jTextField_IVQuant.setText("");
        jTextField_IVTotal.setText("");
        jTextField_IVCod_Venda.setText("");
        jTextField_IVCod_estoque.setText("");
        
        
    }
        
        public void traduzirElementos(){
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

            jTableCompras.getColumnModel().getColumn(0).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableCompras.getColumnModel().getColumn(0).getHeaderValue()));

            jTableCompras.getColumnModel().getColumn(1).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableCompras.getColumnModel().getColumn(1).getHeaderValue()));

            jTableCompras.getColumnModel().getColumn(3).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableCompras.getColumnModel().getColumn(3).getHeaderValue()));

            jTableCompras.getColumnModel().getColumn(4).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTableCompras.getColumnModel().getColumn(4).getHeaderValue()));
            
            
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
        
    public void readJTable() {
    DefaultTableModel modelo = (DefaultTableModel) jTableCompras.getModel();
    modelo.setNumRows(0);
    
    CompraDao vdao = new CompraDao();

    vdao.read().forEach((v) -> {
        modelo.addRow(new Object[]{
            v.getCod_compra(),
            v.getData_compra(),
            v.getNumeroNF(),
            v.getSubtotal(),
            v.getTotal(),
            
        }); });
     }
    
    
    public void readJTableForDesc(String desc) {
    DefaultTableModel modelo = (DefaultTableModel) jTable_iv.getModel();
    modelo.setNumRows(0);
    
    ItemCompraDao vdao = new ItemCompraDao();

    vdao.readForDesc(desc).forEach((v) -> {
        modelo.addRow(new Object[]{
            v.getCod_itemcompra(),
            v.getValorunitario(),
            v.getQuantidade(),
            v.getTotal(),
            v.getCod_compra(),
            v.getCod_estoque(),
            
        }); });
     }
    
    public void readJTableForDescCompra(String desc) {
    DefaultTableModel modelo = (DefaultTableModel) jTableCompras.getModel();
    modelo.setNumRows(0);
    
    CompraDao vdao = new CompraDao();

    vdao.readForDesc(desc).forEach((v) -> {
        modelo.addRow(new Object[]{
            v.getCod_compra(),
            v.getData_compra(),
            v.getNumeroNF(),
            v.getSubtotal(),
            v.getTotal(),
            
            
        }); });
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
        jLabelSobreporExcluir = new javax.swing.JLabel();
        jLabelSobreporCancelar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_codItemVenda = new javax.swing.JTextField();
        jLabelSobreporBuscar = new javax.swing.JLabel();
        jTextField_IVQuant = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField_IVValorUnitario = new javax.swing.JTextField();
        jTextField_IVTotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_IVCod_Venda = new javax.swing.JTextField();
        jLabelSobreporAlterar1 = new javax.swing.JLabel();
        jTFData = new javax.swing.JTextField();
        jTextField_IVCod_estoque = new javax.swing.JTextField();
        jLabelSobreporExcluir1 = new javax.swing.JLabel();
        jTFNF = new javax.swing.JTextField();
        jButton_alterarIV = new javax.swing.JButton();
        jTFSubtotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton_buscar = new javax.swing.JButton();
        jTextField_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_iv = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCompras = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_CompracodCompra = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Compras");
        getContentPane().setLayout(null);

        jLabelSobreporAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporAlterar.setText("Alterar");
        getContentPane().add(jLabelSobreporAlterar);
        jLabelSobreporAlterar.setBounds(120, 490, 80, 30);

        jLabelSobreporExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporExcluir.setText("Excluir");
        getContentPane().add(jLabelSobreporExcluir);
        jLabelSobreporExcluir.setBounds(800, 490, 60, 30);

        jLabelSobreporCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporCancelar.setText("Cancelar");
        getContentPane().add(jLabelSobreporCancelar);
        jLabelSobreporCancelar.setBounds(380, 490, 110, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CÓDIGO ITEM COMPRA:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(530, 100, 180, 18);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("VALOR UNITÁRIO:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(710, 100, 150, 18);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("QUANTIDADE:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(870, 100, 150, 18);

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(530, 160, 150, 18);

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ITENS NA COMPRA SELECIONADA:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(640, 220, 260, 18);

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CÓDIGO COMPRA:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(710, 160, 150, 18);

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CÓDIGO ESTOQUE:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(870, 160, 150, 18);

        jTextField_codItemVenda.setEditable(false);
        jTextField_codItemVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_codItemVenda);
        jTextField_codItemVenda.setBounds(530, 120, 150, 30);

        jLabelSobreporBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporBuscar.setText("Procura");
        getContentPane().add(jLabelSobreporBuscar);
        jLabelSobreporBuscar.setBounds(410, 180, 70, 30);

        jTextField_IVQuant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVQuant);
        jTextField_IVQuant.setBounds(870, 120, 150, 30);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minimercado.png"))); // NOI18N
        getContentPane().add(jLabel17);
        jLabel17.setBounds(890, 470, 150, 60);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bompreco.png"))); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(950, 500, 120, 60);

        jTextField_IVValorUnitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVValorUnitario);
        jTextField_IVValorUnitario.setBounds(710, 120, 130, 30);

        jTextField_IVTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVTotal);
        jTextField_IVTotal.setBounds(530, 180, 150, 30);

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("COMPRAS:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(230, 220, 150, 18);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SUBTOTAL:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 120, 150, 18);

        jTextField_IVCod_Venda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVCod_Venda);
        jTextField_IVCod_Venda.setBounds(710, 180, 130, 30);

        jLabelSobreporAlterar1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporAlterar1.setText("Alterar");
        getContentPane().add(jLabelSobreporAlterar1);
        jLabelSobreporAlterar1.setBounds(630, 490, 80, 30);

        jTFData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDataActionPerformed(evt);
            }
        });
        getContentPane().add(jTFData);
        jTFData.setBounds(30, 80, 160, 30);

        jTextField_IVCod_estoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_IVCod_estoque);
        jTextField_IVCod_estoque.setBounds(870, 180, 150, 30);

        jLabelSobreporExcluir1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporExcluir1.setText("Excluir");
        getContentPane().add(jLabelSobreporExcluir1);
        jLabelSobreporExcluir1.setBounds(250, 490, 60, 30);

        jTFNF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNFActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNF);
        jTFNF.setBounds(200, 80, 290, 30);

        jButton_alterarIV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar2.png"))); // NOI18N
        jButton_alterarIV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_alterarIV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarIVActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_alterarIV);
        jButton_alterarIV.setBounds(580, 480, 118, 51);

        jTFSubtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSubtotalActionPerformed(evt);
            }
        });
        getContentPane().add(jTFSubtotal);
        jTFSubtotal.setBounds(170, 140, 180, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2_1.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(750, 480, 118, 51);

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
        jLabel2.setBounds(360, 120, 150, 18);

        jTextFieldTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldTotal);
        jTextFieldTotal.setBounds(360, 140, 130, 30);

        jTable_iv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ITEMVENDA", "VALOR UNITARIO", "QUANTIDADE", "TOTAL", "ID VENDA", "ID ESTOQUE"
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
            jTable_iv.getColumnModel().getColumn(0).setMinWidth(70);
            jTable_iv.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable_iv.getColumnModel().getColumn(4).setMinWidth(70);
            jTable_iv.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable_iv.getColumnModel().getColumn(5).setMinWidth(70);
            jTable_iv.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(520, 240, 500, 230);

        jTableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATA_VENDA", "NF", "SUBTOTAL", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCompras);
        if (jTableCompras.getColumnModel().getColumnCount() > 0) {
            jTableCompras.getColumnModel().getColumn(0).setMinWidth(40);
            jTableCompras.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableCompras.getColumnModel().getColumn(1).setMinWidth(80);
            jTableCompras.getColumnModel().getColumn(1).setMaxWidth(7080);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 240, 460, 230);

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar2.png"))); // NOI18N
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar);
        jButtonAlterar.setBounds(70, 480, 118, 51);

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2_1.png"))); // NOI18N
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
        jLabel3.setText("DATA COMPRA:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 150, 18);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 480, 118, 51);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NF:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 60, 160, 18);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CÓDIGO COMPRA:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 120, 150, 18);

        jTextField_CompracodCompra.setEditable(false);
        jTextField_CompracodCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_CompracodCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CompracodCompraActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_CompracodCompra);
        jTextField_CompracodCompra.setBounds(30, 140, 130, 30);

        jPanel1.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel14.setText("GERENCIAR COMPRAS");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(430, 20, 299, 26);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, -10, 1340, 60);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/49239.jpg"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(-530, -140, 1920, 760);

        setSize(new java.awt.Dimension(1090, 599));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDataActionPerformed

    private void jTFNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNFActionPerformed

    private void jButton_alterarIVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarIVActionPerformed

        if(jTable_iv.getSelectedRow() != -1){

            ItemCompra iv = new ItemCompra();
            ItemCompraDao dao = new ItemCompraDao();

            iv.setValorunitario(Double.parseDouble(jTextField_IVValorUnitario.getText()));
            iv.setQuantidade(Integer.parseInt(jTextField_IVQuant.getText()));
            iv.setTotal(Double.parseDouble(jTextField_IVTotal.getText()));
            iv.setCod_compra(Integer.parseInt(jTextField_IVCod_Venda.getText()));
            iv.setCod_estoque(Integer.parseInt(jTextField_IVCod_estoque.getText()));

            iv.setCod_itemcompra((int) jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 0));

            dao.update(iv);

            limparCampos();
            readJTableForDesc(jTextField_CompracodCompra.getText());

        }
    }//GEN-LAST:event_jButton_alterarIVActionPerformed

    private void jTFSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFSubtotalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if(jTable_iv.getSelectedRow() != -1){

            ItemCompra iv = new ItemCompra();
            ItemCompraDao dao = new ItemCompraDao();

            iv.setCod_itemcompra((int) jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 0));
            dao.delete(iv);
            limparCampos();

            readJTableForDesc(jTextField_CompracodCompra.getText());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        readJTableForDescCompra(jTextField_buscar.getText());

    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jTable_ivMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ivMouseClicked

        if(jTable_iv.getSelectedRow() != -1){

            jTextField_codItemVenda.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 0).toString());
            jTextField_IVValorUnitario.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 1).toString());
            jTextField_IVQuant.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 2).toString());
            jTextField_IVTotal.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 3).toString());
            jTextField_IVCod_Venda.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 4).toString());
            jTextField_IVCod_estoque.setText(jTable_iv.getValueAt(jTable_iv.getSelectedRow(), 5).toString());

        }
    }//GEN-LAST:event_jTable_ivMouseClicked

    private void jTableComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableComprasMouseClicked

        if(jTableCompras.getSelectedRow() != -1){

            jTFData.setText(jTableCompras.getValueAt(jTableCompras.getSelectedRow(), 1).toString());
            jTFNF.setText(jTableCompras.getValueAt(jTableCompras.getSelectedRow(), 2).toString());
            jTFSubtotal.setText(jTableCompras.getValueAt(jTableCompras.getSelectedRow(), 3).toString());
            jTextFieldTotal.setText(jTableCompras.getValueAt(jTableCompras.getSelectedRow(), 4).toString());
            jTextField_CompracodCompra.setText(jTableCompras.getValueAt(jTableCompras.getSelectedRow(), 0).toString());

            readJTableForDesc(jTextField_CompracodCompra.getText());
        }

    }//GEN-LAST:event_jTableComprasMouseClicked

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        if(jTableCompras.getSelectedRow() != -1){

            Compra c = new Compra();
            CompraDao dao = new CompraDao();

            c.setNumeroNF(jTFNF.getText());
            c.setSubtotal(Double.parseDouble(jTFSubtotal.getText()));
            c.setTotal(Double.parseDouble(jTextFieldTotal.getText()));
            c.setData_compra(jTFData.getText());

            c.setCod_compra((int) jTableCompras.getValueAt(jTableCompras.getSelectedRow(), 0));

            dao.update(c);

            limparCampos();

            readJTable();

        }

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        if(jTableCompras.getSelectedRow() != -1){

            Compra c = new Compra();
            CompraDao dao = new CompraDao();

            c.setCod_compra((int) jTableCompras.getValueAt(jTableCompras.getSelectedRow(), 0));
            dao.delete(c);
            limparCampos();

            readJTable();

        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable_iv.getModel();
        modelo.setRowCount(0);

        limparCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_CompracodCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CompracodCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CompracodCompraActionPerformed

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
            java.util.logging.Logger.getLogger(JPAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPAlterarExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPAlterarExcluir().setVisible(true);
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
    private javax.swing.JTable jTableCompras;
    private javax.swing.JTable jTable_iv;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextField_CompracodCompra;
    private javax.swing.JTextField jTextField_IVCod_Venda;
    private javax.swing.JTextField jTextField_IVCod_estoque;
    private javax.swing.JTextField jTextField_IVQuant;
    private javax.swing.JTextField jTextField_IVTotal;
    private javax.swing.JTextField jTextField_IVValorUnitario;
    private javax.swing.JTextField jTextField_buscar;
    private javax.swing.JTextField jTextField_codItemVenda;
    // End of variables declaration//GEN-END:variables
}
