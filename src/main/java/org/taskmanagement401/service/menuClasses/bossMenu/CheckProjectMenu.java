package org.taskmanagement401.service.menuClasses.bossMenu;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.util.UserInput;

import java.util.List;
import java.util.Optional;

public class CheckProjectMenu {
    private final ProjectRepository projectRepository;

    public CheckProjectMenu(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        checkAndChangeProjectStatus();
    }

    private void checkAndChangeProjectStatus() {
        System.out.println("Select a project to mark as completed:");
        List<Project> projects = projectRepository.findAllActiveProjects();

        if (projects.isEmpty()) {
            System.out.println("No active projects available.");
            return;
        }

        for (Project project : projects) {
            System.out.println("Project ID: " + project.getId() + ", Name: " + project.getName());
            if (project.getTasks() != null && !project.getTasks().isEmpty()) {
                System.out.println("\tTasks:");
                for (Task task : project.getTasks()) {
                    System.out.println("\t\tTask ID: " + task.getTaskID() + ", Name: " + task.getTaskName() + ", Completed: " + task.isTaskCompleted());
                }
            } else {
                System.out.println("\tNo tasks for this project.");
            }
        }
        System.out.println();
        int projectId = UserInput.inputPositiveInt("Enter the ID of the project you want to mark as completed: ");
        Optional<Project> selectedProjectOpt = projectRepository.findById(projectId);

        if (selectedProjectOpt.isPresent()) {
            Project selectedProject = selectedProjectOpt.get();
            selectedProject.setStatus(true);
            System.out.println("Project '" + selectedProject.getName() + "' has been marked as completed.");
        } else {
            System.out.println("Project with ID " + projectId + " not found.");
        }
    }
}
