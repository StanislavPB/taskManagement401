package org.taskmanagement401.service.util;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.Project;

import java.util.List;

public class UserTalkService {
    public static UserDto getUserParameters(boolean getWithUserName){
        String name="";
        if(getWithUserName){
            name=UserInput.inputText("Enter name of user");
        }
        String lastname=UserInput.inputText("Enter login");
        String position=UserInput.inputText("Enter password");
        return new UserDto(name,lastname,position);
    }
    public static void registrationInstructions(){
        System.out.println("The name must have from 3 to 20 letters.");
        System.out.println("The login and the password must have from 6 to 20 letters.");
        System.out.println("The password must contains letters and numbers." );
        System.out.println();
    }
    public static void projectInformation(){
        System.out.println("The name must have from 3 to 20 letters.");
        System.out.println("Description length must be longer then 10 letters.");
        System.out.println();
    }
    public static ProjectDto getProjectParameters(){
        String name="";
        name=UserInput.inputText("Enter name of project");
        String description=UserInput.inputText("Enter description");
        return new ProjectDto(name,description);
    }
    public static void printAllProjects(List<Project> projects){
        for(Project project:projects){
            if(!project.isStatus()){
                System.out.println(project.getId()+" "+project.getName());
            }
        }
     // public int getAnswer ukazali id projecra
     //
    }
}
