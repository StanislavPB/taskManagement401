package org.taskmanagement401;

import org.taskmanagement401.config.TestPreloader;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.manus.MainMenu;

public class TaskManagement401Application {

    public static void main(String[] args) {
        ServicesGeneration mainServices=new ServicesGeneration();
        TestPreloader preloader=new TestPreloader(mainServices);
        MainMenu app=new MainMenu(mainServices);
                  }

}
