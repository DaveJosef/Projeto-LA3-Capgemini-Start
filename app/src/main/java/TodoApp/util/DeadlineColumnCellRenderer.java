
package TodoApp.util;

import TodoApp.model.Task;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(CENTER);
        label.setForeground(Color.WHITE);
        
        TaskTableModel model = (TaskTableModel) table.getModel();
        Task task = model.getTasks().get(row);
        
        //boolean hasExpired = new Date().getTime() < task.getDeadline().getTime();
        boolean hasExpired = !task.getDeadline().after(new Date());
        
        if (hasExpired) {
            label.setBackground(Color.RED);
        } else {
            label.setBackground(Color.GREEN);
        }
        
        return label;
    }
    
    
    
}
