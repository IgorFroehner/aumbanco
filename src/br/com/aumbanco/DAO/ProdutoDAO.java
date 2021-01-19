/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aumbanco.DAO;

import br.com.aumbanco.GUI.TelaComprar;
import br.com.aumbanco.GUI.TelaInicial;
import br.com.aumbanco.GUI.TelaVender;
import br.com.aumbanco.GUI.consProdutos;
import br.com.aumbanco.modelo.Produtos;
import br.com.aumbanco.modelo.Usuario;
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
 * @author XIgorDev & Artur
 */
public class ProdutoDAO {

    private final Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private String login;

    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }
    
    public void usuario(Usuario modelo) throws SQLException {
        //metodo de cadastro no banco de dados 
      login = modelo.getLogin();
    }
    

    public void cadastra(Produtos modelo) throws SQLException {
        //metodo de cadastro no banco de dados 

        String sql = "INSERT INTO aumbanco.tb_produtos (id_prod, nome, unidade_medida, valor, hora_alteracao, login)"
                + " VALUES (?,?,?,?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, modelo.getcProd());
            stmt.setString(2, modelo.getNome());
            stmt.setString(3, modelo.getUnidade());
            stmt.setDouble(4, modelo.getValor());
            stmt.setString(5, modelo.getHoraalteracao());
            stmt.setString(6, modelo.getUsuario());
            stmt.execute();
        }
    }

    public void pegaQuantidade(Produtos produtos) throws SQLException {
        int codigo = (produtos.getcProd());

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("select quantidade aumbanco.tb_produtos where id_prod = '" + codigo + "';");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            if (rs.first()) {
                produtos.setQuantidade(rs.getInt("quantidade_estoque"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void atualiza(Produtos modelo) throws SQLException {

        //altera os dados no banco de dados
        String sql = "UPDATE aumbanco.tb_produtos SET Nome=?,unidade_medida=?,Valor=?,hora_alteracao=?,login=?"
                + " WHERE id_prod = ?";

        //conecta com o banco
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modelo.getNome());
            stmt.setString(2, modelo.getUnidade());
            stmt.setDouble(3, modelo.getValor());
            stmt.setString(4, modelo.getHoraalteracao());
            stmt.setString(5, modelo.getUsuario());
            stmt.setInt(6, modelo.getcProd());
            stmt.execute();
        }
    }

    public void excluir(Produtos produtos) throws SQLException {
        //metodo de excluxão do banco de dados

        String sql = "DELETE FROM aumbanco.tb_produtos WHERE id_prod =?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produtos.getcProd());
            stmt.execute();
        }
    }

    public void UltimoCodigo(Produtos produtos) throws HeadlessException, ParseException {
        //pega ultimo codigo para cadastrar 

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT MAX(id_prod) FROM tb_produtos");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                produtos.setcProd(rs.getInt("MAX(id_prod)"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consulta(Produtos modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (modelo.getNome());

        try {
            java.sql.Statement st = connection.createStatement();

            //pesquisa pelo codigo
            if (modelo.getPesquisa().equals("Código")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE id_prod LIKE '%" + carinha + "%' ");
            }

            //pesquisa pelo nome
            if (modelo.getPesquisa().equals("Nome")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE Nome LIKE '%" + carinha + "%' ");
            }

            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            consProdutos dialog = new consProdutos(new javax.swing.JFrame(), true);
            while (rs.next()) {

                modelo.setcProd(rs.getInt("id_prod"));
                modelo.setNome(rs.getString("Nome"));
                modelo.setQuantidade(rs.getInt("Quantidade_estoque"));
                modelo.setUnidade(rs.getString("unidade_medida"));
                modelo.setValor(rs.getDouble("Valor"));

                dialog.tabela(modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void EstoqueBaixo(Produtos modelo) throws HeadlessException, ParseException {
        //pega ultimo codigo para cadastrar 

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT * FROM tb_produtos WHERE quantidade_estoque < 0 order by quantidade_estoque");
            ResultSet rs = st.getResultSet();

            TelaInicial tela = new TelaInicial();
            //manda pra variaveis 
            while (rs.next()) {
                modelo.setNome(rs.getString("nome"));

                tela.tabela(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    public void consultaCompra(Produtos modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados para tabela de produtos da tela vendas

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (modelo.getNome());

        try {
            java.sql.Statement st = connection.createStatement();

            //pesquisa pelo codigo
            if (modelo.getPesquisa().equals("Código")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE id_prod LIKE '%" + carinha + "%' ");
            }
            //pesquisa pelo nome
            if (modelo.getPesquisa().equals("Nome")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE Nome LIKE '%" + carinha + "%' ");
            }

            ResultSet rs = st.getResultSet();

            TelaComprar dialog = new TelaComprar(new javax.swing.JFrame(), true);

            //manda pra variaveis 
            while (rs.next()) {

                modelo.setcProd(rs.getInt("id_prod"));
                modelo.setNome(rs.getString("Nome"));
                modelo.setQuantidade(rs.getInt("Quantidade_estoque"));
                modelo.setUnidade(rs.getString("unidade_medida"));
                modelo.setValor(rs.getDouble("Valor"));

                dialog.tabela(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consultaVenda(Produtos modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados para tabela de produtos da tela vendas

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (modelo.getNome());

        try {
            java.sql.Statement st = connection.createStatement();

            //pesquisa pelo codigo
            if (modelo.getPesquisa().equals("Código")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE id_prod LIKE '%" + carinha + "%' ");
            }
            //pesquisa pelo nome
            if (modelo.getPesquisa().equals("Nome")) {
                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE Nome LIKE '%" + carinha + "%' ");
            }

            ResultSet rs = st.getResultSet();

            TelaVender dialog = new TelaVender(new javax.swing.JFrame(), true);

            //manda pra variaveis 
            while (rs.next()) {

                modelo.setcProd(rs.getInt("id_prod"));
                modelo.setNome(rs.getString("Nome"));
                modelo.setQuantidade(rs.getInt("Quantidade_estoque"));
                modelo.setUnidade(rs.getString("unidade_medida"));
                modelo.setValor(rs.getDouble("Valor"));

                dialog.tabela(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
