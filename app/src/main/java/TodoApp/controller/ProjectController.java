
package TodoApp.controller;

import TodoApp.model.Project;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {
    
    public void save(Project project) {
        
        String sql = "INSERT INTO projects (emailUser, name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getEmailUser());
            statement.setString(2, project.getName());
            statement.setString(3, project.getDescription());
            statement.setDate(4, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(5, new java.sql.Date(project.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public void update(Project project) {
        
        String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public List<Project> getByEmailUser(String emailUser) {
        
        String sql = "SELECT * FROM projects WHERE emailUser = ?";
        List<Project> projects = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, emailUser);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Project project = new Project();
                project.setEmailUser(resultSet.getString("emailUser"));
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                projects.add(project);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar projetos", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        
        return projects;
        
    }
    
    public List<Project> getAll() {
        
        String sql = "SELECT * FROM projects";
        List<Project> projects = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Project project = new Project();
                project.setEmailUser(resultSet.getString("emailUser"));
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                projects.add(project);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar projetos", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        
        return projects;
        
    }
    
    public void removeById(int id) {
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
}
