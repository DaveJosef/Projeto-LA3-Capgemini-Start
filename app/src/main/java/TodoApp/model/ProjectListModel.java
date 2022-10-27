package TodoApp.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ProjectListModel<Project> implements ListModel<Project> {

    private List<Project> projects = new ArrayList<>();

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int getSize() {
        return projects.size();
    }

    @Override
    public Project getElementAt(int index) {
        return projects.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
    
}
