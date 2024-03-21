package org.taskmanagement401.service.validation;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.error.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class ChatValidation {
    public List<ErrorDto> checkProject(ChatDTO sms){
        List<ErrorDto> errors=new ArrayList<>();
        if(sms.getSms().length()<5){
            errors.add(new ErrorDto(ErrorCodes.WRONGDESCRIPTIONLENGTH.getStatusCode(),
                    ErrorCodes.WRONGDESCRIPTIONLENGTH.getDescription()));
        }
        if(sms.getSms().isBlank()) {
            errors.add(new ErrorDto(ErrorCodes.WRONGDESCRIPTIONLENGTH.getStatusCode(),
                    ErrorCodes.WRONGDESCRIPTIONLENGTH.getDescription()));
        }
        return errors;
    }
}
