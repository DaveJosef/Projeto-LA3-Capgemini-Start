
package TodoApp.util;

import TodoApp.controller.TagTaskController;
import TodoApp.controller.TaskController;
import TodoApp.model.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TaskTableModel extends AbstractTableModel {

    private String[] columns = {"Nome", "Descrição", "Notas", "Completada", "Editar", "Excluir", "Tags"};
    private List<Task> tasks = new ArrayList<>();
    private TagTaskController tagTaskController;

    public TaskTableModel() {
        this.tagTaskController = new TagTaskController();
    }
    
    //private TaskController controller;
/*
    private void updateTask(Task task) {
        try {
            controller.update(task);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);
        task.setCompleted((boolean) aValue);
        
        //updateTask(task);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Task task = tasks.get(rowIndex);
        Object value = null;
        
        switch (columnIndex) {
            case 0:
                value = task.getName();
                break;
            case 1:
                value = task.getDescription();
                break;
            case 2:
                value = new SimpleDateFormat("dd/MM/yyyy").format(task.getDeadline());
                break;
            case 3:
                value = task.getCompleted();
                break;
            case 4:
                value = "";
                break;
            case 5:
                value = "";
                break;
            case 6:
                value = tagTaskController.getTagsByIdTask(task.getId()).toString()
                        .replaceAll("[\\[\\]]", "");
                break;
            default:
                value = "Valor não permitido";
        }
        return value;
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
/*
    public void setController(TaskController controller) {
        this.controller = controller;
    }
    */

    public void setTagTaskController(TagTaskController tagTaskController) {
        this.tagTaskController = tagTaskController;
    }
}
