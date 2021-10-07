package com.igor.DAO;

import com.igor.GUI.cadPessoas;
import com.igor.GUI.consPessoas;
import com.igor.modelo.Pessoas;
import com.igor.factory.ConnectionFactory;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PessoaDAO {

    private Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public PessoaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void consultaCPF_CNPJ(Pessoas modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT cnpj_cpf FROM aumbanco.tb_cliente_fornecedor WHERE cnpj_cpf = '" + modelo.getCPF_CNPJ() + "' ");

            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            if (rs.first()) {
                modelo.setCPF_CNPJ(rs.getString("cnpj_cpf"));
            } else {
                modelo.setCPF_CNPJ("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consulta(Pessoas modelo) throws HeadlessException, ParseException {
        //metodo de consulta no banco de dados 

        //PEGA DO CAMPO DA PESQUISA
        String carinha = (modelo.getNomePessoa());

        try {

            java.sql.Statement st = connection.createStatement();
            //pesquisa por fornecedores
            if (modelo.getPesquisa().equals("Fornecedor")) {
                st.executeQuery("SELECT * FROM tb_cliente_fornecedor WHERE cnpj_cpf LIKE '%" + carinha + "%' and cliente_fornecedor = 'cliente'");
            }
            //pesquisa por clientes
            if (modelo.getPesquisa().equals("Cliente")) {
                st.executeQuery("SELECT * FROM tb_cliente_fornecedor WHERE cnpj_cpf LIKE '%" + carinha + "%' and cliente_fornecedor = 'cliente'");
            }
            if (modelo.getPesquisa().equals("CPF/CNPJ")) {
                st.executeQuery("SELECT * FROM tb_cliente_fornecedor WHERE cnpj_cpf LIKE '%" + carinha + "%' ");
            }
            //pesquisa pelo nome
            if (modelo.getPesquisa().equals("Nome")) {
                st.executeQuery("SELECT * FROM tb_cliente_fornecedor WHERE Nome LIKE '%" + carinha + "%' ");
            }
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {

                modelo.setCPF_CNPJ(rs.getString("cnpj_cpf"));
                modelo.setCliente_fornecedor(rs.getString("cliente_fornecedor"));
                modelo.setNomePessoa(rs.getString("Nome"));
                modelo.setTelefone(rs.getString("Telefone"));
                modelo.setEstado(rs.getString("Estado"));
                modelo.setCidade(rs.getString("Cidade"));
                modelo.setBairro(rs.getString("Bairro"));
                modelo.setRua(rs.getString("Rua"));
                modelo.setNum(rs.getString("Num"));
                modelo.setComplemento(rs.getString("complemento"));
                modelo.setEmail(rs.getString("email"));

                consPessoas dialog = new consPessoas(new javax.swing.JFrame(), true);
                dialog.tabela(modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cadastra(Pessoas modelo) throws SQLException {

        String sql = "INSERT INTO `aumbanco`.`tb_cliente_fornecedor` "
                + "(`cliente_fornecedor`, "
                + "`cnpj_cpf`, "
                + "`nome`, "
                + "`telefone`, "
                + "`estado`, "
                + "`cidade`, "
                + "`bairro`,"
                + "`rua`, "
                + "`num`,"
                + "`complemento`,"
                + "`email`,"
                + "`hora_alteracao`,"
                + "`login`) \n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modelo.getCliente_fornecedor());
            stmt.setString(2, modelo.getCPF_CNPJ());
            stmt.setString(3, modelo.getNomePessoa());
            stmt.setString(4, modelo.getTelefone());
            stmt.setString(5, modelo.getEstado());
            stmt.setString(6, modelo.getCidade());
            stmt.setString(7, modelo.getBairro());
            stmt.setString(8, modelo.getRua());
            stmt.setString(9, modelo.getNum());
            stmt.setString(10, modelo.getComplemento());
            stmt.setString(11, modelo.getEmail());
            stmt.setString(12, modelo.getHoraalteracao());
            stmt.setString(13, modelo.getUsuario());
            stmt.execute();
        }
    }
    
    public void consultaIdpeloCpf(Pessoas modelo) {
        //pega o id do cliente para cadastrar a venda a partir do nome
        try {
            java.sql.Statement st = connection.createStatement();
            st.executeQuery("SELECT id FROM tb_cliente_fornecedor WHERE cnpj_cpf = '"+modelo.getCPF_CNPJ()+"'");
            ResultSet rs = st.getResultSet();

            //manda pra variaveis 
            while (rs.next()) {
                modelo.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void atualiza(Pessoas modelo) throws SQLException {
        //altera os dados no banco de dados

        consultaIdpeloCpf(modelo);
        
        String sql = "UPDATE aumbanco.tb_cliente_fornecedor SET "
                + "cliente_fornecedor=?,"
                + "nome=?,"
                + "cnpj_cpf=?,"
                + "telefone=?,"
                + "estado=?,"
                + "cidade=?,"
                + "bairro=?,"
                + "rua=?,"
                + "num=?,"
                + "complemento=?,"
                + "email=?,"
                + "hora_alteracao=?,"
                + "login=?"
                + "WHERE id = ?";

        //conecta com o banco
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, modelo.getCliente_fornecedor());
            stmt.setString(2, modelo.getNomePessoa());
            stmt.setString(3, modelo.getCPF_CNPJ());
            stmt.setString(4, modelo.getTelefone());
            stmt.setString(5, modelo.getEstado());
            stmt.setString(6, modelo.getCidade());
            stmt.setString(7, modelo.getBairro());
            stmt.setString(8, modelo.getRua());
            stmt.setString(9, modelo.getNum());
            stmt.setString(10, modelo.getComplemento());
            stmt.setString(11, modelo.getEmail());
            stmt.setString(12, modelo.getHoraalteracao());
            stmt.setString(13, modelo.getUsuario());
            stmt.setInt(14, modelo.getId());
            stmt.execute();

        }
    }

    public void estados() {
        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT nome FROM estado");
            ResultSet rs = st.getResultSet();

            javax.swing.JComboBox comboestados = cadPessoas.jCbEstado;

            String a = "";
            while (rs.next()) {
                a = (rs.getString("nome"));
                comboestados.addItem(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cadPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cidade(Pessoas modelo) {
        try {
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("SELECT nome FROM cidade WHERE estado = " + modelo.getCodEstado() + "");
            ResultSet rs = st.getResultSet();

            javax.swing.JComboBox combocidades = cadPessoas.jCbCidade;

            String a = "";
            while (rs.next()) {
                a = (rs.getString("nome"));
                combocidades.addItem(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cadPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
