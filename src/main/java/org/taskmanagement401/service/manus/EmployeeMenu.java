package org.taskmanagement401.service.manus;

import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.entity.User;

import java.util.ArrayList;

public class EmployeeMenu {
    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    private ArrayList<String> employeeMenu= items.getMenu("Employee");
    public EmployeeMenu(User user) {
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
