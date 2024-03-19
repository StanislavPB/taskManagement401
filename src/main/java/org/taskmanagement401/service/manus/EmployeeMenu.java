package org.taskmanagement401.service.manus;

import org.taskmanagement401.config.MenusItems;

import java.util.ArrayList;

public class EmployeeMenu {
    Menu menu=new Menu();
    MenusItems items=new MenusItems();
    ArrayList<String> employeeMenu= items.getMenu("Employee");
    public EmployeeMenu() {
        int userAnswer=0;
        while (userAnswer!=employeeMenu.size()){
            menu.printMenu(employeeMenu);
            userAnswer=menu.getUserChoice(employeeMenu.size());
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

                break;
        }
    }
}
