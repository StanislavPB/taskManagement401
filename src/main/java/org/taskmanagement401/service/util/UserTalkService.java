package org.taskmanagement401.service.util;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

import java.util.List;
import java.util.Optional;

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

    public static void printSelectedProjectTask(List<Task> tasks, Project selectedProject) {
        for (Task task : tasks) {
            if (!task.isTaskCompleted()) {
                System.out.println(task.getTaskID() + " " + task.getTaskName());
               } 
        }

 }
    public static void printAllTasks(List<Task> tasks){
        Collections.sort(tasks, Comparator.comparing(Task::getPriority).reversed());
        for(Task task : tasks){
            if(!task.isTaskCompleted()){
                System.out.println("Id - "+task.getTaskID()+":  "+task.getPriority()+"/"+ task.getTaskName() + "/" + task.getEndDate());

            }
        }
 }
   

    public static void printAllUsers(List<User> users){
        for(User user : users){
            System.out.println(user.getId() + " " + user.getName() + " имеет список задач: " + user.getTask());
        }
    }
    public static void printAllTasksWithProjects(List<Task> tasks){
        Collections.sort(tasks, Comparator.comparing(Task::getProject).thenComparing(Task::getPriority));
        String projectName="";
        for(Task task : tasks){

            if(!projectName.equals(task.getProject().getName())){
                System.out.println("Project : "+task.getProject().getName());
                projectName=task.getProject().getName();
            }
                System.out.println("            Id - "+task.getTaskID()+":  "+task.getPriority()+"/"+ task.getTaskName() + "/" + task.getEndDate());

        }
        }

}
