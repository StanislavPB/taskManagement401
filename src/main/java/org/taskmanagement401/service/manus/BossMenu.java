package org.taskmanagement401.service.manus;

import org.taskmanagement401.config.MenusItems;

import java.util.ArrayList;

public class BossMenu {
    Menu menu=new Menu();
    MenusItems items=new MenusItems();
    ArrayList<String> bossMenu= items.getMenu("Chef");
    public BossMenu() {
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

                break;
            case 2:

                break;
        }
    }
}
