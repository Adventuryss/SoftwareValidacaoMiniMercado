import GerenciarVendas.RealizarVenda;
import GerenciarCompra.JFGerenciarCompra;
import GerenciarCompra.JPAlterarExcluir;
import GerenciarVendas.JPanelAlterarExcluir;
import biblioteca.*;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import biblioteca.traduzirElementos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.MoedaDao;
import model.dao.ProdutoDao;

public class FramePrincipal extends javax.swing.JFrame {

    public FramePrincipal() throws IOException, GeneralSecurityException {
        initComponents();
        SetIcon();
        setResizable(false);
        jInternalFrame2.setVisible(false);
        
        detectLanguage();    //Detecta a lingua da maquina e salva em um txt, isto, caso não exista o arquivo.
        traduzirElementos();
        
               
    }

    public void detectLanguage() throws GeneralSecurityException, IOException{
        Locale locale = Locale.getDefault();
        String language = locale.getDisplayLanguage();
        traduzirElementos traduzir = new traduzirElementos();  
        
        if("português".equals(language)){     
            language = "pt";
        } else if("english".equals(language)){
            language = "en";
        } else if("español".equals(language)){
            language = "es";
        } else {
            language = "it";    
        }

        File myObj = new File("C:\\Project_market\\language.txt");
        if (myObj.createNewFile()) {
            FileWriter myWriter = new FileWriter("C:\\Project_market\\language.txt");
            myWriter.write(language);
            myWriter.close();
        }

        jLabel_currencySelection.setText(traduzir.TraduzirDados(language, jLabel_currencySelection.getText()));
    }
    
    public void traduzirElementos () throws IOException, GeneralSecurityException{
        traduzirElementos traduzir = new traduzirElementos();
        String language;

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Project_market\\language.txt"));
        language = reader.readLine();
        reader.close();
        
        if(!"pt".equals(language)){
        jLabel_languageSelection1.setText(traduzir.TraduzirDados(language, jLabel_languageSelection1.getText()));
        jLabel_currencySelection.setText(traduzir.TraduzirDados(language, jLabel_currencySelection.getText()));    // Frame Internacionalizacao
        jLabel_measureSelection.setText(traduzir.TraduzirDados(language, jLabel_measureSelection.getText()));
        
        jLabel_currencySelection.setText(traduzir.TraduzirDados(language, jLabel_currencySelection.getText()));
        jLabel_titulo.setText(traduzir.TraduzirDados(language, jLabel_titulo.getText()));
        jLabel_gerenciarEstoque.setText(traduzir.TraduzirDados(language, jLabel_gerenciarEstoque.getText()));
        jLabel_gerenciarCompra.setText(traduzir.TraduzirDados(language, jLabel_gerenciarCompra.getText())); // Menus
        jLabel_gerenciarVenda.setText(traduzir.TraduzirDados(language, jLabel_gerenciarVenda.getText()));
        jLabel_relatorio.setText(traduzir.TraduzirDados(language, jLabel_relatorio.getText()));
        jLabel_realizarVenda.setText(traduzir.TraduzirDados(language, jLabel_realizarVenda.getText()));
        jLabel_realizarCompra.setText(traduzir.TraduzirDados(language, jLabel_realizarCompra.getText()));

        jMenuItem_GerEstoque.setText(traduzir.TraduzirDados(language, jMenuItem_GerEstoque.getText()));
        jMenuItem_GerCompr.setText(traduzir.TraduzirDados(language, jMenuItem_GerCompr.getText()));
        jMenuItem_GerVenda.setText(traduzir.TraduzirDados(language, jMenuItem_GerVenda.getText()));
        jMenuItem_realVenda.setText(traduzir.TraduzirDados(language, jMenuItem_realVenda.getText()));
        jMenuItem_realCompra.setText(traduzir.TraduzirDados(language, jMenuItem_realCompra.getText()));   // Botoes
        jMenu_Gerenciar.setText(traduzir.TraduzirDados(language, jMenu_Gerenciar.getText()));
        jMenu_Insercoes.setText(traduzir.TraduzirDados(language, jMenu_Insercoes.getText()));
        jMenu_relatorio.setText(traduzir.TraduzirDados(language, jMenu_relatorio.getText()));
        jMenu_ferramentas.setText(traduzir.TraduzirDados(language, jMenu_ferramentas.getText()));
        jMenuItem_telaInicial.setText(traduzir.TraduzirDados(language, jMenuItem_telaInicial.getText()));
        jMenuItem_internacionalizacao.setText(traduzir.TraduzirDados(language, jMenuItem_internacionalizacao.getText()));
        }

    }

