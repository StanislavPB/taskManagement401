package org.taskmanagement401.config;

import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.service.ServicesGeneration;

public class TestPreloader {
    public TestPreloader(ServicesGeneration mainServices) {
        UserDto dto=new UserDto("Saize A","Saize","password1");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Filipchenko Y","Filipchenko","password2");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Openkin M","Openkin","password3");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Chapligin V","Chapligin","password4");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Burlakova N","Burlakova","password5");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Romaniuk M","Romaniuk","password6");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Khvostykova O","Khvostykova","password7");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Kolesnichenko T","Kolesnichenko","password8");
        mainServices.getUserRepository().addNewUser(dto);
        dto=new UserDto("Ivanov I(Boss)","leader","password9");
        mainServices.getUserRepository().addNewUser(dto);
    }
}
