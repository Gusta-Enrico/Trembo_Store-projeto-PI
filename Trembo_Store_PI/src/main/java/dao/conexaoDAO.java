package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDAO {

    public Connection conectaBD() {
        Connection conexao = null;

        try {
            String url = "jdbc:mysql://localhost:3306/trembo_store?user=root&password=3045";
            conexao = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na classe de conexão do BD" + erro.getMessage());
        }
        return conexao;
    }

}
