package org.taskmanagement401.service.menuClasses.bossMenu;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.util.UserInput;

import java.time.LocalDate;
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
                    String taskInfo = String.format("\t\tTask ID: %d, Name: %s, End Date: %s, Completed: %s",
                            task.getTaskID(), task.getTaskName(), task.getEndDate(), task.isTaskCompleted());

                    if (task.getEndDate().isBefore(LocalDate.now())) {
                        // Просроченные задачи красным цветом
                        System.out.println("\u001B[31m" + taskInfo + "\u001B[0m");
                    } else {
                        // Непросроченные задачи зеленым цветом
                        System.out.println("\u001B[32m" + taskInfo + "\u001B[0m");
                    }
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

            boolean hasIncompleteTasks = selectedProject.getTasks().stream()
                    .anyMatch(task -> !task.isTaskCompleted());

            if (hasIncompleteTasks) {
                System.out.println("This project has incomplete tasks. Are you sure you want to mark it as completed? (y/n)");
                boolean confirm = UserInput.inputBool("");
                if (!confirm) {
                    System.out.println("The project status has not been changed.");
                    return;
                }
            }

            selectedProject.setStatus(true);
            System.out.println("Project '" + selectedProject.getName() + "' has been marked as completed.");
        } else {
            System.out.println("Project with ID " + projectId + " not found.");
        }
    }
}
