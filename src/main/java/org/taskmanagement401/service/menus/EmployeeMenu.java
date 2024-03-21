package org.taskmanagement401.service.menus;

import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;

public class EmployeeMenu {
    private Menu menu = new Menu();
    private MenusItems items = new MenusItems();
    private ArrayList<String> employeeMenu = items.getMenu("Employee");
    ServicesGeneration servicesGeneration;
    public EmployeeMenu(User user, ServicesGeneration servicesGeneration) {
        this.servicesGeneration = servicesGeneration;
        int userAnswer = 0;
        while (userAnswer != employeeMenu.size()){
            menu.printMenu(employeeMenu);
            userAnswer = menu.getUserChoice(employeeMenu.size());
            manageMain(userAnswer);
        }
    }
    private void manageMain(int answer){


        switch (answer){
            case -1:
                menu.printError();
                break;
            case 1:

                break;
            case 2:

                ProjectRepository repository=servicesGeneration.getProjectRepository();
                 UserTalkService.printAllProjects(repository.findAll());
                 //id project!!!!!! getanwer
                 // if id=-1 Optional sout err
                // else po id poluchaem Project!!!!!

                // TaskRepository repository=servicesGeneration.getTASKRepository(project!!!!!!);
                //    UserTalkService.printAllProjects(repository.findAll());
                //id task!!!!!! getanwer   - peremennaya     answer!!!!!
                // if id=-1 Optional sout err
                // else po id poluchaem Task!!!!!

                //userTalkService zaprashivaem koment

                //ResponseDTO response= CommentService.addComment(answer!!!!!)
                //sout response



                //UserTaskService.
                break;
        }
    }
}
