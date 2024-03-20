package org.taskmanagement401.repository;

import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users=new ArrayList<>();
    private int currentId=0;
    public Optional<User> getUserIdByLoginAndPassword(UserDto dto){
        Optional<User> user=findUserByLogin(dto.getLogin());
        if (user.isEmpty()){
            return user;
        } else {
            if (user.get().getPassword().equals(dto.getPassword())) {
                    return user;
                }
                return Optional.empty();
        }
    }

    public Optional<User> addNewUser(UserDto dto){
            Optional<User>user=createNewUser(dto);
            if(user.isEmpty()){
                return Optional.empty();
            }else{
                users.add(user.get());
                return user;
            }
    }
    private Optional<User> createNewUser(UserDto dto){
        if (findUserByLogin(dto.getLogin()).isEmpty()){
            currentId++;
            User user=new User(currentId,dto.getName(),dto.getLogin(),dto.getPassword(),2);
            return Optional.of(user);
        }
        return Optional.empty();
    }
    private Optional<User> findUserByLogin(String login) {
           for (User user : users) {
                if (user.getLogin().equals(login)) {
                    return Optional.of(user);
                }
            }
            return Optional.empty();

    }
}
