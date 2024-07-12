package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
// @Controller
@RestController
@ResponseBody
public class SocialMediaController {

    AccountService accountService;
    MessageService messageService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService) {
        this.accountService = accountService;
        this.messageService = messageService;
    }


    // @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account newUser) {
        
        // Logic to register a new user
        if (accountService.addNewAccount(newUser) != null){
            return ResponseEntity.status(200).body(accountService.addNewAccount(newUser));
        }else if (accountService.existingUserAccount(newUser) != null){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(400).body(null);
        
    }



    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public ResponseEntity<Account> addlogin(@RequestBody Account loginRequest) {
        
        // Logic to authenticate user login
        if (accountService.verifyAccount(loginRequest) != null){
            return ResponseEntity.status(200).body(accountService.verifyAccount(loginRequest));
        }
        return ResponseEntity.status(401).body(null);
    }



    // @RequestMapping(value = "/messages", method = RequestMethod.POST)
    @PostMapping("/messages")
    public ResponseEntity<Message> addMessage(@RequestBody Message newMessage) {
        
        // Logic to create a new message
        if (messageService.addNewMessage(newMessage) != null){
            return ResponseEntity.status(200).body(messageService.addNewMessage(newMessage));
        }
        return ResponseEntity.status(400).body(null);
    }



    // @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @GetMapping("/messages")
    public List<Message> allMessages() {
        
        // Logic to return all messages
        List<Message> messageList = messageService.getAllMessages();
        return messageList;

    }

    
    
    // @RequestMapping(value = "/messages/{message_id}", method = RequestMethod.GET)
    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> findMessageByMessageId(@PathVariable Integer message_id) {
        
        // Logic to retrieve message by messageId
       if (messageService.getMessageByMessageId(message_id) != null){
             return ResponseEntity.status(200).body(messageService.getMessageByMessageId(message_id));
       }
        return ResponseEntity.status(200).body(null);
       
    }



    // @RequestMapping(value = "/messages/{message_id}", method = RequestMethod.DELETE)
    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> removeMessageByMessageId(@PathVariable Integer message_id) {
        
        // Logic to delete message by messageId
        if (messageService.getMessageByMessageId(message_id) != null){
            messageService.removeMessageByMessageId(message_id);
            return ResponseEntity.status(200).body(1);
        }
        return ResponseEntity.status(200).body(null);
    }



    // @RequestMapping(value = "/messages/{message_id}", method = RequestMethod.PATCH)
    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Integer> updatehMessageByMessageId(@PathVariable Integer message_id, @RequestBody Message newMessage) {
        
        // Logic to update message by messageId
        messageService.updateMessageByMessageId(message_id, newMessage);
        Message message = messageService.getMessageByMessageId(message_id);
        if (newMessage.getMessageText().equals(message.getMessageText())){
            return ResponseEntity.status(200).body(1); 
        }
        return ResponseEntity.status(400).body(0);
    }

    // @RequestMapping(value = "/messages/{message_id}", method = RequestMethod.PATCH)
  //  @PatchMapping("/messages/{message_id}")
  //  public @ResponseBody Integer updatehMessageByMessageId(@PathVariable Integer messageId, @RequestParam String newMessage) {
        // Logic to retrieve user profile
  //  }



    // @RequestMapping(value = "/accounts/{account_id}/messages", method = RequestMethod.GET)
    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getAllMessagesByAccountId(@PathVariable Integer account_id) {
        
        // Logic to return messages by accountId
        List<Message> messageList = messageService.getAllMessagesByAccountId(account_id);
        return messageList;
    }

    
    

}
