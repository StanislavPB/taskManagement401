package org.taskmanagement401.entity;

import java.util.HashMap;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private int status;
    private HashMap<Integer,Task> tasks=new HashMap<>();

    public User(int id, String name, String login, String password, int status) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }
}
