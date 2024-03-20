package org.taskmanagement401.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MenusItems {
    private  final HashMap<String, ArrayList<String>> menus=new HashMap<>();

    public MenusItems() {
        ArrayList<String> menu=new ArrayList<>(Arrays.
                asList( "Registration",
                        "Authorization",
                        "Exit"));
        menus.put("Main",menu);


        menu=new ArrayList<>(Arrays.
        asList( "Add project",
                "Editing project",
                "Add task",
                "Add user",
                "Add user to task",
                "Check progress of projects",
                "Chat",
                "Exit"));
        menus.put("Chef",menu);

        menu=new ArrayList<>(Arrays.
        asList( "Get tasks",
                "Comment task",
                "Change task status",
                "Chat",
                "Exit"));
        menus.put("Employee",menu);


    }
    public  ArrayList<String> getMenu(String menuItem){
        return menus.get(menuItem);
    }
}
