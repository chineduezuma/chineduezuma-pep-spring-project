package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
// @Transactional
public class MessageService {

    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }



    /**
     * This method will persist a message to the Message database table, the equivalent of a
     * "insert into message" statement.
     * @return
     */
    public Message addNewMessage(Message newMessage){
        
        if(newMessage.getMessageText() != "" && newMessage.getMessageText().length() <= 255 && messageRepository.findAccountByAccountId(newMessage.getPostedBy()) == null){
             return messageRepository.save(newMessage);
        }
        return null;
    }



    /**
     * This method will retrieve all Message entities from the Message database table, the equivalent
     * of a "select * from message" statement.
     * @return
     */
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }



    /**
     * This method will retrieve a Message entities from the Message database table based on messageId, the equivalent
     * of a "select * from message where messageId = messageId" statement.
     * @return
     */
    public Message getMessageByMessageId(Integer messageId){
        Optional<Message> message = messageRepository.findById(messageId);
        if(message.isPresent()){
        return message.get();
        }
        return null;
    }   



    /**
     * This method will delete a Message entities from the Message database table based on messageId, the equivalent of a
     * "delete from message where messageId = messageId" statement.
     * @return
     */
    public void removeMessageByMessageId(Integer messageId){
        Optional<Message> message = messageRepository.findById(messageId);
        if(message.isPresent()){
            Message deletMessage = message.get();
            messageRepository.delete(deletMessage);
            // messageRepository.delete(messageRepository.findMessageByMessageId(messageId));
        }
    }



    /**
     * This method will update a Message entities from the Message database table based on messageId, the equivalent of a
     * "update message set messageText = messageText  where messageId = messageId" statement.
     * @return
     */
    public void updateMessageByMessageId(Integer messageId, Message newMessage){
        Message message = messageRepository.findMessageByMessageId(messageId);
        if(newMessage.getMessageText() != "" && newMessage.getMessageText().length() <= 255 && messageRepository.findMessageByMessageId(messageId) != null){
            message.setMessageText(newMessage.getMessageText());
            messageRepository.save(message);
       }
    }



     /**
     * This method will retrieve all Message entities from the Message database table based on accountId, the equivalent
     * of a "select * from message where postBy = accountId" statement.
     * @return
     */
    public List<Message> getAllMessagesByAccountId(Integer accountId){
        return messageRepository.findAllMessagesByPostedBy(accountId);
    }

   

}
