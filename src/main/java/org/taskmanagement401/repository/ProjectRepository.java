package org.taskmanagement401.repository;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectRepository
        //implements ProjectRepositoryInterface
{

    private final HashMap<Integer,Project> projects;
    private int currentId = 0;

    public ProjectRepository() {
        this.projects = new HashMap<>();
    }

    //@Override
    public boolean addProject(ProjectDto dto) {
        Project project=createNewProject(dto);
        projects.put(project.getId(),project);
        return true;
    }
    private Project createNewProject(ProjectDto dto){
            return new Project(++currentId, dto.getName(), dto.getDescription());
        }


    public boolean updateProjectDescription(int projectId, String newDescription) {
        for (Project project : projects.values()) {
            if (project.getId() == projectId) {
                project.setDiscription(newDescription);
                return true;
            }
        }
        return false;
    }



   // @Override
    public Optional<Project> findById(int id) {
        Project project=projects.get(id);
        if (project != null) {
                return Optional.of(project);
            }
        return Optional.empty();
    }

    //@Override
/*    public Optional<Project> findByName(String name) {
        for (Project project : projects) {
            if (project.getName().equalsIgnoreCase(name)) {
                return Optional.of(project);
            }
        }
        return Optional.empty();
    }*/

    //@Override
    public List<Project> findAll() {
        return new ArrayList<>(projects.values());
    }

    public List<Project> findAllActiveProjects() {
        return projects.values().stream()
                .filter(project -> !project.isStatus())
                .collect(Collectors.toList());
    }

    //@Override
    /*public void deleteById(int id) {
        projects.removeIf(project -> project.getId() == id);
    }*/

}
