package GerenciarVendas;



import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.ItemVenda;
import model.bean.Venda;
import model.dao.ItemVendaDao;
import model.dao.ProdutoDao;
import model.dao.VendaDao;
import biblioteca.*;
import java.security.GeneralSecurityException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class RealizarVenda extends javax.swing.JFrame {

    /**
     * Creates new form JFVenda
     */
    public RealizarVenda() throws IOException {
        initComponents();

        readJTable(); // le tabela estoque
        gerarNF(); // gera nf automatica
        setResizable(false); // nao deixa maximizar

        traduzirElementos();
        detectarEAplicarTimeZone();

    }
    
        public void traduzirElementos(){
        try {

            traduzirElementos traduzir = new traduzirElementos();
            String language;

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Project_market\\language.txt"));
            language = reader.readLine();
            reader.close();

            jLabel16.setText(traduzir.TraduzirDados(language, jLabel16.getText()));
            jLabel11.setText(traduzir.TraduzirDados(language, jLabel11.getText()));
            jLabel14.setText(traduzir.TraduzirDados(language, jLabel14.getText()));
            jLabel6.setText(traduzir.TraduzirDados(language, jLabel6.getText()));
            jLabel4.setText(traduzir.TraduzirDados(language, jLabel4.getText()));
            jLabel5.setText(traduzir.TraduzirDados(language, jLabel5.getText()));
            jLabel2.setText(traduzir.TraduzirDados(language, jLabel2.getText()));
            jLabel9.setText(traduzir.TraduzirDados(language, jLabel9.getText()));
            jLabel12.setText(traduzir.TraduzirDados(language, jLabel12.getText()));
            jLabel14.setText(traduzir.TraduzirDados(language, jLabel14.getText()));
            
            jLabelSobreporExcluir.setText(traduzir.TraduzirDados(language, jLabelSobreporExcluir.getText()));
            jLabelSobreporAlterar.setText(traduzir.TraduzirDados(language, jLabelSobreporAlterar.getText()));

            jTable_estoque.getColumnModel().getColumn(1).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(1).getHeaderValue()));

            jTable_estoque.getColumnModel().getColumn(2).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(2).getHeaderValue()));

           jTable_estoque.getColumnModel().getColumn(3).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_estoque.getColumnModel().getColumn(3).getHeaderValue()));

            jTable_selecionados.getColumnModel().getColumn(1).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(1).getHeaderValue()));

            jTable_selecionados.getColumnModel().getColumn(1).setHeaderValue(
                   traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(1).getHeaderValue()));

            jTable_selecionados.getColumnModel().getColumn(2).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(2).getHeaderValue()));
  
            jTable_selecionados.getColumnModel().getColumn(3).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(3).getHeaderValue()));
  
            jTable_selecionados.getColumnModel().getColumn(4).setHeaderValue(
                    traduzir.TraduzirDados(language, (String) jTable_selecionados.getColumnModel().getColumn(4).getHeaderValue()));
            
        } catch (GeneralSecurityException | IOException ex) {
            System.out.println("Erro");
        }
    }
    
    public void detectarEAplicarTimeZone() throws FileNotFoundException, IOException {
        File file = new File("C:\\Project_market\\language.txt");
        String zonaDoArquivo = "";
        
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            boolean first = true;
            while (line != null) {
                if (first) {
                    first = false;
                } else {
                    line = br.readLine();
                    line = br.readLine();
                    zonaDoArquivo = line;
                    break;
                }
            }
        }

        converterDataEHora horaData = new converterDataEHora();
        jTextField_data.setText(horaData.converter(zonaDoArquivo));

    }

    public void detectCurrency() throws FileNotFoundException, IOException{
        String moeda;
        
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Project_market\\language.txt"));
        reader.readLine(); // consume first line and ignore
        moeda = reader.readLine();

    }
    
    public void gerarNF() {  // gera um nf aleatoria
        Random random = new Random();
        String letras = "0123456789";

        String armazenaChaves = "";
        int index = -1;
        for (int i = 0; i < 30; i++) {
            index = random.nextInt(letras.length());
            armazenaChaves += letras.substring(index, index + 1);

        }
        jTextField_nf.setText(armazenaChaves);
    }

    public void readJTable() {  // le tabela
        DefaultTableModel modelo = (DefaultTableModel) jTable_estoque.getModel();
        modelo.setNumRows(0);

        ProdutoDao pdao = new ProdutoDao();

        pdao.read().forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getCod_estoque(),
                p.getNome(),
                p.getQuantidade(),
                p.getValorUnitario(),});
        });
    }

    public void readJTableForDesc(String desc) { // le tabela para o buscar
        DefaultTableModel modelo = (DefaultTableModel) jTable_estoque.getModel();
        modelo.setNumRows(0);

        ProdutoDao pdao = new ProdutoDao();

        pdao.readForDesc(desc).forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getCod_estoque(),
                p.getNome(),
                p.getQuantidade(),
                p.getValorUnitario(),});
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

        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_estoque = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_selecionados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_total = new javax.swing.JTextField();
        jTextField_recebido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField_troco = new javax.swing.JTextField();
        jButton_finalizar = new javax.swing.JButton();
        jTextField_qnt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabelSobreporExcluir = new javax.swing.JLabel();
        jLabelSobreporAlterar = new javax.swing.JLabel();
        jButton_adicionar = new javax.swing.JButton();
        jButton_elimina = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField_data = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton_buscar = new javax.swing.JButton();
        jTextField_busca = new javax.swing.JTextField();
        jTextField_valorProduto = new javax.swing.JTextField();
        jTextField_nf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField_cod = new javax.swing.JTextField();
        jTextField_quantidade = new javax.swing.JTextField();
        jTextField_nome = new javax.swing.JTextField();
        jTextFieldValorUnitario = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Venda");
        getContentPane().setLayout(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("REALIZAR VENDA");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(780, 520, 280, 50);

        jTable_estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Valor Unitario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            jTable_estoque.getColumnModel().getColumn(0).setMinWidth(40);
            jTable_estoque.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 381, 300);

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
        });
        jScrollPane2.setViewportView(jTable_selecionados);
        if (jTable_selecionados.getColumnModel().getColumnCount() > 0) {
            jTable_selecionados.getColumnModel().getColumn(0).setMinWidth(40);
            jTable_selecionados.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(540, 190, 382, 300);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(550, 500, 150, 18);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bompreco.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(830, 80, 120, 60);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minimercado.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(700, 50, 150, 60);

        jTextField_total.setEditable(false);
        jTextField_total.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        getContentPane().add(jTextField_total);
        jTextField_total.setBounds(550, 520, 129, 54);

        jTextField_recebido.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_recebido.setText("0");
        jTextField_recebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_recebidoActionPerformed(evt);
            }
        });
        jTextField_recebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_recebidoKeyReleased(evt);
            }
        });
        getContentPane().add(jTextField_recebido);
        jTextField_recebido.setBounds(200, 520, 128, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VALOR RECEBIDO:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 500, 130, 18);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TROCO:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 500, 49, 18);

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ESTOQUE:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 130, 100, 18);

        jTextField_troco.setEditable(false);
        jTextField_troco.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_troco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_trocoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_troco);
        jTextField_troco.setBounds(350, 520, 119, 30);

        jButton_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/finalizarVENDA_1.png"))); // NOI18N
        jButton_finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_finalizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_finalizar);
        jButton_finalizar.setBounds(710, 520, 210, 54);

        jTextField_qnt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_qnt.setText("1");
        getContentPane().add(jTextField_qnt);
        jTextField_qnt.setBounds(410, 210, 120, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("QUANTIDADE:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 190, 100, 18);

        jLabelSobreporExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporExcluir.setText("Excluir");
        getContentPane().add(jLabelSobreporExcluir);
        jLabelSobreporExcluir.setBounds(460, 450, 60, 30);

        jLabelSobreporAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSobreporAlterar.setText("Adicionar");
        getContentPane().add(jLabelSobreporAlterar);
        jLabelSobreporAlterar.setBounds(460, 380, 80, 50);

        jButton_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar.png"))); // NOI18N
        jButton_adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_adicionarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_adicionar);
        jButton_adicionar.setBounds(410, 380, 118, 51);

        jButton_elimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2.png"))); // NOI18N
        jButton_elimina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_elimina);
        jButton_elimina.setBounds(410, 440, 118, 51);

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 60, 110, 18);

        jTextField_data.setEditable(false);
        jTextField_data.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_dataActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_data);
        jTextField_data.setBounds(20, 80, 160, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PRODUTOS SELECIONADOS:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(630, 160, 190, 20);

        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        jButton_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscar);
        jButton_buscar.setBounds(270, 150, 100, 30);

        jTextField_busca.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        getContentPane().add(jTextField_busca);
        jTextField_busca.setBounds(20, 150, 230, 30);

        jTextField_valorProduto.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField_valorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_valorProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_valorProduto);
        jTextField_valorProduto.setBounds(410, 270, 120, 30);

        jTextField_nf.setEditable(false);
        jTextField_nf.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        getContentPane().add(jTextField_nf);
        jTextField_nf.setBounds(210, 80, 280, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(410, 250, 60, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DATA:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 60, 100, 18);

        jPanel1.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel12.setText("REALIZAR VENDA");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(420, 50, 299, 26);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, -40, 1120, 90);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/49239.jpg"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(-400, 20, 1560, 730);

        jTextField_cod.setEditable(false);
        getContentPane().add(jTextField_cod);
        jTextField_cod.setBounds(490, 60, 20, 20);

        jTextField_quantidade.setEditable(false);
        getContentPane().add(jTextField_quantidade);
        jTextField_quantidade.setBounds(490, 120, 20, 20);

        jTextField_nome.setEditable(false);
        jTextField_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_nome);
        jTextField_nome.setBounds(490, 90, 20, 20);

        jTextFieldValorUnitario.setEditable(false);
        getContentPane().add(jTextFieldValorUnitario);
        jTextFieldValorUnitario.setBounds(490, 150, 20, 20);

        jCheckBox1.setText("jCheckBox1");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(260, 600, 81, 23);

        setSize(new java.awt.Dimension(994, 642));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_recebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_recebidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_recebidoActionPerformed

    private void jTextField_trocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_trocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_trocoActionPerformed

    public void limparCampos() {
        DefaultTableModel modelo = (DefaultTableModel) jTable_selecionados.getModel();     // limpar todo os campos apos uma venda

        jTextField_recebido.setText("0");
        jTextField_troco.setText("");
        jTextField_total.setText("");

        jTextField_qnt.setText("1");
        jTextField_valorProduto.setText("");
        modelo.setRowCount(0);
    }

    private void jButton_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_finalizarActionPerformed

        Random random = new Random();
        int numero = random.nextInt(1000);              // Gera um numero aleatorio

        Venda v = new Venda();
        VendaDao dao = new VendaDao();

        ItemVenda iv = new ItemVenda();
        ItemVendaDao idao = new ItemVendaDao();
        // venda
        v.setCod_venda(numero);                       // O numero aleatorio é utilizado no cod_venda
        v.setNumeroNF(jTextField_nf.getText());
        v.setSubtotal(Double.parseDouble(jTextField_troco.getText()));
        v.setTotal(Double.parseDouble(jTextField_total.getText()));
        v.setData_venda("2019-06-01");

        dao.create(v);

        // item venda    
        try {

            int rows = jTable_selecionados.getRowCount();

            for (int row = 0; row < rows; row++) {

                String cod_produto = (String) jTable_selecionados.getValueAt(row, 0);
                String nome = (String) jTable_selecionados.getValueAt(row, 1);
                String valor = (String) jTable_selecionados.getValueAt(row, 2);
                String qnt = (String) jTable_selecionados.getValueAt(row, 3);
                String valortotal = (String) jTable_selecionados.getValueAt(row, 4);

                iv.setValorunitario(Double.parseDouble(valor));
                iv.setQuantidade(Integer.parseInt(qnt));

                iv.setTotal(Double.parseDouble(valortotal));
                iv.setCod_venda(numero);
                iv.setCod_estoque(Integer.parseInt(cod_produto));

                idao.create(iv);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }

        limparCampos();
        gerarNF();
        readJTable();
    }//GEN-LAST:event_jButton_finalizarActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        readJTableForDesc(jTextField_busca.getText());
    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jButton_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_adicionarActionPerformed
        double z = 0, h = 0, totale = 0;
        int u = 0;

        if (jTable_estoque.getSelectedRow() != -1) {

            DefaultTableModel modelo = (DefaultTableModel) jTable_selecionados.getModel();

            int selectedRowIndex = jTable_estoque.getSelectedRow();

            u = Integer.parseInt(jTextField_qnt.getText());
            h = Double.parseDouble(jTable_estoque.getValueAt(selectedRowIndex, 3).toString());
            totale = (u * h);

            double totale2 = (double) Math.round(totale * 100) / 100;
            jTextField_valorProduto.setText(totale2 + "");           // Coloca valor total item

            modelo.addRow(new Object[]{jTextField_cod.getText(), jTextField_nome.getText(), jTextFieldValorUnitario.getText(), jTextField_qnt.getText(), jTextField_valorProduto.getText()});

            for (int y = 0; y < jTable_selecionados.getRowCount(); y++) {                    // coloca a quantidade escolhida na table2
                z += Double.parseDouble(jTable_selecionados.getValueAt(y, 4).toString());
            }

            jTextField_total.setText(z + "");
            AtualizarTroco();

        }

    }//GEN-LAST:event_jButton_adicionarActionPerformed

    private void jTable_estoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_estoqueMouseClicked
        if (jTable_estoque.getSelectedRow() != -1) {

            jTextField_cod.setText(jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 0).toString());
            jTextField_nome.setText(jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 1).toString());
            jTextField_quantidade.setText(jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 2).toString());
            jTextFieldValorUnitario.setText(jTable_estoque.getValueAt(jTable_estoque.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_jTable_estoqueMouseClicked

    private void jTable_selecionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_selecionadosMouseClicked

    }//GEN-LAST:event_jTable_selecionadosMouseClicked

    private void jButton_eliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminaActionPerformed
        double z = 0;

        if (jTable_selecionados.getSelectedRow() != -1) {

            DefaultTableModel modelo = (DefaultTableModel) jTable_selecionados.getModel();

            try {
                int SelectedRowIndex = jTable_selecionados.getSelectedRow();
                modelo.removeRow(SelectedRowIndex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

            for (int y = 0; y < jTable_selecionados.getRowCount(); y++) {
                z += Double.parseDouble(jTable_selecionados.getValueAt(y, 4).toString());
            }

            jTextField_total.setText(z + "");
            AtualizarTroco();

        }

    }//GEN-LAST:event_jButton_eliminaActionPerformed

    public void AtualizarTroco() {
        double troco = 0;

        troco = (Double.parseDouble(jTextField_recebido.getText()) - Double.parseDouble(jTextField_total.getText()));
        double totale2 = (double) Math.round(troco * 100) / 100;
        jTextField_troco.setText(totale2 + "");

    }

    private void jTextField_recebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_recebidoKeyReleased

        AtualizarTroco();

    }//GEN-LAST:event_jTextField_recebidoKeyReleased

    private void jTextField_valorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_valorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_valorProdutoActionPerformed

    private void jTextField_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_dataActionPerformed

    private void jTextField_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nomeActionPerformed

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
            java.util.logging.Logger.getLogger(RealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RealizarVenda().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(RealizarVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_adicionar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_elimina;
    private javax.swing.JButton jButton_finalizar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSobreporAlterar;
    private javax.swing.JLabel jLabelSobreporExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_estoque;
    private javax.swing.JTable jTable_selecionados;
    private javax.swing.JTextField jTextFieldValorUnitario;
    private javax.swing.JTextField jTextField_busca;
    private javax.swing.JTextField jTextField_cod;
    private javax.swing.JTextField jTextField_data;
    private javax.swing.JTextField jTextField_nf;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_qnt;
    private javax.swing.JTextField jTextField_quantidade;
    private javax.swing.JTextField jTextField_recebido;
    private javax.swing.JTextField jTextField_total;
    private javax.swing.JTextField jTextField_troco;
    private javax.swing.JTextField jTextField_valorProduto;
    // End of variables declaration//GEN-END:variables
}
