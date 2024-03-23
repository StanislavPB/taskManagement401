package org.taskmanagement401.service;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

public class AddUserToProjectService {
    public static ResponseDTO assignUser (Project project, User user){
        project.getUsers().add(user);
        return new ResponseDTO<>(200, "Status ok");
    }
}
