
package TodoApp.view;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;

public class TaskListRenderer extends javax.swing.table.DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent comp = null;
        if (column == 3) {
            comp = new JCheckBox();
        }
        return comp;
    }
    
    
    
}
