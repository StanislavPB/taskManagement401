package org.taskmanagement401.service;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.dataService.save.SaveProject;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.ProjectValidation;

import java.util.List;

public class ProjectAddService {
    ProjectValidation validation=new ProjectValidation();
    ProjectRepository projectRepository;

    public ProjectAddService(ProjectRepository projectRepository) {

        this.projectRepository = projectRepository;
    }
    public ResponseDTO registration(ProjectDto dto){

         List<ErrorDto> errors=
                validation.
                        checkProject(dto);
        if(errors.isEmpty()){
            SaveProject saveProject=new SaveProject();
            saveProject.save(projectRepository.addProject(dto));
                return new ResponseDTO<>(200,"status ok");
            }else {
            return new ResponseDTO<>(400, errors);
        }
    }
}
