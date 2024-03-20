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
     //private List<Comment> comments;

    public Task( String taskName, LocalDate endDate, Priority priority) {
        this.taskName = taskName;
        this.endDate = endDate;
        this.assignedUsers = new ArrayList<>();
        this.priority = priority;
        this.taskCompleted = false;
        this.comments = new ArrayList<>();
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


   

    //public List<Comment> getComments() {
      //  return comments;
    //}

   public void setTaskID(Integer taskID) {
        this.taskID = taskID;
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
      //          ", comments=" + comments +
                '}';
    }
}
