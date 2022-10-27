
package TodoApp.util;

import TodoApp.controller.TaskController;
import TodoApp.model.Tag;
import TodoApp.model.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TagTaskTableModel extends AbstractTableModel {

    private String[] columns = {"Nome", "Excluir"};
    private List<Tag> tags = new ArrayList<>();
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tags.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public int getRowCount() {
        return tags.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Tag tag = tags.get(rowIndex);
        Object value = null;
        
        switch (columnIndex) {
            case 0:
                value = tag.getName();
                break;
            case 1:
                value = "";
                break;
            default:
                value = "Valor não permitido";
        }
        return value;
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags ){
        this.tags = tags;
    }
    
}
