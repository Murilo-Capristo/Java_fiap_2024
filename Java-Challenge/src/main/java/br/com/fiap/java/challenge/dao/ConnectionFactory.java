package br.com.fiap.java.challenge.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() throws IOException, SQLException {
        Connection con = null;
        Properties properties = new Properties();

        FileInputStream fileConfig = new FileInputStream("C:\\Users\\Master\\Desktop\\Java_fiap_2024\\Java-Challenge\\src\\main\\config.properties");
        properties.load(fileConfig);
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USERNAME");
        String password = properties.getProperty("PASSWORD");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}
