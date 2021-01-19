/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aumbanco.DAO;

import br.com.aumbanco.GUI.TelaComprar;
import br.com.aumbanco.GUI.consCompra;
import br.com.aumbanco.modelo.Compras;
import br.com.aumbanco.modelo.Pessoas;
import br.com.aumbanco.factory.ConnectionFactory;
import java.awt.HeadlessException;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author IgorDev & Artur
 */
public class CompraDAO {

    private final Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private int quantidade_estoque;

    public CompraDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }
    
    public void consultaNomeProduto(Compras modelo) throws HeadlessException, ParseException {
        //consulta o nome do produto a partir do id do produto
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT nome FROM tb_produtos WHERE id_prod = '"+modelo.getId_produto()+"'");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setNome_produto(rs.getString("nome"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consultaProdutosCompra(Compras modelo) throws HeadlessException, ParseException {
        //consulta os produtos da venda
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT * FROM tb_produtos_compra WHERE id_compra = '"+modelo.getId_compra()+"'");
            ResultSet rs = st.getResultSet();

            TelaComprar dialog = new TelaComprar(new javax.swing.JFrame(), true);
            //manda pra variaveis 
            while (rs.next()) {
                modelo.setId_compra(rs.getInt("id_compra"));
                modelo.setId_produto(rs.getInt("id_produto"));
                modelo.setQuantidade(rs.getInt("quantidade"));
                modelo.setValor(rs.getDouble("preco"));
                consultaNomeProduto(modelo);
                
               dialog.tabela(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consulta(Compras modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (modelo.getFornecedor());

        try {
            java.sql.Statement st = connection.createStatement();

            //pesquisa pelo codigo do cliente
//            if (modelo.getDatac().equals("Cliente")) {
//                modelo.setNome_cliente(carinha);
//                consultaId_clientepeloNome(modelo);
//                st.executeQuery("SELECT * FROM aumbanco.tb_vendas WHERE id_cliente LIKE '%" + modelo.getId_fornecedor() + "%' ");
//            }

            //pesquisa pelo data
            if (modelo.getDatac().equals("Data")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_compras WHERE datac LIKE '%" + carinha + "%' ");
            }
            
            //pesquisa pelo codigo
            if (modelo.getDatac().equals("Código")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_compras WHERE id_compra LIKE '%" + carinha + "%' ");
            }

            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            consCompra dialog = new consCompra(new javax.swing.JFrame(), true);
            while (rs.next()) {

                modelo.setId_compra(rs.getInt("id_compra"));
                modelo.setId_fornecedor(rs.getInt("id_fornecedor"));
                modelo.setDatac(rs.getString("datac"));
                modelo.setN_notafiscal(rs.getString("n_notafiscal"));
                modelo.setValor_total(rs.getDouble("valor_total"));
                consultaNomeFornecedor(modelo);
                
                dialog.tabela(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consultaNomeFornecedor(Compras modelo) throws HeadlessException, ParseException {
        //consulta o fornecedor pelo id
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT nome,cnpj_cpf FROM tb_cliente_fornecedor WHERE id = '"+modelo.getId_fornecedor()+"'");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setFornecedor(rs.getString("nome"));
                modelo.setCnpj_cpf(rs.getString("cnpj_cpf"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void pegaQuantidade(Compras produtos) throws SQLException {
        
        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT quantidade_estoque FROM aumbanco.tb_produtos WHERE id_prod = '" + produtos.getId_produto()+ "';");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            if (rs.first()) {
                quantidade_estoque = (rs.getInt("quantidade_estoque"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void colocaEstoque(Compras modelo) throws SQLException {

        //chama metodo para saber a quantia no estoque
        pegaQuantidade(modelo);
        
        // conta para descontar quantidade vendida
        int quantidade_atualizada = quantidade_estoque+modelo.getQuantidade();
        
        //setar a quantidade no banco
        String sql = "UPDATE aumbanco.tb_produtos SET quantidade_estoque = ? where id_prod = ?;";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantidade_atualizada);
            stmt.setInt(2, modelo.getId_produto());
            stmt.execute();
        }
    }
    
    
    public void cadastra_ProdutosCompra(Compras modelo) throws SQLException {
        //metodo de cadastrar a MestreDetalhes ProdutosVenda
        
        //chama metodo para tirar a quantidade da compra do estoque
        colocaEstoque(modelo);
        
        String sql = "INSERT INTO `aumbanco`.`tb_produtos_compra` (`id_compra`, `id_produto`, `quantidade`, `preco`) "
                + "VALUES (?,?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, modelo.getId_compra());
            stmt.setInt(2, modelo.getId_produto());
            stmt.setInt(3, modelo.getQuantidade()); 
            stmt.setDouble(4, modelo.getValor());
            stmt.execute();
        }
    }
    
    public void consultaId_fornecedor(Compras modelo) throws HeadlessException, ParseException {
        
        //pega o id do cliente para sonsultar a venda a partir do CPF
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT id FROM tb_cliente_fornecedor WHERE cnpj_cpf = '"+modelo.getCnpj_cpf()+"'");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setId_fornecedor(rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cadastra_Compra(Compras modelo) throws SQLException, HeadlessException, ParseException {
        //metodo que cadastra a compra no banco de dados
        
        //chama metodo para ter o id do cliente atravez do CPF
        consultaId_fornecedor(modelo);
      
        String sql = "INSERT INTO `aumbanco`.`tb_compras` (`id_compra`, `id_fornecedor`, `datac`, `n_notafiscal`, `valor_total`) "
                + "VALUES (?,?,?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, modelo.getId_compra());
            stmt.setInt(2, modelo.getId_fornecedor());
            stmt.setString(3, modelo.getDatac());
            stmt.setString(4, modelo.getN_notafiscal());
            stmt.setDouble(5, modelo.getValor_total());
            stmt.execute();
        }
    }

    public void consultaCombo(Pessoas modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT nome,cnpj_cpf FROM aumbanco.tb_cliente_fornecedor WHERE cliente_fornecedor = 'fornecedor'");

            ResultSet rs = st.getResultSet();
            
            TelaComprar dialog = new TelaComprar(new javax.swing.JFrame(), true);
            //manda pra variaveis 
            while (rs.next()) {
                modelo.setNomePessoa(rs.getString("nome"));
                modelo.setCPF_CNPJ(rs.getString("cnpj_cpf"));

                dialog.combobox(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void UltimoCodigo(Compras modelo) throws HeadlessException, ParseException {
        //pega ultimo codigo para cadastrar 

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT MAX(id_compra) FROM tb_compras");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            if (rs.next()) {
                modelo.setId_compra(rs.getInt("MAX(id_compra)"));
            } else {
                modelo.setId_compra(0);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
