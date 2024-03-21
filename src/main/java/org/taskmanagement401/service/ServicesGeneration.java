package org.taskmanagement401.service;

import org.taskmanagement401.repository.CommentRepository;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;

public class  ServicesGeneration {
    private final UserRepository userRepository=new UserRepository();
    private final ProjectRepository projectRepository=new ProjectRepository();
    private final CommentRepository commentRepository=new CommentRepository();
    private final TaskRepository taskRepository = new TaskRepository();
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }


}
