package org.taskmanagement401.dto;

public class ProjectDto {

    private int id;
    private String name;
    private String discription;
    private boolean status;


    public ProjectDto (int id, String name, String discription, boolean status) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.status = status;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return discription;
    }


    public boolean isStatus() {
        return status;
    }


}
