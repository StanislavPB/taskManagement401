package org.taskmanagement401.repository;

import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.entity.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TaskRepository {

   private final List<Task> tasks;
    private Integer id = 0;


    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    private Task createNewTask(TaskDto dto){
        return new Task(++id, dto.getTaskName(), dto.getEndDate(), dto.getPriority().getStatusPriority());
    }
    public Task addTask(TaskDto newTask) {
        Task task = createNewTask(newTask);
        tasks.add(task);
        return task;
    }


    public Optional<Task> findById(Integer taskId) {
        for (Task task : tasks) {
            if (task.getTaskID().equals(taskId)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }


    public Optional<Task> findByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }


    public List<Task> findAll() {
        return tasks;
    }


    public void delete(String taskId) {
        for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
            Task task = iterator.next();
            if (task.getTaskID().equals(taskId)) {
                iterator.remove();
            }
        }
    }
}
