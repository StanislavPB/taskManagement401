package org.taskmanagement401.service;


import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.dto.error.ErrorDto;

import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.validation.TaskValidation;

import java.util.List;

public class AddUserToTaskService {
    private final TaskRepository repository;
    private final TaskValidation taskValidation;


    public AddUserToTaskService(TaskRepository repository, TaskValidation taskValidation) {
        this.repository = repository;
        this.taskValidation = taskValidation;
    }
    public void assignUser (Task task, User user){
        task.getAssignedUsers().add(user);
    }


//    public ResponseDTO checkAssignedUsers(TaskDto dto){
//
//        List<ErrorDto> errors = taskValidation.checkAssignedUsers(dto);
//        if(errors.isEmpty()){
//            if(repository.addUser(dto)){
//                return new ResponseDTO<>(200,"user was added successfully");
//            }else{
//                errors.add();
//                return new ResponseDTO<>(400,errors);
//            }
//        }else {
//            return new ResponseDTO<>(400, errors);
//        }
//    }


}
