
package TodoApp;

import TodoApp.controller.ProjectController;
import TodoApp.controller.TaskController;
import TodoApp.model.Project;
import TodoApp.model.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static final TaskController TASK_CONTROLLER = new TaskController();
    private static final ProjectController PROJECT_CONTROLLER = new ProjectController();
    
    public static void main(String[] args) {
        
        TaskController taskController = new TaskController();
        ProjectController projectController = new ProjectController();
        
        
        projectController.save(new Project(1, "jose@gmail.com", "projeto teste no app", "projeto de teste", new Date(), new Date()));
        
        Task task = new Task(0,
                1,
                "Teste Task Criada No App 3",
                "Teste Task no App 3",
                "Task criada no App 3",
                false,
                new Date(),
                new Date(),
                new Date());
        
        /*
        taskController.save(task);
        */
        
        List<Project> projects = new ArrayList<>();
        int idProject;
        
        /* INICIO DO MENU */
        
        Scanner scan = new Scanner(System.in);
        char repetirMenu;
        int escolha;
        
        // MODELANDO A TASK
        int id;
        String name;
        String description;
        String notes;
        boolean completed;
        Date deadline;
        Date createdAt;
        Date updatedAt;
        
        do {

            System.out.println("Projetos: ");
            projects = projectController.getAll();
            
            projects.forEach(p -> imprimirProjeto(p, taskController));
            
            System.out.println("Escolha uma opcao: 1 - Inserir, 2 - Atualizar, 3 - Deletar ");
            escolha = scan.nextInt();
            
            System.out.println("Informar project id: ");
            idProject = scan.nextInt();
            
            switch (escolha) {
                case 1:
                    
                    System.out.println("Informar name: ");
                    name = scan.next();

                    System.out.println("Informar description: ");
                    description = scan.next();

                    System.out.println("Informar notes: ");
                    notes = scan.next();

                    System.out.println("Informar completed: ");
                    completed = scan.nextBoolean();

                    System.out.println("Informar deadline: ");
                    deadline = createDate();

                    createdAt = new Date();

                    updatedAt = new Date();

                    task.setIdProject(idProject);
                    task.setName(name);
                    task.setDescription(description);
                    task.setCompleted(completed);
                    task.setDeadline(deadline);
                    task.setCreatedAt(createdAt);
                    task.setUpdatedAt(updatedAt);
                    
                    taskController.save(task);
                    System.out.println("Tarefa salva");
                    
                    break;
                case 2:
                    
                    System.out.println("Informar id: ");
                    id = scan.nextInt();

                    System.out.println("Informar name: ");
                    name = scan.next();

                    System.out.println("Informar description: ");
                    description = scan.next();

                    System.out.println("Informar notes: ");
                    notes = scan.next();

                    System.out.println("Informar completed: ");
                    completed = scan.nextBoolean();

                    System.out.println("Informar deadline: ");
                    deadline = createDate();

                    updatedAt = new Date();

                    task.setId(id);
                    task.setName(name);
                    task.setDescription(description);
                    task.setCompleted(completed);
                    task.setDeadline(deadline);
                    task.setUpdatedAt(updatedAt);
                    
                    taskController.update(task);
                    System.out.println("Tarefa atualizada");
                    
                    break;
                case 3:
                    
                    System.out.println("Informar id: ");
                    id = scan.nextInt();

                    taskController.removeById(id);
                    System.out.println("Tarefa removida");
                    
                    break;
            }
            
            System.out.println("Deseja repetir o menu? ");
            repetirMenu = scan.next().charAt(0);
            
        } while (repetirMenu == 's');
        
    }
    
    private static Date createDate() {
        
        Scanner scan = new Scanner(System.in);
        
        String year;
        String month;
        String day;
        
        System.out.println("Informe ano: ");
        year = scan.next();
        System.out.println("Informe mes: ");
        month = scan.next();
        System.out.println("Informe dia: ");
        day = scan.next();
        
        Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        
        return date;
        
    }
    
    private static void imprimirProjeto(Project p, TaskController taskController) {
        
        System.out.println("Tarefas projeto " + p.getId() + " x " + p.getName() + ": ");

        List<Task> tasks = taskController.getByIdProject(p.getId());

        tasks.forEach(t -> System.out.println("\t" + t.getId() + " x " + t.getName()));
        
    }
    
}
