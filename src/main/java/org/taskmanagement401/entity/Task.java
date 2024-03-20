package org.taskmanagement401.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private Integer taskID;
    private String taskName;
    private LocalDate endDate;
    private List<User> assignedUsers;
    private Priority priority;
    private boolean taskCompleted;
    private List<Comment> comments;

    public Task(Integer taskID, String taskName, LocalDate endDate, int statusPriority) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = fromStatusPriority(statusPriority);
        this.endDate = endDate;
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

   public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    public static Priority fromStatusPriority(int statusPriority) {
        if (statusPriority == 1) {
            return Priority.HIGH;
        } else if (statusPriority == 2) {
            return Priority.MEDIUM;
        } else if (statusPriority == 3) {
            return Priority.LOW;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID='" + taskID + '\'' +
                ", taskName='" + taskName + '\'' +
                ", endDate=" + endDate +
                ", assignedUsers=" + assignedUsers +
                ", priority=" + priority +
                ", taskCompleted=" + taskCompleted +
                ", comments=" + comments +
                '}';
    }
}
