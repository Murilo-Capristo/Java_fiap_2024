package br.com.fiap.web.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {


    public static Connection getConnection(){
        Properties properties = new Properties();

        try {
            FileInputStream fileConfig = new FileInputStream("C:\\Users\\Master\\Desktop\\Java_fiap_2024\\web\\src\\main\\config.properties");
            properties.load(fileConfig);

            String url = properties.getProperty("URL");
            String user = properties.getProperty("USERNAME");
            String password = properties.getProperty("PASSWORD");

            return DriverManager.getConnection(url,user, password);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection obterConexao() throws IOException {
        Connection conexao = null;
        Properties properties = new Properties();
        FileInputStream fileConfig = new FileInputStream("C:\\Users\\labsfiap\\Desktop\\Java_fiap_2024\\web\\src\\main\\config.properties");
//        FileInputStream fileConfig = new FileInputStream("C:\\Users\\Master\\Desktop\\Java_fiap_2024\\web\\src\\main\\config.properties");
        properties.load(fileConfig);
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USERNAME");
        String password = properties.getProperty("PASSWORD");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    user, password);
        }catch (SQLException erro){
            erro.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }
}
