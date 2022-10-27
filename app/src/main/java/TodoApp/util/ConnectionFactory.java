
package TodoApp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            return java.sql.DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar conexão", ex);
        }
    }
    
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível fechar conexão", ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement statement) {
        try {
            if (conn != null) {
                conn.close();
            }
            
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível fechar conexão", ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (conn != null) {
                conn.close();
            }
            
            if (statement != null) {
                statement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível fechar conexão", ex);
        }
    }
    
}
