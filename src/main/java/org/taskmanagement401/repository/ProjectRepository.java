package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepository implements ProjectRepositoryInterface {

    private final List<Project> projects;
    private int currentId = 0;

    public ProjectRepository() {
        this.projects = new ArrayList<>();
    }

    @Override
    public void addProject(Project newProject) {
        currentId++;
        projects.add(new Project(currentId, newProject.getName(), newProject.getDiscription()));
    }


    @Override
    public Optional<Project> findById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return Optional.of(project);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Project> findByName(String name) {
        for (Project project : projects) {
            if (project.getName().equalsIgnoreCase(name)) {
                return Optional.of(project);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projects);
    }

    @Override
    public void deleteById(int id) {
        projects.removeIf(project -> project.getId() == id);
    }

}