package org.taskmanagement401.dto;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Priority;
import org.taskmanagement401.entity.Prority;
import org.taskmanagement401.entity.User;

import java.time.LocalDate;
import java.util.List;

public class TaskDto {
    private Integer taskID;
    private String taskName;
    private LocalDate endDate;
    private List<User> assignedUsers;
    private Priority priority;
    private boolean taskCompleted;
    private List<Comment> comments;


    public TaskDto(List<User> assignedUsers, List<Comment> comments) {
        this.assignedUsers = assignedUsers;
        this.comments = comments;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
