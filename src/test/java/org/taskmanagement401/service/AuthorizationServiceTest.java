package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationServiceTest {

    @Test
    void verification() {
        UserDto dto=new UserDto("j","k","");
        UserRepository repository =new UserRepository();
        AuthorizationService service=new AuthorizationService(repository);
        ResponseDTO responseDTO=service.verification(dto);
        assertEquals(400,responseDTO.getCode());
    }
}