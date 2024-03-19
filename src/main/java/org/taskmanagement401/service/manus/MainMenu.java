package org.taskmanagement401.service.manus;






import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.service.RegistrationService;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;
import java.util.function.Predicate;


public class MainMenu {


    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    private ArrayList<String> maneMenu= items.getMenu("Main");
    private RegistrationService registrationService;
    public MainMenu(ServicesGeneration services) {
        registrationService=new RegistrationService(services.getUserRepository());
        int userAnswer=0;
        while (userAnswer!=maneMenu.size()){
            menu.printMenu(maneMenu);
            userAnswer=menu.getUserChoice(maneMenu.size());
            manageMain(userAnswer);
        }
    }
    private void manageMain(int answer){
        switch (answer){
            case -1:
                menu.printError();
                break;
            case 1:
                UserTalkService.registrationInstructions();
                System.out.println(registrationService.registration());
                EmployeeMenu employeeMenu=new EmployeeMenu();

                break;
            case 2:
                int status=1;
                if(status==1){
                    BossMenu bossMenu=new BossMenu();
                }else {
                    employeeMenu = new EmployeeMenu();
                }
                break;
        }
    }

}
