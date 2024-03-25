package org.taskmanagement401.front.menuClasses.employeeMenu;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.List;
import java.util.Optional;

public class GetTasksMenu {
    public GetTasksMenu(User user, ProjectRepository projectRepository,
                        TaskRepository taskRepository) {
        System.out.println("List of all active Projects:");
        List<Project> projects = projectRepository.findAll();
        UserTalkService.printAllProjects(projects);

        int projectChoice = UserInput.inputPositiveInt("Choose a project by ID to add Task: ");

        Optional<Project> optionalProject = projects.stream()
                .filter(project -> project.getId() == projectChoice)
                .findFirst();

        if (optionalProject.isEmpty()){
            System.out.println("Wrong input data");

        } else if(optionalProject.isPresent()){
            System.out.println("List of all active Tasks:");
            Project project = optionalProject.get();
            List<Task> tasks = taskRepository.findAll();
            UserTalkService.printAllTasks(tasks);


            int taskChoice = UserInput.inputPositiveInt("Choose the Task by ID to add User: ");

            Optional<Task> optionalTask = tasks.stream()
                    .filter(task -> task.getTaskID() == taskChoice)
                    .findFirst();

            if (optionalTask.isEmpty()){
                System.out.println("Tasks list is empty");
            }

        } else{
            System.out.println("Invalid project selection.");
        }
    }
}
