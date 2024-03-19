package org.taskmanagement401.service;

import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.validation.TaskValidation;

public class TaskService {
    private final TaskRepository repository;
    private final TaskValidation taskValidation;

    public TaskService(TaskRepository repository, TaskValidation taskValidation) {
        this.repository = repository;
        this.taskValidation = taskValidation;
    }

    private Task createTask(TaskDto task){
        taskValidation.checkTask(task);

//        Task newTask = new Task();
        return null;
    }
    public void addNewTask(){
//        Task newTask = createTask();
//        repository.add(newTask);
    }
}
