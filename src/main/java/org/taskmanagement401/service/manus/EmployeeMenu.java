package org.taskmanagement401.service.manus;

import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.menuClasses.employeeMenu.CommentMenu;
import org.taskmanagement401.service.menuClasses.employeeMenu.GetTasksMenu;
import org.taskmanagement401.service.menuClasses.employeeMenu.TaskStatusMenu;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;

public class EmployeeMenu {
    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    private ArrayList<String> employeeMenu= items.getMenu("Employee");
    ServicesGeneration servicesGeneration;
    public EmployeeMenu(User user, ServicesGeneration servicesGeneration) {
        this.servicesGeneration=servicesGeneration;
        int userAnswer=0;
        while (userAnswer!=employeeMenu.size()){
            menu.printMenu(employeeMenu);
            userAnswer=menu.getUserChoice(employeeMenu.size());
            manageMain(userAnswer,user);
        }
    }
    private void manageMain(int answer, User user){


        switch (answer){
            case -1:
                menu.printError();
                break;
            case 1:
                GetTasksMenu getTasksMenu=new GetTasksMenu(
                        user,servicesGeneration.getProjectRepository(),
                        servicesGeneration.getTaskRepository());

                break;
            case 2:
                //CommentMenu commentMenu=new CommentMenu(user,)
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

                //usertaskservice zaprashivaem koment

                //ResponseDTO response= CommentService.addComment(answer!!!!!)
                //sout response



                //UserTaskService.
                break;
            case 3:
                TaskStatusMenu taskStatusMenu= new TaskStatusMenu(user,
                        servicesGeneration.getProjectRepository(),
                        servicesGeneration.getTaskRepository());
                break;
        }
    }
}
