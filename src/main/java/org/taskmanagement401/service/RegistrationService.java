package org.taskmanagement401.service;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.UserValidation;

import java.util.List;

public class RegistrationService {
    private User user;
    private UserValidation validation=new UserValidation();
    private UserRepository repository;

    public RegistrationService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseDTO registration(){
        UserDto dto=UserTalkService.getUserParameters();
        List<ErrorDto> errors=validation.checkUser(dto);
        if(errors.isEmpty()){
            int id=repository.addNewUser(dto);
            if(id==-1){
                errors.add(new ErrorDto(ErrorCodes.WRONGNEWLOGIN.getStatusCode(),
                        ErrorCodes.WRONGNEWLOGIN.getDescription()));
                return new ResponseDTO<>(400,errors);
            }else{
                return new ResponseDTO<>(200,id);
            }

        }else{
            return new ResponseDTO<>(400,errors);
        }
    }
}
