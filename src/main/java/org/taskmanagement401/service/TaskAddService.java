package org.taskmanagement401.service;


import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.dataService.save.SaveTask;
import org.taskmanagement401.service.validation.TaskValidation;

import java.util.List;

public class TaskAddService {
    private TaskRepository taskRepository;
    private TaskValidation taskValidation = new TaskValidation();


    public TaskAddService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    public ResponseDTO registration(TaskDto dto, Project project) {
        List<ErrorDto> errors = taskValidation.checkTask(dto);
        if (errors.isEmpty()) {
            Task task = taskRepository.addTask(dto);
            project.getTasks().add(task);
            task.setProject(project);
            SaveTask saveTask=new SaveTask();
            saveTask.save(task);
            saveTask.saveList(task,project);
            return new ResponseDTO(200, task);
        } else {
            return new ResponseDTO<>(400, errors);
        }



    }
}
