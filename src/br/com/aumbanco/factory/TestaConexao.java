package br.com.aumbanco.factory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author IgorDev & Artur
 */
public class TestaConexao {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionFactory().getConnection();

        System.out.println("Conexao aberta");;
        connection.close();
        System.out.println("Conexão fechada");
    }

    public void testa() throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Conexao aberta");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Há um problema na conexão.\n Erro: "+erro);
            System.exit(0);
        }
        System.out.println("Conexão fechada");
    }

    public void useAumbanco() throws SQLException {

        try {
            Connection connection = new ConnectionFactory().getConnection();
            java.sql.Statement st = connection.createStatement();

            st.executeQuery("USE aumbanco;");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
