package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@Controller
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


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PostMapping("/register")
    public @ResponseBody Account register(@RequestBody Account newUser) {
        // Logic to register a new user
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public @ResponseBody Account addlogin(@RequestBody Account loginRequest) {
        // Logic to authenticate user login
    }



    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    @PostMapping("/messages")
    public @ResponseBody Message addMessage(@RequestBody Message newMessage) {
        // Logic to authenticate user login
    }



    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @GetMapping("/messages")
    public @ResponseBody List<Message> findAllMessages() {
        // Logic to authenticate user login
    }

    
    
    @RequestMapping(value = "/messages/{message_id}", method = RequestMethod.GET)
    @GetMapping("/messages/{message_id}")
    public @ResponseBody Message findMessageByMessageId(@PathVariable Integer messageId) {
        // Logic to retrieve user profile
    }



    @RequestMapping(value = "/messages/{message_id}", method = RequestMethod.DELETE)
    @DeleteMapping("/messages/{message_id}")
    public @ResponseBody Integer removeMessageByMessageId(@PathVariable Integer messageId) {
        // Logic to retrieve user profile
    }



    @RequestMapping(value = "/messages/{message_id}", method = RequestMethod.PATCH)
    @PatchMapping("/messages/{message_id}")
    public @ResponseBody Integer updatehMessageByMessageId(@PathVariable Integer messageId, @RequestBody Message newMessage) {
        // Logic to retrieve user profile
    }



    @RequestMapping(value = "/accounts/{account_id}/messages", method = RequestMethod.GET)
    @GetMapping("/accounts/{account_id}/messages")
    public @ResponseBody List<Message> getAllMessagesByAccountId(@PathVariable Integer accountId) {
        // Logic to authenticate user login
    }



    
    @PostMapping("submit")
    public ResponseEntity<String> submitInfo(@RequestParam String email,
                                          @RequestParam String major,
                                          @RequestParam int age,
                                          @RequestParam String password){

        studentList.add(new Student(email, major, age, password));
        return ResponseEntity.status(201)
                .body("Successfully Registered");

    }

    @PutMapping("update")
    public @ResponseBody String update(@RequestBody Student updatedStudent){
        if(studentList.removeIf(student -> student.getEmail().equals(updatedStudent.getEmail()))) {
            studentList.add(updatedStudent);
            return "Successfully updated";
        }
        return "Email was not registered, check email and try again. Or register new student.";
    }

    @GetMapping("info/{email}")
    public @ResponseBody Student displayInfo(@PathVariable String email){

        for (Student student:studentList){
            if(student.getEmail().equals(email))
                return student;
        }
        return null;

    }

    @PostMapping("/register")
    public @ResponseBody String submit(@RequestParam String email,
                                          @RequestParam String major,
                                          @RequestParam int age,
                                          @RequestParam String password){

        studentList.add(new Student(email, major, age, password));
        return "Successfully submitted";

    }

}
