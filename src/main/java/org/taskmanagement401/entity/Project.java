package org.taskmanagement401.entity;

import java.util.List;
import java.util.Objects;

public class Project {

    private String id;
    private String name;
    private String discription;
    //private List<User> users;
    //private List<Task> tasks;
    private boolean status;

    /*на коллекции не добавляла пока Getter&Setter, а сами поля закомментировала, потому что ошибку выдает -
    нет переменной, на которую можно сослаться

     */


    public Project(String id, String name, String discription) {
        this.id = id;
        this.name = name;
        this.discription = discription;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return status == project.status && Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(discription, project.discription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, discription, status);
    }
}

