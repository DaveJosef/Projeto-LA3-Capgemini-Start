/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TodoApp.view;

import TodoApp.controller.ProjectController;
import TodoApp.controller.TaskController;
import TodoApp.controller.UserController;
import TodoApp.model.Project;
import TodoApp.model.ProjectListModel;
import TodoApp.model.Task;
import TodoApp.model.User;
import TodoApp.util.TaskTableModel;
import TodoApp.util.DeadlineColumnCellRenderer;
import TodoApp.util.ButtonColumnCellRenderer;
import TodoApp.util.ButtonType;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Deijigue
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        hideErrorLabels();
        initControllers();
        initComponentsModel();
        decorateTasksTable();
        loadWelcomeMessage();
        //login();
        decorateWindow();
    }

    private void decorateWindow() {
        setIconImage(new ImageIcon(getClass().getResource("/tick.png")).getImage());
        setTitle("Todo App");
    }

    private void decorateTasksTable() {
        jTableTaskList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTableTaskList.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTaskList.getTableHeader().setForeground(new Color(255, 255, 255));
        jTableTaskList.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnCellRenderer());
        jTableTaskList.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellRenderer(ButtonType.EDIT));
        jTableTaskList.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellRenderer(ButtonType.DELETE));
        //jTableTaskList.setAutoCreateRowSorter(true);
    }
    
    private void initControllers() {
        taskController = new TaskController();
        projectController = new ProjectController();
        userController = new UserController();
    }
    
    public void initComponentsModel() {
        projectsModel = new DefaultListModel();
        loadProjects();
        tasksModel = new TaskTableModel();
        //tasksModel.setController(taskController);
        jTableTaskList.setModel(tasksModel);
        //loadTasks(2);
        selectFirstProject();
    }

    private void selectFirstProject() {
        if (!projectsModel.isEmpty()) {
            jListProjectList.setSelectedIndex(0);
            Project project = (Project) projectsModel.get(0);
            loadTasks(project.getId());
        } else {
            showJTableTasks(false);
        }
    }
    
    public void loadTasks(int idProject) {
        List<Task> tasks = taskController.getByIdProject(idProject);
        tasksModel.setTasks(tasks);
        
        showJTableTasks(!tasks.isEmpty());
    }
    
    public void loadProjects() {
        List<Project> projects = new ArrayList<>();
        
        if (!(authUser == null)) {
            projects = projectController.getByEmailUser(authUser.getEmail());
        }
        
        projectsModel.clear();
        for (int i = 0; i < projects.size(); i++) {
            projectsModel.addElement(projects.get(i));
        }
        //ProjectListModel model = new ProjectListModel();
        //model.setProjects(projects);
        jListProjectList.setModel(projectsModel);
        
    }

    public ProjectController getProjectController() {
        return projectController;
    }

    public void setProjectController(ProjectController projectController) {
        this.projectController = projectController;
    }

    public TaskController getTaskController() {
        return taskController;
    }

    public void setTaskController(TaskController taskController) {
        this.taskController = taskController;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEmptyList = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelToolBar2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelWelcome = new javax.swing.JLabel();
        jLabelLogout = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsAdd = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksAdd = new javax.swing.JLabel();
        jLabelEmptyProjectsError = new javax.swing.JLabel();
        jPanelProjectList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProjectList = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTaskList = new javax.swing.JTable();

        jPanelEmptyList.setBackground(java.awt.Color.white);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nenhuma tarefa por aqui :D");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Clique no botão \"+\" para adicionar uma nova tarefa.");

        javax.swing.GroupLayout jPanelEmptyListLayout = new javax.swing.GroupLayout(jPanelEmptyList);
        jPanelEmptyList.setLayout(jPanelEmptyListLayout);
        jPanelEmptyListLayout.setHorizontalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        jPanelEmptyListLayout.setVerticalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanelToolBar2.setBackground(new java.awt.Color(0, 153, 102));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        jLabel5.setText(" Todo App");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Anote tudo, esqueça nada");

        jLabelWelcome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelWelcome.setForeground(java.awt.Color.white);
        jLabelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelWelcome.setText("Bem-vindo, ");
        jLabelWelcome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(51, 102, 255));
        jLabelLogout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLogout.setText("Sair");
        jLabelLogout.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelToolBar2Layout = new javax.swing.GroupLayout(jPanelToolBar2);
        jPanelToolBar2.setLayout(jPanelToolBar2Layout);
        jPanelToolBar2Layout.setHorizontalGroup(
            jPanelToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBar2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelToolBar2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelWelcome))
                    .addGroup(jPanelToolBar2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLogout)))
                .addContainerGap())
        );
        jPanelToolBar2Layout.setVerticalGroup(
            jPanelToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBar2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelWelcome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabelLogout))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanelProjects.setBackground(java.awt.Color.white);

        jLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelProjectsTitle.setText("Projects");

        jLabelProjectsAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelProjectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelProjectsAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelProjectsAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelTasks.setBackground(java.awt.Color.white);

        jLabelTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTasksTitle.setText("Tasks");

        jLabelTasksAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelTasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksAddMouseClicked(evt);
            }
        });

        jLabelEmptyProjectsError.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmptyProjectsError.setForeground(new java.awt.Color(255, 51, 51));
        jLabelEmptyProjectsError.setText("Para criar uma tarefa, primeiro é necessário criar um projeto");

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmptyProjectsError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelTasksLayout.createSequentialGroup()
                        .addComponent(jLabelTasksTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTasksAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTasksAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyProjectsError))
        );

        jPanelProjectList.setBackground(java.awt.Color.white);

        jListProjectList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jListProjectList.setModel(new ProjectListModel());
        jListProjectList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjectList.setFixedCellHeight(60);
        jListProjectList.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jListProjectList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListProjectList);

        javax.swing.GroupLayout jPanelProjectListLayout = new javax.swing.GroupLayout(jPanelProjectList);
        jPanelProjectList.setLayout(jPanelProjectListLayout);
        jPanelProjectListLayout.setHorizontalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanelProjectListLayout.setVerticalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setLayout(new java.awt.BorderLayout());

        jTableTaskList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descrição", "Notas", "Concluída"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTaskList.setRowHeight(40);
        jTableTaskList.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jTableTaskList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTaskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTaskListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTaskList);

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTaskListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaskListMouseClicked
        // TODO add your handling code here:
        int columnIndex = jTableTaskList.columnAtPoint(evt.getPoint());
        int rowIndex = jTableTaskList.rowAtPoint(evt.getPoint());
        Task selectedTask = tasksModel.getTasks().get(rowIndex);

        switch (columnIndex) {
            case 3:
            taskController.update(tasksModel.getTasks().get(rowIndex));
            break;
            case 4:
            TaskUpdateDialog taskUpdateDialog = new TaskUpdateDialog(this, rootPaneCheckingEnabled);
            int selectedIndex = jListProjectList.getSelectedIndex();
            Project project = (Project) projectsModel.get(selectedIndex);
            taskUpdateDialog.setProject(project);
            taskUpdateDialog.setTask(selectedTask);
            taskUpdateDialog.loadTask();
            taskUpdateDialog.setVisible(rootPaneCheckingEnabled);
            taskUpdateDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    int selectedTaskIdProject = selectedTask.getIdProject();
                    loadTasks(selectedTaskIdProject);
                }
            });
            break;

            case 5:
            taskController.removeById(selectedTask.getId());
            int selectedTaskIdProject = selectedTask.getIdProject();
            loadTasks(selectedTaskIdProject);
            break;
        }
    }//GEN-LAST:event_jTableTaskListMouseClicked

    private void jListProjectListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectListMouseClicked
        // TODO add your handling code here:
        int projectIndex = jListProjectList.getSelectedIndex();
        if (projectIndex == -1) return;
        Project project = (Project) projectsModel.get(projectIndex);
        loadTasks(project.getId());
    }//GEN-LAST:event_jListProjectListMouseClicked

    private void jLabelTasksAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksAddMouseClicked
        // TODO add your handling code here:
        if (jListProjectList.getModel().getSize() == 0) {
            //JOptionPane.showMessageDialog(rootPane, "Para criar uma tarefa, primeiro é necessário criar um projeto");
            hideErrorLabels();
            showErrorLabel(jLabelEmptyProjectsError);
            return;
        } else {
            hideErrorLabels();
        }
        int selectedIndex = jListProjectList.getSelectedIndex();
        Project project = (Project) projectsModel.get(selectedIndex);
        TaskCreateDialog taskCreateDialog = new TaskCreateDialog(this, rootPaneCheckingEnabled);
        taskCreateDialog.setProject(project);
        taskCreateDialog.setVisible(true);
        taskCreateDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadTasks(project.getId());
            }
        });
    }//GEN-LAST:event_jLabelTasksAddMouseClicked

    private void jLabelProjectsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsAddMouseClicked
        // TODO add your handling code here:
        ProjectCreateDialog projectCreateDialog = new ProjectCreateDialog(this, rootPaneCheckingEnabled);
        projectCreateDialog.setUser(authUser);
        projectCreateDialog.setVisible(true);
        projectCreateDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadProjects();
                selectFirstProject();
            }
        });
    }//GEN-LAST:event_jLabelProjectsAddMouseClicked

    private void goToLoginScreen() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        this.dispose();
    }
    
    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        // TODO add your handling code here:
        goToLoginScreen();
    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void showJTableTasks(boolean areThereTasks) {
        if (areThereTasks) {
            hideComp(jPanel7, jPanelEmptyList);
            showComp(jPanel7, jScrollPane2);
        } else {
            hideComp(jPanel7, jScrollPane2);
            showComp(jPanel7, jPanelEmptyList);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmptyProjectsError;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelProjectsAdd;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksAdd;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JList<String> jListProjectList;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelProjectList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToolBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTaskList;
    // End of variables declaration//GEN-END:variables

    private UserController userController;
    private ProjectController projectController;
    private TaskController taskController;
    private DefaultListModel projectsModel;
    private TaskTableModel tasksModel;
    private User authUser;

    private void showErrorLabel(JLabel jLabel) {
        jLabel.setVisible(true);
    }
    
    private void hideErrorLabels() {
        jLabelEmptyProjectsError.setVisible(false);
    }

    public void setAuthUser(User authUser) {
        this.authUser = authUser;
        loadWelcomeMessage();
        loadProjects();
        selectFirstProject();
    }
    
    private void hideComp(JComponent parent, JComponent child) {
        if (child.isVisible()) {
            child.setVisible(false);
            parent.remove(child);
        }
    }

    private void showComp(JComponent parent, JComponent child) {
        parent.add(child);
        child.setVisible(true);
        child.setSize(parent.getWidth(), parent.getHeight());
    }

    private void login() {
        User result = userController.getAll().get(0);
        System.out.println(result);
        authUser = result;
    }

    private void loadWelcomeMessage() {
        String name = authUser == null ? "null" : authUser.getName();
        jLabelWelcome.setText(String.format("Bem-vindo, %s", name));
    }

}