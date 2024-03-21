package org.taskmanagement401.repository;

import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.entity.Task;

import java.util.*;

public class TaskRepository {

   private final HashMap<Integer,Task> tasks;
    private Integer id = 0;


    public TaskRepository() {
        this.tasks = new HashMap<>();
    }

    private Task createNewTask(TaskDto dto){
        return new Task(++id, dto.getTaskName(), dto.getEndDate(), dto.getPriority().getStatusPriority());
    }
    public boolean addTask(TaskDto newTask) {
        Task task = createNewTask(newTask);
        tasks.put(task.getTaskID(), task);
        return true;
    }


    public Optional<Task> findById(Integer taskId) {
        Task task = tasks.get(taskId);
        return Optional.ofNullable(task);
    }


    public Optional<Task> findByName(String taskName) {
        for (Task task : tasks.values()) {
            if (task.getTaskName().equals(taskName)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }


    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }


    public void delete(String taskId) {
        tasks.remove(taskId);
    }
}
