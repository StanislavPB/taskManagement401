package service;

import entity.Task;
import repository.TaskRepository;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    private Task createTask(){

        return null;
    }
    public void addNewTask(){
        Task newTask = createTask();
        repository.add(newTask);
    }
}
