package org.taskmanagement401.servises.manus;






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
                BossMenu bossMenu=new BossMenu();
                break;
            case 2:
                EmployeeMenu employeeMenu=new EmployeeMenu();
                break;
        }
    }

}
