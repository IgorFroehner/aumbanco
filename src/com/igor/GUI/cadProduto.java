package com.igor.GUI;

import com.igor.DAO.ProdutoDAO;
import com.igor.modelo.Cores;
import com.igor.modelo.Produtos;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author IgorDev e Artur
 *
 */
public class cadProduto extends javax.swing.JDialog {

    /**
     * Creates new form cadProduto
     */
    int btEditar;
    private String usua;

    public cadProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitar();
        desBotoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTcod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPnMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtLimpar = new javax.swing.JButton();
        jBtCadastrar = new javax.swing.JButton();
        jBtEditar = new javax.swing.JButton();
        jBtPesquisa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jCbUnidade = new javax.swing.JComboBox();
        jTvalor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos - Aumbanco");
        setBackground(new java.awt.Color(255, 255, 255));

        jPnFundo.setBackground(new java.awt.Color(255, 255, 255));
        jPnFundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Código do Produto:");

        jTcod.setEditable(false);
        jTcod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTcod.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Nome do Produto:");

        jTnome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Unidade de Medida:");
        jLabel8.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Valor Venda:(R$)");

        jPnMenu.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setFont(new java.awt.Font("Aharoni", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cadastro de Produto");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_1.png"))); // NOI18N
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rewind.png"))); // NOI18N
        jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLimparActionPerformed(evt);
            }
        });

        jBtCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jBtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastrarActionPerformed(evt);
            }
        });

        jBtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/note_edit.png"))); // NOI18N
        jBtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEditarActionPerformed(evt);
            }
        });

        jBtPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        jBtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jBtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back_2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnMenuLayout = new javax.swing.GroupLayout(jPnMenu);
        jPnMenu.setLayout(jPnMenuLayout);
        jPnMenuLayout.setHorizontalGroup(
            jPnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPnMenuLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnMenuLayout.setVerticalGroup(
            jPnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnMenuLayout.createSequentialGroup()
                .addGroup(jPnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jCbUnidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Unidade ", "Kilo (Kg)", "Gramas (g)", "Litros (L)", "Metros (m)", "Metros Cúbicos (m³)", "Metros Quadrados (m²)" }));

        jTvalor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jTvalor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTvalor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTvalorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPnFundoLayout = new javax.swing.GroupLayout(jPnFundo);
        jPnFundo.setLayout(jPnFundoLayout);
        jPnFundoLayout.setHorizontalGroup(
            jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPnFundoLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTcod, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPnFundoLayout.setVerticalGroup(
            jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnFundoLayout.createSequentialGroup()
                .addComponent(jPnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPnFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnFundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        limpacampos();
        habiBotoes();
        habilitar();

        Produtos modelo = new Produtos();
        ProdutoDAO dao = new ProdutoDAO();

        try {
            dao.UltimoCodigo(modelo);
        } catch (HeadlessException | ParseException ex) {
            Logger.getLogger(cadProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        int iai = modelo.getcProd() + 1;
        jTcod.setText("" + iai);
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLimparActionPerformed
        limpar();
    }//GEN-LAST:event_jBtLimparActionPerformed

    private void jBtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastrarActionPerformed
        Produtos modelo = new Produtos();
        //validação dos Campos da Tela de Cadastros
        if (jTcod.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite um código!");
            jTcod.requestFocus();

        } else if (jTnome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite um nome!");
            jTnome.requestFocus();

        } else if (jCbUnidade.getSelectedItem().toString().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Selecione uma unidade de medida!");
            jCbUnidade.requestFocus();

        } else if (jTvalor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido.");
            jTvalor.requestFocus();

        } else {

            //manda para as veriaveis no modelo
            modelo.setcProd(Integer.parseInt(jTcod.getText()));
            modelo.setNome(jTnome.getText());
            modelo.setUnidade(jCbUnidade.getSelectedItem().toString().trim());
            modelo.setValor(Double.parseDouble(jTvalor.getText().replace(",", ".").replace(".","")));
            modelo.setHoraalteracao(new SimpleDateFormat("HH:mm dd/MM/yyyy").format(new Date()));
            modelo.setUsuario(usua);

            if (btEditar == 1) {
                salvaEdicao(modelo);
            } else {

                ProdutoDAO dao = new ProdutoDAO();

                //confirmação do cadastro
                int dialogResult = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cadastrar?");
                if (dialogResult == JOptionPane.YES_OPTION) {

                    //cadastro
                    try {
                        dao.cadastra(modelo);
                    } catch (SQLException ex) {
                        Logger.getLogger(cadProduto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

                    limpar();
                }
            }
        }
    }//GEN-LAST:event_jBtCadastrarActionPerformed

    private void jBtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEditarActionPerformed
        btEditar = 1;
        habilitar();
        habiBotoes();
    }//GEN-LAST:event_jBtEditarActionPerformed

    private void jBtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaActionPerformed
        consProdutos dialog = new consProdutos(new javax.swing.JFrame(), true);
        Cores cores = new Cores();

        cores.setFundo(jPnFundo.getBackground());
        cores.setMenus(jPnMenu.getBackground());
        dialog.consulta();

        dialog.cores(cores);
        dialog.usuario(usua);
        dialog.setVisible(true);
    }//GEN-LAST:event_jBtPesquisaActionPerformed

    private void jTvalorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTvalorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTvalorKeyPressed

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
            java.util.logging.Logger.getLogger(cadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cadProduto dialog = new cadProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void usuario(String u) {
        //recebe o suario na variavel global
        usua = u;
    }

    public void consulta(Produtos modelo) {
        ProdutoDAO dao = new ProdutoDAO();

        try {
            //evento do DAO  
            dao.consulta(modelo);

        } catch (HeadlessException | ParseException ex) {
            Logger.getLogger(consProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

        manda(modelo);
    }

    public void limpar() {
        limpacampos();
        desBotoes();
        desabilitar();
    }

    public void cores(Cores cores) {
        jPnMenu.setBackground(cores.getMenus());
        jPnFundo.setBackground(cores.getFundo());
    }

    public void salvaEdicao(Produtos modelo) {
        ProdutoDAO dao = new ProdutoDAO();

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja editar o cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                dao.atualiza(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(cadProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "O produto foi editado com sucesso !");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, " Edição não realizada. ");
        }
    }

    public void desBotoes() {
        jBtNovo.setEnabled(true);
        jBtLimpar.setEnabled(false);
        jBtCadastrar.setEnabled(false);

        jBtEditar.setEnabled(false);
        btEditar = 0;
    }

    public void habiBotoes() {
        jBtNovo.setEnabled(false);
        jBtCadastrar.setEnabled(true);
        jBtLimpar.setEnabled(true);

        jBtEditar.setEnabled(false);
    }

    public void manda(Produtos modelo) {
        jTcod.setText("" + (modelo.getcProd()));
        jTnome.setText(modelo.getNome());
        jCbUnidade.setSelectedItem("" + modelo.getUnidade());
        jTvalor.setText("" + modelo.getValor());

        jBtNovo.setEnabled(false);
        jBtEditar.setEnabled(true);
        jBtLimpar.setEnabled(true);
    }

    public void habilitar() {
        jTcod.setEnabled(true);
        jTnome.setEnabled(true);
        jCbUnidade.setEnabled(true);
        jTvalor.setEnabled(true);
    }

    public void desabilitar() {
        jTcod.setEnabled(false);
        jTnome.setEnabled(false);
        jCbUnidade.setEnabled(false);
        jTvalor.setEnabled(false);
    }

    public void limpacampos() {
        jTcod.setText("");
        jTnome.setText("");
        jCbUnidade.setSelectedIndex(0);
        jTvalor.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastrar;
    private javax.swing.JButton jBtEditar;
    private javax.swing.JButton jBtLimpar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCbUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPnFundo;
    private javax.swing.JPanel jPnMenu;
    private javax.swing.JTextField jTcod;
    private javax.swing.JTextField jTnome;
    private javax.swing.JFormattedTextField jTvalor;
    // End of variables declaration//GEN-END:variables
}
