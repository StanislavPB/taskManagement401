package org.taskmanagement401.service;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.UserValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorizationService {
    private UserValidation validation=new UserValidation();
    private UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }
    public ResponseDTO verification(){
        UserDto dto= UserTalkService.getUserParameters(false);
        Optional<User>user =repository.getUserIdByLoginAndPassword(dto);
        if(user.isEmpty()){
            List<ErrorDto> errors =new ArrayList<>();
            errors.add(new ErrorDto(ErrorCodes.WRONGLOGINDATA.getStatusCode(),
                    ErrorCodes.WRONGLOGINDATA.getDescription()));
            return new ResponseDTO<>(400,errors);
        }else{
            return new ResponseDTO<>(200,user.get());
        }

    }

}
