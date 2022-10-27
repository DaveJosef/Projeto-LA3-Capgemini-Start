
package TodoApp.controller;

import TodoApp.model.Tag;
import TodoApp.model.Task;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagTaskController {
    
    public void save(Tag tag, Task task) {
        
        String sql = "INSERT INTO tags_tasks (nameTag, idTask) VALUES (?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, tag.getName());
            statement.setInt(2, task.getId());
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar tag_task", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public List<Tag> getTagsByIdTask(int idTask) {

        String sql = "SELECT * FROM tags tgs JOIN tags_tasks tgstks ON tgstks.idTask = ? AND tgstks.nameTag = tgs.name";
        List<Tag> tags = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, idTask);
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

    public void removeByNameTagAndIdTask(String nameTag, int idTask) {
        
        String sql = "DELETE FROM tags_tasks WHERE nameTag = ? AND idTask = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, nameTag);
            statement.setInt(2, idTask);
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover tag_task", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
}
