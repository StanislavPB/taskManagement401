package org.taskmanagement401.service.menuClasses.bossMenu;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.ProjectAddService;
import org.taskmanagement401.service.util.UserTalkService;

public class AddProjectMenu {


    public AddProjectMenu(ProjectRepository projectRepository) {
        UserTalkService.projectInformation();
        ProjectAddService addService=new ProjectAddService(projectRepository);
        ProjectDto dto= UserTalkService.getProjectParameters();
        ResponseDTO dtoResponse=
                addService.registration(dto);
        // System.out.println(dtoResponse);*/
        //ProjectDto dto= UserTalkService.getProjectParameters();
    }
}
