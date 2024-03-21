package org.taskmanagement401.service.validation;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//taskName; - не может быть меньше 5 символов, не может содержать только цифры, не может иметь только символы и только пробелы
//endDate; -  дата не может быть в прошлом, пyстым
//assignedUsers; - ?? это list не знаю какая тут проверка
//priority; - не может быть пустым, какая проверка на enum?
// comments; - ?? это list не знаю какая тут проверка


public class TaskValidation {
    public List<ErrorDto> checkTask(TaskDto dto){

        List<ErrorDto> errors = new ArrayList<>();

        if (dto.getTaskName().isBlank() || dto.getTaskName().length() < 5 || dto.getTaskName().matches("\\d+")
                || dto.getTaskName().matches("^[aA]+$") || dto.getTaskName().matches("^\\\\s+$")){
            errors.add(new ErrorDto(ErrorCodes.WRONGNAME.getStatusCode(), ErrorCodes.WRONGNAME.getDescription()));
        }
        if (dto.getEndDate() == null || dto.getEndDate().isBefore(LocalDate.now())){
            errors.add(new ErrorDto(ErrorCodes.WRONGDATE.getStatusCode(), ErrorCodes.WRONGDATE.getDescription()));
        }
         if(dto.getPriority() == null || dto.getPriority().getStatusPriority() != 1 && dto.getPriority().getStatusPriority() != 2 && dto.getPriority().getStatusPriority() != 3){
             errors.add(new ErrorDto(ErrorCodes.WRONGPRIORITYSTATUS.getStatusCode(), ErrorCodes.WRONGPRIORITYSTATUS.getDescription()));
         }

            return errors;
    }
}
