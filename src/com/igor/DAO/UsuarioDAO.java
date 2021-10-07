/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igor.DAO;

import com.igor.GUI.consUsuario;
import com.igor.modelo.Usuario;
import com.igor.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author devIgor
 */
public class UsuarioDAO {

    private Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
//    public void consulta(Usuario modelo) throws HeadlessException, ParseException {
//        //metodo de consulta no banco de dados 
//
//        //PEGA DO CAMPO DA PESQUISA
//        String carinha = (modelo.getNome());
//
//        try {
//            java.sql.Statement st = connection.createStatement();
//
//            //pesquisa pelo codigo
//            if (modelo.getPesquisa().equals("Código")) {
//                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE id_prod LIKE '%" + carinha + "%' ");
//            }
//
//            //pesquisa pelo nome
//            if (modelo.getPesquisa().equals("Nome")) {
//                st.executeQuery("SELECT * FROM aumbanco.tb_produtos WHERE Nome LIKE '%" + carinha + "%' ");
//            }
//
//            ResultSet rs = st.getResultSet();
//
//            //manda pra variaveis 
//            consProdutos dialog = new consProdutos(new javax.swing.JFrame(), true);
//            while (rs.next()) {
//                modelo.setcProd(rs.getInt("id_prod"));
//                modelo.setNome(rs.getString("Nome"));
//                modelo.setCategoria(rs.getString("Categoria"));
//                modelo.setQuantidade(rs.getInt("Quantidade_estoque"));
//                modelo.setUnidade(rs.getString("unidade_medida"));
//                modelo.setValor(rs.getDouble("Valor"));
//
//                dialog.tabela(modelo);
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }

    public void adiciona(Usuario modelo) throws SQLException {

        //metodo de cadastro no banco de dados 
        String sql = "INSERT INTO tb_usuarios(nome,login,senha,permissao) VALUES(?,?,MD5(?),?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modelo.getNome());
            stmt.setString(2, modelo.getLogin());
            stmt.setString(3, modelo.getSenha());
            stmt.setString(4, modelo.getPermissao());
            stmt.execute();
        }
    }
    
    public void consultaUsuario(Usuario modelo) throws SQLException {

        String login = modelo.getLogin();

        java.sql.Statement st = connection.createStatement();

        st.executeQuery("select * from aumbanco.tb_usuarios WHERE nome LIKE '%" + login + "%'");

        ResultSet rs = st.getResultSet();

        consUsuario dialog = new consUsuario(new javax.swing.JFrame(), true);
        while (rs.next()) {
            modelo.setNome(rs.getString("nome"));
            modelo.setLogin(rs.getString("login"));
            modelo.setSenha(rs.getString("senha"));
            modelo.setPermissao(rs.getString("permissao"));
            
            dialog.tabela(modelo);
        }

    }
    
    public void consulta(Usuario modelo) throws SQLException {

        String login = modelo.getLogin();

        java.sql.Statement st = connection.createStatement();

        st.executeQuery("select * from aumbanco.tb_usuarios WHERE login = '" + login + "'");

        ResultSet rs = st.getResultSet();

        if (rs.next()) {

            modelo.setNome(rs.getString("nome"));
            modelo.setLogin(rs.getString("login"));
            modelo.setSenha(rs.getString("senha"));
            modelo.setPermissao(rs.getString("permissao"));

            modelo.setValida(1);

        } else {
            modelo.setValida(0);
        }

    }

    public void entrada(Usuario modelo) throws SQLException {

        //metodo de cadastro no banco de dados 
        String sql = "INSERT INTO tb_entrada(login,hora_entrada,data_entrada) VALUES(?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modelo.getLogin());
            stmt.setString(2, modelo.getHoraentrada());
            stmt.setString(3, modelo.getDataentrada());
            stmt.execute();
        }
    }

    public void saida(Usuario modelo) throws SQLException {

        //metodo que registra a saida do uo no banco
        String sql = "UPDATE \n"
                + "      tb_entrada AS h\n"
                + "  JOIN\n"
                + "      ( SELECT MAX(id_entrada) AS max_id \n"
                + "        FROM tb_entrada \n"
                + "        WHERE login = ?\n"
                + "      ) AS m\n"
                + "    ON m.max_id = h.id_entrada\n"
                + "SET h.data_saida = ?, h.hora_saida = ? ;";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modelo.getLogin());
            stmt.setString(2, modelo.getDatasaida());
            stmt.setString(3, modelo.getHorasaida());
            stmt.execute();
        }
    }

    public void Valida(Usuario modelo) throws SQLException {
        //valida a senha e o login para a entrada no sistema
        
        String login = modelo.getLogin();
        String senha = modelo.getSenha();

        java.sql.Statement st = connection.createStatement();

        st.executeQuery("select * from aumbanco.tb_usuarios WHERE login = '" + login + "' and senha = md5('" + senha + "') ");

        ResultSet rs = st.getResultSet();

        if (rs.next()) {

            modelo.setNome(rs.getString("nome"));
            modelo.setLogin(rs.getString("login"));
            modelo.setSenha(rs.getString("senha"));
            modelo.setPermissao(rs.getString("permissao"));

            modelo.setValida(1);

        } else {
            modelo.setValida(0);
        }

    }
}
