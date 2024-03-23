package org.taskmanagement401.config;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.ChatRepository;
import org.taskmanagement401.service.ServicesGeneration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
        mainServices.getUserRepository().addNewUser(dto,true);


        mainServices.getProjectRepository().addProject(new ProjectDto("Project1",
                "This is project 1"));
        mainServices.getProjectRepository().addProject(new ProjectDto("Project2",
                "This is project 2"));
        mainServices.getProjectRepository().addProject(new ProjectDto("Project3",
                "This is project 3"));

        mainServices.getTaskRepository().addTask(new TaskDto("Task1",LocalDate.of(2024,3,21),1));
        mainServices.getTaskRepository().addTask(new TaskDto("Task2",LocalDate.of(2024,4,21),2));
        mainServices.getTaskRepository().addTask(new TaskDto("Task3",LocalDate.of(2024,4,3),3));

        mainServices.getProjectRepository().findAllActiveProjects().get(0).getUsers().add(
                mainServices.getUserRepository().getUserById(1).get()
        );
        mainServices.getProjectRepository().findAllActiveProjects().get(1).getUsers().add(
                mainServices.getUserRepository().getUserById(2).get()
        );
        mainServices.getProjectRepository().findAllActiveProjects().get(2).getUsers().add(
                mainServices.getUserRepository().getUserById(3).get()
        );
        mainServices.getProjectRepository().findById(1).get().getTasks().add(
                mainServices.getTaskRepository().findById(1).get()
        );
        mainServices.getTaskRepository().findById(1).get().setProject(
                mainServices.getProjectRepository().findById(1).get());

        mainServices.getProjectRepository().findById(2).get().getTasks().add(
                mainServices.getTaskRepository().findById(2).get()
        );
        mainServices.getTaskRepository().findById(2).get().setProject(
                mainServices.getProjectRepository().findById(2).get());
        mainServices.getProjectRepository().findById(3).get().getTasks().add(
                mainServices.getTaskRepository().findById(3).get()
        );
        mainServices.getTaskRepository().findById(3).get().setProject(
                mainServices.getProjectRepository().findById(3).get());

        mainServices.getTaskRepository().findById(1).get().getAssignedUsers().add(
                mainServices.getUserRepository().getUserById(1).get()
        );
        mainServices.getTaskRepository().findById(2).get().getAssignedUsers().add(
                mainServices.getUserRepository().getUserById(2).get()
        );
        mainServices.getTaskRepository().findById(2).get().getAssignedUsers().add(
                mainServices.getUserRepository().getUserById(2).get()
        );
        mainServices.getUserRepository().getUserById(1).get().getTask().add(
                mainServices.getTaskRepository().findById(1).get()
        );
        mainServices.getUserRepository().getUserById(2).get().getTask().add(
                mainServices.getTaskRepository().findById(2).get()
        );
        mainServices.getUserRepository().getUserById(3).get().getTask().add(
                mainServices.getTaskRepository().findById(3).get()
        );



        mainServices.getUserRepository().getUserById(1).get().getTask().get(0).getComments().add(
                new Comment(mainServices.getUserRepository().getUserById(1).get(),
                        "Help me. I don`t understand")
        );
        Message sms=new Message(1,9,2,"Hello", LocalDateTime.now());
        mainServices.getUserRepository().getUserById(9).get().getSms().add(
                sms
        );
        ChatRepository chatRepository= mainServices.getChatRepository();
        chatRepository.getSms().add(sms);
        for(int i=1;i<100000000;i++){
            //loop for different time sms adding
        }
        sms=new Message(1,2,9,"Hello Boss", LocalDateTime.now());
        mainServices.getUserRepository().getUserById(2).get().getSms().add(
               sms
        );
        chatRepository.getSms().add(sms);
         for(int i=1;i<100000000;i++){
            //loop for different time sms adding
        }
        sms=new Message(1,9,2,"You get holiday with salary for hole year.", LocalDateTime.now());
        mainServices.getUserRepository().getUserById(9).get().getSms().add(
               sms
        );
        chatRepository.getSms().add(sms);

    }
}
