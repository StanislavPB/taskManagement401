package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {

    @Test
    void registration() {
        UserDto dto=new UserDto("j","k","");
        UserRepository repository =new UserRepository();
        RegistrationService service=new RegistrationService(repository);
        ResponseDTO responseDTO=service.registration(dto);
        assertEquals(400,responseDTO.getCode());
    }
}