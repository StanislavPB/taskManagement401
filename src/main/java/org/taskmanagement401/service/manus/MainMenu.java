package org.taskmanagement401.service.manus;






import org.taskmanagement401.config.MenusItems;

import java.util.ArrayList;


public class MainMenu {


    Menu menu=new Menu();
    MenusItems items=new MenusItems();
    ArrayList<String> maneMenu= items.getMenu("Main");
    public MainMenu() {
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
