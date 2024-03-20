package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepositoryInterface {

    public void addProject (Project newProject);

    public Optional<Project> findById(int id);

    public Optional<Project> findByName(String name);

    public List<Project> findAll();

    public void deleteById (int id);


}
