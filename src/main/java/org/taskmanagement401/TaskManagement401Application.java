package org.taskmanagement401;

import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.manus.MainMenu;

public class TaskManagement401Application {

    public static void main(String[] args) {
        ServicesGeneration mainServices=new ServicesGeneration();
        MainMenu app=new MainMenu(mainServices);
    }

}
