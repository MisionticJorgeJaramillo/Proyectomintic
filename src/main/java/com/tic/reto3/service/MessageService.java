package com.tic.reto3.service;


import com.tic.reto3.entities.Client;
import com.tic.reto3.entities.Message;
import com.tic.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Message save(Message p){
        if (p.getIdMessage()==null){
            return messageRepository.save(p);
        }else {
            Optional<Message> e = messageRepository.getMessage(p.getIdMessage());
            if (e.isPresent()){
                return p;
            }else {
                return messageRepository.save(p);
            }
        }
    }

    public boolean delete(int id) {
        boolean flag=false;
        Optional<Message>p= messageRepository.getMessage(id);
        if (p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

