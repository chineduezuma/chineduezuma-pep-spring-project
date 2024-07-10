package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@Controller
@RequestMapping()
public class SocialMediaController {

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
