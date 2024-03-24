package org.taskmanagement401.service;

import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;

import org.taskmanagement401.repository.ChatRepository;
import org.taskmanagement401.service.dataService.save.SaveSMS_Service;
import org.taskmanagement401.service.validation.ChatValidation;

import java.util.*;

public class ChatService {

    private int id=0;
    ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<Message> get_SMS_WithContact(User contact, User user){
            List<Message> resultSMS=new ArrayList<>(user.getSms().stream()
                    .filter(x->x.getReceiver()==contact.getId()).toList());
            List<Message> contactSMS=contact.getSms().stream()
                .filter(x->x.getReceiver()==user.getId()).toList();
            resultSMS.addAll(contactSMS);
            resultSMS.sort(Comparator.comparing(Message::getSendTime));
            return resultSMS;
    }
    public ResponseDTO addNewSMS(ChatDTO commentDto, User sender, int receiver) {
            ChatValidation validation = new ChatValidation();
            List<ErrorDto> errors =
                    validation.checkSMS(commentDto);

            if (errors.isEmpty()) {
                Message sms =chatRepository.addSMS(commentDto.getSms(), sender, receiver);
                SaveSMS_Service save=new SaveSMS_Service();
                Optional<Exception> result=save.saveSMS(sms);
                result.ifPresent(System.out::println);
                return new ResponseDTO<>(200, "Status ok");
            } else {
                return new ResponseDTO<>(400, errors);
            }
    }
}
