package org.taskmanagement401.service.menus;

import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.AddUserToTaskService;
import org.taskmanagement401.service.ProjectAddService;
import org.taskmanagement401.service.ProjectEditService;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.ProjectValidation;
import org.taskmanagement401.service.validation.TaskValidation;

import java.util.ArrayList;
import java.util.List;

public class BossMenu {
    private Menu menu = new Menu();
    private MenusItems items = new MenusItems();
    private ProjectRepository projectRepository;
    private ProjectValidation validation = new ProjectValidation();
    ArrayList<String> bossMenu= items.getMenu("Chef");
    ServicesGeneration servicesGeneration;
    public BossMenu(User user, ServicesGeneration servicesGeneration) {
        projectRepository = servicesGeneration.getProjectRepository();
        int userAnswer = 0;
        while (userAnswer != bossMenu.size()){
            menu.printMenu(bossMenu);
            userAnswer = menu.getUserChoice(bossMenu.size());
            manageMain(userAnswer);
        }
    }
     private void manageMain(int answer){
        switch (answer){
            case -1:
                menu.printError();
                break;
            case 1:
                UserTalkService.projectInformation();
                ProjectAddService addService = new ProjectAddService(projectRepository);
                System.out.println("test1");
                ProjectDto dto = UserTalkService.getProjectParameters();
                ResponseDTO dtoResponse =
                        addService.registration(dto);
               // System.out.println(dtoResponse);*/
                //ProjectDto dto= UserTalkService.getProjectParameters();

                break;

            case 2:
                System.out.println("Select a project to edit:");
                List<Project> projects = projectRepository.findAll();
                // Перебирает список проектов и выводит их названия с индексом для выбора
                for (int i = 0; i < projects.size(); i++) {
                    System.out.println((i + 1) + ". " + projects.get(i).getName());
                }
                int projectChoice = UserInput.inputPositiveInt("Choose a project by number:") - 1;
                // Проверяет, что выбранный номер проекта находится в допустимом диапазоне
                if (projectChoice >= 0 && projectChoice < projects.size()) {
                    // Получает выбранный проект из списка
                    Project selectedProject = projects.get(projectChoice);
                    String newDescription = UserInput.inputText("Enter new description:");
                    ProjectEditService editService = new ProjectEditService(projectRepository, new ProjectValidation());
                    ResponseDTO<String> response = editService.editProjectDescription(selectedProject.getId(), newDescription);
                    System.out.println(response.getAnswer());
                } else {
                    System.out.println("Invalid project selection.");
                }
                break;

            case 5:
                System.out.println("Select a project to find task for adding User: ");
                projects = projectRepository.findAll();
// строчки 56 - 60 (79-83) будут общие для нескольких пунктов меню. Чтобы не дублировать код их нужно вынести в юзер толк сервис.
                for (int i = 0; i < projects.size(); i++) {
                    System.out.println((i + 1) + ". " + projects.get(i).getName());
                }
                projectChoice = UserInput.inputPositiveInt("Choose a project by number:") - 1;

                if (projectChoice >= 0 && projectChoice < projects.size()) {
                    Project selectedProject = projects.get(projectChoice);

                    List<Task> selectedProjectTasks = selectedProject.getTasks();
                    for (int i = 0; i < selectedProjectTasks.size(); i++) {
                        System.out.println((i + 1) + ". " + selectedProjectTasks.get(i).getTaskName());
                    }
                    int taskChoice = UserInput.inputPositiveInt("Choose a task by number: ") - 1;
                    if (taskChoice >= 0 && taskChoice < selectedProjectTasks.size()) {
                        Task targetedTask = selectedProjectTasks.get(taskChoice);

//              тут надо вывести лист сотрудников, спросить его место в листе, сохранить этот индекс в переменную int selectedUser
                        AddUserToTaskService addUserservice = new AddUserToTaskService(servicesGeneration.getTaskRepository(), new TaskValidation());
                        //ResponseDTO <String> response = addUserservice.assignUser(targetedTask,selectedUser);
                    } else {
                        System.out.println("Invalid task selection.");
                    }

                } else {
                    System.out.println("Invalid project selection.");
                }
                break;

     }
    }
}
