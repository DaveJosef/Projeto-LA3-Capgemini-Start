package TodoApp.controller;

import TodoApp.model.Task;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO tasks (idProject,"
                + " name,"
                + " description,"
                + " completed,"
                + " notes,"
                + " deadline,"
                + " createdAt,"
                + " updatedAt)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, completed = ?, notes = ?, deadline = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public List<Task> getByIdProject(int idProject) {

        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        List<Task> tasks = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                tasks.add(task);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar tarefas", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        return tasks;
    }

    public void removeById(int id) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

}
