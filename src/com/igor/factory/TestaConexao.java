package com.igor.factory;

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

        System.out.println("Opened Connection");;
        connection.close();
        System.out.println("Closed Connection");
    }

    public void testa() throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Opened Connection");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "There is a problem with the connection.\n Erro: "+erro);
            System.exit(0);
        }
        System.out.println("Connection closed");
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
