package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class PrintUsers {
    public static Optional<User> print(UserRepository userRepository){
        List <User> users = userRepository.getUsers();
        UserTalkService.printAllUsers(userRepository.getUsers());

        int userChoice = UserInput.inputPositiveInt("Choose a user by ID: ");


        return  users.stream()
                .filter(user -> user.getId() == userChoice)
                .findFirst();
    }


//    public static Optional<Task> print(TaskRepository taskRepository, Optional <Project> selectedProject){
//        List<Task> tasks = taskRepository.findAll();
//        UserTalkService.printSelectedProjectTask(tasks, selectedProject);
//
//        int taskChoice = UserInput.inputPositiveInt("Choose a task by ID to edit: ");
//
//
//        return  tasks.stream()
//                .filter(task -> task.getTaskID() == taskChoice)
//                .findFirst();
//    }

}
