package org.taskmanagement401.service;


import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;

public class AddUserToTaskService {

    public static ResponseDTO assignUser (Task task, User user){
        task.getAssignedUsers().add(user);
        user.getTask().add(task);
        return new ResponseDTO<>(200, "Status ok");
    }


}
