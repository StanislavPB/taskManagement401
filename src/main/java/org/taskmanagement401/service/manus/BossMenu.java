package org.taskmanagement401.service.manus;

import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.AuthorizationService;
import org.taskmanagement401.service.ProjectAddService;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.ProjectValidation;

import java.util.ArrayList;

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
                ResponseDTO dto=addService.registration();
                System.out.println(dto);
                //ProjectDto dto= UserTalkService.getProjectParameters();

                break;
            case 2:

                break;
        }
    }
}
