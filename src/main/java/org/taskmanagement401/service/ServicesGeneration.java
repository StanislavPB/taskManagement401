package org.taskmanagement401.service;

import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.UserRepository;

public class ServicesGeneration {
    private final UserRepository userRepository=new UserRepository();
    private final ProjectRepository projectRepository=new ProjectRepository();


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }
}
