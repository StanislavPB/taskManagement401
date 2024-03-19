package repository;

import entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryInterface {
    public Task add(Task newTask);

    public Optional<Task> findById(String id);

    public Optional<Task> findByName(String taskName);

    public List<Task> findAll();

    public void delete (String taskId);
}
