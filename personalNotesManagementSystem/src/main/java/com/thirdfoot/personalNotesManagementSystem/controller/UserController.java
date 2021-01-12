package com.thirdfoot.personalNotesManagementSystem.controller;


import com.thirdfoot.personalNotesManagementSystem.service.UserService;
import com.thirdfoot.personalNotesManagementSystemModels.Model.User;
import com.thirdfoot.personalNotesManagementSystemModels.ModelDto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/health")
    public String health(){
        return  "up";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void register(@RequestBody User user){
        userService.initiate(user);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        String username = userService.login(userDto);
        return new ResponseEntity<>(username,HttpStatus.OK);
    }
}
