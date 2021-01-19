/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aumbanco.DAO;

import br.com.aumbanco.GUI.TelaVender;
import br.com.aumbanco.GUI.consVenda;
import br.com.aumbanco.modelo.Pessoas;
import br.com.aumbanco.modelo.Produtos;
import br.com.aumbanco.modelo.Venda;
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
 * @author IgorDev e Artur
 */
public class VendaDAO {

    private final Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private int quantidade_estoque;
    
    public VendaDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }
    
    public void consultaNomeProduto(Venda modelo) throws HeadlessException, ParseException {
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
    
    public void consultaProdutosVenda(Venda modelo) throws HeadlessException, ParseException {
        //consulta os produtos da venda
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT * FROM tb_produtos_venda WHERE id_venda = '"+modelo.getId_venda()+"'");
            ResultSet rs = st.getResultSet();

            TelaVender dialog = new TelaVender(new javax.swing.JFrame(), true);
            //manda pra variaveis 
            while (rs.next()) {
                modelo.setId_venda(rs.getInt("id_venda"));
                modelo.setId_produto(rs.getInt("id_produto"));
                modelo.setQuantidade(rs.getInt("quantidade"));
                modelo.setPreco(rs.getDouble("preco"));
                consultaNomeProduto(modelo);
                
               dialog.tabela(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    public void consulta(Venda modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (modelo.getNome_cliente());

        try {
            java.sql.Statement st = connection.createStatement();

            //pesquisa pelo codigo do cliente
            if (modelo.getDatav().equals("Cliente")) {
                modelo.setNome_cliente(carinha);
                consultaId_clientepeloNome(modelo);
                st.executeQuery("SELECT * FROM aumbanco.tb_vendas WHERE id_cliente LIKE '%" + modelo.getId_cliente() + "%' ");
            }

            //pesquisa pelo data
            if (modelo.getDatav().equals("Data")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_vendas WHERE datav LIKE '%" + carinha + "%' ");
            }
            
            //pesquisa pelo codigo
            if (modelo.getDatav().equals("Código")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_vendas WHERE id_venda LIKE '%" + carinha + "%' ");
            }

            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            consVenda dialog = new consVenda(new javax.swing.JFrame(), true);
            while (rs.next()) {

                modelo.setId_venda(rs.getInt("id_venda"));
                modelo.setId_cliente(rs.getInt("id_cliente"));
                modelo.setDatav(rs.getString("datav"));
                modelo.setValorTotal(rs.getInt("valor_total"));
                consultaNomecliente(modelo);
                
                dialog.tabela(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void consultaCombo(Pessoas modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT nome,cnpj_cpf FROM aumbanco.tb_cliente_fornecedor WHERE cliente_fornecedor = 'cliente'");

            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setNomePessoa(rs.getString("nome"));
                modelo.setCPF_CNPJ(rs.getString("cnpj_cpf"));
                
                TelaVender dialog = new TelaVender(new javax.swing.JFrame(), true);
                dialog.combobox(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consultaNomecliente(Venda modelo) throws HeadlessException, ParseException {
        //pega o id do cliente para cadastrar a venda a partir do nome
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT nome,cnpj_cpf FROM tb_cliente_fornecedor WHERE id = '"+modelo.getId_cliente()+"'");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setNome_cliente(rs.getString("nome"));
                modelo.setCnpf_cpf(rs.getString("cnpj_cpf"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consultaId_cliente(Venda modelo) throws HeadlessException, ParseException {
        
        //pega o id do cliente para sonsultar a venda a partir do CPF
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT id FROM tb_cliente_fornecedor WHERE cnpj_cpf = '"+modelo.getCnpf_cpf()+"'");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setId_cliente(rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consultaId_clientepeloNome(Venda modelo) throws HeadlessException, ParseException {
        
        //pega o id do cliente para sonsultar a venda a partir do CPF
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT id FROM tb_cliente_fornecedor WHERE nome = '"+modelo.getNome_cliente()+"'");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setId_cliente(rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cadastra_Venda(Venda modelo) throws SQLException, HeadlessException, ParseException {
        //metodo que cadastra a venda no banco de dados
        
        //chama metodo para ter o id do cliente atravez do CPF
        consultaId_cliente(modelo);
      
        String sql = "INSERT INTO `aumbanco`.`tb_vendas` (`id_venda`, `id_cliente`, `datav`, `valor_total`) "
                + "VALUES (?,?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, modelo.getId_venda());
            stmt.setInt(2, modelo.getId_cliente());
            stmt.setString(3, modelo.getDatav());
            stmt.setDouble(4, modelo.getValorTotal());
            stmt.execute();
        }
    }
    
    public void pegaQuantidade(Venda produtos) throws SQLException {
        
        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT quantidade_estoque FROM aumbanco.tb_produtos WHERE id_prod = '" + produtos.getId_produto() + "';");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            if (rs.first()) {
                quantidade_estoque = (rs.getInt("quantidade_estoque"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tiraEstoque(Venda modelo) throws SQLException {

        //chama metodo para saber a quantia no estoque
        pegaQuantidade(modelo);
        
        // conta para descontar quantidade vendida
        int quantidade_atualizada = quantidade_estoque-modelo.getQuantidade();
        
        //setar a quantidade no banco
        String sql = "UPDATE aumbanco.tb_produtos SET quantidade_estoque = ? where id_prod = ?;";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantidade_atualizada);
            stmt.setInt(2, modelo.getId_produto());
            stmt.execute();
        }
    }
    
    
    public void cadastra_ProdutosVenda(Venda modelo) throws SQLException {
        //metodo de cadastrar a MestreDetalhes ProdutosVenda
        
        //chama metodo para tirar a quantidade da compra do estoque
        tiraEstoque(modelo);
        
        String sql = "INSERT INTO `aumbanco`.`tb_produtos_venda` (`id_venda`, `id_produto`, `quantidade`, `preco`) "
                + "VALUES (?,?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, modelo.getId_venda());
            stmt.setInt(2, modelo.getId_produto());
            stmt.setInt(3, modelo.getQuantidade()); 
            stmt.setDouble(4, modelo.getPreco());

            stmt.execute();
        }
    }

    public void UltimoCodigo(Venda modelo) throws HeadlessException, ParseException {
        //pega ultimo codigo para cadastrar 

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT MAX(id_venda) FROM tb_vendas");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setId_venda(rs.getInt("MAX(id_venda)"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consultaCod(Produtos produtos) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (produtos.getPesquisa());

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT * FROM tbprodutos WHERE cProd LIKE '%" + carinha + "%' ");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {

                produtos.setcProd(rs.getInt("cProd"));
                produtos.setNome(rs.getString("Nome"));
                produtos.setValor(rs.getDouble("Valor"));

                TelaVender dialog = new TelaVender(new javax.swing.JFrame(), true);
                dialog.tabela(produtos);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consultaNome(Produtos modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (modelo.getPesquisa());

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT * FROM tbprodutos WHERE Nome LIKE '%" + carinha + "%' ");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {

                modelo.setcProd(rs.getInt("cProd"));
                modelo.setNome(rs.getString("Nome"));
                modelo.setValor(rs.getDouble("Valor"));

                TelaVender dialog = new TelaVender(new javax.swing.JFrame(), true);
                dialog.tabela(modelo);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
