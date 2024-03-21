package org.taskmanagement401.service.manus;

import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.AuthorizationService;
import org.taskmanagement401.service.ProjectAddService;
import org.taskmanagement401.service.ProjectEditService;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.ProjectValidation;

import java.util.ArrayList;
import java.util.List;

public class BossMenu {
    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    private ProjectRepository projectRepository;
    private ProjectValidation validation=new ProjectValidation();
    ArrayList<String> bossMenu= items.getMenu("Chef");
    public BossMenu(User user, ServicesGeneration servicesGeneration) {
        projectRepository=servicesGeneration.getProjectRepository();
        int userAnswer=0;
        while (userAnswer!=bossMenu.size()){
            menu.printMenu(bossMenu);
            userAnswer=menu.getUserChoice(bossMenu.size());
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
                ProjectAddService addService=new ProjectAddService(projectRepository);
                System.out.println("test1");
                ProjectDto dto= UserTalkService.getProjectParameters();
                ResponseDTO dtoResponse=
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
        }
    }
}
