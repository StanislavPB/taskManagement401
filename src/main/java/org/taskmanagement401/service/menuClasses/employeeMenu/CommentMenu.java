package org.taskmanagement401.service.menuClasses.employeeMenu;

import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.CommentRepository;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.CommentService;
import org.taskmanagement401.service.util.PrintActiveProjects;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentMenu {
    public CommentMenu(User user, ProjectRepository projectRepository,
                       TaskRepository taskRepository,
                       CommentRepository commentRepository, UserRepository userRepository) {
        /* System.out.println("Select project to comment");
        List<Project> projectList = projectRepository.findAll();
        UserTalkService.printAllProjects(projectList);
       int i = UserInput.inputPositiveInt(" Choose project by id");*/

     Optional<Project> projectOptional= PrintActiveProjects.print(projectRepository);
        if (projectOptional.isEmpty()){
            System.out.println("Wrong input data");

        }else {
              CommentDto commentDto = new CommentDto(UserInput.inputText("Enter new comment"));
             CommentService commentService =new CommentService(commentRepository);
            ResponseDTO responseDTO =commentService.addNewComment(user,commentDto,projectOptional.get());
          }
        }

    }