    private void SetIcon() {       // Função para inserir um ícone
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/cart (6).png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel_img2 = new javax.swing.JLabel();
        jLabel_img1 = new javax.swing.JLabel();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_gerenciarVenda = new javax.swing.JLabel();
        jLabel_gerenciarCompra = new javax.swing.JLabel();
        jLabel_gerenciarEstoque = new javax.swing.JLabel();
        jLabel_relatorio = new javax.swing.JLabel();
        jLabel_realizarVenda = new javax.swing.JLabel();
        jLabel_realizarCompra = new javax.swing.JLabel();
        jButtonGerenciaEstoque = new javax.swing.JButton();
        jButtonGerenciaCompra = new javax.swing.JButton();
        jButtonGerenciaVenda = new javax.swing.JButton();
        jButtonRealizaVenda = new javax.swing.JButton();
        jButtonRealizaCompra = new javax.swing.JButton();
        jButtonRelatorio = new javax.swing.JButton();
        jLabel_fundo = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jComboBox_Language = new javax.swing.JComboBox();
        jComboBox_Measure = new javax.swing.JComboBox();
        jButton_language = new javax.swing.JButton();
        jLabel_measureSelection = new javax.swing.JLabel();
        jLabel_languageSelection1 = new javax.swing.JLabel();
        jLabel_currencySelection = new javax.swing.JLabel();
        jComboBox_Currency = new javax.swing.JComboBox();
        jLabel_fundo1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Gerenciar = new javax.swing.JMenu();
        jMenuItem_GerEstoque = new javax.swing.JMenuItem();
        jMenuItem_GerCompr = new javax.swing.JMenuItem();
        jMenuItem_GerVenda = new javax.swing.JMenuItem();
        jMenu_Insercoes = new javax.swing.JMenu();
        jMenuItem_realVenda = new javax.swing.JMenuItem();
        jMenuItem_realCompra = new javax.swing.JMenuItem();
        jMenu_relatorio = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu_ferramentas = new javax.swing.JMenu();
        jMenuItem_telaInicial = new javax.swing.JMenuItem();
        jMenuItem_internacionalizacao = new javax.swing.JMenuItem();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setMaximumSize(new java.awt.Dimension(1100000, 230000));
        jInternalFrame1.setVisible(true);
        jInternalFrame1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jInternalFrame1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jInternalFrame1.getContentPane().setLayout(null);

        jLabel_img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bompreco.png"))); // NOI18N
        jInternalFrame1.getContentPane().add(jLabel_img2);
        jLabel_img2.setBounds(150, 340, 120, 60);

        jLabel_img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minimercado.png"))); // NOI18N
        jInternalFrame1.getContentPane().add(jLabel_img1);
        jLabel_img1.setBounds(20, 310, 150, 60);

        jLabel_titulo.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("GERENCIAMENTO:");
        jInternalFrame1.getContentPane().add(jLabel_titulo);
        jLabel_titulo.setBounds(20, 20, 263, 22);

        jLabel_gerenciarVenda.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gerenciarVenda.setText("GERENCIAR VENDAS");
        jInternalFrame1.getContentPane().add(jLabel_gerenciarVenda);
        jLabel_gerenciarVenda.setBounds(400, 166, 160, 20);

        jLabel_gerenciarCompra.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gerenciarCompra.setText("GERENCIAR COMPRAS");
        jInternalFrame1.getContentPane().add(jLabel_gerenciarCompra);
        jLabel_gerenciarCompra.setBounds(230, 160, 150, 30);

        jLabel_gerenciarEstoque.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gerenciarEstoque.setText("GERENCIAR ESTOQUE");
        jInternalFrame1.getContentPane().add(jLabel_gerenciarEstoque);
        jLabel_gerenciarEstoque.setBounds(60, 160, 180, 30);

        jLabel_relatorio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_relatorio.setText("RELATÓRIOS");
        jInternalFrame1.getContentPane().add(jLabel_relatorio);
        jLabel_relatorio.setBounds(60, 290, 130, 14);

        jLabel_realizarVenda.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_realizarVenda.setText("REALIZAR VENDA");
        jInternalFrame1.getContentPane().add(jLabel_realizarVenda);
        jLabel_realizarVenda.setBounds(230, 290, 150, 14);

        jLabel_realizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_realizarCompra.setText("REALIZAR COMPRA");
        jInternalFrame1.getContentPane().add(jLabel_realizarCompra);
        jLabel_realizarCompra.setBounds(400, 290, 180, 14);

        jButtonGerenciaEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao1.png"))); // NOI18N
        jButtonGerenciaEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerenciaEstoque.setMaximumSize(new java.awt.Dimension(117, 23));
        jButtonGerenciaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciaEstoqueActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButtonGerenciaEstoque);
        jButtonGerenciaEstoque.setBounds(50, 99, 150, 90);

        jButtonGerenciaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao3.png"))); // NOI18N
        jButtonGerenciaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerenciaCompra.setMaximumSize(new java.awt.Dimension(117, 23));
        jButtonGerenciaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciaCompraActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButtonGerenciaCompra);
        jButtonGerenciaCompra.setBounds(220, 99, 150, 90);

        jButtonGerenciaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao2.png"))); // NOI18N
        jButtonGerenciaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerenciaVenda.setMaximumSize(new java.awt.Dimension(117, 23));
        jButtonGerenciaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciaVendaActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButtonGerenciaVenda);
        jButtonGerenciaVenda.setBounds(390, 100, 150, 90);

        jButtonRealizaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao5.png"))); // NOI18N
        jButtonRealizaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRealizaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizaVendaActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButtonRealizaVenda);
        jButtonRealizaVenda.setBounds(220, 220, 150, 90);

        jButtonRealizaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao6.png"))); // NOI18N
        jButtonRealizaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRealizaCompra.setMaximumSize(new java.awt.Dimension(117, 23));
        jButtonRealizaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizaCompraActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButtonRealizaCompra);
        jButtonRealizaCompra.setBounds(390, 220, 150, 90);

        jButtonRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao4.png"))); // NOI18N
        jButtonRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButtonRelatorio);
        jButtonRelatorio.setBounds(50, 220, 150, 90);

        jLabel_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundblue.jpg"))); // NOI18N
        jInternalFrame1.getContentPane().add(jLabel_fundo);
        jLabel_fundo.setBounds(0, -20, 626, 440);

        jInternalFrame2.setClosable(true);
        jInternalFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame2.setVisible(true);
        jInternalFrame2.getContentPane().setLayout(null);

        jComboBox_Language.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Português", "English", "Italiano", "Español" }));
        jInternalFrame2.getContentPane().add(jComboBox_Language);
        jComboBox_Language.setBounds(20, 40, 130, 30);

        jComboBox_Measure.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Metrico", "Imperial" }));
        jInternalFrame2.getContentPane().add(jComboBox_Measure);
        jComboBox_Measure.setBounds(20, 160, 130, 30);

        jButton_language.setText("OK");
        jButton_language.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_languageActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jButton_language);
        jButton_language.setBounds(190, 160, 50, 30);

        jLabel_measureSelection.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel_measureSelection.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_measureSelection.setText("SISTEMA DE MEDIDAS:");
        jInternalFrame2.getContentPane().add(jLabel_measureSelection);
        jLabel_measureSelection.setBounds(20, 140, 240, 19);

        jLabel_languageSelection1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel_languageSelection1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_languageSelection1.setText("SELECIONE A LÍNGUA:");
        jInternalFrame2.getContentPane().add(jLabel_languageSelection1);
        jLabel_languageSelection1.setBounds(20, 20, 230, 19);

        jLabel_currencySelection.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel_currencySelection.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_currencySelection.setText("SELECIONE A MOEDA:");
        jInternalFrame2.getContentPane().add(jLabel_currencySelection);
        jLabel_currencySelection.setBounds(20, 80, 230, 19);

        jComboBox_Currency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BRL", "USD", "EUR" }));
        jInternalFrame2.getContentPane().add(jComboBox_Currency);
        jComboBox_Currency.setBounds(20, 100, 130, 30);

        jLabel_fundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundblue.jpg"))); // NOI18N
        jInternalFrame2.getContentPane().add(jLabel_fundo1);
        jLabel_fundo1.setBounds(-190, -150, 626, 440);

        jMenu_Gerenciar.setText("Gerencia");

        jMenuItem_GerEstoque.setText("Gerenciar Estoque");
        jMenuItem_GerEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GerEstoqueActionPerformed(evt);
            }
        });
        jMenu_Gerenciar.add(jMenuItem_GerEstoque);

        jMenuItem_GerCompr.setText("Gerenciar Compra");
        jMenuItem_GerCompr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GerComprActionPerformed(evt);
            }
        });
        jMenu_Gerenciar.add(jMenuItem_GerCompr);

        jMenuItem_GerVenda.setText("Gerenciar Venda");
        jMenuItem_GerVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GerVendaActionPerformed(evt);
            }
        });
        jMenu_Gerenciar.add(jMenuItem_GerVenda);

        jMenuBar1.add(jMenu_Gerenciar);

        jMenu_Insercoes.setText("Inserções");

        jMenuItem_realVenda.setText("Realizar Venda");
        jMenuItem_realVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_realVendaActionPerformed(evt);
            }
        });
        jMenu_Insercoes.add(jMenuItem_realVenda);

        jMenuItem_realCompra.setText("Realizar Compra");
        jMenuItem_realCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_realCompraActionPerformed(evt);
            }
        });
        jMenu_Insercoes.add(jMenuItem_realCompra);

        jMenuBar1.add(jMenu_Insercoes);

        jMenu_relatorio.setText("Relatorios");

        jMenuItem6.setText("Relatorio Storage");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu_relatorio.add(jMenuItem6);

        jMenuBar1.add(jMenu_relatorio);

        jMenu_ferramentas.setText("Ferramentas");

        jMenuItem_telaInicial.setText("Tela Inicial");
        jMenuItem_telaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_telaInicialActionPerformed(evt);
            }
        });
        jMenu_ferramentas.add(jMenuItem_telaInicial);

        jMenuItem_internacionalizacao.setText("Internacionalização");
        jMenuItem_internacionalizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_internacionalizacaoActionPerformed(evt);
            }
        });
        jMenu_ferramentas.add(jMenuItem_internacionalizacao);

        jMenuBar1.add(jMenu_ferramentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(930, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_telaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_telaInicialActionPerformed

        jInternalFrame1.setVisible(true);   // Para aparecer o menu

    }//GEN-LAST:event_jMenuItem_telaInicialActionPerformed

    private void jInternalFrame1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jInternalFrame1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame1AncestorAdded

    private void jButtonGerenciaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciaVendaActionPerformed
        JPanelAlterarExcluir frame = new JPanelAlterarExcluir();
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonGerenciaVendaActionPerformed

    private void jButtonGerenciaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciaEstoqueActionPerformed
        GerenciaEstoque frame = new GerenciaEstoque();
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonGerenciaEstoqueActionPerformed

    private void jButtonGerenciaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciaCompraActionPerformed
        JPAlterarExcluir frame = new JPAlterarExcluir();
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonGerenciaCompraActionPerformed

    private void jMenuItem_GerEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GerEstoqueActionPerformed
        GerenciaEstoque frame = new GerenciaEstoque();
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GerEstoqueActionPerformed

    private void jButtonRealizaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizaCompraActionPerformed
        JFGerenciarCompra frame = new JFGerenciarCompra();
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonRealizaCompraActionPerformed

    private void jButtonRealizaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizaVendaActionPerformed
        try {
            RealizarVenda frame = new RealizarVenda();
            frame.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRealizaVendaActionPerformed

    private void jMenuItem_GerComprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GerComprActionPerformed
        JPAlterarExcluir frame = new JPAlterarExcluir();
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GerComprActionPerformed

    private void jMenuItem_GerVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GerVendaActionPerformed
        JPanelAlterarExcluir frame = new JPanelAlterarExcluir();
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GerVendaActionPerformed

    private void jButtonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioActionPerformed
      //  RelatorioStorage frame = new RelatorioStorage();
      //  frame.setVisible(true);
    }//GEN-LAST:event_jButtonRelatorioActionPerformed

    private void jMenuItem_realVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_realVendaActionPerformed
        try {
            RealizarVenda frame = new RealizarVenda();
            frame.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem_realVendaActionPerformed

    private void jMenuItem_realCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_realCompraActionPerformed
        JFGerenciarCompra frame = new JFGerenciarCompra();
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItem_realCompraActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    
    private void jButton_languageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_languageActionPerformed
         
        traduzirElementos traduzir = new traduzirElementos();
        MoedaDao moedaDao = new MoedaDao();
        
        String language  = "";
        String moeda = null;
        String timeZone = "";
        String message = "A língua selecionada será utilizada como padrão pelo sistema. A operação pode demorar alguns segundos.";
        String message2 = "Todos os elementos foram internacionalizados com sucesso no sistema.";
        
        conversorMoedas conversorMoeda = new conversorMoedas();
        ProdutoDao dao = new ProdutoDao();
        MoedaDao mDao = new MoedaDao();
        String valorMoeda;
        int cod = 1;

        if ("Português".equals(jComboBox_Language.getSelectedItem().toString())) {   // Armazena valores dos comboBox
            language = "PT";
            timeZone = "America/Sao_Paulo";
        } else if ("English".equals(jComboBox_Language.getSelectedItem().toString())) {
            language = "EN";
            timeZone = "America/Los_Angeles";
        } else if ("Italiano".equals(jComboBox_Language.getSelectedItem().toString())) {
            language = "IT";
            timeZone = "Europe/Paris";
        } else {
            language = "ES";
            timeZone = "Europe/Paris";
        }
        
        if ("BRL".equals(jComboBox_Currency.getSelectedItem().toString())) {    // Armazena valores dos comboBox
            moeda = "BRL";
        } else if ("USD".equals(jComboBox_Currency.getSelectedItem().toString())) {
            moeda = "USD";
        } else if ("EUR".equals(jComboBox_Currency.getSelectedItem().toString())) {
            moeda = "EUR";
        }
        

        try {
            File myObj = new File("C:\\Project_market\\language.txt");                      // Grava as informações dos comboBox
            if (myObj.createNewFile()) {

                FileWriter myWriter = new FileWriter("C:\\Project_market\\language.txt");
                myWriter.write(language);
                myWriter.write("\r\n");
                myWriter.write(moeda);
                myWriter.write("\r\n");
                myWriter.write(timeZone);

                myWriter.close();
            } else {
                FileWriter myWriter = new FileWriter("C:\\Project_market\\language.txt");
                myWriter.write(language);
                myWriter.write("\r\n");
                myWriter.write(moeda);
                myWriter.write("\r\n");
                myWriter.write(timeZone);

                myWriter.close();
            }

            JOptionPane.showMessageDialog(new JFrame(), traduzir.TraduzirDados(language, message), "Dialog", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println("An error occurred. " + evt);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {                                                                               // Traduz elementos
            traduzirElementos();
        } catch (IOException | GeneralSecurityException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        if (!mDao.BuscarValores().equals(moeda)) {
            do {
                valorMoeda = Float.toString(dao.BuscarValores(cod));

                dao.updateValor((float) conversorMoeda.converterMoeda(mDao.BuscarValores(), moeda, Double.parseDouble(valorMoeda)), cod);
          //  dao.updateValor((float)conversor.converter(mDao.BuscarValores(), moeda, Double.parseDouble(valorMoeda)), cod);
                // Moeda que está no banco                Moeda do ComboBox        Valor

                cod++;
                if ("null".equals(dao.BuscarValores(cod))) { // Teste para não deixar ele acessar valores nulos
                    break;
                }

            } while (dao.BuscarValores(cod) != null);        // idem

            moedaDao.update(moeda); // Atualiza a Moeda do Banco pro que foi selecionado no ComboBox
        }

        Float medidaBanco;

        int cod2 = 1; 

        converterQuilogramaParaLibra conversorQuilograma = new converterQuilogramaParaLibra();
        converterLitroParaGalao conversorLitro = new converterLitroParaGalao();
       
        converterLibraParaQuilograma conversorLibraParaQuilo = new converterLibraParaQuilograma();
        converterGalaoParaLitro converterGalaoParaLitro = new converterGalaoParaLitro();


        if (jComboBox_Measure.getSelectedIndex() == 0) {    // Converte as medidas.  Ex.: Litro, kg...
            do {
                if ("Gallon".equals(dao.buscarTipoMedida(cod2))) {
                    medidaBanco = dao.buscarMedida(cod2); // Guarda a medida               
                    dao.updateMedida((float) converterGalaoParaLitro.converter(medidaBanco), cod2);
                    dao.updateTipoMedida("Litro", cod2);
                }
                cod2++;
                if ("null".equals(dao.buscarMedida(cod2))) { // Teste para não deixar ele acessar valores nulos
                    break;
                }
            } while (dao.buscarMedida(cod2) != null);

            cod2 = 1; // Resetar o contador de ID

            do {
                if ("Pound".equals(dao.buscarTipoMedida(cod2))) {
                    medidaBanco = dao.buscarMedida(cod2); // Guarda a medida               
                    dao.updateMedida((float) conversorLibraParaQuilo.converter(medidaBanco), cod2);
                    dao.updateTipoMedida("Quilograma", cod2);
                }
                cod2++;
                if ("null".equals(dao.buscarMedida(cod2))) { // Teste para não deixar ele acessar valores nulos
                    break;
                }
            } while (dao.buscarMedida(cod2) != null);

        } else if (jComboBox_Measure.getSelectedIndex() == 1) {

            do {
                if ("Litro".equals(dao.buscarTipoMedida(cod2))) {

                    medidaBanco = dao.buscarMedida(cod2); // Guarda a medida               
                    dao.updateMedida((float) conversorLitro.converter(medidaBanco), cod2);
                    dao.updateTipoMedida("Gallon", cod2);
                }
                cod2++;
                if ("null".equals(dao.buscarMedida(cod2))) { // Teste para não deixar ele acessar valores nulos
                    break;
                }

            } while (dao.buscarMedida(cod2) != null);

            cod2 = 1; // Resetar o contador de ID

            do {
                if ("Quilograma".equals(dao.buscarTipoMedida(cod2))) {
                    medidaBanco = dao.buscarMedida(cod2); // Guarda a medida               
                    dao.updateMedida((float) conversorQuilograma.converter(medidaBanco), cod2);
                    dao.updateTipoMedida("Pound", cod2);
                }
                cod2++;
                if ("null".equals(dao.buscarMedida(cod2))) { // Teste para não deixar ele acessar valores nulos
                    break;
                }

            } while (dao.buscarMedida(cod2) != null);
        }
        
        try {        
            JOptionPane.showMessageDialog(new JFrame(), traduzir.TraduzirDados(language, message2), "Dialog", JOptionPane.INFORMATION_MESSAGE);
        } catch (GeneralSecurityException | IOException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton_languageActionPerformed

    private void jMenuItem_internacionalizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_internacionalizacaoActionPerformed
        jInternalFrame2.setVisible(true);
    }//GEN-LAST:event_jMenuItem_internacionalizacaoActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FramePrincipal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (GeneralSecurityException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGerenciaCompra;
    private javax.swing.JButton jButtonGerenciaEstoque;
    private javax.swing.JButton jButtonGerenciaVenda;
    private javax.swing.JButton jButtonRealizaCompra;
    private javax.swing.JButton jButtonRealizaVenda;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButton_language;
    private javax.swing.JComboBox jComboBox_Currency;
    private javax.swing.JComboBox jComboBox_Language;
    private javax.swing.JComboBox jComboBox_Measure;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel_currencySelection;
    private javax.swing.JLabel jLabel_fundo;
    private javax.swing.JLabel jLabel_fundo1;
    private javax.swing.JLabel jLabel_gerenciarCompra;
    private javax.swing.JLabel jLabel_gerenciarEstoque;
    private javax.swing.JLabel jLabel_gerenciarVenda;
    private javax.swing.JLabel jLabel_img1;
    private javax.swing.JLabel jLabel_img2;
    private javax.swing.JLabel jLabel_languageSelection1;
    private javax.swing.JLabel jLabel_measureSelection;
    private javax.swing.JLabel jLabel_realizarCompra;
    private javax.swing.JLabel jLabel_realizarVenda;
    private javax.swing.JLabel jLabel_relatorio;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem_GerCompr;
    private javax.swing.JMenuItem jMenuItem_GerEstoque;
    private javax.swing.JMenuItem jMenuItem_GerVenda;
    private javax.swing.JMenuItem jMenuItem_internacionalizacao;
    private javax.swing.JMenuItem jMenuItem_realCompra;
    private javax.swing.JMenuItem jMenuItem_realVenda;
    private javax.swing.JMenuItem jMenuItem_telaInicial;
    private javax.swing.JMenu jMenu_Gerenciar;
    private javax.swing.JMenu jMenu_Insercoes;
    private javax.swing.JMenu jMenu_ferramentas;
    private javax.swing.JMenu jMenu_relatorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
