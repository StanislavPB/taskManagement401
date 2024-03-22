package org.taskmanagement401.service.validation;

import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//taskName; - не может быть меньше 5 символов, не может содержать только цифры, не может иметь только символы и только пробелы
//endDate; -  дата не может быть в прошлом, пыстым
//assignedUsers; - ?? это list не знаю какая тут проверка
//priority; - не может быть пустым, какая проверка на enum?
// comments; - ?? это list не знаю какая тут проверка


public class TaskValidation {
    public boolean checkTask(TaskDto dto){

        List<String> errors = new ArrayList<>(); // или расширим нащ класс enum errorCodes?

        if (dto.getTaskName().isBlank() || dto.getTaskName().length() < 5 || dto.getTaskName().matches("\\d+")
                || dto.getTaskName().matches("^[aA]+$") || dto.getTaskName().matches("^\\\\s+$")){
            errors.add("");
        }
        if (dto.getEndDate() == null || dto.getEndDate().isBefore(LocalDate.now())){
            errors.add("");
        }


            return true;
    }
}
