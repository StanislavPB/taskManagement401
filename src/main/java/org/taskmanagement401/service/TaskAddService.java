package org.taskmanagement401.service;


import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.validation.TaskValidation;

import java.util.List;

public class TaskAddService {
    private final TaskRepository taskRepository;
    private TaskValidation taskValidation;


    public TaskAddService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    public ResponseDTO registration(TaskDto dto) {
        List<ErrorDto> errors = taskValidation.checkTask(dto);
        if (errors.isEmpty()) {
            if (taskRepository.addTask(dto)) {
                return new ResponseDTO<>(200, "Task added!");
            } else {
                errors.add(new ErrorDto(ErrorCodes.ADDEDFAIL.getStatusCode(),
                        ErrorCodes.ADDEDFAIL.getDescription()));
                return new ResponseDTO<>(400, errors);
            }
        } else {
            return new ResponseDTO<>(400, errors);
        }


    }

}
