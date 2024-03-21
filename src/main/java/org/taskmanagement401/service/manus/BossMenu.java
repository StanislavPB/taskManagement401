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
import org.taskmanagement401.service.menuClasses.bossMenu.*;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.ProjectValidation;

import java.util.ArrayList;
import java.util.List;

public class BossMenu {
    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    ServicesGeneration servicesGeneration;
    ArrayList<String> bossMenu= items.getMenu("Chef");
    public BossMenu(User user, ServicesGeneration servicesGeneration) {
        this.servicesGeneration=servicesGeneration;
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
                AddProjectMenu addProjectMenu=new AddProjectMenu(
                        servicesGeneration.getProjectRepository()
                );

                break;
            case 2:
                EditProjectMenu editProjectMenu=new EditProjectMenu(
                        servicesGeneration.getProjectRepository()
                );
                break;
            case 3:
                AddTaskMenu addTaskMenu=new AddTaskMenu(
                        servicesGeneration.getProjectRepository(),
                        servicesGeneration.getTaskRepository()
                );
                break;
            case 4:
                AddUserToProjectMenu addUserToProjectMenu= new AddUserToProjectMenu(
                        servicesGeneration.getProjectRepository(),
                        servicesGeneration.getUserRepository()
                );
                break;
            case 5:
                AddUserToTaskMenu addUserToTaskMenu=new AddUserToTaskMenu(
                  servicesGeneration.getProjectRepository(),
                        servicesGeneration.getUserRepository(),
                        servicesGeneration.getTaskRepository()
                );
                break;
            case 6:
                CheckProjectMenu checkProjectMenu=new CheckProjectMenu(
                        servicesGeneration.getProjectRepository()
                );
                break;
        }
    }
}
