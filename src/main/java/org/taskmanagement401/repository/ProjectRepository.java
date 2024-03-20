package org.taskmanagement401.repository;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepository
        //implements ProjectRepositoryInterface
{

    private final List<Project> projects;
    private int currentId = 0;

    public ProjectRepository() {
        this.projects = new ArrayList<>();
    }

    //@Override
    public boolean addProject(ProjectDto dto) {
        Project project=createNewProject(dto);
        projects.add(project);
        return true;
    }
    private Project createNewProject(ProjectDto dto){
            return new Project(currentId++, dto.getName(), dto.getDescription());
        }


    public boolean updateProjectDescription(int projectId, String newDescription) {
        for (Project project : projects) {
            if (project.getId() == projectId) {
                project.setDiscription(newDescription);
                return true;
            }
        }
        return false;
    }



   // @Override
    public Optional<Project> findById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return Optional.of(project);
            }
        }
        return Optional.empty();
    }

    //@Override
    public Optional<Project> findByName(String name) {
        for (Project project : projects) {
            if (project.getName().equalsIgnoreCase(name)) {
                return Optional.of(project);
            }
        }
        return Optional.empty();
    }

    //@Override
    public List<Project> findAll() {
        return new ArrayList<>(projects);
    }

    //@Override
    public void deleteById(int id) {
        projects.removeIf(project -> project.getId() == id);
    }

}
