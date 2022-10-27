
package TodoApp.controller;

import TodoApp.model.User;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    
    public void save(User user) {
        
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar user", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public void update(User user) {
        
        String sql = "UPDATE users SET name = ?, password = ? WHERE email = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar user", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public List<User> getAll() {
        
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar users", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        
        return users;
        
    }
    
    public User getByEmail(String email) {
        
        String sql = "SELECT * FROM users WHERE email = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        User user = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, email);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover user", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
        return user;
        
    }
    
    public void removeByEmail(String email) {
        
        String sql = "DELETE FROM users WHERE email = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, email);
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover user", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
}
