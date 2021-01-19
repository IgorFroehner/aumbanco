/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aumbanco.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author IgorDev & artur
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/aumbanco", "root", "root");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Há um problema na conexão. Contate o desenvolvedor Erro: \n"+erro);
            throw new RuntimeException(erro);
        }
    }

}
