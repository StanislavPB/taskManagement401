package org.taskmanagement401.repository;

import org.taskmanagement401.dto.TaskDto;
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

    private Task createNewTask(TaskDto dto){
        return new Task(++id, dto.getTaskName(), dto.getEndDate(), dto.getPriority().getStatusPriority());
    }
    @Override
    public Task addTask(TaskDto newTask) {
        Task task = createNewTask(newTask);
        tasks.add(task);
        return task;
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
    public Optional<Task> getTaskById(int id){
        Task task = tasks.get(id);
        if(task != null){
            return Optional.of(task);
        }else{
            return Optional.empty();
        }
    }

    public void setId(Integer id) {
        this.id = id;
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
