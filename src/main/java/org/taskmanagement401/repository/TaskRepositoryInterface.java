package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryInterface {
    public Task add(Task newTask);

    public Optional<Task> findById(Integer id);

    public Optional<Task> findByName(String taskName);

    public List<Task> findAll();

    public void delete (String taskId);
}
