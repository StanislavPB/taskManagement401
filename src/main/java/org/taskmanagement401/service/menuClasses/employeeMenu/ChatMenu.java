package org.taskmanagement401.service.menuClasses.employeeMenu;

import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ChatRepository;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.ChartService;
import org.taskmanagement401.service.CommentService;
import org.taskmanagement401.service.util.PrintChatContacts;
import org.taskmanagement401.service.util.PrintUsers;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatMenu {

    public ChatMenu(User user, UserRepository userRepository, ChatRepository chatRepository) {
        System.out.println("Select chat contact: ");
        Optional<User> userOptional = PrintChatContacts.print(userRepository,user.getId());
        if (userOptional.isEmpty()) {
            System.out.println("Invalid user selection");
        }else {
            ChartService chat=new ChartService();
            List<Message> messege=chat.get_SMS_WithContact(userOptional.get(),user);
             PrintChatContacts.printChat(messege,user.getId());
            ChatDTO commentDto = new ChatDTO(UserInput.inputText("Enter new comment"));
            ResponseDTO response=chat.addNewSMS(commentDto,user,userOptional.get().getId(),chatRepository);
            System.out.println(response);

        }
    }
}
