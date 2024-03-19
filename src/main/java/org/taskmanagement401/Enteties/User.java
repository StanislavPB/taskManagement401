package org.taskmanagement401.Enteties;

public class User {
    int id;
    String name;
    String login;
    String password;
    int status;

    public User(int id, String name, String login, String password, int status) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = status;
    }

}
