package org.taskmanagement401.service.menuClasses.bossMenu;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.TaskAddService;
import org.taskmanagement401.service.util.PrintActiveProjects;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.Optional;

public class AddTaskMenu {
    public AddTaskMenu(ProjectRepository projectRepository, TaskRepository taskRepository) {
        System.out.println("Choose project: ");
        Optional<Project> project = PrintActiveProjects.print(projectRepository);

        UserTalkService.taskInformation();
        TaskAddService taskAddService = new TaskAddService(taskRepository);
    }
}
