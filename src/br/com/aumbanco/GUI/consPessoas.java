/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aumbanco.GUI;

import br.com.aumbanco.DAO.PessoaDAO;
import br.com.aumbanco.modelo.Cores;
import br.com.aumbanco.modelo.Pessoas;
import br.com.aumbanco.util.ReportUtils;
import br.com.aumbanco.factory.ConnectionFactory;
import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
/**
 *
 * @author IgorDev & Artur
 */
public class consPessoas extends javax.swing.JDialog {

    /**
     * Creates new form consPessoas
     */
    private static javax.swing.table.DefaultTableModel tabela;
    private String usua, cliente_fornecedor;

    public consPessoas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jPb.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnFundo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbPessoas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTpesquisa = new javax.swing.JTextField();
        jSelecionar = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPnMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPb = new javax.swing.JProgressBar();
        jBtImprimirClientes = new javax.swing.JButton();
        jBtImprimirFornecedores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Pessoas - Aumbanco");

        jPnFundo.setBackground(new java.awt.Color(255, 255, 255));
        jPnFundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTbPessoas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTbPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CPF/CNPJ", "Cliente/Fornecedor", "Nome", "Telefone", "Estado", "Cidade", "Bairro", "Rua", "Num", "Comp.", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbPessoasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbPessoas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pesquisar por:");

        jTpesquisa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTpesquisaKeyPressed(evt);
            }
        });

        jSelecionar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jSelecionar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CPF/CNPJ", "Cliente", "Fornecedor" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPnMenu.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setFont(new java.awt.Font("Aharoni", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consulta de Pessoas");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back_2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPb.setForeground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPnMenuLayout = new javax.swing.GroupLayout(jPnMenu);
        jPnMenu.setLayout(jPnMenuLayout);
        jPnMenuLayout.setHorizontalGroup(
            jPnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnMenuLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPb, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPnMenuLayout.setVerticalGroup(
            jPnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jBtImprimirClientes.setText("Imprimir Clientes");
        jBtImprimirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirClientesActionPerformed(evt);
            }
        });

        jBtImprimirFornecedores.setText("Imprimir Fornecedores");
        jBtImprimirFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirFornecedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnFundoLayout = new javax.swing.GroupLayout(jPnFundo);
        jPnFundo.setLayout(jPnFundoLayout);
        jPnFundoLayout.setHorizontalGroup(
            jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnFundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPnFundoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jTpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtImprimirClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jBtImprimirFornecedores)))
                .addContainerGap())
            .addComponent(jPnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPnFundoLayout.setVerticalGroup(
            jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnFundoLayout.createSequentialGroup()
                .addComponent(jPnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnFundoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnFundoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtImprimirClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtImprimirFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPnFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTbPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbPessoasMouseClicked
        if (evt.getClickCount() == 2) {
            Pessoas modelo = new Pessoas();
            //manda para os edits da tela cadastro e volta para a mesma

            Object obj0 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 0));
            modelo.setCPF_CNPJ(obj0.toString());

            Object obj1 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 1));
            modelo.setCliente_fornecedor(obj1.toString());

            Object obj2 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 2));
            modelo.setNomePessoa(obj2.toString());

            Object obj3 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 3));
            modelo.setTelefone(obj3.toString());

            Object obj4 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 4));
            modelo.setEstado(obj4.toString());

            Object obj5 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 5));
            modelo.setCidade(obj5.toString());

            Object obj6 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 6));
            modelo.setBairro(obj6.toString());

            Object obj7 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 7));
            modelo.setRua(obj7.toString());

            Object obj8 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 8));
            modelo.setNum(obj8.toString());

            Object obj9 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 9));
            modelo.setComplemento(obj9.toString());

            Object obj10 = (jTbPessoas.getValueAt(jTbPessoas.getSelectedRow(), 10));
            modelo.setEmail(obj10.toString());

            //manda para outra tela com as informações nos edits
            cadPessoas dialog = new cadPessoas(new javax.swing.JFrame(), true);
            dialog.manda(modelo);
            Cores cores = new Cores();

            //manda as cores
            cores.setFundo(jPnFundo.getBackground());
            cores.setMenus(jPnMenu.getBackground());

            //executa os metodos do outro dialog
            dialog.cores(cores);
            dialog.usuario(usua);
            dialog.setVisible(true);

            dispose();
        }
    }//GEN-LAST:event_jTbPessoasMouseClicked

    private void jTpesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpesquisaKeyPressed
        consulta();
    }//GEN-LAST:event_jTpesquisaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consulta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBtImprimirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirClientesActionPerformed
        cliente_fornecedor = "cliente";
        barraInicio();
    }//GEN-LAST:event_jBtImprimirClientesActionPerformed

    private void jBtImprimirFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirFornecedoresActionPerformed
        cliente_fornecedor = "fornecedor";
        barraInicio();
    }//GEN-LAST:event_jBtImprimirFornecedoresActionPerformed

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
            java.util.logging.Logger.getLogger(consPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                consPessoas dialog = new consPessoas(new javax.swing.JFrame(), true);
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

    public void barraInicio() {
        // Progressbar
        new Thread() {

            @Override
            public void run() {

                super.run();

                jPb.setIndeterminate(true);

                jPb.setVisible(true);

                ImprimeClientes_Fornecedores(cliente_fornecedor);
                barraFim();
            }
        }
                .start();
    }

    public void barraFim() {

        jPb.setIndeterminate(false);

        jPb.setVisible(false);

    }

    public void ImprimeClientes_Fornecedores(String clienteoufornecedor) {

        //instancia a conexão
        Connection connection = new ConnectionFactory().getConnection();
        // note que estamos chamando o novo relatório
        InputStream inputStream = getClass().getResourceAsStream("/reportClientes.jasper");

        // mapa de parâmetros do relatório
        Map parametros = new HashMap();
        parametros.put("cliente/fornecedor", clienteoufornecedor);

        // outros possíveis parâmetros aqui...
        try {

            // abre o relatório 
            ReportUtils.openReport(clienteoufornecedor, inputStream, parametros, connection);

        } catch (JRException exc) {
            exc.printStackTrace();
        }

    }

    public void usuario(String u) {
        //recebe usuario logado da outra tela
        usua = u;
    }

    public void cores(Cores cores) {
        jPnMenu.setBackground(cores.getMenus());
        jPnFundo.setBackground(cores.getFundo());
    }

    public void tabela(Pessoas modelo) {
        //pegando do modelo e mandando para a tabela          
        tabela.addRow(new Object[]{
            modelo.getCPF_CNPJ(),
            modelo.getCliente_fornecedor(),
            modelo.getNomePessoa(),
            modelo.getTelefone(),
            modelo.getEstado(),
            modelo.getCidade(),
            modelo.getBairro(),
            modelo.getRua(),
            modelo.getNum(),
            modelo.getComplemento(),
            modelo.getEmail()});
    }

    public void consulta() {
        //instanciando Classe Prova() do Modelo
        Pessoas modelo = new Pessoas();

        //mandando pro set do modelo
        modelo.setNomePessoa(jTpesquisa.getText());
        modelo.setPesquisa((String) jSelecionar.getSelectedItem());

        //criando a variavel para a tabela
        tabela = (javax.swing.table.DefaultTableModel) jTbPessoas.getModel();
        tabela.setNumRows(0);

        PessoaDAO dao = new PessoaDAO();

        try {
            //evento do DAO  
            dao.consulta(modelo);

        } catch (HeadlessException | ParseException ex) {
            Logger.getLogger(consProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtImprimirClientes;
    private javax.swing.JButton jBtImprimirFornecedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jPb;
    private javax.swing.JPanel jPnFundo;
    private javax.swing.JPanel jPnMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jSelecionar;
    private javax.swing.JTable jTbPessoas;
    private javax.swing.JTextField jTpesquisa;
    // End of variables declaration//GEN-END:variables
}