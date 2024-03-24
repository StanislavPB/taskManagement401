package org.taskmanagement401.service;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.service.dataService.save.SaveProject;

public class AddUserToProjectService {
    public static ResponseDTO assignUser (Project project, User user){
        project.getUsers().add(user);
        SaveProject saveProject=new SaveProject();
        saveProject.saveAddUser(project,user);
        return new ResponseDTO<>(200, "Status ok");
    }
}
