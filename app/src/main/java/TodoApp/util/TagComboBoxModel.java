
package TodoApp.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBoxMenuItem;

public class TagComboBoxModel extends DefaultComboBoxModel {
    
    List<JCheckBoxMenuItem> menuItens = new ArrayList<>();

    @Override
    public Object getElementAt(int index) {
        return menuItens.get(index);
    }

    public void setMenuItens(List<JCheckBoxMenuItem> menuItens) {
        this.menuItens = menuItens;
    }
    
    
}
