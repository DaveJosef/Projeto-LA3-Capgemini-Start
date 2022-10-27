/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package TodoApp.view;

import TodoApp.controller.TagController;
import TodoApp.controller.TagTaskController;
import TodoApp.model.Tag;
import TodoApp.model.Task;
import TodoApp.util.ButtonColumnCellRenderer;
import TodoApp.util.ButtonType;
import TodoApp.util.TagTableModel;
import TodoApp.util.TagTaskTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Deijigue
 */
public class TagTaskListDialog extends javax.swing.JDialog {

    private Task task;
    private TagController tagController;
    private TagTaskController tagTaskController;
    private TagTableModel tagTableModel;
    private TagTaskTableModel tagTaskTableModel;
    /**
     * Creates new form ProjectCreateDialog
     */
    public TagTaskListDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initControllers();
        initComponentsModel();
        decorateTagTable();
        decorateTagTaskTable();
        decorateWindow();
    }
    
    private void decorateWindow() {
        setIconImage(new ImageIcon(getClass().getResource("/tick.png")).getImage());
        setTitle("Todo App");
    }

    private void decorateTagTable() {
        jTableTagList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTableTagList.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTagList.getTableHeader().setForeground(new Color(255, 255, 255));
        jTableTagList.getColumnModel().getColumn(1).setCellRenderer(new ButtonColumnCellRenderer(ButtonType.ADD));
        //jTableTagList.setAutoCreateRowSorter(true);
    }

    private void decorateTagTaskTable() {
        jTableTagTaskList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTableTagTaskList.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTagTaskList.getTableHeader().setForeground(new Color(255, 255, 255));
        jTableTagTaskList.getColumnModel().getColumn(1).setCellRenderer(new ButtonColumnCellRenderer(ButtonType.DELETE));
        //jTableTagTaskList.setAutoCreateRowSorter(true);
    }

    private void initControllers() {
        tagController = new TagController();
        tagTaskController = new TagTaskController();
    }
    
    private void initComponentsModel() {
        tagTaskTableModel = new TagTaskTableModel();
        jTableTagTaskList.setModel(tagTaskTableModel);
        
        tagTableModel = new TagTableModel();
        jTableTagList.setModel(tagTableModel);
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
        jPanelEmptyList1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSave = new javax.swing.JLabel();
        jPanelTag = new javax.swing.JPanel();
        jPanelTags = new javax.swing.JPanel();
        jLabelTagsTitle = new javax.swing.JLabel();
        jLabelTagsAdd = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTagTaskList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTagList = new javax.swing.JTable();

        jPanelEmptyList.setBackground(java.awt.Color.white);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nenhuma tag por aqui :D");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Escolha uma tag para adicioná-la àqui.");

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

        jPanelEmptyList1.setBackground(java.awt.Color.white);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nenhuma tag por aqui :D");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Remova uma tag da tarefa para adicioná-la àqui.");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanelEmptyList1Layout = new javax.swing.GroupLayout(jPanelEmptyList1);
        jPanelEmptyList1.setLayout(jPanelEmptyList1Layout);
        jPanelEmptyList1Layout.setHorizontalGroup(
            jPanelEmptyList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        jPanelEmptyList1Layout.setVerticalGroup(
            jPanelEmptyList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyList1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 962));

        jPanelToolBar.setBackground(new java.awt.Color(0, 153, 102));

        jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelToolBarTitle.setForeground(java.awt.Color.white);
        jLabelToolBarTitle.setText("Tags da Tarefa");

        jLabelToolBarSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelToolBarSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelToolBarSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelToolBarSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelToolBarTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addComponent(jLabelToolBarSave, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelToolBarSave, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelTag.setBackground(java.awt.Color.white);

        jPanelTags.setBackground(java.awt.Color.white);

        jLabelTagsTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTagsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTagsTitle.setText("Tags Disponíveis");

        jLabelTagsAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTagsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelTagsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTagsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTagsLayout = new javax.swing.GroupLayout(jPanelTags);
        jPanelTags.setLayout(jPanelTagsLayout);
        jPanelTagsLayout.setHorizontalGroup(
            jPanelTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTagsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTagsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTagsAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTagsLayout.setVerticalGroup(
            jPanelTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTagsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTagsAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTagsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(java.awt.Color.red);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTableTagTaskList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTagTaskList.setRowHeight(40);
        jTableTagTaskList.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jTableTagTaskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTagTaskListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTagTaskList);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(java.awt.Color.red);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTableTagList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTagList.setRowHeight(40);
        jTableTagList.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jTableTagList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTagListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableTagList);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelTagLayout = new javax.swing.GroupLayout(jPanelTag);
        jPanelTag.setLayout(jPanelTagLayout);
        jPanelTagLayout.setHorizontalGroup(
            jPanelTagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTags, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTagLayout.setVerticalGroup(
            jPanelTagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTagLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelTagsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTagsAddMouseClicked
        // TODO add your handling code here:
        /*
        if (jListProjectList.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Para criar uma tarefa, primeiro é necessário criar um projeto");
            return;
        }*/
        TagCreateDialog tagCreateDialog = new TagCreateDialog(null, rootPaneCheckingEnabled);
        tagCreateDialog.setTask(task);
        tagCreateDialog.setVisible(true);
        tagCreateDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadTagTasks(task.getId());
                loadAvailableTags();
            }
        });

    }//GEN-LAST:event_jLabelTagsAddMouseClicked

    private void loadAvailableTags() {
        List<Tag> tags = tagController.getAll();
        List<Tag> filteredTags = tags.stream().filter((Tag t) -> !tagTaskTableModel.getTags().contains(t)).collect(Collectors.toList());
        tagTableModel.setTags(filteredTags);
        
        showJTableAvailableTags(!filteredTags.isEmpty());
    }

    private void loadTagTasks(int idTask) {
        List<Tag> tagTasks = tagTaskController.getTagsByIdTask(idTask);
        tagTaskTableModel.setTags(tagTasks);
        
        showJTableTags(!tagTasks.isEmpty());
    }
    
    private void jLabelToolBarSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelToolBarSaveMouseClicked
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(rootPane, "Edição concluída");
        this.dispose();
    }//GEN-LAST:event_jLabelToolBarSaveMouseClicked

    private void jTableTagTaskListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTagTaskListMouseClicked
        // TODO add your handling code here:
        int columnIndex = jTableTagTaskList.columnAtPoint(evt.getPoint());
        int rowIndex = jTableTagTaskList.rowAtPoint(evt.getPoint());
        Tag selectedTagTask = tagTaskTableModel.getTags().get(rowIndex);
        
        switch (columnIndex) {
            case 1:
                tagTaskController.removeByNameTagAndIdTask(selectedTagTask.getName(), task.getId());
                loadTagTasks(task.getId());
                loadAvailableTags();
                break;
        }
        
        
    }//GEN-LAST:event_jTableTagTaskListMouseClicked

    private void jTableTagListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTagListMouseClicked
        // TODO add your handling code here:
        int columnIndex = jTableTagList.columnAtPoint(evt.getPoint());
        int rowIndex = jTableTagList.rowAtPoint(evt.getPoint());
        Tag selectedTag = tagTableModel.getTags().get(rowIndex);
        
        switch (columnIndex) {
            case 1:
                tagTaskController.save(selectedTag, task);
                loadTagTasks(task.getId());
                loadAvailableTags();
                break;
        }
        
        
    }//GEN-LAST:event_jTableTagListMouseClicked

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

    private void showJTableAvailableTags(boolean areThereTasks) {
        if (areThereTasks) {
            hideComp(jPanel2, jPanelEmptyList1);
            showComp(jPanel2, jScrollPane3);
        } else {
            hideComp(jPanel2, jScrollPane3);
            showComp(jPanel2, jPanelEmptyList1);
        }
    }
    
    private void showJTableTags(boolean areThereTasks) {
        if (areThereTasks) {
            hideComp(jPanel1, jPanelEmptyList);
            showComp(jPanel1, jScrollPane2);
        } else {
            hideComp(jPanel1, jScrollPane2);
            showComp(jPanel1, jPanelEmptyList);
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
            java.util.logging.Logger.getLogger(TagTaskListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TagTaskListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TagTaskListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TagTaskListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TagTaskListDialog dialog = new TagTaskListDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTagsAdd;
    private javax.swing.JLabel jLabelTagsTitle;
    private javax.swing.JLabel jLabelToolBarSave;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelEmptyList1;
    private javax.swing.JPanel jPanelTag;
    private javax.swing.JPanel jPanelTags;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableTagList;
    private javax.swing.JTable jTableTagTaskList;
    // End of variables declaration//GEN-END:variables

    public void setTask(Task task) {
        this.task = task;
        
        loadTagTasks(task.getId());
        loadAvailableTags();
    }

}