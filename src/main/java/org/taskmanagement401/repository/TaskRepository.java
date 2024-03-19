package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskRepositoryInterface {

   private List<Task> tasks;
    private String id;
    private int counter = 0;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public Task add(Task newTask) {
        id = "ts-" + counter++;
        newTask.setTaskID(id);
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public Optional<Task> findById(String taskId) {
        for (Task task : tasks) {
            if (task.getTaskID().equals(taskId)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Task> findByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public void delete(String taskId) {
        tasks.removeIf(task -> task.getTaskID().equals(taskId));
    }
}
