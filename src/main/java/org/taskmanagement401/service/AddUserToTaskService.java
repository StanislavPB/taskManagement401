package org.taskmanagement401.service;


import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

public class AddUserToTaskService {

    public static void assignUser (Task task, User user){
        task.getAssignedUsers().add(user);
    }


}
