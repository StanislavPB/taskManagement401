package org.taskmanagement401.service;

import org.taskmanagement401.repository.UserRepository;

public class ServicesGeneration {
    private final UserRepository userRepository=new UserRepository();


    public UserRepository getUserRepository() {
        return userRepository;
    }
}
