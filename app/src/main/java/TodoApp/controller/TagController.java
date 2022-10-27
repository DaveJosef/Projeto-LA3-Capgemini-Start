
package TodoApp.controller;

import TodoApp.model.Tag;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagController {
    
    public void save(Tag tag) {
        
        String sql = "INSERT INTO tags (name, createdAt) VALUES (?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, tag.getName());
            statement.setDate(2, new java.sql.Date(tag.getCreatedAt().getTime()));
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar tag", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public List<Tag> getAll() {

        String sql = "SELECT * FROM tags";
        List<Tag> tags = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Tag tag = new Tag();
                tag.setName(resultSet.getString("name"));
                tag.setCreatedAt(resultSet.getDate("createdAt"));
                tags.add(tag);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar tags", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        return tags;
    }

}
