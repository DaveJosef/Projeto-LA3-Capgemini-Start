
package TodoApp.view;

import TodoApp.model.Project;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ProjectListRenderer implements javax.swing.ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JComponent comp = new JPanel();
        if (isSelected) {
            comp.setBackground(new java.awt.Color(0, 153, 102));
        } else {
            comp.setBackground(Color.white);
        }
        comp.add(new JLabel(((Project) value).getName()));
        return comp;
    }
    
}
