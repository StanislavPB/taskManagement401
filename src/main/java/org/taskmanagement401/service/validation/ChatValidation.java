package org.taskmanagement401.service.validation;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class ChatValidation {
    public List<ErrorDto> checkComment(CommentDto commentDto){
        List<ErrorDto> errors=new ArrayList<>();
        if(commentDto.getComment().length()<5){
            errors.add(new ErrorDto(ErrorCodes.SHORTMESSAGE.getStatusCode(),
                    ErrorCodes.SHORTMESSAGE.getDescription()));
        }
        if(commentDto.getComment().isBlank()) {
            errors.add(new ErrorDto(ErrorCodes. BLANKDATA.getStatusCode(),
                    ErrorCodes. BLANKDATA.getDescription()));
        }
        return errors;
    }
}
