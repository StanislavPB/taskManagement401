package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskRepositoryInterface {

   private final List<Task> tasks;
    private Integer id = 0;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public Task add(Task newTask) {
        newTask.setTaskID(++id);
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public Optional<Task> findById(Integer taskId) {
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
        for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
            Task task = iterator.next();
            if (task.getTaskID().equals(taskId)) {
                iterator.remove();
            }
        }
    }
}
