package org.taskmanagement401.service.menuClasses.bossMenu;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.TaskAddService;
import org.taskmanagement401.service.util.PrintActiveProjects;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AddTaskMenu {
    public AddTaskMenu(ProjectRepository projectRepository, TaskRepository taskRepository) {
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
            Project project = optionalProject.get();
            if (!project.getTasks().isEmpty()){
                System.out.println("Existing tasks in the project");
                UserTalkService.printAllTasks(project.getTasks());
            } else {
                System.out.println("There is no Tasks in this Project yet.");
            }




            UserTalkService.taskInformation();
            TaskAddService taskAddService = new TaskAddService(taskRepository);
            TaskDto taskDto = UserTalkService.getTaskParameters();
            ResponseDTO<Task> responseDTO = taskAddService.registration(taskDto);
            Task newTask = responseDTO.getAnswer();
            project.getTasks().add(newTask);
            System.out.println(responseDTO);

        }

    }
}
