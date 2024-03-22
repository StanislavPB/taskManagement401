package org.taskmanagement401.service;

import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ChatRepository;
import org.taskmanagement401.service.validation.ChatValidation;
import org.taskmanagement401.service.validation.CommentValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChartService {

    private int id=0;
    public List<Message> get_SMS_WithContact(User contact, User user){
            List<Message> resultSMS=new ArrayList<>();
            List<Message> userSMS=user.getSms();
            userSMS.addAll(contact.getSms());
            Collections.sort(userSMS, Comparator.comparing(Message::getSendTime));
            for(Message sms: user.getSms()){
                if(sms.getSender()== contact.getId() || sms.getReceiver()== contact.getId()){
                    resultSMS.add(sms);
                }
            }
            return resultSMS;
    }
    public ResponseDTO addNewSMS(ChatDTO commentDto, User sender, int receiver, ChatRepository chatRepository) {
        ChatValidation validation = new ChatValidation();
        List<ErrorDto> errors =
                validation.checkSMS(commentDto);

        if (errors.isEmpty()) {
            chatRepository.addSMS(commentDto.getSms(),sender, receiver);
            return new ResponseDTO<>(200, "Status ok");
        } else {
            return new ResponseDTO<>(400, errors);
        }
    }
}
